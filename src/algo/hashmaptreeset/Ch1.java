package algo.hashmaptreeset;

import java.util.*;

public class Ch1 {


    /**
     * 학급 회장 뽑기
     * @param args
     */
    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        String s= sc.nextLine();


        solution(s, n);

    }

    private static void solution(String s, int n) {

        char[] chars = s.toCharArray();
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (char aChar : chars) {
            hashMap.put(aChar, hashMap.getOrDefault(aChar, 0) + 1);
        }

        //System.out.println(hashMap);


        char answer = 0;


        int sum = 0;

        for (Map.Entry<Character, Integer> character : hashMap.entrySet()) {

            if (character.getValue() > sum){
                sum = character.getValue();
                answer = character.getKey();
            }

        }


        System.out.println(answer);


    }


}
