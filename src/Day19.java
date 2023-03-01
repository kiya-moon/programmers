import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Day19 {
    public static void main(String[] args) {
        // 7의 개수
        System.out.println(solution(new int[] {10, 29}));

        // 잘라서 배열로 저장하기
        System.out.println(solution("abc1Addfggg4556b", 6));
    }

    public static int solution(int[] array){
        return (int)Arrays.stream(Arrays.stream(array).mapToObj(String::valueOf).collect(Collectors.joining())
                .split("")).filter(i -> i.equals("7")).count();
    }

    public static String[] solution(String my_str, int n){
        List list = new ArrayList<String>();
        for(int i = 0; i <= my_str.length(); i+=n){
            list.add(my_str.substring(i, i+n));
            String a = list.get(0).toString();
        }
        return new String[list.size()];
    }
}
