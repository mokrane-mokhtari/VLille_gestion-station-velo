import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PanierTest {

    @Test
    void testGetDescription() {
        Vehicule bike = new Bike(1, "Vélo tout-terrain", EtatVehicule.EN_SERVICE);
        Panier panier = new Panier(bike);

        // Vérifie que la description inclut le panier
        assertEquals("Vélo tout-terrain avec panier ", panier.getDescription());
    }

    @Test
    void testGetEtat() {
        Vehicule bike = new Bike(1, "Vélo tout-terrain", EtatVehicule.EN_SERVICE);
        Panier panier = new Panier(bike);

        // Vérifie que l'état reste inchangé
        assertEquals(EtatVehicule.EN_SERVICE, panier.getEtat());
    }
}