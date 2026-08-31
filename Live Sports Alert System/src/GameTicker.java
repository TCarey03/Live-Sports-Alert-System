import java.util.ArrayList;

public class GameTicker {

    private ArrayList<String> updates;

    public GameTicker() {
        updates = new ArrayList<>();
    }

    public void addUpdate(String text) {
        updates.add(text);
    }

    public String getLatestUpdate() {
        if (updates.isEmpty()) {
            return "No updates available.";
        }

        return updates.get(updates.size() - 1);
    }
}