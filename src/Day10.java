import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Day10 {
    public static void main(String[] args) {
        // 점의 위치 구하기
        int loc = solution(new int[]{-7, 9});
        System.out.println(loc);

        // 2차원으로 만들기
        int[][] array = solution(new int[] {1, 2, 3, 4, 5, 6, 7, 8} , 2);
        System.out.println(Arrays.deepToString(array));

        // 공 던지기
        int answer = solution3(new int[] {1, 2, 3}, 3);
        System.out.println(answer);

        // 배열 회전시키기
        int[] rotation = solution4(new int[] {4, 455, 6, 4, -1, 45, 6}, "left");
        System.out.println(Arrays.toString(rotation));
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

    static int solution3(int[] numbers, int k){
        int answer = 0;
        int idx = 0;
        for(int i = 0; i < k; i++){
            answer = numbers[idx % numbers.length];
            idx += 2;
        }
        return answer;

        // 한 줄 풀이
        // (k-1)*2는 마지막에 공을 던지는 사람의 인덱스 ( 마지막에 공을 던지는 사람은 (k-1)*2+1 번째 사람)
//        return numbers[(k-1)*2 % numbers.length];
        // (k-1)*2 % numbers.length + 1
        // 번호는 1부터 시작하기 때문에 index 값에 1을 더해주면 괄호로 인한 복잡도를 줄일 수 있다.
    }

    static int[] solution4(int[] numbers, String direction){
        int[] answer = new int[numbers.length];
        // right일 경우, 배열 마지막이 [numbers.length - 1], 그 다음이 [0]부터
        if(direction.equals("right")){
            answer[0] = numbers[numbers.length - 1];
            for(int i = 1; i < numbers.length; i++){
                answer[i] = numbers[i - 1];
            }
        } else{
            // left일 경우, 배열 두번째부터 for문, 배열 마지막에 [0]
            for(int i = 1; i < numbers.length; i++){
                answer[i-1] = numbers[i];
            }
            answer[numbers.length - 1] = numbers[0];
        }
        return answer;

        // 리스트 사용해서, 필요한 값을 넣고, 필요없는 값은 빼고...
//        List<Integer> list = Arrays.stream(numbers).boxed().collect(Collectors.toList());
//        if(direction.equals("right")){
//            list.add(0, list.get(list.size()-1));
//            list.remove(list.size()-1);
//        } else{
//            list.add(list.size(), list.get(0));
//            list.remove(0);
//        }
//        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
