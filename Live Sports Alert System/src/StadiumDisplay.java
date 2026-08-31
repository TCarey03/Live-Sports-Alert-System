public class StadiumDisplay implements Observer {

    private GameTicker ticker;

    public StadiumDisplay(GameTicker ticker) {
        this.ticker = ticker;
    }

    @Override
    public void update() {
        System.out.println("SCREEN UPDATE: " + ticker.getLatestUpdate());
    }
}
