package javacore.basic;

import java.util.Arrays;
import java.util.Comparator;

public class Ch13 {

    /**
     * java.lang.Comparable / java.util.Comparator 사용법
     *
     * [ java.lang.Comparable ]
     * 객체 자신이 가지고 있는 자신의 정렬 기준을 정의하는 인터페이스
     * Arrays.sort() 및 Collection.sort() 메소드의 기준으로 적용
     *
     * [ java.util.Comparator ]
     * Arrays.sort() 및 Collection.sort() 메소드의 기준으로 삽입해주는 정렬 기준을 가진 인터페이스
     *
     * @param args
     */


    public static void main(String[] args) {


        testComparable test1 = new testComparable(1);
        testComparable test2 = new testComparable(5);
        testComparable[] arr = new testComparable[] { test1, test2 };

        System.out.print("정렬 전 : ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i].getA() + " ");
        }

        //Arrays.sort(arr); //NlogN
        Arrays.sort(arr, (o1, o2) -> {
            if (o1.getA() < o2.getA()) {
                System.out.println("\n리턴 : 1");
                return 1;
            }
            System.out.println("\n리턴 : -1");
            return -1;            }); //NlogN

        System.out.print("\n정렬 후 : ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i].getA() + " ");
        }

    }

}
class testComparable implements Comparable<testComparable> {

    private int a;

    public testComparable(int a) {
        super();
        this.a = a;
    }

    @Override
    public int compareTo(testComparable o) {

        if (this.a < o.a) {
            System.out.println("\n리턴값 : 1");
            return 1;
        }

        System.out.println("\n리턴값  : -1");
        return -1;
    }

    public int getA() {
        return a;
    }
}