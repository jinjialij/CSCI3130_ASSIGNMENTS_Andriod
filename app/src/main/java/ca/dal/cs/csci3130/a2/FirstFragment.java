package ca.dal.cs.csci3130.a2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class FirstFragment extends Fragment {
    EditText name;
    TextView errorMessageForName;
    TextView errorMessageForEmail;
    EditText email;
    Button registerBtn;
    Button loginBtn;
    DatabaseReference db;
//    ArrayList<User> users;
    Map<String, User> userMap;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        db = FirebaseDatabase.getInstance().getReference();
        userMap =  new HashMap<>();
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        name = (EditText) view.findViewById(R.id.editTextName);
        email = (EditText) view.findViewById(R.id.editTextEmail);
        errorMessageForName = (TextView) view.findViewById(R.id.errorMessageNameView);
        errorMessageForEmail = (TextView) view.findViewById(R.id.errorMessageEmailView);
        registerBtn = (Button) view.findViewById(R.id.buttonRegister);
        loginBtn = (Button) view.findViewById(R.id.buttonLogin);

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean validName = !name.getText().toString().isEmpty();
                boolean validEmail= !email.getText().toString().isEmpty();

                if (!validName){
                    errorMessageForName.setText("Username is empty");
                }
                else if (!ValidationHelper.isValidName(name.getText().toString())){
                    errorMessageForName.setText("Username is non-alphanumeric");
                    validName = false;
                }

                if (!validEmail){
                    errorMessageForEmail.setText("Email is empty");
                }
                else if (!ValidationHelper.isValidEmail(email.getText().toString())){
                    errorMessageForEmail.setText("Invalid Email address");
                    validEmail = false;
                }

                if (validName && validEmail) {
                    errorMessageForName.setText("");
                    errorMessageForEmail.setText("");
                    boolean result = UserService.registerNewUser(db, name.getText().toString(), email.getText().toString());

                    if(result) {
                        Bundle bundle = new Bundle();
                        bundle.putString("registerMessage","Welcome " + name.getText().toString() +"!\nA welcome email was sent to " + email.getText().toString());
                        bundle.putString("result", "Successful registration!");
                        Fragment fragment = new Fragment();
                        fragment.setArguments(bundle);
                        getParentFragmentManager()
                                .beginTransaction()
                                .add(fragment, null)
                                .commit();


                        NavHostFragment.findNavController(FirstFragment.this)
                                .navigate(R.id.action_FirstFragment_to_SecondFragment);
                    }
                    else{
                        errorMessageForEmail.setText("Registration failed.");
                    }
                }
            }
        });
        UserService.readData(db, userMap);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                boolean validName = !name.getText().toString().isEmpty();
                boolean validEmail= !email.getText().toString().isEmpty();

                if (!validName){
                    errorMessageForName.setText("Username is empty");
                }
                else if (!ValidationHelper.isValidName(name.getText().toString())){
                    errorMessageForName.setText("Username is non-alphanumeric");
                    validName = false;
                }

                if (!validEmail){
                    errorMessageForEmail.setText("Email is empty");
                }
                else if (!ValidationHelper.isValidEmail(email.getText().toString())){
                    errorMessageForEmail.setText("Invalid Email address");
                    validEmail = false;
                }

                if (validName && validEmail) {
                    errorMessageForName.setText("");
                    errorMessageForEmail.setText("");
                    boolean result = UserService.accountExists(name.getText().toString(), email.getText().toString(), userMap);
                    if(result) {
                        Bundle bundle = new Bundle();
                        bundle.putString("loginMessage","Welcome back, " + name.getText().toString() + "!");
                        Fragment fragment = new Fragment();
                        fragment.setArguments(bundle);
                        getParentFragmentManager()
                                .beginTransaction()
                                .add(fragment, null)
                                .commit();

                        NavHostFragment.findNavController(FirstFragment.this)
                                .navigate(R.id.action_FirstFragment_to_SecondFragment);
                    }
                    else{
                        errorMessageForEmail.setText("Login failed.");
                    }
                }
            }
        });
    }
}