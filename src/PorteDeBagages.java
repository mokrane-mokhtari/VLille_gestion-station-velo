
public class PorteDeBagages extends Accessoire {
    /**
     * Constructor for the PorteDeBagages class.
     * Adds a luggage rack to the given vehicle.
     *
     * @param vehicule The vehicle to decorate with a luggage rack.
     */
    public PorteDeBagages(Vehicule vehicule) {
        super(vehicule);
    }

    @Override
    public String getDescription() {
        return decoratedVehicule.getDescription() + " avec porte de bagages ";
    }

}
