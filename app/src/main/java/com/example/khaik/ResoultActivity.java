package com.example.khaik;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.example.khaik.Adapter.SearchAdapter;
import com.example.khaik.Model.Friend;
import com.example.khaik.Model.Word;
import com.example.khaik.hihi21042018.R;


import java.util.ArrayList;

public class ResoultActivity extends AppCompatActivity {
    private RecyclerView rcv_result;
    private TextView tv_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_item_resoult);

        Intent intent = getIntent();

        ArrayList<Word> list = (ArrayList<Word>) intent.getSerializableExtra("list");
        if (list == null)
        {
            list = new ArrayList<>();
            Word word = (Word) intent.getSerializableExtra("chose");
            list.add(word);
        }
        String query = intent.getStringExtra("key");

        rcv_result = (RecyclerView) findViewById(R.id.rcl_result);
        tv_result = (TextView) findViewById(R.id.tv_result);

        tv_result.setText(query);

        SearchAdapter adapter = new SearchAdapter(this, list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rcv_result.setLayoutManager(layoutManager);

        rcv_result.setAdapter(adapter);

    }
}
