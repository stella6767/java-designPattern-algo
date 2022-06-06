package javacore.basic;

public class Ch23 {

    String[] s = {"Hello", "Oraclejavacommunity"};


    public static void main(String[] args) {

        Runtime r = Runtime.getRuntime();

        // JVM에서 이용가능한 코어 개수를 리턴
        System.out.println("No of CPU Core : " + r.availableProcessors());
        System.out.println("Total memory: " + r.totalMemory());
        System.out.println("Free memory: " + r.freeMemory());



        for (int i = 0; i <= 100000; i++) {
            new Ch23();
        }

        System.out.println("객체생성 이후 ..............");

        System.out.println("Total memory: " + r.totalMemory());

        System.out.println("Free memory: " + r.freeMemory());



        r.gc();

        System.out.println("GC 이후 ..............");
        System.out.println("Total memory: " + r.totalMemory());
        System.out.println("Free memory: " + r.freeMemory());
    }

}
