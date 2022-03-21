package algo.hashmaptreeset;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Ch3 {


    /**
     * 매출액의 종류
     *
     * @param args
     */

    /**
     *
     * 투 포인터 = 어떤 특정조건을 만족하는 연속구간을 구할 때 O(N)으로 풀 수 있도록 도와주는 알고리즘
     * 투포인터 알고리즘 문제의 유형
     * 포인터 2개가 같은 방향으로 진행하는것
     * 포인터 2개가 양끝에서 시작하여 반대로 진행하는 것
     * 포인터 하나는 한쪽 방향으로만 진행하고, 다른 포인터는 양쪽으로 이동하는 것
     *
     *
     * 슬라이딩 윈도우 = 투 포인터 알고리즘은 부분 배열의 길이가 가변적이지만 슬리이딩 윈도우 알고리즘은 부분 배열의 길이가 고정적
     * 3 4 4 3
     *
     */


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());


        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());
        int[] array = new int[n];

        stk = new StringTokenizer(br.readLine());

        for (int i = 0; stk.hasMoreTokens(); i++) {
            int next = Integer.parseInt(stk.nextToken());
            array[i] = next;
        }

        solution3(array, m);


    }


    private static void solution3(int[] array, int m) {


        List<Integer> answer = new ArrayList<>();
        HashMap<Integer, Integer> map=new HashMap<>();


        int lt=0;
        //getOrDefault 찾는 키가 존재한다면 찾는 키의 값을 반환하고 없다면 기본 값을 반환하는 메서드
        for(int i=0;i<m-1;i++) {
            map.put(array[i], map.getOrDefault(array[i], 0)+1);
        }

        //System.out.println(map);

        //j =3 ?

        for(int j=m-1; j< array.length; j++) {
            map.put(array[j], map.getOrDefault(array[j], 0)+1);
            answer.add(map.size());
            map.put(array[lt], map.get(array[lt])-1);
            if(map.get(array[lt])==0)map.remove(array[lt]);
            lt++;
        }

        //j가 가고,  lt가 쫒아가면,


        for (Integer integer : answer) {
            System.out.print(integer + " ");
        }

    }




        private static void solution(int[] array, int m) {

        /**
         * 또 시간복잡도..
         */

        HashSet<Integer> hashSet = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            hashSet.clear();
            for (int j = i; j < m + i; j++) {
                if (j == array.length) break;
                hashSet.add(array[j]);
            }
            if (i <=array.length - m) {
                list.add(hashSet.size());
            }
        }

        for (Integer integer : list) {
            System.out.print(integer + " ");
        }

    }





    private static void solution2(int[] array, int m) {


        HashSet<Integer> hashSet = new HashSet<>();
        List<Integer> list = new ArrayList<>();


        //요것도 시간복잡도..
        int index = 0;
        for (int i = 0; i <m ; i++) {

            if (i == array.length) break;
            hashSet.add(array[i]);
            while (i == (m - 1)){
                i = index;
                m ++;
                list.add(hashSet.size());
                hashSet.clear();
                index ++;
            }
        }


        for (Integer integer : list) {
            System.out.print(integer + " ");
        }



    }

}
