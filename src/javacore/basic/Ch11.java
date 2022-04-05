//package javacore.basic;
//
//import java.util.List;
//
//public class Ch11 {
//
//    /**
//     * 제네릭
//     * - 데이터 타입이 런타임 시점에 결정
//     * - 가상의 데이터 타입을 사용해 사용 시 타입 지정
//     * - 제네릭 타입 제한을 통해 Object보다 타입 안정성을 높일 수 있음 (<T extends superclass> 형태로 지정)
//     *
//     * 제네릭 와일드카드
//     *  - 제네릭이 선언된 클래스의 인스턴스를 메소드의 매개변수로 받을 때, 타입을 무시하고 받음
//     * - <?> 형태로 사용
//     *
//     * @param args
//     */
//
//
//    public static void main(String[] args) {
//
//        TestMain<Integer, Integer> a = new TestMain<>(1, 2, "합계");
//        TestMain<Double, Double> b = new TestMain<>(200.0,300.0, "합계");
//
//        a.plus(); // 3.0
//        b.plus(); // 500.0
//
//        System.out.println(a.equals(b)); // true
//
//    }
//
//}
//
//
//class Test<T, V extends Number> { //일반적으로는 T 라는 이름을 짓고 사용..
//
//    T thing;
//    V value;
//    V num;
//
//    String name;
//
//    public Test(T thing, V value, String name) {
//        this.thing = thing;
//        this.value = value;
//        this.name = name;
//    }
//
//    public Test(V value, V num, String name) {
//        this.value = value;
//        this.num = num;
//        this.name = name;
//    }
//
//    // 가상 타입을 이용한 메소드 작성
//    public void print() {
//
//        System.out.println("물건 : " + thing);
//        System.out.println("가치 : "+ value);
//    }
//
//    public void plus() {
//
//        System.out.println(value.doubleValue() + num.doubleValue());
//    }
//
//    public String getName(List<?> list) {
//        return name;
//    }
//
//    // equals 메소드 오버라이딩 (name 문자열 비교)
//    public boolean equals(TestMain<?, ?> t) {
//
//        if (t.name.equals(this.name))
//            return true;
//
//        return false;
//    }
//
//}