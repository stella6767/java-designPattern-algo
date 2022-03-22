package design_pattern.creational.factory_method;

public class FactoryMethodApp {

    /**
     * 
     * 구체적인 객체 생성 과정을 하위 또는 구체적인 클래스로 옮기는 것이 목적
     * 
     * OCP를 지킬 수 있다. 느슨한 결합을 통해서
     * 단점 - 클래스가 늘어난다..
     *
     * 자바에서의 사용예시 중 하나 -- Calender,
     * 스프링에서 BeanFactory
     * @param args
     */


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
