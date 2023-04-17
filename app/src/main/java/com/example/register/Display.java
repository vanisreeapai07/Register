package com.example.register;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;

public class Display extends AppCompatActivity {

    RecyclerView rv;
    List<DataModel> datamodel;
    DisplayDataAdapter displayDataAdapter;
    Realm realm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        rv = findViewById(R.id.rv);
        realm = Realm.getDefaultInstance();
        datamodel = new ArrayList<>();

        datamodel = realm.where(DataModel.class).findAll();
        displayDataAdapter = new DisplayDataAdapter(datamodel, this);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(displayDataAdapter);

    }
}