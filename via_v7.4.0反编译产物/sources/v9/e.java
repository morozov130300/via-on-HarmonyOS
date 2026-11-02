package v9;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.simpleframework.xml.strategy.Name;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class e extends SQLiteOpenHelper implements h {
    public e(Context context) {
        super(context, "pass", (SQLiteDatabase.CursorFactory) null, 1);
    }

    @Override // v9.h
    public boolean a(String str) {
        return (str == null || str.isEmpty() || n().delete("pass", "id=?", new String[]{str}) <= 0) ? false : true;
    }

    @Override // v9.h
    public List b(String[] strArr) {
        ArrayList arrayList = new ArrayList();
        if (strArr != null && strArr.length != 0) {
            SQLiteDatabase sQLiteDatabaseN = n();
            StringBuilder sb2 = new StringBuilder();
            for (String str : strArr) {
                if (str != null && !str.isEmpty()) {
                    if (sb2.length() > 0) {
                        sb2.append(" or ");
                    }
                    if (str.charAt(0) == '.') {
                        sb2.append("substr(");
                        sb2.append("name");
                        sb2.append(", -");
                        sb2.append(str.length());
                        sb2.append(") = '");
                        sb2.append(str);
                        sb2.append('\'');
                    } else {
                        sb2.append("name");
                        sb2.append(" = '");
                        sb2.append(str);
                        sb2.append('\'');
                    }
                }
            }
            try {
                Cursor cursorQuery = sQLiteDatabaseN.query("pass", null, sb2.toString(), null, null, null, "created_at ASC");
                while (cursorQuery.moveToNext()) {
                    try {
                        arrayList.add(o(cursorQuery));
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

    @Override // v9.h
    public String d(String str, String str2) {
        String string = null;
        if (str != null && !str.isEmpty() && str2 != null && !str2.isEmpty()) {
            try {
                Cursor cursorQuery = n().query("pass", new String[]{Name.MARK}, "name = ? and username = ?", new String[]{str, str2}, null, null, null, "1");
                try {
                    if (cursorQuery.moveToNext()) {
                        string = cursorQuery.getString(0);
                    }
                    cursorQuery.close();
                    return string;
                } finally {
                }
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
        return string;
    }

    @Override // v9.h
    public List f() {
        ArrayList arrayList = new ArrayList();
        try {
            Cursor cursorQuery = n().query("pass", null, null, null, null, null, "created_at ASC");
            while (cursorQuery.moveToNext()) {
                try {
                    arrayList.add(o(cursorQuery));
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

    @Override // v9.h
    public boolean g(f fVar) {
        if (fVar == null) {
            return false;
        }
        SQLiteDatabase sQLiteDatabaseN = n();
        try {
            sQLiteDatabaseN.beginTransaction();
            sQLiteDatabaseN.delete("pass", "name= ? and username = ?", new String[]{fVar.c(), fVar.h()});
            z = sQLiteDatabaseN.insert("pass", null, m(fVar)) > 0;
            if (z) {
                sQLiteDatabaseN.setTransactionSuccessful();
            }
            return z;
        } catch (Exception e10) {
            pc.a.i(e10);
            return z;
        } finally {
            sQLiteDatabaseN.endTransaction();
        }
    }

    @Override // v9.h
    public f h(String str) {
        f fVarO = null;
        if (str != null && !str.isEmpty()) {
            try {
                Cursor cursorQuery = n().query("pass", null, "id = '" + str + "'", null, null, null, null);
                try {
                    if (cursorQuery.moveToNext()) {
                        fVarO = o(cursorQuery);
                    }
                    cursorQuery.close();
                    return fVarO;
                } finally {
                }
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
        return fVarO;
    }

    @Override // v9.h
    public int i() {
        int i10 = 0;
        try {
            Cursor cursorRawQuery = n().rawQuery("SELECT COUNT(*) FROM pass", null);
            try {
                if (cursorRawQuery.moveToFirst()) {
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

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0047, code lost:
    
        r1.setTransactionSuccessful();
     */
    @Override // v9.h
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean j(List list) {
        if (list == null || list.isEmpty()) {
            return false;
        }
        SQLiteDatabase sQLiteDatabaseN = n();
        try {
            try {
                sQLiteDatabaseN.beginTransaction();
                Iterator it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    f fVar = (f) it.next();
                    sQLiteDatabaseN.delete("pass", "name= ? and username = ?", new String[]{fVar.c(), fVar.h()});
                    if (sQLiteDatabaseN.insert("pass", null, m(fVar)) <= 0) {
                    }
                }
            } catch (Exception e10) {
                pc.a.i(e10);
            }
            return true;
        } finally {
            sQLiteDatabaseN.endTransaction();
        }
    }

    @Override // v9.h
    public List k(String str) {
        ArrayList arrayList = new ArrayList();
        if (str != null && !str.isEmpty()) {
            String str2 = "%" + str + "%";
            try {
                Cursor cursorQuery = n().query("pass", null, "name like ? or username like ?", new String[]{str2, str2}, null, null, "created_at ASC");
                while (cursorQuery.moveToNext()) {
                    try {
                        arrayList.add(o(cursorQuery));
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

    @Override // v9.h
    public boolean l(String str, f fVar) {
        if (str != null && !str.isEmpty() && fVar != null) {
            SQLiteDatabase sQLiteDatabaseN = n();
            ContentValues contentValuesM = m(fVar);
            contentValuesM.remove(Name.MARK);
            if (sQLiteDatabaseN.update("pass", contentValuesM, "id=?", new String[]{str}) > 0) {
                return true;
            }
        }
        return false;
    }

    public final ContentValues m(f fVar) {
        ContentValues contentValues = new ContentValues();
        if (fVar.b() != null) {
            contentValues.put(Name.MARK, fVar.b());
        }
        contentValues.put("name", fVar.c());
        contentValues.put("url", fVar.g());
        contentValues.put("username", fVar.h());
        if (fVar.e() != null) {
            contentValues.put("password", fVar.e());
        }
        contentValues.put("note", fVar.d());
        contentValues.put("updated_at", Long.valueOf(fVar.f()));
        contentValues.put("created_at", Long.valueOf(fVar.a()));
        return contentValues;
    }

    public final SQLiteDatabase n() {
        return getWritableDatabase();
    }

    public final f o(Cursor cursor) {
        f fVar = new f();
        fVar.j(cursor.getString(cursor.getColumnIndex(Name.MARK)));
        fVar.k(cursor.getString(cursor.getColumnIndex("name")));
        fVar.o(cursor.getString(cursor.getColumnIndex("url")));
        fVar.p(cursor.getString(cursor.getColumnIndex("username")));
        fVar.m(cursor.getString(cursor.getColumnIndex("password")));
        fVar.l(cursor.getString(cursor.getColumnIndex("note")));
        fVar.n(cursor.getLong(cursor.getColumnIndex("updated_at")));
        fVar.i(cursor.getLong(cursor.getColumnIndex("created_at")));
        return fVar;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) throws SQLException {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS pass (id TEXT PRIMARY KEY NOT NULL, name TEXT, url TEXT, username TEXT, password TEXT, note TEXT, updated_at INTEGER DEFAULT 0, created_at INTEGER DEFAULT 0);");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
    }
}
