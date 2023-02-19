public class Day17 {
    public static void main(String[] args) {
        System.out.println(solution(29183, 0));
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


}
