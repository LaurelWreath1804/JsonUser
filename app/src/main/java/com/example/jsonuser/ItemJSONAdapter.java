package com.example.jsonuser;

import android.app.Activity;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONObject;

public class ItemJSONAdapter extends RecyclerView.Adapter<ItemJSONAdapter.ItemViewHolder> {

    JSONArray jsonArray;
    Context mcon;

    public ItemJSONAdapter(Context con, JSONArray jsonArray) {
        this.mcon = con;
        this.jsonArray = jsonArray;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new ItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        try {
            JSONObject jsonObject = jsonArray.getJSONObject(position);
            JSONObject avatarObject = jsonObject.getJSONObject("avatar");
            JSONObject addressObject = jsonObject.getJSONObject("address");
            JSONObject companyObject = jsonObject.getJSONObject("company");

            MainActivity.items.add(new ItemModel(
                                    jsonObject.getString("username"),
                                    jsonObject.getString("name"),
                                    jsonObject.getString("email"),
                                    avatarObject.getString("thumbnail"),
                             addressObject.getString("street") + ", " + addressObject.getString("suite") + ",\n" + addressObject.getString("city"),
                                    companyObject.getString("name"),
                                    jsonObject.getString("phone"),
                                    avatarObject.getString("photo")));

            holder.textUsername.setText(MainActivity.items.get(position).getUsername());
            holder.textEmail.setText(MainActivity.items.get(position).getEmail());

            Picasso.get().load("https://lebavui.github.io" + MainActivity.items.get(position).getAvatar()).into(holder.imageAvatar);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return jsonArray.length();
    }



    class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView textUsername;
        TextView textEmail;
        ImageView imageAvatar;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);

            imageAvatar = itemView.findViewById(R.id.image_avatar);
            textUsername = itemView.findViewById(R.id.text_username);
            textEmail = itemView.findViewById(R.id.text_email);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int indexView = getAdapterPosition();
                    Intent intent = new Intent(mcon, UserDetail.class);
                    intent.putExtra("id", indexView);
                    mcon.startActivity(intent);
                }
            });
        }
    }
}

