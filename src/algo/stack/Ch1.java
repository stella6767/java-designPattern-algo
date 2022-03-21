package algo.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Ch1 {
    static Stack<Character> stack = new Stack<>();

    public static String solution1(String str) {
        String answer = "YES";

        for (char x : str.toCharArray()) {
            if (x == '(') stack.push(x);
            else {
                if (stack.isEmpty()) return "NO";
                stack.pop();
            }
        }
        if (!stack.isEmpty()) return "NO";
        return answer;
    }

    //입력 문자열에서 소괄호 () 사이에 존재하는 모든 문자를 제거하고. 남은 문자만 출력
    public String solution2(String str) {
        String answer = "";
        for (char x : str.toCharArray()) {
            if (x == '(' || x == ')') stack.push(x);
            else {
                if (stack.isEmpty()) return "NO";
                stack.pop();
            }
        }
        if (!stack.isEmpty()) return "NO";
        return answer;
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        String input = stk.nextToken();
        System.out.println(solution1(input));

        br.close();

    }

}
