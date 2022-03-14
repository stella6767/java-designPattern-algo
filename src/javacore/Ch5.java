package javacore;
import org.openjdk.jol.vm.VM;

public class Ch5 {


    public static void main(String[] args) {

        String str1 = "홍길동"; //리터럴, heap 내부의 constant pool
        String str2 = "홍길동";
        String str3 = new String("홍길동"); //new 키워드를 사용, 같은 내용일지라도 여러개으 객체가 각각 heap 영역을 차지하고 있어요.
        String str4 = new String("홍길동");

        str2 = "김민지"; //값이 변경되면 새로운 메모리 주소에 할당.

        System.out.println("The memory address is " + VM.current().addressOf(str1));
        System.out.println("The memory address is " + VM.current().addressOf(str2));
        System.out.println(str1 == str2);
        System.out.println(str1);

        System.out.println("The memory address is " + VM.current().addressOf(str3));
        System.out.println("The memory address is " + VM.current().addressOf(str4));
        System.out.println(str3.equals(str4));


    }


}
