package ca.dal.cs.csci3130.a4.q4;

import java.util.ArrayList;
import java.util.List;

public class Auctioneer {

    private List<Observer> bidders = new ArrayList<>();
    private int price;

    public void attach(Observer bidder) {
        //This method needs modification
        bidders.add(bidder);
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int currentPrice) {
        //This method needs modification
        price = currentPrice;
        notifyAllBidders(price);
    }

    protected void notifyAllBidders(int currentPrice) {
        //This method needs modification
        for (Observer observer : bidders){
            observer.update(currentPrice);
        }
    }
}
