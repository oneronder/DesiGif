package com.phunsukwangdu.desigif;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import static com.phunsukwangdu.desigif.R.id.imageView2;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        ImageView gif= (ImageView) findViewById(R.id.imageView2);
        Glide
                .with(this) // replace with 'this' if it's in activity
                .load("https://firebasestorage.googleapis.com/v0/b/desigif-f8bcf.appspot.com/o/giphy-downsized.gif?alt=media&token=0e035928-2ea5-498f-bbc9-69865e721002")
                .asGif()
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .into(gif);

//
//        GifImageView gifView = (GifImageView) findViewById(R.id.gif_image_view1);
////        gifView.setBytes(getBitmapBytes(""));
//
//        if (getBitmapBytes("") != null) {
//            gifView.setBytes(getBitmapBytes("R.drawable.giphy"));
//        }
//    }
//
//
//    private byte[] getBitmapBytes(String path1) {
//        String path = Environment.getExternalStorageDirectory() + "/gifhub/mygif_" + 1 + ".gif";
//        File file = new File(path);
//                        Context context = getApplicationContext();
//                CharSequence text = path;
//                int duration = Toast.LENGTH_SHORT;
//                Toast toast = Toast.makeText(context, text, duration);
//                toast.show();
//        int size = (int) file.length();
//        byte[] bytess = new byte[size];
//        try {
//            BufferedInputStream buff = new BufferedInputStream(new FileInputStream(file));
//            buff.read(bytess, 0, bytess.length);
//            buff.close();
//            return bytess;
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//
//        }
//        return null;
    }
}


