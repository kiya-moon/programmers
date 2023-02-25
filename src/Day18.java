import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Day18 {
    public static void main(String[] args) {
        // 문자열 안에 문자열
        System.out.println(solution("ppprrrogrammers", "pppp"));

        // 제곱수 판별하기
        System.out.println(solution(976));

        // 세균 증식
        System.out.println(solution(2, 10));

        // 문자열 정렬하기
        System.out.println(solution("Bcad"));
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

    public static int solution(int n, int t){
        int answer = n;
        for(int i = 1; i <= t; i++){
            answer *= 2;
        }

        // 비트 쉬프트 연산자 사용
//        answer = n << t;

        return answer;
    }

    public static String solution(String my_string){
        StringBuilder sb = new StringBuilder();
        List list = Arrays.stream(my_string.toLowerCase().split("")).sorted().collect(Collectors.toList());
        for(Object o : list){
            sb.append(o);
        }
        return sb.toString();

        // 아... joining을 생각 못해서 StringBuilder를 썼음............;ㅅ;
//        return Arrays.stream(my_string.toLowerCase().split("")).sorted().collect(Collectors.joining());

        // char배열 사용
//        char[] c = my_string.toLowerCase().toCharArray();
//        Arrays.sort(c);
//        return new String(c);
    }
}
