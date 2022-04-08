package algo.test;

import algo.test2.ImageUtills;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

public class BoardMain {

    //노드
    static int sum = 0;

    private static HttpService service = new HttpService();

    public static void main(String[] args) {
        //ExecutorService threadPool = Executors.newFixedThreadPool(10);

        System.out.println(Thread.currentThread().getName());

        /**
         * 비동기 논블락킹을 구현하기 위해서, 가장 간단하게 멀티스레드 쓰는 거죠.
         * 다른 방법은 싱글스레드로 논블락킹  비동기 하는 거에요.
         *
         * NIO 패키지,
         *
         * 톰캣은 기본적으로
         *
         *
         */


        BoardMain boardMain = new BoardMain();
        boardMain.readBoardTitle();

        ImageUtills imageUtills = new ImageUtills();
        imageUtills.readImageTitle();


////        //멀티쓰레딩
//        Thread thread1 = new Thread(() -> {
//            for (int i = 0; i <100 ; i++) {
//
//                try {
//                    Thread.sleep(100);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//
//                sum++;
//            }
//            callBack.back();
//        });
//
//        thread1.setName("client2");
//        thread1.start();


        //람다식, 자바는 일급시민이 객체


        //Thread thread = new Thread(() -> System.out.println("스레드 실행"));
        //thread.start();


//        try {
//            thread1.join(); //blocking을 거는 거에요.
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }


//        //blocking
//        while (sum < 100){ //long polling
//            try {
//                Thread.sleep(1);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//
//


        System.out.println("sum은?????????? " + sum);

        //프로세스 실행 싱글쓰레드
        // 비동기(순서를 보장하지 않는다)  vs default 동기(순서대로)  //싱글쓰레드 기반.

        //blocking, 3초를 기다리기 싫은데. 순서를 기다리기


        //100개의 스레드로 동일한 일을 처리 // 100개가 더 오래걸려요.
        //1개의 스레드로 동일한 일을 처리 //

        /**
         * 멀티스레드, 동시에, 동시에 하는 건 없어요.
         * CPU는 4코어라고 가정
         *
         *
         * 주임님은 금방 익힘.
         * Non blocking vs Blocking
         * 비동기 vs 동기
         *
         */


//        System.out.println(Thread.currentThread().getName());
//
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        //System.out.println("sum은 " + sum); // 0
    }


    public void readBoardTitle(){



        MyCallBack callBack = new MyCallBack() {
            @Override
            public void back(int sum) {
                System.out.println("보드 결과!! " + sum);
                //read title을 끄집어낸다.
                //100d을 사용하고 싶다.
            }
        };

        Thread thread = new Thread(new FileUtilThread(callBack));
        thread.start();
    }

}



