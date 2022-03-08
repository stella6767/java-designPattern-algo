package algo;

import java.util.Stack;

public class StackAlgo {
    Stack<Character> stack = new Stack<>();

    public String solution1(String str){
        String answer = "YES";

        for (char x : str.toCharArray()) {
            if (x == '(') stack.push(x);
            else{
                if (stack.isEmpty()) return "NO";
                stack.pop();
            }
        }
        if (!stack.isEmpty()) return "NO";
        return answer;
    }

    //입력 문자열에서 소괄호 () 사이에 존재하는 모든 문자를 제거하고. 남은 문자만 출력
    public String solution2(String str){
        String answer = "";
        for (char x : str.toCharArray()) {
            if (x == '(') stack.push(x);
            
            else{
                if (stack.isEmpty()) return "NO";
                stack.pop();
            }
        }
        if (!stack.isEmpty()) return "NO";
        return answer;
    }


    public static void main(String[] args) {

        StackAlgo algo = new StackAlgo();

        System.out.println( "올바른 괄호인가? " + algo.solution1("(((()))"));


    }

}
