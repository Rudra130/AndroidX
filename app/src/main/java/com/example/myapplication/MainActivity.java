package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
 class LoginActivity extends AppCompatActivity{
     @Override
     protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_main);

         EditText username = findViewById(R.id.username);
         EditText Password = findViewById(R.id.password);
         @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button loginButton = findViewById(R.id.loginButton);

         loginButton.setOnClickListener(new View.OnClickListener() {

             @Override
             public void onClick(View view) {
                 String usernameText = username.getText().toString();
                 String PasswordText = Password.getText().toString();

                 if (validateCredentials(usernameText, PasswordText)) {
                     // Proceed to the next activity
                     Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                     startActivity(intent);
                 } else {
                     // Show error message
                     Toast.makeText(LoginActivity.this, "Invalid credentials", Toast.LENGTH_SHORT).show();
                 }
             }

         });
     }
         private boolean validateCredentials(String username, String password){
             return username.equals("user") && password.equals("pass");
         }


     }


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.activity_main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}