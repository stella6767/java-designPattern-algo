package algo.test;

public class HttpService {

    //stack, heap, static

    public int return100(){
        int i = 0; //stack // 스레드 동시성을 신경
        for (int j = 0; j < 1000; j++) {
            i++;
        }
        return i;
    }

}
