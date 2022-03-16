package algo.array;

import java.util.*;

public class Ch8 {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();

        int[] list = new int[input];

        for (int i = 0; i < input; i++) {
            int num = Integer.parseInt(sc.next());
            list[i] = num;
        }
        solution(list);
    }

    private static void solution(int[] integers) {


        //list.sort(Comparator.reverseOrder());
        //System.out.print(list);

        //Integer[] integers = list.stream().distinct().toArray(Integer[]::new);

        //method AbstractCollection.<T#3>toArray(T#3[]) is not applicable 채점사이트에서는 안 통하네..

        int[] answerList = new int[integers.length];

        for (int i=0; i< integers.length; i++){
            int cnt = 1;
            for (int j=0; j < integers.length; j++){
                if (integers[j] > integers[i]){
                    cnt ++;
                }
            }
            answerList[i] = cnt;
        }


        for (int i : answerList) {
            System.out.print(i + " ");
        }

    }

}
