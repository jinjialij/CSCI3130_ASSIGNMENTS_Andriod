package ca.dal.cs.csci3130.a2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

public class SecondFragment extends Fragment {
    TextView welcomeTextView;
    TextView successRegisterMessage;

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
        successRegisterMessage = (TextView) view.findViewById(R.id.successMessageTextView);
        Bundle bundle = null;
        if (!getParentFragmentManager().getFragments().isEmpty()){
            bundle = getParentFragmentManager().getFragments().get(0).getArguments();
        }
        if(bundle != null){
            if (bundle.containsKey("registerMessage")){
                welcomeTextView.setText((String)bundle.get("registerMessage"));
            }
            if (bundle.containsKey("loginMessage")){
                welcomeTextView.setText((String)bundle.get("loginMessage"));
            }
            if (bundle.containsKey("result")){
                successRegisterMessage.setText((String)bundle.get("result"));
            }
        }

        view.findViewById(R.id.buttonPrevious).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        });
    }


}