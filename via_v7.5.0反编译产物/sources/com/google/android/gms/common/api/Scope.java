package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import s1.b;
import u1.f;
import v1.a;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class Scope extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<Scope> CREATOR = new b();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f2585c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f2586e;

    public Scope(int i10, String str) {
        f.e(str, "scopeUri must not be null or empty");
        this.f2585c = i10;
        this.f2586e = str;
    }

    public String c() {
        return this.f2586e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Scope) {
            return this.f2586e.equals(((Scope) obj).f2586e);
        }
        return false;
    }

    public int hashCode() {
        return this.f2586e.hashCode();
    }

    public String toString() {
        return this.f2586e;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int iA = a.a(parcel);
        a.j(parcel, 1, this.f2585c);
        a.o(parcel, 2, c(), false);
        a.b(parcel, iA);
    }
}
