package algo.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Ch2 {

    static Stack<Character> stack = new Stack<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        String input = stk.nextToken();
        solution(input);

        br.close();

    }

    /**
     * 괄호문자 제거.
     * 
     *
     * @param input
     */


    private static void solution(String input) {

        String answer = "";
        StringBuilder sb = new StringBuilder();

        for (char x : input.toCharArray()) {
            if (x == '(') stack.push(x);
            else if (x ==  ')') {
                stack.pop();
            } else {
                if (stack.isEmpty()){
                    answer += x;
                }
            }
        }

        System.out.println(answer);

    }

}
