package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class s9 implements y9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final y9[] f3064a;

    public s9(y9... y9VarArr) {
        this.f3064a = y9VarArr;
    }

    @Override // com.google.android.gms.internal.measurement.y9
    public final x9 a(Class cls) {
        y9[] y9VarArr = this.f3064a;
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
        y9[] y9VarArr = this.f3064a;
        for (int i10 = 0; i10 < 2; i10++) {
            if (y9VarArr[i10].b(cls)) {
                return true;
            }
        }
        return false;
    }
}
