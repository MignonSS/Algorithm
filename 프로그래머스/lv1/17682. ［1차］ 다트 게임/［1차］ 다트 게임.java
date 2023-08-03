class Solution {
public int solution(String dartResult) {
    int preScore = 0;
    int curScore = 0;
    int sum = 0;

    char[] charArr =  (dartResult + " ").toCharArray();

    for (int i = 0; i < charArr.length; i++) {

				// 1. 숫자일 때
        if (Character.isDigit(charArr[i])) { 
            if (charArr[i] == '0' && i != 0 && charArr[i - 1] == '1') { // 10일 때
                curScore = 10;
            } else { // 0~9
                sum += curScore;
                preScore = curScore;
                curScore = Character.getNumericValue(charArr[i]);
            }
					
					// 2. 알파벳일 때
        } else if (Character.isAlphabetic(charArr[i])) { 
            int curBonus = charArr[i] == 'S' ? 1 : (charArr[i] == 'D' ? 2 : 3);
            curScore = (int) Math.pow(curScore, curBonus);
					
					// 3. 옵션 확인
        } else { 
            switch (charArr[i]) {
                case '*':
                    sum += preScore;
                    curScore *= 2;
                    break;
                case '#':
                    curScore *= -1;
                    break;
                case ' ':
                    sum += curScore;
            }
        }
    }

    return sum;
}
}