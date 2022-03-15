package algo.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static kotlin.reflect.jvm.internal.impl.builtins.StandardNames.FqNames.list;

public class Ch4 {

    /**
     * 파보나치 수열
     * @param args
     */
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();

        solution(input);
    }

    private static Integer solution(int input) {

        int[] ints = new int[input];

        ints[0] = 1;
        ints[1] = 1;

        for (int i=2; i<input; i++){
            ints[i] = ints[i-2] + ints[i-1];
        }

        for (int anInt : ints) {
            System.out.print(anInt + " ");
        }

        return null;
    }

}
