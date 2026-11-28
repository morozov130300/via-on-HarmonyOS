package aa;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class a implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o9.a f286a;

    public a(o9.a aVar) {
        this.f286a = aVar;
    }

    public static void f(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE conf(domain TEXT NOT NULL PRIMARY KEY,data TEXT)");
    }

    public static void g(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
        if (i10 <= 6) {
            sQLiteDatabase.execSQL("CREATE TABLE conf(domain TEXT NOT NULL PRIMARY KEY,data TEXT)");
        }
    }

    @Override // aa.c
    public void a(Map map) {
        if (map.isEmpty()) {
            return;
        }
        SQLiteDatabase sQLiteDatabaseA = this.f286a.a();
        try {
            sQLiteDatabaseA.beginTransaction();
            ContentValues contentValues = new ContentValues();
            for (Map.Entry entry : map.entrySet()) {
                sQLiteDatabaseA.delete("conf", "domain = ?", new String[]{(String) entry.getKey()});
                if (entry.getValue() != null && !((y9.b) entry.getValue()).r()) {
                    contentValues.put("domain", (String) entry.getKey());
                    contentValues.put("data", y9.c.m((y9.b) entry.getValue()));
                    sQLiteDatabaseA.insert("conf", null, contentValues);
                }
            }
            sQLiteDatabaseA.setTransactionSuccessful();
        } catch (Exception e10) {
            e10.printStackTrace();
        } finally {
            sQLiteDatabaseA.endTransaction();
        }
    }

    @Override // aa.c
    public void b(String str) {
        if (str.isEmpty()) {
            return;
        }
        this.f286a.a().delete("conf", "domain = ? ", new String[]{str});
    }

    @Override // aa.c
    public boolean c(String str, String str2) {
        if (str.isEmpty() || str2.isEmpty() || str.equals(str2)) {
            return false;
        }
        SQLiteDatabase sQLiteDatabaseA = this.f286a.a();
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
            } catch (Exception e10) {
                tc.a.j(e10);
                sQLiteDatabaseA.endTransaction();
                return false;
            }
        } catch (Throwable th3) {
            sQLiteDatabaseA.endTransaction();
            throw th3;
        }
    }

    @Override // aa.c
    public Map d() {
        y9.b bVarK;
        HashMap map = new HashMap();
        try {
            Cursor cursorQuery = this.f286a.a().query("conf", new String[]{"domain", "data"}, null, null, null, null, null);
            while (cursorQuery.moveToNext()) {
                try {
                    String string = cursorQuery.getString(0);
                    String string2 = cursorQuery.getString(1);
                    if (string != null && string.length() > 0 && string2 != null && (bVarK = y9.c.k(string2)) != null) {
                        map.put(string, bVarK);
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
            return map;
        } catch (Exception e10) {
            tc.a.j(e10);
            return map;
        }
    }

    @Override // aa.c
    public void e(String str, y9.b bVar) {
        if (str.isEmpty()) {
            return;
        }
        SQLiteDatabase sQLiteDatabaseA = this.f286a.a();
        try {
            sQLiteDatabaseA.beginTransaction();
            sQLiteDatabaseA.delete("conf", "domain = ?", new String[]{str});
            ContentValues contentValues = new ContentValues();
            contentValues.put("domain", str);
            contentValues.put("data", y9.c.m(bVar));
            sQLiteDatabaseA.insert("conf", null, contentValues);
            sQLiteDatabaseA.setTransactionSuccessful();
        } catch (Exception e10) {
            e10.printStackTrace();
        } finally {
            sQLiteDatabaseA.endTransaction();
        }
    }
}
