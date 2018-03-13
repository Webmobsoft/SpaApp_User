package com.structure.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.structure.R;
import com.structure.adapters.Provider_services_adapter;
import com.structure.adapters.ViewPagerAdapter;

import java.util.ArrayList;

public class Provider_Deatil_Actvity extends AppCompatActivity {
    private RecyclerView mServices_rv;
    private TextView mReveiew_tv;
    private Context mContext;
    private ArrayList mListCategoryName = new ArrayList();
    private ArrayList mListServiceName = new ArrayList();
    private ViewPager mViewPager;
private LinearLayout mLnr_ViewPagerCountDots;
    private int dotsCount;
    private ViewPagerAdapter mAdapter;
    int TOTAL_PAGES = 0;
    private ImageView[] dots;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_provider__deatil__actvity);
        mContext = this;
        addValuesToList();
        initializeValues();
        buildCircles();
        setUiPageViewController(5);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                System.out.println("Postion:    " + position);

                setIndicator(position);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


    }

    private void addValuesToList() {
        mListCategoryName.add("Hair");
        mListCategoryName.add("Eyes");
        mListCategoryName.add("Makeup");
        mListCategoryName.add("hands");

        mListServiceName.add("Bridal Makeup");
        mListServiceName.add("Makeup");
        mListServiceName.add("Manicure");
        mListServiceName.add("Pedicure");
    }

    private void initializeValues() {

        mReveiew_tv = (TextView) findViewById(R.id.review_tv);
        mViewPager= (ViewPager) findViewById(R.id.pager_introduction);
        mServices_rv = (RecyclerView) findViewById(R.id.services_rv);
        mServices_rv.setLayoutManager(new LinearLayoutManager(this));
        mServices_rv.setAdapter(new Provider_services_adapter(mContext, mListServiceName, mListCategoryName));
        mLnr_ViewPagerCountDots= (LinearLayout) findViewById(R.id.viewPagerCountDots);

    }

    private void setUiPageViewController(int pos) {
        dotsCount = 5;

      //  dotsCount = mAdapter.getCount();
        System.out.println(">>>>>>>>>>>>>>>>>>>>>   " + 5);
        dots = new ImageView[dotsCount];

        for (int i = 0; i < dotsCount; i++) {
            System.out.println("Values of i: " + i + "    " + dotsCount);

            dots[i] = new ImageView(mContext);
            if (i == 0) {
                dots[0].setImageDrawable(getResources().getDrawable(R.drawable.selecteditem_dot));
            } else if (i == dotsCount) {
                dots[0].setImageDrawable(getResources().getDrawable(R.drawable.selecteditem_dot));
            } else {
                dots[i].setImageDrawable(getResources().getDrawable(R.drawable.nonselecteditem_dot));
            }

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );

            params.setMargins(4, 0, 4, 0);

            mLnr_ViewPagerCountDots.addView(dots[i], params);
        }
        //  dots[0].setImageDrawable(getResources().getDrawable(R.drawable.selecteditem_dot));
    }
    private void buildCircles() {
        for (int i = 0; i < TOTAL_PAGES; i++) {
            ImageView circle = new ImageView(this);
            circle.setImageResource(R.drawable.nonselecteditem_dot);
        }
        setIndicator(0);
    }


    private void setIndicator(int index) {
        if (index < TOTAL_PAGES) {

            for (int i = 0; i < TOTAL_PAGES; i++) {
                ImageView circle = (ImageView) mLnr_ViewPagerCountDots.getChildAt(i);
                if (i == index) {
                    circle.setImageResource(R.drawable.selecteditem_dot);
                } else {
                    circle.setImageResource(R.drawable.nonselecteditem_dot);
                }
            }
        }

    }
}
