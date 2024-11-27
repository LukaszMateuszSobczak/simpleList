package com.lukaszsobczak.simplelist;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        RecyclerView listView = findViewById(R.id.recycle_view_list);


        listView.setLayoutManager(new LinearLayoutManager(this));
        listView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < 101; i++) {
            list.add(i + 1);
        }

        ListAdapter listAdapter = new ListAdapter(list);
        listView.setAdapter(listAdapter);

    }
}