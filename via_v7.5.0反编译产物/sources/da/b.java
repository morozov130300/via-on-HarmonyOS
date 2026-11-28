package da;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import org.simpleframework.xml.strategy.Name;
import x.d;
import x8.g0;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class b implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o9.a f4013a;

    public b(o9.a aVar) {
        this.f4013a = aVar;
    }

    public static void a(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE history(id INTEGER PRIMARY KEY,url TEXT,title TEXT,updated_at INTEGER DEFAULT 0)");
    }

    public static void d(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
        if (i10 < 8) {
            sQLiteDatabase.execSQL("ALTER TABLE history ADD COLUMN updated_at INTEGER DEFAULT 0;");
            ContentValues contentValues = new ContentValues();
            contentValues.put("updated_at", Long.valueOf(System.currentTimeMillis() / 1000));
            sQLiteDatabase.update("history", contentValues, null, null);
        }
    }

    public final l9.b b(Cursor cursor) {
        return l9.b.j(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getLong(3));
    }

    public final String[] c() {
        return new String[]{Name.MARK, "url", "title", "updated_at"};
    }

    @Override // da.a
    public void e(String str) {
        this.f4013a.a().delete("history", "url = ?", new String[]{str});
    }

    @Override // da.a
    public void g(int... iArr) {
        if (iArr == null || iArr.length == 0) {
            return;
        }
        String[] strArr = new String[iArr.length];
        for (int i10 = 0; i10 < iArr.length; i10++) {
            strArr[i10] = String.valueOf(iArr[i10]);
        }
        this.f4013a.a().delete("history", "id in " + g0.e(iArr.length), strArr);
    }

    @Override // da.a
    public List i() {
        ArrayList arrayList = new ArrayList();
        int rawOffset = Calendar.getInstance().getTimeZone().getRawOffset() / 1000;
        long jCurrentTimeMillis = (System.currentTimeMillis() / 1000) - 3600;
        try {
            Cursor cursorRawQuery = this.f4013a.a().rawQuery("select count(id) from history where updated_at >= ?;", new String[]{String.valueOf(jCurrentTimeMillis)});
            while (cursorRawQuery.moveToNext()) {
                try {
                    arrayList.add(new d(Long.valueOf(jCurrentTimeMillis), Integer.valueOf(cursorRawQuery.getInt(0))));
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
            }
            cursorRawQuery.close();
        } catch (Exception e10) {
            tc.a.e(e10);
        }
        try {
            Cursor cursorRawQuery2 = this.f4013a.a().rawQuery("select (updated_at+" + rawOffset + ")/86400 as range_id, count(" + Name.MARK + ") from history group by range_id;", null);
            while (cursorRawQuery2.moveToNext()) {
                try {
                    arrayList.add(new d(Long.valueOf((cursorRawQuery2.getLong(0) * 86400) - ((long) rawOffset)), Integer.valueOf(cursorRawQuery2.getInt(1))));
                } catch (Throwable th3) {
                    if (cursorRawQuery2 != null) {
                        try {
                            cursorRawQuery2.close();
                        } catch (Throwable th4) {
                            th3.addSuppressed(th4);
                        }
                    }
                    throw th3;
                }
            }
            cursorRawQuery2.close();
        } catch (Exception e11) {
            tc.a.e(e11);
        }
        return arrayList;
    }

    @Override // da.a
    public List k(int i10) {
        ArrayList arrayList = new ArrayList();
        try {
            Cursor cursorQuery = this.f4013a.a().query("history", c(), null, null, null, null, "updated_at DESC", String.valueOf(i10));
            while (cursorQuery.moveToNext()) {
                try {
                    arrayList.add(b(cursorQuery));
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

    @Override // da.a
    public List l(String str, int i10) {
        ArrayList arrayList = new ArrayList();
        d dVarD = g0.d(str, "title", "url");
        if (dVarD == null) {
            return arrayList;
        }
        try {
            Cursor cursorQuery = this.f4013a.a().query("history", c(), (String) dVarD.f14455a, (String[]) dVarD.f14456b, null, null, "updated_at desc", i10 <= 0 ? null : String.valueOf(i10));
            while (cursorQuery.moveToNext()) {
                try {
                    arrayList.add(b(cursorQuery));
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

    @Override // da.a
    public int m(long j10) {
        return this.f4013a.a().delete("history", "updated_at >= ?", new String[]{String.valueOf(j10)});
    }

    @Override // da.a
    public void p(int i10) {
        this.f4013a.a().delete("history", "id = ?", new String[]{String.valueOf(i10)});
    }

    @Override // da.a
    public List q(int i10, int i11) {
        ArrayList arrayList = new ArrayList();
        try {
            Cursor cursorQuery = this.f4013a.a().query("history", c(), null, null, null, null, "updated_at DESC", "" + i10 + "," + i11);
            while (cursorQuery.moveToNext()) {
                try {
                    arrayList.add(b(cursorQuery));
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

    @Override // da.a
    public List r() {
        ArrayList arrayList = new ArrayList();
        try {
            Cursor cursorQuery = this.f4013a.a().query("history", c(), null, null, null, null, "updated_at DESC", null);
            while (cursorQuery.moveToNext()) {
                try {
                    arrayList.add(b(cursorQuery));
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

    @Override // da.a
    public void t(String str, String str2) {
        SQLiteDatabase sQLiteDatabaseA = this.f4013a.a();
        try {
            sQLiteDatabaseA.beginTransaction();
            sQLiteDatabaseA.delete("history", "url = ?", new String[]{str});
            ContentValues contentValues = new ContentValues();
            contentValues.put("title", str2);
            contentValues.put("url", str);
            contentValues.put("updated_at", Long.valueOf(System.currentTimeMillis() / 1000));
            sQLiteDatabaseA.insert("history", null, contentValues);
            sQLiteDatabaseA.setTransactionSuccessful();
        } catch (Exception e10) {
            e10.printStackTrace();
        } finally {
            sQLiteDatabaseA.endTransaction();
        }
    }

    @Override // da.a
    public void w() {
        this.f4013a.a().delete("history", null, null);
    }

    @Override // da.a
    public int x(List list) {
        int i10 = 0;
        if (list == null || list.isEmpty()) {
            return 0;
        }
        SQLiteDatabase sQLiteDatabaseA = this.f4013a.a();
        try {
            sQLiteDatabaseA.beginTransaction();
            ContentValues contentValues = new ContentValues();
            long jCurrentTimeMillis = (System.currentTimeMillis() / 1000) - ((long) list.size());
            Iterator it = list.iterator();
            while (it.hasNext()) {
                l9.b bVar = (l9.b) it.next();
                sQLiteDatabaseA.delete("history", "url = ?", new String[]{bVar.g()});
                contentValues.clear();
                contentValues.put("url", bVar.g());
                contentValues.put("title", bVar.e());
                contentValues.put("updated_at", Long.valueOf(bVar.f() == 0 ? jCurrentTimeMillis : bVar.f()));
                jCurrentTimeMillis++;
                if (sQLiteDatabaseA.insert("history", null, contentValues) > 0) {
                    i10++;
                }
            }
            sQLiteDatabaseA.setTransactionSuccessful();
            return i10;
        } catch (Exception e10) {
            e10.printStackTrace();
            return i10;
        } finally {
            sQLiteDatabaseA.endTransaction();
        }
    }
}
