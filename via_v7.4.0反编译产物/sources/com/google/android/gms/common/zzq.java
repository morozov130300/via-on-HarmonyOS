package com.google.android.gms.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import q1.d0;
import q1.l;
import q1.x;
import u1.a;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class zzq extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzq> CREATOR = new x();

    /* renamed from: e, reason: collision with root package name */
    public final boolean f3356e;

    /* renamed from: j, reason: collision with root package name */
    public final String f3357j;

    /* renamed from: k, reason: collision with root package name */
    public final int f3358k;

    /* renamed from: l, reason: collision with root package name */
    public final int f3359l;

    public zzq(boolean z10, String str, int i10, int i11) {
        this.f3356e = z10;
        this.f3357j = str;
        this.f3358k = d0.a(i10) - 1;
        this.f3359l = l.a(i11) - 1;
    }

    public final String c() {
        return this.f3357j;
    }

    public final boolean f() {
        return this.f3356e;
    }

    public final int g() {
        return l.a(this.f3359l);
    }

    public final int h() {
        return d0.a(this.f3358k);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iA = a.a(parcel);
        a.c(parcel, 1, this.f3356e);
        a.o(parcel, 2, this.f3357j, false);
        a.j(parcel, 3, this.f3358k);
        a.j(parcel, 4, this.f3359l);
        a.b(parcel, iA);
    }
}
