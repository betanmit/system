package com.example.fourthprogram;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DbController extends SQLiteOpenHelper {
    private static final String DB_NAME = "Emp_db";
    public static final String TABLE_NAME="Employee";


    public DbController(Context context){
        super(context,DB_NAME,null,1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String cmd="create table "+TABLE_NAME+" (name text primary key, location text, profession text)";
        db.execSQL(cmd);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean insetdb(String name, String loc, String prof ){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("name",name);
        contentValues.put("location",loc);
        contentValues.put("profession",prof);
        db.insert(TABLE_NAME,null,contentValues);
        return true;
    }

    public String[] fetchdb(String nm){
        String[] ret=new String[2];
        SQLiteDatabase db=this.getReadableDatabase();
        String query="select * from "+TABLE_NAME+" where name='"+nm+"'";
        @SuppressLint("Recycle") Cursor cursor=db.rawQuery(query,null);
        if(cursor!=null){
            cursor.moveToFirst();
            ret[0]=cursor.getString(cursor.getColumnIndex("location"));
            ret[1]=cursor.getString(cursor.getColumnIndex("profession"));
        }


        return ret;
    }

    public boolean updatedb(String id,String loc,String prof){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("name",id);
        contentValues.put("location",loc);
        contentValues.put("profession",prof);
        db.update(TABLE_NAME,contentValues,"name='"+id+"'",null);
        return true;
    }
    public boolean deldb(String id){
        SQLiteDatabase db=this.getWritableDatabase();
        int count=db.delete(TABLE_NAME,"name='"+id+"'",null);
        return true;
    }}