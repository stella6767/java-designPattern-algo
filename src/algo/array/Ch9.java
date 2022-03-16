package algo.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Ch9 {

    /**
     * 2차원 배열.
     */


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();

        int[][] list = new int[input][input];

        for (int i = 0; i < input; i++) {
            for (int j=0; j< input; j++){
                int num = Integer.parseInt(sc.next());
                list[i][j] = num;
            }
        }
        solution(input, list);
    }

    private static void solution(int input, int[][] list) {

        /**
         * 각 행의 합, 각 열의 합, 두 대각선의 합. 중 가장 큰 합
         * 대각선은? 0,0  1,1, 2,2 3,3  4,4
         * 4,0 , 3,1  2,2   1,3,  0,4       (width - 1) - i, j
         */
        ArrayList<Integer> answerList = new ArrayList<>();
        //int j = 0;
        int cnt = 0;
        int reverseCnt = 0;

        int tmp = 0;

        for (int i = 0; i < input; i++) {
            int column = 0;
            int row = 0;
            for (int j=0; j< input; j++){
                column = list[i][j] + column;
                row = list[j][i] + row;

                if (j == i){
                    cnt = list[i][j] + cnt;
                    //System.out.println("cnt==>" + cnt);
                }
                if (i +j == input){
                    reverseCnt = list[i][j] + reverseCnt;
                    //System.out.println("reverseCnt==>" + reverseCnt);
                }
            }

            answerList.add(row);
            answerList.add(column);

            tmp = tmp < row ? row: tmp;
            tmp = tmp < column ? column: tmp;

        }
        tmp = tmp < cnt ? cnt: tmp;
        tmp = tmp < reverseCnt ? reverseCnt: tmp;

        answerList.add(reverseCnt);
        answerList.add(cnt);
        answerList.sort(Collections.reverseOrder());
        System.out.println(answerList.get(0));
        System.out.println(tmp);

    }


}
