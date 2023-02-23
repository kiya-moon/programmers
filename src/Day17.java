import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Day17 {
    public static void main(String[] args) {
        // 숫자 찾기
        System.out.println(solution(29183, 0));

        // n의 배수 고르기
        Arrays.stream(solution(3, new int[]{4, 5, 6, 7, 8, 9, 10, 11, 12})).forEach(i -> System.out.print(i + " "));

        System.out.println();

        // 자릿수 더하기
        System.out.println(solution(930211));

        // OX 퀴즈
        Arrays.stream(solution(new String[]{"-3 - 3 = -6"})).forEach(i -> System.out.print(i + " "));
    }

    public static int solution(int num, int k){
        int answer = 0;
        String temp = num + "";
        if(temp.indexOf(k+"")==-1){
            answer = -1;
        } else {
            answer = temp.indexOf(k+"") + 1;
        }
        return answer;

        // 같은 풀이지만 if문 사용 안하고 깔끔하게
//        String temp = num + "";
//        int answer = temp.indexOf(k+"");
//        return answer < 0 ? -1 : answer + 1;

        // 문자를 앞에 넣어서 인덱스를 하나씩 미루는 방법
        // 희표좌 풀이 진짜 미쳤음
//        return ("-" + num).indexOf(String.valueOf(k));
    }

    public static int[] solution(int n, int[] numlist){
        return Arrays.stream(numlist).boxed().filter(i -> i % n == 0).mapToInt(Integer::intValue).toArray();
        // return Arrays.stream(numlist).filter(i -> i % n == 0).toArray();
    }

    public static int solution(int n){
        return Stream.of(String.valueOf(n).split("")).mapToInt(Integer::parseInt).sum();

        // while문으로 풀이 할 때
//        int answer = 0;
//        while (n > 0){
//            answer += n % 10;
//            n /= 10;
//        }
//        return answer;
    }

    public static String[] solution(String[] quiz){
        String[] answer = {};
        List<String> list = new ArrayList<>();
        String[] temp = {};
        for(String s : quiz){
            temp = s.split(" ");

            // 내 풀이
            if(temp[1].equals("-")){
                list.add((Integer.parseInt(temp[0])) - Integer.parseInt(temp[2]) == Integer.parseInt(temp[4]) ? "O" : "X");
            } else {
                list.add((Integer.parseInt(temp[0])) + Integer.parseInt(temp[2]) == Integer.parseInt(temp[4]) ? "O" : "X");
            }

            // 같은 풀이 다른 느낌
//            int X = Integer.parseInt(temp[0]);
//            int Y = Integer.parseInt(temp[2]);
//            int Z = Integer.parseInt(temp[4]);
//            int cal = 0;
//            if(temp[1].equals("-")){
//                cal = X - Y;
//            } else {
//                cal = X + Y;
//            }
//            list.add(Z == cal ? "O" : "X");

            // 간단한 이번 풀이 같은 경우에는 내 풀이도 괜찮을 것 같지만,
            // 식이 길어질 땐 값마다 Integer.parseInt()를 붙이는 것은 비효율적이니 두 번째 풀이가 나을 것 같다.

            // 음수, 양수에 따라 1 또는 -1을 곱하는 셈법
            // 매우 깔끔함
//            int result = Integer.parseInt(temp[0]) + (Integer.parseInt(temp[2]) * (temp[1].equals("-") ? -1 : 1));
//            list.add(result == Integer.parseInt(temp[4]) ? "O" : "X");
        }

        answer = list.toArray(new String[list.size()]);
        return answer;

        // 희표좌의 Stream 매직...
//        return Arrays.stream(quiz).map(s -> {
//            String[] arr = s.trim().split(" ");
//            return arr[1].equals("+") && Integer.parseInt(arr[0]) + Integer.parseInt(arr[2]) == Integer.parseInt(arr[4])
//                    || Integer.parseInt(arr[0]) - Integer.parseInt(arr[2]) == Integer.parseInt(arr[4]) ? "O" : "X";
//        }).toArray(String[]::new);
    }
}
