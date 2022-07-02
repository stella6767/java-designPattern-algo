package kt2.ch10;

public class JavaPenguin extends JavaAnimal implements JavaSwimable, JavaFlyable{

    private final int wingCount;

    protected JavaPenguin(String species) {
        super(species, 2);
        this.wingCount = 2;
    }

    @Override
    public void move() {
        System.out.println("cat move");
    }

    @Override
    public int getLegCount() {
        return super.legCount + this.wingCount;
    }

    @Override
    public void fly() {

    }

    @Override
    public void act() {
        JavaSwimable.super.act();
        JavaFlyable.super.act();
    }

}



interface JavaSwimable {

    default void act(){
        System.out.println("어푸 어푸");
    }
}

interface JavaFlyable {

    default void act(){
        System.out.println("파닥 파닥");
    }

    void fly();

}