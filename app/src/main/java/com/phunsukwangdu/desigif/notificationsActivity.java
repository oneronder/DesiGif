package com.phunsukwangdu.desigif;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class notificationsActivity extends AppCompatActivity {

    String[] mobileArray = {"⚡️ user5 started following you","⚡️ user7 started following you","⚡️ user3 started following you","♥ user4 liked your post",
            "⚡️ user4 started following you","♥ user2 liked your post","⚡️ user6 started following you","♥ user8 liked your post","⚡️ user7 started following you","⚡️ user3 started following you","♥ user4 liked your post",
            "⚡️ user4 started following you","♥ user2 liked your post","⚡️ user6 started following you","♥ user8 liked your post"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications);
        ArrayAdapter adapter = new ArrayAdapter<String>(this,
                R.layout.notifiacationitems, mobileArray);

        ListView listView = (ListView) findViewById(R.id.mobile_list);
        listView.setAdapter(adapter);

    }
}
