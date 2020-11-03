package ca.dal.cs.csci3130.a4;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import ca.dal.cs.csci3130.a4.q4.Auctioneer;
import ca.dal.cs.csci3130.a4.q4.BidderOne;
import ca.dal.cs.csci3130.a4.q4.BidderThree;
import ca.dal.cs.csci3130.a4.q4.BidderTwo;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //attaching the handlers
        Button setPriceButton = (Button) findViewById(R.id.setPriceButton);
        setPriceButton.setOnClickListener(this);
    }

    protected String getPriceText(int price) {
        return String.valueOf(price);
    }

    @Override
    public void onClick(View view) {
        EditText newPriceTextBox = (EditText) findViewById(R.id.newPriceBox);
        int newPrice = Integer.parseInt(newPriceTextBox.getText().toString());

        //create auctioneer and bidders
        Auctioneer auctioneer = new Auctioneer();
        BidderOne bidder1 = new BidderOne(auctioneer);
        BidderTwo bidder2 = new BidderTwo(auctioneer);
        BidderThree bidder3 = new BidderThree(auctioneer);

        //Auctioneer's new price should be immediately notified to the bidders!
        auctioneer.setPrice(newPrice);

        EditText bidder1TextBox = (EditText) findViewById(R.id.bidder1);
        EditText bidder2TextBox = (EditText) findViewById(R.id.bidder2);
        EditText bidder3TextBox = (EditText) findViewById(R.id.bidder3);

        bidder1TextBox.setText(getPriceText(bidder1.getCurrentPrice()));
        bidder2TextBox.setText(getPriceText(bidder2.getCurrentPrice()));
        bidder3TextBox.setText(getPriceText(bidder3.getCurrentPrice()));

    }
}