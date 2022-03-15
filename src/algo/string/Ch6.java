package algo.string;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Ch6 {

    /**
     * 중복문자 제거
     *
     */



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();

        System.out.println(solution(input));
    }

    private static String solution(String input) {

        String answer = "";
        StringBuilder sb = new StringBuilder();


        char[] chars = input.toCharArray();
        // 0,1,2,7
        int a = 0;
        for (int i=0; i< input.length(); i++){
            //System.out.println(input.charAt(i) +  "  , " + input.indexOf(input.charAt(i)));
            if (input.indexOf(input.charAt(i)) == i) answer += input.charAt(i);
        }

        //System.out.println(answer);
        return answer;
    }


}
