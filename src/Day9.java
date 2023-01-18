import java.util.Arrays;
import java.util.stream.Collectors;

public class Day9 {
    public static void main(String[] args){
        // 개미 군단
        int ant = solution(24);
        System.out.println(ant);

        // 모스부호(1)
        StringBuilder mos = solution(".... . .-.. .-.. ---");
        System.out.println(mos);

        // 가위바위보
        StringBuilder rps = solution3("205");
        System.out.println(rps);

        // 구슬을 나누는 경우의 수
        int noc = solution(5, 3);
        System.out.println(noc);
    }

    static int solution(int hp) {
        int answer = 0;
        int quotient = 0;

        quotient = hp / 5;
        answer = quotient;
        hp -= quotient*5;

        quotient = hp / 3;
        answer += quotient;
        hp -= quotient*3;

        answer += hp / 1;

        // 나머지로 나누면 간단하게 해결
//        answer = (hp / 5) + (hp % 5 / 3) + (hp % 5 % 3);

        return answer;
    }

    static StringBuilder solution(String letter) {
        StringBuilder answer = new StringBuilder();
        String[] arr = letter.split(" ");
        String[] mos = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",
                ".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        String[] alphabet = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m",
                "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};

        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < mos.length; j++){
                if(arr[i].equals(mos[j])){
                    answer.append(alphabet[j]);
                }
            }
        }
        return answer;
    }

    static StringBuilder solution3(String rsp){
        StringBuilder answer = new StringBuilder();
        String[] arr = rsp.split("");

        for(String str : arr){
            switch (str){
                case "2" : answer.append("0");
                    break;
                case "0" : answer.append("5");
                    break;
                case "5" : answer.append("2");
                    break;
            }
        }

        return answer;

        // Stream, 삼항연산자 사용
//        return Arrays.stream(rsp.split("")).map(i -> i.equals("2") ? "0" : i.equals("0") ? "5" : "2").collect(Collectors.joining());
    }

    static int combination(int n, int r) {
        // balls 개수 중 share 개를 뽑는 경우의 수 -> 콤비네이션 사용 (balls C share)
        if(n == r || r == 0){
            return 1;
        } else{
            return combination(n - 1, r - 1) + combination(n - 1, r);
        }
    }

    static int solution(int balls, int share){
        return combination(balls, share);
    }
}
