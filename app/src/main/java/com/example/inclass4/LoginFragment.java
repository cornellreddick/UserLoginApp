package com.example.inclass4;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class LoginFragment extends Fragment {
    Button loginButton, registerButton;
    EditText userIput, userPassword;



   // EditText emailLogin, password;
   public LoginFragment() {
       // Required empty public constructor
   }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_login, container, false);
        userIput = v.findViewById(R.id.emailInput);
        userIput.getText().toString();

        userPassword = v.findViewById(R.id.passwordInput);
        userPassword.getText().toString();

           // Display Account Fragment
        loginButton = v.findViewById(R.id.loginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   if (!userIput.getText().toString().matches("") && !userPassword.getText().toString().matches("")) {
                       getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.containerView, new AccountFragment(), null).commit();
                   } else{
                       Toast.makeText(getContext(), "Please enter an email or password", Toast.LENGTH_SHORT).show();
                   }
               }
           });
        // Display Register Fragment
        registerButton = v.findViewById(R.id.createNewAccountButton);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.containerView, new RegisterFragment(), null).commit();
            }
        });

        return  v;
    }


    LoginFragmentLister mListerner;

    @Override
    public  void onAttach(@NonNull Context context){
        super.onAttach(context);
        mListerner = (LoginFragmentLister) context;
    }

    interface  LoginFragmentLister{
        void sendAccount(DataServices.Account account);
        void goToRegister();
    }
}