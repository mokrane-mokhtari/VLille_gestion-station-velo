
public class Panier extends Accessoire {

    /**
     * Constructor for the Panier class.
     * Adds a basket to the given vehicle.
     *
     * @param vehicule The vehicle to decorate with a basket.
     */
    public Panier(Vehicule vehicule) {
        super(vehicule);
    }

    @Override
    public String getDescription() {
        return decoratedVehicule.getDescription() + " avec panier ";
    }
}
