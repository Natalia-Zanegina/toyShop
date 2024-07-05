package toyShop;

public class Main {

    public static void main(String[] args) throws Exception {
        Lottery lottery = new Lottery(10);
        for (int i = 0; i < 5; i++) {
            lottery.start();
        }
        lottery.stop();
    }
}
