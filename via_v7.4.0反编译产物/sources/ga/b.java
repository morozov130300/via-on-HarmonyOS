package ga;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import org.simpleframework.xml.strategy.Name;
import w.d;
import z8.i0;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class b implements a {

    /* renamed from: a, reason: collision with root package name */
    public final q9.a f6307a;

    public b(q9.a aVar) {
        this.f6307a = aVar;
    }

    public static void a(SQLiteDatabase sQLiteDatabase) throws SQLException {
        sQLiteDatabase.execSQL("CREATE TABLE history(id INTEGER PRIMARY KEY,url TEXT,title TEXT,updated_at INTEGER DEFAULT 0)");
    }

    public static void d(SQLiteDatabase sQLiteDatabase, int i10, int i11) throws SQLException {
        if (i10 < 8) {
            sQLiteDatabase.execSQL("ALTER TABLE history ADD COLUMN updated_at INTEGER DEFAULT 0;");
            ContentValues contentValues = new ContentValues();
            contentValues.put("updated_at", Long.valueOf(System.currentTimeMillis() / 1000));
            sQLiteDatabase.update("history", contentValues, null, null);
        }
    }

    public final n9.b b(Cursor cursor) {
        return n9.b.j(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getLong(3));
    }

    public final String[] c() {
        return new String[]{Name.MARK, "url", "title", "updated_at"};
    }

    @Override // ga.a
    public void e(String str) {
        this.f6307a.a().delete("history", "url = ?", new String[]{str});
    }

    @Override // ga.a
    public void g(int... iArr) {
        if (iArr == null || iArr.length == 0) {
            return;
        }
        String[] strArr = new String[iArr.length];
        for (int i10 = 0; i10 < iArr.length; i10++) {
            strArr[i10] = String.valueOf(iArr[i10]);
        }
        this.f6307a.a().delete("history", "id in " + i0.e(iArr.length), strArr);
    }

    @Override // ga.a
    public List i() {
        Cursor cursorRawQuery;
        ArrayList arrayList = new ArrayList();
        int rawOffset = Calendar.getInstance().getTimeZone().getRawOffset() / 1000;
        long jCurrentTimeMillis = (System.currentTimeMillis() / 1000) - 3600;
        try {
            cursorRawQuery = this.f6307a.a().rawQuery("select count(id) from history where updated_at >= ?;", new String[]{String.valueOf(jCurrentTimeMillis)});
            while (cursorRawQuery.moveToNext()) {
                try {
                    arrayList.add(new d(Long.valueOf(jCurrentTimeMillis), Integer.valueOf(cursorRawQuery.getInt(0))));
                } finally {
                }
            }
            cursorRawQuery.close();
        } catch (Exception e10) {
            pc.a.d(e10);
        }
        try {
            cursorRawQuery = this.f6307a.a().rawQuery("select (updated_at+" + rawOffset + ")/86400 as range_id, count(" + Name.MARK + ") from history group by range_id;", null);
            while (cursorRawQuery.moveToNext()) {
                try {
                    arrayList.add(new d(Long.valueOf((cursorRawQuery.getLong(0) * 86400) - rawOffset), Integer.valueOf(cursorRawQuery.getInt(1))));
                } finally {
                }
            }
            cursorRawQuery.close();
        } catch (Exception e11) {
            pc.a.d(e11);
        }
        return arrayList;
    }

    @Override // ga.a
    public List k(int i10) {
        ArrayList arrayList = new ArrayList();
        try {
            Cursor cursorQuery = this.f6307a.a().query("history", c(), null, null, null, null, "updated_at DESC", String.valueOf(i10));
            while (cursorQuery.moveToNext()) {
                try {
                    arrayList.add(b(cursorQuery));
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

    @Override // ga.a
    public List l(String str, int i10) {
        ArrayList arrayList = new ArrayList();
        d dVarD = i0.d(str, "title", "url");
        if (dVarD == null) {
            return arrayList;
        }
        try {
            Cursor cursorQuery = this.f6307a.a().query("history", c(), (String) dVarD.f13207a, (String[]) dVarD.f13208b, null, null, "updated_at desc", i10 <= 0 ? null : String.valueOf(i10));
            while (cursorQuery.moveToNext()) {
                try {
                    arrayList.add(b(cursorQuery));
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

    @Override // ga.a
    public int m(long j10) {
        return this.f6307a.a().delete("history", "updated_at >= ?", new String[]{String.valueOf(j10)});
    }

    @Override // ga.a
    public void p(int i10) {
        this.f6307a.a().delete("history", "id = ?", new String[]{String.valueOf(i10)});
    }

    @Override // ga.a
    public List q(int i10, int i11) {
        ArrayList arrayList = new ArrayList();
        try {
            Cursor cursorQuery = this.f6307a.a().query("history", c(), null, null, null, null, "updated_at DESC", "" + i10 + "," + i11);
            while (cursorQuery.moveToNext()) {
                try {
                    arrayList.add(b(cursorQuery));
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

    @Override // ga.a
    public List r() {
        ArrayList arrayList = new ArrayList();
        try {
            Cursor cursorQuery = this.f6307a.a().query("history", c(), null, null, null, null, "updated_at DESC", null);
            while (cursorQuery.moveToNext()) {
                try {
                    arrayList.add(b(cursorQuery));
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

    @Override // ga.a
    public void t(String str, String str2) {
        SQLiteDatabase sQLiteDatabaseA = this.f6307a.a();
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

    @Override // ga.a
    public void w() {
        this.f6307a.a().delete("history", null, null);
    }

    @Override // ga.a
    public int x(List list) {
        int i10 = 0;
        if (list == null || list.isEmpty()) {
            return 0;
        }
        SQLiteDatabase sQLiteDatabaseA = this.f6307a.a();
        try {
            try {
                sQLiteDatabaseA.beginTransaction();
                ContentValues contentValues = new ContentValues();
                long jCurrentTimeMillis = (System.currentTimeMillis() / 1000) - list.size();
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    n9.b bVar = (n9.b) it.next();
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
                sQLiteDatabaseA.endTransaction();
                return i10;
            } catch (Exception e10) {
                e10.printStackTrace();
                sQLiteDatabaseA.endTransaction();
                return i10;
            }
        } catch (Throwable th) {
            sQLiteDatabaseA.endTransaction();
            throw th;
        }
    }
}
