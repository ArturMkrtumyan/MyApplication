package com.example.myapplication.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Model.User;
import com.example.myapplication.Model.UserMessage;
import com.example.myapplication.R;

import java.util.List;

public class MessagesAdapter extends RecyclerView.Adapter<MessagesAdapter.MyViewHolder> {
    private Context context;
    private List<UserMessage> userMessages;


    public MessagesAdapter(Context context, List<UserMessage> messages) {
        this.context = context;
        this.userMessages = messages;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_other_user, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holders, int position) {
        UserMessage currentuser = userMessages.get(position);
        String name = currentuser.getName();
        holders.name.setText(name);
        int imagePath = currentuser.getImagePath();
        holders.image.setImageResource(imagePath);
    }


    @Override
    public int getItemCount() {
        return userMessages.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView image;
        private TextView name;

        MyViewHolder(@NonNull final View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            name = itemView.findViewById(R.id.text_name);
        }
    }

}
