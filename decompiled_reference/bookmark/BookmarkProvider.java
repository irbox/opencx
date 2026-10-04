package com.alphainventor.filemanager.bookmark;

import ax.Ha.b;
import android.database.sqlite.SQLiteDatabase$CursorFactory;
import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;
import android.database.sqlite.SQLiteQueryBuilder;
import android.content.ContentUris;
import android.content.ContentValues;
import ax.Ha.c;
import android.database.ContentObserver;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteDatabase;
import android.content.UriMatcher;
import android.net.Uri;
import android.provider.BaseColumns;
import android.content.ContentProvider;

public class BookmarkProvider extends ContentProvider implements BaseColumns
{
    public static final Uri b;
    public static final String[] c;
    private static final String d;
    private static final UriMatcher e;
    private a a;
    
    static {
        b = Uri.parse("content://com.cxinventor.file.explorer.bookmark");
        c = new String[] { "_id", "type", "display_name", "location_name", "location_key", "path", "file_id", "is_directory", "timestamp" };
        d = String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT, %s INTEGER NOT NULL, %s TEXT, %s TEXT NOT NULL, %s INTEGER NOT NULL, %s TEXT, %s TEXT, %s INTEGER NOT NULL DEFAULT 0, %s INTEGER NOT NULL)", new Object[] { "bookmarks", "_id", "type", "display_name", "location_name", "location_key", "path", "file_id", "is_directory", "timestamp" });
        final UriMatcher e2 = new UriMatcher(-1);
        (e = e2).addURI("com.cxinventor.file.explorer.bookmark", "", 1000);
        e2.addURI("com.cxinventor.file.explorer.bookmark", "/#", 2000);
    }
    
    private SQLiteDatabase b() {
        return this.a.getWritableDatabase();
    }
    
    public int delete(final Uri uri, final String s, final String[] array) {
        while (true) {
            final SQLiteDatabase b = this.b();
            final int n = 0;
            int n3;
            final int n2 = n3 = 0;
            int n4 = n;
            Label_0338: {
                int n5 = 0;
            Label_0315:
                while (true) {
                    try {
                        if (BookmarkProvider.e.match(uri) != 2000) {
                            n3 = n2;
                            n4 = n;
                            n4 = b.delete("bookmarks", s, array);
                            n5 = n4;
                            break Label_0315;
                        }
                    }
                    catch (final SecurityException ex) {
                        n4 = n3;
                        break Label_0338;
                    }
                    catch (final SQLiteException ex) {
                        break Label_0338;
                    }
                    final String lastPathSegment = uri.getLastPathSegment();
                    if (s == null) {
                        final StringBuilder sb = new StringBuilder();
                        sb.append("_id=");
                        sb.append(lastPathSegment);
                        n3 = n2;
                        n4 = b.delete("bookmarks", sb.toString(), (String[])null);
                        continue;
                    }
                    final StringBuilder sb2 = new StringBuilder();
                    sb2.append("_id=");
                    sb2.append(lastPathSegment);
                    sb2.append(" and (");
                    sb2.append(s);
                    sb2.append(")");
                    n3 = n2;
                    n4 = b.delete("bookmarks", sb2.toString(), array);
                    continue;
                }
                this.getContext().getContentResolver().notifyChange(uri, (ContentObserver)null);
                return n5;
            }
            final SecurityException ex;
            ((Throwable)ex).printStackTrace();
            ax.Ha.c.h().d("BP").l((Throwable)ex).h();
            return n4;
        }
    }
    
    public String getType(final Uri uri) {
        final int match = BookmarkProvider.e.match(uri);
        if (match == 1000) {
            return "vnd.android.cursor.dir/bookmarks";
        }
        if (match == 2000) {
            return "vnd.android.cursor.item/bookmark";
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Unknown URI: ");
        sb.append((Object)uri);
        throw new IllegalArgumentException(sb.toString());
    }
    
    public Uri insert(final Uri uri, final ContentValues contentValues) {
        final SQLiteDatabase b = this.b();
        final long insert = b.insert("bookmarks", "", contentValues);
        if (insert > 0L) {
            final Uri withAppendedId = ContentUris.withAppendedId(BookmarkProvider.b, insert);
            final SQLiteQueryBuilder sqLiteQueryBuilder = new SQLiteQueryBuilder();
            sqLiteQueryBuilder.setTables("bookmarks");
            if (contentValues.getAsInteger("type") != 2) {
                if (contentValues.getAsInteger("type") == 3) {
                    final Cursor query = sqLiteQueryBuilder.query(b, new String[] { "_id" }, "type = 3", (String[])null, (String)null, (String)null, "timestamp asc");
                    if (query != null && query.getCount() > 200 && query.moveToFirst()) {
                        b.delete("bookmarks", "_id=?", new String[] { Integer.toString(query.getInt(0)) });
                    }
                    query.close();
                }
            }
            this.getContext().getContentResolver().notifyChange(withAppendedId, (ContentObserver)null);
            return withAppendedId;
        }
        return null;
    }
    
    public boolean onCreate() {
        this.a = new a(this.getContext());
        return true;
    }
    
    public Cursor query(final Uri uri, String[] query, final String s, final String[] array, final String s2) {
        final SQLiteDatabase b = this.b();
        final SQLiteQueryBuilder sqLiteQueryBuilder = new SQLiteQueryBuilder();
        sqLiteQueryBuilder.setTables("bookmarks");
        if (BookmarkProvider.e.match(uri) == 2000) {
            final StringBuilder sb = new StringBuilder();
            sb.append("_id=");
            sb.append(uri.getLastPathSegment());
            sqLiteQueryBuilder.appendWhere((CharSequence)sb.toString());
        }
        query = (String[])(Object)sqLiteQueryBuilder.query(b, query, s, array, (String)null, (String)null, s2);
        try {
            ((Cursor)(Object)query).setNotificationUri(this.getContext().getContentResolver(), uri);
            return (Cursor)(Object)query;
        }
        catch (final SecurityException ex) {
            return (Cursor)(Object)query;
        }
    }
    
    public int update(final Uri uri, final ContentValues contentValues, final String s, final String[] array) {
        final SQLiteDatabase b = this.b();
        int n;
        if (BookmarkProvider.e.match(uri) != 2000) {
            n = b.update("bookmarks", contentValues, s, array);
        }
        else {
            final String lastPathSegment = uri.getLastPathSegment();
            if (s == null) {
                final StringBuilder sb = new StringBuilder();
                sb.append("_id=");
                sb.append(lastPathSegment);
                n = b.update("bookmarks", contentValues, sb.toString(), (String[])null);
            }
            else {
                final StringBuilder sb2 = new StringBuilder();
                sb2.append("_id=");
                sb2.append(lastPathSegment);
                sb2.append(" and (");
                sb2.append(s);
                sb2.append(")");
                n = b.update("bookmarks", contentValues, sb2.toString(), array);
            }
        }
        this.getContext().getContentResolver().notifyChange(uri, (ContentObserver)null);
        return n;
    }
    
    private static class a extends SQLiteOpenHelper
    {
        public a(final Context context) {
            super(context, "com.alphainventor.filemanager", (SQLiteDatabase$CursorFactory)null, 3);
        }
        
        public void onCreate(final SQLiteDatabase sqLiteDatabase) {
            sqLiteDatabase.execSQL(BookmarkProvider.d);
        }
        
        public void onDowngrade(final SQLiteDatabase sqLiteDatabase, final int n, final int n2) {
            sqLiteDatabase.execSQL("DROP TABLE bookmarks");
            sqLiteDatabase.execSQL(BookmarkProvider.d);
            final b d = ax.Ha.c.h().d("BookmarkProvider.onDowngrade");
            final StringBuilder sb = new StringBuilder();
            sb.append("old:");
            sb.append(n);
            sb.append(" new:");
            sb.append(n2);
            d.g((Object)sb.toString()).h();
        }
        
        public void onUpgrade(final SQLiteDatabase sqLiteDatabase, final int n, final int n2) {
            if (n < 3) {
                sqLiteDatabase.execSQL("DROP TABLE bookmarks");
                sqLiteDatabase.execSQL(BookmarkProvider.d);
            }
        }
    }
}
