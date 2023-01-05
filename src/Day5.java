import java.util.Arrays;

public class Day5 {
    public static void main(String[] args){
        // 옷가게 할인 받기
        int clothingStore = solution(150000);
        System.out.println(clothingStore);

        // 아이스 아메리카노
        int[] americano = solution2(15000);
        for(int i : americano){
            System.out.println(i);
        }

        // 나이 출력
        int year = solution3(40);
        System.out.println(year);

        // 배열 뒤집기
        int[] reverse = solution4(new int[] {1, 2, 3, 4, 5});
        System.out.println(Arrays.toString(reverse));
    }

    static int solution(int price){
        int answer = 0;
        if(price >= 500000){
            answer = (int)(price*0.8);
        } else if (price >= 300000) {
            answer = (int)(price*0.9);
        } else if (price >= 100000) {
            answer = (int)(price*0.95);
        } else {
            answer = price;
        }
        return answer;
    }

    static int[] solution2(int money){
        int cup = money/5500;
        int changes = money%5500;
        int[] answer = {cup, changes};
        return answer;

        // 한 줄 풀이
        // return new int[] {money/5500, money%5500};
    }

    static int solution3(int age){
        return 2022 - age + 1;

        // 오늘 연도 기준 풀이
        // LocalDate today = LocalDate.now();
        // return today.getYear() - age + 1;
    }

    static int[] solution4(int[] num_list){
        int[] answer = new int[num_list.length];

        for(int i = 0; i<num_list.length; i++){
            answer[i] = num_list[num_list.length-1-i];
        }

        // 신기한 for문
        // for (int i = num_list.length - 1, j = 0; i >= 0; i--, j++) {
        //      answer[j] = num_list[i];
        //  }

        return answer;

        // Stream 사용
        // List<Integer> list = Arrays.stream(num_list).boxed().collect(Collectors.toList());
        // Collections.reverse(list);
        // return list.stream().mapToInt(Integer::intValue).toArray();

    }

}
