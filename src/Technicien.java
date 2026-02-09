
import java.util.List;

public abstract class Technicien extends Humain {
    /**
     * Constructor for the Technicien class.
     * Initializes a technician with their name, address, and a list of vehicles.
     *
     * @param nom            The name of the technician.
     * @param adresse        The address of the technician.
     * @param ListeVehicules The list of vehicles associated with the technician.
     */
    public Technicien(String nom, String adresse, List<Vehicule> ListeVehicules) {
        super(nom, adresse, ListeVehicules);
    }

    /**
     * Performs an operation on a vehicle.
     * This generic method displays a message indicating the technician is working
     * on the vehicle.
     * Subclasses may override this method to define specific behaviors.
     *
     * @param vehicule The vehicle being worked on.
     */
    public void effectuerOperation(Vehicule vehicule) {
        System.out.println("Le technicien " + nom + " travaille sur le véhicule : " + vehicule.getDescription());
    }

}
