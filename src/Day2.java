import java.security.spec.RSAOtherPrimeInfo;

public class Day2 {
    public static void main(String[] args){
        // 두 수의 나누셈
        int division = solution(3,2);
        System.out.println(division);

        // 숫자 비교
        int compare = solution2(3,2);
        System.out.println(compare);

        // 분수의 덧셈
        int[] fraction = solution3(1,2,3,4);
        for(Object object:fraction){
            System.out.println(object);
        }
    }

    static int solution(int num1, int num2) {
        int answer = (int)((num1*1.0)/num2*1000);
        return answer;
    }

    static int solution2(int num1, int num2) {
        int answer = 0;
        if(num1 == num2){
            answer = 1;
        } else{
            answer = -1;
        }

        // if문 간단하게
        // if(num1 == num2) return 1;
        // else return -1;

        // 삼항연산자 활용
        // answer = (num1 == num2) ? 1 : -1;

        return answer;
    }

    static int[] solution3(int denum1, int num1, int denum2, int num2) {
        // 분모
        int denominator = 0;
        // 분자
        int molecule = 0;
        if (num2 % num1 != 0) {
            denominator = num1*num2;
            molecule = (denum1*num2)+(denum2*num1);
        } else {
            denominator = num1>=num2? num1 : num2;
            if(num1>=num2){
                molecule = denum1 + denum2*(num1/num2);
            } else {
                molecule = denum1 * (num2 / num1) + denum2;
            }
        }

        int[] answer = {molecule, denominator};
        return answer;
    }
}
