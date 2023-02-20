import java.util.Arrays;

public class Day17 {
    public static void main(String[] args) {
        //
        System.out.println(solution(29183, 0));

        // n의 배수 고르기
        Arrays.stream(solution(3, new int[]{4, 5, 6, 7, 8, 9, 10, 11, 12})).forEach(i -> System.out.print(i + " "));
    }

    public static int solution(int num, int k){
        int answer = 0;
        String temp = num + "";
        if(temp.indexOf(k+"")==-1){
            answer = -1;
        } else {
            answer = temp.indexOf(k+"") + 1;
        }
        return answer;

        // 같은 풀이지만 if문 사용 안하고 깔끔하게
//        String temp = num + "";
//        int answer = temp.indexOf(k+"");
//        return answer < 0 ? -1 : answer + 1;

        // 문자를 앞에 넣어서 인덱스를 하나씩 미루는 방법
        // 희표좌 풀이 진짜 미쳤음
//        return ("-" + num).indexOf(String.valueOf(k));
    }

    public static int[] solution(int n, int[] numlist){
        return Arrays.stream(numlist).boxed().filter(i -> i % n == 0).mapToInt(Integer::intValue).toArray();
        // return Arrays.stream(numlist).filter(i -> i % n == 0).toArray();
    }
}
