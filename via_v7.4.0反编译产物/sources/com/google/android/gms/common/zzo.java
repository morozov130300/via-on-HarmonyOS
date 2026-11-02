package com.google.android.gms.common;

import android.content.Context;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import q1.w;
import y1.a;
import y1.b;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class zzo extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzo> CREATOR = new w();

    /* renamed from: e, reason: collision with root package name */
    public final String f3351e;

    /* renamed from: j, reason: collision with root package name */
    public final boolean f3352j;

    /* renamed from: k, reason: collision with root package name */
    public final boolean f3353k;

    /* renamed from: l, reason: collision with root package name */
    public final Context f3354l;

    /* renamed from: m, reason: collision with root package name */
    public final boolean f3355m;

    public zzo(String str, boolean z10, boolean z11, IBinder iBinder, boolean z12) {
        this.f3351e = str;
        this.f3352j = z10;
        this.f3353k = z11;
        this.f3354l = (Context) b.a0(a.AbstractBinderC0155a.Z(iBinder));
        this.f3355m = z12;
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [android.os.IBinder, y1.a] */
    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iA = u1.a.a(parcel);
        u1.a.o(parcel, 1, this.f3351e, false);
        u1.a.c(parcel, 2, this.f3352j);
        u1.a.c(parcel, 3, this.f3353k);
        u1.a.i(parcel, 4, b.b0(this.f3354l), false);
        u1.a.c(parcel, 5, this.f3355m);
        u1.a.b(parcel, iA);
    }
}
