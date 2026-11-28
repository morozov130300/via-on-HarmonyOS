package fa;

import android.content.ContentValues;
import android.database.AbstractWindowedCursor;
import android.database.Cursor;
import android.database.CursorWindow;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import la.s;
import org.simpleframework.xml.strategy.Name;
import u9.l;
import x8.g0;
import x8.p2;
import x8.v0;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class a implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o9.a f4577a;

    public a(o9.a aVar) {
        this.f4577a = aVar;
    }

    public static void a(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE addons(id INTEGER PRIMARY KEY,oid INTEGER,name TEXT,author TEXT,url TEXT,info TEXT,code LONGTEXT,flag INTEGER DEFAULT 0)");
    }

    public static void d(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
        if (i10 <= 1) {
            sQLiteDatabase.execSQL("CREATE TABLE addons(id INTEGER PRIMARY KEY,oid INTEGER,name TEXT,author TEXT,url TEXT,info TEXT,code LONGTEXT)");
        }
        if (i10 <= 5) {
            sQLiteDatabase.execSQL("ALTER TABLE addons ADD COLUMN flag INTEGER DEFAULT 0");
            l lVarJ = s.j();
            int[] iArrR1 = lVarJ == null ? new int[0] : lVarJ.r1();
            if (iArrR1.length > 0) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("flag", (Integer) 1);
                String[] strArr = new String[iArrR1.length];
                for (int i12 = 0; i12 < iArrR1.length; i12++) {
                    strArr[i12] = String.valueOf(iArrR1[i12]);
                }
                sQLiteDatabase.update("addons", contentValues, "id in " + g0.e(iArrR1.length), strArr);
                lVarJ.P1(new int[0]);
            }
        }
    }

    public final void b(Cursor cursor) {
        if (cursor == null || cursor.isClosed()) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 28 && (cursor instanceof AbstractWindowedCursor)) {
            ((AbstractWindowedCursor) cursor).setWindow(new CursorWindow("largeWindow", 10485760L));
            return;
        }
        try {
            Field declaredField = CursorWindow.class.getDeclaredField("sCursorWindowSize");
            declaredField.setAccessible(true);
            declaredField.set(null, 5242880);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    @Override // fa.c
    public void c() {
        this.f4577a.a().delete("addons", null, null);
    }

    @Override // fa.c
    public List v() {
        ArrayList arrayList = new ArrayList();
        try {
            Cursor cursorQuery = this.f4577a.a().query("addons", new String[]{Name.MARK, "oid", "url", "name", "flag", "code"}, null, null, null, null, "id desc");
            try {
                b(cursorQuery);
                while (cursorQuery.moveToNext()) {
                    String string = cursorQuery.getString(3);
                    String string2 = cursorQuery.getString(5);
                    l9.a aVar = new l9.a();
                    aVar.u(cursorQuery.getString(2));
                    aVar.n(string2);
                    if (string == null || string.isEmpty()) {
                        string = p2.a(v0.a(string2));
                    }
                    aVar.r(string);
                    aVar.p(cursorQuery.getInt(0));
                    aVar.s(cursorQuery.getInt(1));
                    aVar.o(cursorQuery.getInt(4));
                    arrayList.add(aVar);
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
}
