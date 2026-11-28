package m9;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.tuyafeng.support.utils.p;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import x8.g0;
import x8.n;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class g implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o9.a f7975a;

    public g(o9.a aVar) {
        this.f7975a = aVar;
    }

    public static void C(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE bookmark_items(_id TEXT PRIMARY KEY,url TEXT,title TEXT,folder_id TEXT,ordering INTEGER,last_updated_at INTEGER DEFAULT 0,created_at INTEGER DEFAULT 0)");
        sQLiteDatabase.execSQL("CREATE TABLE bookmark_folders(_id TEXT PRIMARY KEY,title TEXT,parent_folder_id TEXT,ordering INTEGER,created_at INTEGER DEFAULT 0,last_updated_at INTEGER DEFAULT 0)");
    }

    public static void E(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
        if (i10 <= 9) {
            C(sQLiteDatabase);
        }
    }

    @Override // m9.d
    public List A(String str, String[] strArr, int i10) {
        String str2;
        String[] strArr2;
        x.d dVarD = g0.d(str, "title", "url");
        if (dVarD == null) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList = new ArrayList();
        if (strArr == null || strArr.length <= 0) {
            str2 = (String) dVarD.f14455a;
            strArr2 = (String[]) dVarD.f14456b;
        } else {
            str2 = "folder_id in " + g0.e(strArr.length) + " and (" + ((String) dVarD.f14455a) + ")";
            strArr2 = (String[]) com.tuyafeng.support.utils.a.a(strArr, (String[]) dVarD.f14456b);
        }
        try {
            Cursor cursorQuery = this.f7975a.a().query("bookmark_items", new String[]{"_id", "url", "title", "folder_id", "ordering", "last_updated_at", "created_at"}, str2, strArr2, null, null, null, i10 <= 0 ? null : String.valueOf(i10));
            try {
                D(cursorQuery);
                while (cursorQuery.moveToNext()) {
                    b bVar = new b();
                    bVar.j(cursorQuery.getString(0));
                    bVar.n(cursorQuery.getString(1));
                    bVar.l(cursorQuery.getString(2));
                    bVar.i(p.k(cursorQuery.getString(3)));
                    bVar.k(cursorQuery.getInt(4));
                    bVar.m(cursorQuery.getLong(5));
                    bVar.h(cursorQuery.getLong(6));
                    arrayList.add(bVar);
                }
                cursorQuery.close();
                return arrayList;
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
            return arrayList;
        }
    }

    @Override // m9.d
    public boolean B(String... strArr) {
        if (strArr == null || strArr.length == 0) {
            return false;
        }
        SQLiteDatabase sQLiteDatabaseA = this.f7975a.a();
        try {
            sQLiteDatabaseA.beginTransaction();
            for (String str : strArr) {
                sQLiteDatabaseA.delete("bookmark_items", "folder_id = ?", new String[]{str});
            }
            sQLiteDatabaseA.setTransactionSuccessful();
            return true;
        } catch (Exception e10) {
            tc.a.j(e10);
            return false;
        } finally {
            sQLiteDatabaseA.endTransaction();
        }
    }

    public final void D(Cursor cursor) {
        g0.a(cursor, 4194304);
    }

    @Override // m9.d
    public b a(String str) {
        if (n.d(str)) {
            return null;
        }
        String[] strArrF = g0.f(str);
        try {
            Cursor cursorQuery = this.f7975a.a().query("bookmark_items", new String[]{"_id", "url", "title", "folder_id", "ordering", "last_updated_at", "created_at"}, "url in " + g0.e(strArrF.length), strArrF, null, null, "ordering", "1");
            try {
                D(cursorQuery);
                if (!cursorQuery.moveToNext()) {
                    cursorQuery.close();
                    return null;
                }
                b bVar = new b();
                bVar.j(cursorQuery.getString(0));
                bVar.n(cursorQuery.getString(1));
                bVar.l(cursorQuery.getString(2));
                bVar.i(p.k(cursorQuery.getString(3)));
                bVar.k(cursorQuery.getInt(4));
                bVar.m(cursorQuery.getLong(5));
                bVar.h(cursorQuery.getLong(6));
                cursorQuery.close();
                return bVar;
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
            return null;
        }
        tc.a.j(e10);
        return null;
    }

    @Override // m9.d
    public boolean b(String... strArr) {
        if (strArr == null || strArr.length == 0) {
            return false;
        }
        SQLiteDatabase sQLiteDatabaseA = this.f7975a.a();
        try {
            sQLiteDatabaseA.beginTransaction();
            for (String str : strArr) {
                sQLiteDatabaseA.delete("bookmark_items", "_id = ?", new String[]{str});
            }
            sQLiteDatabaseA.setTransactionSuccessful();
            return true;
        } catch (Exception e10) {
            tc.a.j(e10);
            return false;
        } finally {
            sQLiteDatabaseA.endTransaction();
        }
    }

    @Override // m9.d
    public boolean c(String str) {
        return !n.d(str) && this.f7975a.a().delete("bookmark_items", "url = ?", new String[]{str}) > 0;
    }

    @Override // m9.d
    public boolean d(List list) {
        int i10;
        if (list == null || list.isEmpty()) {
            return false;
        }
        SQLiteDatabase sQLiteDatabaseA = this.f7975a.a();
        try {
            try {
                sQLiteDatabaseA.beginTransaction();
                Iterator it = list.iterator();
                i10 = 0;
                while (it.hasNext()) {
                    try {
                        b bVar = (b) it.next();
                        if (bVar != null && !p.f(bVar.c()) && !n.d(bVar.g())) {
                            ContentValues contentValues = new ContentValues();
                            contentValues.put("url", bVar.g());
                            contentValues.put("title", bVar.e());
                            contentValues.put("folder_id", bVar.b());
                            contentValues.put("ordering", Integer.valueOf(bVar.d()));
                            contentValues.put("last_updated_at", Long.valueOf(bVar.f()));
                            contentValues.put("created_at", Long.valueOf(bVar.a()));
                            sQLiteDatabaseA.update("bookmark_items", contentValues, "_id = ?", new String[]{bVar.c()});
                            i10++;
                        }
                    } catch (Exception e10) {
                        e = e10;
                        tc.a.j(e);
                    }
                }
                sQLiteDatabaseA.setTransactionSuccessful();
            } catch (Exception e11) {
                e = e11;
                i10 = 0;
            }
            sQLiteDatabaseA.endTransaction();
            return i10 == list.size();
        } catch (Throwable th) {
            sQLiteDatabaseA.endTransaction();
            throw th;
        }
    }

    @Override // m9.d
    public a e(String str) {
        if (p.f(str)) {
            return null;
        }
        try {
            Cursor cursorQuery = this.f7975a.a().query("bookmark_folders", new String[]{"title", "parent_folder_id", "ordering", "last_updated_at", "created_at"}, "_id = ?", new String[]{str}, null, null, "ordering", "1");
            try {
                if (!cursorQuery.moveToNext()) {
                    cursorQuery.close();
                    return null;
                }
                a aVar = new a();
                aVar.m(str);
                aVar.p(cursorQuery.getString(0));
                aVar.o(p.k(cursorQuery.getString(1)));
                aVar.n(cursorQuery.getInt(2));
                aVar.q(cursorQuery.getLong(3));
                aVar.l(cursorQuery.getLong(4));
                cursorQuery.close();
                return aVar;
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
            return null;
        }
        tc.a.j(e10);
        return null;
    }

    @Override // m9.d
    public boolean f(List list) {
        int i10;
        if (list == null || list.isEmpty()) {
            return false;
        }
        SQLiteDatabase sQLiteDatabaseA = this.f7975a.a();
        try {
            try {
                sQLiteDatabaseA.beginTransaction();
                Iterator it = list.iterator();
                i10 = 0;
                while (it.hasNext()) {
                    try {
                        a aVar = (a) it.next();
                        if (aVar != null && !p.f(aVar.b())) {
                            ContentValues contentValues = new ContentValues();
                            contentValues.put("title", aVar.e());
                            contentValues.put("parent_folder_id", aVar.d());
                            contentValues.put("ordering", Integer.valueOf(aVar.c()));
                            contentValues.put("last_updated_at", Long.valueOf(aVar.f()));
                            contentValues.put("created_at", Long.valueOf(aVar.a()));
                            sQLiteDatabaseA.update("bookmark_folders", contentValues, "_id = ?", new String[]{aVar.b()});
                            i10++;
                        }
                    } catch (Exception e10) {
                        e = e10;
                        tc.a.j(e);
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
        return i10 == list.size();
    }

    @Override // m9.d
    public int g(String str) {
        int i10 = 0;
        if (str == null) {
            return 0;
        }
        try {
            Cursor cursorRawQuery = this.f7975a.a().rawQuery("SELECT MAX(ordering) FROM bookmark_folders WHERE parent_folder_id = ?", new String[]{str});
            try {
                if (cursorRawQuery.moveToNext()) {
                    i10 = cursorRawQuery.getInt(0);
                }
                cursorRawQuery.close();
                return i10;
            } catch (Throwable th) {
                if (cursorRawQuery != null) {
                    try {
                        cursorRawQuery.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        } catch (Exception e10) {
            tc.a.j(e10);
            return i10;
        }
    }

    @Override // m9.d
    public a h(String str) {
        if (p.f(str)) {
            return null;
        }
        try {
            Cursor cursorQuery = this.f7975a.a().query("bookmark_folders", new String[]{"_id", "parent_folder_id", "ordering", "last_updated_at", "created_at"}, "title = ?", new String[]{str}, null, null, "ordering", "1");
            try {
                if (!cursorQuery.moveToNext()) {
                    cursorQuery.close();
                    return null;
                }
                a aVar = new a();
                aVar.m(cursorQuery.getString(0));
                aVar.p(str);
                aVar.o(p.k(cursorQuery.getString(1)));
                aVar.n(cursorQuery.getInt(2));
                aVar.q(cursorQuery.getLong(3));
                aVar.l(cursorQuery.getLong(4));
                cursorQuery.close();
                return aVar;
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
            return null;
        }
        tc.a.j(e10);
        return null;
    }

    @Override // m9.d
    public boolean i(b bVar) {
        int i10;
        boolean z10 = false;
        if (bVar == null || p.f(bVar.c()) || n.d(bVar.g())) {
            return false;
        }
        SQLiteDatabase sQLiteDatabaseA = this.f7975a.a();
        try {
            try {
                sQLiteDatabaseA.beginTransaction();
                sQLiteDatabaseA.delete("bookmark_items", "url = ?", new String[]{bVar.g()});
                try {
                    Cursor cursorRawQuery = sQLiteDatabaseA.rawQuery("SELECT MAX(ordering) FROM bookmark_items WHERE folder_id = ?", new String[]{bVar.b()});
                    try {
                        i10 = cursorRawQuery.moveToNext() ? cursorRawQuery.getInt(0) + 1 : 0;
                        try {
                            cursorRawQuery.close();
                        } catch (Exception e10) {
                            e = e10;
                            tc.a.j(e);
                        }
                    } catch (Throwable th) {
                        if (cursorRawQuery != null) {
                            try {
                                cursorRawQuery.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                        }
                        throw th;
                    }
                } catch (Exception e11) {
                    e = e11;
                    i10 = 0;
                }
                bVar.k(i10);
                ContentValues contentValues = new ContentValues();
                contentValues.put("_id", bVar.c());
                contentValues.put("url", bVar.g());
                contentValues.put("title", bVar.e());
                contentValues.put("folder_id", bVar.b());
                contentValues.put("ordering", Integer.valueOf(bVar.d()));
                contentValues.put("last_updated_at", Long.valueOf(bVar.f()));
                contentValues.put("created_at", Long.valueOf(bVar.a()));
                z10 = sQLiteDatabaseA.insert("bookmark_items", null, contentValues) > 0;
                sQLiteDatabaseA.setTransactionSuccessful();
            } catch (Exception e12) {
                tc.a.j(e12);
            }
            sQLiteDatabaseA.endTransaction();
            return z10;
        } catch (Throwable th3) {
            sQLiteDatabaseA.endTransaction();
            throw th3;
        }
    }

    @Override // m9.d
    public List j() {
        ArrayList arrayList = new ArrayList();
        try {
            Cursor cursorQuery = this.f7975a.a().query("bookmark_folders", new String[]{"_id", "title", "parent_folder_id", "ordering", "last_updated_at", "created_at"}, null, null, null, null, null);
            while (cursorQuery.moveToNext()) {
                try {
                    a aVar = new a();
                    aVar.m(cursorQuery.getString(0));
                    aVar.p(cursorQuery.getString(1));
                    aVar.o(p.k(cursorQuery.getString(2)));
                    aVar.n(cursorQuery.getInt(3));
                    aVar.q(cursorQuery.getLong(4));
                    aVar.l(cursorQuery.getLong(5));
                    arrayList.add(aVar);
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

    @Override // m9.d
    public boolean k(String str, b bVar) {
        if (!p.f(str) && bVar != null && !n.d(bVar.g())) {
            SQLiteDatabase sQLiteDatabaseA = this.f7975a.a();
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put("url", bVar.g());
                contentValues.put("title", bVar.e());
                contentValues.put("folder_id", bVar.b());
                contentValues.put("ordering", Integer.valueOf(bVar.d()));
                contentValues.put("last_updated_at", Long.valueOf(bVar.f()));
                contentValues.put("created_at", Long.valueOf(bVar.a()));
                sQLiteDatabaseA.update("bookmark_items", contentValues, "_id = ?", new String[]{str});
                return true;
            } catch (Exception e10) {
                tc.a.j(e10);
            }
        }
        return false;
    }

    @Override // m9.d
    public boolean l() {
        return this.f7975a.a().delete("bookmark_folders", null, null) > 0;
    }

    @Override // m9.d
    public boolean m(String str, a aVar) {
        if (!p.f(str) && aVar != null) {
            SQLiteDatabase sQLiteDatabaseA = this.f7975a.a();
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put("title", aVar.e());
                contentValues.put("parent_folder_id", aVar.d());
                contentValues.put("ordering", Integer.valueOf(aVar.c()));
                contentValues.put("last_updated_at", Long.valueOf(aVar.f()));
                contentValues.put("created_at", Long.valueOf(aVar.a()));
                return sQLiteDatabaseA.update("bookmark_folders", contentValues, "_id = ?", new String[]{str}) > 0;
            } catch (Exception e10) {
                tc.a.j(e10);
            }
        }
        return false;
    }

    @Override // m9.d
    public int n(String str) {
        int i10 = 0;
        if (str == null) {
            return 0;
        }
        try {
            Cursor cursorRawQuery = this.f7975a.a().rawQuery("SELECT MAX(ordering) FROM bookmark_items WHERE folder_id = ?", new String[]{str});
            try {
                if (cursorRawQuery.moveToNext()) {
                    i10 = cursorRawQuery.getInt(0);
                }
                cursorRawQuery.close();
                return i10;
            } catch (Throwable th) {
                if (cursorRawQuery != null) {
                    try {
                        cursorRawQuery.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        } catch (Exception e10) {
            tc.a.j(e10);
            return i10;
        }
    }

    @Override // m9.d
    public List o(String str) {
        if (str == null) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList = new ArrayList();
        try {
            Cursor cursorQuery = this.f7975a.a().query("bookmark_items", new String[]{"_id", "url", "title", "ordering", "last_updated_at", "created_at"}, "folder_id = ?", new String[]{str}, null, null, null);
            try {
                D(cursorQuery);
                while (cursorQuery.moveToNext()) {
                    b bVar = new b();
                    bVar.j(cursorQuery.getString(0));
                    bVar.n(cursorQuery.getString(1));
                    bVar.l(cursorQuery.getString(2));
                    bVar.i(str);
                    bVar.k(cursorQuery.getInt(3));
                    bVar.m(cursorQuery.getLong(4));
                    bVar.h(cursorQuery.getLong(5));
                    arrayList.add(bVar);
                }
                cursorQuery.close();
                return arrayList;
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
            return arrayList;
        }
    }

    @Override // m9.d
    public boolean p(String... strArr) {
        if (strArr == null || strArr.length == 0) {
            return false;
        }
        SQLiteDatabase sQLiteDatabaseA = this.f7975a.a();
        try {
            sQLiteDatabaseA.beginTransaction();
            for (String str : strArr) {
                sQLiteDatabaseA.delete("bookmark_folders", "_id = ?", new String[]{str});
            }
            sQLiteDatabaseA.setTransactionSuccessful();
            return true;
        } catch (Exception e10) {
            tc.a.j(e10);
            return false;
        } finally {
            sQLiteDatabaseA.endTransaction();
        }
    }

    @Override // m9.d
    public boolean q(a aVar) {
        int i10;
        boolean z10 = false;
        if (aVar == null || p.f(aVar.b())) {
            return false;
        }
        SQLiteDatabase sQLiteDatabaseA = this.f7975a.a();
        try {
            try {
                sQLiteDatabaseA.beginTransaction();
                try {
                    Cursor cursorRawQuery = sQLiteDatabaseA.rawQuery("select max(ordering) from bookmark_folders", null);
                    try {
                        i10 = cursorRawQuery.moveToNext() ? cursorRawQuery.getInt(0) + 1 : 0;
                        try {
                            cursorRawQuery.close();
                        } catch (Exception e10) {
                            e = e10;
                            tc.a.j(e);
                        }
                    } catch (Throwable th) {
                        if (cursorRawQuery != null) {
                            try {
                                cursorRawQuery.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                        }
                        throw th;
                    }
                } catch (Exception e11) {
                    e = e11;
                    i10 = 0;
                }
                aVar.n(i10);
                ContentValues contentValues = new ContentValues();
                contentValues.put("_id", aVar.b());
                contentValues.put("title", aVar.e());
                contentValues.put("parent_folder_id", aVar.d());
                contentValues.put("ordering", Integer.valueOf(aVar.c()));
                contentValues.put("last_updated_at", Long.valueOf(aVar.f()));
                contentValues.put("created_at", Long.valueOf(aVar.a()));
                z10 = sQLiteDatabaseA.insert("bookmark_folders", null, contentValues) > 0;
                sQLiteDatabaseA.setTransactionSuccessful();
            } catch (Exception e12) {
                tc.a.j(e12);
            }
            sQLiteDatabaseA.endTransaction();
            return z10;
        } catch (Throwable th3) {
            sQLiteDatabaseA.endTransaction();
            throw th3;
        }
    }

    @Override // m9.d
    public boolean r(String str) {
        return !p.f(str) && this.f7975a.a().delete("bookmark_items", "_id = ?", new String[]{str}) > 0;
    }

    @Override // m9.d
    public b s(String str) {
        if (p.f(str)) {
            return null;
        }
        try {
            Cursor cursorQuery = this.f7975a.a().query("bookmark_items", new String[]{"url", "title", "folder_id", "ordering", "last_updated_at", "created_at"}, "_id = ?", new String[]{str}, null, null, "ordering", "1");
            try {
                D(cursorQuery);
                if (!cursorQuery.moveToNext()) {
                    cursorQuery.close();
                    return null;
                }
                b bVar = new b();
                bVar.j(str);
                bVar.n(cursorQuery.getString(0));
                bVar.l(cursorQuery.getString(1));
                bVar.i(p.k(cursorQuery.getString(2)));
                bVar.k(cursorQuery.getInt(3));
                bVar.m(cursorQuery.getLong(4));
                bVar.h(cursorQuery.getLong(5));
                cursorQuery.close();
                return bVar;
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
            return null;
        }
        tc.a.j(e10);
        return null;
    }

    @Override // m9.d
    public List t(String str) {
        if (str == null) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList = new ArrayList();
        try {
            Cursor cursorQuery = this.f7975a.a().query("bookmark_folders", new String[]{"_id", "title", "ordering", "last_updated_at", "created_at"}, "parent_folder_id = ?", new String[]{str}, null, null, null);
            while (cursorQuery.moveToNext()) {
                try {
                    a aVar = new a();
                    aVar.m(cursorQuery.getString(0));
                    aVar.p(cursorQuery.getString(1));
                    aVar.o(str);
                    aVar.n(cursorQuery.getInt(2));
                    aVar.q(cursorQuery.getLong(3));
                    aVar.l(cursorQuery.getLong(4));
                    arrayList.add(aVar);
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

    @Override // m9.d
    public List u() {
        ArrayList arrayList = new ArrayList();
        try {
            Cursor cursorQuery = this.f7975a.a().query("bookmark_items", new String[]{"_id", "url", "title", "folder_id", "ordering", "last_updated_at", "created_at"}, null, null, null, null, null);
            try {
                D(cursorQuery);
                while (cursorQuery.moveToNext()) {
                    b bVar = new b();
                    bVar.j(cursorQuery.getString(0));
                    bVar.n(cursorQuery.getString(1));
                    bVar.l(cursorQuery.getString(2));
                    bVar.i(p.k(cursorQuery.getString(3)));
                    bVar.k(cursorQuery.getInt(4));
                    bVar.m(cursorQuery.getLong(5));
                    bVar.h(cursorQuery.getLong(6));
                    arrayList.add(bVar);
                }
                cursorQuery.close();
                return arrayList;
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
            return arrayList;
        }
    }

    @Override // m9.d
    public boolean v() {
        return this.f7975a.a().delete("bookmark_items", null, null) > 0;
    }

    @Override // m9.d
    public Map w(String... strArr) {
        String str;
        String[] strArr2;
        String str2;
        if (strArr == null || strArr.length == 0) {
            str = null;
            strArr2 = null;
        } else {
            if (strArr.length == 1) {
                str2 = "folder_id = ?";
            } else {
                str2 = "folder_id in " + g0.e(strArr.length);
            }
            strArr2 = strArr;
            str = str2;
        }
        try {
            Cursor cursorQuery = this.f7975a.a().query("bookmark_items", new String[]{"folder_id", "COUNT(*)"}, str, strArr2, "folder_id", null, null);
            try {
                HashMap map = new HashMap();
                while (cursorQuery.moveToNext()) {
                    map.put(p.m(cursorQuery.getString(0)), Integer.valueOf(cursorQuery.getInt(1)));
                }
                cursorQuery.close();
                return map;
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
            return Collections.EMPTY_MAP;
        }
    }

    @Override // m9.d
    public int x(List list, List list2) {
        int i10;
        int i11;
        if ((list == null || list.isEmpty()) && (list2 == null || list2.isEmpty())) {
            return 0;
        }
        SQLiteDatabase sQLiteDatabaseA = this.f7975a.a();
        try {
            try {
                sQLiteDatabaseA.beginTransaction();
                if (list != null) {
                    Iterator it = list.iterator();
                    i11 = 0;
                    while (it.hasNext()) {
                        a aVar = (a) it.next();
                        if (!p.f(aVar.b())) {
                            sQLiteDatabaseA.delete("bookmark_folders", "_id = ?", new String[]{aVar.b()});
                            ContentValues contentValues = new ContentValues();
                            contentValues.put("_id", aVar.b());
                            contentValues.put("title", aVar.e());
                            i10 = 0;
                            try {
                                contentValues.put("parent_folder_id", p.k(aVar.d()));
                                contentValues.put("ordering", Integer.valueOf(aVar.c()));
                                contentValues.put("last_updated_at", Long.valueOf(aVar.f()));
                                contentValues.put("created_at", Long.valueOf(aVar.a()));
                                sQLiteDatabaseA.insertOrThrow("bookmark_folders", null, contentValues);
                                i11++;
                            } catch (Exception e10) {
                                e = e10;
                                tc.a.e(e);
                                return i10;
                            }
                        }
                    }
                } else {
                    i11 = 0;
                }
                i10 = 0;
                if (list2 != null) {
                    Iterator it2 = list2.iterator();
                    while (it2.hasNext()) {
                        b bVar = (b) it2.next();
                        if (!p.f(bVar.c()) && !n.d(bVar.g())) {
                            sQLiteDatabaseA.delete("bookmark_items", "_id = ? OR (url = ? AND folder_id = ?)", new String[]{bVar.c(), bVar.g(), p.k(bVar.b())});
                            ContentValues contentValues2 = new ContentValues();
                            contentValues2.put("_id", bVar.c());
                            contentValues2.put("url", bVar.g());
                            contentValues2.put("title", bVar.e());
                            contentValues2.put("folder_id", p.k(bVar.b()));
                            contentValues2.put("ordering", Integer.valueOf(bVar.d()));
                            contentValues2.put("last_updated_at", Long.valueOf(bVar.f()));
                            contentValues2.put("created_at", Long.valueOf(bVar.a()));
                            sQLiteDatabaseA.insertOrThrow("bookmark_items", null, contentValues2);
                            i11++;
                        }
                    }
                }
                sQLiteDatabaseA.setTransactionSuccessful();
                return i11;
            } catch (Exception e11) {
                e = e11;
                i10 = 0;
            }
        } finally {
            sQLiteDatabaseA.endTransaction();
        }
    }

    @Override // m9.d
    public Map y(String... strArr) {
        String str;
        String[] strArr2;
        String str2;
        if (strArr == null || strArr.length == 0) {
            str = null;
            strArr2 = null;
        } else {
            if (strArr.length == 1) {
                str2 = "parent_folder_id = ?";
            } else {
                str2 = "parent_folder_id in " + g0.e(strArr.length);
            }
            strArr2 = strArr;
            str = str2;
        }
        try {
            Cursor cursorQuery = this.f7975a.a().query("bookmark_folders", new String[]{"parent_folder_id", "COUNT(*)"}, str, strArr2, "parent_folder_id", null, null);
            try {
                HashMap map = new HashMap();
                while (cursorQuery.moveToNext()) {
                    map.put(p.m(cursorQuery.getString(0)), Integer.valueOf(cursorQuery.getInt(1)));
                }
                cursorQuery.close();
                return map;
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
            return Collections.EMPTY_MAP;
        }
    }

    @Override // m9.d
    public List z(String str, String[] strArr, int i10) {
        String[] strArr2;
        String str2;
        if (str != null) {
            String strTrim = str.trim();
            if (!strTrim.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                String str3 = "%_" + strTrim + "%";
                String str4 = strTrim + "%";
                if (strArr == null || strArr.length == 0) {
                    strArr2 = new String[]{str3, str4};
                    str2 = "title like ? or title like ?";
                } else {
                    str2 = "parent_folder_id in " + g0.e(strArr.length) + " and (title like ? or title like ?)";
                    strArr2 = (String[]) Arrays.copyOf(strArr, strArr.length + 2);
                    strArr2[strArr.length] = str3;
                    strArr2[strArr.length + 1] = str4;
                }
                try {
                    Cursor cursorQuery = this.f7975a.a().query("bookmark_folders", new String[]{"_id", "title", "parent_folder_id", "ordering", "last_updated_at", "created_at"}, str2, strArr2, null, null, null, i10 <= 0 ? null : String.valueOf(i10));
                    while (cursorQuery.moveToNext()) {
                        try {
                            a aVar = new a();
                            aVar.m(cursorQuery.getString(0));
                            aVar.p(cursorQuery.getString(1));
                            aVar.o(p.k(cursorQuery.getString(2)));
                            aVar.n(cursorQuery.getInt(3));
                            aVar.q(cursorQuery.getLong(4));
                            aVar.l(cursorQuery.getLong(5));
                            arrayList.add(aVar);
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
        }
        return Collections.EMPTY_LIST;
    }
}
