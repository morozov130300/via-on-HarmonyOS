package ja;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.simpleframework.xml.strategy.Name;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class a implements d {

    /* renamed from: a, reason: collision with root package name */
    public final q9.a f7628a;

    public a(q9.a aVar) {
        this.f7628a = aVar;
    }

    public static void i(SQLiteDatabase sQLiteDatabase) throws SQLException {
        sQLiteDatabase.execSQL("CREATE TABLE settings(id INTEGER PRIMARY KEY,title TEXT,content TEXT,note TEXT,flag INTEGER DEFAULT 0,type INTEGER DEFAULT 0,updated_at INTEGER DEFAULT 0,created_at INTEGER DEFAULT 0)");
    }

    public static void l(SQLiteDatabase sQLiteDatabase, int i10, int i11) throws SQLException {
        if (i10 <= 8) {
            sQLiteDatabase.execSQL("CREATE TABLE settings(id INTEGER PRIMARY KEY,title TEXT,content TEXT,note TEXT,flag INTEGER DEFAULT 0,type INTEGER DEFAULT 0,updated_at INTEGER DEFAULT 0,created_at INTEGER DEFAULT 0)");
        }
    }

    @Override // ja.d
    public boolean a(int i10) {
        SQLiteDatabase sQLiteDatabaseA = this.f7628a.a();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("id = ");
        sb2.append(i10);
        return sQLiteDatabaseA.delete("settings", sb2.toString(), null) > 0;
    }

    @Override // ja.d
    public boolean b(int i10, c cVar) {
        SQLiteDatabase sQLiteDatabaseA = this.f7628a.a();
        ContentValues contentValuesJ = j(cVar);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("id = ");
        sb2.append(i10);
        return sQLiteDatabaseA.update("settings", contentValuesJ, sb2.toString(), null) > 0;
    }

    @Override // ja.d
    public List c(int i10) {
        ArrayList arrayList = new ArrayList();
        try {
            Cursor cursorQuery = this.f7628a.a().query("settings", null, "type = " + i10, null, null, null, null);
            while (cursorQuery.moveToNext()) {
                try {
                    c cVarK = k(cursorQuery);
                    if (cVarK != null) {
                        arrayList.add(cVarK);
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

    @Override // ja.d
    public c d(int i10) {
        c cVarK = null;
        try {
            Cursor cursorQuery = this.f7628a.a().query("settings", null, "id = " + i10, null, null, null, null, "1");
            try {
                if (cursorQuery.moveToNext()) {
                    cVarK = k(cursorQuery);
                }
                cursorQuery.close();
                return cVarK;
            } finally {
            }
        } catch (Exception e10) {
            e10.printStackTrace();
            return cVarK;
        }
    }

    @Override // ja.d
    public List e() {
        ArrayList arrayList = new ArrayList();
        try {
            Cursor cursorQuery = this.f7628a.a().query("settings", null, null, null, null, null, null);
            while (cursorQuery.moveToNext()) {
                try {
                    c cVarK = k(cursorQuery);
                    if (cVarK != null) {
                        arrayList.add(cVarK);
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

    @Override // ja.d
    public c f(String str, int i10) {
        if (str != null && !str.isEmpty()) {
            try {
                Cursor cursorQuery = this.f7628a.a().query("settings", null, "type = ? and content = ?", new String[]{String.valueOf(i10), str}, null, null, null, "1");
                try {
                    if (cursorQuery.moveToFirst()) {
                        c cVarK = k(cursorQuery);
                        cursorQuery.close();
                        return cVarK;
                    }
                    cursorQuery.close();
                } finally {
                }
            } catch (Exception e10) {
                pc.a.i(e10);
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:63:0x00d4 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00d6 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00b8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0080 A[SYNTHETIC] */
    @Override // ja.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean g(List list) {
        int i10;
        String str;
        Cursor cursorQuery;
        int i11 = 0;
        if (list == null || list.isEmpty()) {
            return false;
        }
        SQLiteDatabase sQLiteDatabaseA = this.f7628a.a();
        try {
            try {
                sQLiteDatabaseA.beginTransaction();
                Iterator it = list.iterator();
                i10 = 0;
                while (it.hasNext()) {
                    try {
                        c cVar = (c) it.next();
                        if (cVar != null) {
                            cVar.r(i11);
                            if (cVar.h() == 1 || cVar.h() == 2) {
                                try {
                                    str = "settings";
                                } catch (Exception e10) {
                                    e = e10;
                                    str = "settings";
                                }
                                try {
                                    cursorQuery = sQLiteDatabaseA.query("settings", new String[]{"content"}, "type = ? and content = ?", new String[]{String.valueOf(cVar.h()), cVar.a()}, null, null, null, "1");
                                    try {
                                    } catch (Throwable th) {
                                        if (cursorQuery != null) {
                                            try {
                                                cursorQuery.close();
                                            } catch (Throwable th2) {
                                                th.addSuppressed(th2);
                                            }
                                        }
                                        throw th;
                                    }
                                } catch (Exception e11) {
                                    e = e11;
                                    pc.a.i(e);
                                    sQLiteDatabaseA.delete(str, "content = ?", new String[]{cVar.a()});
                                    if (sQLiteDatabaseA.insert(str, null, j(cVar)) <= 0) {
                                    }
                                    i11 = 0;
                                }
                                if (cursorQuery.moveToFirst()) {
                                    cursorQuery.close();
                                } else {
                                    cursorQuery.close();
                                    sQLiteDatabaseA.delete(str, "content = ?", new String[]{cVar.a()});
                                }
                            } else {
                                str = "settings";
                            }
                            if (sQLiteDatabaseA.insert(str, null, j(cVar)) <= 0) {
                                try {
                                    i10++;
                                } catch (Exception e12) {
                                    e = e12;
                                    e.printStackTrace();
                                    if (i10 != list.size()) {
                                    }
                                }
                            }
                        }
                        i11 = 0;
                    } catch (Exception e13) {
                        e = e13;
                    }
                }
                sQLiteDatabaseA.setTransactionSuccessful();
            } finally {
                sQLiteDatabaseA.endTransaction();
            }
        } catch (Exception e14) {
            e = e14;
            i10 = 0;
        }
        return i10 != list.size();
    }

    @Override // ja.d
    public int h(c cVar) {
        if (cVar == null) {
            return 0;
        }
        return (int) this.f7628a.a().insert("settings", null, j(cVar));
    }

    public final ContentValues j(c cVar) {
        ContentValues contentValues = new ContentValues();
        if (cVar == null) {
            return contentValues;
        }
        if (cVar.d() > 0) {
            contentValues.put(Name.MARK, Integer.valueOf(cVar.d()));
        }
        contentValues.put("title", cVar.g());
        contentValues.put("content", cVar.a());
        contentValues.put("note", cVar.f());
        contentValues.put("flag", Integer.valueOf(cVar.c()));
        contentValues.put("type", Integer.valueOf(cVar.h()));
        contentValues.put("updated_at", Long.valueOf(cVar.e()));
        contentValues.put("created_at", Long.valueOf(cVar.b()));
        return contentValues;
    }

    public final c k(Cursor cursor) {
        if (cursor != null && !cursor.isClosed()) {
            try {
                c cVar = new c();
                cVar.r(cursor.getInt(cursor.getColumnIndexOrThrow(Name.MARK)));
                cVar.u(cursor.getString(cursor.getColumnIndexOrThrow("title")));
                cVar.o(cursor.getString(cursor.getColumnIndexOrThrow("content")));
                cVar.t(cursor.getString(cursor.getColumnIndexOrThrow("note")));
                cVar.q(cursor.getInt(cursor.getColumnIndexOrThrow("flag")));
                cVar.v(cursor.getInt(cursor.getColumnIndexOrThrow("type")));
                cVar.s(cursor.getLong(cursor.getColumnIndexOrThrow("updated_at")));
                cVar.p(cursor.getLong(cursor.getColumnIndexOrThrow("created_at")));
                return cVar;
            } catch (Exception e10) {
                pc.a.i(e10);
            }
        }
        return null;
    }
}
