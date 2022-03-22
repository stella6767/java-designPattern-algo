package design_pattern.structural.adapter;

import java.io.*;
import java.util.*;

public class AdapterApp {

    /**
     * 구조 관련 패턴
     * 기존 코드를 클라이언트가 사용하는 인터페이스의 구현체로 바꿔주는 패턴
     * @param args
     */
    
    public static void main(String[] args) {
        PersonAdapter adapter = new PersonAdapter(new Person("홍갈동", 100));

        System.out.println(adapter.showAge());
        System.out.println(adapter.showName());

        // 자바에서의 사용예시, 배열을 리스트로 바꿔준다.
        List<String> list = Arrays.asList("a", "b", "c");
        Enumeration<String> enumeration = Collections.enumeration(list);
        ArrayList<String> list2 = Collections.list(enumeration);

        //io /문자열을 넣었는데, InputStream 객체가 반환
        try(InputStream is = new FileInputStream("input.txt")) {

            InputStreamReader reader = new InputStreamReader(is);
            BufferedReader bufferedReader = new BufferedReader(reader);
            while (bufferedReader.ready()){
                System.out.println(bufferedReader.readLine());
            }

        }catch (IOException e){
            throw new RuntimeException(e);
        }

        //스프링에서  사용예시, HandlerAdapter


    }

}
