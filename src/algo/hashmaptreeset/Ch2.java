package algo.hashmaptreeset;

import java.util.*;
import java.util.stream.Collectors;

public class Ch2 {

    /**알파벳의 나열 순서를 다르지만 그 구성이 일치하면 두 단어는 아나그램이라고 합니다.
     * 아나그램
     *
     *
     */


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String s1 = sc.nextLine();
        String s2 = sc.nextLine();

        solution(s1, s2);

    }



    private static void solution(String s1, String s2) {

        char[] chars = s1.toCharArray();
        char[] chars2 = s2.toCharArray();

        ArrayList<Character> list = new ArrayList<>();
        ArrayList<Character> list2 = new ArrayList<>();

        for (Character character : chars) {
            list.add(character);
        }

        for (Character character : chars2) {
            list2.add(character);
        }

//        System.out.println(list);
//        System.out.println(list2);


        HashSet<Character> hashSet = new HashSet<>();

        list.sort(Comparator.naturalOrder());
        list2.sort(Comparator.naturalOrder());

        //System.out.println(list2);
        //System.out.println(list);


//
//        //list.addAll(list2);
//        hashSet.addAll(list);
//        //System.out.println(hashSet);
//        list.removeAll(list2);
//        System.out.println(list);

        if (list.equals(list2)){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }

    }


}
