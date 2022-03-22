package design.singleton;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class SingleTonApp {

    /**
     * 인스턴스를 오직 하나만 생성해서 재활용
     *
     * @param args
     */


    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, IOException, ClassNotFoundException {

        Card card1 = CreditCard.getInstance();
        Card card2 = CreditCard.getInstance();
        Card card3 = CreditCard.getInstance();
        Card card4 = CreditCard.getInstance();

        TestCard card5 = TestCard.INSTANCE; //Enum은 리플렉션이 뜷을 수 없음.

        /**
         * 싱글톤을 깨트리는 방법 1 / 리플렉션 활용
         */
        
        Constructor<Card> constructor = Card.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        card3 = constructor.newInstance();


        /**
         * 싱글톤을 깨트리는 방법 2 / 직렬화 & 역질력화 사용, readResolve로 막을 수 있음.
         */

        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("creditCard.obj"))) {
            out.writeObject(card1);
        }

        try(ObjectInputStream out = new ObjectInputStream(new FileInputStream("creditCard.obj"))) {
            card4 = (Card) out.readObject();
        }

        checkIsSingleTon(card1, card4);


        /**
         * 싱글톤 사용 예시
         */

        Runtime runtime = Runtime.getRuntime();
        System.out.println(runtime.maxMemory());


    }


    private static void checkIsSingleTon(Card card1, Card card2) {
        if (card1 == card2){
            System.out.println("싱글톤 객체임");
        }else{
            System.out.println("싱글톤 아님.");
        }
    }

}
