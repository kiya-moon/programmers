import java.util.Arrays;
import java.util.stream.Collectors;

public class Day19 {
    public static void main(String[] args) {
        // 7의 개수
        System.out.println(solution(new int[] {7, 77, 17}));
    }

    public static int solution(int[] array){
        int answer = 0;
        // 배열에 7이 총 몇 개 있는지...
        String str = Arrays.stream(Arrays.stream(array).mapToObj(String::valueOf).toArray(String[]::new)).collect(Collectors.joining());

        return (int)Arrays.stream(str.split("")).filter(i -> i == "7").count();

    }
}
