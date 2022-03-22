package design_pattern.creational.singleton;

import java.io.Serializable;

public class CreditCard extends Card implements Serializable {

    /**
     * 멀티스레드 환경에서 안전하게 구현하는 방법
     */

    //private static CreditCard instance;
    //private static final CreditCard instance = new CreditCard(); //이른 초기화 = 스레드 안전성을 확보하는 방법 2
    //private static volatile CreditCard instance;


    private CreditCard() { //외부에서 new 못하도록 막아놓고.

    }


    //방법 4 = static inner 클래스 사용
    private static class Card2Holder {
        private static final CreditCard INSTANCE = new CreditCard();
    }
    public static CreditCard getInstance(){
        return Card2Holder.INSTANCE;
    }


    protected Object readResolve(){ //역직렬화 대응
        return getInstance();
    }


//    public static synchronized CreditCard getInstance(){ //synchronized 가 가장 간단한 방법 1
//        if (instance == null){
//            System.out.println("없으면..");
//            instance = new CreditCard();
//        }
//        //재활용하자.
//        return instance;
//    }

//    public static CreditCard getInstance(){
//        //재활용하자.
//        return instance;
//    }

//    public static CreditCard getInstance() {
//        //double checked locking 방법 3 volatile
//        //방법1보다 비용이 적게 듬. 1.5부터 동작.
//        if (instance == null) {
//            synchronized (CreditCard.class) {
//                if (instance == null) {
//                    instance = new CreditCard();
//                }
//            }
//        }
//        return instance;
//    }


}