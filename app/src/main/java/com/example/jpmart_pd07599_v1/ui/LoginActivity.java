package com.example.jpmart_pd07599_v1.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.jpmart_pd07599_v1.R;
import com.example.jpmart_pd07599_v1.database.DataHelper;

public class LoginActivity extends AppCompatActivity {

    private EditText edtUserName, edtPassword;
    private CheckBox chkRememberMe;
    private Button btnLogin;
    private DataHelper db;

    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_login);

        edtUserName = findViewById(R.id.edtUserName);
        edtPassword = findViewById(R.id.edtPassword);
        chkRememberMe = findViewById(R.id.chkRememberMe);
        btnLogin = findViewById(R.id.btnLogin);

        db = new DataHelper(this);

        btnLogin.setOnClickListener(v -> handleLogin());
    }
    private void handleLogin() {
        String username = edtUserName.getText().toString().trim();
        String password = edtPassword.getText().toString().trim();

        if (username.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Vui lòng nhập tài khoản và mật khẩu", Toast.LENGTH_SHORT).show();
            return;
        }

        int chucVu = db.login(username, password);

        if (chucVu == -1) {
            Toast.makeText(this, "Sai tài khoản hoặc mật khẩu", Toast.LENGTH_SHORT).show();
            return;
        }

        Intent intent;
        if (chucVu == 0) {
            // Nhân viên
            intent = new Intent(this, MainStaffActivity.class);
        } else {
            // Quản lý / Admin
            intent = new Intent(this, MainActivity.class);
        }

        startActivity(intent);
        finish(); // không quay lại login
    }
}
