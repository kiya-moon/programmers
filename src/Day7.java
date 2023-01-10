import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day7 {
    public static void main(String[] args){
        // 특정 문자 제거하기
        String delete = solution("abcdef", "f");
        System.out.println(delete);
    }

    static String solution(String my_string, String letter) {
        String answer = "";
        answer = my_string.replaceAll(letter, "");
        return answer;

        // StringBuilder, char 배열 사용
//        StringBuilder sb = new StringBuilder();
//        char[] arr = my_string.toCharArray();
//
//        for(char c : arr){
//            if(c != letter.charAt(0)){
//                sb.append(c);
//            }
//        }
//
//        return sb.toString();
    }
}
