package design_pattern.structural.flyweight;

public class FlyweightApp {

    /**
     * 성능 개선을 위한 패턴
     * fontFactory.getFont = 동일한 인스턴스를 반환
     *
     * 자바 사용예시 - Integer.valueOf()
     *
     * @param args
     */


    public static void main(String[] args) {
        FontFactory fontFactory = new FontFactory();
        Character c1 = new Character('h', "white", fontFactory.getFont("nanum:12"));
        Character c2 = new Character('e', "white", fontFactory.getFont("nanum:12"));
        Character c3 = new Character('l', "white", fontFactory.getFont("nanum:12"));
    }

}
