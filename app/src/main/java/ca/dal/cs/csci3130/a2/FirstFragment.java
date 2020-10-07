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

public class FirstFragment extends Fragment {
    EditText name;
    TextView errorMessageForName;
    TextView errorMessageForEmail;
    EditText email;
    Button registerBtn;

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
                boolean validName = true;
                boolean validEmail=true;
                if (name.getText().toString().isEmpty()){
                    errorMessageForName.setText("Username is empty");
                    validName = false;
                }
                else if (!validationHelper.isValidName(name.getText().toString())){
                    errorMessageForName.setText("Username is non-alphanumeric");
                    validName = false;
                }

                if (email.getText().toString().isEmpty()){
                    errorMessageForEmail.setText("Email is empty");
                    validEmail = false;
                }
                else if (!validationHelper.isValidEmail(email.getText().toString())){
                    errorMessageForEmail.setText("Invalid Email address");
                    validEmail = false;
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