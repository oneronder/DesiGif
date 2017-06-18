package com.phunsukwangdu.desigif.galleryhome;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.felipecsl.gifimageview.library.GifImageView;
import com.phunsukwangdu.desigif.ProfileActivity;
import com.phunsukwangdu.desigif.R;
import com.phunsukwangdu.desigif.commentActivity;
import com.phunsukwangdu.desigif.ui.DisplayActivity;
import com.phunsukwangdu.desigif.utils.Constants;
import com.phunsukwangdu.desigif.utils.PreferenceManager;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class GifAdapter extends BaseAdapter {

    private Context mContext;
    private boolean liked=false;
    private final String GIF_POSITION =  "position";
    private String TAG = GifAdapter.class.getSimpleName();
    private ArrayList<String> paths;

    public GifAdapter(Context pContext){
        this.mContext = pContext;
        paths =  new ArrayList<>();
        getPaths();
    }

    private void getPaths(){
        Log.d(TAG,"gif count in getpaths "+PreferenceManager.getInstance(mContext).getGifCount());
        if(PreferenceManager.getInstance(mContext).getGifCount()>= 1) {
            for (int i = 1; i <= PreferenceManager.getInstance(mContext).getGifCount(); i++) {
                String p = Constants.PATH_TO_GIF_FILES + i + ".gif";
                if(new File(p).exists()) {
                    Log.d(TAG, "each path " + i + " p");
                    paths.add(p);
                    Collections.reverse(paths);
                }
            }
        }else{
            Log.d(TAG,"gif count is 0");
        }
    }
    @Override
    public int getCount() {
        return paths.size();
    }

    @Override
    public Object getItem(int position) {
        return paths.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        final ViewHolder viewHolder;

        if(convertView == null){
            convertView = LayoutInflater.from(mContext).inflate(R.layout.gif_grid_item,null,false);
             viewHolder = new ViewHolder(convertView);

            convertView.setTag(viewHolder);
        }
        else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

        if(getBitmapBytes(position)!= null) {
            Log.d(TAG,"bitmap found at "+position);
            viewHolder.gifImageView.setBytes(getBitmapBytes(position));
            Log.d(TAG,"frames duration "+ viewHolder.gifImageView.getFramesDisplayDuration());
            viewHolder.profile.setText("susmit");

            viewHolder.profile.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View arg0) {
                    mContext.startActivity(new Intent(mContext, ProfileActivity.class));
                  //  Intent intent = new Intent(GalleryHomeActivity.this, ProfileActivity.class);
                    //  startActivity(intent);
                }
            });
          //  viewHolder.gifImageView.setFramesDisplayDuration(500);

            viewHolder.gifImageView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View arg0) {
                    //mContext.startActivity(new Intent(mContext, ProfileActivity.class));
                    //  Intent intent = new Intent(GalleryHomeActivity.this, ProfileActivity.class);
                    //  startActivity(intent);
                    if(!liked){
                        viewHolder.like.setBackgroundResource(R.mipmap.ic_favorite_black_24dp);
                        liked = true;
                    }
                    else{
                        viewHolder.like.setBackgroundResource(R.mipmap.ic_favorite_border_black_24dp);
                        liked = false;
                    }
                    //Toast.makeText(arg0.getContext(), "like", Toast.LENGTH_SHORT).show();
                }
            });

            viewHolder.like.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View arg0) {
                    //mContext.startActivity(new Intent(mContext, ProfileActivity.class));
                    //  Intent intent = new Intent(GalleryHomeActivity.this, ProfileActivity.class);
                    //  startActivity(intent);
                    if(!liked){
                    arg0.setBackgroundResource(R.mipmap.ic_favorite_black_24dp);
                       liked = true;
                    }
                    else{
                        arg0.setBackgroundResource(R.mipmap.ic_favorite_border_black_24dp);
                        liked = false;
                    }
                    //Toast.makeText(arg0.getContext(), "like", Toast.LENGTH_SHORT).show();
                }
            });

            viewHolder.share.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View arg0) {
                    mContext.startActivity(new Intent(mContext, DisplayActivity.class).putExtra(GIF_POSITION,getItem(position).toString()));
                    //  Intent intent = new Intent(GalleryHomeActivity.this, ProfileActivity.class);
                    //  startActivity(intent);
                    //Toast.makeText(arg0.getContext(), "Share", Toast.LENGTH_SHORT).show();
                }
            });

            viewHolder.comment.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View arg0) {
                    //mContext.startActivity(new Intent(mContext, ProfileActivity.class));
                    //  Intent intent = new Intent(GalleryHomeActivity.this, ProfileActivity.class);
                    //  startActivity(intent);
                    mContext.startActivity(new Intent(mContext, commentActivity.class));

                    Toast.makeText(arg0.getContext(), "Comment", Toast.LENGTH_SHORT).show();
                }
            });

            viewHolder.gifImageView.startAnimation();
        }else
            Log.d(TAG,"bitmap not found at "+position);
        return convertView;
    }



    private   class ViewHolder{
        private GifImageView gifImageView;
        //private Toolbar toptoolbar;
       // private Toolbar bottomtoolbar;
        private Button like;
        private Button comment;
        private Button share;
        private TextView profile;
        private ImageView Iprofile;


        public ViewHolder(View view){
            this.gifImageView = (GifImageView) view.findViewById(R.id.gif_image_view);
            this.like = (Button)view.findViewById(R.id.sun);
            this.comment = (Button)view.findViewById(R.id.comment);
            this.share = (Button)view.findViewById(R.id.share);
           // this.toptoolbar = (Toolbar)view.findViewById(R.id.toolbar);
            //this.bottomtoolbar = (Toolbar)view.findViewById(R.id.toolbar2);
            this.Iprofile = (ImageView)view.findViewById(R.id.sd);
            this.profile = (TextView)view.findViewById(R.id.textView4);
        }
    }

    private byte[] getBitmapBytes(int indx){
        String path = paths.get(indx);
        File file = new File(path);
        int size = (int) file.length();
        byte[] bytes = new byte[size];
        try{
            BufferedInputStream buf = new BufferedInputStream(new FileInputStream(file));
            buf.read(bytes, 0, bytes.length);
            buf.close();
            return bytes;
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){

        }
        return null;
    }
}
