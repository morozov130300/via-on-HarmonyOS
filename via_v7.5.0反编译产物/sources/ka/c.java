package ka;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.tuyafeng.support.utils.p;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class c implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o9.a f7253a;

    public c(o9.a aVar) {
        this.f7253a = aVar;
    }

    public static void g(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE tabs(_id TEXT PRIMARY KEY,url TEXT,title TEXT,file_path TEXT,flags INTEGER DEFAULT 0,last_visited_at INTEGER DEFAULT 0)");
    }

    public static void h(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
        if (i10 <= 10) {
            g(sQLiteDatabase);
        }
    }

    @Override // ka.i
    public boolean a(f fVar) {
        boolean z10 = false;
        if (fVar == null || p.f(fVar.c())) {
            return false;
        }
        SQLiteDatabase sQLiteDatabaseA = this.f7253a.a();
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
            z10 = sQLiteDatabaseA.insert("tabs", null, contentValues) > 0;
            sQLiteDatabaseA.setTransactionSuccessful();
            return z10;
        } catch (Exception e10) {
            tc.a.j(e10);
            return z10;
        } finally {
            sQLiteDatabaseA.endTransaction();
        }
    }

    @Override // ka.i
    public boolean b(String str) {
        return !p.f(str) && this.f7253a.a().delete("tabs", "_id = ?", new String[]{str}) > 0;
    }

    @Override // ka.i
    public List c(String str, int i10) {
        ArrayList arrayList = new ArrayList();
        if (str != null) {
            String strTrim = str.trim();
            if (!strTrim.isEmpty()) {
                String str2 = "%_" + strTrim + "%";
                try {
                    Cursor cursorQuery = this.f7253a.a().query("tabs", new String[]{"_id", "url", "title", "file_path", "flags", "last_visited_at"}, "url like ? or title like ? or title like ?", new String[]{str2, str2, strTrim + "%"}, null, null, "last_visited_at desc", i10 <= 0 ? null : String.valueOf(i10));
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
                }
            }
        }
        return arrayList;
    }

    @Override // ka.i
    public boolean d(List list) {
        int i10;
        if (list == null || list.isEmpty()) {
            return true;
        }
        SQLiteDatabase sQLiteDatabaseA = this.f7253a.a();
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
                        tc.a.e(e);
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
        return i10 > 0;
    }

    @Override // ka.i
    public List e() {
        ArrayList arrayList = new ArrayList();
        try {
            Cursor cursorQuery = this.f7253a.a().query("tabs", new String[]{"_id", "url", "title", "file_path", "flags", "last_visited_at"}, null, null, null, null, null);
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
            tc.a.j(e10);
            return arrayList;
        }
    }

    /* JADX WARN: Code duplicated, block: B:29:0x0044 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Code duplicated, block: B:42:? A[RETURN, SYNTHETIC] */
    @Override // ka.i
    public boolean f(String[] strArr) {
        int i10;
        if (strArr == null || strArr.length == 0) {
            return false;
        }
        SQLiteDatabase sQLiteDatabaseA = this.f7253a.a();
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
                        tc.a.e(e);
                        sQLiteDatabaseA.endTransaction();
                        if (i10 > 0) {
                            return true;
                        }
                        return false;
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
        if (i10 > 0) {
            return true;
        }
        return false;
    }
}
