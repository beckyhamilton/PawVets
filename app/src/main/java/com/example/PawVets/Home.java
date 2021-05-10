package com.example.PawVets;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;
import java.util.List;

public class Home extends AppCompatActivity {

    RecyclerView recyclerView;
    private RecyclerViewAdaptery adapter;
    private StaggeredGridLayoutManager manager;
    private List<row> appList;

    //Array of images
    int[] covers = new int[]{
            R.drawable.settingsicon,
            R.drawable.contactusicon,
            R.drawable.apppointmenticon,
            R.drawable.myaccounticon,
            R.drawable.symptomchecker,
            R.drawable.findusicon
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Making the home button in toolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.menu);


        //Initialising RecyclerView
        recyclerView = findViewById(R.id.recyclerview);
        appList = new ArrayList<>();

        //Adapter
        adapter = new RecyclerViewAdaptery(this, appList);
        manager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);

        //Layout Manager
        recyclerView.setLayoutManager(manager);

        //Adapter
        recyclerView.setAdapter(adapter);

        //Putting data into recyclerview
        InitializeDataIntoRecyclerView();

    }

    private void InitializeDataIntoRecyclerView() {

        row a = new row(covers[0]);
        appList.add(a);

        row b = new row(covers[1]);
        appList.add(b);

        row c = new row(covers[2]);
        appList.add(c);

        row d = new row(covers[3]);
        appList.add(d);

        row e = new row(covers[4]);
        appList.add(e);

        row f = new row(covers[5]);
        appList.add(f);

        adapter.notifyDataSetChanged();
    }

    //Adding buttons to toolbar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Adds item to action bar if present
        getMenuInflater().inflate(R.menu.bottom_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    //Handling click on toolbar buttons
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if(id == R.drawable.menu) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



}