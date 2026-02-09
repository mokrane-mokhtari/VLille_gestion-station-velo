import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StationsTest {

    private Stations station;
    private MockObservateur mockObservateur;

    @BeforeEach
    void setUp() {
        station = new Stations(1, 10); // Station avec une capacité de 10
        mockObservateur = new MockObservateur(); // Initialisation du mock
    }

    @Test
    void testAjouterObservateur() {
        station.ajouterObservateur(mockObservateur);

        // Notifie les observateurs
        station.notifierObservateurs("Test notification ajout", station);

        // Vérifie que le mock a bien reçu la notification
        assertEquals(1, mockObservateur.getNotifications().size(), "L'observateur aurait dû recevoir une notification");
        assertEquals("Test notification ajout (Station ID: 1)", mockObservateur.getNotifications().get(0));
    }

    @Test
    void testRetirerObservateur() {
        station.ajouterObservateur(mockObservateur);
        station.retirerObservateur(mockObservateur);

        // Notifie après retrait
        station.notifierObservateurs("Test notification retrait", station);

        // Vérifie qu'aucune notification n'a été reçue après le retrait
        assertEquals(0, mockObservateur.getNotifications().size(),
                "L'observateur ne doit pas recevoir de notification après son retrait");
    }

    @Test
    void testNotifierSansObservateurs() {
        // Notifie sans ajouter d'observateur
        station.notifierObservateurs("Notification sans observateurs", station);

        // Vérifie qu'aucune notification n'a été reçue
        assertEquals(0, mockObservateur.getNotifications().size(),
                "Aucune notification ne doit être envoyée si aucun observateur n'est enregistré");
    }

}
