package com.example.myapplication.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Model.ChatMessage;
import com.example.myapplication.R;

import java.util.List;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.MyViewHolder> {
    private Context context;
    private List<ChatMessage> messages;

    public ChatAdapter(Context context, List<ChatMessage> messages) {
        this.context = context;
        this.messages = messages;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_chat, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holders, int position) {
        ChatMessage currentMessage = messages.get(position);
        String message = currentMessage.getMessage();
        holders.message.setText(message);
    }

    @Override
    public int getItemCount() {
        return messages.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView message;

        MyViewHolder(@NonNull final View itemView) {
            super(itemView);
            message = itemView.findViewById(R.id.text_chat);
        }
    }

}
