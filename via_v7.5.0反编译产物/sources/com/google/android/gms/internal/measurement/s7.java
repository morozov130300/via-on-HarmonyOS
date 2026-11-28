package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class s7 implements z9 {
    @Override // com.google.android.gms.internal.measurement.z9
    public final /* synthetic */ z9 g(byte[] bArr, q8 q8Var) {
        return j(bArr, 0, bArr.length, q8Var);
    }

    @Override // com.google.android.gms.internal.measurement.z9
    public final /* synthetic */ z9 h(byte[] bArr) {
        return i(bArr, 0, bArr.length);
    }

    public abstract s7 i(byte[] bArr, int i10, int i11);

    public abstract s7 j(byte[] bArr, int i10, int i11, q8 q8Var);
}
