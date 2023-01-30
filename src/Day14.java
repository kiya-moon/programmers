import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Day14 {
    public static void main(String[] args) {
        // 가까운 수
        System.out.println(solution(new int[]{3, 30, 10}, 20));

        // 369게임
        System.out.println(solution(29423));

        // 암호 해독
        System.out.println(solution("pfqallllabwaoclk", 2));

        // 대문자와 소문자
        System.out.println(solution("abCdEfghIJ"));
    }

    static int solution(int[] array, int n){
        int answer = 0;
        Arrays.sort(array);
        // 달거북씨 풀이
        int[] temp = new int[array.length];
        for(int i = 0; i < array.length; i++){
            temp[i] = Math.abs(n - array[i]);
        }
        int tempNum = Arrays.stream(temp).min().getAsInt();

        for(int i = 0; i < temp.length; i++){
            if(temp[i] == tempNum){
                answer = array[i];
                break;
            }
        }

        // 간단하게 비교하는 방법
        for(int i = 1; i < array.length; i++){
            if(Math.abs(n-array[0]) > Math.abs(n-array[i])){
                array[0] = array[i];
            }
        }
        answer = array[0];

        return answer;
    }

    static int solution(int order){
        return (int) Stream.of(String.valueOf(order).split("")).filter(i -> i.equals("3") || i.equals("6") || i.equals("9")).count();
    }

    static String solution(String cipher, int code){
        String answer = "";
        char[] arr = cipher.toCharArray();
        for(int i = code-1; i < arr.length; i += code){
            answer += arr[i];
        }
        return answer;
    }

    static String solution(String my_string){
        String answer = "";
        for(char c : my_string.toCharArray()){
            if(Character.isUpperCase(c)){
                answer += String.valueOf(c).toLowerCase();
            } else{
                answer += String.valueOf(c).toUpperCase();
            }
        }
        return answer;

        // 한 줄 리턴
//        return my_string.chars().mapToObj(c -> String.valueOf((char)
//                (Character.isLowerCase(c) ? Character.toUpperCase(c) : Character.toLowerCase(c)))).collect(Collectors.joining());
    }
}
