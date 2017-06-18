package com.phunsukwangdu.desigif;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class passwordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);
        Button pcb = (Button)findViewById(R.id.submitpass);
        pcb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
               // Intent intent = new Intent(passwordActivity.this, passwordActivity.class);
                // startActivity(intent);
            }
        });
    }
}
