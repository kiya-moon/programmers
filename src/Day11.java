import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

public class Day11 {
    public static void main(String[] args) {
        // 주사위의 개수
        int count = solution(new int[] {10, 8, 6}, 3);
        System.out.println(count);

        // 합성수 찾기
        int findNum = solution(15);
        System.out.println(findNum);

        // 최댓값 만들기(1)
        int maxValue = solution(new int[] {1, 2, 3, 4, 5});
        System.out.println(maxValue);

        // 팩토리얼
        int factorial = solution4(3628800);
        System.out.println(factorial);
    }

    static int solution(int[] box, int n){
        int answer = (box[0] / n) * (box[1] / n) * (box[2] / n);
        return answer;
    }

    static int solution(int n){
        // 합성수는 약수의 개수가 3개 이상인 수
        int answer = 0;

        for(int i = 4; i <= n; i++){
            int count = 0;
            for(int j = 1; j * j <= i; j++){
                if(j * j == i) count++;
                else if(i % j == 0) count += 2;
            }
            if(count >= 3){
                answer++;
            }
        }

        return answer;

        // 이중 스트림
//        return (int)IntStream.rangeClosed(4, n).filter(i -> (int)IntStream.rangeClosed(1, i).filter(j -> i % j == 0).count() > 2).count();
    }

    static int solution(int[] numbers){
        int answer = 0;
        Integer[] temp = Arrays.stream(numbers).boxed().toArray(Integer[]::new);
        Arrays.sort(temp, Comparator.reverseOrder());

        answer = temp[0] * temp[1];

        return answer;
    }

    static int solution4(int n){
        int answer = 0;
        int factorial = 1;
        for(int i = 1; factorial <= n; i++){
            factorial *= i;
            answer = i;
        }
        return answer-1;
    }
}
