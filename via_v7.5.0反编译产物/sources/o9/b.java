package o9;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import m9.g;
import x8.g0;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class b extends SQLiteOpenHelper implements a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static SQLiteDatabase f10976c;

    public b(Context context) {
        super(context, "via", (SQLiteDatabase.CursorFactory) null, 11);
        g0.b(4194304);
    }

    @Override // o9.a
    public SQLiteDatabase a() {
        SQLiteDatabase sQLiteDatabase = f10976c;
        if (sQLiteDatabase == null || !sQLiteDatabase.isOpen()) {
            f10976c = getWritableDatabase();
        }
        return f10976c;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        ba.b.a(sQLiteDatabase);
        da.b.a(sQLiteDatabase);
        ca.b.c(sQLiteDatabase);
        fa.a.a(sQLiteDatabase);
        aa.a.f(sQLiteDatabase);
        ga.a.i(sQLiteDatabase);
        g.C(sQLiteDatabase);
        ka.c.g(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
        ba.b.c(sQLiteDatabase, i10, i11);
        da.b.d(sQLiteDatabase, i10, i11);
        ca.b.e(sQLiteDatabase, i10, i11);
        fa.a.d(sQLiteDatabase, i10, i11);
        aa.a.g(sQLiteDatabase, i10, i11);
        ga.a.l(sQLiteDatabase, i10, i11);
        g.E(sQLiteDatabase, i10, i11);
        ka.c.h(sQLiteDatabase, i10, i11);
    }
}
