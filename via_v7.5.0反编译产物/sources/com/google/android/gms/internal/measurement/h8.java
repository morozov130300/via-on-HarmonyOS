package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class h8 extends j8 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f2830b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f2831c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f2832d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f2833e;

    public /* synthetic */ h8(byte[] bArr, int i10, int i11, boolean z10, g8 g8Var) {
        super(null);
        this.f2833e = Integer.MAX_VALUE;
        this.f2830b = bArr;
        this.f2831c = 0;
    }

    public final int c(int i10) {
        int i11 = this.f2833e;
        this.f2833e = 0;
        int i12 = this.f2831c + this.f2832d;
        this.f2831c = i12;
        if (i12 <= 0) {
            this.f2832d = 0;
            return i11;
        }
        this.f2832d = i12;
        this.f2831c = 0;
        return i11;
    }
}
