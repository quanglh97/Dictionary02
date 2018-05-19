package com.example.khaik.Database;

import android.database.sqlite.SQLiteOpenHelper;

        import android.content.Context;
        import android.database.Cursor;
        import android.database.sqlite.SQLiteDatabase;
        import android.database.sqlite.SQLiteOpenHelper;

import com.example.khaik.Model.Word;

import java.lang.reflect.Array;
import java.util.ArrayList;
        import java.util.List;

public class DatabaseAccess {
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase database;
    private static DatabaseAccess instance;

    /**
     * Private constructor to aboid object creation from outside classes.
     *
     * @param context
     */
    private DatabaseAccess(Context context) {
        this.openHelper = new DatabaseOpenHelper(context);
    }

    /**
     * Return a singleton instance of DatabaseAccess.
     *
     * @param context the Context
     * @return the instance of DabaseAccess
     */
    public static DatabaseAccess getInstance(Context context) {
        if (instance == null) {
            instance = new DatabaseAccess(context);
        }
        return instance;
    }

    /**
     * Open the database connection.
     */
    public void open() {
        this.database = openHelper.getWritableDatabase();
    }

    /**
     * Close the database connection.
     */
    public void close() {
        if (database != null) {
            this.database.close();
        }
    }

    /**
     * Read all quotes from the database.
     *
     * @return a List of quotes
     */
    public ArrayList<Word> getAllWord() {
        ArrayList<Word> ListWord = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM table_of_datable", null);
        if(cursor.moveToFirst())
        {
            do
            {
                Word word = new Word();
                word.setmID(cursor.getInt(0));
                word.setmWord(cursor.getString(1));
                word.setmMean(cursor.getString(2));
                ListWord.add(word);
            }while (cursor.moveToNext());
        }
        cursor.close();
        return ListWord;
    }
}