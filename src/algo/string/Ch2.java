package algo.string;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ch2 {

    public static String solution(String input){

        char[] chars = input.toCharArray();

        StringBuilder sb = new StringBuilder();

        for (char c : chars) {
            if (Character.isLowerCase(c)) {
                sb.append(Character.toUpperCase(c));
            }
            else{
                sb.append(Character.toLowerCase(c));
            }
        }

        return sb.toString();
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String input = sc.next();

        System.out.println(solution(input));


    }

}
