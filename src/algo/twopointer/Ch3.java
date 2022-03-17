package algo.twopointer;


import java.util.*;
import java.util.stream.Collectors;

public class Ch3 {

    /**
     * 연속된 N일간의 최대 매출액은
     */

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] array = new int[n];
        int n2 = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            array[i] = num;
        }
        //solution(array, n2);
        //test2(array, n2);
        test3(array, n2);
        //timeLimitExceed(array, n2);

    }

    /**
     * 홀짝
     */


    private static void test3(int[] array, int n) {

        int answer = 0;
        int sum = 0;


//        List<Integer> collect = Arrays.stream(array).boxed().collect(Collectors.toList());
//        collect.add(0);

        for (int i = 0; i < n; i++) {
            sum += array[i];
        }

        //System.out.println(sum);
        answer = sum;

        for (int i = 0; i < array.length ; i++) {
            if (i + n == array.length) break;
            //sum += collect.get(i + 1) - collect.get(i - 1);
            sum += array[i+n] - array[i];
            answer = Math.max(sum, answer);
        }

        System.out.println(answer);

    }

    private static void test2(int[] array, int n) {

        int answer = 0;

//        for (int i = n; i < array.length; i++) {
//            int sum = Arrays.stream(Arrays.copyOfRange(array, i-n, i)).sum();
//            //System.out.println("sum => " + sum);
//            if (answer < sum){
//                answer = sum;
//            }
//        }
//
//        System.out.println(answer);

    }

    private static void timeLimitExceed(int[] array, int n) {

        int answer = 0;

        for (int i = 0; i < array.length; i++) {
            int sum = 0;
            //3까지..
            for (int j = i; j < i + n; j++) {
                if (j == array.length) {
                    break;
                }
                int current = array[j];
                sum += current;
            }
            //System.out.println("sum =>>" + sum);

            if (sum > answer) {
                answer = sum;
            }
        }

        System.out.println(answer);
    }

}
