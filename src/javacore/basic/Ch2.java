package javacore.basic;

import java.text.DecimalFormat;

public class Ch2 {

    /**
     * 컴퓨터 구성요소 - 중앙처리장치(CPU) - 주기억장치(memory)- 보조기억장치(디스크)
     입출력장치 - 시스템 버스(컴퓨터의 각 구성요소 간의 데이터 신호를 전달하기 위한 데이터 전달 경로)

     * 컴퓨터에 전원이 들어오면 가장 먼저 펌웨어(모든 컴퓨터의 구성요소를 메모리에 저장하여 관리하게 해주는 프로그램) 실행
     *  * -> 운영체제 핵심인 커널을 실행, 커널이란 컴퓨터 자원을 활당하고, 커널의 수행이 완료되면, 쉘이 실행되고 부팅과정이 끝이 남.
     *  * 쉘이란 운영체제의 일부로서, 커널에게 명령을 해석하여, 전달하는 역할
     *  * 부팅만 해도, 커널은 바로 메모리에 올라가 아무것도 안해도 20%정도 실행 주임.
     * * 컴퓨터의 하드웨어와 소프트웨어를 제어하는 것이 OS, 커널(90)과 쉘로 구성됨.
     *          * 카널에 명령을 내리기 위해서는 커널이 이해할 수 있는 언어로 전달해야 하는데, 쉽지 않아요.
     *          * 이때 우리가 전달한 스크립트를 커널이 이해하기 쉽게 해석해주는 역할이 쉘, 일종의 명령줄 인터프리터
     *          * 윈도우의 cmd, linux//unix의 bash  -
     *          * 터미널 - 터미널은 쉘을 이용한다. 인터페이스, 터미널(tv 화면, 쉘- TV 화면에서 실행 중인 프로그램.)
     *
     * 자바는 기본타입(primitive type)과 참조타입(reference type)이 있어요.
     * 기본타입 - 사이즈가 정해져있어요.
     * 참조타입 - 사이즈가 미리 정해져있지 않음. (배열, 열거, 클래스, 인터페이스), new 키워드로 할당, null 할당
     * ,메모리에 두 번 엑세스, 제네릭 타입에서 사용가능
     *
     */



    public static void main(String[] args) {

        int a; //4byte - 32bit
        a = 2_000_000_000;
        long b = 2_000_000_0L; //8byte
        boolean c = true; // 1bit

        //b = a; //묵시적 형변환 (업 캐스팅)
        a = (int) b; //명시적 형변환(다운 캐스팅), 자료유실

        DecimalFormat df = new DecimalFormat("###,###,###");
        //System.out.println(df.format(a));

        //포인터,
        MyData myData = new MyData(); //4byte + 5byte

        //System.out.println(myData.a);
        Object o = a;
        String s = new String("hi");
        callByReference2(s);
        a= 1;
        callByValue(a);
        callByReference(myData);


        System.out.println(a);
        System.out.println(myData.a);
        System.out.println(s);
    }

    static class MyData  {
        int a =1; //4byte
        byte b; // 1byte
    }

    static void callByValue(int a){
        a++;

    }

    static void callByReference(MyData myData){
        //주소값을 직접 넘기는 게 아니라. 주소값을 복사해서 넘기기 때문에, call by value라고 봐야함.
            //C++에서는 메모리 주소를 개발자가 직접적으로 다룰 수 있지만..
        myData.a ++;
    }

    static void callByReference2(String s){
        //주소값을 직접 넘기는 게 아니라. 주소값을 복사해서 넘기기 때문에, call by value라고 봐야함.
        //C++에서는 메모리 주소를 개발자가 직접적으로 다룰 수 있지만..
        s = "test";
    }

}
