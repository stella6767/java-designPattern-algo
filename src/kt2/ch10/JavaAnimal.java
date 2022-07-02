package kt2.ch10;

public abstract class JavaAnimal {

    protected final String species;
    protected final int legCount;


    protected JavaAnimal(String species, int legCount) {
        this.species = species;
        this.legCount = legCount;
    }
    abstract public void move();

    public String getSpecies() {
        return this.species;
    }

    public int getLegCount() {
        return this.legCount;
    }
}
