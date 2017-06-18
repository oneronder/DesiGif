package com.phunsukwangdu.desigif;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.phunsukwangdu.desigif.utils.gifpost;

public class commentActivity extends AppCompatActivity {

    final String[] mobileArrayy = {"user5 started amazing gif ","user7 cool gif dude","user3 awesome gif pal","user @susmit nice app!"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);
        //final ArrayAdapter adapter = new ArrayAdapter<String>(this,
         //       R.layout.notifiacationitems, mobileArrayy);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference myRef = database.getReference("gifpost");

        ListView listView = (ListView) findViewById(R.id.comment_list);
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
        FirebaseListAdapter mAdapter = new FirebaseListAdapter<gifpost>(this, gifpost.class, R.layout.notifiacationitems, myRef) {
            @Override
            protected void populateView(View view, gifpost gifpst, int position) {
                ((TextView) view.findViewById(R.id.label)).setText(gifpst.comment);


            }
        };
        listView.setAdapter(mAdapter);
        //listView.setAdapter(adapter);
        Button cButton = (Button)findViewById(R.id.buttonc);
        final EditText mEdit   = (EditText)findViewById(R.id.usercomment);
        //final DatabaseReference myRef2 = database.getReference("message2");

        cButton.setOnClickListener(
                new View.OnClickListener()
                {
                    public void onClick(View view)
                    {
                        gifpost gifpst = new gifpost(mEdit.getText().toString());
                        String key = myRef.push().getKey();
                        myRef.child(key).setValue(gifpst);
                        //myRef2.setValue(mEdit.getText().toString());
                        //adapter.notifyDataSetChanged();
                    }
                });





    }
}
