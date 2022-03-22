package design_pattern.creational.abstractfactory;

public interface ShipPartsFactory {

    /**
     * AbstractFactory
     * @return
     */


    Anchor createAnchor();

    Wheel createWheel();
}
