package com.example.QuranApp;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class DBHelper extends SQLiteOpenHelper {
    private SQLiteDatabase db;

    private final Context context;
    public DBHelper(Context context) {
        super(context,  params.DB_NAME , null, params.DB_VERSION);
        this. context  = context;
    }

    public void createDB() throws IOException {

        this.getReadableDatabase();
        Log.i("Readable DB Ends","end");

        try {
            copyDB();
            Log.i("copy db ends","end");

        } catch (IOException e) {

            throw new Error("Error copying database");
        }
    }

    public  boolean checkDB(){

        SQLiteDatabase checkDB = null;

        try{
            String path = params.DB_PATH + params.DB_NAME;
            Log.i("myPath",path);
            checkDB = SQLiteDatabase.openDatabase(path, null, SQLiteDatabase.OPEN_READONLY);

            Log.i("myPath ",path);
            if (checkDB!=null)
            {
                Cursor c= checkDB.rawQuery("SELECT * FROM tayah", null);

                if (c.moveToFirst()) {
                    do {

                        Log.i("Tayah ......",String.valueOf(c.getInt(0)));

                    } while (c.moveToNext());

                }
            }
            else
            {
                return false;
            }

        }catch(SQLiteException e){
            e.printStackTrace();
        }

        if(checkDB != null){

            checkDB.close();

        }
        return checkDB != null ? true : false;
    }

    public void copyDB() throws IOException{
        try {
            Log.i("inside copyDB..","start");

            InputStream ip =  context.getAssets().open(params.DB_NAME);
            //InputStream ip =  context.getAssets().open(DB_NAME+".db");
            Log.i("Input Stream....",ip+"");
            String op=  params.DB_PATH  +  params.DB_NAME ;
            OutputStream output = new FileOutputStream( op);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = ip.read(buffer))>0){
                output.write(buffer, 0, length);
                Log.i("Content.... ",length+"");
            }
            output.flush();
            output.close();
            ip.close();
        }
        catch (IOException e) {
            Log.v("error", e.toString());
        }
    }

    public void openDB() throws SQLException {


        String myPath = params.DB_PATH + params.DB_NAME;
        db = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READWRITE);
        Log.i("open DB......",db.toString());
    }

    @Override
    public synchronized void close() {

        if(db != null)
            db.close();

        super.close();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public ArrayList<GenericListItem> displaySurahName(){
        SQLiteDatabase db=null;
        String path = params.DB_PATH + params.DB_NAME;
        Log.i("myPath",path);
        db = SQLiteDatabase.openDatabase(path, null, SQLiteDatabase.OPEN_READONLY);

        ArrayList<GenericListItem> genericListItems = new ArrayList<>();
        if (db!=null) {
            String query = "SELECT SurahNameE,SurahNameU FROM " + params.SURAH_TABLE;
            Cursor cursor = db.rawQuery(query, null);

            if (cursor.moveToFirst()) {
                    do {
                        GenericListItem item=new GenericListItem();

                        if(cursor.getString(0) != null) {
                            item.setFirstEntity(cursor.getString(0));
                            item.setSecendEntity(cursor.getString(1));

                            Log.i("SurahName", cursor.getString(0));


                            genericListItems.add(item);
                        }
                    } while (cursor.moveToNext());
            }
        }
        return genericListItems;
    }


    public ArrayList<GenericListItem> surahFilter(String surahNameCon ){
        SQLiteDatabase db=null;
        String path = params.DB_PATH + params.DB_NAME;
        ArrayList<GenericListItem> genericListItems = new ArrayList<>();
        Log.i("myPath",path);
        db = SQLiteDatabase.openDatabase(path, null, SQLiteDatabase.OPEN_READONLY);
        ArrayList<String> surahNameList = new ArrayList<>();
        if (db!=null) {
            String query = "SELECT SurahNameE,SurahNameU FROM " + params.SURAH_TABLE;
            Cursor cursor = db.rawQuery(query, null);

            if (cursor.moveToFirst()) {
                do {
                    GenericListItem item=new GenericListItem();
                    String name1,name2;

                    if(cursor.getString(0) != null) {
                        name1=surahNameCon.toLowerCase(Locale.ROOT);
                        name2=cursor.getString(0).toLowerCase(Locale.ROOT);
                        if(name2.contains(name1))
                        {
                            item.setFirstEntity(cursor.getString(0));
                            item.setSecendEntity(cursor.getString(1));

                            Log.i("SurahName", cursor.getString(0));

                            genericListItems.add(item);
                        }

                    }
                } while (cursor.moveToNext());
            }
        }
        return genericListItems;
    }


    public ArrayList<GenericListItem> displayAyah(int surahNumber)
    {
        SQLiteDatabase db=this.getReadableDatabase();
        String query="SELECT * FROM "+params.AYAH_TABLE+" where SuraID="+surahNumber;
        Cursor cursor=db.rawQuery(query,null);
        //ArrayList<String> ayahList=new ArrayList<>();
        //9
        ArrayList<GenericListItem> genericListItems=new ArrayList<>();
        if(cursor.moveToFirst())
        {
            do {
                String ayah="";
                GenericListItem item=new GenericListItem();
                if(cursor.getString(3) != null){

                        item.setFirstEntity(cursor.getString(3));
                        item.setSecendEntity(cursor.getString(4));
                        Log.i("Ayah:",ayah);
                        genericListItems.add(item);
                    }
                
            } while (cursor.moveToNext());
        }
        return genericListItems;
    }


    public int getSurahNumber(String surahName)
    {
        SQLiteDatabase db=this.getReadableDatabase();
        String sf1=String.format("'%s'",surahName);
        String query="SELECT SurahID,SurahNameU FROM "+params.SURAH_TABLE+" where SurahNameU="+sf1;
        Cursor cursor=db.rawQuery(query,null);
        int surahNum=0;
        if(cursor.moveToFirst())
        {
            do {
                if(cursor.getString(1) != null) {

                    surahNum= cursor.getInt(0);

                }
            } while (cursor.moveToNext());
        }
        return surahNum;
    }

}
