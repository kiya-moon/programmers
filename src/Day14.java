import java.util.Arrays;
import java.util.OptionalInt;

public class Day14 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{3, 30, 10}, 20));
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
}
