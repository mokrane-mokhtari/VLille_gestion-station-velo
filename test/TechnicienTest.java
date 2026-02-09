import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TechnicienTest {

    private Technicien technicien;
    private Vehicule bike1;

    @BeforeEach
    void setUp() {
        // Initialisation de la liste des véhicules à réparer
        List<Vehicule> ListeVehicules = new ArrayList<>();
        technicien = new Technicien("Jean Dupont", "123 Rue des Artisans", ListeVehicules) {
        };
        bike1 = new Bike(1, "Vélo tout-terrain", EtatVehicule.HORS_SERVICE);
    }

    @Test
    void testEffectuerOperation() {
        // Appel de la méthode effectuerOperation
        technicien.effectuerOperation(bike1);
        assertDoesNotThrow(() -> technicien.effectuerOperation(bike1));
    }

    @Test
    void testTechnicienInitialisation() {
        assertEquals("Jean Dupont", technicien.nom);
        assertEquals("123 Rue des Artisans", technicien.adresse);
        assertTrue(technicien.ListeVehicules.isEmpty());
    }

    @Test
    void testAjouterVehicule() {
        // Ajoute un véhicule à la liste des véhicules à réparer
        technicien.ListeVehicules.add(bike1);
        assertEquals(1, technicien.ListeVehicules.size());
        assertEquals(bike1, technicien.ListeVehicules.get(0));
    }
}