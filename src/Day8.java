import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Day8 {
    public static void main(String[] args){
        // 배열 자르기
        ArrayList arr = solution(new int[] {1, 2, 3, 4, 5}, 1, 3);
        System.out.println(arr);
    }

    static ArrayList solution(int[] numbers, int num1, int num2){
        ArrayList answer = new ArrayList();

        for(int i = num1; i <= num2; i++){
            answer.add(numbers[i]);
        }

        // CopyOfRange 사용
//        return Arrays.copyOfRange(numbers, num1, num2 + 1);

        // IntStream 사용
//        return IntStream.rangeClosed(num1, num2).map(i -> numbers[i]).toArray();

        return answer;
    }
}
