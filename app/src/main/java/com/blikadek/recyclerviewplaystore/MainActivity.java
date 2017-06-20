package com.blikadek.recyclerviewplaystore;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    ArrayList<SectionDataModel> allSampleData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);

        allSampleData = new ArrayList<SectionDataModel>();

        if (toolbar != null) {
            setSupportActionBar(toolbar);
            toolbar.setTitle("G PlayStore");
        }

        createDummyData();

        RecyclerView rvMain = (RecyclerView)findViewById(R.id.rvMain);
        rvMain.setHasFixedSize(true);
        RecyclerViewDataAdapter adapter = new RecyclerViewDataAdapter(this, allSampleData);
        rvMain.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rvMain.setAdapter(adapter);
    }

    public void createDummyData() {
        for (int i=1; i<= 5; i++) {
            SectionDataModel dm = new SectionDataModel();
            dm.setHeaderTitle("Section" + i);

            ArrayList<SingleItemModel> singleItem = new ArrayList<SingleItemModel>();
            for (int j=0; j<=5; j++){
                singleItem.add(new SingleItemModel("Item" + j, "URL " + j));
            }
            dm.setAllItemInSection(singleItem);
            allSampleData.add(dm);
        }
    }
}
