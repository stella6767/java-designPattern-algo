package design_pattern.behavioral.observer;

public class DigitObserver implements Observer {

    /**
     * Concrete Subscribers
     * @param number
     */

    @Override
    public void update(int number) {
        System.out.println( Thread.currentThread().getName() + "숫자: "+ number);
    }
}
