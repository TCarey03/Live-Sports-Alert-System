public class MobilePushNotification implements Observer {

    private GameTicker ticker;

    public MobilePushNotification(GameTicker ticker) {
        this.ticker = ticker;
    }

    @Override
    public void update() {
        System.out.println("PUSH ALERT: " + ticker.getLatestUpdate());
    }
}
