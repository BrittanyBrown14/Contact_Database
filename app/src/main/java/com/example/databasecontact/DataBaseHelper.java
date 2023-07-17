package com.example.databasecontact;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DataBaseHelper extends SQLiteOpenHelper {
    public static final String CONTACT_TABLE = "CONTACT_TABLE";
    public static final String COLUMN_ID = "ID";
    public static final String COLUMN_FIRST_NAME = "FIRST_NAME";
    public static final String COLUMN_LAST_NAME = "LAST_NAME";
    public static final String COLUMN_EMAIL = "EMAIL";
    public static final String COLUMN_DOB = "DOB";
    public static final String COLUMN_IS_ACTIVE = "IS_ACTIVE";


    @Override
    //Is called the first time the db us accessed.
    //There should be code in here to create a new db
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createTableStatement = "CREATE TABLE " + CONTACT_TABLE + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_FIRST_NAME + " TEXT, " + COLUMN_LAST_NAME + " TEXT, " +
                COLUMN_EMAIL + " TEXT, " + COLUMN_DOB + " INT, " + COLUMN_IS_ACTIVE + " BOOL )";

        sqLiteDatabase.execSQL(createTableStatement);
    }

    //this is called when the db version number changes
    //prevents the app from breaking when the db design changes
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public DataBaseHelper(@Nullable Context context) {
        super(context, "contact.db", null, 1);
    }

    public boolean addRecord(ContactModel contactModel)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_FIRST_NAME, contactModel.getFirstName());
        cv.put(COLUMN_LAST_NAME, contactModel.getLastName());
        cv.put(COLUMN_EMAIL, contactModel.getEmail());
        cv.put(COLUMN_DOB, contactModel.getDOB());
        cv.put(COLUMN_IS_ACTIVE, contactModel.isActive());

        long insert = db.insert(CONTACT_TABLE, null, cv);
        if (insert == -1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    public List<ContactModel>getAll()
    {
        List<ContactModel> returnList = new ArrayList<>();
        //get data from db

        String queryAll = "SELECT * FROM " + CONTACT_TABLE;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(queryAll, null);

        if (cursor.moveToFirst())
        {
            // loop through the results and create new customer objects and put them in the return list
            do {
                int contactID = cursor.getInt(0);
                String contactFirstName = cursor.getString(1);
                String contactLastName = cursor.getString(2);
                String contactEmail = cursor.getString(3);
                String contactDOB = cursor.getString(4);
                boolean contactIsActive = cursor.getInt(5) == 1 ? true:false;

                ContactModel newContact = new ContactModel(contactID, contactFirstName, contactLastName, contactEmail, contactDOB, contactIsActive);
                returnList.add(newContact);
            } while (cursor.moveToNext());

        }
        else
        {
            // Fail. Do not add anything to the list
        }
        //close the cursor and the db when everything is done
        cursor.close();
        db.close();
        return returnList;
    }
}
