package com.example.inclass4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity  {
    //implement this interface implements LoginFragment.LoginFragmentLister

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //To add Fragment to Activity Add dynamicallyAdded when App start
        getSupportFragmentManager().beginTransaction()
                .add(R.id.containerView, new LoginFragment())
                .commit();


       // When button is click go to new Account Frag
        findViewById(R.id.loginButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.containerView, new RegisterFragment())
                        .commit();
            }
        });


//        //When button is click go to new Register Frag
//        findViewById(R.id.createAccoundButton).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                getSupportFragmentManager().beginTransaction()
//                        .replace(R.id.registerFrag, new RegisterFragment())
//                        .commit();
//            }
//        });

    }
//
//    @Override
//    public void sendAccount(DataServices.Account account) {
//
//    }
//
//    @Override
//    public void goToRegister() {
//
//    }
}