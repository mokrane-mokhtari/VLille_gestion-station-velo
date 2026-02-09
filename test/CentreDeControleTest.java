import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

// Classe de test pour CentreDeControle
public class CentreDeControleTest {

    private List<Stations> stations;
    private CentreDeControle centreDeControle;
    private MockRedistributionStrategy mockStrategy;

    @BeforeEach
    public void setUp() {
        // Initialisation des stations
        MockStation station1 = new MockStation(1, false, false);
        MockStation station2 = new MockStation(2, false, true);
        MockStation station3 = new MockStation(3, true, false);

        // Ajouter les stations à la liste
        stations = new ArrayList<>();
        stations.add(station1);
        stations.add(station2);
        stations.add(station3);

        // Utilisation d'une stratégie de redistribution fictive pour les tests
        mockStrategy = new MockRedistributionStrategy();
        centreDeControle = new CentreDeControle(stations, mockStrategy);
    }

    @Test
    public void testNotifierStationVide() {
        Stations stationVide = stations.get(1); // Station vide (aucun véhicule)
        centreDeControle.notifier("Station vide", stationVide);

        // Vérification que la méthode redistribuer a été appelée
        assertTrue(mockStrategy.isRedistribuerCalled());
        // Vérification que la liste des stations passées à redistribuer est correcte
        assertEquals(stations, mockStrategy.getRedistributedStations());
    }

    @Test
    public void testNotifierStationNormale() {
        Stations stationNormale = stations.get(0); // Station avec des véhicules mais pas pleine
        centreDeControle.notifier("Station normale", stationNormale);

        // Vérification que la méthode redistribuer n'a pas été appelée
        assertFalse(mockStrategy.isRedistribuerCalled());
    }

    @Test
    public void testNotifierStationPleine() {
        Stations stationPleine = stations.get(2); // Station pleine
        centreDeControle.notifier("Station pleine", stationPleine);

        // Vérification que la méthode redistribuer a été appelée
        assertTrue(mockStrategy.isRedistribuerCalled());
        assertEquals(stations, mockStrategy.getRedistributedStations());
    }

    @Test
    public void testConstructeurInitialisation() {
        // Vérifie que les stations et la stratégie sont correctement initialisées
        assertEquals(stations, centreDeControle.getStations());
        assertEquals(mockStrategy, centreDeControle.getStrategy());
    }
}
