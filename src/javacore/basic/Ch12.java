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


        //와일드카드 <?>
        List<? extends Spoil> spoilBox = new ArrayList<Banana>(); //와일드 카드의 상한제한.. T와 그 자손들만
        List<? super Spoil> spoilBox2 = new ArrayList<>(); //하한제한, T와 그 조상들만
        List<?> spoilBox3 = new ArrayList<>(); //모든 타입이 가능.. <? extends Object> 와 같음
        //spoilBox.add(new Banana());



        //Banana banana = spoilBox.get(0);

        fruitBox.add(apple);
        fruitBox.add(new Banana());
        fruitBox.getAll();


    }

}


class Apple extends Fruit {

}

class Banana extends Fruit implements Spoil {

}

class Melon extends Fruit {

}

class Grapes extends Fruit implements Spoil{

}

interface Spoil  {

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
