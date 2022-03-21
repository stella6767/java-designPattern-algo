package algo.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Ch3 {

    /**
     * 크레인 인형뽑기
     */


    static Stack<Character> stack = new Stack<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(stk.nextToken());
        stk = new StringTokenizer(br.readLine());

        for (int i = 0; i< num; i++){

        }



        br.close();

    }


}
