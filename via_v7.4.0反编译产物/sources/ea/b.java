package ea;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;
import org.simpleframework.xml.strategy.Name;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class b implements a {

    /* renamed from: b, reason: collision with root package name */
    public static final String[] f4939b = {Name.MARK, "url", "title", "folder", "clickTimes", "updated_at", "created_at"};

    /* renamed from: a, reason: collision with root package name */
    public final q9.a f4940a;

    public b(q9.a aVar) {
        this.f4940a = aVar;
    }

    public static void a(SQLiteDatabase sQLiteDatabase) throws SQLException {
        sQLiteDatabase.execSQL("CREATE TABLE bookmarks(id INTEGER PRIMARY KEY,url TEXT,title TEXT,folder TEXT,clickTimes INTEGER,updated_at INTEGER DEFAULT 0,created_at INTEGER DEFAULT 0)");
    }

    public static void c(SQLiteDatabase sQLiteDatabase, int i10, int i11) throws SQLException {
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

    public final n9.b b(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        n9.b bVar = new n9.b();
        bVar.m(cursor.getInt(0));
        bVar.q(cursor.getString(1));
        bVar.o(cursor.getString(2));
        bVar.l(cursor.getString(3));
        bVar.n(cursor.getInt(4));
        bVar.p(cursor.getLong(5));
        bVar.k(cursor.getLong(6));
        return bVar;
    }

    @Override // ea.a
    public List u() {
        ArrayList arrayList = new ArrayList();
        try {
            Cursor cursorQuery = this.f4940a.a().query("bookmarks", f4939b, null, null, null, null, null);
            while (cursorQuery.moveToNext()) {
                try {
                    n9.b bVarB = b(cursorQuery);
                    if (bVarB != null) {
                        arrayList.add(bVarB);
                    }
                } finally {
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
