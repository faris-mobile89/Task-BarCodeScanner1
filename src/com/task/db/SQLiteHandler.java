package com.task.db;

import java.util.LinkedList;
import java.util.List;
import com.task.model.Comment;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class SQLiteHandler extends SQLiteOpenHelper  {

	 
    private static final int DATABASE_VERSION = 1;
    
    private static final String DATABASE_NAME = "CommentsDB";
 
    public SQLiteHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);  
    }
 
    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_COMMENTS_TABLE = "CREATE TABLE comments ( " +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "text TEXT )";
 
        db.execSQL(CREATE_COMMENTS_TABLE);
    }
 
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS comments");
        this.onCreate(db);
    }

    private static final String TABLE_COMMENTS = "comments";
    private static final String KEY_TEXT = "text";

 
    public void addComment(Comment comment){
        Log.d("addComment", comment.toString());

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_TEXT, comment.getText());
 
        db.insert(TABLE_COMMENTS, null, values);
 

        db.close(); 
    }
 
 

    public List<Comment> getAllComments() {
        List<Comment> comments = new LinkedList<Comment>();
 
        String query = "SELECT  * FROM " + TABLE_COMMENTS+" ORDER BY id DESC";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
 
        Comment comment = null;
        if (cursor.moveToFirst()) {
            do {
                comment = new Comment();
                comment.setId(cursor.getString(0));
                comment.setText(cursor.getString(1));
 
                comments.add(comment);
            } while (cursor.moveToNext());
        }
 
        Log.d("getAllComments()", comments.toString());
 
        return comments;
    }
 
}