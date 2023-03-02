import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Day19 {
    public static void main(String[] args) {
        // 7의 개수
        System.out.println(solution(new int[] {10, 29}));

        // 잘라서 배열로 저장하기
        Arrays.stream(solution("abc1Addfggg4556b", 6)).forEach(i -> System.out.print(i + " "));
    }

    public static int solution(int[] array){
        return (int)Arrays.stream(Arrays.stream(array).mapToObj(String::valueOf).collect(Collectors.joining())
                .split("")).filter(i -> i.equals("7")).count();
    }

    public static String[] solution(String my_str, int n){
        List list = new ArrayList<String>();
        for(int i = 0; i < my_str.length(); i+=n){
            list.add(my_str.substring(i, i+n));
            if( i + n + n > my_str.length() ){
                list.add(my_str.substring(i+n));
                break;
            }
        }
        String[] answer = (String[]) list.toArray(new String[list.size()]);
        return answer;
        // 이거 왜 이렇게 안 풀려...
        // 집중이 안되네...
    }
}
