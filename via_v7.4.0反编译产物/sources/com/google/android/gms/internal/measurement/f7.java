package com.google.android.gms.internal.measurement;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class f7 implements d7 {

    /* renamed from: k, reason: collision with root package name */
    public static final d7 f3496k = new d7() { // from class: com.google.android.gms.internal.measurement.e7
        @Override // com.google.android.gms.internal.measurement.d7
        public final Object zza() {
            throw new IllegalStateException();
        }
    };

    /* renamed from: e, reason: collision with root package name */
    public volatile d7 f3497e;

    /* renamed from: j, reason: collision with root package name */
    public Object f3498j;

    public f7(d7 d7Var) {
        d7Var.getClass();
        this.f3497e = d7Var;
    }

    public final String toString() {
        Object obj = this.f3497e;
        if (obj == f3496k) {
            obj = "<supplier that returned " + String.valueOf(this.f3498j) + ">";
        }
        return "Suppliers.memoize(" + String.valueOf(obj) + ")";
    }

    @Override // com.google.android.gms.internal.measurement.d7
    public final Object zza() {
        d7 d7Var = this.f3497e;
        d7 d7Var2 = f3496k;
        if (d7Var != d7Var2) {
            synchronized (this) {
                try {
                    if (this.f3497e != d7Var2) {
                        Object objZza = this.f3497e.zza();
                        this.f3498j = objZza;
                        this.f3497e = d7Var2;
                        return objZza;
                    }
                } finally {
                }
            }
        }
        return this.f3498j;
    }
}
