public class Day4 {
    public static void main(String[] args){
        // 피자 나눠 먹기(1)
        int pizza = solution(15);
        System.out.println(pizza);

        // 피자 나눠 먹기(2)

    }

    static int solution(int n){
        int answer = 0;
        if(n%7==0) {
            answer = n/7;
        } else {
            answer = n/7 + 1;
        }

        // 삼항연산자 풀이
        // answer = (n%7==0) ? n/7 : n/7+1;
        return answer;
    }
}
