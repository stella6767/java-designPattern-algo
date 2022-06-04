package javacore.basic;

public class Ch18 {


    public static void main(String[] args) {

        Ch18 ch18 = new Ch18();

        Square f = n -> n*n;

        ch18.test(f);


    }

    private void test(Square square){

        System.out.println(square.square(3));
    }


}


@FunctionalInterface
interface Square {
    int square(int n);
}