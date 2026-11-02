package com.google.android.gms.common;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import q1.r;
import q1.s;
import q1.y;
import t1.m0;
import y1.a;
import y1.b;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class zzs extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzs> CREATOR = new y();

    /* renamed from: e, reason: collision with root package name */
    public final String f3360e;

    /* renamed from: j, reason: collision with root package name */
    public final r f3361j;

    /* renamed from: k, reason: collision with root package name */
    public final boolean f3362k;

    /* renamed from: l, reason: collision with root package name */
    public final boolean f3363l;

    public zzs(String str, IBinder iBinder, boolean z10, boolean z11) {
        this.f3360e = str;
        s sVar = null;
        if (iBinder != null) {
            try {
                a aVarC = m0.Z(iBinder).c();
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
        this.f3361j = sVar;
        this.f3362k = z10;
        this.f3363l = z11;
    }

    public zzs(String str, r rVar, boolean z10, boolean z11) {
        this.f3360e = str;
        this.f3361j = rVar;
        this.f3362k = z10;
        this.f3363l = z11;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iA = u1.a.a(parcel);
        u1.a.o(parcel, 1, this.f3360e, false);
        r rVar = this.f3361j;
        if (rVar == null) {
            Log.w("GoogleCertificatesQuery", "certificate binder is null");
            rVar = null;
        }
        u1.a.i(parcel, 2, rVar, false);
        u1.a.c(parcel, 3, this.f3362k);
        u1.a.c(parcel, 4, this.f3363l);
        u1.a.b(parcel, iA);
    }
}
