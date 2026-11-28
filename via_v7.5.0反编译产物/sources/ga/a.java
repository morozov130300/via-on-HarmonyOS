package ga;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.simpleframework.xml.strategy.Name;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class a implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o9.a f5593a;

    public a(o9.a aVar) {
        this.f5593a = aVar;
    }

    public static void i(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE settings(id INTEGER PRIMARY KEY,title TEXT,content TEXT,note TEXT,flag INTEGER DEFAULT 0,type INTEGER DEFAULT 0,updated_at INTEGER DEFAULT 0,created_at INTEGER DEFAULT 0)");
    }

    public static void l(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
        if (i10 <= 8) {
            sQLiteDatabase.execSQL("CREATE TABLE settings(id INTEGER PRIMARY KEY,title TEXT,content TEXT,note TEXT,flag INTEGER DEFAULT 0,type INTEGER DEFAULT 0,updated_at INTEGER DEFAULT 0,created_at INTEGER DEFAULT 0)");
        }
    }

    @Override // ga.d
    public boolean a(int i10) {
        SQLiteDatabase sQLiteDatabaseA = this.f5593a.a();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("id = ");
        sb2.append(i10);
        return sQLiteDatabaseA.delete("settings", sb2.toString(), null) > 0;
    }

    @Override // ga.d
    public List b(int i10) {
        ArrayList arrayList = new ArrayList();
        try {
            Cursor cursorQuery = this.f5593a.a().query("settings", null, "type = " + i10, null, null, null, null);
            while (cursorQuery.moveToNext()) {
                try {
                    c cVarK = k(cursorQuery);
                    if (cVarK != null) {
                        arrayList.add(cVarK);
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

    @Override // ga.d
    public c c(int i10) {
        c cVarK = null;
        try {
            Cursor cursorQuery = this.f5593a.a().query("settings", null, "id = " + i10, null, null, null, null, "1");
            try {
                if (cursorQuery.moveToNext()) {
                    cVarK = k(cursorQuery);
                }
                cursorQuery.close();
                return cVarK;
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
            e10.printStackTrace();
            return cVarK;
        }
    }

    @Override // ga.d
    public int d(c cVar) {
        if (cVar == null) {
            return 0;
        }
        return (int) this.f5593a.a().insert("settings", null, j(cVar));
    }

    @Override // ga.d
    public List e() {
        ArrayList arrayList = new ArrayList();
        try {
            Cursor cursorQuery = this.f5593a.a().query("settings", null, null, null, null, null, null);
            while (cursorQuery.moveToNext()) {
                try {
                    c cVarK = k(cursorQuery);
                    if (cVarK != null) {
                        arrayList.add(cVarK);
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

    @Override // ga.d
    public boolean f(int i10, c cVar) {
        SQLiteDatabase sQLiteDatabaseA = this.f5593a.a();
        ContentValues contentValuesJ = j(cVar);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("id = ");
        sb2.append(i10);
        return sQLiteDatabaseA.update("settings", contentValuesJ, sb2.toString(), null) > 0;
    }

    @Override // ga.d
    public c g(String str, int i10) {
        if (str != null && !str.isEmpty()) {
            try {
                Cursor cursorQuery = this.f5593a.a().query("settings", null, "type = ? and content = ?", new String[]{String.valueOf(i10), str}, null, null, null, "1");
                try {
                    if (cursorQuery.moveToFirst()) {
                        c cVarK = k(cursorQuery);
                        cursorQuery.close();
                        return cVarK;
                    }
                    cursorQuery.close();
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
            }
            tc.a.j(e10);
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:63:0x00d4 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:64:0x00d6 A[ORIG_RETURN, RETURN] */
    @Override // ga.d
    public boolean h(List list) {
        int i10;
        String str;
        int i11 = 0;
        if (list == null || list.isEmpty()) {
            return false;
        }
        SQLiteDatabase sQLiteDatabaseA = this.f5593a.a();
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
                                    try {
                                        Cursor cursorQuery = sQLiteDatabaseA.query("settings", new String[]{"content"}, "type = ? and content = ?", new String[]{String.valueOf(cVar.h()), cVar.a()}, null, null, null, "1");
                                        try {
                                            if (cursorQuery.moveToFirst()) {
                                                cursorQuery.close();
                                            } else {
                                                cursorQuery.close();
                                                sQLiteDatabaseA.delete(str, "content = ?", new String[]{cVar.a()});
                                            }
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
                                    } catch (Exception e10) {
                                        e = e10;
                                        tc.a.j(e);
                                    }
                                } catch (Exception e11) {
                                    e = e11;
                                    str = "settings";
                                }
                            } else {
                                str = "settings";
                            }
                            try {
                                if (sQLiteDatabaseA.insert(str, null, j(cVar)) > 0) {
                                    i10++;
                                }
                            } catch (Exception e12) {
                                e = e12;
                                e.printStackTrace();
                                sQLiteDatabaseA.endTransaction();
                                if (i10 == list.size()) {
                                    return true;
                                }
                                return false;
                            }
                        }
                        i11 = 0;
                    } catch (Exception e13) {
                        e = e13;
                    }
                }
                sQLiteDatabaseA.setTransactionSuccessful();
            } catch (Throwable th3) {
                sQLiteDatabaseA.endTransaction();
                throw th3;
            }
        } catch (Exception e14) {
            e = e14;
            i10 = 0;
        }
        sQLiteDatabaseA.endTransaction();
        if (i10 == list.size()) {
            return true;
        }
        return false;
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
                tc.a.j(e10);
            }
        }
        return null;
    }
}
