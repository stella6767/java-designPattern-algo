package design.factory;

public class IDCardFactory implements Factory{

    @Override
    public IDCard createProduct(String name) {
        return new IDCard(name);
    }
}
