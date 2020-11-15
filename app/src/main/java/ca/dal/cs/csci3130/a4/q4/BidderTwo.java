package ca.dal.cs.csci3130.a4.q4;

public class BidderTwo extends Observer {

    final int TEN = 10;

    public BidderTwo(Auctioneer auctioneer) {
        //This constructor needs modification
        this.auctioneer = auctioneer;
        this.auctioneer.attach(this);
    }

    @Override
    public void update(int newPrice) {
        //This method needs modification
        this.currentPrice = TEN + newPrice;
    }

    @Override
    public int getCurrentPrice() {
        return this.currentPrice;
    }
}
