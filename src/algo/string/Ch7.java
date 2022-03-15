package algo.string;

import java.util.Scanner;

public class Ch7 {

    /**
     * 회문 문자열
     * @param args
     */


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();

        System.out.println(solution(input));
    }

    private static String solution(String input) {

        String answer = "";

        char[] chars = input.toCharArray();
        StringBuilder sb = new StringBuilder();

        for (int i= 0; i <chars.length; i++){
            answer += Character.toUpperCase(chars[i]);
        }


        //System.out.println(answer);
        sb.append(answer);

        StringBuilder reverse = sb.reverse();
       // System.out.println("reverse:  " + reverse.toString());

        String s = reverse.toString();

        if (s.equals(answer)){
            answer = "YES";
        }else{
            answer="NO";
        }
        return answer;
    }

}
