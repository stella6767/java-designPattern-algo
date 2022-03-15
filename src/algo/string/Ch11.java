package algo.string;

import java.util.Scanner;

public class Ch11 {

    /**
     * 문자열 압축
     * @param args
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        System.out.println(solution(input));

    }

    private static String solution(String input) {

        String answer = "";
        int p = 1;
        
         //indexofOutofError 예방
        char[] chars = input.toCharArray();
        // 0,1,2,7
        for (int i = 0; i < input.length(); i++) {
            //System.out.println(input.charAt(i) +  "  , " + input.indexOf(input.charAt(i)));
            if ( i + 1<input.length()  && input.indexOf(input.charAt(i)) == input.indexOf(input.charAt(i + 1)) ) {
                p++; //K, K 면
                if (p > 1) {
                    //answer += p;
                    //p = 1;
                }
            } else {
                answer += input.charAt(i);
                if (p > 1) {
                    answer += p;
                    p =1;
                }
            }
        }


        return answer;
    }
}
