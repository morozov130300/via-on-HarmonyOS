package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import u1.r;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public final class zzaj extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaj> CREATOR = new r();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f2629c;

    public zzaj(int i10) {
        this.f2629c = i10;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iA = v1.a.a(parcel);
        v1.a.j(parcel, 1, this.f2629c);
        v1.a.b(parcel, iA);
    }
}
