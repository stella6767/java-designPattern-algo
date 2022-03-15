package algo.string;

import java.util.Scanner;

public class Ch10 {

    /**
     * 가장 짧은 문자거리
     *
     * 머리가 안 돌아가네..
     * @param args
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        System.out.println(solution(input));

    }

    private static String solution(String input) {

        String[] s = input.split(" ");
        String target = s[0];
        String standDard = s[1];
        char[] chars = target.toCharArray();
        //int[] ints = new int[chars.length];
        StringBuilder sb = new StringBuilder();

        int k = 1000;
        for (int i = 0; i < chars.length; i++) {

            if (chars[i] == standDard.charAt(0)) {
                k = 0;
                sb.append(k);

            } else {
                k++;
                sb.append(k);
            }
        }

        k = 1000;
        for (int i = chars.length; i >= 0; i--) {

            if (chars[i] == standDard.charAt(0)) {
                k = 0;
            } else {
                k++;
                sb.append(k);
            }
        }


        String s1 = sb.toString();
        System.out.println(s1);

        return null;
    }
}
