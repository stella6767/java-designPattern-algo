package kt2.ch1;

import lombok.Builder;

public class Person {

    private String name;

    private int age;

    public Person( String firstName,  String lastName, int i) {

    }

    public int getAge() {
        return age;
    }

    @Builder
    public Person(String name, int age) {

        this.name = name;
        this.age = age;
    }

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
