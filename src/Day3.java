import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Day3 {
    public static void main(String[] args){
        // 중앙값 구하기
        int[] array = {9, -1, 0};
        int median = solution(array);
        System.out.println(median);
    }

    static int solution (int[] array){
        List list = new ArrayList<>();
        list = Arrays.stream(array).boxed().sorted().collect(Collectors.toList());

        int div = list.size()/2;
        int answer = (int) list.get(div);

        // list로 변환하지 않고 배열 그대로 사용
        // Arrays.sort(array);
        // int answer = array[array.length / 2];

        return answer;
    }

    static int solution2 (int[] array){
        int answer = 0;
        return answer;
    }
}
