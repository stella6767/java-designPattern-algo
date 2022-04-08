package design_pattern.creational.singleton;

public class SinhandCard extends Card {

    private static SinhandCard sinhandCard;

    int count;

    //이른 초기화

    private SinhandCard() {
    }

    //리플렉션과 seriazable로 뜷을 수 있음.
    public synchronized static SinhandCard createInstance() {
        if (sinhandCard == null) {
            //thread1 , main thrad
            System.out.println("없으면 생성해야징");
            sinhandCard = new SinhandCard(); //늦은 초기화
        }
        return sinhandCard;
    }


    public int return100() {
        count = 0;
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName()  + " " + count);
            count++;
        }
        return count;
    }


}
