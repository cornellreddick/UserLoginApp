package com.example.inclass4;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class RegisterFragment extends Fragment {
Button regCancelButton, regSubmitButton;
EditText regEmail, regPassword, regName;
//    // TODO: Rename parameter arguments, choose names that match
//    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//    private static final String ARG_PARAM1 = "param1";
//    private static final String ARG_PARAM2 = "param2";
//
//    // TODO: Rename and change types of parameters
//    private String mParam1;
//    private String mParam2;
//
    public RegisterFragment() {
        // Required empty public constructor
    }

//    // TODO: Rename and change types and number of parameters
//    public static RegisterFragment newInstance(String param1, String param2) {
//        RegisterFragment fragment = new RegisterFragment();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
//        return fragment;
//    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_register, container, false);
        //On cancel display login
        regCancelButton = v.findViewById(R.id.regCancelButton);
        regCancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.containerView, new LoginFragment(), null).commit();
            }
        });
        //
        regSubmitButton = v.findViewById(R.id.regSubmitButton);
        regName = v.findViewById(R.id.regName);
        regName.getText().toString();

        regEmail = v.findViewById(R.id.regEmail);
        regEmail.getText().toString();

        regPassword = v.findViewById(R.id.regPassword);
        regPassword.getText().toString();

        regSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!regName.getText().toString().matches("")
                        && !regEmail.getText().toString().matches("")
                        && !regPassword.getText().toString().matches("")) {
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.containerView, new AccountFragment(), null).commit();
                } else{
                    Toast.makeText(getContext(), "Please enter a name, email, and password!", Toast.LENGTH_SHORT).show();
                }}
        });



        return v;
    }
}