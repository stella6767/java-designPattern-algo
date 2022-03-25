package javacore.basic;

import java.util.Objects;

public class Ch10 {

    /**
     * 객체를 함 비교해보자
     */

    public static void main(String[] args) {


        /**
         *  ==  참조타입의 경우 메모리주소 비스무리한 link로 판별..
         */

        Integer a = new Integer(1);
        Integer b = new Integer(1);
        int c = 1;
        Sub s = new Sub();

        /* 일반 정수형(f)와 객체 비교 */
        System.out.println(a == c);  // true
        System.out.println(b == c);  // true
        System.out.println(s.d == c);  // true

        /* 객체와 객체 비교 */
        System.out.println(a == b);  // false
        System.out.println(b == s.d);  // true (인스턴스 안의 원시타입 변수이므로 값 비교)


        System.out.println("=========================================");

        /**
         * instanceof는 좌측의 객체가 우측의 타입이 맞는지 확인, 좌측은 인스턴스가, 우측은 인스턴스가 아닌 타입
         */

        Parent p = null;
        Sub s1 = new Sub();
        Sub2 s2 = new Sub2();

        System.out.println(s1 instanceof Sub); // true
        System.out.println(s2 instanceof Parent); // true
        System.out.println(p instanceof Sub); // false

        p = s1; // 부모 클래스에 s1을 오버라이딩 시킬 경우
        System.out.println(p instanceof Sub); // true

        System.out.println("=========================================");

        /**
         * equals - 객체 내부의 값을 모두 비교해 동일 값을 가진 객체를 판별하는 메소드
         * 오버라이딩 해줘여됨.
         */

        Sub s3 = new Sub();
        Sub s4 = new Sub();

        System.out.println(s3.equals(s3));	// true
        System.out.println(s3.equals(s4));	// false, Override해주면 true


    }

    static class Sub extends Parent {
        int d = 1;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true; // 자기 자신이 비교 대상으로 들어왔으면 true
            if (o == null || getClass() != o.getClass()) return false; // 메모리 주소가 없는 객체라면 false, 비교 대상 둘이 다른 클래스라면 false
            Sub sub = (Sub) o;// Object 타입으로 들어왔으므로 비교를 위해 형변환
            return d == sub.d; //필드와 값이 같으면 true
        }


        /**
         * 객체 내부의 필드 값을 hash값으로 바꿔 hash값을 리턴해줌
         * 같은 값은 무조건 동일 hash값을 가짐
         * 하지만 hash값이 동일하더라도 값이 다를 수 있기 때문에 equals 메소드와 혼용 필수
         * equals 메소드보다 비교 연산이 빠르기 때문에 hashCode를 먼저 비교 후 equals 수행
         *
         * ​동일한 객체는 무조건 같은 hash값을 가지지만 낮은 확률로 서로 다른 두 객체가 같은 hash값을 가질 수도 있슴
         * 따라서 hashCode 메소드를 통해 동일한 hash값이 도출되면 equals 메소드를 다시 수행해 값을 비교
         * @return
         */

        @Override
        public int hashCode() {
            return Objects.hash(d);
        }
    }
    static class Sub2 extends Parent {
        int d = 1;
    }

}


class Parent {

}