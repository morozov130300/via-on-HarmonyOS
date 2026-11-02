package o9;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import g6.p;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import z8.i0;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class g implements d {

    /* renamed from: a, reason: collision with root package name */
    public final q9.a f10487a;

    public g(q9.a aVar) {
        this.f10487a = aVar;
    }

    public static void C(SQLiteDatabase sQLiteDatabase) throws SQLException {
        sQLiteDatabase.execSQL("CREATE TABLE bookmark_items(_id TEXT PRIMARY KEY,url TEXT,title TEXT,folder_id TEXT,ordering INTEGER,last_updated_at INTEGER DEFAULT 0,created_at INTEGER DEFAULT 0)");
        sQLiteDatabase.execSQL("CREATE TABLE bookmark_folders(_id TEXT PRIMARY KEY,title TEXT,parent_folder_id TEXT,ordering INTEGER,created_at INTEGER DEFAULT 0,last_updated_at INTEGER DEFAULT 0)");
    }

    public static void E(SQLiteDatabase sQLiteDatabase, int i10, int i11) throws SQLException {
        if (i10 <= 9) {
            C(sQLiteDatabase);
        }
    }

    @Override // o9.d
    public List A(String str, String[] strArr, int i10) {
        String str2;
        String[] strArr2;
        w.d dVarD = i0.d(str, "title", "url");
        if (dVarD == null) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList = new ArrayList();
        if (strArr == null || strArr.length <= 0) {
            str2 = (String) dVarD.f13207a;
            strArr2 = (String[]) dVarD.f13208b;
        } else {
            str2 = "folder_id in " + i0.e(strArr.length) + " and (" + ((String) dVarD.f13207a) + ")";
            strArr2 = (String[]) g6.a.a(strArr, (String[]) dVarD.f13208b);
        }
        try {
            Cursor cursorQuery = this.f10487a.a().query("bookmark_items", new String[]{"_id", "url", "title", "folder_id", "ordering", "last_updated_at", "created_at"}, str2, strArr2, null, null, null, i10 <= 0 ? null : String.valueOf(i10));
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
            } finally {
            }
        } catch (Exception e10) {
            pc.a.i(e10);
            return arrayList;
        }
    }

    @Override // o9.d
    public boolean B(String... strArr) {
        if (strArr == null || strArr.length == 0) {
            return false;
        }
        SQLiteDatabase sQLiteDatabaseA = this.f10487a.a();
        try {
            try {
                sQLiteDatabaseA.beginTransaction();
                for (String str : strArr) {
                    sQLiteDatabaseA.delete("bookmark_items", "folder_id = ?", new String[]{str});
                }
                sQLiteDatabaseA.setTransactionSuccessful();
                sQLiteDatabaseA.endTransaction();
                return true;
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

    public final void D(Cursor cursor) {
        i0.a(cursor, 4194304);
    }

    @Override // o9.d
    public b a(String str) {
        if (z8.p.o(str)) {
            return null;
        }
        String[] strArrF = i0.f(str);
        try {
            Cursor cursorQuery = this.f10487a.a().query("bookmark_items", new String[]{"_id", "url", "title", "folder_id", "ordering", "last_updated_at", "created_at"}, "url in " + i0.e(strArrF.length), strArrF, null, null, "ordering", "1");
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
            } finally {
            }
        } catch (Exception e10) {
            pc.a.i(e10);
            return null;
        }
    }

    @Override // o9.d
    public boolean b(String str, b bVar) {
        if (!p.f(str) && bVar != null && !z8.p.o(bVar.g())) {
            SQLiteDatabase sQLiteDatabaseA = this.f10487a.a();
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
                pc.a.i(e10);
            }
        }
        return false;
    }

    @Override // o9.d
    public boolean c(String... strArr) {
        if (strArr == null || strArr.length == 0) {
            return false;
        }
        SQLiteDatabase sQLiteDatabaseA = this.f10487a.a();
        try {
            try {
                sQLiteDatabaseA.beginTransaction();
                for (String str : strArr) {
                    sQLiteDatabaseA.delete("bookmark_items", "_id = ?", new String[]{str});
                }
                sQLiteDatabaseA.setTransactionSuccessful();
                sQLiteDatabaseA.endTransaction();
                return true;
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

    @Override // o9.d
    public boolean d(String str) {
        return !z8.p.o(str) && this.f10487a.a().delete("bookmark_items", "url = ?", new String[]{str}) > 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00ac A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:51:? A[RETURN, SYNTHETIC] */
    @Override // o9.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean e(List list) {
        int i10;
        if (list == null || list.isEmpty()) {
            return false;
        }
        SQLiteDatabase sQLiteDatabaseA = this.f10487a.a();
        try {
            try {
                sQLiteDatabaseA.beginTransaction();
                Iterator it = list.iterator();
                i10 = 0;
                while (it.hasNext()) {
                    try {
                        b bVar = (b) it.next();
                        if (bVar != null && !p.f(bVar.c()) && !z8.p.o(bVar.g())) {
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
                        pc.a.i(e);
                        sQLiteDatabaseA.endTransaction();
                        if (i10 != list.size()) {
                        }
                    }
                }
                sQLiteDatabaseA.setTransactionSuccessful();
            } catch (Exception e11) {
                e = e11;
                i10 = 0;
            }
            sQLiteDatabaseA.endTransaction();
            return i10 != list.size();
        } catch (Throwable th) {
            sQLiteDatabaseA.endTransaction();
            throw th;
        }
    }

    @Override // o9.d
    public a f(String str) {
        if (p.f(str)) {
            return null;
        }
        try {
            Cursor cursorQuery = this.f10487a.a().query("bookmark_folders", new String[]{"title", "parent_folder_id", "ordering", "last_updated_at", "created_at"}, "_id = ?", new String[]{str}, null, null, "ordering", "1");
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
            } finally {
            }
        } catch (Exception e10) {
            pc.a.i(e10);
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00a0  */
    @Override // o9.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean g(a aVar) {
        int i10;
        if (aVar == null || p.f(aVar.b())) {
            return false;
        }
        SQLiteDatabase sQLiteDatabaseA = this.f10487a.a();
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
                            pc.a.i(e);
                            aVar.n(i10);
                            ContentValues contentValues = new ContentValues();
                            contentValues.put("_id", aVar.b());
                            contentValues.put("title", aVar.e());
                            contentValues.put("parent_folder_id", aVar.d());
                            contentValues.put("ordering", Integer.valueOf(aVar.c()));
                            contentValues.put("last_updated_at", Long.valueOf(aVar.f()));
                            contentValues.put("created_at", Long.valueOf(aVar.a()));
                            if (sQLiteDatabaseA.insert("bookmark_folders", null, contentValues) > 0) {
                            }
                            sQLiteDatabaseA.setTransactionSuccessful();
                            return z;
                        }
                    } finally {
                    }
                } catch (Exception e11) {
                    e = e11;
                    i10 = 0;
                }
                aVar.n(i10);
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("_id", aVar.b());
                contentValues2.put("title", aVar.e());
                contentValues2.put("parent_folder_id", aVar.d());
                contentValues2.put("ordering", Integer.valueOf(aVar.c()));
                contentValues2.put("last_updated_at", Long.valueOf(aVar.f()));
                contentValues2.put("created_at", Long.valueOf(aVar.a()));
                z = sQLiteDatabaseA.insert("bookmark_folders", null, contentValues2) > 0;
                sQLiteDatabaseA.setTransactionSuccessful();
            } catch (Exception e12) {
                pc.a.i(e12);
            }
            return z;
        } finally {
            sQLiteDatabaseA.endTransaction();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0099 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:47:? A[RETURN, SYNTHETIC] */
    @Override // o9.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean h(List list) {
        int i10;
        if (list == null || list.isEmpty()) {
            return false;
        }
        SQLiteDatabase sQLiteDatabaseA = this.f10487a.a();
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
                        pc.a.i(e);
                        sQLiteDatabaseA.endTransaction();
                        if (i10 != list.size()) {
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
        return i10 != list.size();
    }

    @Override // o9.d
    public int i(String str) {
        int i10 = 0;
        if (str == null) {
            return 0;
        }
        try {
            Cursor cursorRawQuery = this.f10487a.a().rawQuery("SELECT MAX(ordering) FROM bookmark_folders WHERE parent_folder_id = ?", new String[]{str});
            try {
                if (cursorRawQuery.moveToNext()) {
                    i10 = cursorRawQuery.getInt(0);
                }
                cursorRawQuery.close();
                return i10;
            } finally {
            }
        } catch (Exception e10) {
            pc.a.i(e10);
            return i10;
        }
    }

    @Override // o9.d
    public a j(String str) {
        if (p.f(str)) {
            return null;
        }
        try {
            Cursor cursorQuery = this.f10487a.a().query("bookmark_folders", new String[]{"_id", "parent_folder_id", "ordering", "last_updated_at", "created_at"}, "title = ?", new String[]{str}, null, null, "ordering", "1");
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
            } finally {
            }
        } catch (Exception e10) {
            pc.a.i(e10);
            return null;
        }
    }

    @Override // o9.d
    public List k() {
        ArrayList arrayList = new ArrayList();
        try {
            Cursor cursorQuery = this.f10487a.a().query("bookmark_folders", new String[]{"_id", "title", "parent_folder_id", "ordering", "last_updated_at", "created_at"}, null, null, null, null, null);
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

    @Override // o9.d
    public boolean l() {
        return this.f10487a.a().delete("bookmark_folders", null, null) > 0;
    }

    @Override // o9.d
    public int m(String str) {
        int i10 = 0;
        if (str == null) {
            return 0;
        }
        try {
            Cursor cursorRawQuery = this.f10487a.a().rawQuery("SELECT MAX(ordering) FROM bookmark_items WHERE folder_id = ?", new String[]{str});
            try {
                if (cursorRawQuery.moveToNext()) {
                    i10 = cursorRawQuery.getInt(0);
                }
                cursorRawQuery.close();
                return i10;
            } finally {
            }
        } catch (Exception e10) {
            pc.a.i(e10);
            return i10;
        }
    }

    @Override // o9.d
    public List n(String str) {
        if (str == null) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList = new ArrayList();
        try {
            Cursor cursorQuery = this.f10487a.a().query("bookmark_items", new String[]{"_id", "url", "title", "ordering", "last_updated_at", "created_at"}, "folder_id = ?", new String[]{str}, null, null, null);
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
            } finally {
            }
        } catch (Exception e10) {
            pc.a.i(e10);
            return arrayList;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00c8  */
    @Override // o9.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean o(b bVar) {
        int i10;
        if (bVar == null || p.f(bVar.c()) || z8.p.o(bVar.g())) {
            return false;
        }
        SQLiteDatabase sQLiteDatabaseA = this.f10487a.a();
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
                            pc.a.i(e);
                            bVar.k(i10);
                            ContentValues contentValues = new ContentValues();
                            contentValues.put("_id", bVar.c());
                            contentValues.put("url", bVar.g());
                            contentValues.put("title", bVar.e());
                            contentValues.put("folder_id", bVar.b());
                            contentValues.put("ordering", Integer.valueOf(bVar.d()));
                            contentValues.put("last_updated_at", Long.valueOf(bVar.f()));
                            contentValues.put("created_at", Long.valueOf(bVar.a()));
                            if (sQLiteDatabaseA.insert("bookmark_items", null, contentValues) > 0) {
                            }
                            sQLiteDatabaseA.setTransactionSuccessful();
                            return z;
                        }
                    } finally {
                    }
                } catch (Exception e11) {
                    e = e11;
                    i10 = 0;
                }
                bVar.k(i10);
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("_id", bVar.c());
                contentValues2.put("url", bVar.g());
                contentValues2.put("title", bVar.e());
                contentValues2.put("folder_id", bVar.b());
                contentValues2.put("ordering", Integer.valueOf(bVar.d()));
                contentValues2.put("last_updated_at", Long.valueOf(bVar.f()));
                contentValues2.put("created_at", Long.valueOf(bVar.a()));
                z = sQLiteDatabaseA.insert("bookmark_items", null, contentValues2) > 0;
                sQLiteDatabaseA.setTransactionSuccessful();
            } catch (Exception e12) {
                pc.a.i(e12);
            }
            return z;
        } finally {
            sQLiteDatabaseA.endTransaction();
        }
    }

    @Override // o9.d
    public boolean p(String... strArr) {
        if (strArr == null || strArr.length == 0) {
            return false;
        }
        SQLiteDatabase sQLiteDatabaseA = this.f10487a.a();
        try {
            try {
                sQLiteDatabaseA.beginTransaction();
                for (String str : strArr) {
                    sQLiteDatabaseA.delete("bookmark_folders", "_id = ?", new String[]{str});
                }
                sQLiteDatabaseA.setTransactionSuccessful();
                sQLiteDatabaseA.endTransaction();
                return true;
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

    @Override // o9.d
    public boolean q(String str) {
        return !p.f(str) && this.f10487a.a().delete("bookmark_items", "_id = ?", new String[]{str}) > 0;
    }

    @Override // o9.d
    public b r(String str) {
        if (p.f(str)) {
            return null;
        }
        try {
            Cursor cursorQuery = this.f10487a.a().query("bookmark_items", new String[]{"url", "title", "folder_id", "ordering", "last_updated_at", "created_at"}, "_id = ?", new String[]{str}, null, null, "ordering", "1");
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
            } finally {
            }
        } catch (Exception e10) {
            pc.a.i(e10);
            return null;
        }
    }

    @Override // o9.d
    public List s(String str) {
        if (str == null) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList = new ArrayList();
        try {
            Cursor cursorQuery = this.f10487a.a().query("bookmark_folders", new String[]{"_id", "title", "ordering", "last_updated_at", "created_at"}, "parent_folder_id = ?", new String[]{str}, null, null, null);
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

    @Override // o9.d
    public boolean t(String str, a aVar) {
        if (!p.f(str) && aVar != null) {
            SQLiteDatabase sQLiteDatabaseA = this.f10487a.a();
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put("title", aVar.e());
                contentValues.put("parent_folder_id", aVar.d());
                contentValues.put("ordering", Integer.valueOf(aVar.c()));
                contentValues.put("last_updated_at", Long.valueOf(aVar.f()));
                contentValues.put("created_at", Long.valueOf(aVar.a()));
                return sQLiteDatabaseA.update("bookmark_folders", contentValues, "_id = ?", new String[]{str}) > 0;
            } catch (Exception e10) {
                pc.a.i(e10);
            }
        }
        return false;
    }

    @Override // o9.d
    public List u() {
        ArrayList arrayList = new ArrayList();
        try {
            Cursor cursorQuery = this.f10487a.a().query("bookmark_items", new String[]{"_id", "url", "title", "folder_id", "ordering", "last_updated_at", "created_at"}, null, null, null, null, null);
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
            } finally {
            }
        } catch (Exception e10) {
            pc.a.i(e10);
            return arrayList;
        }
    }

    @Override // o9.d
    public boolean v() {
        return this.f10487a.a().delete("bookmark_items", null, null) > 0;
    }

    @Override // o9.d
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
                str2 = "folder_id in " + i0.e(strArr.length);
            }
            strArr2 = strArr;
            str = str2;
        }
        try {
            Cursor cursorQuery = this.f10487a.a().query("bookmark_items", new String[]{"folder_id", "COUNT(*)"}, str, strArr2, "folder_id", null, null);
            try {
                HashMap map = new HashMap();
                while (cursorQuery.moveToNext()) {
                    map.put(p.m(cursorQuery.getString(0)), Integer.valueOf(cursorQuery.getInt(1)));
                }
                cursorQuery.close();
                return map;
            } finally {
            }
        } catch (Exception e10) {
            pc.a.i(e10);
            return Collections.EMPTY_MAP;
        }
    }

    @Override // o9.d
    public int x(List list, List list2) {
        int i10;
        int i11;
        if ((list == null || list.isEmpty()) && (list2 == null || list2.isEmpty())) {
            return 0;
        }
        SQLiteDatabase sQLiteDatabaseA = this.f10487a.a();
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
                                sQLiteDatabaseA.insert("bookmark_folders", null, contentValues);
                                i11++;
                            } catch (Exception e10) {
                                e = e10;
                                pc.a.d(e);
                                sQLiteDatabaseA.endTransaction();
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
                        if (!p.f(bVar.c()) && !z8.p.o(bVar.g())) {
                            sQLiteDatabaseA.delete("bookmark_items", "url = ?", new String[]{bVar.g()});
                            ContentValues contentValues2 = new ContentValues();
                            contentValues2.put("_id", bVar.c());
                            contentValues2.put("url", bVar.g());
                            contentValues2.put("title", bVar.e());
                            contentValues2.put("folder_id", p.k(bVar.b()));
                            contentValues2.put("ordering", Integer.valueOf(bVar.d()));
                            contentValues2.put("last_updated_at", Long.valueOf(bVar.f()));
                            contentValues2.put("created_at", Long.valueOf(bVar.a()));
                            sQLiteDatabaseA.insert("bookmark_items", null, contentValues2);
                            i11++;
                        }
                    }
                }
                sQLiteDatabaseA.setTransactionSuccessful();
                sQLiteDatabaseA.endTransaction();
                return i11;
            } catch (Exception e11) {
                e = e11;
                i10 = 0;
            }
        } catch (Throwable th) {
            sQLiteDatabaseA.endTransaction();
            throw th;
        }
    }

    @Override // o9.d
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
                str2 = "parent_folder_id in " + i0.e(strArr.length);
            }
            strArr2 = strArr;
            str = str2;
        }
        try {
            Cursor cursorQuery = this.f10487a.a().query("bookmark_folders", new String[]{"parent_folder_id", "COUNT(*)"}, str, strArr2, "parent_folder_id", null, null);
            try {
                HashMap map = new HashMap();
                while (cursorQuery.moveToNext()) {
                    map.put(p.m(cursorQuery.getString(0)), Integer.valueOf(cursorQuery.getInt(1)));
                }
                cursorQuery.close();
                return map;
            } finally {
            }
        } catch (Exception e10) {
            pc.a.i(e10);
            return Collections.EMPTY_MAP;
        }
    }

    @Override // o9.d
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
                    str2 = "parent_folder_id in " + i0.e(strArr.length) + " and (title like ? or title like ?)";
                    strArr2 = (String[]) Arrays.copyOf(strArr, strArr.length + 2);
                    strArr2[strArr.length] = str3;
                    strArr2[strArr.length + 1] = str4;
                }
                try {
                    Cursor cursorQuery = this.f10487a.a().query("bookmark_folders", new String[]{"_id", "title", "parent_folder_id", "ordering", "last_updated_at", "created_at"}, str2, strArr2, null, null, null, i10 <= 0 ? null : String.valueOf(i10));
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
        }
        return Collections.EMPTY_LIST;
    }
}
