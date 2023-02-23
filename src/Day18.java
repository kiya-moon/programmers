import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Day18 {
    public static void main(String[] args) {
        // 문자열 안에 문자열
        System.out.println(solution("ppprrrogrammers", "pppp"));

        // 제곱수 판별하기
        System.out.println(solution(976));
    }

    public static int solution(String str1, String str2){
        // indexOf()
        return str1.indexOf(str2) == -1 ? 2 : 1;

        // contains()
//        return str1.contains(str2) ? 1 : 2;
    }

    public static int solution(int n){
        int[] arr = IntStream.rangeClosed(1, n).filter(i -> n % i == 0).toArray();
        int square = arr[arr.length / 2];
        return n == square * square ? 1 : 2;

        // Math 메서드
//        return n % Math.sqrt(n) == 0 ? 1 : 2;

    }
}
