package algo.array;

import java.util.ArrayList;
import java.util.Scanner;

public class Ch2 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();

        int[] array = new int[cnt];

        for (int i=0; i<cnt; i++){
            int j = sc.nextInt();
            array[i] = j;
        }

        solution(array);


    }

    private static Integer solution(int[] input) {

        int cnt = 1, max =  input[0];

        for (int i=1; i<input.length; i++ ){
            if ( input[i] > max){
                cnt ++;
                max = input[i];
            }
        }

        System.out.println(cnt);

        return null;
    }
}
