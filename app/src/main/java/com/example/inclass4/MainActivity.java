package com.example.inclass4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements LoginFragment.LoginFragmentLister{
    //implement this interface implements LoginFragment.LoginFragmentLister
    Button button;
    TextView tv;
    public static String EMAIL_KEY = "email";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Login");


        //Display Login Fragment
        getSupportFragmentManager().beginTransaction()
                .add(R.id.containerView, new LoginFragment())
                .commit();



    }
    DataServices.Account userAccount;

    @Override
    public void sendAccount(DataServices.Account account) {
        userAccount = account;
//        AccountFragment accountFragment = new AccountFragment();
//        String name = userAccount.getEmail();
//        Bundle b = new Bundle();
//        b.putSerializable(EMAIL_KEY, name);
//        accountFragment.setArguments(b);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.containerView, new AccountFragment())
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void goToRegister() {


    }


}


