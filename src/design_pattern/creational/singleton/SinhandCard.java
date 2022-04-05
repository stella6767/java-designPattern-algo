package design_pattern.creational.singleton;

public class SinhandCard extends Card{

    private static SinhandCard sinhandCard;

    private SinhandCard() {
    }

    //리플렉션과 seriazable로 뜷을 수 있음.
    public synchronized static SinhandCard createInstance(){
        if (sinhandCard == null){
            //thread1 , main thrad
            System.out.println("없으면 생성해야징");
            sinhandCard = new SinhandCard();
        }
        return sinhandCard;
    }

}
