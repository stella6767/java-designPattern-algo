package algo.twopointer;

import java.util.Scanner;

public class Ch5 {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        solution(n);
    }
    private static void solution(int n) {

        int cnt=1, answer =0;

        // n을 m개의 자연수합으로 표현할 때, 1부터 m까지의 수를 n에서 빼고
        // n을 m으로 나눴을 때 0이면 n은 m개의 자연수 합으로 나타낼 수 있다.

        n--;
        while(n>0){
            cnt++;
            n-=cnt;
            if(n%cnt == 0){
                answer++;
            }
        }
        System.out.println(answer);
    }


}
