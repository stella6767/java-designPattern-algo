package design.abstractfactory;

public class WhiteShipFactory implements ShipFactory {

    /**
     * client
     */

    private ShipPartsFactory shipPartsFactory;

    public WhiteShipFactory(ShipPartsFactory shipPartsFactory) {
        this.shipPartsFactory = shipPartsFactory;
    }

    @Override
    public Ship createShip() {
        Ship whiteShip = new WhiteShip();
        whiteShip.setAnchor(shipPartsFactory.createAnchor());
        whiteShip.setWheel(shipPartsFactory.createWheel());
        return whiteShip;
    }
}
