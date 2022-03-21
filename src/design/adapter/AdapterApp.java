package design.adapter;

public class AdapterApp {

    public static void main(String[] args) {
        PersonAdapter adapter = new PersonAdapter(new Person("홍갈동", 100));

        System.out.println(adapter.showAge());
        System.out.println(adapter.showName());
    }

}
