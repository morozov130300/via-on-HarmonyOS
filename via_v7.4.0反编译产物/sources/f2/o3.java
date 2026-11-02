package f2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import android.os.Parcel;
import android.os.SystemClock;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.measurement.internal.zzac;
import com.google.android.gms.measurement.internal.zzau;
import com.google.android.gms.measurement.internal.zzlk;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class o3 extends c4 {

    /* renamed from: c, reason: collision with root package name */
    public final n3 f5542c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f5543d;

    public o3(h5 h5Var) {
        super(h5Var);
        Context contextC = this.f5030a.c();
        this.f5030a.z();
        this.f5542c = new n3(this, contextC, "google_app_measurement_local.db");
    }

    @Override // f2.c4
    public final boolean n() {
        return false;
    }

    public final SQLiteDatabase o() {
        if (this.f5543d) {
            return null;
        }
        SQLiteDatabase writableDatabase = this.f5542c.getWritableDatabase();
        if (writableDatabase != null) {
            return writableDatabase;
        }
        this.f5543d = true;
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:119:0x01f6 A[PHI: r9 r11
  0x01f6: PHI (r9v3 int) = (r9v1 int), (r9v1 int), (r9v4 int) binds: [B:110:0x01e4, B:127:0x0213, B:118:0x01f4] A[DONT_GENERATE, DONT_INLINE]
  0x01f6: PHI (r11v7 android.database.sqlite.SQLiteDatabase) = 
  (r11v5 android.database.sqlite.SQLiteDatabase)
  (r11v6 android.database.sqlite.SQLiteDatabase)
  (r11v8 android.database.sqlite.SQLiteDatabase)
 binds: [B:110:0x01e4, B:127:0x0213, B:118:0x01f4] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:131:0x021c  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0221  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List p(int i10) {
        SQLiteDatabase sQLiteDatabaseO;
        Cursor cursorQuery;
        Cursor cursorQuery2;
        long j10;
        String str;
        String[] strArr;
        Parcel parcelObtain;
        zzlk zzlkVarCreateFromParcel;
        zzac zzacVarCreateFromParcel;
        h();
        Cursor cursor = null;
        if (this.f5543d) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (!s()) {
            return arrayList;
        }
        int i11 = 5;
        for (int i12 = 0; i12 < 5; i12++) {
            try {
                sQLiteDatabaseO = o();
                if (sQLiteDatabaseO == null) {
                    this.f5543d = true;
                    return null;
                }
                try {
                    sQLiteDatabaseO.beginTransaction();
                    try {
                        cursorQuery2 = sQLiteDatabaseO.query("messages", new String[]{"rowid"}, "type=?", new String[]{"3"}, null, null, "rowid desc", "1");
                        try {
                            long j11 = -1;
                            if (cursorQuery2.moveToFirst()) {
                                j10 = cursorQuery2.getLong(0);
                                cursorQuery2.close();
                            } else {
                                cursorQuery2.close();
                                j10 = -1;
                            }
                            if (j10 != -1) {
                                str = "rowid<?";
                                strArr = new String[]{String.valueOf(j10)};
                            } else {
                                str = null;
                                strArr = null;
                            }
                            cursorQuery = sQLiteDatabaseO.query("messages", new String[]{"rowid", "type", "entry"}, str, strArr, null, null, "rowid asc", Integer.toString(100));
                            while (cursorQuery.moveToNext()) {
                                try {
                                    j11 = cursorQuery.getLong(0);
                                    int i13 = cursorQuery.getInt(1);
                                    byte[] blob = cursorQuery.getBlob(2);
                                    if (i13 == 0) {
                                        parcelObtain = Parcel.obtain();
                                        try {
                                            try {
                                                parcelObtain.unmarshall(blob, 0, blob.length);
                                                parcelObtain.setDataPosition(0);
                                                zzau zzauVarCreateFromParcel = zzau.CREATOR.createFromParcel(parcelObtain);
                                                if (zzauVarCreateFromParcel != null) {
                                                    arrayList.add(zzauVarCreateFromParcel);
                                                }
                                            } catch (SafeParcelReader.ParseException unused) {
                                                this.f5030a.d().r().a("Failed to load event from local database");
                                                parcelObtain.recycle();
                                            }
                                        } finally {
                                        }
                                    } else if (i13 == 1) {
                                        parcelObtain = Parcel.obtain();
                                        try {
                                            try {
                                                parcelObtain.unmarshall(blob, 0, blob.length);
                                                parcelObtain.setDataPosition(0);
                                                zzlkVarCreateFromParcel = zzlk.CREATOR.createFromParcel(parcelObtain);
                                            } catch (SafeParcelReader.ParseException unused2) {
                                                this.f5030a.d().r().a("Failed to load user property from local database");
                                                parcelObtain.recycle();
                                                zzlkVarCreateFromParcel = null;
                                            }
                                            if (zzlkVarCreateFromParcel != null) {
                                                arrayList.add(zzlkVarCreateFromParcel);
                                            }
                                        } finally {
                                        }
                                    } else if (i13 == 2) {
                                        parcelObtain = Parcel.obtain();
                                        try {
                                            try {
                                                parcelObtain.unmarshall(blob, 0, blob.length);
                                                parcelObtain.setDataPosition(0);
                                                zzacVarCreateFromParcel = zzac.CREATOR.createFromParcel(parcelObtain);
                                            } catch (SafeParcelReader.ParseException unused3) {
                                                this.f5030a.d().r().a("Failed to load conditional user property from local database");
                                                parcelObtain.recycle();
                                                zzacVarCreateFromParcel = null;
                                            }
                                            if (zzacVarCreateFromParcel != null) {
                                                arrayList.add(zzacVarCreateFromParcel);
                                            }
                                        } finally {
                                        }
                                    } else if (i13 == 3) {
                                        this.f5030a.d().w().a("Skipping app launch break");
                                    } else {
                                        this.f5030a.d().r().a("Unknown record type in local database");
                                    }
                                } catch (SQLiteDatabaseLockedException unused4) {
                                    SystemClock.sleep(i11);
                                    i11 += 20;
                                    if (cursorQuery != null) {
                                        cursorQuery.close();
                                    }
                                    if (sQLiteDatabaseO != null) {
                                        sQLiteDatabaseO.close();
                                    }
                                } catch (SQLiteFullException e10) {
                                    e = e10;
                                    this.f5030a.d().r().b("Error reading entries from local database", e);
                                    this.f5543d = true;
                                    if (cursorQuery != null) {
                                        cursorQuery.close();
                                    }
                                    if (sQLiteDatabaseO != null) {
                                    }
                                } catch (SQLiteException e11) {
                                    e = e11;
                                    if (sQLiteDatabaseO != null) {
                                        try {
                                            if (sQLiteDatabaseO.inTransaction()) {
                                                sQLiteDatabaseO.endTransaction();
                                            }
                                        } catch (Throwable th) {
                                            th = th;
                                            cursor = cursorQuery;
                                            if (cursor != null) {
                                                cursor.close();
                                            }
                                            if (sQLiteDatabaseO != null) {
                                                sQLiteDatabaseO.close();
                                            }
                                            throw th;
                                        }
                                    }
                                    this.f5030a.d().r().b("Error reading entries from local database", e);
                                    this.f5543d = true;
                                    if (cursorQuery != null) {
                                        cursorQuery.close();
                                    }
                                    if (sQLiteDatabaseO != null) {
                                    }
                                }
                            }
                            if (sQLiteDatabaseO.delete("messages", "rowid <= ?", new String[]{Long.toString(j11)}) < arrayList.size()) {
                                this.f5030a.d().r().a("Fewer entries removed from local database than expected");
                            }
                            sQLiteDatabaseO.setTransactionSuccessful();
                            sQLiteDatabaseO.endTransaction();
                            cursorQuery.close();
                            sQLiteDatabaseO.close();
                            return arrayList;
                        } catch (Throwable th2) {
                            th = th2;
                            if (cursorQuery2 != null) {
                                cursorQuery2.close();
                            }
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        cursorQuery2 = null;
                    }
                } catch (SQLiteDatabaseLockedException unused5) {
                    cursorQuery = null;
                } catch (SQLiteFullException e12) {
                    e = e12;
                    cursorQuery = null;
                } catch (SQLiteException e13) {
                    e = e13;
                    cursorQuery = null;
                } catch (Throwable th4) {
                    th = th4;
                    if (cursor != null) {
                    }
                    if (sQLiteDatabaseO != null) {
                    }
                    throw th;
                }
            } catch (SQLiteDatabaseLockedException unused6) {
                sQLiteDatabaseO = null;
                cursorQuery = null;
            } catch (SQLiteFullException e14) {
                e = e14;
                sQLiteDatabaseO = null;
                cursorQuery = null;
            } catch (SQLiteException e15) {
                e = e15;
                sQLiteDatabaseO = null;
                cursorQuery = null;
            } catch (Throwable th5) {
                th = th5;
                sQLiteDatabaseO = null;
            }
        }
        this.f5030a.d().w().a("Failed to read events from database in reasonable time");
        return null;
    }

    public final void q() {
        int iDelete;
        h();
        try {
            SQLiteDatabase sQLiteDatabaseO = o();
            if (sQLiteDatabaseO == null || (iDelete = sQLiteDatabaseO.delete("messages", null, null)) <= 0) {
                return;
            }
            this.f5030a.d().v().b("Reset local analytics data. records", Integer.valueOf(iDelete));
        } catch (SQLiteException e10) {
            this.f5030a.d().r().b("Error resetting local analytics data. error", e10);
        }
    }

    public final boolean r() {
        return x(3, new byte[0]);
    }

    public final boolean s() {
        Context contextC = this.f5030a.c();
        this.f5030a.z();
        return contextC.getDatabasePath("google_app_measurement_local.db").exists();
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0066 A[PHI: r4
  0x0066: PHI (r4v3 int) = (r4v1 int), (r4v1 int), (r4v4 int) binds: [B:26:0x005d, B:33:0x007a, B:29:0x0064] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean t() {
        h();
        if (!this.f5543d && s()) {
            int i10 = 5;
            for (int i11 = 0; i11 < 5; i11++) {
                SQLiteDatabase sQLiteDatabase = null;
                try {
                    try {
                        SQLiteDatabase sQLiteDatabaseO = o();
                        if (sQLiteDatabaseO == null) {
                            this.f5543d = true;
                            return false;
                        }
                        sQLiteDatabaseO.beginTransaction();
                        sQLiteDatabaseO.delete("messages", "type == ?", new String[]{Integer.toString(3)});
                        sQLiteDatabaseO.setTransactionSuccessful();
                        sQLiteDatabaseO.endTransaction();
                        sQLiteDatabaseO.close();
                        return true;
                    } catch (SQLiteDatabaseLockedException unused) {
                        SystemClock.sleep(i10);
                        i10 += 20;
                        if (0 != 0) {
                            sQLiteDatabase.close();
                        }
                    }
                } catch (SQLiteFullException e10) {
                    this.f5030a.d().r().b("Error deleting app launch break from local database", e10);
                    this.f5543d = true;
                    if (0 != 0) {
                    }
                } catch (SQLiteException e11) {
                    if (0 != 0) {
                        try {
                            if (sQLiteDatabase.inTransaction()) {
                                sQLiteDatabase.endTransaction();
                            }
                        } catch (Throwable th) {
                            if (0 != 0) {
                                sQLiteDatabase.close();
                            }
                            throw th;
                        }
                    }
                    this.f5030a.d().r().b("Error deleting app launch break from local database", e11);
                    this.f5543d = true;
                    if (0 != 0) {
                        sQLiteDatabase.close();
                    }
                }
            }
            this.f5030a.d().w().a("Error deleting app launch break from local database in reasonable time");
        }
        return false;
    }

    public final boolean u(zzac zzacVar) {
        byte[] bArrE0 = this.f5030a.N().e0(zzacVar);
        if (bArrE0.length <= 131072) {
            return x(2, bArrE0);
        }
        this.f5030a.d().t().a("Conditional user property too long for local database. Sending directly to service");
        return false;
    }

    public final boolean v(zzau zzauVar) {
        Parcel parcelObtain = Parcel.obtain();
        t.a(zzauVar, parcelObtain, 0);
        byte[] bArrMarshall = parcelObtain.marshall();
        parcelObtain.recycle();
        if (bArrMarshall.length <= 131072) {
            return x(0, bArrMarshall);
        }
        this.f5030a.d().t().a("Event is too long for local database. Sending event directly to service");
        return false;
    }

    public final boolean w(zzlk zzlkVar) {
        Parcel parcelObtain = Parcel.obtain();
        sa.a(zzlkVar, parcelObtain, 0);
        byte[] bArrMarshall = parcelObtain.marshall();
        parcelObtain.recycle();
        if (bArrMarshall.length <= 131072) {
            return x(1, bArrMarshall);
        }
        this.f5030a.d().t().a("User property too long for local database. Sending directly to service");
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:104:0x00ff A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:117:0x015e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:119:0x015e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:121:0x015e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0124 A[PHI: r8
  0x0124: PHI (r8v3 android.database.sqlite.SQLiteDatabase) = (r8v2 android.database.sqlite.SQLiteDatabase), (r8v4 android.database.sqlite.SQLiteDatabase) binds: [B:73:0x0122, B:91:0x015b] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x016b  */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r10v18 */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r10v3, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r10v6, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r2v12 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean x(int i10, byte[] bArr) throws Throwable {
        SQLiteDatabase sQLiteDatabaseO;
        ?? RawQuery;
        Cursor cursor;
        boolean z10;
        Cursor cursor2;
        Cursor cursor3;
        h();
        ?? r22 = 0;
        if (this.f5543d) {
            return false;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("type", Integer.valueOf(i10));
        contentValues.put("entry", bArr);
        this.f5030a.z();
        int i11 = 0;
        int i12 = 5;
        for (int i13 = 5; i11 < i13; i13 = 5) {
            Cursor cursor4 = null;
            cursor4 = null;
            cursor = null;
            Cursor cursor5 = null;
            sQLiteDatabase = null;
            SQLiteDatabase sQLiteDatabase = null;
            try {
                sQLiteDatabaseO = o();
                if (sQLiteDatabaseO == null) {
                    this.f5543d = true;
                    return r22;
                }
                try {
                    try {
                        sQLiteDatabaseO.beginTransaction();
                        RawQuery = sQLiteDatabaseO.rawQuery("select count(1) from messages", null);
                        long j10 = 0;
                        if (RawQuery != 0) {
                            try {
                                try {
                                    if (RawQuery.moveToFirst()) {
                                        j10 = RawQuery.getLong(r22);
                                    }
                                } catch (Throwable th) {
                                    th = th;
                                    cursor4 = RawQuery;
                                    if (cursor4 != null) {
                                    }
                                    if (sQLiteDatabaseO != null) {
                                    }
                                    throw th;
                                }
                            } catch (SQLiteDatabaseLockedException unused) {
                                cursor5 = RawQuery;
                                SystemClock.sleep(i12);
                                i12 += 20;
                                if (cursor5 != null) {
                                }
                                if (sQLiteDatabaseO == null) {
                                }
                                i11++;
                                r22 = 0;
                            } catch (SQLiteFullException e10) {
                                e = e10;
                                cursor3 = RawQuery;
                                sQLiteDatabase = sQLiteDatabaseO;
                                cursor = cursor3;
                                this.f5030a.d().r().b("Error writing entry; local database full", e);
                                this.f5543d = true;
                                if (cursor != null) {
                                }
                                if (sQLiteDatabase != null) {
                                }
                                i11++;
                                r22 = 0;
                            } catch (SQLiteException e11) {
                                e = e11;
                                cursor2 = RawQuery;
                                sQLiteDatabase = sQLiteDatabaseO;
                                RawQuery = cursor2;
                                if (sQLiteDatabase != null) {
                                }
                                this.f5030a.d().r().b("Error writing entry to local database", e);
                                this.f5543d = true;
                                if (RawQuery != 0) {
                                }
                                if (sQLiteDatabase != null) {
                                }
                                i11++;
                                r22 = 0;
                            }
                        }
                        if (j10 >= 100000) {
                            this.f5030a.d().r().a("Data loss, local db full");
                            long j11 = 100001 - j10;
                            long jDelete = sQLiteDatabaseO.delete("messages", "rowid in (select rowid from messages order by rowid asc limit ?)", new String[]{Long.toString(j11)});
                            if (jDelete != j11) {
                                try {
                                    try {
                                        z10 = true;
                                    } catch (SQLiteDatabaseLockedException unused2) {
                                        cursor5 = RawQuery;
                                        SystemClock.sleep(i12);
                                        i12 += 20;
                                        if (cursor5 != null) {
                                            cursor5.close();
                                        }
                                        if (sQLiteDatabaseO == null) {
                                            sQLiteDatabaseO.close();
                                        }
                                        i11++;
                                        r22 = 0;
                                    }
                                } catch (SQLiteFullException e12) {
                                    e = e12;
                                    cursor3 = RawQuery;
                                    sQLiteDatabase = sQLiteDatabaseO;
                                    cursor = cursor3;
                                    this.f5030a.d().r().b("Error writing entry; local database full", e);
                                    this.f5543d = true;
                                    if (cursor != null) {
                                        cursor.close();
                                    }
                                    if (sQLiteDatabase != null) {
                                        sQLiteDatabase.close();
                                    }
                                    i11++;
                                    r22 = 0;
                                } catch (SQLiteException e13) {
                                    e = e13;
                                    cursor2 = RawQuery;
                                    sQLiteDatabase = sQLiteDatabaseO;
                                    RawQuery = cursor2;
                                    if (sQLiteDatabase != null) {
                                        try {
                                            if (sQLiteDatabase.inTransaction()) {
                                                sQLiteDatabase.endTransaction();
                                            }
                                        } catch (Throwable th2) {
                                            th = th2;
                                            sQLiteDatabaseO = sQLiteDatabase;
                                            cursor4 = RawQuery;
                                            if (cursor4 != null) {
                                                cursor4.close();
                                            }
                                            if (sQLiteDatabaseO != null) {
                                                sQLiteDatabaseO.close();
                                            }
                                            throw th;
                                        }
                                    }
                                    this.f5030a.d().r().b("Error writing entry to local database", e);
                                    this.f5543d = true;
                                    if (RawQuery != 0) {
                                        RawQuery.close();
                                    }
                                    if (sQLiteDatabase != null) {
                                    }
                                    i11++;
                                    r22 = 0;
                                }
                                try {
                                    this.f5030a.d().r().d("Different delete count than expected in local db. expected, received, difference", Long.valueOf(j11), Long.valueOf(jDelete), Long.valueOf(j11 - jDelete));
                                } catch (SQLiteFullException e14) {
                                    e = e14;
                                    cursor3 = RawQuery;
                                    sQLiteDatabase = sQLiteDatabaseO;
                                    cursor = cursor3;
                                    this.f5030a.d().r().b("Error writing entry; local database full", e);
                                    this.f5543d = true;
                                    if (cursor != null) {
                                    }
                                    if (sQLiteDatabase != null) {
                                    }
                                    i11++;
                                    r22 = 0;
                                } catch (SQLiteException e15) {
                                    e = e15;
                                    cursor2 = RawQuery;
                                    sQLiteDatabase = sQLiteDatabaseO;
                                    RawQuery = cursor2;
                                    if (sQLiteDatabase != null) {
                                    }
                                    this.f5030a.d().r().b("Error writing entry to local database", e);
                                    this.f5543d = true;
                                    if (RawQuery != 0) {
                                    }
                                    if (sQLiteDatabase != null) {
                                    }
                                    i11++;
                                    r22 = 0;
                                }
                            } else {
                                z10 = true;
                            }
                        }
                        sQLiteDatabaseO.insertOrThrow("messages", null, contentValues);
                        sQLiteDatabaseO.setTransactionSuccessful();
                        sQLiteDatabaseO.endTransaction();
                        if (RawQuery != 0) {
                            RawQuery.close();
                        }
                        sQLiteDatabaseO.close();
                        return z10;
                    } catch (Throwable th3) {
                        th = th3;
                        if (cursor4 != null) {
                        }
                        if (sQLiteDatabaseO != null) {
                        }
                        throw th;
                    }
                } catch (SQLiteDatabaseLockedException unused3) {
                } catch (SQLiteFullException e16) {
                    e = e16;
                    cursor3 = null;
                } catch (SQLiteException e17) {
                    e = e17;
                    cursor2 = null;
                }
            } catch (SQLiteDatabaseLockedException unused4) {
                sQLiteDatabaseO = null;
            } catch (SQLiteFullException e18) {
                e = e18;
                cursor = null;
            } catch (SQLiteException e19) {
                e = e19;
                RawQuery = 0;
            } catch (Throwable th4) {
                th = th4;
                sQLiteDatabaseO = null;
            }
        }
        this.f5030a.d().v().a("Failed to write entry to local database");
        return false;
    }
}
