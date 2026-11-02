package da;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import java.util.HashMap;
import java.util.Map;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class a implements c {

    /* renamed from: a, reason: collision with root package name */
    public final q9.a f4650a;

    public a(q9.a aVar) {
        this.f4650a = aVar;
    }

    public static void f(SQLiteDatabase sQLiteDatabase) throws SQLException {
        sQLiteDatabase.execSQL("CREATE TABLE conf(domain TEXT NOT NULL PRIMARY KEY,data TEXT)");
    }

    public static void g(SQLiteDatabase sQLiteDatabase, int i10, int i11) throws SQLException {
        if (i10 <= 6) {
            sQLiteDatabase.execSQL("CREATE TABLE conf(domain TEXT NOT NULL PRIMARY KEY,data TEXT)");
        }
    }

    @Override // da.c
    public void a(Map map) {
        if (map.isEmpty()) {
            return;
        }
        SQLiteDatabase sQLiteDatabaseA = this.f4650a.a();
        try {
            try {
                sQLiteDatabaseA.beginTransaction();
                ContentValues contentValues = new ContentValues();
                for (Map.Entry entry : map.entrySet()) {
                    sQLiteDatabaseA.delete("conf", "domain = ?", new String[]{(String) entry.getKey()});
                    if (entry.getValue() != null && !((ba.b) entry.getValue()).r()) {
                        contentValues.put("domain", (String) entry.getKey());
                        contentValues.put("data", ba.c.m((ba.b) entry.getValue()));
                        sQLiteDatabaseA.insert("conf", null, contentValues);
                    }
                }
                sQLiteDatabaseA.setTransactionSuccessful();
                sQLiteDatabaseA.endTransaction();
            } catch (Exception e10) {
                e10.printStackTrace();
                sQLiteDatabaseA.endTransaction();
            }
        } catch (Throwable th) {
            sQLiteDatabaseA.endTransaction();
            throw th;
        }
    }

    @Override // da.c
    public void b(String str) {
        if (str.isEmpty()) {
            return;
        }
        this.f4650a.a().delete("conf", "domain = ? ", new String[]{str});
    }

    @Override // da.c
    public boolean c(String str, String str2) {
        if (str.isEmpty() || str2.isEmpty() || str.equals(str2)) {
            return false;
        }
        SQLiteDatabase sQLiteDatabaseA = this.f4650a.a();
        try {
            try {
                sQLiteDatabaseA.beginTransaction();
                Cursor cursorQuery = sQLiteDatabaseA.query("conf", new String[]{"domain"}, "domain = ?", new String[]{str2}, null, null, null);
                try {
                    if (cursorQuery.moveToFirst()) {
                        cursorQuery.close();
                        sQLiteDatabaseA.endTransaction();
                        return false;
                    }
                    cursorQuery.close();
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("domain", str2);
                    boolean z10 = sQLiteDatabaseA.update("conf", contentValues, "domain = ?", new String[]{str}) == 1;
                    sQLiteDatabaseA.setTransactionSuccessful();
                    sQLiteDatabaseA.endTransaction();
                    return z10;
                } finally {
                }
            } catch (Exception e10) {
                pc.a.i(e10);
                sQLiteDatabaseA.endTransaction();
                return false;
            }
        } catch (Throwable th) {
            sQLiteDatabaseA.endTransaction();
            throw th;
        }
    }

    @Override // da.c
    public Map d() {
        ba.b bVarK;
        HashMap map = new HashMap();
        try {
            Cursor cursorQuery = this.f4650a.a().query("conf", new String[]{"domain", "data"}, null, null, null, null, null);
            while (cursorQuery.moveToNext()) {
                try {
                    String string = cursorQuery.getString(0);
                    String string2 = cursorQuery.getString(1);
                    if (string != null && string.length() > 0 && string2 != null && (bVarK = ba.c.k(string2)) != null) {
                        map.put(string, bVarK);
                    }
                } finally {
                }
            }
            cursorQuery.close();
            return map;
        } catch (Exception e10) {
            pc.a.i(e10);
            return map;
        }
    }

    @Override // da.c
    public void e(String str, ba.b bVar) {
        if (str.isEmpty()) {
            return;
        }
        SQLiteDatabase sQLiteDatabaseA = this.f4650a.a();
        try {
            sQLiteDatabaseA.beginTransaction();
            sQLiteDatabaseA.delete("conf", "domain = ?", new String[]{str});
            ContentValues contentValues = new ContentValues();
            contentValues.put("domain", str);
            contentValues.put("data", ba.c.m(bVar));
            sQLiteDatabaseA.insert("conf", null, contentValues);
            sQLiteDatabaseA.setTransactionSuccessful();
        } catch (Exception e10) {
            e10.printStackTrace();
        } finally {
            sQLiteDatabaseA.endTransaction();
        }
    }
}
