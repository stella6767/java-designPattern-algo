package design_pattern.behavioral.observer;

public class ObserverApp {

    /**
     *옵저버 패턴은 3개의 액터 클래스를 사용합니다. 주체, 관찰자 및 클라이언트.
     * 주제는 관찰자를 클라이언트 개체에 연결 및 분리하는 메서드가 있는 개체입니다.
     * @param args
     */


    public static void main(String[] args) {

        RandomGenertor randomGenertor = new RandomGenertor();

        Observer observer1 = new DigitObserver();
        Observer observer2 = new GraphicObserver();
        Observer observer3 = number -> {
            for (int i = 0; i < number; i++) {
                System.out.print("=");
            }
            System.out.println();
        };


        //클라이언트는 게시자(publisher) 및 구독자(subscriber) 객체를 별도 생성한 후 구독자 등록.
        randomGenertor.subscribe(observer1);
        randomGenertor.subscribe(observer2);
        randomGenertor.subscribe(observer3);


        randomGenertor.notifyToSubscriber();
        //randomGenertor.notifyToSubscriber();
        //randomGenertor.notifyToSubscriber();
    }
}
