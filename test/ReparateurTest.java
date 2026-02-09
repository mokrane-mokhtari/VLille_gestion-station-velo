import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ReparateurTest {

    private Reparateur reparateur;
    private Bike bike1;

    @BeforeEach
    void setUp() {
        // Création d'une liste de véhicules
        List<Vehicule> ListeVehicules = new ArrayList<>();
        bike1 = new Bike(1, "Vélo tout-terrain", EtatVehicule.HORS_SERVICE);
        ListeVehicules.add(bike1); // Ajoute un vélo à la liste

        // Initialisation d'un Humain (Reparateur dans ce cas)
        reparateur = new Reparateur("Jean Réparateur", "456 Avenue des Lille", ListeVehicules);

    }

    @Test
    void testHumainAttributes() {
        // Vérifie que les attributs de la classe Humain sont correctement initialisés
        assertEquals("Jean Réparateur", reparateur.getNom());
        assertEquals("456 Avenue des Lille", reparateur.getAdresse());

        // Vérifie que la liste des véhicules n'est pas vide
        assertNotNull(reparateur.getListeVehicules(), "La liste des véhicules ne doit pas être nulle");
        assertFalse(reparateur.getListeVehicules().isEmpty(), "La liste des véhicules ne doit pas être vide");

        // Vérifie que bike1 est bien dans la liste des véhicules
        assertTrue(reparateur.getListeVehicules().contains(bike1), "La liste des véhicules doit contenir bike1");
    }

    @Test
    void testEffectuerOperation() {
        // Vérificayion que etat est HORS_SERVICE
        assertEquals(EtatVehicule.HORS_SERVICE, bike1.getEtat());
        // Appel de la méthode effectuerOperation via le réparateur
        reparateur.effectuerOperation(bike1);
        // Vérifie que l'état du véhicule a été modifié correctement
        assertEquals(EtatVehicule.EN_SERVICE, bike1.getEtat());
    }

}
