package com.example.gogreenfyp;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

import org.web3j.crypto.CipherException;

import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

public class WalletErrorDialog extends AlertDialog implements android.view.View.OnClickListener {

        public Activity activity;
        public FirebaseAuth firebaseAuth;
        public Button createWallet, importWallet;

        public WalletErrorDialog(Activity a, FirebaseAuth fAuth) {
            super(a);
            // TODO Auto-generated constructor stub
            this.firebaseAuth = fAuth;
        }

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.dialog_error_wallet);
            createWallet = (Button) findViewById(R.id.btnCreateWallet);
            importWallet = (Button) findViewById(R.id.btnImportWallet);
            createWallet.setOnClickListener(this);
            importWallet.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btnCreateWallet:
                    try {
                        if(Wallet.createWallet(this.activity, this.firebaseAuth)){
                            Log.d("Wallet creation", "Success");
                        }
                    } catch (NoSuchAlgorithmException | NoSuchProviderException | InvalidAlgorithmParameterException | CipherException | IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case R.id.btnImportWallet:
                    Intent intent = new Intent(this.activity, ImportWalletActivity.class);
                    this.activity.startActivity(intent);
                    break;
                default:
                    break;
            }
            dismiss();
        }

}
