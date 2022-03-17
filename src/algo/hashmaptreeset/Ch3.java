package algo.hashmaptreeset;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Ch3 {


    /**
     * 매출액의 종류
     *
     * @param args
     */

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            int next = sc.nextInt();
            array[i] = next;
        }

        solution2(array, m);
    }

    private static void solution(int[] array, int m) {

        HashSet<Integer> hashSet = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            hashSet.clear();
            for (int j = i; j < m + i; j++) {
                if (j == array.length) break;
                hashSet.add(array[j]);
            }
            if (i <=array.length - m) {
                list.add(hashSet.size());
            }
        }

        for (Integer integer : list) {
            System.out.print(integer + " ");
        }

    }



    private static void solution2(int[] array, int m) {

        /**
         * 또 시간복잡도..
         */

        HashSet<Integer> hashSet = new HashSet<>();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < array.length; i++) {
            hashSet.clear();
            for (int j = i; j < m + i; j++) {
                if (j == array.length) break;
                hashSet.add(array[j]);
            }

            if (i <=array.length - m) {
                list.add(hashSet.size());
            }

        }

        for (Integer integer : list) {

            System.out.print(integer + " ");
        }

    }

}
