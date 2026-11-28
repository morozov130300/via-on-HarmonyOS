package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import g2.r;
import g2.s;
import java.util.Iterator;
import v1.a;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class zzas extends AbstractSafeParcelable implements Iterable<String> {
    public static final Parcelable.Creator<zzas> CREATOR = new s();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Bundle f3262c;

    public zzas(Bundle bundle) {
        this.f3262c = bundle;
    }

    public final int c() {
        return this.f3262c.size();
    }

    public final Bundle g() {
        return new Bundle(this.f3262c);
    }

    public final Double h(String str) {
        return Double.valueOf(this.f3262c.getDouble("value"));
    }

    @Override // java.lang.Iterable
    public final Iterator<String> iterator() {
        return new r(this);
    }

    public final Long k(String str) {
        return Long.valueOf(this.f3262c.getLong("value"));
    }

    public final Object n(String str) {
        return this.f3262c.get(str);
    }

    public final String o(String str) {
        return this.f3262c.getString(str);
    }

    public final String toString() {
        return this.f3262c.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iA = a.a(parcel);
        a.e(parcel, 2, g(), false);
        a.b(parcel, iA);
    }
}
