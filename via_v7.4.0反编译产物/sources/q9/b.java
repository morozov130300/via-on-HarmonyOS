package q9;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import o9.g;
import z8.i0;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class b extends SQLiteOpenHelper implements a {

    /* renamed from: e, reason: collision with root package name */
    public static SQLiteDatabase f11333e;

    public b(Context context) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        super(context, "via", (SQLiteDatabase.CursorFactory) null, 11);
        i0.b(4194304);
    }

    @Override // q9.a
    public SQLiteDatabase a() {
        SQLiteDatabase sQLiteDatabase = f11333e;
        if (sQLiteDatabase == null || !sQLiteDatabase.isOpen()) {
            f11333e = getWritableDatabase();
        }
        return f11333e;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) throws SQLException {
        ea.b.a(sQLiteDatabase);
        ga.b.a(sQLiteDatabase);
        fa.b.c(sQLiteDatabase);
        ia.a.a(sQLiteDatabase);
        da.a.f(sQLiteDatabase);
        ja.a.i(sQLiteDatabase);
        g.C(sQLiteDatabase);
        na.c.g(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) throws SQLException {
        ea.b.c(sQLiteDatabase, i10, i11);
        ga.b.d(sQLiteDatabase, i10, i11);
        fa.b.e(sQLiteDatabase, i10, i11);
        ia.a.d(sQLiteDatabase, i10, i11);
        da.a.g(sQLiteDatabase, i10, i11);
        ja.a.l(sQLiteDatabase, i10, i11);
        g.E(sQLiteDatabase, i10, i11);
        na.c.h(sQLiteDatabase, i10, i11);
    }
}
