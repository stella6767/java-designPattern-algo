package kt2.ch13;

/**
 * 내부 클래스는 숨겨진 외부 클래스 정보를 가지고 있어, 참조를 해지하지 못하는 경우
 * 메모리 누수가 생길 수 있고 이를 디버깅 하기 어렵다.
 *
 * 그래서 내부 클래스를 사용할때는 가급적 static class를 쓰라는 게 이펙티브 자바의 조언
 *
 */

public class JavaHouse {

    private String address;
    private LivingRoom livingRoom;

    public JavaHouse(String address) {
        this.address = address;
        this.livingRoom = new LivingRoom(10);
    }

    public LivingRoom getLivingRoom() {
        return livingRoom;
    }

    public static class LivingRoom {
        private double area;

        public LivingRoom(double area) {
            this.area = area;
        }
    }

}
