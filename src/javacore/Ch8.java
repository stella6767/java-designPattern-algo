package javacore;

import org.openjdk.jol.vm.VM;
import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class Ch8 {

    /**
     * 컨텍스트
     * @param args
     */


    static final Unsafe unsafe = getUnsafe(); //자바로 low level 프로그래밍을 할 수 있다?
    //http://younghwannam.blogspot.com/search?q=%5Bjava%5D%5Bthread%5D%5Bunsafe%5D+%EC%9E%90%EB%B0%94%EA%B0%80+%EC%88%A8%EA%B2%A8%EB%86%93%EC%9D%80+%EC%95%85%EB%A7%88%EC%9D%98+%EC%97%B4%EB%A7%A4
    //https://rangken.github.io/blog/2015/sun.misc.unSafe/
    //https://stackoverflow.com/questions/8820164/is-there-a-way-to-get-a-reference-address

    static final boolean is64bit = true;

    public static void main(String[] args) {

        int a = 10;

        Jar jar = new Jar();
        Jar jarContext = jar.getContext();

        Jar jar2 = jarContext;


        /**
         *
         * 힙 영역 메모리 주소만 확인하는 것 같은데..
         * 참조를 기억하는 메모리 주소를 볼려면 어떻게 해야되지??
         *  아 모르겠다..
         */

        System.out.println(VM.current().addressOf(jar));
        System.out.println(VM.current().addressOf(jarContext));
        System.out.println(VM.current().addressOf(a));
        System.out.println(VM.current().sizeOfField(String.valueOf(jarContext)));

        //System.gc();

        System.out.println(jar == jarContext);
        System.out.println(jar.hashCode());
        System.out.println(jarContext.hashCode());
        System.out.println("check jar2: " + jar2.hashCode());

        printAddresses("a", a);
        printAddresses("jar", jar);
        printAddresses("jarContext", jarContext);





        printParameterAddress(jar);


    }


    private static void printParameterAddress(Jar jar){

        printAddresses("jar", jar);
    }


    public static void printAddresses(String label, Object... objects) {
        System.out.print(label + ": 0x");
        long last = 0;
        int offset = unsafe.arrayBaseOffset(objects.getClass());
        int scale = unsafe.arrayIndexScale(objects.getClass());
        switch (scale) {
            case 4:
                long factor = is64bit ? 8 : 1;
                final long i1 = (unsafe.getInt(objects, offset) & 0xFFFFFFFFL) * factor;
                System.out.print(Long.toHexString(i1));
                last = i1;
                for (int i = 1; i < objects.length; i++) {
                    final long i2 = (unsafe.getInt(objects, offset + i * 4) & 0xFFFFFFFFL) * factor;
                    if (i2 > last)
                        System.out.print(", +" + Long.toHexString(i2 - last));
                    else
                        System.out.print(", -" + Long.toHexString( last - i2));
                    last = i2;
                }
                break;
            case 8:
                throw new AssertionError("Not supported");
        }
        System.out.println();
    }

    private static Unsafe getUnsafe() {
        try {
            Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
            theUnsafe.setAccessible(true);
            return (Unsafe) theUnsafe.get(null);
        } catch (Exception e) {
            throw new AssertionError(e);
        }
    }
}
