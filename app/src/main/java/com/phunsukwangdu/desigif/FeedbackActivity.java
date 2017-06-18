package com.phunsukwangdu.desigif;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FeedbackActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        Button fbb = (Button)findViewById(R.id.Feedbackbutton);
        fbb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();


                // Intent intent = new Intent(passwordActivity.this, passwordActivity.class);
                // startActivity(intent);
            }
        });
    }
}
