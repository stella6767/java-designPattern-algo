package algo.hashmaptreeset;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Ch5 {


    /**
     * K번째 큰 수 (문제가 이해가 안 되는데??)
     * 현수는 이 중 3장을 뽑아 각 카드에 적힌 수를 합한 값을 기록하려고 합니다. 3장을 뽑을 수 있는 모든 경우를 기록합니다.
     * 기록한 값 중 K번째로 큰 수를 출력하는 프로그램을 작성하세요.
     * <p>
     * 아 3장을 합한 값 중 가장 큰 수를 출력하라는 말인가?
     */

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        int[] array = new int[n];

        stk = new StringTokenizer(br.readLine());

        for (int i = 0; stk.hasMoreTokens(); i++) {
            int num = Integer.parseInt(stk.nextToken());
            array[i] = num;
        }

        solution(n, m, array);
        br.close();
    }

    private static void solution(int n, int m, int[] array) {

        TreeSet<Integer> treeSet = new TreeSet<>(Comparator.reverseOrder());

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    //treeSet.add(array[i] + array[j] + array[k]);
                    int sum = array[i] + array[j] + array[k];
                    treeSet.add(sum);
                }
            }
        }

        //System.out.println(treeSet);

        int answer = -1;

        int index = 0;
        for (Integer integer : treeSet) {
            if (index == m -1 ){
                answer = integer;
                break;
            }

            index ++;
        }


        System.out.println(answer);
    }

}
