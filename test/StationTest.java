import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class StationTest {

    private Stations station;
    private Vehicule bike1, bike2;

    @BeforeEach
    void setUp() {
        station = new Stations(1, 2); // Station avec une capacité de 2 vélos
        bike1 = new Bike(1, "Vélo classique", EtatVehicule.EN_SERVICE);
        bike2 = new Bike(2, "Vélo électrique", EtatVehicule.EN_SERVICE);
    }

    @Test
    void testIsVide() {
        assertTrue(station.isVide());
    }

    @Test
    void testIsPleine() {
        station.deposerVehicule(bike1);
        station.deposerVehicule(bike2);
        assertTrue(station.isPleine());
    }

    @Test
    void testRetirerVehicule() {
        station.deposerVehicule(bike1);
        Vehicule retiré = station.retirerVehicule();
        assertEquals(bike1, retiré);
        assertTrue(station.getVehiculeDispo().isEmpty());
    }

    @Test
    void testDeposerVehicule() {
        station.deposerVehicule(bike1);
        assertEquals(1, station.getVehiculeDispo().size());
        assertTrue(station.getVehiculeDispo().contains(bike1));
    }

}