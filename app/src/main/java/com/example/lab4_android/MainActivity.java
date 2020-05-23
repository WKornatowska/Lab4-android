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
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    public void nowyWpis(MenuItem menuItem) {
        Intent intencja = new Intent(this, DodajWpis.class);
        startActivityForResult(intencja, 1);
    }

    @Override
    public void onActivityResult(int request_code, int resultCode, Intent data) {
        super.onActivityResult(request_code, resultCode, data);
        if (request_code == 1 && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            String nowy = (String) extras.get("wpis");
            target.add(nowy);
            adapter.notifyDataSetChanged();
        }
    }

}
