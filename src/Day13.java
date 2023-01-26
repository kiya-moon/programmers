import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day13 {
    public static void main(String[] args) {
        // 컨트롤 제트
        System.out.println(solution("-1 -2 -3 Z"));

        // 배열 원소의 길이
        Arrays.stream(solution(new String[]{"We", "are", "the", "world!"})).forEach(i -> System.out.print(i + " "));

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

    static int[] solution(String[] strlist){
        int[] answer = new int[strlist.length];

        for(int i = 0; i < strlist.length; i++){
            String s = strlist[i];
            answer[i] = (int)Arrays.stream(s.split("")).count();
        }

        return answer;

        // 한 줄 리턴
//        return Arrays.stream(strlist).mapToInt(String::length).toArray();
    }
}
