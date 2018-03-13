package com.structure.adapters;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.structure.R;

import java.util.List;


/**
 * Created by root on 13/7/17.
 */
public class ViewPagerAdapter extends PagerAdapter {

    private Context mContext;
    private int[] mResources;
    LayoutInflater layoutInflater;
    Typeface face;
    List<String> bannersList;

    public ViewPagerAdapter(Context mContext, int[] mResources) {
        this.mContext = mContext;
        this.mResources = mResources;

    }
    public ViewPagerAdapter(Context mContext, List<String> bannersList) {
        this.mContext = mContext;
        layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //face = Typeface.createFromAsset(mContext.getAssets(), mContext.getResources().getString(R.string.BYekan));
        this.bannersList = bannersList;
    }

    @Override
    public int getCount() {
        return bannersList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((LinearLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        //   LayoutInflater infl=LayoutInflater.from(mContext);
        View itemView = layoutInflater.inflate(R.layout.pager_item_provider_screen, container, false);

        ImageView imageView = (ImageView) itemView.findViewById(R.id.img_pager_item);


        Glide.with(mContext)

                .load(R.mipmap.ic_launcher).asBitmap()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .dontTransform().dontAnimate()
                .error(R.mipmap.ic_launcher).into(imageView);


        container.addView(itemView);




        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }

}
