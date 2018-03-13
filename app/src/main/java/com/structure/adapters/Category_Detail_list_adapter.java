package com.structure.adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.structure.R;
import com.structure.ui.Provider_Deatil_Actvity;

import java.util.ArrayList;

/**
 * Created by root on 26/4/17.
 */
public class Category_Detail_list_adapter extends RecyclerView.Adapter<Category_Detail_list_adapter.ViewHolder> {
    Context mContext;
    Typeface face;
    ArrayList mListCategoryValues;

    public Category_Detail_list_adapter(Context mContext, ArrayList mListCategoryValues) {
        this.mContext = mContext;
        this.mListCategoryValues = mListCategoryValues;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_category_details, parent, false);


        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.mMerchntName_tv.setText(mListCategoryValues.get(position).toString());
        holder.mSkillName_tv.setText(mListCategoryValues.get(position).toString());
        holder.mRating_tv.setText("7.0");
    }


    @Override
    public int getItemCount() {

        return mListCategoryValues.size();


    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView mMerchntName_tv, mSkillName_tv, mRating_tv;
        ImageView mImg_Provider, mImg_Wishlist;


        /* private ItemCartListBinding binding;


         public ItemCartListBinding getBinding() {
             return binding;
         }

         public void setBinding(ItemCartListBinding binding) {
             this.binding = binding;
         }
 */
        public ViewHolder(View itemView) {
            super(itemView);
            mMerchntName_tv = (TextView) itemView.findViewById(R.id.merchantName_tv);
            mSkillName_tv = (TextView) itemView.findViewById(R.id.merchantService_tv);
            mRating_tv = (TextView) itemView.findViewById(R.id.rating_tv);
            mImg_Provider = (ImageView) itemView.findViewById(R.id.provider_img);
            mImg_Wishlist = (ImageView) itemView.findViewById(R.id.img_wishList);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(mContext, Provider_Deatil_Actvity.class);
                    mContext.startActivity(intent);
                }
            });
        }

    }

}

/*




















               // InputStream is = new BufferedInputStream(url.openStream(), 8192);

               /* File rootPath = new File(Environment.getDataDirectory(), context.getPackageName());
                if(!rootPath.exists()) {
                    rootPath.mkdirs();
                }
                File dataFile = new File(rootPath, "Videos");
                if(!Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
                    Toast.makeText(context, "Cannot use storage.", Toast.LENGTH_SHORT).show();
                  // context.finish();
                   // return;
                }*/


              /*  File sdCard = Environment.getDataDirectory();
                File dir = new File (sdCard.getAbsolutePath()+"/"+context.getPackageName() + "/Videos/videos");
                dir.mkdirs();
                File file = new File(dir, "Viddddd.exo");*/

// FileOutputStream f = new FileOutputStream(file);
//  OutputStream output = new FileOutputStream(file);

//  OutputStream output = new FileOutputStream("/sdcard"+"/videoplayer"+"/downloadedfile.exo");
//  OutputStream output = new FileOutputStream(dataFile+"/downloadedfile.exo");

//FileOutputStream fout;
//   InputStream is = context.getContentResolver().openInputStream(uri);
               /* if (null != is) { // input stream is valid
                    File file = new File(Environment.getExternalStorageDirectory()
                            + "/" + context.getResources().getString(R.string.app_name) + "/Videos" + "/Video.exo");
                    fout = new FileOutputStream(file);
                    int read;
                    byte[] bytes = new byte[1024];

                    while ((read = is.read(bytes)) != -1) {
                        fout.write(bytes, 0, read);
                    }
                    fout.flush();
                    fout.close();
                    is.close();
                    System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>   path"+file.getAbsolutePath());

                    return file.getAbsolutePath();
                }
*/

                /*byte data[] = new byte[1024];
                long total = 0;
                while ((count = is.read(data)) != -1) {
                    total += count;
                    publishProgress("" + (int) ((total * 100) / lenghtOfFile));
                    fout.write(data, 0, count);
                }
                fout.flush();
                fout.close();
                is.close();*/