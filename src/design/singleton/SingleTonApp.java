package design.singleton;

public class SingleTonApp {

    public static void main(String[] args) {

        Card card1 = Card.getInstance();
        Card card2 = Card.getInstance();

        if (card1 == card2){
            System.out.println("싱글톤 객체임");
        }else{
            System.out.println("싱글톤 아님.");
        }

    }

}
