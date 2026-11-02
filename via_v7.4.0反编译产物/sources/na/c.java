package na;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import g6.p;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class c implements i {

    /* renamed from: a, reason: collision with root package name */
    public final q9.a f10282a;

    public c(q9.a aVar) {
        this.f10282a = aVar;
    }

    public static void g(SQLiteDatabase sQLiteDatabase) throws SQLException {
        sQLiteDatabase.execSQL("CREATE TABLE tabs(_id TEXT PRIMARY KEY,url TEXT,title TEXT,file_path TEXT,flags INTEGER DEFAULT 0,last_visited_at INTEGER DEFAULT 0)");
    }

    public static void h(SQLiteDatabase sQLiteDatabase, int i10, int i11) throws SQLException {
        if (i10 <= 10) {
            g(sQLiteDatabase);
        }
    }

    @Override // na.i
    public boolean a(String str) {
        return !p.f(str) && this.f10282a.a().delete("tabs", "_id = ?", new String[]{str}) > 0;
    }

    @Override // na.i
    public List b(String str, int i10) {
        ArrayList arrayList = new ArrayList();
        if (str != null) {
            String strTrim = str.trim();
            if (!strTrim.isEmpty()) {
                String str2 = "%_" + strTrim + "%";
                try {
                    Cursor cursorQuery = this.f10282a.a().query("tabs", new String[]{"_id", "url", "title", "file_path", "flags", "last_visited_at"}, "url like ? or title like ? or title like ?", new String[]{str2, str2, strTrim + "%"}, null, null, "last_visited_at desc", i10 <= 0 ? null : String.valueOf(i10));
                    while (cursorQuery.moveToNext()) {
                        try {
                            f fVar = new f();
                            fVar.i(cursorQuery.getString(0));
                            fVar.l(cursorQuery.getString(1));
                            fVar.k(cursorQuery.getString(2));
                            fVar.g(p.k(cursorQuery.getString(3)));
                            fVar.h(cursorQuery.getInt(4));
                            fVar.j(cursorQuery.getLong(5));
                            arrayList.add(fVar);
                        } finally {
                        }
                    }
                    cursorQuery.close();
                    return arrayList;
                } catch (Exception e10) {
                    e10.printStackTrace();
                }
            }
        }
        return arrayList;
    }

    @Override // na.i
    public boolean c(f fVar) {
        if (fVar == null || p.f(fVar.c())) {
            return false;
        }
        SQLiteDatabase sQLiteDatabaseA = this.f10282a.a();
        try {
            sQLiteDatabaseA.beginTransaction();
            sQLiteDatabaseA.delete("tabs", "_id = ?", new String[]{fVar.c()});
            ContentValues contentValues = new ContentValues();
            contentValues.put("_id", fVar.c());
            contentValues.put("url", fVar.f());
            contentValues.put("title", fVar.e());
            contentValues.put("file_path", fVar.a());
            contentValues.put("flags", Integer.valueOf(fVar.b()));
            contentValues.put("last_visited_at", Long.valueOf(fVar.d()));
            z = sQLiteDatabaseA.insert("tabs", null, contentValues) > 0;
            sQLiteDatabaseA.setTransactionSuccessful();
            return z;
        } catch (Exception e10) {
            pc.a.i(e10);
            return z;
        } finally {
            sQLiteDatabaseA.endTransaction();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x009e A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:44:? A[RETURN, SYNTHETIC] */
    @Override // na.i
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean d(List list) {
        int i10;
        if (list == null || list.isEmpty()) {
            return true;
        }
        SQLiteDatabase sQLiteDatabaseA = this.f10282a.a();
        try {
            try {
                sQLiteDatabaseA.beginTransaction();
                Iterator it = list.iterator();
                i10 = 0;
                while (it.hasNext()) {
                    try {
                        f fVar = (f) it.next();
                        if (!p.f(fVar.c())) {
                            sQLiteDatabaseA.delete("tabs", "_id = ?", new String[]{fVar.c()});
                            ContentValues contentValues = new ContentValues();
                            contentValues.put("_id", fVar.c());
                            contentValues.put("url", fVar.f());
                            contentValues.put("title", fVar.e());
                            contentValues.put("file_path", fVar.a());
                            contentValues.put("flags", Integer.valueOf(fVar.b()));
                            contentValues.put("last_visited_at", Long.valueOf(fVar.d()));
                            sQLiteDatabaseA.insert("tabs", null, contentValues);
                            i10++;
                        }
                    } catch (Exception e10) {
                        e = e10;
                        pc.a.d(e);
                        sQLiteDatabaseA.endTransaction();
                        if (i10 <= 0) {
                        }
                    }
                }
                sQLiteDatabaseA.setTransactionSuccessful();
            } catch (Throwable th) {
                sQLiteDatabaseA.endTransaction();
                throw th;
            }
        } catch (Exception e11) {
            e = e11;
            i10 = 0;
        }
        sQLiteDatabaseA.endTransaction();
        return i10 <= 0;
    }

    @Override // na.i
    public List e() {
        ArrayList arrayList = new ArrayList();
        try {
            Cursor cursorQuery = this.f10282a.a().query("tabs", new String[]{"_id", "url", "title", "file_path", "flags", "last_visited_at"}, null, null, null, null, null);
            while (cursorQuery.moveToNext()) {
                try {
                    f fVar = new f();
                    fVar.i(cursorQuery.getString(0));
                    fVar.l(cursorQuery.getString(1));
                    fVar.k(cursorQuery.getString(2));
                    fVar.g(p.k(cursorQuery.getString(3)));
                    fVar.h(cursorQuery.getInt(4));
                    fVar.j(cursorQuery.getLong(5));
                    arrayList.add(fVar);
                } finally {
                }
            }
            cursorQuery.close();
            return arrayList;
        } catch (Exception e10) {
            pc.a.i(e10);
            return arrayList;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0044 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:42:? A[RETURN, SYNTHETIC] */
    @Override // na.i
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean f(String[] strArr) {
        int i10;
        if (strArr == null || strArr.length == 0) {
            return false;
        }
        SQLiteDatabase sQLiteDatabaseA = this.f10282a.a();
        try {
            try {
                sQLiteDatabaseA.beginTransaction();
                i10 = 0;
                for (String str : strArr) {
                    try {
                        if (!p.f(str) && sQLiteDatabaseA.delete("tabs", "_id = ?", new String[]{str}) > 0) {
                            i10++;
                        }
                    } catch (Exception e10) {
                        e = e10;
                        pc.a.d(e);
                        sQLiteDatabaseA.endTransaction();
                        if (i10 <= 0) {
                        }
                    }
                }
                sQLiteDatabaseA.setTransactionSuccessful();
            } catch (Throwable th) {
                sQLiteDatabaseA.endTransaction();
                throw th;
            }
        } catch (Exception e11) {
            e = e11;
            i10 = 0;
        }
        sQLiteDatabaseA.endTransaction();
        return i10 <= 0;
    }
}
