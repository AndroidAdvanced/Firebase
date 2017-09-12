package com.firebase;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    DatabaseReference databaseArtist;

    ListView listView;

    List<Artist> artistList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);


        artistList = new ArrayList<Artist>();
        databaseArtist = FirebaseDatabase.getInstance().getReference("artists");

        listView = (ListView) findViewById(R.id.listView);

        Button btn = (Button) findViewById(R.id.button2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addArtist();
            }
        });
    }


    @Override
    protected void onStart() {
        super.onStart();

        databaseArtist.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                artistList = new ArrayList<Artist>();

                for(DataSnapshot artistSnapShot : dataSnapshot.getChildren()) {

                    Artist artist = artistSnapShot.getValue(Artist.class);
                    artistList.add(artist);
                }

                ArtistList adapter = new ArtistList(MainActivity.this, artistList);
                listView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    void addArtist() {

        System.out.println("ABC A");

        EditText edit= (EditText) findViewById(R.id.editText);
        String name = edit.getText().toString().trim();
        Spinner spinner = (Spinner) findViewById(R.id.spinner);

        String spinnerVal = spinner.getSelectedItem().toString();
        System.out.println("ABC B");

        if(!TextUtils.isEmpty(name)) {
            System.out.println("ABC C");

            String id = databaseArtist.push().getKey();

            Artist artist = new Artist(name, id, spinnerVal);

            databaseArtist.child(id).setValue(artist);
            System.out.println("ABC D");

            Toast.makeText(this,"artist added", Toast.LENGTH_LONG).show();

        } else {
            System.out.println("ABC E");

        }
    }
}
