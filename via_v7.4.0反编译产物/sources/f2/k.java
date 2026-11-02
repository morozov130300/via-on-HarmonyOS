package f2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.internal.measurement.ae;
import com.google.android.gms.internal.measurement.ed;
import com.google.android.gms.internal.measurement.ke;
import com.google.android.gms.internal.measurement.tb;
import com.google.android.gms.measurement.internal.zzac;
import com.google.android.gms.measurement.internal.zzau;
import com.google.android.gms.measurement.internal.zzlk;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class k extends ba {

    /* renamed from: f, reason: collision with root package name */
    public static final String[] f5398f = {"last_bundled_timestamp", "ALTER TABLE events ADD COLUMN last_bundled_timestamp INTEGER;", "last_bundled_day", "ALTER TABLE events ADD COLUMN last_bundled_day INTEGER;", "last_sampled_complex_event_id", "ALTER TABLE events ADD COLUMN last_sampled_complex_event_id INTEGER;", "last_sampling_rate", "ALTER TABLE events ADD COLUMN last_sampling_rate INTEGER;", "last_exempt_from_sampling", "ALTER TABLE events ADD COLUMN last_exempt_from_sampling INTEGER;", "current_session_count", "ALTER TABLE events ADD COLUMN current_session_count INTEGER;"};

    /* renamed from: g, reason: collision with root package name */
    public static final String[] f5399g = {"origin", "ALTER TABLE user_attributes ADD COLUMN origin TEXT;"};

    /* renamed from: h, reason: collision with root package name */
    public static final String[] f5400h = {"app_version", "ALTER TABLE apps ADD COLUMN app_version TEXT;", "app_store", "ALTER TABLE apps ADD COLUMN app_store TEXT;", "gmp_version", "ALTER TABLE apps ADD COLUMN gmp_version INTEGER;", "dev_cert_hash", "ALTER TABLE apps ADD COLUMN dev_cert_hash INTEGER;", "measurement_enabled", "ALTER TABLE apps ADD COLUMN measurement_enabled INTEGER;", "last_bundle_start_timestamp", "ALTER TABLE apps ADD COLUMN last_bundle_start_timestamp INTEGER;", "day", "ALTER TABLE apps ADD COLUMN day INTEGER;", "daily_public_events_count", "ALTER TABLE apps ADD COLUMN daily_public_events_count INTEGER;", "daily_events_count", "ALTER TABLE apps ADD COLUMN daily_events_count INTEGER;", "daily_conversions_count", "ALTER TABLE apps ADD COLUMN daily_conversions_count INTEGER;", "remote_config", "ALTER TABLE apps ADD COLUMN remote_config BLOB;", "config_fetched_time", "ALTER TABLE apps ADD COLUMN config_fetched_time INTEGER;", "failed_config_fetch_time", "ALTER TABLE apps ADD COLUMN failed_config_fetch_time INTEGER;", "app_version_int", "ALTER TABLE apps ADD COLUMN app_version_int INTEGER;", "firebase_instance_id", "ALTER TABLE apps ADD COLUMN firebase_instance_id TEXT;", "daily_error_events_count", "ALTER TABLE apps ADD COLUMN daily_error_events_count INTEGER;", "daily_realtime_events_count", "ALTER TABLE apps ADD COLUMN daily_realtime_events_count INTEGER;", "health_monitor_sample", "ALTER TABLE apps ADD COLUMN health_monitor_sample TEXT;", "android_id", "ALTER TABLE apps ADD COLUMN android_id INTEGER;", "adid_reporting_enabled", "ALTER TABLE apps ADD COLUMN adid_reporting_enabled INTEGER;", "ssaid_reporting_enabled", "ALTER TABLE apps ADD COLUMN ssaid_reporting_enabled INTEGER;", "admob_app_id", "ALTER TABLE apps ADD COLUMN admob_app_id TEXT;", "linked_admob_app_id", "ALTER TABLE apps ADD COLUMN linked_admob_app_id TEXT;", "dynamite_version", "ALTER TABLE apps ADD COLUMN dynamite_version INTEGER;", "safelisted_events", "ALTER TABLE apps ADD COLUMN safelisted_events TEXT;", "ga_app_id", "ALTER TABLE apps ADD COLUMN ga_app_id TEXT;", "config_last_modified_time", "ALTER TABLE apps ADD COLUMN config_last_modified_time TEXT;", "e_tag", "ALTER TABLE apps ADD COLUMN e_tag TEXT;", "session_stitching_token", "ALTER TABLE apps ADD COLUMN session_stitching_token TEXT;", "sgtm_upload_enabled", "ALTER TABLE apps ADD COLUMN sgtm_upload_enabled INTEGER;", "target_os_version", "ALTER TABLE apps ADD COLUMN target_os_version INTEGER;", "session_stitching_token_hash", "ALTER TABLE apps ADD COLUMN session_stitching_token_hash INTEGER;"};

    /* renamed from: i, reason: collision with root package name */
    public static final String[] f5401i = {"realtime", "ALTER TABLE raw_events ADD COLUMN realtime INTEGER;"};

    /* renamed from: j, reason: collision with root package name */
    public static final String[] f5402j = {"has_realtime", "ALTER TABLE queue ADD COLUMN has_realtime INTEGER;", "retry_count", "ALTER TABLE queue ADD COLUMN retry_count INTEGER;"};

    /* renamed from: k, reason: collision with root package name */
    public static final String[] f5403k = {"session_scoped", "ALTER TABLE event_filters ADD COLUMN session_scoped BOOLEAN;"};

    /* renamed from: l, reason: collision with root package name */
    public static final String[] f5404l = {"session_scoped", "ALTER TABLE property_filters ADD COLUMN session_scoped BOOLEAN;"};

    /* renamed from: m, reason: collision with root package name */
    public static final String[] f5405m = {"previous_install_count", "ALTER TABLE app2 ADD COLUMN previous_install_count INTEGER;"};

    /* renamed from: d, reason: collision with root package name */
    public final j f5406d;

    /* renamed from: e, reason: collision with root package name */
    public final v9 f5407e;

    public k(pa paVar) {
        super(paVar);
        this.f5407e = new v9(this.f5030a.a());
        this.f5030a.z();
        this.f5406d = new j(this, this.f5030a.c(), "google_app_measurement.db");
    }

    public static final void H(ContentValues contentValues, String str, Object obj) {
        t1.f.d("value");
        t1.f.h(obj);
        if (obj instanceof String) {
            contentValues.put("value", (String) obj);
        } else if (obj instanceof Long) {
            contentValues.put("value", (Long) obj);
        } else {
            if (!(obj instanceof Double)) {
                throw new IllegalArgumentException("Invalid value type");
            }
            contentValues.put("value", (Double) obj);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0220  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0226  */
    /* JADX WARN: Removed duplicated region for block: B:139:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r15v0 */
    /* JADX WARN: Type inference failed for: r15v1 */
    /* JADX WARN: Type inference failed for: r15v2 */
    /* JADX WARN: Type inference failed for: r15v3 */
    /* JADX WARN: Type inference failed for: r15v4 */
    /* JADX WARN: Type inference failed for: r15v6 */
    /* JADX WARN: Type inference failed for: r15v7 */
    /* JADX WARN: Type inference failed for: r15v8 */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v14 */
    /* JADX WARN: Type inference failed for: r5v17 */
    /* JADX WARN: Type inference failed for: r5v2, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r5v3, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v30 */
    /* JADX WARN: Type inference failed for: r5v31 */
    /* JADX WARN: Type inference failed for: r5v4 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void G(String str, long j10, long j11, ma maVar) throws Throwable {
        ?? r52;
        String string;
        String str2;
        String[] strArr;
        Cursor cursorQuery;
        t1.f.h(maVar);
        h();
        i();
        Cursor cursor = null;
        string = null;
        string = null;
        String string2 = null;
        try {
            try {
                SQLiteDatabase sQLiteDatabaseP = P();
                r52 = "";
                ?? r15 = -1;
                ?? r152 = -1;
                try {
                    if (TextUtils.isEmpty(null)) {
                        String[] strArr2 = j11 != -1 ? new String[]{String.valueOf(j11), String.valueOf(j10)} : new String[]{String.valueOf(j10)};
                        String str3 = r52;
                        if (j11 != -1) {
                            str3 = "rowid <= ? and ";
                        }
                        Cursor cursorRawQuery = sQLiteDatabaseP.rawQuery("select app_id, metadata_fingerprint from raw_events where " + str3 + "app_id in (select app_id from apps where config_fetched_time >= ?) order by rowid limit 1;", strArr2);
                        if (!cursorRawQuery.moveToFirst()) {
                            cursorRawQuery.close();
                            return;
                        }
                        string2 = cursorRawQuery.getString(0);
                        string = cursorRawQuery.getString(1);
                        cursorRawQuery.close();
                        r52 = cursorRawQuery;
                    } else {
                        String[] strArr3 = j11 != -1 ? new String[]{null, String.valueOf(j11)} : new String[]{null};
                        String str4 = r52;
                        if (j11 != -1) {
                            str4 = " and rowid <= ?";
                        }
                        Cursor cursorRawQuery2 = sQLiteDatabaseP.rawQuery("select metadata_fingerprint from raw_events where app_id = ?" + str4 + " order by rowid limit 1;", strArr3);
                        if (!cursorRawQuery2.moveToFirst()) {
                            cursorRawQuery2.close();
                            return;
                        } else {
                            string = cursorRawQuery2.getString(0);
                            cursorRawQuery2.close();
                            r52 = cursorRawQuery2;
                        }
                    }
                    Cursor cursor2 = r52;
                    try {
                        Cursor cursorQuery2 = sQLiteDatabaseP.query("raw_events_metadata", new String[]{"metadata"}, "app_id = ? and metadata_fingerprint = ?", new String[]{string2, string}, null, null, "rowid", "2");
                        try {
                            if (!cursorQuery2.moveToFirst()) {
                                this.f5030a.d().r().b("Raw event metadata record is missing. appId", v3.z(string2));
                                cursorQuery2.close();
                                return;
                            }
                            try {
                                try {
                                    com.google.android.gms.internal.measurement.u4 u4Var = (com.google.android.gms.internal.measurement.u4) ((com.google.android.gms.internal.measurement.t4) ra.E(com.google.android.gms.internal.measurement.u4.S1(), cursorQuery2.getBlob(0))).o();
                                    if (cursorQuery2.moveToNext()) {
                                        this.f5030a.d().w().b("Get multiple raw event metadata records, expected one. appId", v3.z(string2));
                                    }
                                    cursorQuery2.close();
                                    t1.f.h(u4Var);
                                    maVar.f5508a = u4Var;
                                    if (j11 != -1) {
                                        str2 = "app_id = ? and metadata_fingerprint = ? and rowid <= ?";
                                        strArr = new String[]{string2, string, String.valueOf(j11)};
                                    } else {
                                        str2 = "app_id = ? and metadata_fingerprint = ?";
                                        strArr = new String[]{string2, string};
                                    }
                                    try {
                                        cursorQuery = sQLiteDatabaseP.query("raw_events", new String[]{"rowid", "name", "timestamp", "data"}, str2, strArr, null, null, "rowid", null);
                                    } catch (SQLiteException e10) {
                                        e = e10;
                                        r152 = cursorQuery2;
                                        r52 = r152;
                                        this.f5030a.d().r().c("Data loss. Error selecting raw event. appId", v3.z(string2), e);
                                        if (r52 == 0) {
                                            r52.close();
                                            return;
                                        }
                                        return;
                                    } catch (Throwable th) {
                                        th = th;
                                        r15 = cursorQuery2;
                                        cursor = r15;
                                        if (cursor != null) {
                                            cursor.close();
                                        }
                                        throw th;
                                    }
                                } catch (IOException e11) {
                                    this.f5030a.d().r().c("Data loss. Failed to merge raw event metadata. appId", v3.z(string2), e11);
                                    cursorQuery2.close();
                                    return;
                                }
                            } catch (SQLiteException e12) {
                                e = e12;
                            } catch (Throwable th2) {
                                th = th2;
                            }
                            try {
                                if (!cursorQuery.moveToFirst()) {
                                    this.f5030a.d().w().b("Raw event data disappeared while in transaction. appId", v3.z(string2));
                                    cursorQuery.close();
                                    return;
                                }
                                do {
                                    long j12 = cursorQuery.getLong(0);
                                    try {
                                        com.google.android.gms.internal.measurement.i4 i4Var = (com.google.android.gms.internal.measurement.i4) ra.E(com.google.android.gms.internal.measurement.j4.H(), cursorQuery.getBlob(3));
                                        i4Var.A(cursorQuery.getString(1));
                                        i4Var.E(cursorQuery.getLong(2));
                                        if (!maVar.a(j12, (com.google.android.gms.internal.measurement.j4) i4Var.o())) {
                                            cursorQuery.close();
                                            return;
                                        }
                                    } catch (IOException e13) {
                                        this.f5030a.d().r().c("Data loss. Failed to merge raw event. appId", v3.z(string2), e13);
                                    }
                                } while (cursorQuery.moveToNext());
                                cursorQuery.close();
                            } catch (SQLiteException e14) {
                                e = e14;
                                r52 = cursorQuery;
                                this.f5030a.d().r().c("Data loss. Error selecting raw event. appId", v3.z(string2), e);
                                if (r52 == 0) {
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                cursor = cursorQuery;
                                if (cursor != null) {
                                }
                                throw th;
                            }
                        } catch (SQLiteException e15) {
                            e = e15;
                            r152 = cursorQuery2;
                        } catch (Throwable th4) {
                            th = th4;
                            r15 = cursorQuery2;
                        }
                    } catch (SQLiteException e16) {
                        e = e16;
                        r52 = cursor2;
                    } catch (Throwable th5) {
                        th = th5;
                        cursor = cursor2;
                    }
                } catch (SQLiteException e17) {
                    e = e17;
                }
            } catch (Throwable th6) {
                th = th6;
                cursor = r52;
            }
        } catch (SQLiteException e18) {
            e = e18;
            r52 = 0;
        } catch (Throwable th7) {
            th = th7;
        }
    }

    public final long I(String str, String[] strArr) {
        Cursor cursor = null;
        try {
            try {
                Cursor cursorRawQuery = P().rawQuery(str, strArr);
                if (!cursorRawQuery.moveToFirst()) {
                    throw new SQLiteException("Database returned empty set");
                }
                long j10 = cursorRawQuery.getLong(0);
                cursorRawQuery.close();
                return j10;
            } catch (SQLiteException e10) {
                this.f5030a.d().r().c("Database error", str, e10);
                throw e10;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    public final int J(String str, String str2) {
        t1.f.d(str);
        t1.f.d(str2);
        h();
        i();
        try {
            return P().delete("conditional_properties", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e10) {
            this.f5030a.d().r().d("Error deleting conditional property", v3.z(str), this.f5030a.D().f(str2), e10);
            return 0;
        }
    }

    public final long K(String str, String[] strArr, long j10) {
        Cursor cursorRawQuery = null;
        try {
            try {
                cursorRawQuery = P().rawQuery(str, strArr);
                if (!cursorRawQuery.moveToFirst()) {
                    cursorRawQuery.close();
                    return j10;
                }
                long j11 = cursorRawQuery.getLong(0);
                cursorRawQuery.close();
                return j11;
            } catch (SQLiteException e10) {
                this.f5030a.d().r().c("Database error", str, e10);
                throw e10;
            }
        } catch (Throwable th) {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
            throw th;
        }
    }

    public final long L(String str, String str2) {
        long jK;
        t1.f.d(str);
        t1.f.d("first_open_count");
        h();
        i();
        SQLiteDatabase sQLiteDatabaseP = P();
        sQLiteDatabaseP.beginTransaction();
        long j10 = 0;
        try {
            try {
                jK = K("select first_open_count from app2 where app_id=?", new String[]{str}, -1L);
                if (jK == -1) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("app_id", str);
                    contentValues.put("first_open_count", (Integer) 0);
                    contentValues.put("previous_install_count", (Integer) 0);
                    if (sQLiteDatabaseP.insertWithOnConflict("app2", null, contentValues, 5) == -1) {
                        this.f5030a.d().r().c("Failed to insert column (got -1). appId", v3.z(str), "first_open_count");
                        sQLiteDatabaseP.endTransaction();
                        return -1L;
                    }
                    jK = 0;
                }
            } catch (SQLiteException e10) {
                e = e10;
            }
            try {
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("app_id", str);
                contentValues2.put("first_open_count", Long.valueOf(1 + jK));
                if (sQLiteDatabaseP.update("app2", contentValues2, "app_id = ?", new String[]{str}) == 0) {
                    this.f5030a.d().r().c("Failed to update column (got 0). appId", v3.z(str), "first_open_count");
                    sQLiteDatabaseP.endTransaction();
                    return -1L;
                }
                sQLiteDatabaseP.setTransactionSuccessful();
                sQLiteDatabaseP.endTransaction();
                return jK;
            } catch (SQLiteException e11) {
                e = e11;
                j10 = jK;
                this.f5030a.d().r().d("Error inserting column. appId", v3.z(str), "first_open_count", e);
                sQLiteDatabaseP.endTransaction();
                return j10;
            }
        } catch (Throwable th) {
            sQLiteDatabaseP.endTransaction();
            throw th;
        }
    }

    public final long M() {
        return K("select max(bundle_end_timestamp) from queue", null, 0L);
    }

    public final long N() {
        return K("select max(timestamp) from raw_events", null, 0L);
    }

    public final long O(String str) {
        t1.f.d(str);
        return K("select count(1) from events where app_id=? and name not like '!_%' escape '!'", new String[]{str}, 0L);
    }

    public final SQLiteDatabase P() {
        h();
        try {
            return this.f5406d.getWritableDatabase();
        } catch (SQLiteException e10) {
            this.f5030a.d().w().b("Error opening database", e10);
            throw e10;
        }
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x00bf: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:38:0x00bf */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00dc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Bundle Q(String str) throws Throwable {
        Cursor cursorRawQuery;
        Cursor cursor;
        h();
        i();
        Cursor cursor2 = null;
        try {
            try {
                cursorRawQuery = P().rawQuery("select parameters from default_event_params where app_id=?", new String[]{str});
                try {
                    if (!cursorRawQuery.moveToFirst()) {
                        this.f5030a.d().v().a("Default event parameters not found");
                        cursorRawQuery.close();
                        return null;
                    }
                    try {
                        com.google.android.gms.internal.measurement.j4 j4Var = (com.google.android.gms.internal.measurement.j4) ((com.google.android.gms.internal.measurement.i4) ra.E(com.google.android.gms.internal.measurement.j4.H(), cursorRawQuery.getBlob(0))).o();
                        this.f5039b.g0();
                        List<com.google.android.gms.internal.measurement.n4> listL = j4Var.L();
                        Bundle bundle = new Bundle();
                        for (com.google.android.gms.internal.measurement.n4 n4Var : listL) {
                            String strJ = n4Var.J();
                            if (n4Var.W()) {
                                bundle.putDouble(strJ, n4Var.D());
                            } else if (n4Var.X()) {
                                bundle.putFloat(strJ, n4Var.E());
                            } else if (n4Var.a0()) {
                                bundle.putString(strJ, n4Var.K());
                            } else if (n4Var.Y()) {
                                bundle.putLong(strJ, n4Var.G());
                            }
                        }
                        cursorRawQuery.close();
                        return bundle;
                    } catch (IOException e10) {
                        this.f5030a.d().r().c("Failed to retrieve default event parameters. appId", v3.z(str), e10);
                        cursorRawQuery.close();
                        return null;
                    }
                } catch (SQLiteException e11) {
                    e = e11;
                    this.f5030a.d().r().b("Error selecting default event parameters", e);
                    if (cursorRawQuery != null) {
                        cursorRawQuery.close();
                    }
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                cursor2 = cursor;
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th;
            }
        } catch (SQLiteException e12) {
            e = e12;
            cursorRawQuery = null;
        } catch (Throwable th2) {
            th = th2;
            if (cursor2 != null) {
            }
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:69:0x025b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final e6 R(String str) {
        Cursor cursorQuery;
        t1.f.d(str);
        h();
        i();
        Cursor cursor = null;
        try {
            cursorQuery = P().query("apps", new String[]{"app_instance_id", "gmp_app_id", "resettable_device_id_hash", "last_bundle_index", "last_bundle_start_timestamp", "last_bundle_end_timestamp", "app_version", "app_store", "gmp_version", "dev_cert_hash", "measurement_enabled", "day", "daily_public_events_count", "daily_events_count", "daily_conversions_count", "config_fetched_time", "failed_config_fetch_time", "app_version_int", "firebase_instance_id", "daily_error_events_count", "daily_realtime_events_count", "health_monitor_sample", "android_id", "adid_reporting_enabled", "admob_app_id", "dynamite_version", "safelisted_events", "ga_app_id", "session_stitching_token", "sgtm_upload_enabled", "target_os_version", "session_stitching_token_hash"}, "app_id=?", new String[]{str}, null, null, null);
            try {
                try {
                    if (!cursorQuery.moveToFirst()) {
                        cursorQuery.close();
                        return null;
                    }
                    e6 e6Var = new e6(this.f5039b.b0(), str);
                    boolean z10 = false;
                    e6Var.j(cursorQuery.getString(0));
                    e6Var.y(cursorQuery.getString(1));
                    e6Var.H(cursorQuery.getString(2));
                    e6Var.D(cursorQuery.getLong(3));
                    e6Var.E(cursorQuery.getLong(4));
                    e6Var.C(cursorQuery.getLong(5));
                    e6Var.l(cursorQuery.getString(6));
                    e6Var.k(cursorQuery.getString(7));
                    e6Var.z(cursorQuery.getLong(8));
                    e6Var.u(cursorQuery.getLong(9));
                    e6Var.F(cursorQuery.isNull(10) || cursorQuery.getInt(10) != 0);
                    e6Var.t(cursorQuery.getLong(11));
                    e6Var.r(cursorQuery.getLong(12));
                    e6Var.q(cursorQuery.getLong(13));
                    e6Var.o(cursorQuery.getLong(14));
                    e6Var.n(cursorQuery.getLong(15));
                    e6Var.w(cursorQuery.getLong(16));
                    e6Var.m(cursorQuery.isNull(17) ? -2147483648L : cursorQuery.getInt(17));
                    e6Var.x(cursorQuery.getString(18));
                    e6Var.p(cursorQuery.getLong(19));
                    e6Var.s(cursorQuery.getLong(20));
                    e6Var.B(cursorQuery.getString(21));
                    e6Var.i(cursorQuery.isNull(23) || cursorQuery.getInt(23) != 0);
                    e6Var.h(cursorQuery.getString(24));
                    e6Var.v(cursorQuery.isNull(25) ? 0L : cursorQuery.getLong(25));
                    if (!cursorQuery.isNull(26)) {
                        e6Var.I(Arrays.asList(cursorQuery.getString(26).split(",", -1)));
                    }
                    ae.b();
                    if (this.f5030a.z().B(str, i3.f5328q0) || this.f5030a.z().B(null, i3.f5324o0)) {
                        e6Var.J(cursorQuery.getString(28));
                    }
                    ke.b();
                    if (this.f5030a.z().B(null, i3.f5332s0)) {
                        if (!cursorQuery.isNull(29) && cursorQuery.getInt(29) != 0) {
                            z10 = true;
                        }
                        e6Var.L(z10);
                    }
                    ed.b();
                    if (this.f5030a.z().B(null, i3.G0)) {
                        e6Var.M(cursorQuery.getLong(30));
                    }
                    if (this.f5030a.z().B(null, i3.J0)) {
                        e6Var.K(cursorQuery.getLong(31));
                    }
                    e6Var.f();
                    if (cursorQuery.moveToNext()) {
                        this.f5030a.d().r().b("Got multiple records for app, expected one. appId", v3.z(str));
                    }
                    cursorQuery.close();
                    return e6Var;
                } catch (SQLiteException e10) {
                    e = e10;
                    this.f5030a.d().r().c("Error querying app. appId", v3.z(str), e);
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                cursor = cursorQuery;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        } catch (SQLiteException e11) {
            e = e11;
            cursorQuery = null;
        } catch (Throwable th2) {
            th = th2;
            if (cursor != null) {
            }
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x012a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final zzac S(String str, String str2) throws Throwable {
        String str3;
        Cursor cursorQuery;
        t1.f.d(str);
        t1.f.d(str2);
        h();
        i();
        Cursor cursor = null;
        try {
            cursorQuery = P().query("conditional_properties", new String[]{"origin", "value", "active", "trigger_event_name", "trigger_timeout", "timed_out_event", "creation_timestamp", "triggered_event", "triggered_timestamp", "time_to_live", "expired_event"}, "app_id=? and name=?", new String[]{str, str2}, null, null, null);
            try {
                try {
                    if (!cursorQuery.moveToFirst()) {
                        cursorQuery.close();
                        return null;
                    }
                    String string = cursorQuery.getString(0);
                    if (string == null) {
                        string = "";
                    }
                    String str4 = string;
                    Object objY = Y(cursorQuery, 1);
                    boolean z10 = cursorQuery.getInt(2) != 0;
                    String string2 = cursorQuery.getString(3);
                    long j10 = cursorQuery.getLong(4);
                    ra raVarG0 = this.f5039b.g0();
                    byte[] blob = cursorQuery.getBlob(5);
                    Parcelable.Creator<zzau> creator = zzau.CREATOR;
                    zzau zzauVar = (zzau) raVarG0.B(blob, creator);
                    long j11 = cursorQuery.getLong(6);
                    zzau zzauVar2 = (zzau) this.f5039b.g0().B(cursorQuery.getBlob(7), creator);
                    long j12 = cursorQuery.getLong(8);
                    long j13 = cursorQuery.getLong(9);
                    zzau zzauVar3 = (zzau) this.f5039b.g0().B(cursorQuery.getBlob(10), creator);
                    str3 = str2;
                    try {
                        zzac zzacVar = new zzac(str, str4, new zzlk(str3, j12, objY, str4), j11, z10, string2, zzauVar, j10, zzauVar2, j13, zzauVar3);
                        if (cursorQuery.moveToNext()) {
                            this.f5030a.d().r().c("Got multiple records for conditional property, expected one", v3.z(str), this.f5030a.D().f(str3));
                        }
                        cursorQuery.close();
                        return zzacVar;
                    } catch (SQLiteException e10) {
                        e = e10;
                        this.f5030a.d().r().d("Error querying conditional property", v3.z(str), this.f5030a.D().f(str3), e);
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        return null;
                    }
                } catch (Throwable th) {
                    th = th;
                    cursor = cursorQuery;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            } catch (SQLiteException e11) {
                e = e11;
                str3 = str2;
            }
        } catch (SQLiteException e12) {
            e = e12;
            str3 = str2;
            cursorQuery = null;
        } catch (Throwable th2) {
            th = th2;
            if (cursor != null) {
            }
            throw th;
        }
    }

    public final i T(long j10, String str, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14) {
        return U(j10, str, 1L, false, false, z12, false, z14);
    }

    public final i U(long j10, String str, long j11, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14) {
        t1.f.d(str);
        h();
        i();
        String[] strArr = {str};
        i iVar = new i();
        Cursor cursor = null;
        try {
            try {
                SQLiteDatabase sQLiteDatabaseP = P();
                Cursor cursorQuery = sQLiteDatabaseP.query("apps", new String[]{"day", "daily_events_count", "daily_public_events_count", "daily_conversions_count", "daily_error_events_count", "daily_realtime_events_count"}, "app_id=?", new String[]{str}, null, null, null);
                if (!cursorQuery.moveToFirst()) {
                    this.f5030a.d().w().b("Not updating daily counts, app is not known. appId", v3.z(str));
                    cursorQuery.close();
                    return iVar;
                }
                if (cursorQuery.getLong(0) == j10) {
                    iVar.f5288b = cursorQuery.getLong(1);
                    iVar.f5287a = cursorQuery.getLong(2);
                    iVar.f5289c = cursorQuery.getLong(3);
                    iVar.f5290d = cursorQuery.getLong(4);
                    iVar.f5291e = cursorQuery.getLong(5);
                }
                if (z10) {
                    iVar.f5288b += j11;
                }
                if (z11) {
                    iVar.f5287a += j11;
                }
                if (z12) {
                    iVar.f5289c += j11;
                }
                if (z13) {
                    iVar.f5290d += j11;
                }
                if (z14) {
                    iVar.f5291e += j11;
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put("day", Long.valueOf(j10));
                contentValues.put("daily_public_events_count", Long.valueOf(iVar.f5287a));
                contentValues.put("daily_events_count", Long.valueOf(iVar.f5288b));
                contentValues.put("daily_conversions_count", Long.valueOf(iVar.f5289c));
                contentValues.put("daily_error_events_count", Long.valueOf(iVar.f5290d));
                contentValues.put("daily_realtime_events_count", Long.valueOf(iVar.f5291e));
                sQLiteDatabaseP.update("apps", contentValues, "app_id=?", strArr);
                cursorQuery.close();
                return iVar;
            } catch (SQLiteException e10) {
                this.f5030a.d().r().c("Error updating daily counts. appId", v3.z(str), e10);
                if (0 != 0) {
                    cursor.close();
                }
                return iVar;
            }
        } finally {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0133  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final q V(String str, String str2) {
        Cursor cursorQuery;
        Boolean boolValueOf;
        t1.f.d(str);
        t1.f.d(str2);
        h();
        i();
        SQLiteCursor sQLiteCursor = 0;
        try {
            try {
                cursorQuery = P().query("events", (String[]) new ArrayList(Arrays.asList("lifetime_count", "current_bundle_count", "last_fire_timestamp", "last_bundled_timestamp", "last_bundled_day", "last_sampled_complex_event_id", "last_sampling_rate", "last_exempt_from_sampling", "current_session_count")).toArray(new String[0]), "app_id=? and name=?", new String[]{str, str2}, null, null, null);
                try {
                    if (!cursorQuery.moveToFirst()) {
                        cursorQuery.close();
                        return null;
                    }
                    long j10 = cursorQuery.getLong(0);
                    long j11 = cursorQuery.getLong(1);
                    long j12 = cursorQuery.getLong(2);
                    long j13 = cursorQuery.isNull(3) ? 0L : cursorQuery.getLong(3);
                    Long lValueOf = cursorQuery.isNull(4) ? null : Long.valueOf(cursorQuery.getLong(4));
                    Long lValueOf2 = cursorQuery.isNull(5) ? null : Long.valueOf(cursorQuery.getLong(5));
                    Long lValueOf3 = cursorQuery.isNull(6) ? null : Long.valueOf(cursorQuery.getLong(6));
                    if (cursorQuery.isNull(7)) {
                        boolValueOf = null;
                    } else {
                        boolValueOf = Boolean.valueOf(cursorQuery.getLong(7) == 1);
                    }
                    q qVar = new q(str, str2, j10, j11, cursorQuery.isNull(8) ? 0L : cursorQuery.getLong(8), j12, j13, lValueOf, lValueOf2, lValueOf3, boolValueOf);
                    if (cursorQuery.moveToNext()) {
                        this.f5030a.d().r().b("Got multiple records for event aggregates, expected one. appId", v3.z(str));
                    }
                    cursorQuery.close();
                    return qVar;
                } catch (SQLiteException e10) {
                    e = e10;
                    this.f5030a.d().r().d("Error querying events. appId", v3.z(str), this.f5030a.D().d(str2), e);
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                sQLiteCursor = "current_bundle_count";
                if (sQLiteCursor != 0) {
                    sQLiteCursor.close();
                }
                throw th;
            }
        } catch (SQLiteException e11) {
            e = e11;
            cursorQuery = null;
        } catch (Throwable th2) {
            th = th2;
            if (sQLiteCursor != 0) {
            }
            throw th;
        }
    }

    public final ta X(String str, String str2) {
        Throwable th;
        String str3;
        String str4;
        SQLiteException sQLiteException;
        Cursor cursorQuery;
        t1.f.d(str);
        t1.f.d(str2);
        h();
        i();
        Cursor cursor = null;
        try {
            cursorQuery = P().query("user_attributes", new String[]{"set_timestamp", "value", "origin"}, "app_id=? and name=?", new String[]{str, str2}, null, null, null);
            try {
                try {
                    if (!cursorQuery.moveToFirst()) {
                        cursorQuery.close();
                        return null;
                    }
                    long j10 = cursorQuery.getLong(0);
                    Object objY = Y(cursorQuery, 1);
                    if (objY == null) {
                        cursorQuery.close();
                        return null;
                    }
                    str3 = str;
                    str4 = str2;
                    try {
                        ta taVar = new ta(str3, cursorQuery.getString(2), str4, j10, objY);
                        if (cursorQuery.moveToNext()) {
                            this.f5030a.d().r().b("Got multiple records for user property, expected one. appId", v3.z(str3));
                        }
                        cursorQuery.close();
                        return taVar;
                    } catch (SQLiteException e10) {
                        e = e10;
                        sQLiteException = e;
                        this.f5030a.d().r().d("Error querying user property. appId", v3.z(str3), this.f5030a.D().f(str4), sQLiteException);
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        return null;
                    }
                } catch (SQLiteException e11) {
                    e = e11;
                    str3 = str;
                    str4 = str2;
                }
            } catch (Throwable th2) {
                th = th2;
                cursor = cursorQuery;
                if (cursor == null) {
                    throw th;
                }
                cursor.close();
                throw th;
            }
        } catch (SQLiteException e12) {
            str3 = str;
            str4 = str2;
            sQLiteException = e12;
            cursorQuery = null;
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public final Object Y(Cursor cursor, int i10) {
        int type = cursor.getType(i10);
        if (type == 0) {
            this.f5030a.d().r().a("Loaded invalid null value from database");
            return null;
        }
        if (type == 1) {
            return Long.valueOf(cursor.getLong(i10));
        }
        if (type == 2) {
            return Double.valueOf(cursor.getDouble(i10));
        }
        if (type == 3) {
            return cursor.getString(i10);
        }
        if (type != 4) {
            this.f5030a.d().r().b("Loaded invalid unknown value type, ignoring it", Integer.valueOf(type));
            return null;
        }
        this.f5030a.d().r().a("Loaded invalid blob type value, ignoring it");
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0042  */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String Z() throws Throwable {
        SQLiteException e10;
        Cursor cursorRawQuery;
        SQLiteDatabase sQLiteDatabaseP = P();
        ?? r12 = 0;
        try {
            try {
                cursorRawQuery = sQLiteDatabaseP.rawQuery("select app_id from queue order by has_realtime desc, rowid asc limit 1;", null);
                try {
                    if (!cursorRawQuery.moveToFirst()) {
                        cursorRawQuery.close();
                        return null;
                    }
                    String string = cursorRawQuery.getString(0);
                    cursorRawQuery.close();
                    return string;
                } catch (SQLiteException e11) {
                    e10 = e11;
                    this.f5030a.d().r().b("Database error getting next bundle app id", e10);
                    if (cursorRawQuery != null) {
                        cursorRawQuery.close();
                    }
                    return null;
                }
            } catch (Throwable th) {
                r12 = sQLiteDatabaseP;
                th = th;
                if (r12 != 0) {
                    r12.close();
                }
                throw th;
            }
        } catch (SQLiteException e12) {
            e10 = e12;
            cursorRawQuery = null;
        } catch (Throwable th2) {
            th = th2;
            if (r12 != 0) {
            }
            throw th;
        }
    }

    public final List a0(String str, String str2, String str3) {
        t1.f.d(str);
        h();
        i();
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(str);
        StringBuilder sb2 = new StringBuilder("app_id=?");
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(str2);
            sb2.append(" and origin=?");
        }
        if (!TextUtils.isEmpty(str3)) {
            arrayList.add(String.valueOf(str3).concat("*"));
            sb2.append(" and name glob ?");
        }
        return b0(sb2.toString(), (String[]) arrayList.toArray(new String[arrayList.size()]));
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0058, code lost:
    
        r2 = r27.f5030a.d().r();
        r27.f5030a.z();
        r2.b("Read more than the max allowed conditional properties, ignoring extra", 1000);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List b0(String str, String[] strArr) {
        h();
        i();
        ArrayList arrayList = new ArrayList();
        Cursor cursorQuery = null;
        try {
            try {
                this.f5030a.z();
                cursorQuery = P().query("conditional_properties", new String[]{"app_id", "origin", "name", "value", "active", "trigger_event_name", "trigger_timeout", "timed_out_event", "creation_timestamp", "triggered_event", "triggered_timestamp", "time_to_live", "expired_event"}, str, strArr, null, null, "rowid", "1001");
                if (!cursorQuery.moveToFirst()) {
                    cursorQuery.close();
                    return arrayList;
                }
                while (true) {
                    int size = arrayList.size();
                    this.f5030a.z();
                    if (size >= 1000) {
                        break;
                    }
                    String string = cursorQuery.getString(0);
                    String string2 = cursorQuery.getString(1);
                    String string3 = cursorQuery.getString(2);
                    Object objY = Y(cursorQuery, 3);
                    boolean z10 = cursorQuery.getInt(4) != 0;
                    String string4 = cursorQuery.getString(5);
                    long j10 = cursorQuery.getLong(6);
                    ra raVarG0 = this.f5039b.g0();
                    byte[] blob = cursorQuery.getBlob(7);
                    Parcelable.Creator<zzau> creator = zzau.CREATOR;
                    zzau zzauVar = (zzau) raVarG0.B(blob, creator);
                    arrayList.add(new zzac(string, string2, new zzlk(string3, cursorQuery.getLong(10), objY, string2), cursorQuery.getLong(8), z10, string4, zzauVar, j10, (zzau) this.f5039b.g0().B(cursorQuery.getBlob(9), creator), cursorQuery.getLong(11), (zzau) this.f5039b.g0().B(cursorQuery.getBlob(12), creator)));
                    if (!cursorQuery.moveToNext()) {
                        break;
                    }
                }
                cursorQuery.close();
                return arrayList;
            } catch (SQLiteException e10) {
                this.f5030a.d().r().b("Error querying conditional user property value", e10);
                List list = Collections.EMPTY_LIST;
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return list;
            }
        } catch (Throwable th) {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            throw th;
        }
    }

    public final List c0(String str) {
        String str2;
        t1.f.d(str);
        h();
        i();
        ArrayList arrayList = new ArrayList();
        Cursor cursorQuery = null;
        try {
            try {
                this.f5030a.z();
                cursorQuery = P().query("user_attributes", new String[]{"name", "origin", "set_timestamp", "value"}, "app_id=?", new String[]{str}, null, null, "rowid", "1000");
                try {
                    if (!cursorQuery.moveToFirst()) {
                        cursorQuery.close();
                        return arrayList;
                    }
                    while (true) {
                        String string = cursorQuery.getString(0);
                        String string2 = cursorQuery.getString(1);
                        if (string2 == null) {
                            string2 = "";
                        }
                        String str3 = string2;
                        long j10 = cursorQuery.getLong(2);
                        Object objY = Y(cursorQuery, 3);
                        if (objY == null) {
                            this.f5030a.d().r().b("Read invalid user property value, ignoring it. appId", v3.z(str));
                            str2 = str;
                        } else {
                            str2 = str;
                            try {
                                arrayList.add(new ta(str2, str3, string, j10, objY));
                            } catch (SQLiteException e10) {
                                e = e10;
                                this.f5030a.d().r().c("Error querying user properties. appId", v3.z(str2), e);
                                List list = Collections.EMPTY_LIST;
                                if (cursorQuery != null) {
                                    cursorQuery.close();
                                }
                                return list;
                            }
                        }
                        if (!cursorQuery.moveToNext()) {
                            cursorQuery.close();
                            return arrayList;
                        }
                        str = str2;
                    }
                } catch (SQLiteException e11) {
                    e = e11;
                    str2 = str;
                }
            } finally {
            }
        } catch (SQLiteException e12) {
            e = e12;
            str2 = str;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x00a6, code lost:
    
        r0 = r17.f5030a.d().r();
        r17.f5030a.z();
        r0.b("Read more than the max allowed user properties, ignoring excess", 1000);
     */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0121  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List d0(String str, String str2, String str3) {
        String str4;
        t1.f.d(str);
        h();
        i();
        ArrayList arrayList = new ArrayList();
        Cursor cursorQuery = null;
        try {
            try {
                ArrayList arrayList2 = new ArrayList(3);
                String str5 = str;
                arrayList2.add(str5);
                StringBuilder sb2 = new StringBuilder("app_id=?");
                if (TextUtils.isEmpty(str2)) {
                    str4 = str2;
                } else {
                    str4 = str2;
                    try {
                        arrayList2.add(str4);
                        sb2.append(" and origin=?");
                    } catch (SQLiteException e10) {
                        e = e10;
                        this.f5030a.d().r().d("(2)Error querying user properties", v3.z(str), str4, e);
                        List list = Collections.EMPTY_LIST;
                        if (cursorQuery != null) {
                        }
                        return list;
                    }
                }
                if (!TextUtils.isEmpty(str3)) {
                    arrayList2.add(str3 + "*");
                    sb2.append(" and name glob ?");
                }
                String[] strArr = (String[]) arrayList2.toArray(new String[arrayList2.size()]);
                String string = sb2.toString();
                this.f5030a.z();
                cursorQuery = P().query("user_attributes", new String[]{"name", "set_timestamp", "value", "origin"}, string, strArr, null, null, "rowid", "1001");
                if (!cursorQuery.moveToFirst()) {
                    cursorQuery.close();
                    return arrayList;
                }
                while (true) {
                    int size = arrayList.size();
                    this.f5030a.z();
                    if (size >= 1000) {
                        break;
                    }
                    String string2 = cursorQuery.getString(0);
                    long j10 = cursorQuery.getLong(1);
                    Object objY = Y(cursorQuery, 2);
                    String string3 = cursorQuery.getString(3);
                    if (objY == null) {
                        try {
                            this.f5030a.d().r().d("(2)Read invalid user property value, ignoring it", v3.z(str5), string3, str3);
                        } catch (SQLiteException e11) {
                            e = e11;
                            str4 = string3;
                            this.f5030a.d().r().d("(2)Error querying user properties", v3.z(str), str4, e);
                            List list2 = Collections.EMPTY_LIST;
                            if (cursorQuery != null) {
                                cursorQuery.close();
                            }
                            return list2;
                        }
                    } else {
                        arrayList.add(new ta(str5, string3, string2, j10, objY));
                    }
                    if (!cursorQuery.moveToNext()) {
                        break;
                    }
                    str5 = str;
                    str4 = string3;
                }
                cursorQuery.close();
                return arrayList;
            } catch (SQLiteException e12) {
                e = e12;
                str4 = str2;
            }
        } catch (Throwable th) {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            throw th;
        }
    }

    public final void e0() {
        i();
        P().beginTransaction();
    }

    public final void f0() {
        i();
        P().endTransaction();
    }

    public final void g0(List list) throws SQLException {
        h();
        i();
        t1.f.h(list);
        t1.f.j(list.size());
        if (u()) {
            String str = "(" + TextUtils.join(",", list) + ")";
            if (I("SELECT COUNT(1) FROM queue WHERE rowid IN " + str + " AND retry_count =  2147483647 LIMIT 1", null) > 0) {
                this.f5030a.d().w().a("The number of upload retries exceeds the limit. Will remain unchanged.");
            }
            try {
                P().execSQL("UPDATE queue SET retry_count = IFNULL(retry_count, 0) + 1 WHERE rowid IN " + str + " AND (retry_count IS NULL OR retry_count < 2147483647)");
            } catch (SQLiteException e10) {
                this.f5030a.d().r().b("Error incrementing retry count. error", e10);
            }
        }
    }

    public final void h0() {
        h();
        i();
        if (u()) {
            long jA = this.f5039b.e0().f5217e.a();
            long jB = this.f5030a.a().b();
            long jAbs = Math.abs(jB - jA);
            this.f5030a.z();
            if (jAbs > ((Long) i3.A.a(null)).longValue()) {
                this.f5039b.e0().f5217e.b(jB);
                h();
                i();
                if (u()) {
                    SQLiteDatabase sQLiteDatabaseP = P();
                    String strValueOf = String.valueOf(this.f5030a.a().a());
                    this.f5030a.z();
                    int iDelete = sQLiteDatabaseP.delete("queue", "abs(bundle_end_timestamp - ?) > cast(? as integer)", new String[]{strValueOf, String.valueOf(g.i())});
                    if (iDelete > 0) {
                        this.f5030a.d().v().b("Deleted stale rows. rowsDeleted", Integer.valueOf(iDelete));
                    }
                }
            }
        }
    }

    @Override // f2.ba
    public final boolean l() {
        return false;
    }

    public final void m(String str, String str2) {
        t1.f.d(str);
        t1.f.d(str2);
        h();
        i();
        try {
            P().delete("user_attributes", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e10) {
            this.f5030a.d().r().d("Error deleting user property. appId", v3.z(str), this.f5030a.D().f(str2), e10);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x031c, code lost:
    
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x031d, code lost:
    
        r12.put("filter_id", r0);
        r21 = r3;
        r12.put("property_name", r7.H());
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x032f, code lost:
    
        if (r7.N() == false) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x0331, code lost:
    
        r0 = java.lang.Boolean.valueOf(r7.L());
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x033a, code lost:
    
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x033b, code lost:
    
        r12.put("session_scoped", r0);
        r12.put("data", r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x034d, code lost:
    
        if (P().insertWithOnConflict("property_filters", null, r12, 5) != (-1)) goto L112;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x034f, code lost:
    
        r22.f5030a.d().r().b("Failed to insert property filter (got -1). appId", f2.v3.z(r23));
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x0363, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x0365, code lost:
    
        r0 = r19;
        r3 = r21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x036b, code lost:
    
        r22.f5030a.d().r().c("Error storing property filter. appId", f2.v3.z(r23), r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x037e, code lost:
    
        i();
        h();
        t1.f.d(r23);
        r0 = P();
        r0.delete("property_filters", "app_id=? and audience_id=?", new java.lang.String[]{r23, java.lang.String.valueOf(r10)});
        r0.delete("event_filters", "app_id=? and audience_id=?", new java.lang.String[]{r23, java.lang.String.valueOf(r10)});
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x03a1, code lost:
    
        r7 = r20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:141:0x0483, code lost:
    
        r20.endTransaction();
     */
    /* JADX WARN: Code restructure failed: missing block: B:142:0x0487, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0176, code lost:
    
        r11 = r0.K().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0182, code lost:
    
        if (r11.hasNext() == false) goto L170;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x018e, code lost:
    
        if (((com.google.android.gms.internal.measurement.i3) r11.next()).M() != false) goto L178;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0190, code lost:
    
        r22.f5030a.d().w().c("Property filter with no ID. Audience definition ignored. appId, audienceId", f2.v3.z(r23), java.lang.Integer.valueOf(r10));
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x01a9, code lost:
    
        r11 = r0.J().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x01b5, code lost:
    
        r19 = r0;
        r0 = "app_id";
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x01c3, code lost:
    
        if (r11.hasNext() == false) goto L179;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x01c5, code lost:
    
        r12 = (com.google.android.gms.internal.measurement.z2) r11.next();
        i();
        h();
        t1.f.d(r23);
        t1.f.h(r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x01df, code lost:
    
        if (r12.J().isEmpty() == false) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x01e1, code lost:
    
        r0 = r22.f5030a.d().w();
        r11 = f2.v3.z(r23);
        r13 = java.lang.Integer.valueOf(r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x01f9, code lost:
    
        if (r12.R() == false) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x01fb, code lost:
    
        r16 = java.lang.Integer.valueOf(r12.E());
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0206, code lost:
    
        r16 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0208, code lost:
    
        r0.d("Event filter had no event name. Audience definition ignored. appId, audienceId, filterId", r11, r13, java.lang.String.valueOf(r16));
        r20 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0213, code lost:
    
        r3 = r12.i();
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0217, code lost:
    
        r20 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0219, code lost:
    
        r7 = new android.content.ContentValues();
        r7.put("app_id", r23);
        r7.put("audience_id", java.lang.Integer.valueOf(r10));
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x022c, code lost:
    
        if (r12.R() == false) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x022e, code lost:
    
        r0 = java.lang.Integer.valueOf(r12.E());
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0237, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x023a, code lost:
    
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x023b, code lost:
    
        r7.put("filter_id", r0);
        r7.put("event_name", r12.J());
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x024b, code lost:
    
        if (r12.S() == false) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x024d, code lost:
    
        r0 = java.lang.Boolean.valueOf(r12.P());
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0256, code lost:
    
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0257, code lost:
    
        r7.put("session_scoped", r0);
        r7.put("data", r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0269, code lost:
    
        if (P().insertWithOnConflict("event_filters", null, r7, 5) != (-1)) goto L182;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x026b, code lost:
    
        r22.f5030a.d().r().b("Failed to insert event filter (got -1). appId", f2.v3.z(r23));
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x027e, code lost:
    
        r0 = r19;
        r7 = r20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0286, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0287, code lost:
    
        r22.f5030a.d().r().c("Error storing event filter. appId", f2.v3.z(r23), r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x029c, code lost:
    
        r20 = r7;
        r3 = r19.K().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x02aa, code lost:
    
        if (r3.hasNext() == false) goto L184;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x02ac, code lost:
    
        r7 = (com.google.android.gms.internal.measurement.i3) r3.next();
        i();
        h();
        t1.f.d(r23);
        t1.f.h(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x02c6, code lost:
    
        if (r7.H().isEmpty() == false) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x02c8, code lost:
    
        r0 = r22.f5030a.d().w();
        r9 = f2.v3.z(r23);
        r11 = java.lang.Integer.valueOf(r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x02e0, code lost:
    
        if (r7.M() == false) goto L95;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x02e2, code lost:
    
        r16 = java.lang.Integer.valueOf(r7.D());
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x02ed, code lost:
    
        r16 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x02ef, code lost:
    
        r0.d("Property filter had no property name. Audience definition ignored. appId, audienceId, filterId", r9, r11, java.lang.String.valueOf(r16));
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x02f8, code lost:
    
        r11 = r7.i();
        r12 = new android.content.ContentValues();
        r12.put(r0, r23);
        r19 = r0;
        r12.put("audience_id", java.lang.Integer.valueOf(r10));
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x0311, code lost:
    
        if (r7.M() == false) goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x0313, code lost:
    
        r0 = java.lang.Integer.valueOf(r7.D());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void n(String str, List list) throws Throwable {
        SQLiteDatabase sQLiteDatabase;
        boolean z10;
        t1.f.h(list);
        for (int i10 = 0; i10 < list.size(); i10++) {
            com.google.android.gms.internal.measurement.w2 w2Var = (com.google.android.gms.internal.measurement.w2) ((com.google.android.gms.internal.measurement.x2) list.get(i10)).m();
            if (w2Var.s() != 0) {
                for (int i11 = 0; i11 < w2Var.s(); i11++) {
                    com.google.android.gms.internal.measurement.y2 y2Var = (com.google.android.gms.internal.measurement.y2) w2Var.w(i11).m();
                    com.google.android.gms.internal.measurement.y2 y2Var2 = (com.google.android.gms.internal.measurement.y2) y2Var.clone();
                    String strB = g6.b(y2Var.w());
                    if (strB != null) {
                        y2Var2.t(strB);
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    int i12 = 0;
                    while (i12 < y2Var.s()) {
                        com.google.android.gms.internal.measurement.b3 b3VarV = y2Var.v(i12);
                        com.google.android.gms.internal.measurement.y2 y2Var3 = y2Var;
                        boolean z11 = z10;
                        String strA = u7.a(b3VarV.H(), h6.f5272a, h6.f5273b);
                        if (strA != null) {
                            com.google.android.gms.internal.measurement.a3 a3Var = (com.google.android.gms.internal.measurement.a3) b3VarV.m();
                            a3Var.s(strA);
                            y2Var2.u(i12, (com.google.android.gms.internal.measurement.b3) a3Var.o());
                            z10 = true;
                        } else {
                            z10 = z11;
                        }
                        i12++;
                        y2Var = y2Var3;
                    }
                    if (z10) {
                        w2Var.u(i11, y2Var2);
                        list.set(i10, (com.google.android.gms.internal.measurement.x2) w2Var.o());
                    }
                }
            }
            if (w2Var.t() != 0) {
                for (int i13 = 0; i13 < w2Var.t(); i13++) {
                    com.google.android.gms.internal.measurement.i3 i3VarX = w2Var.x(i13);
                    String strA2 = u7.a(i3VarX.H(), i6.f5350a, i6.f5351b);
                    if (strA2 != null) {
                        com.google.android.gms.internal.measurement.h3 h3Var = (com.google.android.gms.internal.measurement.h3) i3VarX.m();
                        h3Var.s(strA2);
                        w2Var.v(i13, h3Var);
                        list.set(i10, (com.google.android.gms.internal.measurement.x2) w2Var.o());
                    }
                }
            }
        }
        i();
        h();
        t1.f.d(str);
        t1.f.h(list);
        SQLiteDatabase sQLiteDatabaseP = P();
        sQLiteDatabaseP.beginTransaction();
        try {
            i();
            h();
            t1.f.d(str);
            SQLiteDatabase sQLiteDatabaseP2 = P();
            sQLiteDatabaseP2.delete("property_filters", "app_id=?", new String[]{str});
            sQLiteDatabaseP2.delete("event_filters", "app_id=?", new String[]{str});
            Iterator it = list.iterator();
            while (it.hasNext()) {
                com.google.android.gms.internal.measurement.x2 x2Var = (com.google.android.gms.internal.measurement.x2) it.next();
                i();
                h();
                t1.f.d(str);
                t1.f.h(x2Var);
                if (x2Var.N()) {
                    int iD = x2Var.D();
                    Iterator it2 = x2Var.J().iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            if (!((com.google.android.gms.internal.measurement.z2) it2.next()).R()) {
                                this.f5030a.d().w().c("Event filter with no ID. Audience definition ignored. appId, audienceId", v3.z(str), Integer.valueOf(iD));
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                } else {
                    this.f5030a.d().w().b("Audience with no ID. appId", v3.z(str));
                }
            }
            sQLiteDatabase = sQLiteDatabaseP;
            ArrayList arrayList = new ArrayList();
            Iterator it3 = list.iterator();
            while (it3.hasNext()) {
                com.google.android.gms.internal.measurement.x2 x2Var2 = (com.google.android.gms.internal.measurement.x2) it3.next();
                arrayList.add(x2Var2.N() ? Integer.valueOf(x2Var2.D()) : null);
            }
            t1.f.d(str);
            i();
            h();
            SQLiteDatabase sQLiteDatabaseP3 = P();
            try {
                long jI = I("select count(1) from audience_filter_values where app_id=?", new String[]{str});
                int i14 = 0;
                int iMax = Math.max(0, Math.min(2000, this.f5030a.z().o(str, i3.H)));
                if (jI > iMax) {
                    ArrayList arrayList2 = new ArrayList();
                    while (true) {
                        if (i14 >= arrayList.size()) {
                            sQLiteDatabaseP3.delete("audience_filter_values", "audience_id in (select audience_id from audience_filter_values where app_id=? and audience_id not in " + ("(" + TextUtils.join(",", arrayList2) + ")") + " order by rowid desc limit -1 offset ?)", new String[]{str, Integer.toString(iMax)});
                            break;
                        }
                        Integer num = (Integer) arrayList.get(i14);
                        if (num == null) {
                            break;
                        }
                        arrayList2.add(Integer.toString(num.intValue()));
                        i14++;
                    }
                }
            } catch (SQLiteException e10) {
                this.f5030a.d().r().c("Database error querying filters. appId", v3.z(str), e10);
            }
            sQLiteDatabase.setTransactionSuccessful();
            sQLiteDatabase.endTransaction();
        } catch (Throwable th) {
            th = th;
            sQLiteDatabase = sQLiteDatabaseP;
        }
    }

    public final void o() {
        i();
        P().setTransactionSuccessful();
    }

    public final void p(e6 e6Var) {
        t1.f.h(e6Var);
        h();
        i();
        String strL0 = e6Var.l0();
        t1.f.h(strL0);
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", strL0);
        contentValues.put("app_instance_id", e6Var.m0());
        contentValues.put("gmp_app_id", e6Var.a());
        contentValues.put("resettable_device_id_hash", e6Var.c());
        contentValues.put("last_bundle_index", Long.valueOf(e6Var.e0()));
        contentValues.put("last_bundle_start_timestamp", Long.valueOf(e6Var.f0()));
        contentValues.put("last_bundle_end_timestamp", Long.valueOf(e6Var.d0()));
        contentValues.put("app_version", e6Var.o0());
        contentValues.put("app_store", e6Var.n0());
        contentValues.put("gmp_version", Long.valueOf(e6Var.c0()));
        contentValues.put("dev_cert_hash", Long.valueOf(e6Var.Z()));
        contentValues.put("measurement_enabled", Boolean.valueOf(e6Var.O()));
        contentValues.put("day", Long.valueOf(e6Var.Y()));
        contentValues.put("daily_public_events_count", Long.valueOf(e6Var.W()));
        contentValues.put("daily_events_count", Long.valueOf(e6Var.V()));
        contentValues.put("daily_conversions_count", Long.valueOf(e6Var.T()));
        contentValues.put("config_fetched_time", Long.valueOf(e6Var.S()));
        contentValues.put("failed_config_fetch_time", Long.valueOf(e6Var.b0()));
        contentValues.put("app_version_int", Long.valueOf(e6Var.R()));
        contentValues.put("firebase_instance_id", e6Var.p0());
        contentValues.put("daily_error_events_count", Long.valueOf(e6Var.U()));
        contentValues.put("daily_realtime_events_count", Long.valueOf(e6Var.X()));
        contentValues.put("health_monitor_sample", e6Var.b());
        e6Var.A();
        contentValues.put("android_id", (Long) 0L);
        contentValues.put("adid_reporting_enabled", Boolean.valueOf(e6Var.N()));
        contentValues.put("admob_app_id", e6Var.j0());
        contentValues.put("dynamite_version", Long.valueOf(e6Var.a0()));
        contentValues.put("session_stitching_token", e6Var.d());
        contentValues.put("sgtm_upload_enabled", Boolean.valueOf(e6Var.Q()));
        contentValues.put("target_os_version", Long.valueOf(e6Var.h0()));
        contentValues.put("session_stitching_token_hash", Long.valueOf(e6Var.g0()));
        List listE = e6Var.e();
        if (listE != null) {
            if (listE.isEmpty()) {
                this.f5030a.d().w().b("Safelisted events should not be an empty list. appId", strL0);
            } else {
                contentValues.put("safelisted_events", TextUtils.join(",", listE));
            }
        }
        tb.b();
        if (this.f5030a.z().B(null, i3.f5320m0) && !contentValues.containsKey("safelisted_events")) {
            contentValues.put("safelisted_events", (String) null);
        }
        try {
            SQLiteDatabase sQLiteDatabaseP = P();
            if (sQLiteDatabaseP.update("apps", contentValues, "app_id = ?", new String[]{strL0}) == 0 && sQLiteDatabaseP.insertWithOnConflict("apps", null, contentValues, 5) == -1) {
                this.f5030a.d().r().b("Failed to insert/update app (got -1). appId", v3.z(strL0));
            }
        } catch (SQLiteException e10) {
            this.f5030a.d().r().c("Error storing app. appId", v3.z(strL0), e10);
        }
    }

    public final void q(q qVar) {
        t1.f.h(qVar);
        h();
        i();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", qVar.f5613a);
        contentValues.put("name", qVar.f5614b);
        contentValues.put("lifetime_count", Long.valueOf(qVar.f5615c));
        contentValues.put("current_bundle_count", Long.valueOf(qVar.f5616d));
        contentValues.put("last_fire_timestamp", Long.valueOf(qVar.f5618f));
        contentValues.put("last_bundled_timestamp", Long.valueOf(qVar.f5619g));
        contentValues.put("last_bundled_day", qVar.f5620h);
        contentValues.put("last_sampled_complex_event_id", qVar.f5621i);
        contentValues.put("last_sampling_rate", qVar.f5622j);
        contentValues.put("current_session_count", Long.valueOf(qVar.f5617e));
        Boolean bool = qVar.f5623k;
        contentValues.put("last_exempt_from_sampling", (bool == null || !bool.booleanValue()) ? null : 1L);
        try {
            if (P().insertWithOnConflict("events", null, contentValues, 5) == -1) {
                this.f5030a.d().r().b("Failed to insert/update event aggregates (got -1). appId", v3.z(qVar.f5613a));
            }
        } catch (SQLiteException e10) {
            this.f5030a.d().r().c("Error storing event aggregates. appId", v3.z(qVar.f5613a), e10);
        }
    }

    public final boolean r() {
        return I("select count(1) > 0 from raw_events", null) != 0;
    }

    public final boolean s() {
        return I("select count(1) > 0 from queue where has_realtime = 1", null) != 0;
    }

    public final boolean t() {
        return I("select count(1) > 0 from raw_events where realtime = 1", null) != 0;
    }

    public final boolean u() {
        Context contextC = this.f5030a.c();
        this.f5030a.z();
        return contextC.getDatabasePath("google_app_measurement.db").exists();
    }

    public final boolean v(String str, Long l10, long j10, com.google.android.gms.internal.measurement.j4 j4Var) {
        h();
        i();
        t1.f.h(j4Var);
        t1.f.d(str);
        t1.f.h(l10);
        byte[] bArrI = j4Var.i();
        this.f5030a.d().v().c("Saving complex main event, appId, data size", this.f5030a.D().d(str), Integer.valueOf(bArrI.length));
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("event_id", l10);
        contentValues.put("children_to_process", Long.valueOf(j10));
        contentValues.put("main_event", bArrI);
        try {
            if (P().insertWithOnConflict("main_event_params", null, contentValues, 5) != -1) {
                return true;
            }
            this.f5030a.d().r().b("Failed to insert complex main event (got -1). appId", v3.z(str));
            return false;
        } catch (SQLiteException e10) {
            this.f5030a.d().r().c("Error storing complex main event. appId", v3.z(str), e10);
            return false;
        }
    }

    public final boolean w(zzac zzacVar) {
        t1.f.h(zzacVar);
        h();
        i();
        String str = zzacVar.f3952e;
        t1.f.h(str);
        if (X(str, zzacVar.f3954k.f3970j) == null) {
            long jI = I("SELECT COUNT(1) FROM conditional_properties WHERE app_id=?", new String[]{str});
            this.f5030a.z();
            if (jI >= 1000) {
                return false;
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("origin", zzacVar.f3953j);
        contentValues.put("name", zzacVar.f3954k.f3970j);
        H(contentValues, "value", t1.f.h(zzacVar.f3954k.c()));
        contentValues.put("active", Boolean.valueOf(zzacVar.f3956m));
        contentValues.put("trigger_event_name", zzacVar.f3957n);
        contentValues.put("trigger_timeout", Long.valueOf(zzacVar.f3959p));
        contentValues.put("timed_out_event", this.f5030a.N().e0(zzacVar.f3958o));
        contentValues.put("creation_timestamp", Long.valueOf(zzacVar.f3955l));
        contentValues.put("triggered_event", this.f5030a.N().e0(zzacVar.f3960q));
        contentValues.put("triggered_timestamp", Long.valueOf(zzacVar.f3954k.f3971k));
        contentValues.put("time_to_live", Long.valueOf(zzacVar.f3961r));
        contentValues.put("expired_event", this.f5030a.N().e0(zzacVar.f3962s));
        try {
            if (P().insertWithOnConflict("conditional_properties", null, contentValues, 5) != -1) {
                return true;
            }
            this.f5030a.d().r().b("Failed to insert/update conditional user property (got -1)", v3.z(str));
            return true;
        } catch (SQLiteException e10) {
            this.f5030a.d().r().c("Error storing conditional user property", v3.z(str), e10);
            return true;
        }
    }

    public final boolean x(ta taVar) {
        t1.f.h(taVar);
        h();
        i();
        if (X(taVar.f5714a, taVar.f5716c) == null) {
            if (wa.Z(taVar.f5716c)) {
                if (I("select count(1) from user_attributes where app_id=? and name not like '!_%' escape '!'", new String[]{taVar.f5714a}) >= this.f5030a.z().p(taVar.f5714a, i3.I, 25, 100)) {
                    return false;
                }
            } else if (!"_npa".equals(taVar.f5716c)) {
                long jI = I("select count(1) from user_attributes where app_id=? and origin=? AND name like '!_%' escape '!'", new String[]{taVar.f5714a, taVar.f5715b});
                this.f5030a.z();
                if (jI >= 25) {
                    return false;
                }
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", taVar.f5714a);
        contentValues.put("origin", taVar.f5715b);
        contentValues.put("name", taVar.f5716c);
        contentValues.put("set_timestamp", Long.valueOf(taVar.f5717d));
        H(contentValues, "value", taVar.f5718e);
        try {
            if (P().insertWithOnConflict("user_attributes", null, contentValues, 5) != -1) {
                return true;
            }
            this.f5030a.d().r().b("Failed to insert/update user property (got -1). appId", v3.z(taVar.f5714a));
            return true;
        } catch (SQLiteException e10) {
            this.f5030a.d().r().c("Error storing user property. appId", v3.z(taVar.f5714a), e10);
            return true;
        }
    }
}
