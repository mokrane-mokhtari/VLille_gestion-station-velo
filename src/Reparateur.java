
import java.util.List;

public class Reparateur extends Technicien {
    /**
     * Constructor for the Reparateur class.
     * Initializes a repair technician with their name, address, and a list of
     * vehicles.
     *
     * @param nom            The name of the repair technician.
     * @param adresse        The address of the repair technician.
     * @param ListeVehicules The list of vehicles associated with the repair
     *                       technician.
     */
    public Reparateur(String nom, String adresse, List<Vehicule> ListeVehicules) {
        super(nom, adresse, ListeVehicules);
    }

    /**
     * Performs a maintenance operation on a vehicle.
     * This operation changes the vehicle's state to
     * {@link EtatVehicule#EN_SERVICE}.
     *
     * @param vehicule The vehicle to repair.
     */
    @Override
    public void effectuerOperation(Vehicule vehicule) {
        super.effectuerOperation(vehicule);

        vehicule.setEtat(EtatVehicule.EN_SERVICE);
        System.out.println("Vehicule " + vehicule.getDescription() + "est maintenance en service ");

    }
}
