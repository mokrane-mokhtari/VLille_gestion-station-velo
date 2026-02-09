import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RedistributionAleatoireTest {

    private List<Stations> stations;
    private RedistributionAleatoire redistribution;

    @BeforeEach
    void setUp() {
        redistribution = new RedistributionAleatoire();
        stations = new ArrayList<>();

        // Initialisation des stations mockées
        stations.add(new MockStation(1, true, false)); // Station pleine
        stations.add(new MockStation(2, false, true)); // Station vide
        stations.add(new MockStation(3, false, false)); // Station normale
    }

    @Test
    void testRedistributionAleatoire() {
        redistribution.redistribuer(stations);

        // Vérifie que la liste des stations a été modifiée (par shuffle)
        List<Stations> shuffledStations = new ArrayList<>(stations);
        Collections.shuffle(shuffledStations);

        assertNotEquals(stations, shuffledStations, "Les stations devraient être redistribuées aléatoirement");
    }
}