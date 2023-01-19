import java.util.Arrays;
import java.util.stream.IntStream;

public class Day10 {
    public static void main(String[] args) {
        // 점의 위치 구하기
        int loc = solution(new int[]{-7, 9});
        System.out.println(loc);

        // 2차원으로 만들기
        int[][] array = solution(new int[] {1, 2, 3, 4, 5, 6, 7, 8} , 2);
        System.out.println(Arrays.deepToString(array));

    }

    static int solution(int[] dot){
        int answer = 0;

        if (dot[0] > 0 && dot [1] > 0){ return answer = 1; }
        else if (dot[0] < 0 && dot[1] > 0){ return answer = 2; }
        else if (dot[0] < 0 && dot[1] < 0 ){ return answer = 3; }
        else if (dot[0] > 0 && dot[1] < 0 ){ return answer = 4; }

        return answer;
    }

    static int[][] solution (int[] num_list, int n){
        int[][] answer = new int[num_list.length/n][n];
        int idx = 0;

        for(int i = 0; i < num_list.length/n; i++){
            for(int j = 0; j < n; j++){
                answer[i][j] = num_list[idx];
                idx++;
            }
        }

        // 몫과 나머지를 이용하면 for문으로 해결 가능
//        for(int i = 0; i < num_list.length; i++){
//            answer[i/n][i%n] = num_list[i];
//        }

        return answer;
    }

    static int[] solution(int[] numbers, int k){

    }
}
