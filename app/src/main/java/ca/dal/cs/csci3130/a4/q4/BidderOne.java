package ca.dal.cs.csci3130.a4.q4;

public class BidderOne extends Observer {
    final int FIVE = 5;

    public BidderOne(Auctioneer auctioneer) {
        //This constructor needs modification
        this.auctioneer = auctioneer;
        this.auctioneer.attach(this);
    }

    @Override
    public void update(int newPrice) {
        //This method needs modification
        this.currentPrice = FIVE + newPrice;
    }

    @Override
    public int getCurrentPrice() {
        return this.currentPrice;
    }
}
