package com.michalrys.my_notes.db;

/**
 * Created by barte on 09.01.2016.
 * 2022-06-07 mrys: updated
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.LinkedList;
import java.util.List;

public class DataBaseManager extends SQLiteOpenHelper {

    public DataBaseManager(Context context) {
        super(context, "notes2.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("DROP TABLE NOTES;"); // added in order to have low ids
        db.execSQL(
                "CREATE TABLE NOTES(" +
                        "ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "TITLE CHAR(40)," +
                        "CONTENT CHAR(100)," +
                        "CREATED CHAR(50));" +
                        "");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public void runQuery(String sqlQuery) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(sqlQuery);
    }

    public void addNote(Note note) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues inputValues = new ContentValues();
        inputValues.put("title", note.getTitle());
        inputValues.put("content", note.getContent());
        inputValues.put("created", note.getCreated());
        db.insertOrThrow("notes", null, inputValues);
    }

    public void deleteNote(int id) {
        SQLiteDatabase db = getWritableDatabase();
        String[] arguements = {"" + id};
        db.delete("notes", "id=?", arguements);
    }


    public void updateNote(Note note) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues inputValues = new ContentValues();
        inputValues.put("title", note.getTitle());
        inputValues.put("content", note.getContent());
        inputValues.put("created", note.getCreated());
        String args[] = {String.valueOf(note.getId())};
        db.update("notes", inputValues, "id=?", args);
    }

    public void updateNoteUPDATE(Note note) {
        SQLiteDatabase db = getWritableDatabase();
        Long id = note.getId();
        String title = note.getTitle();
        String content = note.getContent();
        String created = note.getCreated();
//        db.execSQL("UPDATE TELEFONY SET IMIE = '" + imie + "' WHERE NR = " + nr);
//        db.execSQL("UPDATE TELEFONY SET NAZWISKO = '" + nazwisko + "' WHERE NR = " + nr);
//        db.execSQL("UPDATE TELEFONY SET TELEFON = '" + telefon + "' WHERE NR = " + nr);
        db.execSQL(String.format("UPDATE NOTES SET TITLE ='%s', CONTENT = '%s', CREATED = '%s' WHERE NR = %d", title, content, created, id));
    }

    public List<Note> getAll() {
        List<Note> notes = new LinkedList<>();
        String[] columns = {"id", "title", "content", "created"};
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query("notes", columns, null, null, null, null, null);
        while (cursor.moveToNext()) {
            Note note = new Note();
            note.setId(cursor.getLong(0));
            note.setTitle(cursor.getString(1));
            note.setContent(cursor.getString(2));
            note.setCreated(cursor.getString(3));
            notes.add(note);
        }
        return notes;
    }

    public Note get(int id) {
        Note note = new Note();
        SQLiteDatabase db = getReadableDatabase();
        String[] columns = {"id", "title", "content", "created"};
        String args[] = {id + ""};
        Cursor cursor = db.query("notes", columns, " id=?", args, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
            note.setId(cursor.getLong(0));
            note.setTitle(cursor.getString(1));
            note.setContent(cursor.getString(2));
            note.setCreated(cursor.getString(3));
        }
        return note;
    }

    public List<Note> getByTitle(String title) {
        List<Note> notes = new LinkedList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT ID,TITLE,CONTENT,CREATED FROM NOTES WHERE TITLE='"
                + title + "' ORDER BY TITLE ASC", null);
        //Cursor cursor =db.rawQuery
        //("select id,title,content,created from notes where title=?	order by title asc", title);
        while (cursor.moveToNext()) {
            Note note = new Note();
            note.setId(cursor.getLong(0));
            note.setTitle(cursor.getString(1));
            note.setContent(cursor.getString(2));
            note.setCreated(cursor.getString(3));
            notes.add(note);
        }
        return notes;
    }
}