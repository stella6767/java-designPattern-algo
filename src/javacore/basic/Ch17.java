package javacore.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Ch17 {

    /**
     * 일급 객체? 메서드 래퍼런스
     * https://jojoldu.tistory.com/232?category=635881
     * <p>
     * 함수형 프로그래밍에서는 '함수' 자체가 일급 시민
     * 일반적으로 1급 시민의 조건은 다음과 같이 정의한다고 한다.
     * - 변수(variable)에 담을 수 있다
     * - 인자(parameter)로 전달할 수 있다
     * - 반환값(return value)으로 전달할 수 있다
     * <p>
     * 자바스크립트에서는 function 자체가 일급 시민이다..
     * function을 인자로 넘겨줄 수도 있고, 리턴해줄 수도 있고 값에 할당할 수도 있다.
     * 자바는 그런 유연함은 없다. 자바 8 이전에는 자바는 이러한 한계를 전략패턴 또는 익명클래스로 해결해왔으나.
     * 8 이후 이제는 흉내를 낼 수 있다. (고차 함수 같은 기법도 흉내가 가능)
     */

    public static <T> void main(String[] args) {

        final Function<String, Integer> toInt = s -> Integer.parseInt(s);
        System.out.println(toInt.apply("1"));

        List<String> list = new ArrayList<>();
        list.add("kang");
        list.add("kang");
        list.add("min");

        Predicate<String> kangFilter = s -> {
            if (s.equals("kang")) {
                return true;
            }
            return false;
        };
        List<String> filteredList = filter(list, kangFilter);
        System.out.println(filteredList);


        List<String> filteredList2 = filterSupplier(list, s -> {
            if (s.equals("kang")) return s;
            return null;
        });


        System.out.println(filteredList2);

        NameService<T> nameService = new NameService<>();

//        List<T> kang = nameService.nameFilter((list1, name) -> {
//            for (Object t : list1) {
//                if (t.equals(name)) {
//                    list1.remove(t);
//                }
//            }
//
//            return list1;
//        }, list, "kang");


        /**
         * Higher-order function / 고차함수
         */
        
        final Function<Function<Integer,String>, String> f = g->g.apply(10);
        System.out.println(f.apply(i->"#" + i)); //#10

        final Function<Integer, Function<Integer,Integer>> f2 = l -> i2 -> l + i2;
        System.out.println(
                f2.apply(1).apply(9)
        );




    }


    private static void printHello(){
        System.out.println("hello world");
    }





    private static <T> List<T> filterSupplier(List<T> list, Function<T, T> function) {
        List<T> resultList = new ArrayList<>();
        for (final T t : list) {
            resultList.add(function.apply(t));
        }
        return resultList;
    }


    private static <T> List<T> filter(List<T> list, Predicate<T> filter) {
        List<T> resultList = new ArrayList<>();
        for (T t : list) {
            if (filter.test(t)) {
                resultList.add(t);
            }
        }
        return resultList;
    }


}


interface Filter<T> {
    public List<T> nameFilter(List<T> list, String name);
}

class NameService<T> {
    public List<T> nameFilter(Filter f, List<T> list, String name) {
        return f.nameFilter(list, name);
    }
}





