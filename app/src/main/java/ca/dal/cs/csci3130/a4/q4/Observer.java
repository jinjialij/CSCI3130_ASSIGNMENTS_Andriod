package ca.dal.cs.csci3130.a4.q4;

public abstract class Observer {
    protected Auctioneer auctioneer;
    protected int currentPrice;

    public abstract void update(int newPrice);

    public abstract int getCurrentPrice();
}
