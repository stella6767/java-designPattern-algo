package javacore.basic.socket;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Page implements Runnable {
    Socket socket;

    // 생성자
    Page(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {

        // output 스트림 및 버퍼 스트림 생성
        try (BufferedOutputStream bufOut =
                     new BufferedOutputStream(socket.getOutputStream())) {

            // 웹브라우저의 서비스 요청에 대해 응답해줘야 하는 구문
            bufOut.write("HTTP/1.0 200 OK\n".getBytes());
            bufOut.flush();
            bufOut.write("Content-Type: text/html\n\n".getBytes());
            bufOut.flush();

            for (int i = 0; i < 10; i++) {

                bufOut.write("<h1>웹서버에 접속하였습니다.</h1>".getBytes());
                bufOut.flush();
                Thread.sleep(1000);
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("스트림 생성 실패");

        } finally {

            try {
                socket.close();
                System.out.println(socket.getPort()
                        + " 접속이 종료됐습니다.");
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }
}
