package design_pattern.behavioral.iterator;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

public class IteratorApp {

    /**
     * 집합 객체 내부 구조를 노출시키지 않고 순회하는 방법을 제공하는 패턴
     *
     *
     *
     * @param args
     */


    public static void main(String[] args) throws FileNotFoundException, XMLStreamException {

        Board board = new Board();
        board.addPost("디자인 패턴 게임");
        board.addPost("선생님, 저랑 디자인 패턴 하나 학습하시겠습니까?");
        board.addPost("지금 이 자리에 계신 여러분들은 모두 디자인 패턴을 학습하고 계신 분들입니다.");


        /**
         * 이전 코드
         */
//
//        // TODO 들어간 순서대로 순회하기
//        List<Post> posts = board.getPosts();
//        for (int i = 0 ; i < posts.size() ; i++) {
//            Post post = posts.get(i);
//            System.out.println(post.getTitle());
//        }
//
//        // TODO 가장 최신 글 먼저 순회하기
//        Collections.sort(posts, (p1, p2) -> p2.getCreatedDateTime().compareTo(p1.getCreatedDateTime()));
//        for (int i = 0 ; i < posts.size() ; i++) {
//            Post post = posts.get(i);
//            System.out.println(post.getTitle());
//        }


        /**
         * After
         */

        // TODO 들어간 순서대로 순회하기
        List<Post> posts = board.getPosts();
        Iterator<Post> iterator = posts.iterator();
        System.out.println(iterator.getClass());

        for (int i = 0 ; i < posts.size() ; i++) {
            Post post = posts.get(i);
            System.out.println(post.getTitle());
        }

        System.out.println();

        // TODO 가장 최신 글 먼저 순회하기
        Iterator<Post> recentPostIterator = board.getRecentPostIterator();
        while(recentPostIterator.hasNext()) {
            System.out.println(recentPostIterator.next().getTitle());
        }


        Enumeration enumeration;
        Iterator iterator2;

        // TODO Streaming API for XML(StAX), 이터레이터 기반의 API ... 스프링 / CompositeIterator
        // SAX (simple api for xml)
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        XMLEventReader reader = xmlInputFactory.createXMLEventReader(new FileInputStream("src/design_pattern/behavioral/Book.xml"));

        while (reader.hasNext()) {
            XMLEvent nextEvent = reader.nextEvent();
            if (nextEvent.isStartElement()) {
                StartElement startElement = nextEvent.asStartElement();
                QName name = startElement.getName();
                if (name.getLocalPart().equals("book")) {
                    Attribute title = startElement.getAttributeByName(new QName("title"));
                    System.out.println(title.getValue());
                }
            }
        }

        


    }
}
