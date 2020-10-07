package ca.dal.cs.csci3130.a2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import java.util.regex.Pattern;

public class FirstFragment extends Fragment {
    EditText name;
    TextView errorMessageForName;
    TextView errorMessageForEmail;
    EditText email;
    Button registerBtn;

    Pattern emailRegex = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
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

        view.findViewById(R.id.buttonRegister).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean validName = false;
                boolean validEmail = false;
                if (name.getText().toString().isEmpty()){
                    errorMessageForName.setText("Username is empty");
                }
                else if (name.getText().toString().matches("^.*[^a-zA-Z0-9 ].*$")){
                    errorMessageForName.setText("Username is non-alphanumeric");
                }
                else{
                    validName = true;
                }

                if (email.getText().toString().isEmpty()){
                    errorMessageForEmail.setText("Email is empty");
                }
                else if (!emailRegex.matcher(email.getText().toString()).find()){
                    errorMessageForEmail.setText("Invalid Email address");
                }
                else{
                    validEmail = true;
                }

                if (validName && validEmail) {
                    errorMessageForName.setText("");
                    errorMessageForEmail.setText("");
                    NavHostFragment.findNavController(FirstFragment.this)
                            .navigate(R.id.action_FirstFragment_to_SecondFragment);
                }
            }
        });
    }
}