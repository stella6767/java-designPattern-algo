package design.factory;

public class FactoryMethodApp {

    public static void main(String[] args) {

        IDCardFactory factory = new IDCardFactory();

        Product idCard1 = factory.createProduct("홍길동");
        Product idCard2 = factory.createProduct("한석봉");

        idCard1.use();
        idCard2.use();

        IDCard idCard3 = IDCard.Factory.create("신사임당");
        idCard3.use();

    }
}
