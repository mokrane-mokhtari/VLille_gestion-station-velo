import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TechnicienFactoryTest {

    @Test
    void testCreerReparateur() {
        List<Vehicule> vehicules = new ArrayList<>();
        Technicien reparateur = TechnicienFactory.creerTechnicien("reparateur", "Jean Réparateur", "123 Rue Réparation",
                vehicules);

        // Vérifie que l'objet est créé et est une instance de Reparateur
        assertNotNull(reparateur, "La factory aurait dû créer un technicien.");
        assertTrue(reparateur instanceof Reparateur, "Le technicien aurait dû être un Reparateur.");

        // Vérifie les attributs
        assertEquals("Jean Réparateur", reparateur.getNom());
        assertEquals("123 Rue Réparation", reparateur.getAdresse());
        assertEquals(vehicules, reparateur.getListeVehicules());
    }

    @Test
    void testCreerPeintre() {
        List<Vehicule> vehicules = new ArrayList<>();
        Technicien peintre = TechnicienFactory.creerTechnicien("peintre", "Marie Peintre", "456 Rue Artistes",
                vehicules);

        // Vérifie que l'objet est créé et est une instance de Peintre
        assertNotNull(peintre, "La factory aurait dû créer un technicien.");
        assertTrue(peintre instanceof Peintre, "Le technicien aurait dû être un Peintre.");

        // Vérifie les attributs
        assertEquals("Marie Peintre", peintre.getNom());
        assertEquals("456 Rue Artistes", peintre.getAdresse());
        assertEquals(vehicules, peintre.getListeVehicules());
    }

    @Test
    void testCreerTechnicienTypeInconnu() {
        List<Vehicule> vehicules = new ArrayList<>();

        // Vérifie qu'une exception est levée pour un type inconnu
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            TechnicienFactory.creerTechnicien("inconnu", "Alex Mystère", "789 Rue Cachée", vehicules);
        });

        // Vérifie le message de l'exception
        assertEquals("Type de technicien inconnu : inconnu", exception.getMessage());
    }
}