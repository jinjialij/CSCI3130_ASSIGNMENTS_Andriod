package ca.dal.cs.csci3130.a1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editText1;
    TextView result;
    Button submitBtn;
    AlertDialog.Builder alertBuilder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //get editText1, result, and submitBtn from the activity_main
        editText1 = (EditText) findViewById(R.id.editText1);
        result = (TextView) findViewById(R.id.result);

        alertBuilder = new AlertDialog.Builder(this);

        submitBtn = (Button) findViewById(R.id.submitBtn);
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editText1.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "Please enter a number", Toast.LENGTH_SHORT).show();
                }
                else{
                    result.setText(editText1.getText().toString());
                    alertBuilder.setMessage(result.getText().toString());
                    alertBuilder.setTitle("Result");
                    alertBuilder.setNeutralButton("Close", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });

                    //create dialog box
                    AlertDialog alert = alertBuilder.create();
                    alert.show();
                }
            }
        });
    }
}