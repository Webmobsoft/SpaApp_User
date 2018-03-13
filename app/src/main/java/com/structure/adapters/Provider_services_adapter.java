package com.structure.adapters;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.structure.R;

import java.util.ArrayList;

/**
 * Created by root on 26/4/17.
 */
public class Provider_services_adapter extends RecyclerView.Adapter<Provider_services_adapter.ViewHolder> {
    Context mContext;
    Typeface face;
    ArrayList mListServiceName,mListCategoryName;

    public Provider_services_adapter(Context mContext, ArrayList mListServiceName,ArrayList mListCategoryName) {
        this.mContext = mContext;

        this.mListCategoryName=mListCategoryName;
        this.mListServiceName=mListServiceName;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_provider_service, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.mServiceName_tv.setText(mListServiceName.get(position).toString());
        holder.mServiceCategory_tv.setText(mListCategoryName.get(position).toString());

        holder.mPrice_tv.setText("150");
        holder.mTime_tv.setText("120min");


    }


    @Override
    public int getItemCount() {

        return mListServiceName.size();


    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView mServiceName_tv,mServiceCategory_tv,mTime_tv,mPrice_tv;
//tv_service_category_tv
        public ViewHolder(View itemView) {
            super(itemView);
            mServiceName_tv= (TextView) itemView.findViewById(R.id.service_name_tv);
            mTime_tv= (TextView) itemView.findViewById(R.id.time_tv);
            mPrice_tv= (TextView) itemView.findViewById(R.id.price_tv);
mServiceCategory_tv= (TextView) itemView.findViewById(R.id.tv_service_category_tv);


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