
/**
 * A class to model bike
 * 
 * @author JC
 *
 */
public class Bike implements Vehicule {

   protected int id;
   protected String description;
   protected EtatVehicule etat;
   protected int nbUtilisation;

   /**
    * Constructor for the Bike class.
    *
    * @param id          The unique identifier of the bike.
    * @param description The textual description of the bike.
    * @param etat        The initial state of the bike.
    */
   public Bike(int id, String description, EtatVehicule etat) {
      this.id = id;
      this.description = description;
      this.etat = etat;
      this.nbUtilisation = 0;

   }

   /**
    * @return the reference
    */
   @Override
   public int getId() {
      return this.id;
   }

   public String getDescription() {
      return this.description;
   }

   public void setEtat(EtatVehicule etat) {
      this.etat = etat;
   }

   public EtatVehicule getEtat() {
      return this.etat;
   }

   public int getNbUtilisation() {
      return this.nbUtilisation;
   }

   /**
    * Increments the usage counter of the bike.
    * This method only works if the bike is in service.
    */
   @Override
   public void incrementerUtilisation() {
      if (this.etat == EtatVehicule.EN_SERVICE) {
         this.nbUtilisation++;
      }
   }

   /**
    * Compares this bike to another object by its ID.
    *
    * @param o the object to compare.
    * @return {@code true} if the IDs are identical, otherwise {@code false}.
    */
   public boolean equals(Object o) {
      if (o instanceof Bike) {
         Bike other = (Bike) o;
         return this.id == other.id;
      } else {
         return false;
      }
   }

   public String toString() {
      return "bike id: " + this.id + " " + this.description + " " + this.etat;
   }
}
