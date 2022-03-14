package javacore;

import java.util.ArrayList;
import java.util.List;

public class Ch6 {

    /**
     * oop (객체 지향 프로그래밍).
     *
     * 추상화, 캡슐화, 은닉성, 다형성, 상속성
     *
     * 캡슐화: 데이터 구조와 데이터를 다루는 방법을 결합. 변수와 함수를 하나로 묶음
     * 은닉성 - 캡술화의 한 개념. 내부 데이터, 내부 연산을 외부에서 접근 X , 상태는 행위를 통해서 변경해야된다는 것이 객체지향 철칙
     * 추상화 - 컴퓨터는 추상적으로 생각하지 않는다. 추상화(개별적인 실체로부터 공통적인 속성을 뽑아내는 거), 실체가 없는 것을 마치 실체가 있는 것처럼 다룰 수 있게 됨.
     * 예를 들어, 동물. , 복잡한 세상을 단순화시켜서 바라볼 수 있게 됨.
     * 상속성 - 상위 개념의 특징을 하위 개념이 물려받는 것. 데이터 재사용성이 아니라, 다형성에 초점을 두고 구현을 해야해요. is a 관계
     * 다형성 - 하나의 객체가 여러가지 타입을 가질 수 있는 것. 즉 고양이면서 동시에 동물이라고 부를 수 있게 되는 거죠.
     *
     * has a (컴포지션)
     *
     *
     */


    public static void main(String[] args) {
//        Dragon dragon1 = new Dragon("Dragon1");
//        dragon1.setHp(-100);
//        System.out.println(dragon1);

        //상속의 목적, 타입을 일치시키기 위해 사용.


        //heap 영역(cat, animal) -
        Animal cat = new Cat();

        //자연, 돌 extends 자연, 바위, 물


//        //heap(포유류, 동물)
//        Animal 포유류1 = new 포유류();
//
//        포유류 포 = (포유류) 포유류1;
//        포.sound();

//        Cat c = (Cat) 포; //컴파일 시점에서 에러를 잡을 수 없기 때문에, 주의를 해줘야
//        c.sound();
        Animal bird = new Bird();
        Animal dog = new Dog();


        Tamer tamer = new Tamer();
        tamer.whipToAnimals();


//
//
//
//        sound(cat);
//        sound(bird);
//        sound(dog);
//
//        System.out.println(cat.hp);

    }

    static void sound(Animal a){
        a.sound();
    }


}


abstract class Animal { //추상클래스,
    int hp = 10;
    abstract void sound();
    void a(){

    }

}


//class 포유류 extends Animal{
//
//    @Override
//    void sound() {
//
//    }
//}

class Dog extends Animal {

    @Override
    void sound(){
        System.out.println("멍멍.");
    };

}

class Cat extends Animal {

    @Override
    void sound() {
        System.out.println( "야옹");
    }
}


class Bird extends Animal {

    @Override
    void sound(){
        System.out.println("짹쨱");
    };

}



class Tamer {

    //List<Animal> animals = new ArrayList<>();
    Dog dog = new Dog();
    Cat cat = new Cat();

    void whipToAnimals(){
        dog.sound();
        cat.sound();
    }

}


class Dragon {
    final String name; // 상태
    private int hp; //4byte
    static int attack = 10; // 4byte

    Dragon(String name) {
        this.name = name;
    }

    public void setHp(int hp) {
        if (hp >= 0){
            this.hp = hp;
        }
    }

    @Override
    public String toString() {
        return "Dragon{" +
                "name='" + name + '\'' +
                ", hp=" + hp +
                '}';
    }
}
