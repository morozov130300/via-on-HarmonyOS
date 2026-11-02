package f5;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
import org.simpleframework.xml.strategy.Name;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class d extends SQLiteOpenHelper implements b {
    public d(Context context) {
        super(context, "downloader", (SQLiteDatabase.CursorFactory) null, 3);
    }

    @Override // f5.b
    public List a() {
        ArrayList arrayList = new ArrayList();
        try {
            Cursor cursorQuery = u().query("tasks", null, null, null, null, null, "id DESC");
            while (cursorQuery.moveToNext()) {
                try {
                    arrayList.add(w(cursorQuery));
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

    @Override // f5.b
    public boolean b(g5.c cVar) {
        SQLiteDatabase sQLiteDatabaseU = u();
        cVar.R(System.currentTimeMillis() / 1000);
        return sQLiteDatabaseU.update("tasks", t(cVar), "id = ?", new String[]{String.valueOf(cVar.j())}) > 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0058 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:42:? A[RETURN, SYNTHETIC] */
    @Override // f5.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean d(List list) {
        int i10;
        SQLiteDatabase sQLiteDatabaseU = u();
        try {
            try {
                sQLiteDatabaseU.beginTransaction();
                Iterator it = list.iterator();
                i10 = 0;
                while (it.hasNext()) {
                    try {
                        g5.c cVar = (g5.c) it.next();
                        if (cVar.j() > 0 && sQLiteDatabaseU.update("tasks", t(cVar), "id = ?", new String[]{String.valueOf(cVar.j())}) > 0) {
                            i10++;
                        }
                    } catch (Exception e10) {
                        e = e10;
                        e.printStackTrace();
                        sQLiteDatabaseU.endTransaction();
                        if (i10 != list.size()) {
                        }
                    }
                }
                sQLiteDatabaseU.setTransactionSuccessful();
            } catch (Throwable th) {
                sQLiteDatabaseU.endTransaction();
                throw th;
            }
        } catch (Exception e11) {
            e = e11;
            i10 = 0;
        }
        sQLiteDatabaseU.endTransaction();
        return i10 != list.size();
    }

    @Override // f5.b
    public List f(int[] iArr) {
        ArrayList arrayList = new ArrayList();
        if (iArr != null && iArr.length > 0) {
            try {
                Cursor cursorQuery = u().query("tasks", null, v(iArr), null, null, null, "created_at ASC");
                while (cursorQuery.moveToNext()) {
                    try {
                        arrayList.add(w(cursorQuery));
                    } finally {
                    }
                }
                cursorQuery.close();
                return arrayList;
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
        return arrayList;
    }

    @Override // f5.b
    public boolean g(long j10) {
        return u().delete("tasks", "id = ?", new String[]{String.valueOf(j10)}) > 0;
    }

    @Override // f5.b
    public long h(g5.c cVar) {
        SQLiteDatabase sQLiteDatabaseU = u();
        long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
        cVar.y(jCurrentTimeMillis);
        cVar.R(jCurrentTimeMillis);
        return sQLiteDatabaseU.insert("tasks", null, t(cVar));
    }

    @Override // f5.b
    public List i(long j10) {
        ArrayList arrayList = new ArrayList();
        try {
            Cursor cursorQuery = u().query("chunks", null, "task_id= ?", new String[]{String.valueOf(j10)}, null, null, null);
            while (cursorQuery.moveToNext()) {
                try {
                    arrayList.add(r(cursorQuery));
                } finally {
                }
            }
            cursorQuery.close();
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return arrayList;
    }

    @Override // f5.b
    public boolean j(int[] iArr) {
        boolean zMoveToNext = false;
        if (iArr != null && iArr.length > 0) {
            try {
                Cursor cursorQuery = u().query("tasks", new String[]{Name.MARK}, v(iArr), null, null, null, null);
                try {
                    zMoveToNext = cursorQuery.moveToNext();
                    cursorQuery.close();
                    return zMoveToNext;
                } finally {
                }
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
        return zMoveToNext;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0044 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
    @Override // f5.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean k(List list) {
        int i10;
        SQLiteDatabase sQLiteDatabaseU = u();
        try {
            try {
                sQLiteDatabaseU.beginTransaction();
                Iterator it = list.iterator();
                i10 = 0;
                while (it.hasNext()) {
                    try {
                        if (sQLiteDatabaseU.insert("chunks", null, s((g5.a) it.next())) > 0) {
                            i10++;
                        }
                    } catch (Exception e10) {
                        e = e10;
                        e.printStackTrace();
                        sQLiteDatabaseU.endTransaction();
                        if (i10 != list.size()) {
                        }
                    }
                }
                sQLiteDatabaseU.setTransactionSuccessful();
            } catch (Exception e11) {
                e = e11;
                i10 = 0;
            }
            sQLiteDatabaseU.endTransaction();
            return i10 != list.size();
        } catch (Throwable th) {
            sQLiteDatabaseU.endTransaction();
            throw th;
        }
    }

    @Override // f5.b
    public g5.c l(long j10) {
        g5.c cVarW = null;
        try {
            Cursor cursorQuery = u().query("tasks", null, "id = ?", new String[]{String.valueOf(j10)}, null, null, null);
            try {
                if (cursorQuery.moveToNext()) {
                    cVarW = w(cursorQuery);
                }
                cursorQuery.close();
                return cVarW;
            } finally {
            }
        } catch (Exception e10) {
            e10.printStackTrace();
            return cVarW;
        }
    }

    @Override // f5.b
    public boolean m(long j10) {
        try {
            u().delete("chunks", "task_id = ?", new String[]{String.valueOf(j10)});
            return true;
        } catch (Exception e10) {
            e10.printStackTrace();
            return true;
        }
    }

    @Override // f5.b
    public boolean n(long j10, long j11) {
        SQLiteDatabase sQLiteDatabaseU = u();
        ContentValues contentValues = new ContentValues();
        contentValues.put("downloaded", Long.valueOf(j11));
        return sQLiteDatabaseU.update("chunks", contentValues, "id = ?", new String[]{String.valueOf(j10)}) > 0;
    }

    @Override // f5.b
    public boolean o(long j10) {
        SQLiteDatabase sQLiteDatabaseU = u();
        ContentValues contentValues = new ContentValues();
        contentValues.put("downloaded", (Integer) 0);
        return sQLiteDatabaseU.update("chunks", contentValues, "task_id = ?", new String[]{String.valueOf(j10)}) > 0;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) throws SQLException {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS tasks (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT NOT NULL, url TEXT, header TEXT, mimetype TEXT, path TEXT, file_uri TEXT, downloaded_size INTEGER, total_size INTEGER, chunks INTEGER, priority INTEGER, state INTEGER, error_message TEXT, flags INTEGER, updated_at INTEGER DEFAULT 0, created_at INTEGER DEFAULT 0 ); ");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS chunks (id INTEGER PRIMARY KEY AUTOINCREMENT, task_id INTEGER, start INTEGER, length INTEGER, downloaded INTEGER, flags INTEGER ); ");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) throws SQLException {
        if (i10 == 1) {
            sQLiteDatabase.execSQL("DELETE FROM tasks");
        } else if (i10 == 2) {
            sQLiteDatabase.execSQL("ALTER TABLE tasks ADD COLUMN error_message Text;");
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS chunks (id INTEGER PRIMARY KEY AUTOINCREMENT, task_id INTEGER, start INTEGER, length INTEGER, downloaded INTEGER, flags INTEGER ); ");
        }
    }

    public final Map p(String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        HashMap map = new HashMap();
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                if (!next.isEmpty()) {
                    map.put(next, jSONObject.isNull(next) ? null : jSONObject.optString(next));
                }
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        if (map.isEmpty()) {
            return null;
        }
        return map;
    }

    public final String q(Map map) {
        if (map == null || map.size() <= 0) {
            return null;
        }
        return new JSONObject(map).toString();
    }

    public final g5.a r(Cursor cursor) {
        g5.a aVar = new g5.a();
        aVar.j(cursor.getLong(cursor.getColumnIndex(Name.MARK)));
        aVar.n(cursor.getLong(cursor.getColumnIndex("task_id")));
        aVar.l(cursor.getLong(cursor.getColumnIndex("start")));
        aVar.k(cursor.getLong(cursor.getColumnIndex(Name.LENGTH)));
        aVar.i(cursor.getLong(cursor.getColumnIndex("downloaded")));
        return aVar;
    }

    public final ContentValues s(g5.a aVar) {
        ContentValues contentValues = new ContentValues();
        if (aVar.d() != 0) {
            contentValues.put(Name.MARK, Long.valueOf(aVar.d()));
        }
        contentValues.put("task_id", Long.valueOf(aVar.h()));
        contentValues.put("start", Long.valueOf(aVar.f()));
        contentValues.put(Name.LENGTH, Long.valueOf(aVar.e()));
        contentValues.put("downloaded", Long.valueOf(aVar.b()));
        contentValues.put("flags", (Integer) 0);
        return contentValues;
    }

    public final ContentValues t(g5.c cVar) {
        ContentValues contentValues = new ContentValues();
        if (cVar.j() != 0) {
            contentValues.put(Name.MARK, Long.valueOf(cVar.j()));
        }
        contentValues.put("name", cVar.l());
        contentValues.put("downloaded_size", Long.valueOf(cVar.c()));
        contentValues.put("total_size", Long.valueOf(cVar.r()));
        contentValues.put("state", Integer.valueOf(cVar.q()));
        contentValues.put("error_message", cVar.d());
        contentValues.put("url", cVar.t());
        contentValues.put("header", q(cVar.i()));
        contentValues.put("chunks", Integer.valueOf(cVar.a()));
        contentValues.put("path", cVar.m());
        contentValues.put("file_uri", cVar.f() == null ? cVar.g() : cVar.f().toString());
        contentValues.put("mimetype", cVar.k());
        contentValues.put("priority", Integer.valueOf(cVar.n()));
        contentValues.put("flags", Integer.valueOf(cVar.h()));
        contentValues.put("created_at", Long.valueOf(cVar.b()));
        contentValues.put("updated_at", Long.valueOf(cVar.s()));
        return contentValues;
    }

    public final SQLiteDatabase u() {
        return getWritableDatabase();
    }

    public final String v(int[] iArr) {
        if (iArr == null || iArr.length == 0) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        if (iArr.length == 1) {
            sb2.append("state");
            sb2.append(" = ");
            sb2.append(iArr[0]);
            return sb2.toString();
        }
        sb2.append("state");
        sb2.append(" in (");
        for (int i10 = 0; i10 < iArr.length; i10++) {
            if (i10 > 0) {
                sb2.append(',');
            }
            sb2.append(iArr[i10]);
        }
        sb2.append(')');
        return sb2.toString();
    }

    public final g5.c w(Cursor cursor) {
        g5.c cVar = new g5.c();
        cVar.H(cursor.getLong(cursor.getColumnIndex(Name.MARK)));
        cVar.J(cursor.getString(cursor.getColumnIndex("name")));
        cVar.z(cursor.getLong(cursor.getColumnIndex("downloaded_size")));
        cVar.Q(cursor.getLong(cursor.getColumnIndex("total_size")));
        cVar.P(cursor.getInt(cursor.getColumnIndex("state")));
        cVar.A(cursor.getString(cursor.getColumnIndex("error_message")));
        cVar.S(cursor.getString(cursor.getColumnIndex("url")));
        cVar.G(p(cursor.getString(cursor.getColumnIndex("header"))));
        cVar.x(cursor.getInt(cursor.getColumnIndex("chunks")));
        cVar.K(cursor.getString(cursor.getColumnIndex("path")));
        String string = cursor.getString(cursor.getColumnIndex("file_uri"));
        cVar.C(string == null ? null : Uri.parse(string));
        cVar.D(string);
        cVar.I(cursor.getString(cursor.getColumnIndex("mimetype")));
        cVar.L(cursor.getInt(cursor.getColumnIndex("priority")));
        cVar.E(cursor.getInt(cursor.getColumnIndex("flags")));
        cVar.y(cursor.getLong(cursor.getColumnIndex("created_at")));
        cVar.R(cursor.getLong(cursor.getColumnIndex("updated_at")));
        return cVar;
    }
}
