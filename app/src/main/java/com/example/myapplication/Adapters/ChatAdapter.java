package com.example.myapplication.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

import java.util.List;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.MyViewHolder> {
    private List<String> allmessages;

    public ChatAdapter(List<String> allmessages) {
        this.allmessages = allmessages;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_chat, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holders, int position) {
        String message = allmessages.get(position);
        holders.message.setText(message);
    }

    @Override
    public int getItemCount() {
        return allmessages.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView message;

        MyViewHolder(@NonNull final View itemView) {
            super(itemView);
            message = itemView.findViewById(R.id.text_chat);
        }
    }

}
