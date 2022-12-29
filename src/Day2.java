import java.security.spec.RSAOtherPrimeInfo;
import java.util.Arrays;

public class Day2 {
    public static void main(String[] args){
        // 두 수의 나누셈
        int division = solution(3,2);
        System.out.println(division);

        // 숫자 비교
        int compare = solution2(3,2);
        System.out.println(compare);

        // 분수의 덧셈
        int[] fraction = solution3(9,2,1,3);
        for(Object object:fraction){
            System.out.println(object);
        }

        // 배열 두 배 만들기
        int[] numbers = {1, 2, 3, 4, 5};
        int[] array = solution4(numbers);
        for(Object object:array){
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
        int denominator = num1*num2;
        // 분자
        int molecule = (denum1*num2) + (denum2*num1);
        // 최대공약수
        int max = 0;

        for(int i=1; i<=denominator && i<=molecule; i++){
            if(denominator%i==0 && molecule%i==0){
                max = i;
            }
        }

        denominator = denominator/max;
        molecule = molecule/max;

        int[] answer = {molecule, denominator};
        return answer;
    }

    static int[] solution4(int[] numbers){
        int[] answer = numbers;
        for(int i = 0; i < numbers.length; i++){
            answer[i] = numbers[i]*2;
        }
        return answer;

        // 화살표 함수 사용
        // return Arrays.stream(numbers).map(i -> i*2).toArray();
    }
}
