package design_pattern.creational.factory_method;

public class IDCardFactory implements Factory{

    @Override
    public IDCard createProduct(String name) {
        return new IDCard(name);
    }
}
