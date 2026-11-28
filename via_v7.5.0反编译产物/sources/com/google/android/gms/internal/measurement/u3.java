package com.google.android.gms.internal.measurement;

import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class u3 extends x8 implements ba {
    public /* synthetic */ u3(o3 o3Var) {
        super(v3.zza);
    }

    public final int s() {
        return ((v3) this.f3182e).E();
    }

    public final t3 t(int i10) {
        return ((v3) this.f3182e).G(i10);
    }

    public final u3 u() {
        q();
        ((v3) this.f3182e).zzj = a9.s();
        return this;
    }

    public final u3 v(int i10, s3 s3Var) {
        q();
        v3.S((v3) this.f3182e, i10, (t3) s3Var.o());
        return this;
    }

    public final String w() {
        return ((v3) this.f3182e).N();
    }

    public final List x() {
        return Collections.unmodifiableList(((v3) this.f3182e).O());
    }

    public final List y() {
        return Collections.unmodifiableList(((v3) this.f3182e).P());
    }
}
