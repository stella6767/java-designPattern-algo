package algo.array;

import java.util.ArrayList;
import java.util.Scanner;

public class Ch1 {



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();

        int[] array = new int[cnt];

        for (int i=0; i<cnt; i++){

            int j = sc.nextInt();
            array[i] = j;
        }

        for (Integer integer : solution(array)) {
            System.out.print(integer + " ");
        }
    }

    private static ArrayList<Integer> solution(int[] input) {

        ArrayList<Integer> list = new ArrayList<>();
        list.add(input[0]);
        for (int i=1; i<input.length; i++ ){
            if (input[i] > input[i-1]){
                list.add(input[i]);
            }
        }
        return list;
    }

}
