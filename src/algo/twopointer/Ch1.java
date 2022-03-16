package algo.twopointer;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ch1 {

    /**
     * 두 배열 합치기
     * @param args
     */
    
    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] ary1 = new int[n];
        for (int i=0; i <n; i++){
            int num = sc.nextInt();
            ary1[i] = num;
        }

        int n2 = sc.nextInt();
        int[] ary2 = new int[n2];

        for (int i=0; i <n2; i++){
            int num = sc.nextInt();
            ary2[i] = num;
        }

        solution(ary1, ary2);

    }

    private static void solution(int[] ary1, int[] ary2) {

        int[] ints = IntStream.concat(IntStream.of(ary1), IntStream.of(ary2)).toArray();



        List<Integer> collect = Arrays.stream(ints).boxed().collect(Collectors.toList());

        collect.sort(Comparator.naturalOrder());
        for (Integer integer : collect) {
            System.out.print(integer + " ");

        }


    }

}
