package com.example.lab4_android;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

import static com.example.lab4_android.R.id.listView;

public class MainActivity extends AppCompatActivity {

    private ArrayList <String> target;
    private ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String [] values = new String[] {"Pies", "Kot", "Karp", "Osioł", "Chomik", "Mysz", "Jeż", "Karaluch"};
        this.target=new ArrayList<String>();
        this.target.addAll(Arrays.asList(values));
        this.adapter=new ArrayAdapter(this, android.R.layout.simple_list_item_1, this.target);
        ListView listView =(ListView) findViewById(R.id.listView);
        listView.setAdapter(this.adapter);

    }
    // To do....
}
