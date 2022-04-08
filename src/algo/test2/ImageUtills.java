package algo.test2;

import algo.test.FileUtilThread;
import algo.test.MyCallBack;

public class ImageUtills {


    public void readImageTitle(){
        MyCallBack callBack = new MyCallBack() {
            @Override
            public void back(int sum) {
                System.out.println("이미지 결과!! " + sum);
                //read title을 끄집어낸다.
                //100d을 사용하고 싶다.
            }
        };
        Thread thread = new Thread(new FileUtilThread(callBack));
        thread.start();
    }


}
