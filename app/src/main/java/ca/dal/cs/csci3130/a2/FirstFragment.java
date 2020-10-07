package ca.dal.cs.csci3130.a2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

public class FirstFragment extends Fragment {
    EditText name;
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
        registerBtn = (Button) view.findViewById(R.id.buttonRegister);

        view.findViewById(R.id.buttonRegister).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (name.getText().toString().isEmpty()){
                    Toast.makeText(getContext(), "Username is empty", Toast.LENGTH_SHORT).show();
                }
                else if (name.getText().toString().matches("^.*[^a-zA-Z0-9 ].*$")){
                    Toast.makeText(getContext(), "Username is non-alphanumeric", Toast.LENGTH_SHORT).show();
                }
                else {
                    NavHostFragment.findNavController(FirstFragment.this)
                            .navigate(R.id.action_FirstFragment_to_SecondFragment);
                }
            }
        });
    }
}