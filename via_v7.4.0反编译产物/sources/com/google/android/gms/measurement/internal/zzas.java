package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import f2.r;
import f2.s;
import java.util.Iterator;
import u1.a;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class zzas extends AbstractSafeParcelable implements Iterable<String> {
    public static final Parcelable.Creator<zzas> CREATOR = new s();

    /* renamed from: e, reason: collision with root package name */
    public final Bundle f3963e;

    public zzas(Bundle bundle) {
        this.f3963e = bundle;
    }

    public final int c() {
        return this.f3963e.size();
    }

    public final Bundle g() {
        return new Bundle(this.f3963e);
    }

    public final Double h(String str) {
        return Double.valueOf(this.f3963e.getDouble("value"));
    }

    @Override // java.lang.Iterable
    public final Iterator<String> iterator() {
        return new r(this);
    }

    public final Long k(String str) {
        return Long.valueOf(this.f3963e.getLong("value"));
    }

    public final Object n(String str) {
        return this.f3963e.get(str);
    }

    public final String o(String str) {
        return this.f3963e.getString(str);
    }

    public final String toString() {
        return this.f3963e.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iA = a.a(parcel);
        a.e(parcel, 2, g(), false);
        a.b(parcel, iA);
    }
}
