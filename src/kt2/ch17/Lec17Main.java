package kt2.ch17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;


/**
 * Java에서 함수형 프로그래밍을 흉내내는 방법들.
 * 하지만 기본적으로 자바에서 함수는 2급시민이기 때문에,
 * 메서드 자체를 직접 넘겨줄 순 없다..
 *
 */

public class Lec17Main {

    public static void main(String[] args) {


        Lec17Main lec17Main = new Lec17Main();

        List<Fruit> fruits = Arrays.asList(
                new Fruit("사과", 1000),
                new Fruit("사과", 1000),
                new Fruit("사과", 1000),
                new Fruit("사과", 1000),
                new Fruit("바나나", 1200),
                new Fruit("바나나", 1200),
                new Fruit("바나나", 1200),
                new Fruit("수박", 3000)
        );

        List<Fruit> 사과 = lec17Main.filterFruits1(fruits, fruit -> fruit.getName().contains("사과"));

        String targetFruitName = "바나나";
        //targetFruitName = "수박";
        List<Fruit> 바나나 = lec17Main.filterFruits2(fruits, fruit -> fruit.getName().contains(targetFruitName));

        System.out.println(사과);
        System.out.println(바나나);


    }

    private static boolean test(Fruit fruit) {
        return fruit.getName().contains("바나나");
    }


    private List<Fruit> filterFruits1(List<Fruit> fruits, FruitFilter fruitFilter){
        ArrayList<Fruit> results = new ArrayList<>();
        for (Fruit fruit : fruits) {
            if (fruitFilter.isSelected(fruit)){
                results.add(fruit);
            }
        }

        return results;
    }


    //이미 있는 함수형 인터페이스 활용
    private List<Fruit> filterFruits2(List<Fruit> fruits, Predicate<Fruit> fruitFilter){
        return fruits
                .stream()
                .filter(fruitFilter)
                .collect(Collectors.toList());
    }


}


@FunctionalInterface
interface FruitFilter {
    boolean isSelected(Fruit fruit);
}
