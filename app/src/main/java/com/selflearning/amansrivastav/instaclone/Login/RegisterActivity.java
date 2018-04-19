package com.selflearning.amansrivastav.instaclone.Login;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.selflearning.amansrivastav.instaclone.R;
import com.selflearning.amansrivastav.instaclone.utils.FirebaseMethods;

/**
 * Created by Aman.Srivastav on 19-04-2018.
 */



public class RegisterActivity extends AppCompatActivity{
    private static final String TAG = "RegisterActivity";
    private FirebaseAuth mAuth;
    private TextView email, username, password;
    private TextView waitText;
    private Button btnRegister;
    private ProgressBar progressBar;
    private FirebaseMethods firebaseMethods;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mAuth = FirebaseAuth.getInstance();
        email =  (TextView) findViewById(R.id.input_email);
        password =  (TextView) findViewById(R.id.input_password);
        username =  (TextView) findViewById(R.id.input_username);
        waitText =  (TextView) findViewById(R.id.loadingPleaseWait);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        btnRegister = (Button) findViewById(R.id.btn_register);

        progressBar.setVisibility(View.GONE);
        waitText.setVisibility(View.GONE);
        firebaseMethods =  new FirebaseMethods(RegisterActivity.this);
        signInProcess();

    }

    void signInProcess()
    {

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailS, passwordS, userNameS;
               emailS = email.getText().toString();
               passwordS = password.getText().toString();
               userNameS = username.getText().toString();
               if(checkNotNull(emailS, passwordS, userNameS))
               {
                   firebaseMethods.registerNewEmail(emailS, passwordS, userNameS);
               }
               else
               {
                   Toast.makeText(RegisterActivity.this, "Please fill out all the fields", Toast.LENGTH_SHORT).show();
               }

            }
        });
    }

    boolean checkNotNull(String email, String password, String userName)
    {
        if(isStringNull(email) || isStringNull(password) || isStringNull(userName))
            return false;
        else
            return true;
    }

    private boolean isStringNull(String string) {
        Log.d(TAG, "isStringNull: checking string if null.");

        if (string.equals("")) {
            return true;
        } else {
            return false;
        }
    }
}
