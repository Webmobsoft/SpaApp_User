package com.structure.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.structure.R;
import com.structure.adapters.Category_Detail_list_adapter;

import java.util.ArrayList;

public class Category_Details_List_Activity extends AppCompatActivity {


    private RecyclerView mProvider_rv;
    private Context mContext;
    private TextView mCategoryName_tv,mSeletedDate_tv,mZipCode_tv;
    ArrayList mList_merchantNames=new ArrayList();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category__details__list_);
        mContext=this;
        addMerchnts();
        initializeView();
    }

    private void initializeView() {

        mCategoryName_tv=(TextView) findViewById(R.id.categorySelected_tv);
        mSeletedDate_tv=(TextView) findViewById(R.id.selectedDate_tv);
        mZipCode_tv=(TextView) findViewById(R.id.zipCode_tv);
        mProvider_rv= (RecyclerView) findViewById(R.id.provider_rv);
        mProvider_rv.setLayoutManager(new LinearLayoutManager(this));
        mProvider_rv.setAdapter(new Category_Detail_list_adapter(mContext,mList_merchantNames));



    }

    private void addMerchnts() {
        mList_merchantNames.add("Nails");
        mList_merchantNames.add("HiaRS");
        mList_merchantNames.add("HiaRS");
        mList_merchantNames.add("EYSS");
        mList_merchantNames.add("HiaRS");
        mList_merchantNames.add("Waxing");
        mList_merchantNames.add("Makeup");
        mList_merchantNames.add("Tannibg");
        mList_merchantNames.add("Eyes");
        mList_merchantNames.add("Nails");


    }
}
