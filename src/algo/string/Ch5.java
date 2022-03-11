package algo.string;

import java.util.Scanner;

public class Ch5 {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String input = sc.next();
        solution(input);
    }


    private static void solution(String input) {

        String answer = "";
        char[] chars = input.toCharArray();
        int lt =  0, rt = chars.length -1 ;

        for (char c  : chars) {
            if (Character.isAlphabetic(c)) {
               rt--;
            } else if (!Character.isAlphabetic(c)) {
                lt++;
            }
            char tmp = chars[lt];
            chars[lt] = chars[rt];
            chars[rt] = tmp;
            lt++;
            rt--;


        }
        answer = String.valueOf(chars);
        System.out.println(answer);

    }

}
