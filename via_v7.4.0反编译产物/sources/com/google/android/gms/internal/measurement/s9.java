package com.google.android.gms.internal.measurement;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class s9 implements y9 {

    /* renamed from: a, reason: collision with root package name */
    public final y9[] f3765a;

    public s9(y9... y9VarArr) {
        this.f3765a = y9VarArr;
    }

    @Override // com.google.android.gms.internal.measurement.y9
    public final x9 a(Class cls) {
        y9[] y9VarArr = this.f3765a;
        for (int i10 = 0; i10 < 2; i10++) {
            y9 y9Var = y9VarArr[i10];
            if (y9Var.b(cls)) {
                return y9Var.a(cls);
            }
        }
        throw new UnsupportedOperationException("No factory is available for message type: ".concat(cls.getName()));
    }

    @Override // com.google.android.gms.internal.measurement.y9
    public final boolean b(Class cls) {
        y9[] y9VarArr = this.f3765a;
        for (int i10 = 0; i10 < 2; i10++) {
            if (y9VarArr[i10].b(cls)) {
                return true;
            }
        }
        return false;
    }
}
