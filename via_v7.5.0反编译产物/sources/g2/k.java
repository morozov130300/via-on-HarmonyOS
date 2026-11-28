package g2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
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

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class k extends ba {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String[] f5014f = {"last_bundled_timestamp", "ALTER TABLE events ADD COLUMN last_bundled_timestamp INTEGER;", "last_bundled_day", "ALTER TABLE events ADD COLUMN last_bundled_day INTEGER;", "last_sampled_complex_event_id", "ALTER TABLE events ADD COLUMN last_sampled_complex_event_id INTEGER;", "last_sampling_rate", "ALTER TABLE events ADD COLUMN last_sampling_rate INTEGER;", "last_exempt_from_sampling", "ALTER TABLE events ADD COLUMN last_exempt_from_sampling INTEGER;", "current_session_count", "ALTER TABLE events ADD COLUMN current_session_count INTEGER;"};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String[] f5015g = {"origin", "ALTER TABLE user_attributes ADD COLUMN origin TEXT;"};

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String[] f5016h = {"app_version", "ALTER TABLE apps ADD COLUMN app_version TEXT;", "app_store", "ALTER TABLE apps ADD COLUMN app_store TEXT;", "gmp_version", "ALTER TABLE apps ADD COLUMN gmp_version INTEGER;", "dev_cert_hash", "ALTER TABLE apps ADD COLUMN dev_cert_hash INTEGER;", "measurement_enabled", "ALTER TABLE apps ADD COLUMN measurement_enabled INTEGER;", "last_bundle_start_timestamp", "ALTER TABLE apps ADD COLUMN last_bundle_start_timestamp INTEGER;", "day", "ALTER TABLE apps ADD COLUMN day INTEGER;", "daily_public_events_count", "ALTER TABLE apps ADD COLUMN daily_public_events_count INTEGER;", "daily_events_count", "ALTER TABLE apps ADD COLUMN daily_events_count INTEGER;", "daily_conversions_count", "ALTER TABLE apps ADD COLUMN daily_conversions_count INTEGER;", "remote_config", "ALTER TABLE apps ADD COLUMN remote_config BLOB;", "config_fetched_time", "ALTER TABLE apps ADD COLUMN config_fetched_time INTEGER;", "failed_config_fetch_time", "ALTER TABLE apps ADD COLUMN failed_config_fetch_time INTEGER;", "app_version_int", "ALTER TABLE apps ADD COLUMN app_version_int INTEGER;", "firebase_instance_id", "ALTER TABLE apps ADD COLUMN firebase_instance_id TEXT;", "daily_error_events_count", "ALTER TABLE apps ADD COLUMN daily_error_events_count INTEGER;", "daily_realtime_events_count", "ALTER TABLE apps ADD COLUMN daily_realtime_events_count INTEGER;", "health_monitor_sample", "ALTER TABLE apps ADD COLUMN health_monitor_sample TEXT;", "android_id", "ALTER TABLE apps ADD COLUMN android_id INTEGER;", "adid_reporting_enabled", "ALTER TABLE apps ADD COLUMN adid_reporting_enabled INTEGER;", "ssaid_reporting_enabled", "ALTER TABLE apps ADD COLUMN ssaid_reporting_enabled INTEGER;", "admob_app_id", "ALTER TABLE apps ADD COLUMN admob_app_id TEXT;", "linked_admob_app_id", "ALTER TABLE apps ADD COLUMN linked_admob_app_id TEXT;", "dynamite_version", "ALTER TABLE apps ADD COLUMN dynamite_version INTEGER;", "safelisted_events", "ALTER TABLE apps ADD COLUMN safelisted_events TEXT;", "ga_app_id", "ALTER TABLE apps ADD COLUMN ga_app_id TEXT;", "config_last_modified_time", "ALTER TABLE apps ADD COLUMN config_last_modified_time TEXT;", "e_tag", "ALTER TABLE apps ADD COLUMN e_tag TEXT;", "session_stitching_token", "ALTER TABLE apps ADD COLUMN session_stitching_token TEXT;", "sgtm_upload_enabled", "ALTER TABLE apps ADD COLUMN sgtm_upload_enabled INTEGER;", "target_os_version", "ALTER TABLE apps ADD COLUMN target_os_version INTEGER;", "session_stitching_token_hash", "ALTER TABLE apps ADD COLUMN session_stitching_token_hash INTEGER;"};

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String[] f5017i = {"realtime", "ALTER TABLE raw_events ADD COLUMN realtime INTEGER;"};

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String[] f5018j = {"has_realtime", "ALTER TABLE queue ADD COLUMN has_realtime INTEGER;", "retry_count", "ALTER TABLE queue ADD COLUMN retry_count INTEGER;"};

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String[] f5019k = {"session_scoped", "ALTER TABLE event_filters ADD COLUMN session_scoped BOOLEAN;"};

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String[] f5020l = {"session_scoped", "ALTER TABLE property_filters ADD COLUMN session_scoped BOOLEAN;"};

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String[] f5021m = {"previous_install_count", "ALTER TABLE app2 ADD COLUMN previous_install_count INTEGER;"};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final j f5022d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final v9 f5023e;

    public k(pa paVar) {
        super(paVar);
        this.f5023e = new v9(this.f4646a.a());
        this.f4646a.z();
        this.f5022d = new j(this, this.f4646a.c(), "google_app_measurement.db");
    }

    public static final void H(ContentValues contentValues, String str, Object obj) {
        u1.f.d("value");
        u1.f.h(obj);
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

    /* JADX WARN: Code duplicated, block: B:114:0x0220  */
    /* JADX WARN: Code duplicated, block: B:117:0x0226  */
    /* JADX WARN: Code duplicated, block: B:139:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v0 */
    /* JADX WARN: Type inference failed for: r15v1 */
    /* JADX WARN: Type inference failed for: r15v2 */
    /* JADX WARN: Type inference failed for: r15v3 */
    /* JADX WARN: Type inference failed for: r15v4 */
    /* JADX WARN: Type inference failed for: r15v6 */
    /* JADX WARN: Type inference failed for: r15v7 */
    /* JADX WARN: Type inference failed for: r15v8 */
    /* JADX WARN: Type inference failed for: r17v0 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9 */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v14 */
    /* JADX WARN: Type inference failed for: r5v17 */
    /* JADX WARN: Type inference failed for: r5v2, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r5v23, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v28 */
    /* JADX WARN: Type inference failed for: r5v29 */
    /* JADX WARN: Type inference failed for: r5v3, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v30 */
    /* JADX WARN: Type inference failed for: r5v31 */
    /* JADX WARN: Type inference failed for: r5v32 */
    /* JADX WARN: Type inference failed for: r5v33 */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v1, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r6v18, types: [java.lang.StringBuilder] */
    public final void G(String str, long j10, long j11, ma maVar) throws Throwable {
        ?? r10;
        String string;
        String str2;
        String[] strArr;
        u1.f.h(maVar);
        h();
        i();
        ?? r11 = 0;
        string = null;
        string = null;
        String string2 = null;
        try {
            try {
                SQLiteDatabase sQLiteDatabaseP = P();
                r10 = "";
                ?? r15 = -1;
                ?? r16 = -1;
                try {
                    if (TextUtils.isEmpty(null)) {
                        String[] strArr2 = j11 != -1 ? new String[]{String.valueOf(j11), String.valueOf(j10)} : new String[]{String.valueOf(j10)};
                        ?? r12 = r10;
                        if (j11 != -1) {
                            r12 = "rowid <= ? and ";
                        }
                        Cursor cursorRawQuery = sQLiteDatabaseP.rawQuery("select app_id, metadata_fingerprint from raw_events where " + r12 + "app_id in (select app_id from apps where config_fetched_time >= ?) order by rowid limit 1;", strArr2);
                        if (!cursorRawQuery.moveToFirst()) {
                            cursorRawQuery.close();
                            return;
                        }
                        string2 = cursorRawQuery.getString(0);
                        string = cursorRawQuery.getString(1);
                        cursorRawQuery.close();
                        r10 = cursorRawQuery;
                    } else {
                        String[] strArr3 = j11 != -1 ? new String[]{null, String.valueOf(j11)} : new String[]{null};
                        ?? r13 = r10;
                        if (j11 != -1) {
                            r13 = " and rowid <= ?";
                        }
                        Cursor cursorRawQuery2 = sQLiteDatabaseP.rawQuery("select metadata_fingerprint from raw_events where app_id = ?" + r13 + " order by rowid limit 1;", strArr3);
                        if (!cursorRawQuery2.moveToFirst()) {
                            cursorRawQuery2.close();
                            return;
                        } else {
                            string = cursorRawQuery2.getString(0);
                            cursorRawQuery2.close();
                            r10 = cursorRawQuery2;
                        }
                    }
                    ?? r17 = r10;
                    try {
                        Cursor cursorQuery = sQLiteDatabaseP.query("raw_events_metadata", new String[]{"metadata"}, "app_id = ? and metadata_fingerprint = ?", new String[]{string2, string}, null, null, "rowid", "2");
                        try {
                            if (!cursorQuery.moveToFirst()) {
                                this.f4646a.d().r().b("Raw event metadata record is missing. appId", v3.z(string2));
                                cursorQuery.close();
                                return;
                            }
                            try {
                                try {
                                    com.google.android.gms.internal.measurement.u4 u4Var = (com.google.android.gms.internal.measurement.u4) ((com.google.android.gms.internal.measurement.t4) ra.E(com.google.android.gms.internal.measurement.u4.S1(), cursorQuery.getBlob(0))).o();
                                    if (cursorQuery.moveToNext()) {
                                        this.f4646a.d().w().b("Get multiple raw event metadata records, expected one. appId", v3.z(string2));
                                    }
                                    cursorQuery.close();
                                    u1.f.h(u4Var);
                                    maVar.f5124a = u4Var;
                                    if (j11 != -1) {
                                        str2 = "app_id = ? and metadata_fingerprint = ? and rowid <= ?";
                                        strArr = new String[]{string2, string, String.valueOf(j11)};
                                    } else {
                                        str2 = "app_id = ? and metadata_fingerprint = ?";
                                        strArr = new String[]{string2, string};
                                    }
                                    try {
                                        Cursor cursorQuery2 = sQLiteDatabaseP.query("raw_events", new String[]{"rowid", "name", "timestamp", "data"}, str2, strArr, null, null, "rowid", null);
                                        try {
                                            if (!cursorQuery2.moveToFirst()) {
                                                this.f4646a.d().w().b("Raw event data disappeared while in transaction. appId", v3.z(string2));
                                                cursorQuery2.close();
                                                return;
                                            }
                                            do {
                                                long j12 = cursorQuery2.getLong(0);
                                                try {
                                                    com.google.android.gms.internal.measurement.i4 i4Var = (com.google.android.gms.internal.measurement.i4) ra.E(com.google.android.gms.internal.measurement.j4.H(), cursorQuery2.getBlob(3));
                                                    i4Var.A(cursorQuery2.getString(1));
                                                    i4Var.E(cursorQuery2.getLong(2));
                                                    if (!maVar.a(j12, (com.google.android.gms.internal.measurement.j4) i4Var.o())) {
                                                        cursorQuery2.close();
                                                        return;
                                                    }
                                                } catch (IOException e10) {
                                                    this.f4646a.d().r().c("Data loss. Failed to merge raw event. appId", v3.z(string2), e10);
                                                }
                                            } while (cursorQuery2.moveToNext());
                                            cursorQuery2.close();
                                        } catch (SQLiteException e11) {
                                            e = e11;
                                            r10 = cursorQuery2;
                                            this.f4646a.d().r().c("Data loss. Error selecting raw event. appId", v3.z(string2), e);
                                            if (r10 != 0) {
                                                r10.close();
                                            }
                                        } catch (Throwable th) {
                                            th = th;
                                            r11 = cursorQuery2;
                                            if (r11 != 0) {
                                                r11.close();
                                            }
                                            throw th;
                                        }
                                    } catch (SQLiteException e12) {
                                        e = e12;
                                        r16 = cursorQuery;
                                        r10 = r16;
                                        this.f4646a.d().r().c("Data loss. Error selecting raw event. appId", v3.z(string2), e);
                                        if (r10 != 0) {
                                            r10.close();
                                        }
                                    } catch (Throwable th2) {
                                        th = th2;
                                        r15 = cursorQuery;
                                        r11 = r15;
                                        if (r11 != 0) {
                                            r11.close();
                                        }
                                        throw th;
                                    }
                                } catch (IOException e13) {
                                    this.f4646a.d().r().c("Data loss. Failed to merge raw event metadata. appId", v3.z(string2), e13);
                                    cursorQuery.close();
                                }
                            } catch (SQLiteException e14) {
                                e = e14;
                            } catch (Throwable th3) {
                                th = th3;
                            }
                        } catch (SQLiteException e15) {
                            e = e15;
                            r16 = cursorQuery;
                        } catch (Throwable th4) {
                            th = th4;
                            r15 = cursorQuery;
                        }
                    } catch (SQLiteException e16) {
                        e = e16;
                        r10 = r17;
                    } catch (Throwable th5) {
                        th = th5;
                        r11 = r17;
                    }
                } catch (SQLiteException e17) {
                    e = e17;
                }
            } catch (Throwable th6) {
                th = th6;
                r11 = r10;
            }
        } catch (SQLiteException e18) {
            e = e18;
            r10 = 0;
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
                this.f4646a.d().r().c("Database error", str, e10);
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
        u1.f.d(str);
        u1.f.d(str2);
        h();
        i();
        try {
            return P().delete("conditional_properties", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e10) {
            this.f4646a.d().r().d("Error deleting conditional property", v3.z(str), this.f4646a.D().f(str2), e10);
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
                this.f4646a.d().r().c("Database error", str, e10);
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
        u1.f.d(str);
        u1.f.d("first_open_count");
        h();
        i();
        SQLiteDatabase sQLiteDatabaseP = P();
        sQLiteDatabaseP.beginTransaction();
        long j10 = 0;
        try {
            try {
                long jK = K("select first_open_count from app2 where app_id=?", new String[]{str}, -1L);
                if (jK == -1) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("app_id", str);
                    contentValues.put("first_open_count", (Integer) 0);
                    contentValues.put("previous_install_count", (Integer) 0);
                    if (sQLiteDatabaseP.insertWithOnConflict("app2", null, contentValues, 5) == -1) {
                        this.f4646a.d().r().c("Failed to insert column (got -1). appId", v3.z(str), "first_open_count");
                        return -1L;
                    }
                    jK = 0;
                    this.f4646a.d().r().d("Error inserting column. appId", v3.z(str), "first_open_count", e);
                    return j10;
                }
                try {
                    ContentValues contentValues2 = new ContentValues();
                    contentValues2.put("app_id", str);
                    contentValues2.put("first_open_count", Long.valueOf(1 + jK));
                    if (sQLiteDatabaseP.update("app2", contentValues2, "app_id = ?", new String[]{str}) == 0) {
                        this.f4646a.d().r().c("Failed to update column (got 0). appId", v3.z(str), "first_open_count");
                        return -1L;
                    }
                    sQLiteDatabaseP.setTransactionSuccessful();
                    return jK;
                } catch (SQLiteException e10) {
                    e = e10;
                    j10 = jK;
                }
            } catch (SQLiteException e11) {
                e = e11;
            }
        } finally {
            sQLiteDatabaseP.endTransaction();
        }
    }

    public final long M() {
        return K("select max(bundle_end_timestamp) from queue", null, 0L);
    }

    public final long N() {
        return K("select max(timestamp) from raw_events", null, 0L);
    }

    public final long O(String str) {
        u1.f.d(str);
        return K("select count(1) from events where app_id=? and name not like '!_%' escape '!'", new String[]{str}, 0L);
    }

    public final SQLiteDatabase P() {
        h();
        try {
            return this.f5022d.getWritableDatabase();
        } catch (SQLiteException e10) {
            this.f4646a.d().w().b("Error opening database", e10);
            throw e10;
        }
    }

    /* JADX WARN: Code duplicated, block: B:48:0x00dc  */
    /* JADX WARN: Not initialized variable reg: 1, insn: 0x00bf: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]) (LINE:192), block:B:38:0x00bf */
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
                        this.f4646a.d().v().a("Default event parameters not found");
                        cursorRawQuery.close();
                        return null;
                    }
                    try {
                        com.google.android.gms.internal.measurement.j4 j4Var = (com.google.android.gms.internal.measurement.j4) ((com.google.android.gms.internal.measurement.i4) ra.E(com.google.android.gms.internal.measurement.j4.H(), cursorRawQuery.getBlob(0))).o();
                        this.f4655b.g0();
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
                        this.f4646a.d().r().c("Failed to retrieve default event parameters. appId", v3.z(str), e10);
                        cursorRawQuery.close();
                        return null;
                    }
                } catch (SQLiteException e11) {
                    e = e11;
                    this.f4646a.d().r().b("Error selecting default event parameters", e);
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
                cursor2.close();
            }
            throw th;
        }
    }

    public final e6 R(String str) {
        Cursor cursorQuery;
        u1.f.d(str);
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
                    e6 e6Var = new e6(this.f4655b.b0(), str);
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
                    if (this.f4646a.z().B(str, i3.f4944q0) || this.f4646a.z().B(null, i3.f4940o0)) {
                        e6Var.J(cursorQuery.getString(28));
                    }
                    ke.b();
                    if (this.f4646a.z().B(null, i3.f4948s0)) {
                        if (!cursorQuery.isNull(29) && cursorQuery.getInt(29) != 0) {
                            z10 = true;
                        }
                        e6Var.L(z10);
                    }
                    ed.b();
                    if (this.f4646a.z().B(null, i3.G0)) {
                        e6Var.M(cursorQuery.getLong(30));
                    }
                    if (this.f4646a.z().B(null, i3.J0)) {
                        e6Var.K(cursorQuery.getLong(31));
                    }
                    e6Var.f();
                    if (cursorQuery.moveToNext()) {
                        this.f4646a.d().r().b("Got multiple records for app, expected one. appId", v3.z(str));
                    }
                    cursorQuery.close();
                    return e6Var;
                } catch (SQLiteException e10) {
                    e = e10;
                    this.f4646a.d().r().c("Error querying app. appId", v3.z(str), e);
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                cursor = cursorQuery;
            }
        } catch (SQLiteException e11) {
            e = e11;
            cursorQuery = null;
        } catch (Throwable th2) {
            th = th2;
        }
        th = th;
        cursor = cursorQuery;
        if (cursor != null) {
            cursor.close();
        }
        throw th;
    }

    /* JADX WARN: Code duplicated, block: B:41:0x012a  */
    public final zzac S(String str, String str2) throws Throwable {
        String str3;
        Cursor cursorQuery;
        u1.f.d(str);
        u1.f.d(str2);
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
                    ra raVarG0 = this.f4655b.g0();
                    byte[] blob = cursorQuery.getBlob(5);
                    Parcelable.Creator<zzau> creator = zzau.CREATOR;
                    zzau zzauVar = (zzau) raVarG0.B(blob, creator);
                    long j11 = cursorQuery.getLong(6);
                    zzau zzauVar2 = (zzau) this.f4655b.g0().B(cursorQuery.getBlob(7), creator);
                    long j12 = cursorQuery.getLong(8);
                    long j13 = cursorQuery.getLong(9);
                    zzau zzauVar3 = (zzau) this.f4655b.g0().B(cursorQuery.getBlob(10), creator);
                    str3 = str2;
                    try {
                        zzac zzacVar = new zzac(str, str4, new zzlk(str3, j12, objY, str4), j11, z10, string2, zzauVar, j10, zzauVar2, j13, zzauVar3);
                        if (cursorQuery.moveToNext()) {
                            this.f4646a.d().r().c("Got multiple records for conditional property, expected one", v3.z(str), this.f4646a.D().f(str3));
                        }
                        cursorQuery.close();
                        return zzacVar;
                    } catch (SQLiteException e10) {
                        e = e10;
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
                cursor.close();
            }
            throw th;
        }
        this.f4646a.d().r().d("Error querying conditional property", v3.z(str), this.f4646a.D().f(str3), e);
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        return null;
    }

    public final i T(long j10, String str, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14) {
        return U(j10, str, 1L, false, false, z12, false, z14);
    }

    public final i U(long j10, String str, long j11, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14) {
        u1.f.d(str);
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
                    this.f4646a.d().w().b("Not updating daily counts, app is not known. appId", v3.z(str));
                    cursorQuery.close();
                    return iVar;
                }
                if (cursorQuery.getLong(0) == j10) {
                    iVar.f4904b = cursorQuery.getLong(1);
                    iVar.f4903a = cursorQuery.getLong(2);
                    iVar.f4905c = cursorQuery.getLong(3);
                    iVar.f4906d = cursorQuery.getLong(4);
                    iVar.f4907e = cursorQuery.getLong(5);
                }
                if (z10) {
                    iVar.f4904b += j11;
                }
                if (z11) {
                    iVar.f4903a += j11;
                }
                if (z12) {
                    iVar.f4905c += j11;
                }
                if (z13) {
                    iVar.f4906d += j11;
                }
                if (z14) {
                    iVar.f4907e += j11;
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put("day", Long.valueOf(j10));
                contentValues.put("daily_public_events_count", Long.valueOf(iVar.f4903a));
                contentValues.put("daily_events_count", Long.valueOf(iVar.f4904b));
                contentValues.put("daily_conversions_count", Long.valueOf(iVar.f4905c));
                contentValues.put("daily_error_events_count", Long.valueOf(iVar.f4906d));
                contentValues.put("daily_realtime_events_count", Long.valueOf(iVar.f4907e));
                sQLiteDatabaseP.update("apps", contentValues, "app_id=?", strArr);
                cursorQuery.close();
                return iVar;
            } catch (SQLiteException e10) {
                this.f4646a.d().r().c("Error updating daily counts. appId", v3.z(str), e10);
                if (0 != 0) {
                    cursor.close();
                }
                return iVar;
            }
        } catch (Throwable th) {
            if (0 == 0) {
                throw th;
            }
            cursor.close();
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:54:0x0133  */
    /* JADX WARN: Multi-variable type inference failed */
    public final q V(String str, String str2) {
        Cursor cursorQuery;
        Boolean boolValueOf;
        u1.f.d(str);
        u1.f.d(str2);
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
                        this.f4646a.d().r().b("Got multiple records for event aggregates, expected one. appId", v3.z(str));
                    }
                    cursorQuery.close();
                    return qVar;
                } catch (SQLiteException e10) {
                    e = e10;
                    this.f4646a.d().r().d("Error querying events. appId", v3.z(str), this.f4646a.D().d(str2), e);
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
                sQLiteCursor.close();
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
        u1.f.d(str);
        u1.f.d(str2);
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
                            this.f4646a.d().r().b("Got multiple records for user property, expected one. appId", v3.z(str3));
                        }
                        cursorQuery.close();
                        return taVar;
                    } catch (SQLiteException e10) {
                        e = e10;
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
            sQLiteException = e;
        } catch (SQLiteException e12) {
            str3 = str;
            str4 = str2;
            sQLiteException = e12;
            cursorQuery = null;
        } catch (Throwable th3) {
            th = th3;
        }
        this.f4646a.d().r().d("Error querying user property. appId", v3.z(str3), this.f4646a.D().f(str4), sQLiteException);
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        return null;
    }

    public final Object Y(Cursor cursor, int i10) {
        int type = cursor.getType(i10);
        if (type == 0) {
            this.f4646a.d().r().a("Loaded invalid null value from database");
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
            this.f4646a.d().r().b("Loaded invalid unknown value type, ignoring it", Integer.valueOf(type));
            return null;
        }
        this.f4646a.d().r().a("Loaded invalid blob type value, ignoring it");
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0042  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r1v3 */
    public final String Z() throws Throwable {
        SQLiteException e10;
        Cursor cursorRawQuery;
        SQLiteDatabase sQLiteDatabaseP = P();
        ?? r10 = 0;
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
                    this.f4646a.d().r().b("Database error getting next bundle app id", e10);
                    if (cursorRawQuery != null) {
                        cursorRawQuery.close();
                    }
                    return null;
                }
            } catch (Throwable th) {
                r10 = sQLiteDatabaseP;
                th = th;
                if (r10 != 0) {
                    r10.close();
                }
                throw th;
            }
        } catch (SQLiteException e12) {
            e10 = e12;
            cursorRawQuery = null;
        } catch (Throwable th2) {
            th = th2;
            if (r10 != 0) {
                r10.close();
            }
            throw th;
        }
    }

    public final List a0(String str, String str2, String str3) {
        u1.f.d(str);
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

    public final List b0(String str, String[] strArr) {
        h();
        i();
        ArrayList arrayList = new ArrayList();
        Cursor cursorQuery = null;
        try {
            try {
                this.f4646a.z();
                cursorQuery = P().query("conditional_properties", new String[]{"app_id", "origin", "name", "value", "active", "trigger_event_name", "trigger_timeout", "timed_out_event", "creation_timestamp", "triggered_event", "triggered_timestamp", "time_to_live", "expired_event"}, str, strArr, null, null, "rowid", "1001");
                if (!cursorQuery.moveToFirst()) {
                    cursorQuery.close();
                    return arrayList;
                }
                do {
                    int size = arrayList.size();
                    this.f4646a.z();
                    if (size >= 1000) {
                        t3 t3VarR = this.f4646a.d().r();
                        this.f4646a.z();
                        t3VarR.b("Read more than the max allowed conditional properties, ignoring extra", 1000);
                        break;
                    }
                    String string = cursorQuery.getString(0);
                    String string2 = cursorQuery.getString(1);
                    String string3 = cursorQuery.getString(2);
                    Object objY = Y(cursorQuery, 3);
                    boolean z10 = cursorQuery.getInt(4) != 0;
                    String string4 = cursorQuery.getString(5);
                    long j10 = cursorQuery.getLong(6);
                    ra raVarG0 = this.f4655b.g0();
                    byte[] blob = cursorQuery.getBlob(7);
                    Parcelable.Creator<zzau> creator = zzau.CREATOR;
                    zzau zzauVar = (zzau) raVarG0.B(blob, creator);
                    arrayList.add(new zzac(string, string2, new zzlk(string3, cursorQuery.getLong(10), objY, string2), cursorQuery.getLong(8), z10, string4, zzauVar, j10, (zzau) this.f4655b.g0().B(cursorQuery.getBlob(9), creator), cursorQuery.getLong(11), (zzau) this.f4655b.g0().B(cursorQuery.getBlob(12), creator)));
                } while (cursorQuery.moveToNext());
                cursorQuery.close();
                return arrayList;
            } catch (SQLiteException e10) {
                this.f4646a.d().r().b("Error querying conditional user property value", e10);
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
        u1.f.d(str);
        h();
        i();
        ArrayList arrayList = new ArrayList();
        Cursor cursorQuery = null;
        try {
            try {
                this.f4646a.z();
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
                            this.f4646a.d().r().b("Read invalid user property value, ignoring it. appId", v3.z(str));
                            str2 = str;
                        } else {
                            str2 = str;
                            arrayList.add(new ta(str2, str3, string, j10, objY));
                        }
                        try {
                            if (!cursorQuery.moveToNext()) {
                                cursorQuery.close();
                                return arrayList;
                            }
                            str = str2;
                        } catch (SQLiteException e10) {
                            e = e10;
                        }
                    }
                } catch (SQLiteException e11) {
                    e = e11;
                    str2 = str;
                }
            } catch (Throwable th) {
                if (cursorQuery == null) {
                    throw th;
                }
                cursorQuery.close();
                throw th;
            }
        } catch (SQLiteException e12) {
            e = e12;
            str2 = str;
        }
        this.f4646a.d().r().c("Error querying user properties. appId", v3.z(str2), e);
        List list = Collections.EMPTY_LIST;
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        return list;
    }

    /* JADX WARN: Code duplicated, block: B:38:0x0121  */
    public final List d0(String str, String str2, String str3) {
        String str4;
        u1.f.d(str);
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
                        this.f4646a.d().r().d("(2)Error querying user properties", v3.z(str), str4, e);
                        List list = Collections.EMPTY_LIST;
                        if (cursorQuery != null) {
                            cursorQuery.close();
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
                this.f4646a.z();
                cursorQuery = P().query("user_attributes", new String[]{"name", "set_timestamp", "value", "origin"}, string, strArr, null, null, "rowid", "1001");
                if (!cursorQuery.moveToFirst()) {
                    cursorQuery.close();
                    return arrayList;
                }
                while (true) {
                    int size = arrayList.size();
                    this.f4646a.z();
                    if (size >= 1000) {
                        t3 t3VarR = this.f4646a.d().r();
                        this.f4646a.z();
                        t3VarR.b("Read more than the max allowed user properties, ignoring excess", 1000);
                        break;
                    }
                    String string2 = cursorQuery.getString(0);
                    long j10 = cursorQuery.getLong(1);
                    Object objY = Y(cursorQuery, 2);
                    String string3 = cursorQuery.getString(3);
                    if (objY == null) {
                        try {
                            this.f4646a.d().r().d("(2)Read invalid user property value, ignoring it", v3.z(str5), string3, str3);
                        } catch (SQLiteException e11) {
                            e = e11;
                            str4 = string3;
                            this.f4646a.d().r().d("(2)Error querying user properties", v3.z(str), str4, e);
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

    public final void g0(List list) {
        h();
        i();
        u1.f.h(list);
        u1.f.j(list.size());
        if (u()) {
            String str = "(" + TextUtils.join(",", list) + ")";
            if (I("SELECT COUNT(1) FROM queue WHERE rowid IN " + str + " AND retry_count =  2147483647 LIMIT 1", null) > 0) {
                this.f4646a.d().w().a("The number of upload retries exceeds the limit. Will remain unchanged.");
            }
            try {
                P().execSQL("UPDATE queue SET retry_count = IFNULL(retry_count, 0) + 1 WHERE rowid IN " + str + " AND (retry_count IS NULL OR retry_count < 2147483647)");
            } catch (SQLiteException e10) {
                this.f4646a.d().r().b("Error incrementing retry count. error", e10);
            }
        }
    }

    public final void h0() {
        h();
        i();
        if (u()) {
            long jA = this.f4655b.e0().f4833e.a();
            long jB = this.f4646a.a().b();
            long jAbs = Math.abs(jB - jA);
            this.f4646a.z();
            if (jAbs > ((Long) i3.A.a(null)).longValue()) {
                this.f4655b.e0().f4833e.b(jB);
                h();
                i();
                if (u()) {
                    SQLiteDatabase sQLiteDatabaseP = P();
                    String strValueOf = String.valueOf(this.f4646a.a().a());
                    this.f4646a.z();
                    int iDelete = sQLiteDatabaseP.delete("queue", "abs(bundle_end_timestamp - ?) > cast(? as integer)", new String[]{strValueOf, String.valueOf(g.i())});
                    if (iDelete > 0) {
                        this.f4646a.d().v().b("Deleted stale rows. rowsDeleted", Integer.valueOf(iDelete));
                    }
                }
            }
        }
    }

    @Override // g2.ba
    public final boolean l() {
        return false;
    }

    public final void m(String str, String str2) {
        u1.f.d(str);
        u1.f.d(str2);
        h();
        i();
        try {
            P().delete("user_attributes", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e10) {
            this.f4646a.d().r().d("Error deleting user property. appId", v3.z(str), this.f4646a.D().f(str2), e10);
        }
    }

    public final void n(String str, List list) throws Throwable {
        SQLiteDatabase sQLiteDatabase;
        boolean z10;
        u1.f.h(list);
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
                        String strA = u7.a(b3VarV.H(), h6.f4888a, h6.f4889b);
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
                    String strA2 = u7.a(i3VarX.H(), i6.f4966a, i6.f4967b);
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
        u1.f.d(str);
        u1.f.h(list);
        SQLiteDatabase sQLiteDatabaseP = P();
        sQLiteDatabaseP.beginTransaction();
        try {
            i();
            h();
            u1.f.d(str);
            SQLiteDatabase sQLiteDatabaseP2 = P();
            sQLiteDatabaseP2.delete("property_filters", "app_id=?", new String[]{str});
            sQLiteDatabaseP2.delete("event_filters", "app_id=?", new String[]{str});
            Iterator it = list.iterator();
            while (it.hasNext()) {
                com.google.android.gms.internal.measurement.x2 x2Var = (com.google.android.gms.internal.measurement.x2) it.next();
                i();
                h();
                u1.f.d(str);
                u1.f.h(x2Var);
                if (x2Var.N()) {
                    int iD = x2Var.D();
                    Iterator it2 = x2Var.J().iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            if (!((com.google.android.gms.internal.measurement.z2) it2.next()).R()) {
                                this.f4646a.d().w().c("Event filter with no ID. Audience definition ignored. appId, audienceId", v3.z(str), Integer.valueOf(iD));
                                break;
                            }
                        } else {
                            Iterator it3 = x2Var.K().iterator();
                            while (true) {
                                if (!it3.hasNext()) {
                                    Iterator it4 = x2Var.J().iterator();
                                    while (true) {
                                        com.google.android.gms.internal.measurement.x2 x2Var2 = x2Var;
                                        String str2 = "app_id";
                                        try {
                                            if (!it4.hasNext()) {
                                                sQLiteDatabase = sQLiteDatabaseP;
                                                Iterator it5 = x2Var2.K().iterator();
                                                while (true) {
                                                    if (it5.hasNext()) {
                                                        com.google.android.gms.internal.measurement.i3 i3Var = (com.google.android.gms.internal.measurement.i3) it5.next();
                                                        i();
                                                        h();
                                                        u1.f.d(str);
                                                        u1.f.h(i3Var);
                                                        if (i3Var.H().isEmpty()) {
                                                            this.f4646a.d().w().d("Property filter had no property name. Audience definition ignored. appId, audienceId, filterId", v3.z(str), Integer.valueOf(iD), String.valueOf(i3Var.M() ? Integer.valueOf(i3Var.D()) : null));
                                                        } else {
                                                            byte[] bArrJ = i3Var.j();
                                                            ContentValues contentValues = new ContentValues();
                                                            contentValues.put(str2, str);
                                                            String str3 = str2;
                                                            contentValues.put("audience_id", Integer.valueOf(iD));
                                                            contentValues.put("filter_id", i3Var.M() ? Integer.valueOf(i3Var.D()) : null);
                                                            Iterator it6 = it5;
                                                            contentValues.put("property_name", i3Var.H());
                                                            contentValues.put("session_scoped", i3Var.N() ? Boolean.valueOf(i3Var.L()) : null);
                                                            contentValues.put("data", bArrJ);
                                                            try {
                                                                if (P().insertWithOnConflict("property_filters", null, contentValues, 5) == -1) {
                                                                    this.f4646a.d().r().b("Failed to insert property filter (got -1). appId", v3.z(str));
                                                                } else {
                                                                    str2 = str3;
                                                                    it5 = it6;
                                                                }
                                                            } catch (SQLiteException e10) {
                                                                this.f4646a.d().r().c("Error storing property filter. appId", v3.z(str), e10);
                                                            }
                                                        }
                                                    }
                                                    sQLiteDatabaseP = sQLiteDatabase;
                                                    break;
                                                }
                                            }
                                            com.google.android.gms.internal.measurement.z2 z2Var = (com.google.android.gms.internal.measurement.z2) it4.next();
                                            i();
                                            h();
                                            u1.f.d(str);
                                            u1.f.h(z2Var);
                                            if (!z2Var.J().isEmpty()) {
                                                byte[] bArrJ2 = z2Var.j();
                                                sQLiteDatabase = sQLiteDatabaseP;
                                                ContentValues contentValues2 = new ContentValues();
                                                contentValues2.put("app_id", str);
                                                contentValues2.put("audience_id", Integer.valueOf(iD));
                                                contentValues2.put("filter_id", z2Var.R() ? Integer.valueOf(z2Var.E()) : null);
                                                contentValues2.put("event_name", z2Var.J());
                                                contentValues2.put("session_scoped", z2Var.S() ? Boolean.valueOf(z2Var.P()) : null);
                                                contentValues2.put("data", bArrJ2);
                                                try {
                                                    if (P().insertWithOnConflict("event_filters", null, contentValues2, 5) == -1) {
                                                        this.f4646a.d().r().b("Failed to insert event filter (got -1). appId", v3.z(str));
                                                    }
                                                    x2Var = x2Var2;
                                                    sQLiteDatabaseP = sQLiteDatabase;
                                                } catch (SQLiteException e11) {
                                                    this.f4646a.d().r().c("Error storing event filter. appId", v3.z(str), e11);
                                                    i();
                                                    h();
                                                    u1.f.d(str);
                                                    SQLiteDatabase sQLiteDatabaseP3 = P();
                                                    sQLiteDatabaseP3.delete("property_filters", "app_id=? and audience_id=?", new String[]{str, String.valueOf(iD)});
                                                    sQLiteDatabaseP3.delete("event_filters", "app_id=? and audience_id=?", new String[]{str, String.valueOf(iD)});
                                                    sQLiteDatabaseP = sQLiteDatabase;
                                                    break;
                                                }
                                            } else {
                                                this.f4646a.d().w().d("Event filter had no event name. Audience definition ignored. appId, audienceId, filterId", v3.z(str), Integer.valueOf(iD), String.valueOf(z2Var.R() ? Integer.valueOf(z2Var.E()) : null));
                                                sQLiteDatabase = sQLiteDatabaseP;
                                            }
                                            i();
                                            h();
                                            u1.f.d(str);
                                            SQLiteDatabase sQLiteDatabaseP4 = P();
                                            sQLiteDatabaseP4.delete("property_filters", "app_id=? and audience_id=?", new String[]{str, String.valueOf(iD)});
                                            sQLiteDatabaseP4.delete("event_filters", "app_id=? and audience_id=?", new String[]{str, String.valueOf(iD)});
                                            sQLiteDatabaseP = sQLiteDatabase;
                                            break;
                                            break;
                                        } catch (Throwable th) {
                                            th = th;
                                            sQLiteDatabase.endTransaction();
                                            throw th;
                                        }
                                    }
                                }
                                if (!((com.google.android.gms.internal.measurement.i3) it3.next()).M()) {
                                    this.f4646a.d().w().c("Property filter with no ID. Audience definition ignored. appId, audienceId", v3.z(str), Integer.valueOf(iD));
                                    break;
                                }
                            }
                        }
                    }
                } else {
                    this.f4646a.d().w().b("Audience with no ID. appId", v3.z(str));
                }
            }
            sQLiteDatabase = sQLiteDatabaseP;
            ArrayList arrayList = new ArrayList();
            Iterator it7 = list.iterator();
            while (it7.hasNext()) {
                com.google.android.gms.internal.measurement.x2 x2Var3 = (com.google.android.gms.internal.measurement.x2) it7.next();
                arrayList.add(x2Var3.N() ? Integer.valueOf(x2Var3.D()) : null);
            }
            u1.f.d(str);
            i();
            h();
            SQLiteDatabase sQLiteDatabaseP5 = P();
            try {
                long jI = I("select count(1) from audience_filter_values where app_id=?", new String[]{str});
                int i14 = 0;
                int iMax = Math.max(0, Math.min(2000, this.f4646a.z().o(str, i3.H)));
                if (jI > iMax) {
                    ArrayList arrayList2 = new ArrayList();
                    while (true) {
                        if (i14 >= arrayList.size()) {
                            sQLiteDatabaseP5.delete("audience_filter_values", "audience_id in (select audience_id from audience_filter_values where app_id=? and audience_id not in " + ("(" + TextUtils.join(",", arrayList2) + ")") + " order by rowid desc limit -1 offset ?)", new String[]{str, Integer.toString(iMax)});
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
            } catch (SQLiteException e12) {
                this.f4646a.d().r().c("Database error querying filters. appId", v3.z(str), e12);
            }
            sQLiteDatabase.setTransactionSuccessful();
            sQLiteDatabase.endTransaction();
        } catch (Throwable th2) {
            th = th2;
            sQLiteDatabase = sQLiteDatabaseP;
        }
    }

    public final void o() {
        i();
        P().setTransactionSuccessful();
    }

    public final void p(e6 e6Var) {
        u1.f.h(e6Var);
        h();
        i();
        String strL0 = e6Var.l0();
        u1.f.h(strL0);
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
                this.f4646a.d().w().b("Safelisted events should not be an empty list. appId", strL0);
            } else {
                contentValues.put("safelisted_events", TextUtils.join(",", listE));
            }
        }
        tb.b();
        if (this.f4646a.z().B(null, i3.f4936m0) && !contentValues.containsKey("safelisted_events")) {
            contentValues.put("safelisted_events", (String) null);
        }
        try {
            SQLiteDatabase sQLiteDatabaseP = P();
            if (sQLiteDatabaseP.update("apps", contentValues, "app_id = ?", new String[]{strL0}) == 0 && sQLiteDatabaseP.insertWithOnConflict("apps", null, contentValues, 5) == -1) {
                this.f4646a.d().r().b("Failed to insert/update app (got -1). appId", v3.z(strL0));
            }
        } catch (SQLiteException e10) {
            this.f4646a.d().r().c("Error storing app. appId", v3.z(strL0), e10);
        }
    }

    public final void q(q qVar) {
        u1.f.h(qVar);
        h();
        i();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", qVar.f5229a);
        contentValues.put("name", qVar.f5230b);
        contentValues.put("lifetime_count", Long.valueOf(qVar.f5231c));
        contentValues.put("current_bundle_count", Long.valueOf(qVar.f5232d));
        contentValues.put("last_fire_timestamp", Long.valueOf(qVar.f5234f));
        contentValues.put("last_bundled_timestamp", Long.valueOf(qVar.f5235g));
        contentValues.put("last_bundled_day", qVar.f5236h);
        contentValues.put("last_sampled_complex_event_id", qVar.f5237i);
        contentValues.put("last_sampling_rate", qVar.f5238j);
        contentValues.put("current_session_count", Long.valueOf(qVar.f5233e));
        Boolean bool = qVar.f5239k;
        contentValues.put("last_exempt_from_sampling", (bool == null || !bool.booleanValue()) ? null : 1L);
        try {
            if (P().insertWithOnConflict("events", null, contentValues, 5) == -1) {
                this.f4646a.d().r().b("Failed to insert/update event aggregates (got -1). appId", v3.z(qVar.f5229a));
            }
        } catch (SQLiteException e10) {
            this.f4646a.d().r().c("Error storing event aggregates. appId", v3.z(qVar.f5229a), e10);
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
        Context contextC = this.f4646a.c();
        this.f4646a.z();
        return contextC.getDatabasePath("google_app_measurement.db").exists();
    }

    public final boolean v(String str, Long l10, long j10, com.google.android.gms.internal.measurement.j4 j4Var) {
        h();
        i();
        u1.f.h(j4Var);
        u1.f.d(str);
        u1.f.h(l10);
        byte[] bArrJ = j4Var.j();
        this.f4646a.d().v().c("Saving complex main event, appId, data size", this.f4646a.D().d(str), Integer.valueOf(bArrJ.length));
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("event_id", l10);
        contentValues.put("children_to_process", Long.valueOf(j10));
        contentValues.put("main_event", bArrJ);
        try {
            if (P().insertWithOnConflict("main_event_params", null, contentValues, 5) != -1) {
                return true;
            }
            this.f4646a.d().r().b("Failed to insert complex main event (got -1). appId", v3.z(str));
            return false;
        } catch (SQLiteException e10) {
            this.f4646a.d().r().c("Error storing complex main event. appId", v3.z(str), e10);
            return false;
        }
    }

    public final boolean w(zzac zzacVar) {
        u1.f.h(zzacVar);
        h();
        i();
        String str = zzacVar.f3251c;
        u1.f.h(str);
        if (X(str, zzacVar.f3253m.f3269e) == null) {
            long jI = I("SELECT COUNT(1) FROM conditional_properties WHERE app_id=?", new String[]{str});
            this.f4646a.z();
            if (jI >= 1000) {
                return false;
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("origin", zzacVar.f3252e);
        contentValues.put("name", zzacVar.f3253m.f3269e);
        H(contentValues, "value", u1.f.h(zzacVar.f3253m.c()));
        contentValues.put("active", Boolean.valueOf(zzacVar.f3255o));
        contentValues.put("trigger_event_name", zzacVar.f3256p);
        contentValues.put("trigger_timeout", Long.valueOf(zzacVar.f3258r));
        contentValues.put("timed_out_event", this.f4646a.N().e0(zzacVar.f3257q));
        contentValues.put("creation_timestamp", Long.valueOf(zzacVar.f3254n));
        contentValues.put("triggered_event", this.f4646a.N().e0(zzacVar.f3259s));
        contentValues.put("triggered_timestamp", Long.valueOf(zzacVar.f3253m.f3270m));
        contentValues.put("time_to_live", Long.valueOf(zzacVar.f3260t));
        contentValues.put("expired_event", this.f4646a.N().e0(zzacVar.f3261u));
        try {
            if (P().insertWithOnConflict("conditional_properties", null, contentValues, 5) != -1) {
                return true;
            }
            this.f4646a.d().r().b("Failed to insert/update conditional user property (got -1)", v3.z(str));
            return true;
        } catch (SQLiteException e10) {
            this.f4646a.d().r().c("Error storing conditional user property", v3.z(str), e10);
            return true;
        }
    }

    public final boolean x(ta taVar) {
        u1.f.h(taVar);
        h();
        i();
        if (X(taVar.f5330a, taVar.f5332c) == null) {
            if (wa.Z(taVar.f5332c)) {
                if (I("select count(1) from user_attributes where app_id=? and name not like '!_%' escape '!'", new String[]{taVar.f5330a}) >= this.f4646a.z().p(taVar.f5330a, i3.I, 25, 100)) {
                    return false;
                }
            } else if (!"_npa".equals(taVar.f5332c)) {
                long jI = I("select count(1) from user_attributes where app_id=? and origin=? AND name like '!_%' escape '!'", new String[]{taVar.f5330a, taVar.f5331b});
                this.f4646a.z();
                if (jI >= 25) {
                    return false;
                }
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", taVar.f5330a);
        contentValues.put("origin", taVar.f5331b);
        contentValues.put("name", taVar.f5332c);
        contentValues.put("set_timestamp", Long.valueOf(taVar.f5333d));
        H(contentValues, "value", taVar.f5334e);
        try {
            if (P().insertWithOnConflict("user_attributes", null, contentValues, 5) != -1) {
                return true;
            }
            this.f4646a.d().r().b("Failed to insert/update user property (got -1). appId", v3.z(taVar.f5330a));
            return true;
        } catch (SQLiteException e10) {
            this.f4646a.d().r().c("Error storing user property. appId", v3.z(taVar.f5330a), e10);
            return true;
        }
    }
}
