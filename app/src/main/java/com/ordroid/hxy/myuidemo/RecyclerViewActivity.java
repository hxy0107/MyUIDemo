package com.ordroid.hxy.myuidemo;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ordroid.hxy.myuidemo.adapter.DividerGridItemDecoration;
import com.ordroid.hxy.myuidemo.adapter.DividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/10/15 0015.
 */
public class RecyclerViewActivity extends Activity {
    private RecyclerView mRecyclerView;
    private List<String> mDates;
    private RecyclerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);
        initData();
        mRecyclerView=(RecyclerView)findViewById(R.id.id_recyclerview);
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager( 4,StaggeredGridLayoutManager.VERTICAL));
        mAdapter=new RecyclerAdapter();
        mRecyclerView.setAdapter(mAdapter);

        //add itemdecoration
        mRecyclerView.addItemDecoration(new DividerGridItemDecoration(this));

        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    protected void initData(){
        mDates=new ArrayList<String>();

        for(int i='A';i<'Z';i++){
            mDates.add(""+(char)i);
        }
        for(int i='A';i<'Z';i++){
            mDates.add(""+(char)i);
        }        for(int i='A';i<'Z';i++){
            mDates.add(""+(char)i);
        }

    }



    class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>{


        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View inflate = LayoutInflater.from(RecyclerViewActivity.this).inflate(R.layout.recycler_item_view, parent, false);
            MyViewHolder holder=new MyViewHolder(inflate);
            return holder;
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            holder.textView.setText(mDates.get(position));
        }

        @Override
        public int getItemCount() {
            return mDates.size();
        }

        class MyViewHolder extends RecyclerView.ViewHolder{
            TextView textView;

            public MyViewHolder(View itemView) {
                super(itemView);
                textView=(TextView)itemView.findViewById(R.id.recycler_item_textview);
            }
        }
    }


}
