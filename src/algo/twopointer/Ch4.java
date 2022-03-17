package algo.twopointer;

import java.util.ArrayList;
import java.util.Scanner;

public class Ch4 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];
        int n2 = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            array[i] = num;
        }
        //solutionTimeLimitExceed(array, n2);

        solution(array, n2);
    }


    /**
     * 요것도 시간복잡도 생각해야겠네..
     * for문을 한 번만 돌려서..
     *
     * @param array
     * @param n
     */


    private static void solution(int[] array, int n) {

        int cnt = 0;
        int sum = 0;
        int p1 = 0;

        boolean isRun = false;

        for (int i = 0; i < array.length; i++) {
            sum += array[i];

            if (sum == n) {
                cnt++;
//                sum = 0;
//                ++ p1;
//                i = p1;
            }

//            else if (i == array.length - 1 && cnt == 0) {
//                i = 0;
//                sum = 0;
//            }

            while(sum >= n){
                sum -= array[p1];
                p1++;

                if(sum == n){
                    cnt ++;
                }
            }
        }


//        while (p1 < ary1.length && p2 < ary2.length) {
//            if (ary1[p1] == ary2[p2]) {
//                answer.add(ary1[p1++]);
//                p2++;
//            } else if (ary1[p1] < ary2[p2]) p1++;
//            else p2++;
//        }


        System.out.println(cnt);

    }

    private static void solutionTimeLimitExceed(int[] array, int n) {

        int cnt = 0;

        for (int i = 0; i < array.length; i++) {
            int check = 0;
            for (int j = i; j < array.length; j++) {
                check += array[j];

                if (check == n) {
                    cnt++;
                    break;
                }
            }
        }

        System.out.println(cnt);

    }


}
