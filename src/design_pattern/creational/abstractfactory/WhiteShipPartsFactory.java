package design_pattern.creational.abstractfactory;

public class WhiteShipPartsFactory implements ShipPartsFactory{

    /**
     * ConcreateFactory1
     * @return
     */

    @Override
    public Anchor createAnchor() {
        return new WhiteAnchor();
    }

    @Override
    public Wheel createWheel() {
        return new WhiteWheel();
    }
}
