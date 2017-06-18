package com.phunsukwangdu.desigif.galleryhome;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.phunsukwangdu.desigif.R;
import com.phunsukwangdu.desigif.SettingsActivity;
import com.phunsukwangdu.desigif.notificationsActivity;
import com.phunsukwangdu.desigif.ui.DisplayActivity;
import com.phunsukwangdu.desigif.ui.Main2Activity;

public class GalleryHomeActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    private  final String TAG = GalleryHomeActivity.class.getSimpleName();

    private GridView mGridView;

    private final String GIF_POSITION =  "position";

    private LinearLayout noGifLayout;

    private GifAdapter mAdapter;

    private Button makeGif;

    private TextView nogifsTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery_home);
        //setToolbar();
        mGridView = (GridView)findViewById(R.id.gridview);
        noGifLayout = (LinearLayout)findViewById(R.id.no_gif_layout);
        makeGif = (Button)findViewById(R.id.make_gif_button);
      //  makeGif.setTypeface(Typeface.createFromAsset(getAssets(),"bungamelatiputih.ttf"));
        nogifsTextView = (TextView)findViewById(R.id.no_gif_yet);
       // nogifsTextView.setTypeface(Typeface.createFromAsset(getAssets(),"bungamelatiputih.ttf"));
        setData();
        Button hm = (Button)findViewById(R.id.home1);
        hm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GalleryHomeActivity.this, GalleryHomeActivity.class);
                startActivity(intent);
                finish();
            }
        });

        Button cmr = (Button)findViewById(R.id.camera1);
        cmr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GalleryHomeActivity.this, Main2Activity.class);
                startActivity(intent);
            }
        });

        Button stng = (Button)findViewById(R.id.settng1);
        stng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Context context = getApplicationContext();
//                CharSequence text = "Settings!";
//                int duration = Toast.LENGTH_SHORT;
//                Toast toast = Toast.makeText(context, text, duration);
//                toast.show();
                Intent intent = new Intent(GalleryHomeActivity.this, SettingsActivity.class);
                startActivity(intent);

            }
        });

        Button notf = (Button)findViewById(R.id.notify1);
        notf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GalleryHomeActivity.this, notificationsActivity.class);
                startActivity(intent);
            }
        });



    }

    private void setData(){
         mAdapter = new GifAdapter(this);
        Log.d(TAG,"adapter count "+mAdapter.getCount());
        if(mAdapter.getCount()>0) {
            mGridView.setVisibility(View.VISIBLE);
            mGridView.setAdapter(mAdapter);
            mGridView.setOnItemClickListener(this);
            noGifLayout.setVisibility(View.GONE);
        }else{
            mGridView.setVisibility(View.GONE);
            noGifLayout.setVisibility(View.VISIBLE);
            makeGif.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(GalleryHomeActivity.this, Main2Activity.class);
                    startActivity(intent);

                }
            });
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        mAdapter.notifyDataSetChanged();
    }

    private void setToolbar(){

        Toolbar toolbar = (Toolbar)findViewById(R.id.gallery_toolbar);
        setSupportActionBar(toolbar);
        ImageView cameraIcon = (ImageView)toolbar.findViewById(R.id.camera_icon);
        cameraIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GalleryHomeActivity.this, Main2Activity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(GalleryHomeActivity.this, DisplayActivity.class);
        Log.d(TAG,"sending path "+mAdapter.getItem(position).toString());
        intent.putExtra(GIF_POSITION,mAdapter.getItem(position).toString());
        startActivity(intent);
    }
}
