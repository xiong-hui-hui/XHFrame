package com.xiong.tuan.utils.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by hui.xiong on 2016/3/18.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "zlx";
    public static final int DATABASE_VERSION = 1;
    private Context mContext;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        // create all tables
        // TODO
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        if (newVersion > oldVersion) {
            //re-create all tables
            onCreate(sqLiteDatabase);
        }
    }
}
