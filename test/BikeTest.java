import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BikeTest {

    private Bike bike1;
    private Bike bike2;

    @BeforeEach
    void setUp() {
        bike1 = new Bike(1, "Bike1", EtatVehicule.EN_SERVICE);
        bike2 = new Bike(2, "Bike2", EtatVehicule.HORS_SERVICE);
    }

    @Test
    void testEquals() {
        Bike bike3 = new Bike(1, "bike3", EtatVehicule.EN_SERVICE);
        assertTrue(bike1.equals(bike3));
        assertFalse(bike1.equals(bike2));
        assertFalse(bike1.equals(null));
        assertFalse(bike1.equals("Not a bike"));
    }

    @Test
    void testToString() {
        String expected1 = "bike id: 1 Bike1 EN_SERVICE";
        String expected2 = "bike id: 2 Bike2 HORS_SERVICE";
        assertEquals(expected1, bike1.toString());
        assertEquals(expected2, bike2.toString());
    }

    @Test

    public void testIncrementerUtilisationMultiple() {
        bike1.incrementerUtilisation();
        bike1.incrementerUtilisation();
        assertEquals(2, bike1.getNbUtilisation(), "Le nombre d'utilisations doit être 2 après deux incrémentations");
    }

    /*
     * @Test
     * void testGetId() {
     * assertEquals(1, bike1.getId());
     * assertEquals(2, bike2.getId());
     * }
     * 
     * @Test
     * void testGetDescription() {
     * assertEquals("Bike1", bike1.getDescription());
     * assertEquals("Bike2", bike2.getDescription());
     * }
     * 
     * @Test
     * void testGetEtat() {
     * assertEquals(EtatVehicule.EN_SERVICE, bike1.getEtat());
     * assertEquals(EtatVehicule.HORS_SERVICE, bike2.getEtat());
     * 
     * }
     */
}