package design.observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomGenertor {

    /**
     * Publisher , 이벤트 발행역할
     */


    private List<Observer> observers = new ArrayList<>();

    public void subscribe(Observer observer){
        observers.add(observer);
    }

    public void unsubscribe(Observer observer){
        observers.remove(observer);
    }

    public void notifyToSubscriber(){ //이벤트 발생하면, 게시자는 각 구독자 인터페이스에 선언된 메서드 호출
        int num = new Random().nextInt(50);
        observers.forEach(observer -> observer.update(num));
    }
}
