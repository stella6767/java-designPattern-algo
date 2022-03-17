package algo.twopointer;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ch2 {

    /**
     * https://www.baeldung.com/java-two-pointer-technique
     * 공통 원소 추출
     * two-pointer-algoritm
     *
     * @param args
     */

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] ary1 = new int[n];
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            ary1[i] = num;
        }

        int n2 = sc.nextInt();
        int[] ary2 = new int[n2];

        for (int i = 0; i < n2; i++) {
            int num = sc.nextInt();
            ary2[i] = num;
        }

        solution(ary1, ary2);

    }

    private static void solution(int[] ary1, int[] ary2) {
        //int[] ints = IntStream.concat(IntStream.of(ary1), IntStream.of(ary2)).toArray();
        //List<Integer> collect = Arrays.stream(ints).boxed().collect(Collectors.toList());
        ArrayList<Integer> answer = new ArrayList<>();
        Arrays.sort(ary1);
        Arrays.sort(ary2);
        int p1 = 0, p2 = 0;

        while (p1 < ary1.length && p2 < ary2.length) {
            if (ary1[p1] == ary2[p2]) {
                answer.add(ary1[p1++]);
                p2++;
            } else if (ary1[p1] < ary2[p2]) p1++;
            else p2++;
        }

        for (Integer integer : answer) {

            System.out.print(integer + " ");
        }

        //usingCollectFunction(ary1, ary2);

    }

    private static void usingCollectFunction(int[] ary1, int[] ary2) {

        //https://ddolcat.tistory.com/794
        //시간초과 걸린다..

        List<Integer> collect1 = Arrays.stream(ary1).boxed().collect(Collectors.toList());
        List<Integer> collect2 = Arrays.stream(ary2).boxed().collect(Collectors.toList());
        collect1.retainAll(collect2); //교집합
//        collect1.containsAll(collect2); //부분집합인지 아닌지 boolean 리턴
//        collect1.retainAll(collect2); // 차집합
//        collect1.addAll(collect2);//합집합
//        List<Integer> collect = collect1.stream().distinct().collect(Collectors.toList()); //중복제거


        collect1.sort(Comparator.naturalOrder());

        for (Integer integer : collect1) {
            System.out.print(integer + " ");
        }
    }


}
