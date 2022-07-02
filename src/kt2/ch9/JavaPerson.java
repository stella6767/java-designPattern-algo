package kt2.ch9;

public class JavaPerson {

    private final String name;
    private int age;

    public JavaPerson(String name, int age) {
        if (age <= 0){
            throw new IllegalArgumentException("나이는" + age + "일 수 없습니다.");
        }
        this.name = name;
        this.age = age;
    }


    public JavaPerson(String name) {
        this(name, 1);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }


    public void setAge(int age) {
        this.age = age;
    }

    public boolean isAdult(){
        return this.age >=20;
    }

}
