package oop;

public class CarFactory {

    public Tier tier(){
        return new SnowTier();
    }

    public Control control(){

        return new Sonata(tier());
    }

}
