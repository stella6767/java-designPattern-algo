package kt2.ch15;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Lec15Main {

    public static void main(String[] args) {
        int[] array = {100, 200};

        for (int i = 0; i < array.length; i++) {
            System.out.printf("%s %s", i, array[i]);
        }


        final List<Integer> numbers = Arrays.asList(100, 200);

        for (Integer number : numbers) {
            System.out.println(number);
        }

        for (int i = 0; i < numbers.size(); i++) {
            System.out.println(numbers.get(i));
        }


        //JDK 9부터
        Map<Integer, String> map = Map.of(1, "MONDAY", 2, "TUESDAY");

        for (Integer key : map.keySet()) {
            System.out.println(key);
            System.out.println(map.get(key));
        }

        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }

    }

}
