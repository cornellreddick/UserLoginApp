package com.example.inclass4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements LoginFragment.LoginFragmentLister{
    //implement this interface implements LoginFragment.LoginFragmentLister
    Button button;
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

    @Override
    public void sendAccount(DataServices.Account account) {
        DataServices.AccountRequestTask task = DataServices.login("a@a.com", "test123");
        if(task.isSuccessful()){ //successful
             account = task.getAccount();
        } else { //not successful
            String error = task.getErrorMessage();
            Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void goToRegister() {

    }


}


