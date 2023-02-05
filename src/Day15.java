import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Day15 {
    public static void main(String[] args) {
        // 영어가 싫어요
        System.out.println(solution("onefourzerosixseven"));

        // 인덱스 바꾸기
        System.out.println(solution("I love you", 3, 6));

        // 한 번만 등장한 문자
        System.out.println(solution3("abcabcadc"));

        // 약수 구하기
        System.out.println(solution(24));

    }

    static long solution(String numbers){
        long answer = 0;

        numbers = numbers.replace("zero", "0");
        numbers = numbers.replace("one", "1");
        numbers = numbers.replace("two", "2");
        numbers = numbers.replace("three", "3");
        numbers = numbers.replace("four", "4");
        numbers = numbers.replace("five", "5");
        numbers = numbers.replace("six", "6");
        numbers = numbers.replace("seven", "7");
        numbers = numbers.replace("eight", "8");
        numbers = numbers.replace("nine", "9");

        // 더 깔끔한 방법
//        String[] numbers_arr = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
//
//        for(int i = 0; i < numbers_arr.length; i++){
//            numbers = numbers.replaceAll(numbers_arr[i], String.valueOf(i));
//        }

        answer = Long.parseLong(numbers);

        return answer;
    }

    static String solution(String my_string, int num1, int num2){
        StringBuilder answer = new StringBuilder();
        for(int i = 0; i < my_string.length(); i++){
            if(i == num1){
                answer.append(my_string.charAt(num2));
            } else if (i == num2) {
                answer.append(my_string.charAt(num1));
            } else {
                answer.append(my_string.charAt(i));
            }
        }
        return answer.toString();

        // Collection.swap()
//        List<String> list = Arrays.stream(my_string.split("")).collect(Collectors.toList());
//        Collections.swap(list, num1, num2);
//        return String.join("", list);
    }

    static String solution3(String s){
        char[] alphabet = new char[26];
        for (int i = 0; i < s.length(); i++) {
            alphabet[s.charAt(i) - 97]++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < alphabet.length; i++) {
            if (alphabet[i] == 1) sb.append((char) (i + 97));
        }

        return sb.toString();
    }

    static int[] solution(int n){
        List<Integer> list = new ArrayList();
        for(int i = 1; i <= n; i++){
            if(n % i == 0){
                list.add(i);
            }
        }
        return list.stream().mapToInt(x -> x).toArray();

        // 한 줄 리턴
//        return IntStream.rangeClosed(1, n).filter(i -> n % i == 0).toArray();
    }
}
