package com.example.providerapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.providerapp.Models.OrderData;
import com.example.providerapp.ViewModels.OrdersViewModel;
import com.example.providerapp.databinding.FragmentOrdersBinding;


public class Orders extends Fragment implements DetailsClick {
    OrdersViewModel ordersViewModel;
    private static final String ARG_PARAM1 = "param1";
    private String mParam1;
    DetailsClick detailsClick = this;
    DetailsData detailsData;

    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    OrdersAdapter adapter;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        detailsData = (DetailsData) context;
    }

    public Orders() {
    }


    public static Orders newInstance(String param1) {
        Orders fragment = new Orders();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        preferences = getActivity().getSharedPreferences("saveToken" , Context.MODE_PRIVATE);
        String token = preferences.getString("token", "");
        ordersViewModel = new OrdersViewModel();
        ordersViewModel.getOrders(token);

        adapter = new OrdersAdapter(ordersViewModel.orderData.getValue() , detailsClick);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentOrdersBinding binding = FragmentOrdersBinding.inflate(inflater , container , false);
        binding.rv.setAdapter(adapter);
        binding.rv.setLayoutManager(new LinearLayoutManager(getActivity() , RecyclerView.VERTICAL , false));

        return binding.getRoot();
    }



    @Override
    public void details(int oder_ID, OrderData orderData) {
        detailsData.detailsData(oder_ID , orderData);
    }
}