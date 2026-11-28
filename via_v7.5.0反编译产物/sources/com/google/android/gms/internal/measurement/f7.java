package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class f7 implements d7 {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final d7 f2795m = new d7() { // from class: com.google.android.gms.internal.measurement.e7
        @Override // com.google.android.gms.internal.measurement.d7
        public final Object zza() {
            throw new IllegalStateException();
        }
    };

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile d7 f2796c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Object f2797e;

    public f7(d7 d7Var) {
        d7Var.getClass();
        this.f2796c = d7Var;
    }

    public final String toString() {
        Object obj = this.f2796c;
        if (obj == f2795m) {
            obj = "<supplier that returned " + String.valueOf(this.f2797e) + ">";
        }
        return "Suppliers.memoize(" + String.valueOf(obj) + ")";
    }

    @Override // com.google.android.gms.internal.measurement.d7
    public final Object zza() {
        d7 d7Var = this.f2796c;
        d7 d7Var2 = f2795m;
        if (d7Var != d7Var2) {
            synchronized (this) {
                try {
                    if (this.f2796c != d7Var2) {
                        Object objZza = this.f2796c.zza();
                        this.f2797e = objZza;
                        this.f2796c = d7Var2;
                        return objZza;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return this.f2797e;
    }
}
