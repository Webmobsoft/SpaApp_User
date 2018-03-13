package com.structure.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.structure.R;
import com.structure.adapters.Select_Category_adapter;

import java.util.ArrayList;

public class GetCategory_Activity extends AppCompatActivity {


    private RecyclerView mCategory_rv;
    private TextView mAppName_tv, mSelectCategory_tv;
    private ArrayList mListCategoryValues = new ArrayList();
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_category_);
        mContext = this;
        addValuesToCategoryList();
        System.out.println("Githubbbbb chck");
        initializeValues();
        // binding = DataBindingUtil.setContentView(this, R.layout.fragment_purchase_list);


    }

    private void initializeValues() {
        mAppName_tv = (TextView) findViewById(R.id.app_name_tv);
        mSelectCategory_tv = (TextView) findViewById(R.id.selectCategory_tv);
        mCategory_rv = (RecyclerView) findViewById(R.id.category_rv);
        mCategory_rv.setLayoutManager(new GridLayoutManager(mContext, 3));
        mCategory_rv.setAdapter(new Select_Category_adapter(mContext, mListCategoryValues));

    }

    private void addValuesToCategoryList() {
        mListCategoryValues.add("Nails");
        mListCategoryValues.add("HiaRS");
        mListCategoryValues.add("HiaRS");
        mListCategoryValues.add("EYSS");
        mListCategoryValues.add("HiaRS");
        mListCategoryValues.add("Waxing");
        mListCategoryValues.add("Makeup");
        mListCategoryValues.add("Tannibg");
        mListCategoryValues.add("Eyes");


    }
}
