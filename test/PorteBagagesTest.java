import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PorteBagagesTest {

    @Test
    void testGetEtat() {
        Vehicule bike = new Bike(1, "Vélo tout-terrain", EtatVehicule.EN_SERVICE);
        PorteDeBagages porteDeBagages = new PorteDeBagages(bike);

        // Vérifie que l'état reste inchangé
        assertEquals(EtatVehicule.EN_SERVICE, porteDeBagages.getEtat());
    }

    @Test
    void testGetDescription() {
        Vehicule bike = new Bike(1, "Vélo tout-terrain", EtatVehicule.EN_SERVICE);
        PorteDeBagages porteDeBagages = new PorteDeBagages(bike);

        // Vérifie que la description inclut le porte-bagages
        assertEquals("Vélo tout-terrain avec porte de bagages ", porteDeBagages.getDescription());
    }

}
