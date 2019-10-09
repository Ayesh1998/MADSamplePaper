package com.example.madsamplepaper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

   public static final  String databaseName = "mad.db";
    public static final String tableUser = "Users";
    public static final String tableMasseges= "Masseges";

    public static final String colUser1 = "idUser";
    public static final String colUser2 = "name";
    public static final String colUser3 = "password";
    public static final String colUser4 = "type";

    public static final String colMassege1 = "idMassege";
    public static final String colMassege2 = "user";
    public static final String colMassege3 = "subject";
    public static final String colMassege4 = "massege";

    public DatabaseHelper(@Nullable Context context) {
        super(context,databaseName,null,1);
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table " + tableUser + " ( idUser INTEGER PRIMARY KEY AUTOINCREMENT, name Text, password Text, type Text )" );
        db.execSQL("create table " + tableMasseges + " ( idMassege INTEGER PRIMARY KEY AUTOINCREMENT, user Text, subject Text, massege Text )" );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public Boolean insertUser(String name,String pass,String type){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(colUser2,name);
        cv.put(colUser3,pass);
        cv.put(colUser4,type);

        Long a = db.insert(tableUser,null,cv);

        if (a==-1){
            return false;
        }else{
            return true;
        }

    }

    public Boolean insertMassge(String user,String subject,String mg){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(colMassege2,user);
        cv.put(colMassege3,subject);
        cv.put(colMassege4,mg);

        Long a = db.insert(tableMasseges,null,cv);

        if (a==-1){
            return false;
        }else{
            return true;
        }

    }


    public List readMaseges(){
        SQLiteDatabase db = getReadableDatabase();

        String [] projection = {colMassege1,colMassege2,colMassege3,colMassege4};
        Cursor cr = db.query(tableMasseges,projection,null,null,null,null,null);

        List mges = new ArrayList<>();
        while (cr.moveToNext()) {
            String mg = cr.getString(cr.getColumnIndexOrThrow(colMassege4));
            mges.add(mg);
        }

        cr.close();
        return mges;
    }

    public List readMasegesSub(){
        SQLiteDatabase db = getReadableDatabase();

        String [] projection = {colMassege1,colMassege2,colMassege3,colMassege4};
        Cursor cr = db.query(tableMasseges,projection,null,null,null,null,null);

        List mges = new ArrayList<>();
        while (cr.moveToNext()) {
            String mg = cr.getString(cr.getColumnIndexOrThrow(colMassege3));
            mges.add(mg);
        }

        cr.close();
        return mges;
    }




}
