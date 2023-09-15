import java.util.*;

class Solution {
        public int[] solution(int[] fees, String[] records) {
        Map<String, Car> carMap = new HashMap<>();

        for (String record : records) {
            String[] split = record.split(" ");
            String carNumber = split[1];
            int curTime = Integer.parseInt(split[0].substring(0, 2)) * 60 + Integer.parseInt(split[0].substring(3));
            Car curCar = carMap.getOrDefault(carNumber, new Car());

            if (split[2].equals("IN")) {
                curCar.inTime = curTime;
            } else {
                curCar.calculateParkingTime(curTime);
                curCar.inTime = -1;
            }

            carMap.put(carNumber, curCar);
        }

        return carMap.keySet().stream().sorted()
                .mapToInt(num -> {
                    Car car = carMap.get(num);
                    if (car.inTime != -1) {
                        car.calculateParkingTime(23 * 60 + 59);
                    }
                    System.out.println("[" + num + "] parkingTime: " + car.parkingTime);
                    return car.calculateFee(fees[0], fees[1], fees[2], fees[3]);
                } ).toArray();
    }
}

class Car {
    int inTime = -1;
    int parkingTime;
    int fee;

    public void calculateParkingTime(int outTime) {
        this.parkingTime += (outTime - inTime);
    }

    public int calculateFee(int defaultTime, int defaultFee, int unitTime, int unitFee) {
        if (parkingTime <= defaultTime) {
            this.fee += defaultFee;
        } else {
            int excessTime = parkingTime - defaultTime;
            int excessFee = ((int) Math.ceil((double) excessTime / unitTime)) * unitFee;
            this.fee += (defaultFee + excessFee);
        }
        return this.fee;
    }
}