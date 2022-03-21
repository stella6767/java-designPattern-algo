package algo.stack;

import algo.array.Cmmon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Ch3 {

    /**
     * 크레인 인형뽑기 (KAKAO)
     *
     * 게임 화면의 격자의 상태가 담긴 2차원 배열 board와 인형을 집기 위해 크레인을 작동시킨 위치가 담긴 배열 moves가 매개변수로 주어질 때,
     * 크레인을 모두 작동시킨 후 터트려져 사라진 인형의 개수를 구하는 프로그램을 작성하세요.
     *
     * 크레인은 멈춘 위치에서 가장 위에 있는 인형.
     *
     * 문제는 쉬운 것 같은데.. 뇌정지 오네..
     *
     */


    static Stack<Character> stack = new Stack<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(stk.nextToken());

        int[][] array = new int[num][num];


        for (int i = 0; i< num; i++){
            stk = new StringTokenizer(br.readLine());
            for (int j = 0; stk.hasMoreTokens(); j++) {
                int value = Integer.parseInt(stk.nextToken());
                array[i][j] = value;
            }
        }


        stk = new StringTokenizer(br.readLine());
        int num2 = Integer.parseInt(stk.nextToken());

        int[] array2 = new int[num2];

        stk = new StringTokenizer(br.readLine());
        for (int k = 0; stk.hasMoreTokens(); k++) {
            int value = Integer.parseInt(stk.nextToken());
            array2[k] = value;
        }

        solution(array, array2);

        br.close();

    }

    private static void solution(int[][] array, int[] array2) {
        //Cmmon.print2DArray(array);
        //Cmmon.print1DArray(array2);

        for (int i = 0; i< array2.length; i++){
            int crain = array2[i];

        }


        for (int i = 0; i < array.length; i++) {
            int[] inArr = array[i];
            for (int j = 0; j < inArr.length; j++) {



                System.out.print(inArr[j] + " ");
            }
        }

    }


}
