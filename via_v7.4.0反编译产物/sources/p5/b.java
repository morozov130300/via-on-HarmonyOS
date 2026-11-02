package p5;

import android.content.ContentValues;
import android.content.Context;
import android.database.AbstractWindowedCursor;
import android.database.Cursor;
import android.database.CursorWindow;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import r5.e;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class b extends SQLiteOpenHelper implements d {

    /* renamed from: j, reason: collision with root package name */
    public static final String f10965j = "b";

    /* renamed from: k, reason: collision with root package name */
    public static final String[] f10966k = {"_id", "name", "version", "enabled", "icon_url", "homepage_url", "support_url", "download_url", "last_updated_at", "created_at"};

    /* renamed from: l, reason: collision with root package name */
    public static final String[] f10967l = {"_id", "script_id", "content", "matches", "exclude_matches", "includes", "excludes", "run_at", "requires", "resources", "grant", "flags", "enabled", "user_overrides"};

    /* renamed from: e, reason: collision with root package name */
    public String f10968e;

    public b(Context context) {
        super(context, "monkey", (SQLiteDatabase.CursorFactory) null, 3);
        this.f10968e = null;
        File externalFilesDir = context.getExternalFilesDir("gm");
        File file = new File(externalFilesDir == null ? new File(context.getFilesDir(), "gm") : externalFilesDir, "resources");
        if (file.exists() || file.mkdirs()) {
            this.f10968e = file.getAbsolutePath();
            s5.d.a(f10965j, "resource directory: " + this.f10968e);
        }
        s5.d.a(f10965j, "local script data source construct");
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

    @Override // p5.d
    public r5.b J(int i10) {
        r5.b bVarJ0 = null;
        try {
            Cursor cursorQuery = getReadableDatabase().query("scripts", f10967l, "_id = " + i10, null, null, null, "LENGTH(content) ASC");
            try {
                c0(cursorQuery);
                if (cursorQuery.moveToNext()) {
                    bVarJ0 = j0(cursorQuery);
                }
                cursorQuery.close();
                return bVarJ0;
            } finally {
            }
        } catch (Exception e10) {
            e10.printStackTrace();
            return bVarJ0;
        }
    }

    @Override // p5.d
    public boolean W(String str) {
        File fileH0 = h0(str);
        if (fileH0 == null) {
            return false;
        }
        if (fileH0.exists() && fileH0.length() > 0 && fileH0.lastModified() < System.currentTimeMillis() - 1296000000) {
            s5.d.a(f10965j, "resource exists and valid for: " + str);
            return true;
        }
        String str2 = f10965j;
        s5.d.a(str2, "download resource: " + str);
        File file = new File(fileH0.getParent(), fileH0.getName() + ".tmp");
        boolean zC = s5.b.c(str, file);
        if (zC) {
            b0(fileH0);
            zC = file.renameTo(fileH0);
        } else {
            b0(file);
        }
        s5.d.a(str2, "download resource: " + str + ", result: " + zC);
        return zC;
    }

    @Override // p5.d
    public boolean a(String str, String str2) {
        return getWritableDatabase().delete("variables", "script_id = ? AND name = ?", new String[]{str, str2}) > 0;
    }

    @Override // p5.d
    public boolean b(int i10, e eVar) {
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

    public final void c0(Cursor cursor) {
        if (Build.VERSION.SDK_INT < 28 || !(cursor instanceof AbstractWindowedCursor)) {
            return;
        }
        ((AbstractWindowedCursor) cursor).setWindow(new CursorWindow("test", 8388608L));
    }

    @Override // p5.d
    public void d(String str, String str2, String str3) {
        if (str == null || str.isEmpty() || str2 == null || str2.isEmpty()) {
            return;
        }
        a(str, str2);
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

    public final ContentValues d0(r5.a aVar) {
        ContentValues contentValues = new ContentValues();
        if (aVar == null) {
            return contentValues;
        }
        contentValues.putAll(f0(aVar.d()));
        contentValues.putAll(e0(aVar.a()));
        return contentValues;
    }

    public final ContentValues e0(r5.b bVar) {
        ContentValues contentValues = new ContentValues();
        if (bVar == null) {
            return contentValues;
        }
        if (bVar.g() > 0) {
            contentValues.put("_id", Integer.valueOf(bVar.g()));
        }
        contentValues.put("script_id", bVar.m());
        contentValues.put("content", bVar.b() == null ? "" : bVar.b());
        contentValues.put("matches", bVar.i());
        contentValues.put("exclude_matches", bVar.c());
        contentValues.put("includes", bVar.h());
        contentValues.put("excludes", bVar.d());
        contentValues.put("run_at", Integer.valueOf(bVar.l()));
        contentValues.put("requires", bVar.j());
        contentValues.put("resources", bVar.k());
        contentValues.put("enabled", Integer.valueOf(bVar.o() ? 1 : 0));
        contentValues.put("grant", Integer.valueOf(bVar.f()));
        contentValues.put("flags", Integer.valueOf(bVar.e()));
        contentValues.put("user_overrides", bVar.n());
        return contentValues;
    }

    @Override // p5.d
    public String f(String str, String str2) {
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
                } finally {
                }
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
        return strM0;
    }

    public final ContentValues f0(r5.c cVar) {
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

    @Override // p5.d
    public String g(int i10) {
        String string = null;
        try {
            Cursor cursorQuery = getReadableDatabase().query("scripts", new String[]{"content"}, "_id = " + i10, null, null, null, null);
            try {
                c0(cursorQuery);
                if (cursorQuery.moveToNext()) {
                    string = cursorQuery.getString(0);
                }
                cursorQuery.close();
                return string;
            } finally {
            }
        } catch (Exception e10) {
            e10.printStackTrace();
            return string;
        }
    }

    public final ContentValues g0(String str, String str2, String str3) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("script_id", str);
        contentValues.put("name", str2);
        contentValues.put("value", str3);
        return contentValues;
    }

    @Override // p5.d
    public int h(r5.a aVar) {
        s5.d.a(f10965j, "add script: " + aVar);
        if (aVar == null) {
            return 0;
        }
        return (int) getWritableDatabase().insert("scripts", null, d0(aVar));
    }

    public final File h0(String str) {
        String str2 = this.f10968e;
        if (str2 == null || str2.isEmpty() || str == null || str.isEmpty()) {
            return null;
        }
        return new File(this.f10968e, i0(str));
    }

    @Override // p5.d
    public r5.c i(String str, String str2) {
        String[] strArr;
        String str3;
        r5.c cVarK0 = null;
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
                Cursor cursorQuery = getReadableDatabase().query("scripts", f10966k, str3, strArr, null, null, null);
                try {
                    if (cursorQuery.moveToNext()) {
                        cVarK0 = k0(cursorQuery);
                    }
                    cursorQuery.close();
                    return cVarK0;
                } finally {
                }
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
        return cVarK0;
    }

    public final String i0(String str) {
        return s5.c.a(str);
    }

    @Override // p5.d
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
                } finally {
                }
            }
            cursorQuery.close();
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    public final r5.b j0(Cursor cursor) {
        if (cursor != null && !cursor.isClosed()) {
            try {
                r5.b bVar = new r5.b();
                bVar.v(cursor.getInt(cursor.getColumnIndexOrThrow("_id")));
                bVar.B(cursor.getString(cursor.getColumnIndexOrThrow("script_id")));
                bVar.p(cursor.getString(cursor.getColumnIndexOrThrow("content")));
                bVar.x(cursor.getString(cursor.getColumnIndexOrThrow("matches")));
                bVar.r(cursor.getString(cursor.getColumnIndexOrThrow("exclude_matches")));
                bVar.w(cursor.getString(cursor.getColumnIndexOrThrow("includes")));
                bVar.s(cursor.getString(cursor.getColumnIndexOrThrow("excludes")));
                bVar.A(cursor.getInt(cursor.getColumnIndexOrThrow("run_at")));
                bVar.y(cursor.getString(cursor.getColumnIndexOrThrow("requires")));
                bVar.z(cursor.getString(cursor.getColumnIndexOrThrow("resources")));
                boolean z10 = true;
                if (cursor.getInt(cursor.getColumnIndexOrThrow("enabled")) != 1) {
                    z10 = false;
                }
                bVar.q(z10);
                bVar.u(cursor.getInt(cursor.getColumnIndexOrThrow("grant")));
                bVar.t(cursor.getInt(cursor.getColumnIndexOrThrow("flags")));
                bVar.C(cursor.getString(cursor.getColumnIndexOrThrow("user_overrides")));
                return bVar;
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
        return null;
    }

    @Override // p5.d
    public r5.c k(int i10) {
        r5.c cVarK0 = null;
        try {
            Cursor cursorQuery = getReadableDatabase().query("scripts", f10966k, "_id = " + i10, null, null, null, null);
            try {
                if (cursorQuery.moveToNext()) {
                    cVarK0 = k0(cursorQuery);
                }
                cursorQuery.close();
                return cVarK0;
            } finally {
            }
        } catch (Exception e10) {
            e10.printStackTrace();
            return cVarK0;
        }
    }

    public final r5.c k0(Cursor cursor) {
        if (cursor != null && !cursor.isClosed()) {
            try {
                r5.c cVar = new r5.c();
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

    @Override // p5.d
    public boolean l(int i10, boolean z10) {
        s5.d.a(f10965j, "set script enabled, script: " + i10 + ", enalbed: " + z10);
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
            } finally {
            }
        } catch (Exception e10) {
            e10.printStackTrace();
            return string;
        }
    }

    @Override // p5.d
    public e m(int i10) {
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
            } finally {
            }
        } catch (Exception e10) {
            e10.printStackTrace();
            return null;
        }
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

    @Override // p5.d
    public e n(int i10) {
        return e.a(l0(i10));
    }

    @Override // p5.d
    public List o() {
        ArrayList arrayList = new ArrayList();
        try {
            Cursor cursorQuery = getReadableDatabase().query("scripts", f10966k, null, null, null, null, "created_at DESC");
            while (cursorQuery.moveToNext()) {
                try {
                    r5.c cVarK0 = k0(cursorQuery);
                    if (cVarK0 != null) {
                        arrayList.add(cVarK0);
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

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) throws SQLException {
        s5.d.a(f10965j, "local script data source on create");
        sQLiteDatabase.execSQL("CREATE TABLE scripts (_id INTEGER PRIMARY KEY, script_id TEXT NOT NULL, name TEXT, version TEXT, content TEXT NOT NULL, matches TEXT, exclude_matches TEXT, includes TEXT, excludes TEXT, run_at INTEGER DEFAULT 0, requires TEXT, resources TEXT, enabled INTEGER DEFAULT 0, flags INTEGER DEFAULT 0, grant INTEGER DEFAULT 0, icon_url TEXT, homepage_url TEXT, support_url TEXT, download_url TEXT, user_overrides TEXT, last_updated_at INTEGER DEFAULT 0, created_at INTEGER DEFAULT 0);");
        sQLiteDatabase.execSQL("CREATE TABLE variables (_id INTEGER PRIMARY KEY, script_id TEXT NOT NULL, name TEXT NOT NULL, value TEXT);");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) throws SQLException {
        s5.d.a(f10965j, "local script data source on upgrade");
        if (i10 <= 1) {
            sQLiteDatabase.execSQL("ALTER TABLE scripts ADD COLUMN grant INTEGER;");
            sQLiteDatabase.execSQL("UPDATE scripts SET grant = " + String.valueOf(268435455));
        }
        if (i10 <= 2) {
            sQLiteDatabase.execSQL("ALTER TABLE scripts ADD COLUMN user_overrides TEXT;");
        }
    }

    @Override // p5.d
    public boolean p(int i10, r5.a aVar) {
        if (i10 > 0 && aVar != null) {
            ContentValues contentValuesD0 = d0(aVar);
            contentValuesD0.remove("created_at");
            if (aVar.a() == null || aVar.a().n() == null) {
                contentValuesD0.remove("user_overrides");
                aVar.a().C(l0(i10));
            }
            if (getWritableDatabase().update("scripts", contentValuesD0, "_id = " + i10, null) > 0) {
                return true;
            }
        }
        return false;
    }

    @Override // p5.d
    public r5.c q(String str) {
        r5.c cVarK0 = null;
        try {
            Cursor cursorQuery = getReadableDatabase().query("scripts", f10966k, "script_id = ?", new String[]{str}, null, null, null);
            try {
                if (cursorQuery.moveToNext()) {
                    cVarK0 = k0(cursorQuery);
                }
                cursorQuery.close();
                return cVarK0;
            } finally {
            }
        } catch (Exception e10) {
            e10.printStackTrace();
            return cVarK0;
        }
    }

    @Override // p5.d
    public boolean r(int i10) {
        if (i10 <= 0) {
            return false;
        }
        SQLiteDatabase writableDatabase = getWritableDatabase();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("_id = ");
        sb2.append(i10);
        return writableDatabase.delete("scripts", sb2.toString(), null) > 0;
    }

    @Override // p5.d
    public List s() {
        ArrayList arrayList = new ArrayList();
        try {
            Cursor cursorQuery = getReadableDatabase().query("scripts", f10967l, null, null, null, null, "LENGTH(content) ASC");
            try {
                c0(cursorQuery);
                while (cursorQuery.moveToNext()) {
                    r5.b bVarJ0 = j0(cursorQuery);
                    if (bVarJ0 != null) {
                        s5.d.a(f10965j, "query db for: " + bVarJ0.m());
                        arrayList.add(bVarJ0);
                    }
                }
                cursorQuery.close();
                return arrayList;
            } finally {
            }
        } catch (Exception e10) {
            e10.printStackTrace();
            return arrayList;
        }
    }

    @Override // p5.d
    public byte[] t(String str) throws UnsupportedEncodingException {
        byte[] bArrG = s5.b.g(str);
        return bArrG.length > 0 ? bArrG : s5.b.j(h0(str));
    }

    @Override // p5.d
    public boolean u(Set set) {
        String str = this.f10968e;
        if (str == null || str.isEmpty()) {
            return false;
        }
        File file = new File(this.f10968e);
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
            int i10 = 0;
            for (File file2 : fileArrListFiles) {
                if (!hashSet.contains(file2.getName()) && !b0(file2)) {
                    i10++;
                }
            }
            if (i10 == 0) {
                return true;
            }
        }
        return false;
    }

    @Override // p5.d
    public boolean v(String str) {
        return (str == null || str.isEmpty() || getWritableDatabase().delete("variables", "script_id = ?", new String[]{str}) <= 0) ? false : true;
    }

    @Override // p5.d
    public String w(String str) {
        if (str == null || str.length() < 4 || !"http".equals(str.substring(0, 4).toLowerCase(Locale.ROOT))) {
            return null;
        }
        return h0(str).getAbsolutePath();
    }

    @Override // p5.d
    public String x(String str) throws UnsupportedEncodingException {
        String strH = s5.b.h(str);
        return strH != null ? strH : s5.b.i(h0(str));
    }
}
