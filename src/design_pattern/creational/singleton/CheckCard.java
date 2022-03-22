package design_pattern.creational.singleton;

public class CheckCard extends Card {


    /**
     * 멀티스레드 환경에서 안전 X
     */

    private static CheckCard instance;


    private CheckCard(){ //외부에서 new 못하도록 막아놓고.

    }

    public static CheckCard getInstance(){

        if (instance == null){
            System.out.println("없으면.. 생성하지만 스레드가 동시에 접근가능할 수도 있음..");
            instance = new CheckCard();
        }
        //재활용하자.
        return instance;
    }

}
