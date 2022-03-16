package algo.array;

import java.util.Scanner;

public class Ch5 {


    /**
     * 에라토스테네스의 채
     * @param args
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();

        solution(input);
    }

    private static void solution(int input) {

        int[] ints = new int[input + 1];

        //일단 2의 배수는 소수가 아님, 1과 자기자신만으로 나뉘는 수
        int answer = 0;

        for (int i=2; i<= input; i++){
            if (ints[i] == 0){
                answer ++;
                for(int j =i; j <= input; j=j+i){
                    ints[j] = 1;
                }
            }

        }


        System.out.println(answer);

    }


}
