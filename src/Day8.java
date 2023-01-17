import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Day8 {
    public static void main(String[] args){
        // 배열 자르기
        ArrayList arr = solution(new int[] {1, 2, 3, 4, 5}, 1, 3);
        System.out.println(arr);

        // 외계행성의 나이
        String age = solution(51);
        System.out.println(age);

        // 진료 순서 정하기
        int[] order = solution(new int[] {1, 2, 3, 4, 5, 6, 7});
        for(int i = 0; i < order.length; i++){
            System.out.print(order[i] + ", ");
        }

        System.out.println();

        // 순서쌍의 개수
        int count = solution4(100);
        System.out.println(count);
    }

    static ArrayList solution(int[] numbers, int num1, int num2){
        ArrayList answer = new ArrayList();

        for(int i = num1; i <= num2; i++){
            answer.add(numbers[i]);
        }

        // CopyOfRange 사용
//        return Arrays.copyOfRange(numbers, num1, num2 + 1);

        // IntStream 사용
//        return IntStream.rangeClosed(num1, num2).map(i -> numbers[i]).toArray();

        return answer;
    }

    static String solution(int age){
        String answer = "";
        String[] arr = String.valueOf(age).split("");

        for(int i = 0; i<arr.length; i++){
            // 아스키코드를 이용
            answer += (char)((Integer.parseInt(arr[i]) + 97));
        }

        return answer;
    }

    static int[] solution(int[] emergency) {
        int[] answer = new int[emergency.length];

        // reverseOrder 사용해주기 위해서 Wrapper클래스로 박싱
        Integer[] temp = Arrays.stream(emergency).boxed().toArray(Integer[]::new);
        Arrays.sort(temp, Comparator.reverseOrder());

        // emergency 배열을 받아서 temp 배열에 역정렬해서 넣음
        // emergency 배열과 비교해서 temp의 인덱스 값 answer 배열에 반환

        for(int i = 0; i < emergency.length; i++){
            for(int j = 0; j < temp.length; j++){
                if(emergency[i] == temp[j]){
                    answer[i] = j+1;
                }
            }
        }

        return answer;

        // 한 줄 리턴
//        return Arrays.stream(emergency).map(i -> Arrays.stream(emergency).boxed().sorted(Comparator.reverseOrder()).collect(Collectors.toList()).indexOf(i)+1).toArray();
    }

    static int solution4(int n){
        int answer = 0;
        int i = 1;
        while(i <= n){
            if(n % i == 0){
                answer++;
            }
            i++;
        }
        return answer;

        // IntStream 사용
//        return IntStream.rangeClosed(1, n).filter(i -> n % i == 0).count();
    }
}
