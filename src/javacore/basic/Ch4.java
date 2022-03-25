package javacore.basic;

import org.openjdk.jol.vm.VM;

public class Ch4 {

    /**
     * JAVA는 call by reference 가 없나?
     * 값을 복사하는 거라 call by value 입니다.
     *
     * 해시함수는 언제나 고정된 길이의 해시값으로 반환.
     *
     * 자바는 메모리 주소 확인이 쉽지 않음.
     * hashcode는 단순리 고유한 개체에 고유한 정수를 반환. 메모리주소로 구현되지는 않습니다.
     * 실제메모리 주소가 아니라, 지정된 위치에서 객체를 가져오기 위한 JVM의 링크.
     * JVM이 메모리 주소가 유동적으로 변경가능. JAVA 언어에서 메모리 주소 확인한다는 게 별 의미 X
     *
     *
     *
     *
     * @param args
     */


    public static void main(String[] args) {

        int a = 10;
        System.out.println("The memory address is " + VM.current().addressOf(a));


        a= callByValueTest(a);

        System.out.println(a);

        Object o;

        MyCh4Data data = new MyCh4Data();

        callByValue2(data);
        System.out.println(data.a);




    }

    private static int callByValueTest(int a) {
        System.out.println("The memory address is a2" + VM.current().addressOf(a));
        a ++;
        return a;
    }

    private static void callByValue2(MyCh4Data data) {
        //주소값을 직접 넘기는 게 아니 , 주소값을 복사해서 새로 메모리 주소에 할당해주고 넘기기 때문에, call by value라고 봐야됨.
        data.a ++;
    }


    static class MyCh4Data{
        int a;
    }


}


