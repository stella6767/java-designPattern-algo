package algo.twopointer;

import java.util.Scanner;

public class Ch3 {

    /**
     *
     *  연속된 N일간의 최대 매출액은
     */

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] array = new int[n];
        int n2 = sc.nextInt();

        for (int i=0; i <n; i++){
            int num = sc.nextInt();
            array[i] = num;
        }

        solution(array, n);

    }

    private static void solution(int[] array, int n) {

        



    }

}
