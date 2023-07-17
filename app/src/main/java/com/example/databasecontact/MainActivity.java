package com.example.databasecontact;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText firstName;
    EditText lastName;
    EditText Email;
    EditText DoB;
    Button saveBtn;
    Button viewBtn;
    Switch isActive;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstName = findViewById(R.id.editTextFirstName);
        lastName = findViewById(R.id.editTextLastName);
        Email = findViewById(R.id.editTextEmail);
        DoB = findViewById(R.id.editTextDOB);
        saveBtn = findViewById(R.id.saveButton);
        viewBtn = findViewById(R.id.viewButton);
        isActive = findViewById(R.id.activeSwitch);
    }
    public void addContact(View v)
    {
        ContactModel cm;
        try
        {
            cm = new ContactModel(-1, firstName.getText().toString(),lastName.getText().toString(),Email.getText().toString()
                    ,DoB.getText().toString(),isActive.isChecked() );
        }
        catch (Exception ex)
        {
            Toast.makeText(this, "error:" + ex, Toast.LENGTH_SHORT).show();
            cm = new ContactModel(-1, "error", "error", "error","No DOB" , isActive.isChecked());
        }

        DataBaseHelper dataBaseHelper = new DataBaseHelper(MainActivity.this);

        boolean success = dataBaseHelper.addRecord(cm);
        Toast.makeText(this, "Success = " + success, Toast.LENGTH_SHORT).show();

    }
    public void onClick(View v)
    {
        // TODO Auto-generated method stub
        Intent i = new Intent(getApplicationContext(),ViewingActivity.class);
        startActivity(i);

    }
}