package com.google.android.gms.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import r1.k;
import u1.e;
import v1.a;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class Feature extends AbstractSafeParcelable {
    public static final Parcelable.Creator<Feature> CREATOR = new k();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f2582c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f2583e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final long f2584m;

    public Feature(String str, int i10, long j10) {
        this.f2582c = str;
        this.f2583e = i10;
        this.f2584m = j10;
    }

    public long c() {
        long j10 = this.f2584m;
        return j10 == -1 ? this.f2583e : j10;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof Feature) {
            Feature feature = (Feature) obj;
            if (((getName() != null && getName().equals(feature.getName())) || (getName() == null && feature.getName() == null)) && c() == feature.c()) {
                return true;
            }
        }
        return false;
    }

    public String getName() {
        return this.f2582c;
    }

    public final int hashCode() {
        return e.b(getName(), Long.valueOf(c()));
    }

    public final String toString() {
        e.a aVarC = e.c(this);
        aVarC.a("name", getName());
        aVarC.a("version", Long.valueOf(c()));
        return aVarC.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iA = a.a(parcel);
        a.o(parcel, 1, getName(), false);
        a.j(parcel, 2, this.f2583e);
        a.l(parcel, 3, c());
        a.b(parcel, iA);
    }
}
