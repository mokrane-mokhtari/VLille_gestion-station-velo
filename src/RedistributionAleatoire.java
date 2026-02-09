import java.util.Collections;
import java.util.List;

public class RedistributionAleatoire implements StrategyRedistribution {
    /**
     * Redistributes vehicles randomly between stations.
     * Stations are shuffled before redistribution, and vehicles are moved
     * from full stations to non-full stations.
     *
     * @param stations The list of stations to be considered for redistribution.
     */
    @Override
    public void redistribuer(List<Stations> stations) {
        System.out.println("Redistribution aléatoire en cours...");

        Collections.shuffle(stations);

        for (Stations station : stations) {

            if (station.isPleine()) {

                Vehicule vehicule = station.retirerVehicule();
                if (vehicule != null) {

                    for (Stations cible : stations) {
                        if (!cible.isPleine()) {
                            cible.deposerVehicule(vehicule);
                            break;
                        }
                    }
                }
            }
        }
    }
}