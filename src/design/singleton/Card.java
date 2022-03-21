package design.singleton;

public class Card {

    private static Card instance;


    private Card (){ //외부에서 new 못하도록 막아놓고.

    }

    public static Card getInstance(){

        if (instance == null){
            System.out.println("없으면..");
        }
        //재활용하자.
        return instance;
    }

}
