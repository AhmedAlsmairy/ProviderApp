package com.example.providerapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.SharedPreferences;
import android.os.Bundle;

import com.example.providerapp.ViewModels.OrdersStatusViewModel;
import com.example.providerapp.databinding.ActivityOrdersStatusViewPagerBinding;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;

public class OrdersStatusViewPager extends AppCompatActivity {
ActivityOrdersStatusViewPagerBinding binding;
SharedPreferences preferences;
private String token;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOrdersStatusViewPagerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<Fragment> fragments = new ArrayList<>();
        ArrayList<String> titles = new ArrayList<>();

        preferences = getSharedPreferences("saveToken" , MODE_PRIVATE);
        token = preferences.getString("token" , "");

        fragments.add(OrdersStatus.newInstance(token , "pending"));
        fragments.add(OrdersStatus.newInstance(token,"unCompleted"));
        fragments.add(OrdersStatus.newInstance(token,"completed"));
        ViewPagerAdapter adapter = new ViewPagerAdapter( this , fragments);

        binding.fram.setAdapter(adapter);


        titles.add("pending");
        titles.add("unCompleted");
        titles.add("completed");

        new TabLayoutMediator(binding.tab, binding.fram, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                tab.setText(titles.get(position));
            }
        });

    }
}