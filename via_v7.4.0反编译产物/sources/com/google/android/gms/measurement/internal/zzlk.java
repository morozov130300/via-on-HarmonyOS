package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import f2.sa;
import f2.ta;
import t1.f;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class zzlk extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzlk> CREATOR = new sa();

    /* renamed from: e, reason: collision with root package name */
    public final int f3969e;

    /* renamed from: j, reason: collision with root package name */
    public final String f3970j;

    /* renamed from: k, reason: collision with root package name */
    public final long f3971k;

    /* renamed from: l, reason: collision with root package name */
    public final Long f3972l;

    /* renamed from: m, reason: collision with root package name */
    public final String f3973m;

    /* renamed from: n, reason: collision with root package name */
    public final String f3974n;

    /* renamed from: o, reason: collision with root package name */
    public final Double f3975o;

    public zzlk(int i10, String str, long j10, Long l10, Float f10, String str2, String str3, Double d10) {
        this.f3969e = i10;
        this.f3970j = str;
        this.f3971k = j10;
        this.f3972l = l10;
        if (i10 == 1) {
            this.f3975o = f10 != null ? Double.valueOf(f10.doubleValue()) : null;
        } else {
            this.f3975o = d10;
        }
        this.f3973m = str2;
        this.f3974n = str3;
    }

    public zzlk(ta taVar) {
        this(taVar.f5716c, taVar.f5717d, taVar.f5718e, taVar.f5715b);
    }

    public zzlk(String str, long j10, Object obj, String str2) {
        f.d(str);
        this.f3969e = 2;
        this.f3970j = str;
        this.f3971k = j10;
        this.f3974n = str2;
        if (obj == null) {
            this.f3972l = null;
            this.f3975o = null;
            this.f3973m = null;
            return;
        }
        if (obj instanceof Long) {
            this.f3972l = (Long) obj;
            this.f3975o = null;
            this.f3973m = null;
        } else if (obj instanceof String) {
            this.f3972l = null;
            this.f3975o = null;
            this.f3973m = (String) obj;
        } else {
            if (!(obj instanceof Double)) {
                throw new IllegalArgumentException("User attribute given of un-supported type");
            }
            this.f3972l = null;
            this.f3975o = (Double) obj;
            this.f3973m = null;
        }
    }

    public final Object c() {
        Long l10 = this.f3972l;
        if (l10 != null) {
            return l10;
        }
        Double d10 = this.f3975o;
        if (d10 != null) {
            return d10;
        }
        String str = this.f3973m;
        if (str != null) {
            return str;
        }
        return null;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        sa.a(this, parcel, i10);
    }
}
