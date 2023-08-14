package com.example.recylerviewexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ClipData;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
ArrayList<ContactMode> arrContacts = new ArrayList<>();
private SearchView searchView;
private RecylerContactAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        searchView = findViewById(R.id.searchView);
        searchView.clearFocus();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                fileList(newText);
                return true;
            }
        });

        RecyclerView recyclerView = findViewById(R.id.recylerContact);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // ContactMode model = new ContactMode(R.drawable.ic_launcher_background, "Aditya","9026535980");
        // we do not need to create the contact model object everytime, we can directly pass into the arrayList

        arrContacts.add(new ContactMode(R.drawable.ic_launcher_background,"Aditya","9026535980"));
        arrContacts.add(new ContactMode(R.drawable.ic_launcher_background,"Ayush","9026535980"));
        arrContacts.add(new ContactMode(R.drawable.ic_launcher_background,"Amrit","9026535980"));
        arrContacts.add(new ContactMode(R.drawable.ic_launcher_background,"Anupum","9026535980"));
        arrContacts.add(new ContactMode(R.drawable.ic_launcher_background,"Abhinav","9026535980"));
        arrContacts.add(new ContactMode(R.drawable.ic_launcher_background,"Atin","9026535980"));
        arrContacts.add(new ContactMode(R.drawable.ic_launcher_background,"Fabian","9026535980"));
        arrContacts.add(new ContactMode(R.drawable.ic_launcher_background,"Ajay","9026535980"));
        arrContacts.add(new ContactMode(R.drawable.ic_launcher_background,"Gangwar","9026535980"));
        arrContacts.add(new ContactMode(R.drawable.ic_launcher_background,"Ankur","9026535980"));
        arrContacts.add(new ContactMode(R.drawable.ic_launcher_background,"Anushka","9056535980"));
        arrContacts.add(new ContactMode(R.drawable.ic_launcher_background,"Aditi","9026535980"));
        arrContacts.add(new ContactMode(R.drawable.ic_launcher_background,"Alankrita","9026535980"));
        arrContacts.add(new ContactMode(R.drawable.ic_launcher_background,"Afseen","9026535980"));
        arrContacts.add(new ContactMode(R.drawable.ic_launcher_background,"Astha","9026535980"));
        arrContacts.add(new ContactMode(R.drawable.ic_launcher_background,"Bharti","9026535980"));
        arrContacts.add(new ContactMode(R.drawable.ic_launcher_background,"Alia","9026535980"));
        arrContacts.add(new ContactMode(R.drawable.ic_launcher_background,"Anamika","9026535980"));
        arrContacts.add(new ContactMode(R.drawable.ic_launcher_background,"Akshita","9026535980"));


        adapter = new RecylerContactAdapter(this,arrContacts);
        recyclerView.setAdapter(adapter);

    }

    private void fileList(String newText) {
        ArrayList<ContactMode> filteredList = new ArrayList<>();
        for(ContactMode c : arrContacts){
            if(c.getName().toLowerCase().contains(newText.toLowerCase())){
                filteredList.add(c);
            }
        }
        if(filteredList.isEmpty()){
            Toast.makeText(this, "No Data found.", Toast.LENGTH_SHORT).show();
        }else{

            adapter.setFilteredList((ArrayList<ContactMode>) filteredList);
        }
    }
}