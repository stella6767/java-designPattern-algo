package algo.array;

import java.util.Scanner;

public class Ch7 {


    /**
     * 점수계산.
     * @param args
     */

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int input = sc.nextInt();

        int[] ints = new int[input];

        for (int i = 0; i < input; i++) {
            int num = Integer.parseInt(sc.next());
            ints[i] = num;
        }

        solution(ints);


    }

    private static void solution(int[] list) {
        int totalScore = 0;
        int index = 0;
        int j = 1;


        for (int a : list) {
            if (index == 0 && a == 1){
                totalScore = 1;
            }else if (a == 1){
                totalScore = totalScore + j;
            }else{
                j = 0;
            }
            index ++;
            j ++;
        }

        System.out.print(totalScore);

    }

}
