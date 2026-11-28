package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class ka implements x9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final aa f2891a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f2892b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object[] f2893c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f2894d;

    public ka(aa aaVar, String str, Object[] objArr) {
        this.f2891a = aaVar;
        this.f2892b = str;
        this.f2893c = objArr;
        char cCharAt = str.charAt(0);
        if (cCharAt < 55296) {
            this.f2894d = cCharAt;
            return;
        }
        int i10 = cCharAt & 8191;
        int i11 = 1;
        int i12 = 13;
        while (true) {
            int i13 = i11 + 1;
            char cCharAt2 = str.charAt(i11);
            if (cCharAt2 < 55296) {
                this.f2894d = i10 | (cCharAt2 << i12);
                return;
            } else {
                i10 |= (cCharAt2 & 8191) << i12;
                i12 += 13;
                i11 = i13;
            }
        }
    }

    @Override // com.google.android.gms.internal.measurement.x9
    public final boolean a() {
        return (this.f2894d & 2) == 2;
    }

    @Override // com.google.android.gms.internal.measurement.x9
    public final int b() {
        return (this.f2894d & 1) == 1 ? 1 : 2;
    }

    public final String c() {
        return this.f2892b;
    }

    public final Object[] d() {
        return this.f2893c;
    }

    @Override // com.google.android.gms.internal.measurement.x9
    public final aa zza() {
        return this.f2891a;
    }
}
