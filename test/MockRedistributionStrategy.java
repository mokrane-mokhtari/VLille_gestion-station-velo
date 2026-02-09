import java.util.List;

public class MockRedistributionStrategy implements StrategyRedistribution {

    private boolean redistribuerCalled = false;
    private List<Stations> redistributedStations;

    @Override
    public void redistribuer(List<Stations> stations) {
        this.redistribuerCalled = true;
        this.redistributedStations = stations;
    }

    public boolean isRedistribuerCalled() {
        return redistribuerCalled;
    }

    public List<Stations> getRedistributedStations() {
        return redistributedStations;
    }
}
