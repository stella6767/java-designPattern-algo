package kt2.ch10;

public class JavaCat extends JavaAnimal{

    protected JavaCat(String species) {
        super(species, 4);
    }

    @Override
    public void move() {
        System.out.println("cat move");
    }
}
