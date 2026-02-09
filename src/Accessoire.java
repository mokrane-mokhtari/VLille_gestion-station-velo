
public abstract class Accessoire implements Vehicule {
    protected Vehicule decoratedVehicule;

    /**
     * Constructor for the Accessoire class.
     * Allows creating an accessory around an existing vehicle.
     *
     * @param decoratedVehicule the vehicle to decorate.
     */
    public Accessoire(Vehicule decoratedVehicule) {
        this.decoratedVehicule = decoratedVehicule;
    }

    @Override
    public int getId() {
        return decoratedVehicule.getId();
    }

    public EtatVehicule getEtat() {
        return decoratedVehicule.getEtat();
    }

    public void setEtat(EtatVehicule etat) {
        decoratedVehicule.setEtat(etat);
    }

    public int getNbUtilisation() {
        return decoratedVehicule.getNbUtilisation();
    }

    @Override
    public void incrementerUtilisation() {
        decoratedVehicule.incrementerUtilisation(); // Délégation à l'objet décoré
    }

    /// methode qui renvoir la description de vehicule
    public String getDescription() {
        return decoratedVehicule.getDescription();
    }

}
