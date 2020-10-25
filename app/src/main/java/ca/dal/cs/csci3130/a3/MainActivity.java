package ca.dal.cs.csci3130.a3;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.addDogList();
        this.addVehicleList();

        Button check = (Button) findViewById(R.id.checkButton);

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                TextView result = (TextView) findViewById(R.id.result);
                Spinner dogList = (Spinner) findViewById(R.id.dogList);
                Spinner vehicleList = (Spinner) findViewById(R.id.vehicleList);
                String dogSelected = dogList.getSelectedItem().toString();
                String vehicleSelected = vehicleList.getSelectedItem().toString();

                Dog dog = getDog(dogSelected);
                Vehicle vehicle = getVehicle(vehicleSelected);

                if(dog.getSpeed() >= vehicle.getAverageSpeed()){
                    result.setText(dogSelected);
                }
                else{
                    result.setText(vehicleSelected);
                }
            }
        });
    }

    protected void addDogList() {
        Spinner dogList = (Spinner) findViewById(R.id.dogList);
        List<String> dogs = new ArrayList<String>();
        dogs.add("HUSKY");
        dogs.add("DALMATIAN");
        dogs.add("BULLDOG");
        @SuppressLint("ResourceType") ArrayAdapter<String> dogListAdapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, dogs);
        dogListAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        dogList.setAdapter(dogListAdapter);
    }

    protected void addVehicleList() {
        Spinner vehicleList = (Spinner) findViewById(R.id.vehicleList);
        List<String> vehicles = new ArrayList<String>();
        vehicles.add("BUS");
        vehicles.add("TRUCK");
        @SuppressLint("ResourceType") ArrayAdapter<String> vehicleListAdapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, vehicles);
        vehicleListAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        vehicleList.setAdapter(vehicleListAdapter);
    }

    protected Dog getDog(String dogSelected){
        Dog dog;
        if (dogSelected.equals("HUSKY")){
            dog = new Husky();
        }
        else if (dogSelected.equals("DALMATIAN")){
            dog = new Dalmatian();
        }
        else {
            dog = new BullDog();
        }

        return dog;
    }

    protected Vehicle getVehicle(String vehicleSelected){
        Vehicle vehicle;
        if (vehicleSelected.equals("BUS")){
            vehicle = new Bus(4, 60);
        }
        else {
            vehicle = new Truck(4, 80);
        }

        return vehicle;
    }
}