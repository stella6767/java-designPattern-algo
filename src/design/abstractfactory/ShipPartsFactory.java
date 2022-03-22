package design.abstractfactory;

public interface ShipPartsFactory {

    /**
     * AbstractFactory
     * @return
     */


    Anchor createAnchor();

    Wheel createWheel();
}
