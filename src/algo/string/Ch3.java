package algo.string;

import java.util.Scanner;

public class Ch3 {

    public static String solution(String input){

        String[] array = input.split(" ");

        String answer = "";

        for (String s : array) {
            if (s.length() > answer.length()){
                answer =s;
            }
        }

        return answer;
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        System.out.println(solution(input));


    }

}
