package algo.string;

import java.util.Scanner;

public class Ch9 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        System.out.println(solution(input));
    }

    private static int solution(String input) {

        StringBuilder sb = new StringBuilder();

        char[] chars = input.toCharArray();

        for (char aChar : chars) {
            if (!Character.isAlphabetic(aChar)){
                sb.append(aChar);
            }
        }

        String answer = sb.toString();
        Integer real = Integer.valueOf(answer);
        return real;
    }

}
