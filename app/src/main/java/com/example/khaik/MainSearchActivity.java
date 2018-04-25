package com.example.khaik;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.SearchView;

import com.example.khaik.Adapter.SearchAdapter;
import com.example.khaik.Database.Database;
import com.example.khaik.Model.Friend;
import com.example.khaik.hihi21042018.R;

import java.util.ArrayList;

public class MainSearchActivity extends AppCompatActivity {
    SearchAdapter adapter;
    Toolbar toolbar;
    ArrayList<Friend> myListFriend;
    Database myDatabase;
    public static final String My_CONTENT = "MY_CONTEN";
    public static final String My_NAME = "MY_NAME";
    public static final String My_MSSV = "MY_MSSV";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_search);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        RecyclerView lv = (RecyclerView) findViewById(R.id.lv_search);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        lv.setLayoutManager(layoutManager);

        myListFriend = new ArrayList<>();
        myDatabase = new Database(this);
        myListFriend = (ArrayList<Friend>) myDatabase.getFriend();

        adapter = new SearchAdapter(getApplicationContext(), myListFriend);
        lv.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView  searchView = (SearchView) menu.findItem(R.id.search).getActionView();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {


                Intent intent = new Intent(MainSearchActivity.this, ResoultActivity.class);
                intent.putExtra("list", SearchAdapter.afterFilter);
                intent.putExtra("key", query);

                startActivity(intent);

                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                doMySearch(newText);
                return false;
            }
        });


        return true;
    }

    private void doMySearch(String query) {
        this.adapter.getFilter().filter(query);
    }
}
