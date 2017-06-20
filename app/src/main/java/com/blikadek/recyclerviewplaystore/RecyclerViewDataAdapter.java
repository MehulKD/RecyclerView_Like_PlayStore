package com.blikadek.recyclerviewplaystore;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.blikadek.recyclerviewplaystore.R;
import com.blikadek.recyclerviewplaystore.SectionDataModel;

import java.util.ArrayList;

/**
 * Created by M13x5aY on 20/06/2017.
 */

public class RecyclerViewDataAdapter extends RecyclerView.Adapter<RecyclerViewDataAdapter.ItemRowHolder> {

    private ArrayList<SectionDataModel> dataList;
    private Context mContext;

    public RecyclerViewDataAdapter(Context contex, ArrayList<SectionDataModel> dataList) {
        this.dataList = dataList;
        this.mContext=contex;
    }


    @Override
    public ItemRowHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, null);
        ItemRowHolder mh = new ItemRowHolder(v);
        return mh;
    }

    @Override
    public void onBindViewHolder(ItemRowHolder holder, int position) {
     final String sectionName = dataList.get(position).getHeaderTitle();
        ArrayList singleSectionItems = dataList.get(position).getAllItemInSection();
        holder.itemTitle.setText(sectionName);
        SectionListDataAdapter itemListDataAdapter = new SectionListDataAdapter(mContext, singleSectionItems);

        holder.recycler_view_list.setHasFixedSize(true);
        holder.recycler_view_list.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
        holder.recycler_view_list.setAdapter(itemListDataAdapter);


        holder.btnMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Toast.makeText(v.getContext(), "click event on more, " + sectionName , Toast.LENGTH_SHORT).show();



            }
        });
    }

    @Override
    public int getItemCount() {
        return (null != dataList ? dataList.size() :0 );
    }

    public class ItemRowHolder extends RecyclerView.ViewHolder {
        protected TextView itemTitle;
        protected RecyclerView recycler_view_list;
        protected Button btnMore;


        public ItemRowHolder(View v) {
            super(v);

            this.itemTitle = (TextView) v.findViewById(R.id.itemTitle);
            this.recycler_view_list = (RecyclerView) v.findViewById(R.id.rvViewList);
            this.btnMore = (Button) v.findViewById(R.id.btnMore);
        }
    }
}
