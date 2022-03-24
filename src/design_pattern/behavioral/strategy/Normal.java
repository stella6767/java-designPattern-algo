package design_pattern.behavioral.strategy;

/**
 * ConcreateStrategies
 */

public class Normal implements Speed {
    @Override
    public void blueLight() {
        System.out.println("무궁화    꽃    이    ");
    }

    @Override
    public void redLight() {
        System.out.println("피   었   습니다.");
    }
}
