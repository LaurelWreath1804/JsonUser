package com.example.jsonuser;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

public class UserDetail extends AppCompatActivity {
    TextView textUsername;
    TextView textName;
    TextView textEmail;
    TextView textAddress;
    TextView textPhone;
    TextView textCompany;
    ImageView imagePhoto;
    Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_details);

        textUsername = findViewById(R.id.text_username2);
        textName = findViewById(R.id.text_name2);
        textEmail = findViewById(R.id.text_email2);
        textAddress = findViewById(R.id.text_address2);
        textPhone = findViewById(R.id.text_phone2);
        textCompany = findViewById(R.id.text_company2);
        imagePhoto = findViewById(R.id.image_photo);
        backButton = findViewById(R.id.button);

        Intent intent = getIntent();
        int id = intent.getIntExtra("id", 0);
        ItemModel chosenItem = MainActivity.items.get(id);

        textUsername.setText(chosenItem.getUsername());
        textName.setText(chosenItem.getName());
        textEmail.setText(chosenItem.getEmail());
        textAddress.setText(chosenItem.getAddress());
        textPhone.setText(chosenItem.getPhone());
        textCompany.setText(chosenItem.getCompany());
        Picasso.get().load("https://lebavui.github.io" + chosenItem.getPhoto()).into(imagePhoto);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserDetail.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }
}
