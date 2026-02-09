import java.util.List;

public class TechnicienFactory {
    public static Technicien creerTechnicien(String type, String nom, String adresse, List<Vehicule> ListeVehicules) {
        switch (type.toLowerCase()) {
            case "reparateur":
                return new Reparateur(nom, adresse, ListeVehicules);
            case "peintre":
                return new Peintre(nom, adresse, ListeVehicules);
            default:
                throw new IllegalArgumentException("Type de technicien inconnu : " + type);
        }
    }
}
