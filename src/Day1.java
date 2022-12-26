public class Day1 {
    public static void main(String[] args) {

        // 두 수의 합
        int sum = solution(1, 2);
        System.out.println(sum);

        // 두 수의 차
        int minus = solution2(1, 2);
        System.out.println(minus);

        // 두 수의 곱
        int multiply = solution3(1, 2);
        System.out.println(multiply);

        // 몫 구하기
        int quotient = solution4(1,2);
        System.out.println(quotient);

        // 추가. 나머지 구하기
        int remainder = soution5(1,2);
        System.out.println(remainder);

    }

    static int solution(int num1, int num2) {
        int answer = num1 + num2;
        return answer;
    }

    static int solution2(int num1, int num2) {
            int answer = num1 - num2;
            return answer;
    }

    static int solution3(int num1, int num2) {
        int answer = num1*num2;
        return answer;
    }

    static int solution4(int num1, int num2) {
        int answer = num1/num2;
        return answer;
    }

    static int soution5(int num1, int num2){
        int answer = num1%num2;
        return answer;
    }
}