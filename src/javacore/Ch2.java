package javacore;

import java.text.DecimalFormat;

public class Ch2 {

    /**
     * .java 파일들이 모여있는 폴더를 패키지.
     * .src 는 .java의 소스파일이 있는 곳. 사람이 이해할 수 있는 코드
     *
     * 자바는 기본타입(primitive type)과 참조타입(reference type)이 있어요.
     * 기본타입 - 사이즈가 정해져있어요. call by value
     * 참조타입 - 사이즈가 미리 정해지지 않고 동적으로 정해집니다. (배열, 열거, 클래스, 인터페이스), new 키워드로 할당
     */


    public static void main(String[] args) {

        int a = 20_000_000_00; //4byte - 32bit

        long b = 20_000_000_0L; //8byte

        DecimalFormat df = new DecimalFormat("###,###,###");

        //b = a; // 묵시적 형변환 (업 캐스팅)
        a = (int) b; // 명시적 형변환(다운 캐스팅) 자료유실

        System.out.println(df.format(a));

        MyDate myDate = new MyDate();
        

    }


    static class MyDate {
        int a; //4byte
        byte b; //1byte
    }

}
