class MockStation extends Stations {

    private boolean pleine;
    private boolean vide;

    public MockStation(int id, boolean pleine, boolean vide) {
        super(id, 10); // Capacité fictive
        this.pleine = pleine;
        this.vide = vide;
    }

    @Override
    public boolean isPleine() {
        return pleine;
    }

    @Override
    public boolean isVide() {
        return vide;
    }

    @Override
    public Vehicule retirerVehicule() {
        return new Bike(1, "Mock Bike", EtatVehicule.EN_SERVICE);
    }

    @Override
    public void deposerVehicule(Vehicule vehicule) {
    }
}