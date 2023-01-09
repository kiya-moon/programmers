import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Day6 {
    public static void main(String[] args){
        // 문자열 뒤집기
        String string = solution("jaron");
        System.out.println(string);

        // 직각 삼각형 출력하기
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i = 1; i <= n; i++){
            for(int j = 0; j < i; j++){
                System.out.print("*");
            }
            System.out.println();
        }

        // 단일 for문 사용
//        for(int i = 1; i <= n; i++){
//            System.out.println("*".repeat(i));
//        }

        // BufferReader 및 StringBuilder 사용 방법
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder sb = new StringBuilder();
//
//        try {
//            int n = Integer.parseInt(br.readLine());
//
//            for(int i = 1; i <= n; i++){
//                for(int j = 0; j < i; j++){
//                    sb.append("*");
//                }
//                sb.append("/n");
//            }
//
//            System.out.println(sb.toString());
//
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

        // 짝수 홀수 개수
        int[] count = solution2(new int[] {1, 2, 3, 4, 5});
        for(int i = 0; i < count.length; i++){
            System.out.println(count[i]);
        }

        // 문자 반복 출력하기
        StringBuilder repeat = solution3("hello", 3);
        System.out.println(repeat);

    }

    static String solution(String my_string){
        StringBuilder answer = new StringBuilder(my_string).reverse();
        return answer.toString();

        // for문으로 풀이
//        String answer = "";
//        for(int i = my_string.length()-1; i>=0; i--){
//            answer += my_string.charAt(i);
//        }
//        return answer;
    }

    static int[] solution2(int[] num_list) {
        int even = 0;
        int odd = 0;

        for(int i = 0; i < num_list.length; i++){
            if(num_list[i] % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }
        int[] answer = {even, odd};
        return answer;

        // 참신한 방법
        // 2로 나누면 나머지는 0과 1만 나옴
        // answer 배열의 인덱스로 활용 가능
//        int[] answer = new int[2];
//
//        for(int i = 0; i < num_list.length; i++)
//            answer[num_list[i] % 2]++;
//
//        return answer;

        // IntStream 사용
//        return IntStream.of((int) Arrays.stream(num_list).filter(i -> i % 2 == 0).count(),
//                (int)Arrays.stream(num_list).filter(i -> i % 2 != 0).count()).toArray();
    }

    static StringBuilder solution3(String my_string, int n){
        StringBuilder answer = new StringBuilder();
        for(int i = 0; i < my_string.length(); i++){
            for(int j = 0; j < n; j++){
                answer.append(my_string.charAt(i));
            }
        }

        return answer;

        // for each 사용
//        for(char c : my_string.toCharArray()){
//            answer.append((c + "").repeat(n));
//        }
//
//        return answer.toString();
    }

}
