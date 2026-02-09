import java.util.ArrayList;
import java.util.List;

class MockObservateur implements Observateur {
    private final List<String> notifications = new ArrayList<>();

    @Override
    public void notifier(String message, Stations station) {
        notifications.add(message + " (Station ID: " + station.getIdStation() + ")");
    }

    public List<String> getNotifications() {
        return notifications;
    }
}