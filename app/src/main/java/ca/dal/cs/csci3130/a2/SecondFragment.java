package ca.dal.cs.csci3130.a2;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import java.util.List;

public class SecondFragment extends Fragment {
    TextView welcomeTextView;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        welcomeTextView = (TextView) view.findViewById(R.id.welcomeTextView);
        Bundle bundle = null;
        if (!getParentFragmentManager().getFragments().isEmpty()){
            bundle = getParentFragmentManager().getFragments().get(0).getArguments();
        }
        if(bundle != null){
            welcomeTextView.setText((String)bundle.get("msg"));
        }

        view.findViewById(R.id.button_second).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        });
    }


}