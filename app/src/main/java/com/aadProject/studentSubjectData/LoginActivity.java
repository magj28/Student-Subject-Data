package com.aadProject.studentSubjectData;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    EditText edtID = findViewById(R.id.regno);
    EditText edtPass = findViewById(R.id.password);
    Button btnLogin = findViewById(R.id.button);
    Button btnRegister = findViewById(R.id.button_reg);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = edtID.getText().toString().trim();
                String pass = edtPass.getText().toString().trim();
                dbHelper dbh = new dbHelper(LoginActivity.this);
                if(TextUtils.isEmpty(id)){
                    Toast.makeText(LoginActivity.this, "ID must not be empty!", Toast.LENGTH_SHORT).show();
                }else if(TextUtils.isEmpty(pass)){
                    Toast.makeText(LoginActivity.this, "Password must not be empty!", Toast.LENGTH_SHORT).show();
                }else{
                    if(dbh.checkUser(id,pass)){
                        Intent intent = new Intent(LoginActivity.this, BatchmatesActivity.class);
                        startActivity(intent);
                        finish();
                    }
                }
            }
        });
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
}