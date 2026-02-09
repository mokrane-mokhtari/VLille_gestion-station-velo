import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PeintreTest {

    private Peintre peintre;
    private Vehicule bike1;

    @BeforeEach
    void setUp() {
        // Initialisation de la liste des véhicules à réparer
        List<Vehicule> vehiculesARepare = new ArrayList<>();
        peintre = new Peintre("Jean Dupont", "123 Rue des Artisans", vehiculesARepare);

        // Création d'une instance de véhicule (ou classe concrète dérivée de Vehicule)
        bike1 = new Bike(1, "Vélo tout-terrain", EtatVehicule.HORS_SERVICE);
    }

    @Test
    void testEffectuerOperation() {
        // Vérifie que l'état initial du véhicule est HORS_SERVICE
        assertEquals(EtatVehicule.HORS_SERVICE, bike1.getEtat());

        // Appel de la méthode effectuerOperation
        peintre.effectuerOperation(bike1);

        // Vérifie que l'état du véhicule a été changé en EN_SERVICE
        assertEquals(EtatVehicule.EN_SERVICE, bike1.getEtat());
    }

    @Test
    void testPeintreInitialisation() {
        // Vérifie que le peintre est bien initialisé
        assertEquals("Jean Dupont", peintre.nom);
        assertEquals("123 Rue des Artisans", peintre.adresse);
        assertTrue(peintre.ListeVehicules.isEmpty());
    }
}