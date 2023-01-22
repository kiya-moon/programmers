import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Day12 {
    public static void main(String[] args) {
        // 모음 제거
        String removeVowel = solution("nice to meet you");
        System.out.println(removeVowel);

        // 문자열 정렬하기(1)
        int[] sort = solution2("hi12392");
        IntStream intStream = Arrays.stream(sort);
        intStream.forEach(i -> System.out.print(i + " "));

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
        String[] temp = my_string.replaceAll("[^//d]", "").split("");
        answer = Stream.of(temp).mapToInt(Integer::parseInt).sorted().toArray();
        return answer;
    }

}
