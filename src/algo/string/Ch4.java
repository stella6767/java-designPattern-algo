package algo.string;

import java.util.ArrayList;
import java.util.Scanner;

public class Ch4 {

    public static void solution(ArrayList<String> input){

        String answer = "";
        for (String s : input) {

            StringBuilder sb = new StringBuilder();
            sb.append(s);
            reverse(sb);
        }
    }

    public static void reverse(StringBuilder sb){
        String s = sb.reverse().toString();
        System.out.println(s);
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
    }

}
