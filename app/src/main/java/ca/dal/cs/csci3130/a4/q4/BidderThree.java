package ca.dal.cs.csci3130.a4.q4;

public class BidderThree extends Observer {

    final int THREE = 3;

    public BidderThree(Auctioneer auctioneer) {
        //This constructor needs modification
        this.auctioneer = auctioneer;
        this.auctioneer.attach(this);
    }

    @Override
    public void update(int newPrice) {
        //This method needs modification
        this.currentPrice = THREE + newPrice;
    }

    @Override
    public int getCurrentPrice() {
        return this.currentPrice;
    }
}
