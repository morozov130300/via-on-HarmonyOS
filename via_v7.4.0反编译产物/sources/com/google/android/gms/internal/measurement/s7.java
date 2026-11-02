package com.google.android.gms.internal.measurement;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class s7 implements z9 {
    public abstract s7 e(byte[] bArr, int i10, int i11);

    @Override // com.google.android.gms.internal.measurement.z9
    public final /* synthetic */ z9 h(byte[] bArr, q8 q8Var) {
        return i(bArr, 0, bArr.length, q8Var);
    }

    public abstract s7 i(byte[] bArr, int i10, int i11, q8 q8Var);

    @Override // com.google.android.gms.internal.measurement.z9
    public final /* synthetic */ z9 k(byte[] bArr) {
        return e(bArr, 0, bArr.length);
    }
}
