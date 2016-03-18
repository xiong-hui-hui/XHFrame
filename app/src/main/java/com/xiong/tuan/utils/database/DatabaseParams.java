package com.xiong.tuan.utils.database;

import android.content.ContentValues;

/**
 * Created by hui.xiong on 2016/3/18.
 */
public class DatabaseParams {
    public static class Insert {

        public String table;
        public String nullColumnHack;
        public ContentValues values;
    }

    public static class Delete {

        public String table;
        public String whereClause;
        public String[] whereArgs;
    }

    public static class Select {

        public boolean distinct;
        public String table;
        public String[] columns;
        public String selection;
        public String[] selectionArgs;
        public String groupBy;
        public String having;
        public String orderBy;
        public String limit;
    }

    public static class Update {

        public String table;
        public ContentValues values;
        public String whereClause;
        public String[] whereArgs;
    }
}
