import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AssistanceElectriqueTest {

    @Test
    void testGetDescription() {
        Vehicule bike = new Bike(2, "Vélo de route", EtatVehicule.EN_SERVICE);
        AssistanceElectrique assistanceElectrique = new AssistanceElectrique(bike);

        // Vérifie que la description inclut l'assistance électrique
        assertEquals("Vélo de route avec assistance électrique", assistanceElectrique.getDescription());
    }

    @Test
    void testGetEtat() {
        Vehicule bike = new Bike(2, "Vélo de route", EtatVehicule.HORS_SERVICE);
        AssistanceElectrique assistanceElectrique = new AssistanceElectrique(bike);

        // Vérifie que l'état reste le même que celui du vélo décoré
        assertEquals(EtatVehicule.HORS_SERVICE, assistanceElectrique.getEtat());
    }

}
