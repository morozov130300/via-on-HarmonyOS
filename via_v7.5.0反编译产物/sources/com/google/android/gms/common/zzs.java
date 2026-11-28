package com.google.android.gms.common;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import r1.r;
import r1.s;
import r1.y;
import u1.m0;
import v1.a;
import z1.b;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class zzs extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzs> CREATOR = new y();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f2659c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final r f2660e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f2661m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f2662n;

    public zzs(String str, r rVar, boolean z10, boolean z11) {
        this.f2659c = str;
        this.f2660e = rVar;
        this.f2661m = z10;
        this.f2662n = z11;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iA = a.a(parcel);
        a.o(parcel, 1, this.f2659c, false);
        r rVar = this.f2660e;
        if (rVar == null) {
            Log.w("GoogleCertificatesQuery", "certificate binder is null");
            rVar = null;
        }
        a.i(parcel, 2, rVar, false);
        a.c(parcel, 3, this.f2661m);
        a.c(parcel, 4, this.f2662n);
        a.b(parcel, iA);
    }

    public zzs(String str, IBinder iBinder, boolean z10, boolean z11) {
        this.f2659c = str;
        s sVar = null;
        if (iBinder != null) {
            try {
                z1.a aVarC = m0.Z(iBinder).c();
                byte[] bArr = aVarC == null ? null : (byte[]) b.a0(aVarC);
                if (bArr != null) {
                    sVar = new s(bArr);
                } else {
                    Log.e("GoogleCertificatesQuery", "Could not unwrap certificate");
                }
            } catch (RemoteException e10) {
                Log.e("GoogleCertificatesQuery", "Could not unwrap certificate", e10);
            }
        }
        this.f2660e = sVar;
        this.f2661m = z10;
        this.f2662n = z11;
    }
}
