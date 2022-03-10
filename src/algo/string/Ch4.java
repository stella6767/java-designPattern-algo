package algo.string;

import java.util.ArrayList;
import java.util.Scanner;

public class Ch4 {

    public static String solution(ArrayList<String> input){

        String answer = "";
        for (String s : input) {
            char[] chars = s.toCharArray();
            for (char aChar : chars) {
                //역순으로 출력..
            }

        }



        return answer;
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();

        ArrayList<String> arrayList = new ArrayList<>();

        while (cnt>0){
            String s = sc.next();
            arrayList.add(s);
            cnt --;
        }

        solution(arrayList);

       //System.out.println(solution(input));


    }

}
