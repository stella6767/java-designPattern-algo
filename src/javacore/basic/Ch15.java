package javacore.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Ch15 {

    /**
     * First Class Collection
     *
     * 비지니스에 종속적인 자료구조
     * 상태와 행위를 한 곳에서 관리
     * 이름이 있는 컬렉션
     *
     * @param args
     */

    public static void main(String[] args) {

        Flower flower1 = new Flower("lavender");
        Flower flower2 = new Flower("lavender");
        Flower flower3 = new Flower("다른 종류");


        List<Flower> flowers = new ArrayList<>();
        flowers.add(flower1);
        flowers.add(flower2);
        flowers.add(flower3);


        /**
         * 일급 컬렉션이 없다면 비즈니스 로직을 외부에서 관리
         */

//        flowers.stream()
//                .filter(flower -> flower.getPrice() > 10)
//                .collect(Collectors.toList());



        LavenderFlowers lavenderFlowers = new LavenderFlowers(flowers); //이름있는 타입을 가질 수 있다.
        List<Flower> flowersOverPrice = lavenderFlowers.getFlowersOverPrice(-1);

        List<Flower> flowersOverPrice10 = lavenderFlowers.getFlowersOverPrice(10);


//        System.out.println(lavenderFlowers.getFlowers().size());
//        lavenderFlowers.getFlowers().add(new Flower()); //접근방법이 없음.
//        System.out.println(lavenderFlowers.getFlowers().size());


    }
}


class Flower {

    private int price;

    private String type;


    public Flower() {
    }

    public Flower(String type) {
        this.type = type;
    }

    public int getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }
}


//일급 컬렉션. Collection들을 Wrapping한 컬렉션
class LavenderFlowers {

    private final List<Flower> flowers; //굳이 불변성을 보장하기 위해 쓸 필요는 없다.

    public LavenderFlowers(List<Flower> flowers) {
        
        this.flowers =  flowers.stream()
                .filter(flower -> flower.getType().equals("lavender"))
                .collect(Collectors.toList());
    }



    /**
     * 이 컬렉션에 값을 추가하거나 변경하는 방법이 없기 때문에, 불변성이 보장됨.
     * @param price
     * @return
     */
//    public List<Flower> getFlowers() {
//        return flowers;
//    }

    public List<Flower> getFlowersOverPrice(int price){
        // 비즈니스 로직을 내부에서 관리, 상태와 행위를 한곳에서 관리
        return flowers.stream()
                .filter(flower -> flower.getPrice() > price)
                .collect(Collectors.toList());
    }


    public int getSize(){
        return flowers.size();
    }

}