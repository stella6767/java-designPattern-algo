package kt2.ch12;

public class Lec12Main {

    public static void main(String[] args) {

        //companino object 이름이 있다면 그냥 이름을 활용하면 됨
        KotilnPerson.Factory.newBaby("ABC");

        //@JvmStatic
        KotilnPerson.newBaby("ABC");
    }
}
