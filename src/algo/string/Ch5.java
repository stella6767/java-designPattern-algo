package algo.string;

import java.util.Scanner;

public class Ch5 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        System.out.println(solution(input));
    }


    private static String solution(String input) {
        //a#b!GE*T@S

        String answer = "";
        char[] chars = input.toCharArray();
        int lt =  0, rt = chars.length -1 ;

        while (lt < rt){
            if (!Character.isAlphabetic(chars[lt])) {
                lt++;
            } else if (!Character.isAlphabetic(chars[rt])) {
                rt --;
            }
            else {
                //배열의 양 끝에서 알파벳일 때만 교환.
                char tmp = chars[lt];
                chars[lt] = chars[rt];
                chars[rt] = tmp;
                lt++;
                rt--;
            }
        }
        answer = String.valueOf(chars);
        return answer;
    }

}
