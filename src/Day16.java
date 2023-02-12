import java.util.Arrays;

public class Day16 {
    public static void main(String[] args) {
        // 편지
        System.out.println(solution("I love you~"));

        // 가장 큰 수 찾기
        int[] answer = solution(new int[] {1, 8, 3});
        for(int i : answer){
            System.out.println(i);
        }
    }

    public static int solution(String message){
        return message.length() * 2;
    }

    public static int[] solution(int[] array){
        int max = Arrays.stream(array).max().getAsInt();
        int idx = 0;
        for(int i = 0; i < array.length; i++){
            if(array[i] == max){
                idx = i;
            }
        }
        int[] answer = {max, idx};
        return answer;
    }
}
