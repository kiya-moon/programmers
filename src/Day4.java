public class Day4 {
    public static void main(String[] args){
        // 피자 나눠 먹기(1)
        int pizza = solution(15);
        System.out.println(pizza);

        // 피자 나눠 먹기(2)
        int pizza2 = solution2(4);
        System.out.println(pizza2);

        // 피자 나눠 먹기(3)
        int pizza3 = solution3(4, 12);
        System.out.println(pizza3);

        // 배열의 평균값
        int[] numbers = {89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99};
        double average = solution4(numbers);
        System.out.println(average);
    }

    static int solution(int n){
        int answer = 0;
        if(n%7==0) {
            answer = n/7;
        } else {
            answer = n/7 + 1;
        }

        // 삼항연산자 풀이
        // answer = (n%7==0) ? n/7 : n/7+1;
        return answer;
    }

    static int solution2(int n){
        // n과 6의 최대공약수 구하기
        int min = (n < 6) ? n : 6;
        int gcd = 0;
        for (int i = 1; i <= min; i++){
            if(n % i == 0 && 6 % i == 0){
                gcd = i;
            }
        }

        // n과 6의 최소공배수 구하기
        int lcm = n*6/gcd;

        // 최소공배수 / 6 = 최소 피자 판 수
        int answer = lcm/6;

        // 무한루프 활용
        // answer = 1;
        // while(true){
        //  if(6 * answer % n == 0){ break; }
        //  answer++;
        // }
        return answer;
    }

    static int solution3(int slice, int n){
        int answer = 0;
        if(n % slice == 0){
            answer = n/slice;
        } else{
            answer = n/slice + 1;
        }
        return answer;
    }

    static double solution4(int[] numbers){
        double answer = 0;
        double sum = 0;
        for(int i : numbers){
            sum += numbers[i];
        }
        answer = sum / numbers.length;

        // stream 사용
        // orElse는 배열이 null일 시 default 값을 주기 위해 사용
        // answer = Arrays.stream(numbers).average().orElse(0);
        return answer;
    }
}
