package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import g2.sa;
import g2.ta;
import u1.f;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class zzlk extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzlk> CREATOR = new sa();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f3268c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f3269e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final long f3270m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Long f3271n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final String f3272o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final String f3273p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Double f3274q;

    public zzlk(int i10, String str, long j10, Long l10, Float f10, String str2, String str3, Double d10) {
        this.f3268c = i10;
        this.f3269e = str;
        this.f3270m = j10;
        this.f3271n = l10;
        if (i10 == 1) {
            this.f3274q = f10 != null ? Double.valueOf(f10.doubleValue()) : null;
        } else {
            this.f3274q = d10;
        }
        this.f3272o = str2;
        this.f3273p = str3;
    }

    public final Object c() {
        Long l10 = this.f3271n;
        if (l10 != null) {
            return l10;
        }
        Double d10 = this.f3274q;
        if (d10 != null) {
            return d10;
        }
        String str = this.f3272o;
        if (str != null) {
            return str;
        }
        return null;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        sa.a(this, parcel, i10);
    }

    public zzlk(ta taVar) {
        this(taVar.f5332c, taVar.f5333d, taVar.f5334e, taVar.f5331b);
    }

    public zzlk(String str, long j10, Object obj, String str2) {
        f.d(str);
        this.f3268c = 2;
        this.f3269e = str;
        this.f3270m = j10;
        this.f3273p = str2;
        if (obj == null) {
            this.f3271n = null;
            this.f3274q = null;
            this.f3272o = null;
            return;
        }
        if (obj instanceof Long) {
            this.f3271n = (Long) obj;
            this.f3274q = null;
            this.f3272o = null;
        } else if (obj instanceof String) {
            this.f3271n = null;
            this.f3274q = null;
            this.f3272o = (String) obj;
        } else {
            if (obj instanceof Double) {
                this.f3271n = null;
                this.f3274q = (Double) obj;
                this.f3272o = null;
                return;
            }
            throw new IllegalArgumentException("User attribute given of un-supported type");
        }
    }
}
