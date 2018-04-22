package app.cool.dz.coolapp.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class DataBasePostsHelper extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "todos_db";


    public SQLiteDatabase db;
        List<String> todoList ;

  public DataBasePostsHelper(Context context) {
      super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table todos (_id integer primary key autoincrement, title text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    /**
     * Add a new row to the database table
     * @param title The title value for the new row
     * @return The unique id of the newly added row
     */
    public long add(String title) {
        SQLiteDatabase db = this.getWritableDatabase();
        if (db == null) {
            return 0;
        }
        ContentValues row = new ContentValues();
        row.put("title", title);
        long id = db.insert("todos", null, row);
        Log.i("db_log","new todo add");
        db.close();
        return id;
    }

    /**
     * List all rows to the database table
     */
    public List<String> list() {
        SQLiteDatabase db = this.getReadableDatabase();
        todoList = new ArrayList<String>();
        Cursor cursor  = db.rawQuery("select * from todos",null);
        while (cursor.moveToNext()) {

            //cursor.getInt(cursor.getColumnIndex("id"));
            todoList.add(cursor.getString(cursor.getColumnIndex("title")));
            //Log.i("db_log",cursor.getString(cursor.getColumnIndex("title")));

        }
        db.close();
        return todoList;

    }

}
