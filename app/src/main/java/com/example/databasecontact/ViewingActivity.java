package com.example.databasecontact;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class ViewingActivity extends AppCompatActivity {

    ListView lv;
    ArrayAdapter contactAdapter;
    List<ContactModel> all;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewing);

        lv = findViewById(R.id.listView1);

        DataBaseHelper dataBaseHelper =  new DataBaseHelper(ViewingActivity.this);

        all = dataBaseHelper.getAll();
        showAllContacts(all);
    }

    public void back(View v)
    {
        // TODO Auto-generated method stub
        Intent i = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(i);

    }

    public void refresh(View v)
    {
        showAllContacts(all);
    }

    private void showAllContacts(List<ContactModel> all) {
        contactAdapter = new ArrayAdapter<ContactModel>(ViewingActivity.this, android.R.layout.simple_list_item_1, all);
        lv.setAdapter(contactAdapter);
    }
}