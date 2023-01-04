package com.example.providerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.providerapp.ViewModels.LoginViewModel;
import com.example.providerapp.databinding.ActivityLoginBinding;

public class Login extends AppCompatActivity {
ActivityLoginBinding binding;
SharedPreferences preferences;
SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        LoginViewModel loginViewModel = new LoginViewModel();
        preferences = getSharedPreferences("saveToken" , MODE_PRIVATE);
        editor = preferences.edit();
        binding.login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = binding.email.getText().toString();
                String password = binding.password.getText().toString();
                if (!email.isEmpty() && !password.isEmpty()){
                  boolean success = loginViewModel.login(email , password);
                  if (success){
                      editor.putString("token" , loginViewModel.getToken()).apply();
                      startActivity(new Intent(getBaseContext() , MainActivity.class));
                      finish();
                  }else {
                      Toast.makeText(Login.this, "error!", Toast.LENGTH_SHORT).show();
                  }

                }else {
                    Toast.makeText(Login.this, "Fill all fields!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        binding.signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getBaseContext() , Register.class));
            }
        });


    }
}