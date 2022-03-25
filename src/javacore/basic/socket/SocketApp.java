package javacore.basic.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SocketApp {


    public static void main(String[] args) {

        // 스레드풀 생성
        ExecutorService threadPool = Executors.newCachedThreadPool();

        // 서버 소켓 생성, 8080포트 오픈
        try (ServerSocket serverSoket = new ServerSocket(15000)) {

            // 다수 클라이언트 접속을 위해 루프 구성
            while (true) {

                // 통신 연결, 실패 시 메세지 출력 후 반복문 재실행
                try {
                    Socket socket = serverSoket.accept();

                    // 새로운 스레드로 수행
                    System.out.println(socket.getPort()
                            + " 클라이언트가 연결되었습니다.");
                    threadPool.execute(new Page(socket));

                } catch (IOException soketException) {

                    System.out.print("클라이언트-서버 연결 실패 : ");
                    soketException.printStackTrace();
                    continue;
                }
            }

        } catch (IOException serverSoketException) {
            serverSoketException.printStackTrace();
        }
    }

}
