package design_pattern.behavioral.memento;

public class MementoApp {

    /**
     * 객체의 상태를 이전 상태로 복원하는데 사용. 행동 패턴, 3개의 액터 클래스로 구현
     * Originator는 Memento 객체에 상태를 생성하고 저장하며 Caretaker 객체는 Memento에서 객체 상태를 복원하는 역할을 합니다
     * @param args
     */

    public static void main(String[] args) {

        Originator originator = new Originator();
        CareTaker careTaker = new CareTaker();

        originator.setState("State #1");
        originator.setState("State #2");
        careTaker.add(originator.saveStateToMemento());

        originator.setState("State #3");
        careTaker.add(originator.saveStateToMemento());

        originator.setState("State #4");
        System.out.println("Current State: " + originator.getState());

        originator.getStateFromMemento(careTaker.get(0));
        System.out.println("First saved State: " + originator.getState());
        originator.getStateFromMemento(careTaker.get(1));
        System.out.println("Second saved State: " + originator.getState());
    }

}
