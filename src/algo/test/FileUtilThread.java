package algo.test;



public class FileUtilThread implements Runnable {
    private MyCallBack callBack;

    

    public FileUtilThread(MyCallBack callBack) {
        this.callBack = callBack;
    }

    @Override
    public void run() {

        int sum = 0;

        for (int i = 0; i < 100; i++) {

            System.out.println("===================" + i);
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            sum++;
            //doSomething 파일, ㄴ꼐
        }
        //100
        callBack.back(sum); //되게 여러가지 클래스에서 필요한 공통작업(5초)인데, 비동기를 하는데,
//        ImageUtills imageUtills = new ImageUtills();
    }


}
