package javacore.basic;

import lombok.SneakyThrows;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Ch20 {

    /**
     * thread 활용 기초
     * @param args
     */

    static int sum;

    public static void main(String[] args) throws InterruptedException {

        printCurrentThread();

        Thread t1 = new Thread(() -> {
            //printCurrentThread();
            String threadName = Thread.currentThread().getName();

            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(threadName  + "  count: " + i);

                sum = i;
                //printCurrentThread();
                System.out.println(threadName + " sum: " + sum);

            }
        });

        //t1.setDaemon(true);
        t1.start();
        FutureTask futureTask = new FutureTask<>(new Another());


        Thread t2 = new Thread(futureTask, "callable");
        t2.start();


        try {
            System.out.println("result : " + futureTask.get());
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


        //System.

        //

        t1.interrupt();

        //t1.join(); //t1

        System.out.println("check!!! sum: " + sum);

        for (int i = 0; i < 10; i++) {
            Thread.sleep(1000);
            System.out.println("i count: " + i);
        }
    }

    public static void printCurrentThread() {
        String threadName = Thread.currentThread().getName();
        System.out.println("현재쓰레드: " + threadName );
    }
}


/**
 * 동기랑 비동기의 개념이죠.
 * 그러면 100시간이 걸리는 일이 있어.
 * 그러면 스레드 100개 만들어서 각각 동일한 일의 양을 할당시켜서 실행을 하면.. 1시간 안에 끝나는 거죠.
 * 싱글코어 기준으로 생각을 하면, 결국에는 모든 프로세스는 순서적으로 실행을 해요. 다만
 *
 * 1시간보다 더 걸려요.
 *
 */



class Another implements Callable {
    int sum ;


//    @SneakyThrows
//    @Override
//    public void run() {
//        Ch20.printCurrentThread();
//
//        Thread.sleep(10000);
//
//    }

    @Override
    public Object call() throws Exception {


        for (int i = 0; i < 10; i++) {
            Thread.sleep(1000);
            System.out.println("i2 count: " + i);

            sum = i;
        }

        return sum;
    }
}


