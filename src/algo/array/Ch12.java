package algo.array;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ch12 {


    /**
     * 멘토링 - 1째 줄에, 수학점
     * 만약 A학생이 멘토이고, B학생이 멘티가 되는 짝이 되었다면, A학생은 M번의 수학테스트에서 모두 B학생보다 등수가 앞서야 합니다.
     * M번의 수학성적이 주어지면 멘토와 멘티가 되는 짝을 만들 수 있는 경우가 총 몇 가지 인지 출력하는 프로그램을 작성하세요.
     * 만약 한 줄에 N=4이고, 테스트 결과가 3 4 1 2로 입력되었다면 3번 학생이 1등, 4번 학생이 2등, 1번 학생이 3등, 2번 학생이 4등을 의미
     *
     * y = 시험개수
     * x = 시험등수
     * 포기!!!
     *
     * @param args
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input1 = sc.nextInt();
        int input2 = sc.nextInt();

        int[][] list = new int[input2][input1];

        for (int i = 0; i < input2; i++) {
            for (int j = 0; j < input1; j++) {
                int num = Integer.parseInt(sc.next());
                list[i][j] = num;
            }
        }
        solution(list, input1, input2);
    }

    private static void solution(int[][] list, int input1, int input2) {
        //Cmmon.print2DArray(list);
        ArrayList<Integer> tempList = new ArrayList<>();

        for (int i= 0; i <list.length; i++){
            int top = list[i][0];
            for (int j=0; j< list.length; j++){
                for (int k=0; k< list.length; k++){
                    int pi = 0, pj = 0;
                    if (list[i][k] < top){


                    }

                }
            }
        }



    }

//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int N = sc.nextInt();
//        int M = sc.nextInt();
//
//        int[][] arr = new int[M][N];
//        for(int i = 0; i < M; i++) {
//            for(int j = 0; j < N; j++) {
//                arr[i][j] = sc.nextInt();
//            }
//        }
//
//        List[] mt = new List[N+1];
//        mt[0] = new ArrayList<Integer>();
//        List<Integer> tempList = new ArrayList<Integer>();
//        for (int i = N - 1; i >= 0; i--) {
//            mt[arr[0][i]] = new ArrayList<Integer>();
//            tempList.add(arr[0][i]);
//            mt[arr[0][i]].addAll(tempList);
//        }
//
//        for(int i = 0; i < M; i++) {
//            List<Integer> tempList2 = new ArrayList<Integer>();
//            for(int j = N - 1; j >= 0; j--) {
//                tempList2.add(arr[i][j]);
//                mt[arr[i][j]].retainAll(tempList2);
//            }
//        }
//
//        int answer = -N;
//        for (List a : mt) {
//            answer += a.size();
//        }
//
//        System.out.println(answer);
//    }


}
