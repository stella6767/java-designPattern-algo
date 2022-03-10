package algo.string;

import java.util.Scanner;

public class Ch1 {


    public static int solution(String probleam, char c){

        int answer = 0;

        for (Character s : probleam.toCharArray()) {
            if (Character.toUpperCase(s) == Character.toUpperCase(c) ) answer++;

        }

        return answer;
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String probleam = sc.next();
        char c = sc.next().charAt(0);

        System.out.println(solution(probleam, c));


    }


}
