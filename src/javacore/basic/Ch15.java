package javacore.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Ch15 {

    /**
     * First Class Collection
     * <p>
     * https://jackjeong.tistory.com/107
     * https://jojoldu.tistory.com/412
     * https://tecoble.techcourse.co.kr/post/2020-05-08-First-Class-Collection/
     * <p>
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
//        List<Flower> flowersOverPrice = lavenderFlowers.getFlowersOverPrice(-1);
//        List<Flower> flowersOverPrice10 = lavenderFlowers.getFlowersOverPrice(10);

        System.out.println(lavenderFlowers.getFlowers().get(0).getType());
        flower1.setType("다른 타입");

        //lavenderFlowers.getFlowers().add(new Flower());
        System.out.println(lavenderFlowers.getFlowers().get(0).getType());



//        System.out.println(lavenderFlowers.getFlowers().size());
//        lavenderFlowers.getFlowers().add(new Flower()); //접근방법이 없음.
//        System.out.println(lavenderFlowers.getFlowers().size());


    }
}


class Flower implements Cloneable{

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


    public void setType(String type) {
        this.type = type;
    }


    @Override
    public String toString() {
        return "Flower{" +
                "price=" + price +
                ", type='" + type + '\'' +
                '}';
    }

    @Override
    public Flower clone() throws CloneNotSupportedException {
        return (Flower) super.clone();
    }
}


//일급 컬렉션. Collection들을 Wrapping한 컬렉션
class LavenderFlowers {

    private final List<Flower> flowers; // 멤버변수가 하나
    //final을 붙인 이유 - 한번 객체화 시킨 변수에 대해서 다른 참조자를 갖도록 할 수 없다.
    //물론 Flower가 불변객체가 아니기 때문에, 이 객체도 불변객체는 아님.

    public LavenderFlowers(List<Flower> flowers) {
        //element 까지 불변 보장이 안 되는걸 deep copy로 막기는 했지만.. 굉장히 번거로운 걸

        List<Flower> lavenders = flowers.stream()
                .filter(flower -> flower.getType().equals("lavender"))
                .map(flower -> {
                    try {
                        flower = flower.clone();
                    } catch (CloneNotSupportedException e) {
                        e.printStackTrace();
                    }
                    return flower;
                })
                .collect(Collectors.toUnmodifiableList());
        this.flowers = lavenders;

    }



//    public LavenderFlowers(List<Flower> flowers) {
//
//        this.flowers = flowers.stream()
//                .filter(flower -> flower.getType().equals("lavender"))
//                .collect(Collectors.toList());
//    }


//    public List<Flower> getFlowers() {
//        return flowers;
//        //이 function을 주석으로 한다면, 컬렉션에 값을 추가하거나 변경하는 방법이 없기 때문에, 불변성이 보장되는 것처럼 느끼지만
//        //하지만 만약 원본 들어가는 flower의 값을 누가 변경했다면 여기도 영향을 미침.
//    }

    public List<Flower> getFlowers() {
        return Collections.unmodifiableList(flowers);  //불변성

    }

    public List<Flower> getFlowersOverPrice(int price) {
        // 비즈니스 로직을 내부에서 관리, 상태와 행위를 한곳에서 관리
        return flowers.stream()
                .filter(flower -> flower.getPrice() > price)
                .collect(Collectors.toList());
    }


    public int getSize() {
        return flowers.size();
    }

}