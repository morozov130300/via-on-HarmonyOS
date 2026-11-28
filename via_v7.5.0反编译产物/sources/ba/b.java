package ba;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;
import org.simpleframework.xml.strategy.Name;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class b implements a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String[] f1835b = {Name.MARK, "url", "title", "folder", "clickTimes", "updated_at", "created_at"};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o9.a f1836a;

    public b(o9.a aVar) {
        this.f1836a = aVar;
    }

    public static void a(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE bookmarks(id INTEGER PRIMARY KEY,url TEXT,title TEXT,folder TEXT,clickTimes INTEGER,updated_at INTEGER DEFAULT 0,created_at INTEGER DEFAULT 0)");
    }

    public static void c(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
        if (i10 <= 2) {
            sQLiteDatabase.execSQL("CREATE TABLE bookmarks(id INTEGER PRIMARY KEY,url TEXT,title TEXT,folder TEXT,clickTimes INTEGER,updated_at INTEGER DEFAULT 0,created_at INTEGER DEFAULT 0)");
        }
        if (i10 < 8) {
            sQLiteDatabase.execSQL("ALTER TABLE bookmarks ADD COLUMN updated_at INTEGER DEFAULT 0;");
            sQLiteDatabase.execSQL("ALTER TABLE bookmarks ADD COLUMN created_at INTEGER DEFAULT 0;");
            ContentValues contentValues = new ContentValues();
            long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
            contentValues.put("updated_at", Long.valueOf(jCurrentTimeMillis));
            contentValues.put("created_at", Long.valueOf(jCurrentTimeMillis));
            sQLiteDatabase.update("bookmarks", contentValues, null, null);
        }
    }

    public final l9.b b(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        l9.b bVar = new l9.b();
        bVar.m(cursor.getInt(0));
        bVar.q(cursor.getString(1));
        bVar.o(cursor.getString(2));
        bVar.l(cursor.getString(3));
        bVar.n(cursor.getInt(4));
        bVar.p(cursor.getLong(5));
        bVar.k(cursor.getLong(6));
        return bVar;
    }

    @Override // ba.a
    public List u() {
        ArrayList arrayList = new ArrayList();
        try {
            Cursor cursorQuery = this.f1836a.a().query("bookmarks", f1835b, null, null, null, null, null);
            while (cursorQuery.moveToNext()) {
                try {
                    l9.b bVarB = b(cursorQuery);
                    if (bVarB != null) {
                        arrayList.add(bVarB);
                    }
                } catch (Throwable th) {
                    if (cursorQuery == null) {
                        throw th;
                    }
                    try {
                        cursorQuery.close();
                        throw th;
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                        throw th;
                    }
                }
            }
            cursorQuery.close();
            return arrayList;
        } catch (Exception e10) {
            e10.printStackTrace();
            return arrayList;
        }
    }
}
