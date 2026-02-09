import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EtatVehiculeTest {

    @Test
    void testEtatVehicule() {
        EtatVehicule etat = EtatVehicule.EN_SERVICE;
        assertEquals("EN_SERVICE", etat.name());

        etat = EtatVehicule.HORS_SERVICE;
        assertEquals("HORS_SERVICE", etat.name());
    }
}