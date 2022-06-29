package kt2.ch4;

public class Lec04Main {

    public static void main(String[] args) {

        JavaMoney money1 = new JavaMoney(2000L);
        JavaMoney money2 = new JavaMoney(2000L);
        JavaMoney money3 = new JavaMoney(1000L);

        System.out.println(money1.plus(money2));
        System.out.println(money1.equals(money2));

        if (money1.compareTo(money3) > 0){
            System.out.println("Money1 > Money3");
        }

    }
}
