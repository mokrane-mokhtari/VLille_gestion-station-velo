
import java.util.List;

public class Peintre extends Technicien {
    /**
     * Constructor for the Peintre class.
     * Initializes a painter with their name, address, and a list of vehicles.
     *
     * @param nom            The name of the painter.
     * @param adresse        The address of the painter.
     * @param ListeVehicules The list of vehicles associated with the painter.
     */
    public Peintre(String nom, String adresse, List<Vehicule> ListeVehicules) {
        super(nom, adresse, ListeVehicules);
    }

    /**
     * Performs a painting operation on a vehicle.
     * This operation changes the vehicle's state to
     * {@link EtatVehicule#EN_SERVICE}.
     *
     * @param vehicule The vehicle to paint.
     */
    @Override
    public void effectuerOperation(Vehicule vehicule) {
        System.out.println(nom + "effecue une operation de peinture sur le vehicle " + vehicule.getDescription());
        vehicule.setEtat(EtatVehicule.EN_SERVICE); // mettre en service le vehicule apres la peinture
        System.out.println(
                "Vehicule " + vehicule.getDescription() + "est maintenance en service apres la nouvelle peinture  ");

    }

}
