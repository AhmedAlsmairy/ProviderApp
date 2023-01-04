package com.example.providerapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.providerapp.Models.AllWorks;
import com.example.providerapp.Models.Work;
import com.example.providerapp.ViewModels.RegisterViewModel;
import com.example.providerapp.databinding.ActivityRegisterBinding;

import java.util.ArrayList;
import java.util.List;

public class Register extends AppCompatActivity {
ActivityRegisterBinding binding;
    List<String> items = new ArrayList<>();
    List<AllWorks> arrayWithID = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        RegisterViewModel registerViewModel = new RegisterViewModel();

        registerViewModel.getAllWork();
        registerViewModel.allWork.observe(this, new Observer<List<AllWorks>>() {
            @Override
            public void onChanged(List<AllWorks> allWorks) {
                AllWorks work;
                for (int i = 0; i < allWorks.size(); i++) {
                    work =  allWorks.get(i);
                    items.add(work.getName());
                    arrayWithID.add(work);
                }
                ArrayAdapter<String> countryAdapter = new ArrayAdapter<String>(getBaseContext(),
                        android.R.layout.simple_spinner_item, items);
                countryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

                binding.spinner.setAdapter(countryAdapter);

            }
        });

        binding.signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = binding.fullName.getText().toString();
                String email = binding.email.getText().toString();
                String phone = binding.phone.getText().toString();
                String password = binding.password.getText().toString();
                int ID = 0;

                if (!name.isEmpty() && !email.isEmpty() && !phone.isEmpty() && !password.isEmpty()){

                   String job = binding.spinner.getSelectedItem().toString();
                    for (int i = 0; i < arrayWithID.size(); i++) {
                       if (arrayWithID.get(i).getName().equals(job)) {
                           ID = arrayWithID.get(i).getId();
                        }
                    }

                    boolean success = registerViewModel.register(name , email , password , phone , ID);
                    if (success){
                        Toast.makeText(Register.this, "Successfully registered", Toast.LENGTH_SHORT).show();
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                finish();
                            }
                        } , 1500);

                    }else {
                        Toast.makeText(Register.this, "error!", Toast.LENGTH_SHORT).show();
                    }

                }else {
                    Toast.makeText(Register.this, "Fill all fields!", Toast.LENGTH_SHORT).show();
                }

            }
        });

        binding.signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });



    }
}