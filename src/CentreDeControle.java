import java.util.List;

public class CentreDeControle implements Observateur {
    private List<Stations> stations; // Liste des stations surveillées
    private StrategyRedistribution strategy; // Stratégie utilisée pour redistribuer les véhicules

    /**
     * Constructor for the CentreDeControle class.
     * Initializes the control center with a list of stations and a redistribution
     * strategy.
     *
     * @param stations The list of stations to monitor.
     * @param strategy The redistribution strategy to apply.
     */
    public CentreDeControle(List<Stations> stations, StrategyRedistribution strategy) {
        this.stations = stations;
        this.strategy = strategy;
    }

    public List<Stations> getStations() {
        return stations;
    }

    public StrategyRedistribution getStrategy() {
        return strategy;
    }

    /**
     * Notifies the control center of an event in a station.
     * Handles the station's status and applies redistribution if necessary.
     *
     * @param message The notification message from the station.
     * @param station The station sending the notification.
     */
    @Override
    public void notifier(String message, Stations station) {
        // Afficher la notification reçue
        System.out.println("Notification reçue du centre de contrôle : " + message + " (Station ID: "
                + station.getIdStation() + ")");
        // Gérer l'état de la station concernée
        gererEtatStation(station);
    }

    /**
     * Handles the status of a station to determine if redistribution is needed.
     * Applies the redistribution strategy if the station is full or empty.
     *
     * @param station The station to evaluate.
     */
    private void gererEtatStation(Stations station) {
        if (station.isPleine()) {
            // Si la station est pleine, redistribuer à partir de la liste complète des
            // stations
            System.out.println("La station " + station.getIdStation() + " est pleine. Redistribution en cours...");
            strategy.redistribuer(stations);
        } else if (station.isVide()) {
            // Si la station est vide, redistribuer à partir de la liste complète des
            // stations
            System.out.println("La station " + station.getIdStation() + " est vide. Redistribution en cours...");
            strategy.redistribuer(stations);
        }
    }
}
