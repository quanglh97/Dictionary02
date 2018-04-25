package com.example.khaik.Database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;

import com.example.khaik.Model.Friend;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;
import java.util.List;

public class Database extends SQLiteAssetHelper {
    private static final String DB_NAME = "friend.db";
    private static final int DB_VER = 1;
    public Database(Context context) {
        super(context, DB_NAME, null, DB_VER);
    }

    // Function get all Friend
    public List<Friend> getFriend()
    {
        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        // make sure all is column name in your Table
        String[] sqlSelect = {"MSSV", "TENSV"};
        String tableName = "Friend";

        qb.setTables(tableName);
        Cursor cursor = qb.query(db, sqlSelect, null, null, null, null, null);
        List<Friend> result = new ArrayList<>();
        if(cursor.moveToNext())
        {
            do {
                {
                    Friend friend = new Friend();
                    friend.setMSSV(cursor.getString(cursor.getColumnIndex("MSSV")));
                    friend.setTENSV(cursor.getString(cursor.getColumnIndex("TENSV")));

                    result.add(friend);
                }
            } while (cursor.moveToNext());
        }

        return result;
    }


    // Function get all Friend's name
    public List<String> getNames()
    {
        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        // make sure all is column name in your Table
        String[] sqlSelect = {"TENSV"};
        String tableName = "Friend";

        qb.setTables(tableName);
        Cursor cursor = qb.query(db, sqlSelect, null, null, null, null, null);
        List<String> result = new ArrayList<>();
        if(cursor.moveToNext())
        {
            do {
                {
                    result.add(cursor.getString(cursor.getColumnIndex("TENSV")));
                }
            } while (cursor.moveToNext());
        }

        return result;
    }

    // function get friend by name
    // Function get all Friend
    public List<Friend> getFriendByName(String name)
    {
        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        // make sure all is column name in your Table
        String[] sqlSelect = {"MSSV", "TENSV"};
        String tableName = "Friend";

        qb.setTables(tableName);
        Cursor cursor = qb.query(db, sqlSelect, "TENSV LIKE ?", new String[]{"%" + name + "%"}, null, null, null);
        List<Friend> result = new ArrayList<>();
        if(cursor.moveToNext())
        {
            do {
                {
                    Friend friend = new Friend();
                    friend.setMSSV(cursor.getString(cursor.getColumnIndex("MSSV")));
                    friend.setTENSV(cursor.getString(cursor.getColumnIndex("TENSV")));

                    result.add(friend);
                }
            } while (cursor.moveToNext());
        }

        return result;
    }
}
