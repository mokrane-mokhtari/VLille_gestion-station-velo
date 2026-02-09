import java.util.ArrayList;
import java.util.List;

public class Stations implements Sujet {

    protected int idStation;
    protected int capacite;
    protected List<Vehicule> vehiculeDispo; // la liste des vehicule dans une station
    private List<Observateur> observateurs; // Liste des observateurs

    /**
     * Constructor for the Stations class.
     * Initializes a station with a unique ID and a specific capacity.
     *
     * @param idStation The unique identifier of the station.
     * @param capacite  The maximum capacity of the station.
     */
    public Stations(int idStation, int capacite) {
        this.idStation = idStation;
        this.capacite = capacite;
        this.vehiculeDispo = new ArrayList<>();
        this.observateurs = new ArrayList<>();
    }

    public int getIdStation() {
        return this.idStation;
    }

    public int getCapacite() {
        return this.capacite;
    }

    public List<Vehicule> getVehiculeDispo() {
        return this.vehiculeDispo;
    }

    public boolean isPleine() {
        return vehiculeDispo.size() >= capacite;
    }

    public boolean isVide() {
        return vehiculeDispo.isEmpty();
    }

    /**
     * Deposits a vehicle at the station.
     * Notifies observers if successful.
     *
     * @param vehicule The vehicle to deposit.
     */
    public void deposerVehicule(Vehicule vehicule) {
        if (vehiculeDispo.size() < capacite) {
            vehiculeDispo.add(vehicule);
            System.out.println("Le véhicule " + vehicule.getDescription() + " (ID" + vehicule.getId() + ")"
                    + " est déposé à la station " + idStation);
            notifierObservateurs("Véhicule déposé: " + vehicule.getDescription(), this);

        } else {
            System.out.println("La station " + idStation + " est pleine.");
        }
    }

    /**
     * Withdraws a vehicle from the station.
     * Notifies observers if successful.
     *
     * @return The withdrawn vehicle, or {@code null} if the station is empty.
     */
    public Vehicule retirerVehicule() {
        if (!vehiculeDispo.isEmpty()) {
            Vehicule vehicule = vehiculeDispo.remove(0);
            System.out.println("Le véhicule " + vehicule.getDescription() + "  " + vehicule.getId()
                    + " est retiré de la station " + idStation);
            notifierObservateurs("Véhicule retiré", this);
            return vehicule;
        } else {
            System.out.println("La station " + idStation + " est vide.");
            return null;
        }
    }

    /**
     * Withdraws a vehicle from the station.
     * Notifies observers if successful.
     *
     * @return The withdrawn vehicle, or {@code null} if the station is empty.
     */
    @Override
    public void ajouterObservateur(Observateur observateur) {
        if (!observateurs.contains(observateur)) {
            observateurs.add(observateur);
        }
    }

    /**
     * Adds an observer to this station.
     *
     * @param observateur The observer to add.
     */
    @Override
    public void retirerObservateur(Observateur observateur) {
        observateurs.remove(observateur);
    }

    /**
     * Notifies all observers of this station.
     *
     * @param message The notification message.
     * @param station The station triggering the notification.
     */
    @Override
    public void notifierObservateurs(String message, Stations station) {
        for (Observateur observateur : observateurs) {
            observateur.notifier(message, station);
        }
    }
}
