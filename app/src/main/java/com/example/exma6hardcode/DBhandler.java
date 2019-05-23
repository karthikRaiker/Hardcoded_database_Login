package com.example.exma6hardcode;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBhandler extends SQLiteOpenHelper {

    private static final int DB_version = 1;
    private static final String DB_name="users";
    private static final String Table_name="user";
    private static final String User_id="id";
    private static final String User_name="name";
    private static final String User_password="password";

    public DBhandler(Context context)
    {
        super(context, DB_name,null,DB_version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+ Table_name + "(" +User_id+ " INTEGER PRIMARY KEY, " + User_name + " TEXT, " +User_password+ " TEXT );");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+Table_name);
        onCreate(db);

    }

    public void adduser(User usr)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(User_name, usr.getName());
        cv.put(User_password,usr.getPassword());
        db.insert(Table_name, null,cv);
        db.close();

    }

    public int checkUser(User us)
    {
        int id = -1;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT id FROM user WHERE name=? AND password=?",new String[]{us.getName(),us.getPassword()});
        if(cursor.getCount()>0)
        {
            cursor.moveToFirst();
            id=cursor.getInt(0);
            cursor.close();
        }
        return id;
    }
}


