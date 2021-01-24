package com.example.jgufuridavaleba;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.security.cert.PolicyNode;
import java.util.ArrayList;
import java.util.List;

public class Activity2 extends AppCompatActivity {

    ListView listView;
    DatabaseReference databaseReference;
    List<String> title_list, answer_list;
    ArrayAdapter<String> arrayAdapter;


    Book book1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        listView = findViewById(R.id.listView);
        databaseReference = FirebaseDatabase.getInstance().getReference("jgufuridavaleba1");
        book1 = new Book();
        title_list = new ArrayList<>();
        answer_list = new ArrayList<>();



        arrayAdapter = new ArrayAdapter<>(this,R.layout.item,R.id.item,title_list);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                // am cvladis shemogebis shemdeg aplikacias vushvebdi, magram bolos iqrasheboda
                DataSnapshot dataSnapshot = null;
                for(DataSnapshot d : dataSnapshot.getChildren()) {
                    book1 = d.getValue(Book.class);
                    title_list.add(book1.getTitle());
                    answer_list.add(book1.getAnswer());

                }

                listView.setAdapter(arrayAdapter);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent intent = new Intent(Activity2.this,answer.class);
                        String p = answer_list.get(position);
                        intent.putExtra("answer",p);
                        startActivity(intent);
                    }
                });

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}