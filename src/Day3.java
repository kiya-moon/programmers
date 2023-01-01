import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Day3 {
    public static void main(String[] args){
        // 중앙값 구하기
        int median = solution(new int[]{9, -1, 0});
        System.out.println(median);

        // 최빈값 구하기
        int mode = solution2(new int[]{1, 2, 3, 3, 3, 4});
        System.out.println(mode);

        // 짝수는 싫어요
        List odd = solution3(10);
        for (int i=0; i<odd.size(); i++){
            System.out.println(odd.get(i));
        }
    }

    static int solution (int[] array){
        List list = new ArrayList<>();
        list = Arrays.stream(array).boxed().sorted().collect(Collectors.toList());

        int div = list.size()/2;
        int answer = (int) list.get(div);

        // list로 변환하지 않고 배열 그대로 사용
        // Arrays.sort(array);
        // int answer = array[array.length / 2];

        return answer;
    }

    static int solution2 (int[] array){
        int answer = 0;

        // 매개변수로 들어온 배열의 최대값
        int arrayMax = Arrays.stream(array).max().getAsInt();

        // 최대값보다 1 큰 새로운 배열 생성
        int[] array2 = new int[arrayMax + 1];
        for(int i=0; i<array.length; i++){
            // array 배열의 값을 array2 배열의 인덱스로 사용
            array2[array[i]]++;
        }

        // array2 배열의 최대값 인덱스 구하기
        int array2max = array2[0];
        for(int i=0; i<array2.length; i++){
            if(array2max<array2[i]){
                array2max = array2[i];
                answer = i;  // 이 인덱스가 array 배열의 최빈값
            }
        }

        // 최빈값이 같을 때
        int check = 0;
        for(int i=0; i<array2.length; i++){
            if(array2max==array2[i]){
                check++;
            }
        }

        if(check!=1){
            answer = -1;
        }

        return answer;
    }

    static List solution3(int n){

        List list = new ArrayList();
        for(int i=n; i>0; i--){
            // 홀수라면
            if(i % 2 != 0){
                list.add(i);
            }
        }
        Collections.sort(list);

        // IntStream 사용
//            public int[] solution(int n) {
//                return IntStream.rangeClosed(0, n).filter(value -> value % 2 == 1).toArray();
//            }
//        }

        return list;
    }
}
