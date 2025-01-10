package com.example.meetdevs;

import android.os.Bundle;
import android.view.View;
import android.widget.*;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnClickListener {
    private int contador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        List<Item> items = new ArrayList<Item>();
        items.add(new Item(R.drawable.perro, false, "Hello teacher", "Comment c'va proffeseur?"));
        items.add(new Item(R.drawable.gato, false, "Hello adult", "Comment c'va chat?"));
        items.add(new Item(R.drawable.leon, false, "Hello kid", "Comment c'va lion?"));

        CustomAdapter adapter = new CustomAdapter(this, items);
        ListView listView = findViewById(R.id.id_listView);
        listView.setAdapter(adapter);

    }

    @Override
    public void onClick() {
        Toast.makeText(this, "Click", Toast.LENGTH_SHORT).show();
    }
}