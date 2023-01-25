import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day13 {
    public static void main(String[] args) {
        // 컨트롤 제트
        System.out.println(solution("-1 -2 -3 Z"));
    }

    static int solution(String s){
        int answer = 0;

        List<String> arr = new ArrayList<>(Arrays.asList(s.split(" ")));
        List<Integer> nums = new ArrayList<>();

        for(int i = arr.size()-1; i >= 0; i--){
            if(arr.get(i).equals("Z")){
                arr.remove(i);
                arr.remove(i-1);
                i--;
            } else{
                nums.add(Integer.parseInt(arr.get(i)));
            }
        }

        answer = nums.stream().mapToInt(Integer::intValue).sum();

        return answer;
    }
}
