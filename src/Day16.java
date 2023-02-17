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

        // 문자열 계산하기
        System.out.println(solution3("1 + 1 + 1"));

        // 배열의 유사도
        System.out.println(solution(new String[] {"n", "omg"}, new String[] {"m", "dot"}));
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

    public static int solution3(String my_string){
        String[] temp = my_string.split(" ");
        int answer = Integer.parseInt(temp[0]);
        for(int i = 1; i < temp.length; i++){
            if(temp[i].equals("+")){
                answer += Integer.parseInt(temp[i + 1]);
            } else if(temp[i].equals("-")) {
                answer -= Integer.parseInt(temp[i + 1]);
            }
        }
        return answer;
    }

    public static int solution(String[] s1, String s2[]){
        int answer = 0;
        for(int i = 0; i < s1.length; i++){
            for(int j = 0; j < s2.length; j++){
                if(s1[i].equals(s2[j])){
                    answer++;
                }
            }
        }
        return answer;
    }

}
