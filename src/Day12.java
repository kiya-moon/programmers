import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Day12 {
    public static void main(String[] args) {
        // 모음 제거
        String removeVowel = solution("nice to meet you");
        System.out.println(removeVowel);

        // 문자열 정렬하기(1)
        int[] sort = solution2("p2o4i8gj2");
        IntStream intStream = Arrays.stream(sort);
        intStream.forEach(i -> System.out.print(i + " "));

        System.out.println();

        // 숨어있는 숫자의 덧셈(1)
        int sum = solution3("aAb1B2cC34oOp");
        System.out.println(sum);

        // 소인수분해
        System.out.println(solution4(420));

    }

    static String solution(String my_string){
        String answer = "";
        answer = my_string.replaceAll("a", "").replaceAll("e", "")
                .replaceAll("i","").replaceAll("o", "").replaceAll("u", "");
//         answer = my_string.replaceAll("a|e|i|o|u|", "");
//         answer = my_string.replaceAll("[a,e,i,o,u]", "");
        return answer;
    }

    static int[] solution2(String my_string){
        int[] answer = {};
        String temp = my_string.replaceAll("[^0-9]", "");
        answer = Arrays.stream(temp.split("")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(answer);

        // 한 줄로 가능한 거여써....
//        answer =  Arrays.stream(my_string.replaceAll("[^0-9]", "").split("")).sorted().mapToInt(Integer::parseInt).toArray();

        return answer;

    }

    static int solution3(String my_string){
        int answer = 0;
        int[] temp = {};

        temp = Arrays.stream(my_string.replaceAll("[^0-9]", "").split(""))
                .mapToInt(Integer::parseInt).toArray();

        for(int i = 0; i < temp.length; i++){
            answer += temp[i];
        }

        return answer;
    }

    static List solution4(int n){
        List<Integer> answer = new ArrayList<>();
        for(int i = 2; i <= n;){
            if(n % i == 0){
                answer.add(i);
                n /= i;
            } else {
                i++;
            }
        }
        return answer.stream().distinct().collect(Collectors.toList());

        // hashSet 사용하면 중복 없이 값을 넣을 수 있지만
        // 순서 없이 들어가기 때문에 프로그래머스 테스트에서 통과를 못함
    }
}
