package com.example.inclass4;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;


public class LoginFragment extends Fragment {

   // EditText emailLogin, password;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);


        view.findViewById(R.id.loginButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Button Clicked !!", Toast.LENGTH_SHORT).show();
            }
        });

        return  view;
    }


//    LoginFragmentLister mListerner;
//
//    @Override
//    public  void onAttach(@NonNull Context context){
//        super.onAttach(context);
//        mListerner = (LoginFragmentLister) context;
//    }
//
//    interface  LoginFragmentLister{
//    void sendAccount(DataServices.Account account);
//        void goToRegister();
//    }
}