package com.example.networking;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;

@SuppressWarnings("FieldCanBeLocal")
public class MainActivity extends AppCompatActivity implements JsonTask.JsonTaskListener {

    private RecyclerViewAdapter adapter;
    private ArrayList<Mountain> mountains;
    private ArrayList<RecyclerViewItem> items;

    private final String JSON_URL = "HTTPS_URL_TO_JSON_DATA_CHANGE_THIS_URL";
    private final String JSON_FILE = "mountains.json";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new JsonFile(this, this).execute(JSON_FILE);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);

        mountains = new ArrayList<>(Arrays.asList(
                new Mountain("MatterHorn"),
                new Mountain("Mont Blanc"),
                new Mountain("Denali")

        ));

        items = new ArrayList<>();
        for (Mountain mountain : mountains){
            items.add(new RecyclerViewItem(mountain.getName()));
        }

        adapter = new RecyclerViewAdapter(this, items, new RecyclerViewAdapter.OnClickListener() {
            @Override
            public void onClick(RecyclerViewItem item) {
                Toast.makeText(MainActivity.this, item.getTitle(), Toast.LENGTH_SHORT).show();
            }

        });


    }

    @Override
    public void onPostExecute(String json) {
        Log.d("MainActivity", json);
    }

}
