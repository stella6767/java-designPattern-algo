package design_pattern.behavioral.observer.part2;

public class Client {
    /**
     * 다수의 객체가 특정 객체 상태 변화를 감지하고 알림을 받는 패턴
     *
     * 리스너(구독자)를 명시적으로 해지하지 않으면 계속 쌓임.. 가비지 컬렉션의 대상이 안 되기 때문에..
     * 그걸 방지하기 위해서는 WeakRefernce 를 참고
     *
     * 사용 예시 - flow api, propertychangelistner, applicationEventPublisher EventListner
     *
     */

    public static void main(String[] args) {

        ChatServer chatServer = new ChatServer();
        User kang = new User("kang");
        User min = new User("min");
        User yoon = new User("yoon");

        chatServer.register("디자인", kang);
        chatServer.register("디자인", min);
        chatServer.register("건축", yoon);

        chatServer.sendMsg(kang, "디자인", "아 재밌다.");

    }

}
