import java.util.ArrayList;

public class GameTicker implements Subject {

    private ArrayList<String> updates;
    private ArrayList<Observer> observers;

    public GameTicker() {
        updates = new ArrayList<>();
        observers = new ArrayList<>();
    }

    public void addUpdate(String text) {
        updates.add(text);
        notifyObservers();
    }

    public String getLatestUpdate() {
        if (updates.isEmpty()) {
            return "No updates available.";
        }

        return updates.get(updates.size() - 1);
    }

    @Override
    public void register(Observer o) {
        observers.add(o);
    }

    @Override
    public void remove(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}
