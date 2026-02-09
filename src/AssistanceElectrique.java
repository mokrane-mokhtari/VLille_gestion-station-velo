public class AssistanceElectrique extends Accessoire {
    /**
     * Constructor for the AssistanceElectrique class.
     * Adds electric assistance to the given vehicle.
     *
     * @param vehicule The vehicle to decorate with electric assistance.
     */
    public AssistanceElectrique(Vehicule vehicule) {
        super(vehicule);
    }

    @Override
    public String getDescription() {
        return decoratedVehicule.getDescription() + " avec assistance électrique";
    }

}