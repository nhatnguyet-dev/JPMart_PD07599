package com.example.jpmart_pd07599_v1.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.jpmart_pd07599_v1.R;

public class LoginActivity extends AppCompatActivity {

    private EditText edtUserName, textPassword;
    private CheckBox chkRememberMe;
    private Button btnLogin;
//    private StaffDAO staffDAO;

    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_login);

        edtUserName = findViewById(R.id.edtUserName);
        textPassword = findViewById(R.id.edtPassword);
        chkRememberMe = findViewById(R.id.chkRememberMe);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(v->{
            startActivity(new Intent(LoginActivity.this, MainActivity.class));
        });
    }
}
