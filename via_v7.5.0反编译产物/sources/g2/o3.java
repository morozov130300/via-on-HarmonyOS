package g2;

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

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class o3 extends c4 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final n3 f5158c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f5159d;

    public o3(h5 h5Var) {
        super(h5Var);
        Context contextC = this.f4646a.c();
        this.f4646a.z();
        this.f5158c = new n3(this, contextC, "google_app_measurement_local.db");
    }

    @Override // g2.c4
    public final boolean n() {
        return false;
    }

    public final SQLiteDatabase o() {
        if (this.f5159d) {
            return null;
        }
        SQLiteDatabase writableDatabase = this.f5158c.getWritableDatabase();
        if (writableDatabase != null) {
            return writableDatabase;
        }
        this.f5159d = true;
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:119:0x01f6 A[PHI: r9 r11
  0x01f6: PHI (r9v3 int) = (r9v1 int), (r9v1 int), (r9v4 int) binds: [B:110:0x01e4, B:127:0x0213, B:118:0x01f4] A[DONT_GENERATE, DONT_INLINE]
  0x01f6: PHI (r11v7 android.database.sqlite.SQLiteDatabase) = 
  (r11v5 android.database.sqlite.SQLiteDatabase)
  (r11v6 android.database.sqlite.SQLiteDatabase)
  (r11v8 android.database.sqlite.SQLiteDatabase)
 binds: [B:110:0x01e4, B:127:0x0213, B:118:0x01f4] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:131:0x021c  */
    /* JADX WARN: Code duplicated, block: B:133:0x0221  */
    public final List p(int i10) {
        SQLiteDatabase sQLiteDatabaseO;
        Cursor cursorQuery;
        Cursor cursorQuery2;
        long j10;
        String str;
        String[] strArr;
        zzlk zzlkVarCreateFromParcel;
        zzac zzacVarCreateFromParcel;
        h();
        Cursor cursor = null;
        if (this.f5159d) {
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
                    this.f5159d = true;
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
                                        Parcel parcelObtain = Parcel.obtain();
                                        try {
                                            try {
                                                parcelObtain.unmarshall(blob, 0, blob.length);
                                                parcelObtain.setDataPosition(0);
                                                zzau zzauVarCreateFromParcel = zzau.CREATOR.createFromParcel(parcelObtain);
                                                parcelObtain.recycle();
                                                if (zzauVarCreateFromParcel != null) {
                                                    arrayList.add(zzauVarCreateFromParcel);
                                                }
                                            } catch (SafeParcelReader.ParseException unused) {
                                                this.f4646a.d().r().a("Failed to load event from local database");
                                                parcelObtain.recycle();
                                            }
                                        } catch (Throwable th) {
                                            parcelObtain.recycle();
                                            throw th;
                                        }
                                    } else if (i13 == 1) {
                                        Parcel parcelObtain2 = Parcel.obtain();
                                        try {
                                            try {
                                                parcelObtain2.unmarshall(blob, 0, blob.length);
                                                parcelObtain2.setDataPosition(0);
                                                zzlkVarCreateFromParcel = zzlk.CREATOR.createFromParcel(parcelObtain2);
                                                parcelObtain2.recycle();
                                            } catch (SafeParcelReader.ParseException unused2) {
                                                this.f4646a.d().r().a("Failed to load user property from local database");
                                                parcelObtain2.recycle();
                                                zzlkVarCreateFromParcel = null;
                                            }
                                            if (zzlkVarCreateFromParcel != null) {
                                                arrayList.add(zzlkVarCreateFromParcel);
                                            }
                                        } catch (Throwable th2) {
                                            parcelObtain2.recycle();
                                            throw th2;
                                        }
                                    } else if (i13 == 2) {
                                        Parcel parcelObtain3 = Parcel.obtain();
                                        try {
                                            try {
                                                parcelObtain3.unmarshall(blob, 0, blob.length);
                                                parcelObtain3.setDataPosition(0);
                                                zzacVarCreateFromParcel = zzac.CREATOR.createFromParcel(parcelObtain3);
                                                parcelObtain3.recycle();
                                            } catch (SafeParcelReader.ParseException unused3) {
                                                this.f4646a.d().r().a("Failed to load conditional user property from local database");
                                                parcelObtain3.recycle();
                                                zzacVarCreateFromParcel = null;
                                            }
                                            if (zzacVarCreateFromParcel != null) {
                                                arrayList.add(zzacVarCreateFromParcel);
                                            }
                                        } catch (Throwable th3) {
                                            parcelObtain3.recycle();
                                            throw th3;
                                        }
                                    } else if (i13 == 3) {
                                        this.f4646a.d().w().a("Skipping app launch break");
                                    } else {
                                        this.f4646a.d().r().a("Unknown record type in local database");
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
                                    this.f4646a.d().r().b("Error reading entries from local database", e);
                                    this.f5159d = true;
                                    if (cursorQuery != null) {
                                        cursorQuery.close();
                                    }
                                    if (sQLiteDatabaseO != null) {
                                        sQLiteDatabaseO.close();
                                    }
                                } catch (SQLiteException e11) {
                                    e = e11;
                                    if (sQLiteDatabaseO != null) {
                                        try {
                                            if (sQLiteDatabaseO.inTransaction()) {
                                                sQLiteDatabaseO.endTransaction();
                                            }
                                        } catch (Throwable th4) {
                                            th = th4;
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
                                    this.f4646a.d().r().b("Error reading entries from local database", e);
                                    this.f5159d = true;
                                    if (cursorQuery != null) {
                                        cursorQuery.close();
                                    }
                                    if (sQLiteDatabaseO != null) {
                                        sQLiteDatabaseO.close();
                                    }
                                }
                            }
                            if (sQLiteDatabaseO.delete("messages", "rowid <= ?", new String[]{Long.toString(j11)}) < arrayList.size()) {
                                this.f4646a.d().r().a("Fewer entries removed from local database than expected");
                            }
                            sQLiteDatabaseO.setTransactionSuccessful();
                            sQLiteDatabaseO.endTransaction();
                            cursorQuery.close();
                            sQLiteDatabaseO.close();
                            return arrayList;
                        } catch (Throwable th5) {
                            th = th5;
                            if (cursorQuery2 != null) {
                                cursorQuery2.close();
                            }
                            throw th;
                        }
                    } catch (Throwable th6) {
                        th = th6;
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
                } catch (Throwable th7) {
                    th = th7;
                    if (cursor != null) {
                        cursor.close();
                    }
                    if (sQLiteDatabaseO != null) {
                        sQLiteDatabaseO.close();
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
            } catch (Throwable th8) {
                th = th8;
                sQLiteDatabaseO = null;
            }
        }
        this.f4646a.d().w().a("Failed to read events from database in reasonable time");
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
            this.f4646a.d().v().b("Reset local analytics data. records", Integer.valueOf(iDelete));
        } catch (SQLiteException e10) {
            this.f4646a.d().r().b("Error resetting local analytics data. error", e10);
        }
    }

    public final boolean r() {
        return x(3, new byte[0]);
    }

    public final boolean s() {
        Context contextC = this.f4646a.c();
        this.f4646a.z();
        return contextC.getDatabasePath("google_app_measurement_local.db").exists();
    }

    /* JADX WARN: Code duplicated, block: B:30:0x0066 A[PHI: r4
  0x0066: PHI (r4v3 int) = (r4v1 int), (r4v1 int), (r4v4 int) binds: [B:26:0x005d, B:33:0x007a, B:29:0x0064] A[DONT_GENERATE, DONT_INLINE]] */
    public final boolean t() {
        h();
        if (!this.f5159d && s()) {
            int i10 = 5;
            for (int i11 = 0; i11 < 5; i11++) {
                SQLiteDatabase sQLiteDatabase = null;
                try {
                    try {
                        SQLiteDatabase sQLiteDatabaseO = o();
                        if (sQLiteDatabaseO == null) {
                            this.f5159d = true;
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
                    this.f4646a.d().r().b("Error deleting app launch break from local database", e10);
                    this.f5159d = true;
                    if (0 != 0) {
                        sQLiteDatabase.close();
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
                    this.f4646a.d().r().b("Error deleting app launch break from local database", e11);
                    this.f5159d = true;
                    if (0 != 0) {
                        sQLiteDatabase.close();
                    }
                }
            }
            this.f4646a.d().w().a("Error deleting app launch break from local database in reasonable time");
        }
        return false;
    }

    public final boolean u(zzac zzacVar) {
        byte[] bArrE0 = this.f4646a.N().e0(zzacVar);
        if (bArrE0.length <= 131072) {
            return x(2, bArrE0);
        }
        this.f4646a.d().t().a("Conditional user property too long for local database. Sending directly to service");
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
        this.f4646a.d().t().a("Event is too long for local database. Sending event directly to service");
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
        this.f4646a.d().t().a("User property too long for local database. Sending directly to service");
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:104:0x00ff A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:118:0x015e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:120:0x015e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:122:0x015e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:48:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:67:0x0105 A[Catch: all -> 0x0109, TryCatch #7 {all -> 0x0109, blocks: (B:65:0x00ff, B:67:0x0105, B:70:0x010b, B:88:0x0144), top: B:104:0x00ff }] */
    /* JADX WARN: Code duplicated, block: B:72:0x011f  */
    /* JADX WARN: Code duplicated, block: B:74:0x0124 A[PHI: r8
  0x0124: PHI (r8v3 android.database.sqlite.SQLiteDatabase) = (r8v2 android.database.sqlite.SQLiteDatabase), (r8v4 android.database.sqlite.SQLiteDatabase) binds: [B:73:0x0122, B:91:0x015b] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:81:0x0135  */
    /* JADX WARN: Code duplicated, block: B:83:0x013a  */
    /* JADX WARN: Code duplicated, block: B:90:0x0158  */
    /* JADX WARN: Code duplicated, block: B:95:0x0166  */
    /* JADX WARN: Code duplicated, block: B:97:0x016b  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v10 */
    /* JADX WARN: Type inference failed for: r10v11 */
    /* JADX WARN: Type inference failed for: r10v12 */
    /* JADX WARN: Type inference failed for: r10v13 */
    /* JADX WARN: Type inference failed for: r10v14 */
    /* JADX WARN: Type inference failed for: r10v15 */
    /* JADX WARN: Type inference failed for: r10v16 */
    /* JADX WARN: Type inference failed for: r10v17 */
    /* JADX WARN: Type inference failed for: r10v18 */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r10v3, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r10v4, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r10v6, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r10v7 */
    /* JADX WARN: Type inference failed for: r10v8 */
    /* JADX WARN: Type inference failed for: r10v9 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v12 */
    /* JADX WARN: Type inference failed for: r8v13 */
    /* JADX WARN: Type inference failed for: r8v14 */
    /* JADX WARN: Type inference failed for: r8v5, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r8v6, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r8v7 */
    public final boolean x(int i10, byte[] bArr) throws Throwable {
        SQLiteDatabase sQLiteDatabaseO;
        ?? RawQuery;
        ?? r10;
        boolean z10;
        ?? r11;
        ?? r12;
        h();
        ?? r13 = 0;
        if (this.f5159d) {
            return false;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("type", Integer.valueOf(i10));
        contentValues.put("entry", bArr);
        this.f4646a.z();
        int i11 = 0;
        int i12 = 5;
        for (int i13 = 5; i11 < i13; i13 = 5) {
            ?? r14 = 0;
            r14 = 0;
             = 0;
            ?? r15 = 0;
            sQLiteDatabase = null;
            SQLiteDatabase sQLiteDatabase = null;
            try {
                sQLiteDatabaseO = o();
                if (sQLiteDatabaseO == null) {
                    this.f5159d = true;
                    return r13;
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
                                        j10 = RawQuery.getLong(r13);
                                    }
                                } catch (Throwable th) {
                                    th = th;
                                    r14 = RawQuery;
                                    if (r14 != 0) {
                                        r14.close();
                                    }
                                    if (sQLiteDatabaseO != null) {
                                        sQLiteDatabaseO.close();
                                    }
                                    throw th;
                                }
                            } catch (SQLiteDatabaseLockedException unused) {
                                r15 = RawQuery;
                                SystemClock.sleep(i12);
                                i12 += 20;
                                if (r15 != 0) {
                                    r15.close();
                                }
                                if (sQLiteDatabaseO != null) {
                                    sQLiteDatabaseO.close();
                                }
                                i11++;
                                r13 = 0;
                            } catch (SQLiteFullException e10) {
                                e = e10;
                                r12 = RawQuery;
                                sQLiteDatabase = sQLiteDatabaseO;
                                r10 = r12;
                                this.f4646a.d().r().b("Error writing entry; local database full", e);
                                this.f5159d = true;
                                if (r10 != 0) {
                                    r10.close();
                                }
                                if (sQLiteDatabase != null) {
                                    sQLiteDatabase.close();
                                }
                                i11++;
                                r13 = 0;
                            } catch (SQLiteException e11) {
                                e = e11;
                                r11 = RawQuery;
                                sQLiteDatabase = sQLiteDatabaseO;
                                RawQuery = r11;
                                if (sQLiteDatabase != null) {
                                    try {
                                        if (sQLiteDatabase.inTransaction()) {
                                            sQLiteDatabase.endTransaction();
                                        }
                                    } catch (Throwable th2) {
                                        th = th2;
                                        sQLiteDatabaseO = sQLiteDatabase;
                                        r14 = RawQuery;
                                        if (r14 != 0) {
                                            r14.close();
                                        }
                                        if (sQLiteDatabaseO != null) {
                                            sQLiteDatabaseO.close();
                                        }
                                        throw th;
                                    }
                                }
                                this.f4646a.d().r().b("Error writing entry to local database", e);
                                this.f5159d = true;
                                if (RawQuery != 0) {
                                    RawQuery.close();
                                }
                                if (sQLiteDatabase != null) {
                                    sQLiteDatabase.close();
                                }
                                i11++;
                                r13 = 0;
                            }
                        }
                        if (j10 >= 100000) {
                            this.f4646a.d().r().a("Data loss, local db full");
                            long j11 = 100001 - j10;
                            long jDelete = sQLiteDatabaseO.delete("messages", "rowid in (select rowid from messages order by rowid asc limit ?)", new String[]{Long.toString(j11)});
                            if (jDelete != j11) {
                                try {
                                    try {
                                        z10 = true;
                                        try {
                                            this.f4646a.d().r().d("Different delete count than expected in local db. expected, received, difference", Long.valueOf(j11), Long.valueOf(jDelete), Long.valueOf(j11 - jDelete));
                                        } catch (SQLiteFullException e12) {
                                            e = e12;
                                            r12 = RawQuery;
                                            sQLiteDatabase = sQLiteDatabaseO;
                                            r10 = r12;
                                            this.f4646a.d().r().b("Error writing entry; local database full", e);
                                            this.f5159d = true;
                                            if (r10 != 0) {
                                                r10.close();
                                            }
                                            if (sQLiteDatabase != null) {
                                                sQLiteDatabase.close();
                                            }
                                            i11++;
                                            r13 = 0;
                                        } catch (SQLiteException e13) {
                                            e = e13;
                                            r11 = RawQuery;
                                            sQLiteDatabase = sQLiteDatabaseO;
                                            RawQuery = r11;
                                            if (sQLiteDatabase != null) {
                                                if (sQLiteDatabase.inTransaction()) {
                                                    sQLiteDatabase.endTransaction();
                                                }
                                            }
                                            this.f4646a.d().r().b("Error writing entry to local database", e);
                                            this.f5159d = true;
                                            if (RawQuery != 0) {
                                                RawQuery.close();
                                            }
                                            if (sQLiteDatabase != null) {
                                                sQLiteDatabase.close();
                                            }
                                            i11++;
                                            r13 = 0;
                                        }
                                    } catch (SQLiteDatabaseLockedException unused2) {
                                        r15 = RawQuery;
                                        SystemClock.sleep(i12);
                                        i12 += 20;
                                        if (r15 != 0) {
                                            r15.close();
                                        }
                                        if (sQLiteDatabaseO != null) {
                                            sQLiteDatabaseO.close();
                                        }
                                        i11++;
                                        r13 = 0;
                                    }
                                } catch (SQLiteFullException e14) {
                                    e = e14;
                                    r12 = RawQuery;
                                } catch (SQLiteException e15) {
                                    e = e15;
                                    r11 = RawQuery;
                                }
                            } else {
                                z10 = true;
                            }
                        } else {
                            z10 = true;
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
                        if (r14 != 0) {
                            r14.close();
                        }
                        if (sQLiteDatabaseO != null) {
                            sQLiteDatabaseO.close();
                        }
                        throw th;
                    }
                } catch (SQLiteDatabaseLockedException unused3) {
                } catch (SQLiteFullException e16) {
                    e = e16;
                    r12 = 0;
                } catch (SQLiteException e17) {
                    e = e17;
                    r11 = 0;
                }
            } catch (SQLiteDatabaseLockedException unused4) {
                sQLiteDatabaseO = null;
            } catch (SQLiteFullException e18) {
                e = e18;
                r10 = 0;
            } catch (SQLiteException e19) {
                e = e19;
                RawQuery = 0;
            } catch (Throwable th4) {
                th = th4;
                sQLiteDatabaseO = null;
            }
        }
        this.f4646a.d().v().a("Failed to write entry to local database");
        return false;
    }
}
