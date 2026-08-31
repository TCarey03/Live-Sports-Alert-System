public class SocialMediaBot implements Observer {

    private GameTicker ticker;

    public SocialMediaBot(GameTicker ticker) {
        this.ticker = ticker;
    }

    @Override
    public void update() {
        System.out.println("TWEET: " + ticker.getLatestUpdate() + " #GameDay");
    }
}
