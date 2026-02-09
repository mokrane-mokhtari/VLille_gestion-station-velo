
public interface Vehicule {

    EtatVehicule getEtat(); // permet d'obtenir l etat de vehicule

    int getId();

    void setEtat(EtatVehicule etat); /// permet de modifier l etat du vehicule

    int getNbUtilisation(); // permet d'obtenir le nombre d'utulisation de chaque vehicule

    void incrementerUtilisation(); // permet d'incrementer le nombre d'utulisation de chaque vehicule

    String getDescription(); // permet d'obtenir le description de chaque vehicule

}
