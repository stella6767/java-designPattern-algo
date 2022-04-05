package javacore.basic;

import java.util.concurrent.*;

public class Ch9 {

    /**
     * Thread를 직접 생성해서 쓰기 보다는, 자바에서 제공하는 스레드풀을 사용하는 게 좋다. (util.concurrent)
     * thread를 만든다는 것은 JVM이 OS에게 스레드 실행에 필요한 자원을 할당받는다는 의미이므로, JVM 내에서 실행되는 게
     * 아니라 상대적으로 더 많은 자원을 소모한다. 그래서 자바 utill 패키지를 활용해 필요한 스레드 묶음을 만들고, 재활용해가며 작업을 할당하자.
     *
     * Task는 Queue로 관리된다. ThreadPool에 있는 Thread수보다 Task가 많으면, 미실행된 Task는 Queue에 저장되고,
     * 실행을 마친 Thread로 할당되어 순차적으로 수행된다.
     *
     * CachedThreadPool
     * - 쓰레드를 캐싱하는 쓰레드풀 (일정시간동안 쓰레드를 검사하여 60초동안 작업이 없으면 Pool에서 제거한다.)
     * - CachedThreadPool은 쓰레드수가 폭발적으로 증가할 수 있다는 단점이 있다. Thread의 제한 없이 무한정 생성하고, 해당 쓰레드의 작업이 60초간 없을 경우 Pool에서 제거하는 방식이기 때문에 작업이 계속적으로 쌓이는 환경에서는 해당 Thread가 소멸되는 것보다, 생성되는 양이 더 많을 것
     * FixedThreadPool
     * - 고정된 개수를 가진 쓰레드풀
     * - fixedThreadPool을 생성할때, 해당 머신의 CPU코어수를 기준으로 생성하면 더 좋은 퍼포먼스를 얻을 수 있다.
     * SingleThreadExecutor
     * - 한 개의 쓰레드로 작업을 처리하는 쓰레드풀 (TaskPool?)
     * = 싱글 쓰레드의 작업을 처리할때 고려해야 할 race-condition이라던지 하는 부분들을 알아서 처리
     *
     *
     * thread safe을 보장하나?
     * https://stackoverflow.com/questions/1702386/is-executorservice-specifically-threadpoolexecutor-thread-safe
     * 읽어봤는데, 질문이 포괄적이라 보장은 못하지만, 일반적으로는 safe하다는 뜻인듯..
     *
     * @param args
     */


    public static void main(String[] args) {

        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        /**
         * void execute(Runnable command) : Runnable 객체로 스레드 동작, (작업처리결과 반환 X)
         * Future<T> submit(Callable<T> task) : Runnable 또는 Callable 객체로 스레드 동작 (스레드 동작에 대한 반환값이 있음. 또한 스레드 실행 중 예외가 발생해도
         * 스레드를 삭제하지 않고 다시 재사용해 오버헤드를 줄일 수 있음. 예외처리로직이 디펄트로 구현되어있음.. Runnable을 인자로 받을 수도 있지만, 일반적으로 Callable)
         */

        threadPool.execute(Ch9::run);


        Future<String> submitResult = threadPool.submit(() -> {

            Thread.sleep(500);

            return "callable return";
        });

        try {
            System.out.println(submitResult.get()); //ThreadPool을 사용시 Thread.join()을 get()으로 대체
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }


        System.out.println("흠..");


        /**
         * 먼저 종료되는 스레드 순으로 작업 처리하기 - ExecutorCompletionService
         */


        ExecutorCompletionService<String> completionService = new ExecutorCompletionService<>(threadPool);

        completionService.submit(() -> {
            Thread.sleep(2000);
            return  Thread.currentThread().getName() +  ": 2초를 기다리다." ;
        });

        completionService.submit(() -> {
            Thread.sleep(1000);
            return Thread.currentThread().getName() + ":  1초를 기다리다.";
        });

        int i = 0;
        while (true){

            try {
                // 먼저 끝나는 스레드의 결과를 담아줌
                Future<String> take = completionService.take();
                System.out.println(take.get());
                i++;
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
                break;

            }

            // 결과가 두 개 이상 쌓이면 종료
            if(i > 1)
                break;

        }




        /**
         * 스레드풀은 데몬 스레드가 아님, 주 스레드가 종료되면 같이 종료되지 않음.. shutdown 꼭 해주자.
         */

        threadPool.shutdown(); //현재 실행중인 작업이 끝나고 스레드풀 종료
        //threadPool.shutdownNow(); //즉시 종료
    }

    private static void run() {
        try {
            Thread.sleep(1000); //callable과 달리 예외처리 내가 구현해줘야됨..
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("runnable thread");
    }
}
