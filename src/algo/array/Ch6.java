package algo.array;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ch6 {

    /**
     * 뒤집은 소수
     *
     * 왜 오류가 나는건지..??? 문제를 잘 못 이해했네, 중간에 0은 괜찮.
     */

    public static void main(String[] args) {

        //long startTime = System.currentTimeMillis();
        Scanner sc = new Scanner(System.in);
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int input = sc.nextInt();
        List<String> strings = new ArrayList<>();
        for (int i = 0; i < input; i++) {
            String num = sc.next();
            strings.add(num);
        }
        for (String string : strings) {
            solution(string);
        }

//        long endTime = System.currentTimeMillis();
//        System.out.println();
//        System.out.println("totalTime: " + (endTime - startTime));
    }

    private static void solution(String input) {

        StringBuilder sb = new StringBuilder();
        sb.append(input);
        String s = sb.toString();
        Integer num = Integer.valueOf(s);
        while (num % 10 == 0){

            num = num / 10;
        }

        String s1 = String.valueOf(num);

        StringBuilder sb2 = new StringBuilder();
        sb2.append(s1);

        String answer = sb2.reverse().toString();
        Integer realNum = Integer.valueOf(answer);

        //System.out.print(s + " ");

        boolean isTrue = true;
        if (realNum < 2){
            isTrue = false;
        }
        for (int j = 2; j < realNum; j++) {
            if (realNum % j == 0) {
                isTrue = false;
            }
        }
        if (isTrue){
            System.out.print(realNum +" ");

        }
    }
}
