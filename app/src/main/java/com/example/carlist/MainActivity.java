package com.example.carlist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_ShowGames = (Button) findViewById(R.id.btn_ShowSavedGames);

        btn_ShowGames.setOnClickListener(view -> {
            Intent intent = new Intent(this, ListViewInfo.class);
            startActivity(intent);
        });
    }
}