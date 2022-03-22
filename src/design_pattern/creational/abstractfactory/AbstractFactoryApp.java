package design_pattern.creational.abstractfactory;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class AbstractFactoryApp {

    /**
     * 서로 관련있는 여러  객체를  만들어주는 인터페이스
     * 관련있는 여러 객체를 구체적인 클래스에 의존하지 않고 만들 수 있게  해주는 것이 목적, 합성에 초점
     *
     *  스프링에서의  factoryBean
     *
     * @param args
     */


    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {

        ShipFactory shipFactory = new WhiteShipFactory(new WhitePartsProFactory());
        Ship ship = shipFactory.createShip();
        System.out.println(ship.getAnchor().getClass());
        System.out.println(ship.getWheel().getClass());


        //자바에서 사용예시
//        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//        DocumentBuilder builder = factory.newDocumentBuilder();
//        Document document = builder.parse(new File("src/"));
//        System.out.println(document.getDocumentElement());


    }

}
