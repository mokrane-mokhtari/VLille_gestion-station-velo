import java.util.List;

public abstract class Humain {

    public String nom;
    public String adresse;
    public List<Vehicule> ListeVehicules;

    /**
     * Constructor for the Humain class.
     * Initializes a human with their name, address, and a list of vehicles.
     *
     * @param nom            The name of the human.
     * @param adresse        The address of the human.
     * @param ListeVehicules The list of vehicles associated with the human.
     */
    public Humain(String nom, String adresse, List<Vehicule> ListeVehicules) {
        this.nom = nom;
        this.adresse = adresse;
        this.ListeVehicules = ListeVehicules;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return this.adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public List<Vehicule> getListeVehicules() {
        return ListeVehicules;
    }

    public void setListeVehicules(List<Vehicule> ListeVehicules) {
        this.ListeVehicules = ListeVehicules;
    }

    /**
     * Performs an operation on a vehicle.
     * This method must be implemented by concrete subclasses.
     *
     * @param vehicule The vehicle on which the operation is performed.
     */
    public abstract void effectuerOperation(Vehicule vehicule);

}
