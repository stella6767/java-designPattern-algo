package design_pattern.creational.singleton;

/**
 * enum 자체가 serialization 및 thread-safety를 보장합니다
 */

public enum CardEnum {

    SINHANCARD, CREDITCARD, CHECKCARD;

    private CardEnum() { //pricate default
    }

    public CardEnum getSinhanCard(){
        return SINHANCARD;
    }
}
