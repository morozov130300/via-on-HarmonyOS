package fa;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import w.d;
import z8.i0;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class b implements a {

    /* renamed from: a, reason: collision with root package name */
    public final q9.a f6063a;

    public b(q9.a aVar) {
        this.f6063a = aVar;
    }

    public static void c(SQLiteDatabase sQLiteDatabase) throws SQLException {
        sQLiteDatabase.execSQL("CREATE TABLE favorites(f_id INTEGER PRIMARY KEY,f_url TEXT,f_title TEXT,f_order INTEGER,updated_at INTEGER DEFAULT 0,created_at INTEGER DEFAULT 0)");
    }

    public static void e(SQLiteDatabase sQLiteDatabase, int i10, int i11) throws SQLException {
        if (i10 <= 3) {
            sQLiteDatabase.execSQL("CREATE TABLE favorites(f_id INTEGER PRIMARY KEY,f_url TEXT,f_title TEXT,f_order INTEGER,updated_at INTEGER DEFAULT 0,created_at INTEGER DEFAULT 0)");
        }
        if (i10 < 8) {
            sQLiteDatabase.execSQL("ALTER TABLE favorites ADD COLUMN updated_at INTEGER DEFAULT 0;");
            sQLiteDatabase.execSQL("ALTER TABLE favorites ADD COLUMN created_at INTEGER DEFAULT 0;");
            ContentValues contentValues = new ContentValues();
            long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
            contentValues.put("updated_at", Long.valueOf(jCurrentTimeMillis));
            contentValues.put("created_at", Long.valueOf(jCurrentTimeMillis));
            sQLiteDatabase.update("favorites", contentValues, null, null);
        }
    }

    @Override // fa.a
    public n9.b a(String str) throws Throwable {
        Exception exc;
        n9.b bVar;
        n9.b bVar2 = null;
        if (str != null) {
            String strTrim = str.trim();
            if (!strTrim.isEmpty()) {
                String[] strArrF = i0.f(strTrim);
                try {
                    Cursor cursorQuery = this.f6063a.a().query("favorites", new String[]{"f_id", "f_url", "f_title", "f_order"}, "f_url in " + i0.e(strArrF.length), strArrF, null, null, null, "1");
                    try {
                        if (cursorQuery.moveToNext()) {
                            bVar = new n9.b();
                            try {
                                bVar.m(cursorQuery.getInt(0));
                                bVar.q(cursorQuery.getString(1));
                                bVar.o(cursorQuery.getString(2));
                                bVar.n(cursorQuery.getInt(3));
                                bVar2 = bVar;
                            } catch (Throwable th) {
                                th = th;
                                Throwable th2 = th;
                                try {
                                    if (cursorQuery == null) {
                                        throw th2;
                                    }
                                    try {
                                        cursorQuery.close();
                                        throw th2;
                                    } catch (Throwable th3) {
                                        th2.addSuppressed(th3);
                                        throw th2;
                                    }
                                } catch (Exception e10) {
                                    exc = e10;
                                    bVar2 = bVar;
                                    exc.printStackTrace();
                                    return bVar2;
                                }
                                exc = e10;
                                bVar2 = bVar;
                                exc.printStackTrace();
                                return bVar2;
                            }
                        }
                        cursorQuery.close();
                        return bVar2;
                    } catch (Throwable th4) {
                        th = th4;
                        bVar = null;
                    }
                } catch (Exception e11) {
                    exc = e11;
                }
            }
        }
        return bVar2;
    }

    @Override // fa.a
    public void b(String str) {
        if (str != null) {
            String strTrim = str.trim();
            if (strTrim.isEmpty()) {
                return;
            }
            String[] strArrF = i0.f(strTrim);
            this.f6063a.a().delete("favorites", "f_url in " + i0.e(strArrF.length), strArrF);
        }
    }

    @Override // fa.a
    public void d(int i10) {
        this.f6063a.a().delete("favorites", "f_id = ?", new String[]{String.valueOf(i10)});
    }

    @Override // fa.a
    public n9.b f(int i10) throws Throwable {
        Throwable th;
        n9.b bVar = null;
        if (i10 < 0) {
            return null;
        }
        try {
            Cursor cursorQuery = this.f6063a.a().query("favorites", new String[]{"f_url", "f_title", "f_order"}, "f_id = ?", new String[]{String.valueOf(i10)}, null, null, null, "1");
            try {
                if (cursorQuery.moveToNext()) {
                    n9.b bVar2 = new n9.b();
                    try {
                        bVar2.m(i10);
                        bVar2.q(cursorQuery.getString(0));
                        bVar2.o(cursorQuery.getString(1));
                        bVar2.n(cursorQuery.getInt(2));
                        bVar = bVar2;
                    } catch (Throwable th2) {
                        th = th2;
                        bVar = bVar2;
                        if (cursorQuery == null) {
                            throw th;
                        }
                        try {
                            cursorQuery.close();
                            throw th;
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                            throw th;
                        }
                    }
                }
                cursorQuery.close();
                return bVar;
            } catch (Throwable th4) {
                th = th4;
            }
        } catch (Exception e10) {
            e10.printStackTrace();
            return bVar;
        }
    }

    @Override // fa.a
    public List h() {
        ArrayList arrayList = new ArrayList();
        try {
            Cursor cursorQuery = this.f6063a.a().query("favorites", new String[]{"f_id", "f_url", "f_title", "f_order"}, null, null, null, null, "f_order");
            while (cursorQuery.moveToNext()) {
                try {
                    n9.b bVar = new n9.b(cursorQuery.getString(1), cursorQuery.getString(2));
                    bVar.m(cursorQuery.getInt(0));
                    bVar.n(cursorQuery.getInt(3));
                    arrayList.add(bVar);
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

    @Override // fa.a
    public void j(List list) {
        SQLiteDatabase sQLiteDatabaseA = this.f6063a.a();
        try {
            try {
                sQLiteDatabaseA.beginTransaction();
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    n9.b bVar = (n9.b) it.next();
                    sQLiteDatabaseA.delete("favorites", "f_url = ?", new String[]{String.valueOf(bVar.g())});
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("f_url", bVar.g());
                    contentValues.put("f_title", bVar.e());
                    contentValues.put("f_order", Integer.valueOf(bVar.d()));
                    sQLiteDatabaseA.insert("favorites", null, contentValues);
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

    @Override // fa.a
    public void n() {
        this.f6063a.a().delete("favorites", null, null);
    }

    @Override // fa.a
    public List o(String str, int i10) {
        ArrayList arrayList = new ArrayList();
        d dVarD = i0.d(str, "f_title", "f_url");
        if (dVarD == null) {
            return arrayList;
        }
        try {
            Cursor cursorQuery = this.f6063a.a().query("favorites", new String[]{"f_id", "f_url", "f_title"}, (String) dVarD.f13207a, (String[]) dVarD.f13208b, null, null, "f_id desc", i10 <= 0 ? null : String.valueOf(i10));
            while (cursorQuery.moveToNext()) {
                try {
                    arrayList.add(n9.b.i(cursorQuery.getInt(0), cursorQuery.getString(1), cursorQuery.getString(2)));
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

    @Override // fa.a
    public int s(n9.b bVar) {
        int iC = -1;
        if (bVar == null || bVar.h()) {
            return -1;
        }
        boolean z10 = bVar.c() <= 0;
        SQLiteDatabase sQLiteDatabaseA = this.f6063a.a();
        try {
            try {
                sQLiteDatabaseA.beginTransaction();
                if (z10) {
                    sQLiteDatabaseA.delete("favorites", "f_url = ?", new String[]{bVar.g()});
                }
                int iD = bVar.d();
                if (z10 && iD == -1) {
                    try {
                        Cursor cursorRawQuery = sQLiteDatabaseA.rawQuery("select max(f_order) from favorites", null);
                        try {
                            if (cursorRawQuery.moveToNext()) {
                                iD = cursorRawQuery.getInt(0) + 1;
                            }
                            cursorRawQuery.close();
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
                        e10.printStackTrace();
                    }
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put("f_url", bVar.g());
                contentValues.put("f_title", bVar.e());
                contentValues.put("f_order", Integer.valueOf(iD));
                long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
                contentValues.put("updated_at", Long.valueOf(jCurrentTimeMillis));
                if (z10) {
                    contentValues.put("created_at", Long.valueOf(jCurrentTimeMillis));
                    iC = (int) sQLiteDatabaseA.insert("favorites", null, contentValues);
                } else if (sQLiteDatabaseA.update("favorites", contentValues, "f_id = ?", new String[]{String.valueOf(bVar.c())}) > 0) {
                    iC = bVar.c();
                }
                sQLiteDatabaseA.setTransactionSuccessful();
            } catch (Throwable th3) {
                sQLiteDatabaseA.endTransaction();
                throw th3;
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        sQLiteDatabaseA.endTransaction();
        return iC;
    }

    @Override // fa.a
    public void t(int i10, int i11) {
        List listH = h();
        SQLiteDatabase sQLiteDatabaseA = this.f6063a.a();
        try {
            try {
                if (i11 > i10) {
                    while (i10 < i11) {
                        int i12 = i10 + 1;
                        Collections.swap(listH, i10, i12);
                        i10 = i12;
                    }
                } else {
                    while (i10 > i11) {
                        Collections.swap(listH, i10, i10 - 1);
                        i10--;
                    }
                }
                sQLiteDatabaseA.beginTransaction();
                ContentValues contentValues = new ContentValues();
                int size = listH.size();
                for (int i13 = 0; i13 < size; i13++) {
                    contentValues.put("f_order", Integer.valueOf(i13));
                    sQLiteDatabaseA.update("favorites", contentValues, "f_id = ?", new String[]{String.valueOf(((n9.b) listH.get(i13)).c())});
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
}
