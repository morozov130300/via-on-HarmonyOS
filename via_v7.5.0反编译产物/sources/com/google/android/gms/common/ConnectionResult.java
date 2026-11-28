package com.google.android.gms.common;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import org.chromium.support_lib_boundary.ProcessGlobalConfigConstants;
import r1.j;
import u1.e;
import v1.a;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class ConnectionResult extends AbstractSafeParcelable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f2578c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f2579e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final PendingIntent f2580m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f2581n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final ConnectionResult f2577o = new ConnectionResult(0);
    public static final Parcelable.Creator<ConnectionResult> CREATOR = new j();

    public ConnectionResult(int i10, int i11, PendingIntent pendingIntent, String str) {
        this.f2578c = i10;
        this.f2579e = i11;
        this.f2580m = pendingIntent;
        this.f2581n = str;
    }

    public static String k(int i10) {
        if (i10 == 99) {
            return "UNFINISHED";
        }
        if (i10 == 1500) {
            return "DRIVE_EXTERNAL_STORAGE_REQUIRED";
        }
        switch (i10) {
            case ProcessGlobalConfigConstants.UI_THREAD_STARTUP_MODE_DEFAULT /* -1 */:
                return "UNKNOWN";
            case 0:
                return "SUCCESS";
            case 1:
                return "SERVICE_MISSING";
            case 2:
                return "SERVICE_VERSION_UPDATE_REQUIRED";
            case 3:
                return "SERVICE_DISABLED";
            case 4:
                return "SIGN_IN_REQUIRED";
            case 5:
                return "INVALID_ACCOUNT";
            case 6:
                return "RESOLUTION_REQUIRED";
            case 7:
                return "NETWORK_ERROR";
            case 8:
                return "INTERNAL_ERROR";
            case 9:
                return "SERVICE_INVALID";
            case 10:
                return "DEVELOPER_ERROR";
            case 11:
                return "LICENSE_CHECK_FAILED";
            default:
                switch (i10) {
                    case 13:
                        return "CANCELED";
                    case 14:
                        return "TIMEOUT";
                    case 15:
                        return "INTERRUPTED";
                    case 16:
                        return "API_UNAVAILABLE";
                    case 17:
                        return "SIGN_IN_FAILED";
                    case 18:
                        return "SERVICE_UPDATING";
                    case 19:
                        return "SERVICE_MISSING_PERMISSION";
                    case 20:
                        return "RESTRICTED_PROFILE";
                    case 21:
                        return "API_VERSION_UPDATE_REQUIRED";
                    case 22:
                        return "RESOLUTION_ACTIVITY_NOT_FOUND";
                    case 23:
                        return "API_DISABLED";
                    case 24:
                        return "API_DISABLED_FOR_CONNECTION";
                    default:
                        return "UNKNOWN_ERROR_CODE(" + i10 + ")";
                }
        }
    }

    public int c() {
        return this.f2579e;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ConnectionResult)) {
            return false;
        }
        ConnectionResult connectionResult = (ConnectionResult) obj;
        return this.f2579e == connectionResult.f2579e && e.a(this.f2580m, connectionResult.f2580m) && e.a(this.f2581n, connectionResult.f2581n);
    }

    public String f() {
        return this.f2581n;
    }

    public PendingIntent g() {
        return this.f2580m;
    }

    public boolean h() {
        return this.f2579e == 0;
    }

    public int hashCode() {
        return e.b(Integer.valueOf(this.f2579e), this.f2580m, this.f2581n);
    }

    public String toString() {
        e.a aVarC = e.c(this);
        aVarC.a("statusCode", k(this.f2579e));
        aVarC.a("resolution", this.f2580m);
        aVarC.a("message", this.f2581n);
        return aVarC.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int iA = a.a(parcel);
        a.j(parcel, 1, this.f2578c);
        a.j(parcel, 2, c());
        a.n(parcel, 3, g(), i10, false);
        a.o(parcel, 4, f(), false);
        a.b(parcel, iA);
    }

    public ConnectionResult(int i10) {
        this(i10, null, null);
    }

    public ConnectionResult(int i10, PendingIntent pendingIntent) {
        this(i10, pendingIntent, null);
    }

    public ConnectionResult(int i10, PendingIntent pendingIntent, String str) {
        this(1, i10, pendingIntent, str);
    }
}
