package p9;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.List;
import org.simpleframework.xml.strategy.Name;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class w extends SQLiteOpenHelper implements p {
    public w(Context context) {
        super(context, "copilot", (SQLiteDatabase.CursorFactory) null, 4);
    }

    public final l J(Cursor cursor) {
        l lVar = new l();
        lVar.l(cursor.getString(cursor.getColumnIndex(Name.MARK)));
        lVar.p(cursor.getString(cursor.getColumnIndex("name")));
        lVar.r(cursor.getString(cursor.getColumnIndex("url")));
        lVar.m(cursor.getString(cursor.getColumnIndex("token")));
        lVar.o(g6.p.o(cursor.getString(cursor.getColumnIndex("models")), ','));
        lVar.k(cursor.getInt(cursor.getColumnIndex("flags")));
        lVar.q(cursor.getLong(cursor.getColumnIndex("updated_at")));
        lVar.j(cursor.getLong(cursor.getColumnIndex("created_at")));
        return lVar;
    }

    public final ContentValues W(l lVar) {
        ContentValues contentValues = new ContentValues();
        if (lVar.d() != null) {
            contentValues.put(Name.MARK, lVar.d());
        }
        contentValues.put("name", lVar.g());
        contentValues.put("url", lVar.i());
        contentValues.put("token", lVar.e());
        contentValues.put("models", g6.p.g(',', lVar.f()));
        contentValues.put("flags", Integer.valueOf(lVar.c()));
        contentValues.put("updated_at", Long.valueOf(lVar.h()));
        contentValues.put("created_at", Long.valueOf(lVar.a()));
        return contentValues;
    }

    @Override // p9.p
    public boolean a(String str) {
        return e0().delete("messages", "thread_id = ? and role != ?", new String[]{str, "system"}) > 0;
    }

    @Override // p9.p
    public l b(String str) {
        l lVarJ = null;
        try {
            Cursor cursorQuery = e0().query("backends", null, "id = '" + str + "'", null, null, null, null);
            try {
                if (cursorQuery.moveToNext()) {
                    lVarJ = J(cursorQuery);
                }
                cursorQuery.close();
                return lVarJ;
            } finally {
            }
        } catch (Exception e10) {
            e10.printStackTrace();
            return lVarJ;
        }
    }

    public final ContentValues b0(n nVar) {
        ContentValues contentValues = new ContentValues();
        if (nVar.e() != null) {
            contentValues.put(Name.MARK, nVar.e());
        }
        contentValues.put("thread_id", nVar.h());
        contentValues.put("content", g6.p.m(nVar.b()));
        contentValues.put("reasoning", nVar.f());
        contentValues.put("role", nVar.g());
        contentValues.put("flags", Integer.valueOf(nVar.d()));
        contentValues.put("updated_at", Long.valueOf(nVar.i()));
        return contentValues;
    }

    public final ContentValues c0(q qVar) {
        ContentValues contentValues = new ContentValues();
        if (qVar.d() != null) {
            contentValues.put(Name.MARK, qVar.d());
        }
        contentValues.put("name", qVar.e());
        contentValues.put("content", qVar.a());
        contentValues.put("required", g6.p.g(',', qVar.f()));
        contentValues.put("type", Integer.valueOf(qVar.g()));
        contentValues.put("flags", Integer.valueOf(qVar.c()));
        contentValues.put("updated_at", Long.valueOf(qVar.h()));
        contentValues.put("created_at", Long.valueOf(qVar.b()));
        return contentValues;
    }

    @Override // p9.p
    public boolean d(String str, l lVar) {
        SQLiteDatabase sQLiteDatabaseE0 = e0();
        ContentValues contentValuesW = W(lVar);
        contentValuesW.remove(Name.MARK);
        return sQLiteDatabaseE0.update("backends", contentValuesW, "id=?", new String[]{str}) > 0;
    }

    public final ContentValues d0(r rVar) {
        ContentValues contentValues = new ContentValues();
        if (rVar.c() != null) {
            contentValues.put(Name.MARK, rVar.c());
        }
        contentValues.put("name", rVar.d());
        contentValues.put("preview", rVar.e());
        contentValues.put("flags", Integer.valueOf(rVar.b()));
        contentValues.put("updated_at", Long.valueOf(rVar.f()));
        contentValues.put("created_at", Long.valueOf(rVar.a()));
        return contentValues;
    }

    public final SQLiteDatabase e0() {
        return getWritableDatabase();
    }

    @Override // p9.p
    public boolean f(n nVar) {
        return e0().insert("messages", null, b0(nVar)) > 0;
    }

    public final n f0(Cursor cursor) {
        n nVar = new n();
        nVar.n(cursor.getString(cursor.getColumnIndex(Name.MARK)));
        nVar.q(cursor.getString(cursor.getColumnIndex("thread_id")));
        nVar.k(cursor.getString(cursor.getColumnIndex("content")));
        nVar.o(cursor.getString(cursor.getColumnIndex("reasoning")));
        nVar.p(cursor.getString(cursor.getColumnIndex("role")));
        nVar.m(cursor.getInt(cursor.getColumnIndex("flags")));
        nVar.r(cursor.getLong(cursor.getColumnIndex("updated_at")));
        return nVar;
    }

    @Override // p9.p
    public List g(int i10) {
        ArrayList arrayList = new ArrayList();
        try {
            Cursor cursorQuery = e0().query("suggestions", null, "type = ?", new String[]{String.valueOf(i10)}, null, null, "created_at ASC");
            while (cursorQuery.moveToNext()) {
                try {
                    arrayList.add(g0(cursorQuery));
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

    public final q g0(Cursor cursor) {
        q qVar = new q();
        qVar.o(cursor.getString(cursor.getColumnIndex(Name.MARK)));
        qVar.p(cursor.getString(cursor.getColumnIndex("name")));
        qVar.l(cursor.getString(cursor.getColumnIndex("content")));
        qVar.q(g6.p.o(cursor.getString(cursor.getColumnIndex("required")), ','));
        qVar.r(cursor.getInt(cursor.getColumnIndex("type")));
        qVar.n(cursor.getInt(cursor.getColumnIndex("flags")));
        qVar.s(cursor.getLong(cursor.getColumnIndex("updated_at")));
        qVar.m(cursor.getLong(cursor.getColumnIndex("created_at")));
        return qVar;
    }

    @Override // p9.p
    public boolean h(String[] strArr) {
        SQLiteDatabase sQLiteDatabaseE0 = e0();
        try {
            try {
                sQLiteDatabaseE0.beginTransaction();
                int iDelete = 0;
                for (String str : strArr) {
                    iDelete = iDelete + sQLiteDatabaseE0.delete("threads", "id=?", new String[]{str}) + sQLiteDatabaseE0.delete("messages", "thread_id=?", new String[]{str});
                }
                if (iDelete > 0) {
                    sQLiteDatabaseE0.setTransactionSuccessful();
                    sQLiteDatabaseE0.endTransaction();
                    return true;
                }
            } catch (Exception e10) {
                pc.a.i(e10);
            }
            sQLiteDatabaseE0.endTransaction();
            return false;
        } catch (Throwable th) {
            sQLiteDatabaseE0.endTransaction();
            throw th;
        }
    }

    public final r h0(Cursor cursor) {
        r rVar = new r();
        rVar.i(cursor.getString(cursor.getColumnIndex(Name.MARK)));
        rVar.j(cursor.getString(cursor.getColumnIndex("name")));
        rVar.k(cursor.getString(cursor.getColumnIndex("preview")));
        rVar.h(cursor.getInt(cursor.getColumnIndex("flags")));
        rVar.l(cursor.getLong(cursor.getColumnIndex("updated_at")));
        rVar.g(cursor.getLong(cursor.getColumnIndex("created_at")));
        return rVar;
    }

    @Override // p9.p
    public boolean i(String str, n nVar) {
        SQLiteDatabase sQLiteDatabaseE0 = e0();
        ContentValues contentValuesB0 = b0(nVar);
        contentValuesB0.remove(Name.MARK);
        return sQLiteDatabaseE0.update("messages", contentValuesB0, "id=?", new String[]{str}) > 0;
    }

    @Override // p9.p
    public boolean j(String str) {
        return e0().delete("messages", "id=?", new String[]{str}) > 0;
    }

    @Override // p9.p
    public boolean k(String str) {
        return e0().delete("backends", "id=?", new String[]{str}) > 0;
    }

    @Override // p9.p
    public List l() {
        ArrayList arrayList = new ArrayList();
        try {
            Cursor cursorQuery = e0().query("threads", null, null, null, null, null, "updated_at DESC");
            while (cursorQuery.moveToNext()) {
                try {
                    arrayList.add(h0(cursorQuery));
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

    @Override // p9.p
    public n m(String str) {
        n nVarF0 = null;
        try {
            Cursor cursorQuery = e0().query("messages", null, "id = '" + str + "'", null, null, null, null);
            try {
                if (cursorQuery.moveToNext()) {
                    nVarF0 = f0(cursorQuery);
                }
                cursorQuery.close();
                return nVarF0;
            } finally {
            }
        } catch (Exception e10) {
            e10.printStackTrace();
            return nVarF0;
        }
    }

    @Override // p9.p
    public r n(String str) {
        r rVarH0 = null;
        try {
            Cursor cursorQuery = e0().query("threads", null, "id = '" + str + "'", null, null, null, null);
            try {
                if (cursorQuery.moveToNext()) {
                    rVarH0 = h0(cursorQuery);
                }
                cursorQuery.close();
                return rVarH0;
            } finally {
            }
        } catch (Exception e10) {
            e10.printStackTrace();
            return rVarH0;
        }
    }

    @Override // p9.p
    public boolean o(l lVar) {
        return e0().insert("backends", null, W(lVar)) > 0;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) throws SQLException {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS backends (id TEXT PRIMARY KEY NOT NULL, name TEXT NOT NULL, url TEXT NOT NULL, token TEXT NOT NULL, models TEXT, flags INTEGER DEFAULT 0, updated_at INTEGER DEFAULT 0, created_at INTEGER DEFAULT 0);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS threads (id TEXT PRIMARY KEY NOT NULL, name TEXT, preview TEXT, flags INTEGER DEFAULT 0, updated_at INTEGER DEFAULT 0, created_at INTEGER DEFAULT 0);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS messages (id TEXT PRIMARY KEY NOT NULL, thread_id TEXT NOT NULL, content TEXT NOT NULL, reasoning TEXT, role TEXT NOT NULL, flags INTEGER DEFAULT 0, updated_at INTEGER DEFAULT 0);");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS suggestions (id TEXT PRIMARY KEY NOT NULL, name TEXT, content TEXT, vendors TEXT, required TEXT, type INTEGER DEFAULT 0, flags INTEGER DEFAULT 0, updated_at INTEGER DEFAULT 0, created_at INTEGER DEFAULT 0);");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) throws SQLException {
        if (i10 <= 1) {
            sQLiteDatabase.execSQL("ALTER TABLE messages ADD COLUMN reasoning TEXT;");
        }
        if (i10 <= 2) {
            sQLiteDatabase.execSQL("ALTER TABLE backends RENAME model1 TO models;");
        }
        if (i10 <= 3) {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS suggestions (id TEXT PRIMARY KEY NOT NULL, name TEXT, content TEXT, vendors TEXT, required TEXT, type INTEGER DEFAULT 0, flags INTEGER DEFAULT 0, updated_at INTEGER DEFAULT 0, created_at INTEGER DEFAULT 0);");
        }
    }

    @Override // p9.p
    public List p() {
        ArrayList arrayList = new ArrayList();
        try {
            Cursor cursorQuery = e0().query("backends", null, null, null, null, null, "created_at ASC");
            while (cursorQuery.moveToNext()) {
                try {
                    arrayList.add(J(cursorQuery));
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

    @Override // p9.p
    public boolean q(String str, r rVar) {
        SQLiteDatabase sQLiteDatabaseE0 = e0();
        ContentValues contentValuesD0 = d0(rVar);
        contentValuesD0.remove(Name.MARK);
        return sQLiteDatabaseE0.update("threads", contentValuesD0, "id=?", new String[]{str}) > 0;
    }

    @Override // p9.p
    public List r() {
        ArrayList arrayList = new ArrayList();
        try {
            Cursor cursorQuery = e0().query("suggestions", null, null, null, null, null, "created_at ASC");
            while (cursorQuery.moveToNext()) {
                try {
                    arrayList.add(g0(cursorQuery));
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

    @Override // p9.p
    public boolean s(String str, q qVar) {
        SQLiteDatabase sQLiteDatabaseE0 = e0();
        ContentValues contentValuesC0 = c0(qVar);
        contentValuesC0.remove(Name.MARK);
        return sQLiteDatabaseE0.update("suggestions", contentValuesC0, "id=?", new String[]{str}) > 0;
    }

    @Override // p9.p
    public boolean t(q qVar) {
        return e0().insert("suggestions", null, c0(qVar)) > 0;
    }

    @Override // p9.p
    public boolean u(String str) {
        return e0().delete("suggestions", "id= ?", new String[]{str}) > 0;
    }

    @Override // p9.p
    public q v(String str) {
        q qVarG0 = null;
        try {
            Cursor cursorQuery = e0().query("suggestions", null, "id = '" + str + "'", null, null, null, null);
            try {
                if (cursorQuery.moveToNext()) {
                    qVarG0 = g0(cursorQuery);
                }
                cursorQuery.close();
                return qVarG0;
            } finally {
            }
        } catch (Exception e10) {
            e10.printStackTrace();
            return qVarG0;
        }
    }

    @Override // p9.p
    public boolean w(r rVar) {
        return e0().insert("threads", null, d0(rVar)) > 0;
    }

    @Override // p9.p
    public List x(String str) {
        ArrayList arrayList = new ArrayList();
        try {
            Cursor cursorQuery = e0().query("messages", null, "thread_id = '" + str + "'", null, null, null, "updated_at ASC");
            while (cursorQuery.moveToNext()) {
                try {
                    arrayList.add(f0(cursorQuery));
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
}
