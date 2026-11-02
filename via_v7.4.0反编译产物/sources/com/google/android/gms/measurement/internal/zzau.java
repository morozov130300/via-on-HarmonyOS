package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import f2.t;
import t1.f;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class zzau extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzau> CREATOR = new t();

    /* renamed from: e, reason: collision with root package name */
    public final String f3964e;

    /* renamed from: j, reason: collision with root package name */
    public final zzas f3965j;

    /* renamed from: k, reason: collision with root package name */
    public final String f3966k;

    /* renamed from: l, reason: collision with root package name */
    public final long f3967l;

    public zzau(zzau zzauVar, long j10) {
        f.h(zzauVar);
        this.f3964e = zzauVar.f3964e;
        this.f3965j = zzauVar.f3965j;
        this.f3966k = zzauVar.f3966k;
        this.f3967l = j10;
    }

    public zzau(String str, zzas zzasVar, String str2, long j10) {
        this.f3964e = str;
        this.f3965j = zzasVar;
        this.f3966k = str2;
        this.f3967l = j10;
    }

    public final String toString() {
        return "origin=" + this.f3966k + ",name=" + this.f3964e + ",params=" + String.valueOf(this.f3965j);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        t.a(this, parcel, i10);
    }
}
