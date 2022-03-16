package algo.array;

import java.util.ArrayList;
import java.util.Scanner;

public class Ch10 {


    /**
     * 가장자리는 0으로 가정.
     * 각 격자판의 숫자 중 자신의 상하좌우 숫자보다 큰 숫자는 봉우리 지역입니다. 봉우리 지역이 몇 개 있는 지 알아내자
     * <p>
     * 1,1  > 0,0   0,1   0,2  2,0  2,1  2,2   1,0   1,1  1,2
     *
     * @param args
     */


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        int[][] list = new int[input + 2][input + 2];

        for (int i = 1; i < input+1; i++) {
            for (int j = 1; j < input+1; j++) {
                int num = Integer.parseInt(sc.next());
                list[i][j] = num;
            }
        }
        solution(input, list);
    }




    private static void solution(int input, int[][] list) {

//        list = [[0, -1], [0, 1], [-1, 0], [1, 0]]
//        for int i = 0; i < len(list)

//        for (int[] ints : list) {
//            for (int anInt : ints) {
//                System.out.println(anInt);
//            }
//        }

        //print2DArray(list);

        //System.out.println();
        //System.out.println(">>>" + list[2][3]); // ?? 1이 나와야 되는데??


        int[][] array = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
        ArrayList<Integer> topList = new ArrayList<>();

        int judge = 0;
        int cnt = 0;

        for (int i = 1; i < input+1; i++) {
            for (int j = 1; j < input+1; j++) {
                int tmp = 0;
                judge = list[i][j];
//                tmp = list[i][j - 1]; //상
//
//                judge = judge > tmp ? judge : tmp;
//
//                tmp = list[i][j + 1]; //하
//                tmp = list[i - 1][j]; //좌
//                tmp = list[i + 1][j]; //우
                for (int k = 0; k < array.length; k++) {
                    int y = array[k][0];
                    int x = array[k][1];
                    int check = list[i + x][j + y];
                    if (judge <= check) {
                        tmp = 1;
                        break;
                    }
                }

                if (tmp == 0){
                    cnt ++;
                }
            }
        }

        //System.out.println("봉우리 개수 => " + cnt);
        System.out.println(cnt);

    }

    private static void print2DArray(int[][] list) {
        System.out.println();
        for (int i = 0; i < list.length; i++) {
            int[] inArr = list[i];
            for (int j = 0; j < inArr.length; j++) {
                System.out.print(inArr[j] + " ");
            }
            System.out.println();
        }
    }
}
