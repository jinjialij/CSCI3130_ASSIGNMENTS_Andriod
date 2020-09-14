package ca.dal.cs.csci3130.a1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button submitBtn;
    PopupWindow popupWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        submitBtn = (Button) findViewById(R.id.submitBtn);
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater layoutInflater = (LayoutInflater) MainActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View customView = layoutInflater.inflate(R.layout.layout_popup, null);
                //create a pop up window, using layout_popup as the content view
                popupWindow = new PopupWindow(customView, LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT, true);

                //let the popup window shows at the center of the activity_main page
                View root = LayoutInflater.from(MainActivity.this).inflate(R.layout.activity_main, null);
                popupWindow.showAtLocation(root, Gravity.CENTER, 0, 0);

                //get the input value of editText1
                EditText editText1 = (EditText) findViewById(R.id.editText1);

                //get the result TextView object in the layout_popup and set its text value to the editText1's value
                TextView result = (TextView) popupWindow.getContentView().findViewById(R.id.result);
                result.setText("Result: "+editText1.getText().toString());

                //create a button to close the popup window
                Button closeBtn = (Button) popupWindow.getContentView().findViewById(R.id.closeBtn);
                closeBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popupWindow.dismiss();
                    }
                });
            }
        });
    }
}