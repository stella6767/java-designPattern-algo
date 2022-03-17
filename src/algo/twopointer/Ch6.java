package algo.twopointer;

import java.util.Scanner;

public class Ch6 {

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

    private static void solution(int[] array, int n) {

        //System.out.println(array);

        int cnt =0, lt =0, answer =0;

        for (int rt=0; rt< array.length; rt ++){
            if (array[rt] == 0){
                cnt ++;
            }
            while (cnt > n){
                if (array[lt] == 0){
                    cnt --;
                }
                lt ++;
            }
            answer = Math.max(answer, rt - lt + 1);
        }

        System.out.println(answer);


    }

}
