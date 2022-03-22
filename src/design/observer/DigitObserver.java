package design.observer;

public class DigitObserver implements Observer {

    /**
     * Concrete Subscribers
     * @param number
     */

    @Override
    public void update(int number) {
        System.out.println("숫자: "+ number);
    }
}
