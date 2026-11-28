package qa;

import android.content.ContentValues;
import android.content.Context;
import android.database.AbstractWindowedCursor;
import android.database.Cursor;
import android.database.CursorWindow;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDoneException;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.os.Build;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import ra.e;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class b extends SQLiteOpenHelper implements d {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String[] f11850e = {"_id", "name", "version", "enabled", "icon_url", "homepage_url", "support_url", "download_url", "last_updated_at", "created_at"};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f11851c;

    public b(Context context) {
        super(context, "monkey", (SQLiteDatabase.CursorFactory) null, 3);
        this.f11851c = null;
        File externalFilesDir = context.getExternalFilesDir("gm");
        File file = new File(externalFilesDir == null ? new File(context.getFilesDir(), "gm") : externalFilesDir, "resources");
        if (file.exists() || file.mkdirs()) {
            this.f11851c = file.getAbsolutePath();
            tc.a.a("resource directory: " + this.f11851c, new Object[0]);
        }
        tc.a.a("local script data source construct", new Object[0]);
    }

    public static boolean b0(File file) {
        File[] fileArrListFiles;
        if (file == null || !file.exists()) {
            return true;
        }
        if (file.isDirectory() && (fileArrListFiles = file.listFiles()) != null && fileArrListFiles.length > 0) {
            for (File file2 : fileArrListFiles) {
                if (!b0(file2)) {
                    return false;
                }
            }
        }
        return file.delete();
    }

    public static String[] p0(String str) {
        return new String[]{"_id", "script_id", str, "matches", "exclude_matches", "includes", "excludes", "run_at", "requires", "resources", "grant", "flags", "enabled", "user_overrides"};
    }

    @Override // qa.d
    public List J() {
        return o0(null);
    }

    @Override // qa.d
    public boolean W(String str) {
        return ua.a.b(str, h0(str));
    }

    @Override // qa.d
    public int a(ra.a aVar) {
        tc.a.a("Add script: %s", aVar.d());
        return (int) getWritableDatabase().insert("scripts", null, d0(aVar));
    }

    @Override // qa.d
    public boolean b(String str, String str2) {
        return getWritableDatabase().delete("variables", "script_id = ? AND name = ?", new String[]{str, str2}) > 0;
    }

    @Override // qa.d
    public void c(String str, String str2, String str3) {
        if (str == null || str.isEmpty() || str2 == null || str2.isEmpty()) {
            return;
        }
        b(str, str2);
        if (str3 == null || str3.isEmpty()) {
            return;
        }
        SQLiteDatabase writableDatabase = getWritableDatabase();
        try {
            writableDatabase.beginTransaction();
            writableDatabase.delete("variables", "script_id = ? AND name = ?", new String[]{str, str2});
            writableDatabase.insert("variables", null, g0(str, str2, str3));
            writableDatabase.setTransactionSuccessful();
        } catch (Exception e10) {
            e10.printStackTrace();
        } finally {
            writableDatabase.endTransaction();
        }
    }

    public final void c0(Cursor cursor) {
        if (Build.VERSION.SDK_INT < 28 || !(cursor instanceof AbstractWindowedCursor)) {
            return;
        }
        ((AbstractWindowedCursor) cursor).setWindow(new CursorWindow("test", 8388608L));
    }

    public final ContentValues d0(ra.a aVar) {
        ContentValues contentValues = new ContentValues();
        if (aVar == null) {
            return contentValues;
        }
        contentValues.putAll(f0(aVar.c()));
        contentValues.putAll(e0(aVar.a()));
        return contentValues;
    }

    @Override // qa.d
    public String e(String str, String str2) {
        String strM0 = null;
        if (str != null && !str.isEmpty() && str2 != null && !str2.isEmpty()) {
            try {
                Cursor cursorQuery = getReadableDatabase().query("variables", new String[]{"value"}, "script_id = ? AND name = ?", new String[]{str, str2}, null, null, null, null);
                try {
                    if (cursorQuery.moveToNext()) {
                        strM0 = m0(cursorQuery);
                    }
                    cursorQuery.close();
                    return strM0;
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
            }
        }
        return strM0;
    }

    public final ContentValues e0(ra.b bVar) {
        ContentValues contentValues = new ContentValues();
        if (bVar == null) {
            return contentValues;
        }
        if (bVar.f() > 0) {
            contentValues.put("_id", Integer.valueOf(bVar.f()));
        }
        contentValues.put("script_id", bVar.l());
        contentValues.put("content", bVar.a() == null ? "" : bVar.a());
        contentValues.put("matches", bVar.h());
        contentValues.put("exclude_matches", bVar.b());
        contentValues.put("includes", bVar.g());
        contentValues.put("excludes", bVar.c());
        contentValues.put("run_at", Integer.valueOf(bVar.k()));
        contentValues.put("requires", bVar.i());
        contentValues.put("resources", bVar.j());
        contentValues.put("enabled", Integer.valueOf(bVar.n() ? 1 : 0));
        contentValues.put("grant", Integer.valueOf(bVar.e()));
        contentValues.put("flags", Integer.valueOf(bVar.d()));
        contentValues.put("user_overrides", bVar.m());
        return contentValues;
    }

    @Override // qa.d
    public String f(int i10) {
        try {
            SQLiteStatement sQLiteStatementCompileStatement = getReadableDatabase().compileStatement("SELECT content FROM scripts WHERE _id = ?");
            try {
                sQLiteStatementCompileStatement.bindLong(1, i10);
                String strSimpleQueryForString = sQLiteStatementCompileStatement.simpleQueryForString();
                sQLiteStatementCompileStatement.close();
                return strSimpleQueryForString;
            } catch (Throwable th) {
                if (sQLiteStatementCompileStatement != null) {
                    try {
                        sQLiteStatementCompileStatement.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        } catch (SQLiteDoneException unused) {
            return null;
        } catch (Exception e10) {
            e10.printStackTrace();
            return null;
        }
    }

    public final ContentValues f0(ra.c cVar) {
        ContentValues contentValues = new ContentValues();
        if (cVar == null) {
            return contentValues;
        }
        if (cVar.e() > 0) {
            contentValues.put("_id", Integer.valueOf(cVar.e()));
        }
        contentValues.put("name", cVar.g());
        contentValues.put("version", cVar.i());
        contentValues.put("enabled", Integer.valueOf(cVar.j() ? 1 : 0));
        contentValues.put("icon_url", cVar.d());
        contentValues.put("homepage_url", cVar.c());
        contentValues.put("download_url", cVar.b());
        contentValues.put("last_updated_at", Long.valueOf(cVar.f()));
        contentValues.put("created_at", Long.valueOf(cVar.a()));
        return contentValues;
    }

    @Override // qa.d
    public ra.d g(int i10) {
        List listO0 = o0("_id = " + i10);
        if (listO0.isEmpty()) {
            return null;
        }
        return (ra.d) listO0.get(0);
    }

    public final ContentValues g0(String str, String str2, String str3) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("script_id", str);
        contentValues.put("name", str2);
        contentValues.put("value", str3);
        return contentValues;
    }

    @Override // qa.d
    public ra.c h(String str, String str2) {
        String[] strArr;
        String str3;
        ra.c cVarK0 = null;
        if ((str != null && !str.isEmpty()) || (str2 != null && !str2.isEmpty())) {
            if (str == null || str.isEmpty()) {
                strArr = new String[]{str2};
                str3 = "download_url = ?";
            } else if (str2 == null || str2.isEmpty()) {
                strArr = new String[]{str};
                str3 = "script_id = ?";
            } else {
                strArr = new String[]{str, str2};
                str3 = "script_id = ? OR download_url = ?";
            }
            try {
                Cursor cursorQuery = getReadableDatabase().query("scripts", f11850e, str3, strArr, null, null, null);
                try {
                    if (cursorQuery.moveToNext()) {
                        cVarK0 = k0(cursorQuery);
                    }
                    cursorQuery.close();
                    return cVarK0;
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
            }
        }
        return cVarK0;
    }

    public final File h0(String str) {
        String str2 = this.f11851c;
        if (str2 == null || str2.isEmpty() || str == null || str.isEmpty()) {
            return null;
        }
        return new File(this.f11851c, i0(str));
    }

    public final String i0(String str) {
        return ua.b.a(str);
    }

    @Override // qa.d
    public String[] j(String str) {
        if (str == null || str.isEmpty()) {
            return new String[0];
        }
        ArrayList arrayList = new ArrayList();
        try {
            Cursor cursorQuery = getReadableDatabase().query("variables", new String[]{"name"}, "script_id = ?", new String[]{str}, null, null, null, null);
            while (cursorQuery.moveToNext()) {
                try {
                    String string = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("name"));
                    if (string != null && !string.isEmpty()) {
                        arrayList.add(string);
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
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    public final ra.b j0(Cursor cursor) {
        if (cursor != null && !cursor.isClosed()) {
            try {
                ra.b bVar = new ra.b();
                bVar.u(cursor.getInt(cursor.getColumnIndexOrThrow("_id")));
                bVar.A(cursor.getString(cursor.getColumnIndexOrThrow("script_id")));
                int columnIndex = cursor.getColumnIndex("content");
                if (columnIndex >= 0) {
                    bVar.o(cursor.getString(columnIndex));
                }
                bVar.w(cursor.getString(cursor.getColumnIndexOrThrow("matches")));
                bVar.q(cursor.getString(cursor.getColumnIndexOrThrow("exclude_matches")));
                bVar.v(cursor.getString(cursor.getColumnIndexOrThrow("includes")));
                bVar.r(cursor.getString(cursor.getColumnIndexOrThrow("excludes")));
                bVar.z(cursor.getInt(cursor.getColumnIndexOrThrow("run_at")));
                bVar.x(cursor.getString(cursor.getColumnIndexOrThrow("requires")));
                bVar.y(cursor.getString(cursor.getColumnIndexOrThrow("resources")));
                boolean z10 = true;
                if (cursor.getInt(cursor.getColumnIndexOrThrow("enabled")) != 1) {
                    z10 = false;
                }
                bVar.p(z10);
                bVar.t(cursor.getInt(cursor.getColumnIndexOrThrow("grant")));
                bVar.s(cursor.getInt(cursor.getColumnIndexOrThrow("flags")));
                bVar.B(cursor.getString(cursor.getColumnIndexOrThrow("user_overrides")));
                return bVar;
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
        return null;
    }

    @Override // qa.d
    public ra.c k(int i10) {
        ra.c cVarK0 = null;
        try {
            Cursor cursorQuery = getReadableDatabase().query("scripts", f11850e, "_id = " + i10, null, null, null, null);
            try {
                if (cursorQuery.moveToNext()) {
                    cVarK0 = k0(cursorQuery);
                }
                cursorQuery.close();
                return cVarK0;
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
            return cVarK0;
        }
    }

    public final ra.c k0(Cursor cursor) {
        if (cursor != null && !cursor.isClosed()) {
            try {
                ra.c cVar = new ra.c();
                cVar.q(cursor.getInt(cursor.getColumnIndexOrThrow("_id")));
                cVar.t(cursor.getString(cursor.getColumnIndexOrThrow("name")));
                cVar.v(cursor.getString(cursor.getColumnIndexOrThrow("version")));
                boolean z10 = true;
                if (cursor.getInt(cursor.getColumnIndexOrThrow("enabled")) != 1) {
                    z10 = false;
                }
                cVar.n(z10);
                cVar.p(cursor.getString(cursor.getColumnIndexOrThrow("icon_url")));
                cVar.o(cursor.getString(cursor.getColumnIndexOrThrow("homepage_url")));
                cVar.m(cursor.getString(cursor.getColumnIndexOrThrow("download_url")));
                cVar.s(cursor.getLong(cursor.getColumnIndexOrThrow("last_updated_at")));
                cVar.l(cursor.getLong(cursor.getColumnIndexOrThrow("created_at")));
                return cVar;
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
        return null;
    }

    @Override // qa.d
    public boolean l(int i10, boolean z10) {
        tc.a.a("set script enabled, script: " + i10 + ", enalbed: " + z10, new Object[0]);
        if (i10 <= 0) {
            return false;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("enabled", Integer.valueOf(z10 ? 1 : 0));
        SQLiteDatabase writableDatabase = getWritableDatabase();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("_id = ");
        sb2.append(i10);
        return writableDatabase.update("scripts", contentValues, sb2.toString(), null) > 0;
    }

    public String l0(int i10) {
        String string = null;
        try {
            Cursor cursorQuery = getReadableDatabase().query("scripts", new String[]{"user_overrides"}, "_id = " + i10, null, null, null, null);
            try {
                if (cursorQuery.moveToNext()) {
                    string = cursorQuery.getString(0);
                }
                cursorQuery.close();
                return string;
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
            return string;
        }
    }

    @Override // qa.d
    public boolean m(int i10, e eVar) {
        if (i10 <= 0) {
            return false;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("user_overrides", e.l(eVar));
        SQLiteDatabase writableDatabase = getWritableDatabase();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("_id = ");
        sb2.append(i10);
        return writableDatabase.update("scripts", contentValues, sb2.toString(), null) > 0;
    }

    public final String m0(Cursor cursor) {
        if (cursor != null && !cursor.isClosed()) {
            try {
                return cursor.getString(cursor.getColumnIndexOrThrow("value"));
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
        return null;
    }

    @Override // qa.d
    public e n(int i10) {
        try {
            Cursor cursorQuery = getReadableDatabase().query("scripts", new String[]{"run_at", "matches", "exclude_matches", "includes", "excludes"}, "_id = " + i10, null, null, null, null);
            try {
                if (!cursorQuery.moveToNext()) {
                    cursorQuery.close();
                    return null;
                }
                e eVar = new e();
                eVar.k(cursorQuery.getInt(0));
                eVar.j(cursorQuery.getString(1));
                eVar.g(cursorQuery.getString(2));
                eVar.i(cursorQuery.getString(3));
                eVar.h(cursorQuery.getString(4));
                cursorQuery.close();
                return eVar;
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
            return null;
        }
        e10.printStackTrace();
        return null;
    }

    public int n0(int i10) {
        int i11;
        int iD;
        if (i10 >= 1) {
            return i10;
        }
        SQLiteDatabase writableDatabase = getWritableDatabase();
        writableDatabase.beginTransaction();
        try {
            Cursor cursorQuery = writableDatabase.query("scripts", new String[]{"_id", "content", "flags", "download_url"}, null, null, null, null, "LENGTH(content) ASC");
            try {
                c0(cursorQuery);
                while (cursorQuery.moveToNext()) {
                    ra.a aVarE = ra.a.e(cursorQuery.getString(1), cursorQuery.getString(3));
                    if (aVarE != null && (iD = (aVarE.a().d() & 2) | (i11 = cursorQuery.getInt(2))) != i11) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("flags", Integer.valueOf(iD));
                        writableDatabase.update("scripts", contentValues, "_id = ?", new String[]{cursorQuery.getString(0)});
                    }
                }
                cursorQuery.close();
                writableDatabase.setTransactionSuccessful();
                writableDatabase.endTransaction();
                return 1;
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
        } catch (Throwable th3) {
            writableDatabase.endTransaction();
            throw th3;
        }
    }

    @Override // qa.d
    public e o(int i10) {
        return e.a(l0(i10));
    }

    public final List o0(String str) {
        ArrayList arrayList = new ArrayList();
        try {
            Cursor cursorQuery = getReadableDatabase().query("scripts", p0("length(CAST(content AS BLOB)) AS content_size"), str, null, null, null, "LENGTH(content) ASC");
            try {
                c0(cursorQuery);
                int columnIndexOrThrow = cursorQuery.getColumnIndexOrThrow("content_size");
                while (cursorQuery.moveToNext()) {
                    ra.d dVarL = ra.d.l(j0(cursorQuery));
                    if (dVarL != null) {
                        dVarL.n(cursorQuery.getInt(columnIndexOrThrow));
                        arrayList.add(dVarL);
                    }
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
            e10.printStackTrace();
            return arrayList;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        tc.a.a("local script data source on create", new Object[0]);
        sQLiteDatabase.execSQL("CREATE TABLE scripts (_id INTEGER PRIMARY KEY, script_id TEXT NOT NULL, name TEXT, version TEXT, content TEXT NOT NULL, matches TEXT, exclude_matches TEXT, includes TEXT, excludes TEXT, run_at INTEGER DEFAULT 0, requires TEXT, resources TEXT, enabled INTEGER DEFAULT 0, flags INTEGER DEFAULT 0, grant INTEGER DEFAULT 0, icon_url TEXT, homepage_url TEXT, support_url TEXT, download_url TEXT, user_overrides TEXT, last_updated_at INTEGER DEFAULT 0, created_at INTEGER DEFAULT 0);");
        sQLiteDatabase.execSQL("CREATE TABLE variables (_id INTEGER PRIMARY KEY, script_id TEXT NOT NULL, name TEXT NOT NULL, value TEXT);");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
        tc.a.a("local script data source on upgrade", new Object[0]);
        if (i10 <= 1) {
            sQLiteDatabase.execSQL("ALTER TABLE scripts ADD COLUMN grant INTEGER;");
            sQLiteDatabase.execSQL("UPDATE scripts SET grant = " + String.valueOf(268435455));
        }
        if (i10 <= 2) {
            sQLiteDatabase.execSQL("ALTER TABLE scripts ADD COLUMN user_overrides TEXT;");
        }
    }

    @Override // qa.d
    public boolean p(int i10, ra.a aVar) {
        if (i10 <= 0 || aVar == null) {
            return false;
        }
        ContentValues contentValuesD0 = d0(aVar);
        contentValuesD0.remove("created_at");
        if (aVar.a() == null || aVar.a().m() == null) {
            contentValuesD0.remove("user_overrides");
            aVar.a().B(l0(i10));
        }
        SQLiteDatabase writableDatabase = getWritableDatabase();
        writableDatabase.beginTransaction();
        try {
            Cursor cursorQuery = writableDatabase.query("scripts", new String[]{"script_id"}, "_id = ?", new String[]{String.valueOf(i10)}, null, null, null);
            try {
                if (!cursorQuery.moveToFirst()) {
                    cursorQuery.close();
                    writableDatabase.endTransaction();
                    return false;
                }
                String string = cursorQuery.getString(0);
                cursorQuery.close();
                if (writableDatabase.update("scripts", contentValuesD0, "_id = " + i10, null) <= 0) {
                    writableDatabase.endTransaction();
                    return false;
                }
                String strD = aVar.d();
                if (!string.equals(strD)) {
                    writableDatabase.delete("variables", "script_id = ? AND name IN (SELECT name FROM variables WHERE script_id = ?)", new String[]{strD, string});
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("script_id", strD);
                    writableDatabase.update("variables", contentValues, "script_id = ?", new String[]{string});
                }
                writableDatabase.setTransactionSuccessful();
                writableDatabase.endTransaction();
                return true;
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
        } catch (Throwable th3) {
            writableDatabase.endTransaction();
            throw th3;
        }
        writableDatabase.endTransaction();
        throw th3;
    }

    @Override // qa.d
    public List q() {
        ArrayList arrayList = new ArrayList();
        try {
            Cursor cursorQuery = getReadableDatabase().query("scripts", f11850e, null, null, null, null, "created_at DESC");
            while (cursorQuery.moveToNext()) {
                try {
                    ra.c cVarK0 = k0(cursorQuery);
                    if (cVarK0 != null) {
                        arrayList.add(cVarK0);
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

    @Override // qa.d
    public ra.c r(String str) {
        ra.c cVarK0 = null;
        try {
            Cursor cursorQuery = getReadableDatabase().query("scripts", f11850e, "script_id = ?", new String[]{str}, null, null, null);
            try {
                if (cursorQuery.moveToNext()) {
                    cVarK0 = k0(cursorQuery);
                }
                cursorQuery.close();
                return cVarK0;
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
            return cVarK0;
        }
    }

    @Override // qa.d
    public boolean s(int i10) {
        if (i10 <= 0) {
            return false;
        }
        SQLiteDatabase writableDatabase = getWritableDatabase();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("_id = ");
        sb2.append(i10);
        return writableDatabase.delete("scripts", sb2.toString(), null) > 0;
    }

    @Override // qa.d
    public byte[] t(String str) {
        byte[] bArrE = ua.a.e(str);
        return bArrE.length > 0 ? bArrE : ua.a.h(h0(str));
    }

    @Override // qa.d
    public boolean u(Set set) {
        int iIndexOf;
        String str = this.f11851c;
        if (str == null || str.isEmpty()) {
            return false;
        }
        File file = new File(this.f11851c);
        if (set == null || set.isEmpty()) {
            boolean zB0 = b0(file);
            file.mkdirs();
            return zB0;
        }
        HashSet hashSet = new HashSet();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            hashSet.add(i0((String) it.next()));
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null && fileArrListFiles.length != 0) {
            long jCurrentTimeMillis = System.currentTimeMillis() - TimeUnit.DAYS.toMillis(1L);
            int i10 = 0;
            for (File file2 : fileArrListFiles) {
                String name = file2.getName();
                if (!hashSet.contains(name) && (((iIndexOf = name.indexOf(46)) <= 0 || !name.endsWith(".tmp") || file2.lastModified() <= jCurrentTimeMillis || !hashSet.contains(name.substring(0, iIndexOf))) && !b0(file2))) {
                    i10++;
                }
            }
            if (i10 == 0) {
                return true;
            }
        }
        return false;
    }

    @Override // qa.d
    public boolean v(String str) {
        return (str == null || str.isEmpty() || getWritableDatabase().delete("variables", "script_id = ?", new String[]{str}) <= 0) ? false : true;
    }

    @Override // qa.d
    public String w(String str) {
        if (str == null || str.length() < 4 || !"http".equals(str.substring(0, 4).toLowerCase(Locale.ROOT))) {
            return null;
        }
        return h0(str).getAbsolutePath();
    }

    @Override // qa.d
    public String x(String str) {
        String strF = ua.a.f(str);
        return strF != null ? strF : ua.a.g(h0(str));
    }
}
