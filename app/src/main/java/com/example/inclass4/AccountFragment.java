package com.example.inclass4;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class AccountFragment extends Fragment implements LoginFragment.LoginFragmentLister{
    Button editAcctBtn, cancelAcctBtn ;
    TextView welcomeTv, emailTv;
    String data;

    private static final String ARG_PARAM_ACCOUNT = "param1";
    private DataServices.Account userAccount;
    private String userEmail;
    public AccountFragment() {
        // Required empty public constructor
    }

    public static AccountFragment newInstance(DataServices.Account acct) {
        AccountFragment fragment = new AccountFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_PARAM_ACCOUNT, acct);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
           this.userAccount = (DataServices.Account) getArguments().getSerializable(ARG_PARAM_ACCOUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_account, container, false);
//        loginFragmentLister.sendAccount(userAccount);
//        userAccount = (DataServices.Account) getArguments().getSerializable(MainActivity.EMAIL_KEY);
//       emailTv = v.findViewById(R.id.emailTv);

//        Bundle b = getArguments();
//        if (b != null){
//            userEmail = (String) b.getSerializable(MainActivity.EMAIL_KEY);
//        }
//        emailTv.setText(userAccount.getEmail());

        editAcctBtn = v.findViewById(R.id.editAcctBtn);
        editAcctBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.containerView, new UpdateAccountFragment(), null).commit();
            }
        });

        cancelAcctBtn = v.findViewById(R.id.acctLogoutBtn);
        cancelAcctBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.containerView, new LoginFragment(), null).commit();
            }
        });

        return v;
    }

    LoginFragment.LoginFragmentLister loginFragmentLister;

    @Override
    public  void onAttach(@NonNull Context context) {
        super.onAttach(context);
        loginFragmentLister = (LoginFragment.LoginFragmentLister) context;

    }

//    public static AccountFragment newInstance(DataServices.Account account) {
//        AccountFragment accountFragment = new AccountFragment();
//        Bundle b = new Bundle();
//        b.putSerializable(MainActivity.EMAIL_KEY, account);
//        accountFragment.setArguments(b);
//        return accountFragment;
//    }

    @Override
    public void sendAccount(DataServices.Account account) {
        userAccount = account;
    }

    @Override
    public void goToRegister() {

    }
}