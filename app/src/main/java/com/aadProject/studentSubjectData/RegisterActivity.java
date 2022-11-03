package com.aadProject.studentSubjectData;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.aadProject.studentSubjectData.dbHelper;

public class RegisterActivity extends AppCompatActivity {

    EditText edtID = findViewById(R.id.crtregno);
    EditText edtPass = findViewById(R.id.crtpassword);
    EditText edtSub1 = findViewById(R.id.crtsub1);
    EditText edtSub2 = findViewById(R.id.crtsub2);
    EditText edtSub3 = findViewById(R.id.crtsub3);
    Button btnRegister = findViewById(R.id.crtbutton);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = edtID.getText().toString().trim();
                String pass = edtPass.getText().toString().trim();
                String sub1 = edtSub1.getText().toString().trim();
                String sub2 = edtSub2.getText().toString().trim();
                String sub3 = edtSub3.getText().toString().trim();
                users newUser = new users(id,pass,sub1,sub2,sub3);
                dbHelper dbh = new dbHelper(RegisterActivity.this);
                dbh.addUser(newUser);
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
                Toast.makeText(RegisterActivity.this, "Registeration Success! Login", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}