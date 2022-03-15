package algo.string;

import java.util.Scanner;

public class Ch8 {

    /**
     * 펠린드롬
     *
     * 검사할 때, 알파벡만 가지고, 검사. 대소문자를 구분하지 않음.
     * @param args
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        System.out.println(solution(input));
    }

    private static String solution(String input) {
        String answer = "";

        StringBuilder sb = new StringBuilder();
        char[] chars = input.toCharArray();
        for (char aChar : chars) {
            if (Character.isAlphabetic(aChar)){
                sb.append(Character.toUpperCase(aChar));
            }
        }
        String s = sb.toString();
        String reverse = sb.reverse().toString();
        //System.out.println(reverse);

        if (reverse.equals(s)){
            answer = "YES";
        }else{
            answer = "NO";
        }
        return answer;
    }

}
