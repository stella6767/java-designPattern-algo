package javacore.basic.socket;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class ClientSocket {


    public static void main(String[] args) {

        // 서버와 소켓 연결 성공하면 데이터를 받아올 InputStream 생성
        try(Socket socket = new Socket("127.0.0.1", 15000);
            InputStream in = socket.getInputStream()) {

            // 속도 향상을 위해 필터 스트림 사용 (선택사항)
            BufferedInputStream bufIn = new BufferedInputStream(in);

            // 받은 데이터를 저장해줄 바이트 배열
            byte[] dataFromServer = new byte[100];

            // 데이터를 읽어옴
            bufIn.read(dataFromServer);

            // 받은 데이터 출력
            System.out.println(new String(dataFromServer));

        } catch (IOException e) {

            System.out.println("서버 연결에 실패했습니다.");
        }

    }


}
