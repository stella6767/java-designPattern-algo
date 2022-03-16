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
        //ArrayList<MyData> arrayList = new ArrayList<>();
        ArrayList<Integer> rowList = new ArrayList<>();
        ArrayList<Integer> columList = new ArrayList<>();
        ArrayList<Integer> judgeList = new ArrayList<>();

        ArrayList<Integer> answerList = new ArrayList<>();
        //int j = 0;
        int cnt = 0;
        int reverseCnt = 0;

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

//            System.out.println(row);
//            System.out.println(column);
            //System.out.println("cnt==>" + cnt + "  , reverseCnt==>" + reverseCnt);
            rowList.add(row);
            columList.add(column);
            answerList.add(row);
            answerList.add(column);

        }
        answerList.add(reverseCnt);
        answerList.add(cnt);

        //System.out.println("cnt==>" + cnt + "  , reverseCnt==>" + reverseCnt);

        rowList.sort(Collections.reverseOrder());
        answerList.sort(Collections.reverseOrder());
        columList.sort(Collections.reverseOrder());

        //System.out.println(rowList);
        //System.out.println(columList);

        judgeList.add(rowList.get(0));
        judgeList.add(columList.get(0));
        judgeList.add(reverseCnt);
        judgeList.add(cnt);

        judgeList.sort(Collections.reverseOrder());

        //System.out.println(judgeList);

        System.out.println(answerList.get(0));

    }


    static class MyData {
        int column;
        int row;

        public MyData(int column, int row) {
            this.column = column;
            this.row = row;
        }

        @Override
        public String toString() {
            return "MyData{" +
                    "column=" + column +
                    ", row=" + row +
                    '}';
        }
    }

}
