import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Day7 {
    public static void main(String[] args){
        // 특정 문자 제거하기
        String delete = solution("abcdef", "f");
        System.out.println(delete);

        // 양꼬치
        int price = solution(64, 6);
        System.out.println(price);

        // 짝수의 합
        int sum = solution(10);
        System.out.println(sum);
    }

    static String solution(String my_string, String letter) {
        String answer = "";
        answer = my_string.replaceAll(letter, "");
        return answer;

        // StringBuilder, char 배열 사용
//        StringBuilder sb = new StringBuilder();
//        char[] arr = my_string.toCharArray();
//
//        for(char c : arr){
//            if(c != letter.charAt(0)){
//                sb.append(c);
//            }
//        }
//
//        return sb.toString();
    }

    static int solution(int n, int k){
        return (12000 * n) + (2000 * k) - ((n/10) * 2000);
    }

    static int solution(int n){
        int answer = 0;

        for(int i = 1; i <= n; i++){
            if(i % 2 != 1){
                answer += i;
            }
        }

        // IntStream 사용
        // 짝수만 더하는 것이기 때문에 2부터 시작
//        answer = IntStream.rangeClosed(2, n).filter(i -> i % 2 == 0).sum();

        return answer;
    }
}
