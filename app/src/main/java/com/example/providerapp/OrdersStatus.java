package com.example.providerapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.providerapp.ViewModels.OrdersStatusViewModel;
import com.example.providerapp.databinding.FragmentOrdersStatusBinding;


public class OrdersStatus extends Fragment {

    OrderStatusAdapter adapter;
    OrdersStatusViewModel viewModel = new OrdersStatusViewModel();

    private static final String ARG_PARAM1 = "token";
    private static final String ARG_PARAM2 = "type";

    private String token;
    private String type;



    public OrdersStatus() {
        // Required empty public constructor
    }



    public static OrdersStatus newInstance(String t , String type) {
        OrdersStatus fragment = new OrdersStatus();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, t);
        args.putString(ARG_PARAM2, type);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            token = getArguments().getString(ARG_PARAM1);
            type = getArguments().getString(ARG_PARAM2);

            if (type.equals("unCompleted")){
                viewModel.getUnCompletedOrder(token);
                adapter = new OrderStatusAdapter(viewModel.UnCompletedOrderData.getValue());

            }else if (type.equals("completed")){
                viewModel.getCompletedOrder(token);
                adapter = new OrderStatusAdapter(viewModel.UnCompletedOrderData.getValue());
            }else {

            }

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentOrdersStatusBinding binding = FragmentOrdersStatusBinding.inflate(inflater , container , false);
        binding.rv.setAdapter(adapter);
        binding.rv.setLayoutManager(new LinearLayoutManager(getActivity() , RecyclerView.VERTICAL , false));

        return binding.getRoot();
    }
}