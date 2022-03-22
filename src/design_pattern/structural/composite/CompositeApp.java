package design_pattern.structural.composite;

public class CompositeApp {

    /**
     * 그룹 전체와 개별 객체를 동일하게 처리할 수 있는 패턴
     *
     * 다향성과 재귀를 활용
     * 클라이언트 코드를 변경하지 않고 새로운 엘리먼트 타입을 추가
     * 지나친 일반화를 주의하자.
     *
     * swing, javafx
     * @param args
     */

    public static void main(String[] args) {

        Item doranBlade = new Item("도란검", 450);
        Item doranSheld = new Item("도란방패", 450);

        Bag bag = new Bag();
        bag.add(doranBlade);
        bag.add(doranSheld);

        CompositeApp client = new CompositeApp();
        client.printPrice(doranBlade);
        client.printPrice(bag);
    }

    private void printPrice(Component component) {
        System.out.println(component.getPrice());

    }

}
