import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Day13 {
    public static void main(String[] args) {
        // 컨트롤 제트
        System.out.println(solution("-1 -2 -3 Z"));

        // 배열 원소의 길이
        Arrays.stream(solution(new String[]{"We", "are", "the", "world!"})).forEach(i -> System.out.print(i + " "));

        System.out.println();

        // 중복된 문자 제거
        System.out.println(solution3("people"));

        // 삼각형의 완성조건(1)
        System.out.println(solution(new int[] {199, 72, 222}));
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

        // Stack 이용하는 방법
//        Stack<Integer> stack = new Stack<>();
//        for(String str : s.split(" ")){
//            if(str.equals("Z")){
//                stack.pop();
//            } else{
//                stack.push(Integer.parseInt(str));
//            }
//        }
//        for(int i : stack){
//            answer += i;
//        }

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

    static String solution3(String my_string){
        String answer = "";
        List<String> arr = new ArrayList<>();
        for(int i = 0; i < my_string.length(); i++){
            if(!arr.contains(String.valueOf(my_string.charAt(i)))){
                arr.add(String.valueOf(my_string.charAt(i)));
            }
        }

        // LinkedHashSet 사용
//        Set<String> arr = new LinkedHashSet<>(Arrays.asList(my_string.split("")));

        answer = String.join("", arr);

        return answer;

        // 한 줄 리턴
        // 나도 이렇게 하고 싶었다규ㅠㅠㅠㅠ
//        return Arrays.stream(my_string.split("")).distinct().collect(Collectors.joining());
    }

    static int solution(int[] sides){
        int longSide = Arrays.stream(sides).max().getAsInt();
        System.out.println(Arrays.stream(sides).filter(i -> i == longSide).distinct().toString());
        if(longSide < Arrays.stream(sides).filter(i -> i == longSide).distinct().sum()){
            return 1;
        } else {
            return 2;
        }
    }
}
