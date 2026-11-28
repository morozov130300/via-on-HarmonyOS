package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class m7 extends h7 {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final zzja f2918m;

    public m7(zzja zzjaVar, int i10) {
        super(zzjaVar.size(), i10);
        this.f2918m = zzjaVar;
    }

    @Override // com.google.android.gms.internal.measurement.h7
    public final Object a(int i10) {
        return this.f2918m.get(i10);
    }
}
