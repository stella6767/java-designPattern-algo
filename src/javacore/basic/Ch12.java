package javacore.basic;

import java.util.ArrayList;
import java.util.List;

public class Ch12 {

    /**
     * 제네릭 변성
     * https://www.youtube.com/watch?v=PtM44sO-A6g&t=2s&ab_channel=%EC%B5%9C%EB%B2%94%EA%B7%A0
     *
     */


    public static void main(String[] args) {

        Fruit apple = new Apple();
        //FruitBox<Fruit> fruitBox = new FruitBox<Apple>(); // FruitBox<Apple>은 FruitBox<Fruit> 의 서브 클래스가 아니다!

        //FruitBox<Fruit> fruitBox = new FruitBox<>();
        FruitBox<? super Fruit> fruitBox = new FruitBox<>();
        fruitBox.add(apple);
        fruitBox.getAll();


    }

}


class Apple extends Fruit {

}

//class FruitBox <T extends Fruit>{
//
//    private List<Fruit> fruits = new ArrayList<>();
//
//    public void add(T fruit){
//        this.fruits.add(fruit);
//    }
//
//    public List<Fruit>  getAll(){
//        return this.fruits;
//    }
//
//}


class FruitBox <T extends Fruit>{

    private List<T> fruits = new ArrayList<>();

    public void add(T fruit){
        this.fruits.add(fruit);
    }

    public List<? extends Fruit>  getAll(){
        return this.fruits;
    }

}


class Fruit {


}
