package com.example.UDDD_DQT;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class CustomerAdapter extends RecyclerView.Adapter<CustomerAdapter.CustomerViewHolder> {

    private ArrayList<Customer> customerList;

    public CustomerAdapter(ArrayList<Customer> customerList) {
        this.customerList = customerList;
    }

    @NonNull
    @Override
    public CustomerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.customer_item, parent, false);
        return new CustomerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomerViewHolder holder, int position) {
        Customer customer = customerList.get(position);
        holder.firstNameTextView.setText(customer.getFirstName());
        holder.lastNameTextView.setText(customer.getLastName());
        holder.emailTextView.setText(customer.getEmail());
        Glide.with(holder.itemView.getContext()).load(customer.getAvatar()).into(holder.avatarImageView);
    }

    @Override
    public int getItemCount() {
        return customerList.size();
    }

    static class CustomerViewHolder extends RecyclerView.ViewHolder {
        TextView firstNameTextView;
        TextView lastNameTextView;
        TextView emailTextView;
        ImageView avatarImageView;

        public CustomerViewHolder(@NonNull View itemView) {
            super(itemView);
            firstNameTextView = itemView.findViewById(R.id.first_name);
            lastNameTextView = itemView.findViewById(R.id.last_name);
            emailTextView = itemView.findViewById(R.id.email);
            avatarImageView = itemView.findViewById(R.id.avatar);
        }
    }
}
