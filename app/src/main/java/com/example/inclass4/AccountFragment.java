package com.example.inclass4;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AccountFragment extends Fragment {
    Button editAcctBtn, cancelAcctBtn ;
    TextView welcomeTv, emailTv;
    public AccountFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_account, container, false);
        // Display Update Update Account Fragment
        editAcctBtn = v.findViewById(R.id.editAcctBtn);
        editAcctBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.containerView, new UpdateAccountFragment(), null).commit();
            }
        });

        cancelAcctBtn = v.findViewById(R.id.acctLoginBtn);
        cancelAcctBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.containerView, new LoginFragment(), null).commit();
            }
        });

        return v;
    }
}