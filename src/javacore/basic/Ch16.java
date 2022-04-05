package javacore.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ch16 {

    /**
     * 불변 객체,
     * 불변 컬렉션 타입
     * <p>
     * 대표적인 게 String
     * https://www.mimul.com/blog/why-string-class-has-made-immutable-or-final-java/
     * https://wildeveloperetrain.tistory.com/34
     * https://mangkyu.tistory.com/131
     *
     * 공유를 하기 위해서는 String 클래스는 Immutable class

     * 1. Thread-Safe하여 병렬 프로그래밍에 유용하며, 동기화를 고려하지 않아도 된다.
     * 2. 실패 원자적인(Failure Atomic) 메소드를 만들 수 있다.
     * 3. Cache나 Map의 또는 Set 등의 요소로 활용하기에 더욱 적합하다.
     * 4. 부수 효과(Side Effect)를 피해 오류가능성을 최소화할 수 있다.
     * 5. 다른 사람이 작성한 함수를 예측가능하며 안전하게 사용할 수 있다.
     * 6. 가비지 컬렉션의 성능을 높일 수 있다.
     *
     * final 키워드가 내부의 객체 상태를 변경하지 못하도록 하는 것은 아니다.
     * 설사 방어적 복사로 대비를 다 했다고 하더라도 reflection을 이용하면 변경 가능하기 때문에. 한계가 있슴.
     *
     * https://www.daleseo.com/java9-immutable-collections/
     */


    public static void main(String[] args) {

        String s = "불변객체";
        s.toCharArray();


        ImmutableClass kang = ImmutableClass.of(10, "kang");
        ImmutableClass kang2 = ImmutableClass.of(11, "kang2");

        kang.getList().add("불변?");

        System.out.println(kang.getList().get(0));



    }

/*    Java에서 불변 객체를 생성하기 위해서는 다음과 같은 규칙에 따라서 클래스를 생성해야 한다.

    클래스를 final로 선언하라
    모든 클래스 변수를 private와 final로 선언하라
    객체를 생성하기 위한 생성자 또는 정적 팩토리 메소드를 추가하라
    참조에 의해 변경가능성이 있는 경우 방어적 복사를 이용하여 전달하라
    클래스들은 가변적이여야 하는 매우 타당한 이유가 있지 않는 한 반드시 불변으로 만들어야 한다.
    만약 클래스를 불변으로 만드는 것이 불가능하다면, 가능한 변경 가능성을 최소화하라.
        https://galid1.tistory.com/622

    */


    private static char[] toCharArray(String value) {
        // Cannot use Arrays.copyOf because of class initialization order issues
        char result[] = new char[value.length()];
        System.arraycopy(value, 0, result, 0, value.length());
        return result;
    }


}


final class ImmutableClass {
    private final int age; //필드를 final로 만들었다고 하더라도, 이 필드가 클래스변수고, 그 클래스가 불변객체가 아닐 경우는 이 객체도 불변객체가 아님.
    private final String name;
    private final List<String> list;

    private ImmutableClass(int age, String name) {
        this.age = age;
        this.name = name;
        this.list = new ArrayList<>();
    }

    public static ImmutableClass of(int age, String name) {
        return new ImmutableClass(age, name);
    }

    public int getAge() {
        return age;
    }


    public String getName() {
        return name;
    }

    public List<String> getList() {
        return Collections.unmodifiableList(list);
    }
}

