package com.rushro2m.umeng;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class UserActivity extends AppCompatActivity {
    TextView tv_name;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        tv_name = findViewById(R.id.tv_name);
        image = findViewById(R.id.image);
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        Log.e("name", "onCreate: " + intent.getStringExtra("name"));
        tv_name.setText(name);
        Log.e("iconurl", "onCreate: " + intent.getStringExtra("iconurl"));
        Picasso.with(this).load(intent.getStringExtra("iconurl")).into(image);
    }
}
