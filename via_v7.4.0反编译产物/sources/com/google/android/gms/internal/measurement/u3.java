package com.google.android.gms.internal.measurement;

import java.util.Collections;
import java.util.List;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class u3 extends x8 implements ba {
    public /* synthetic */ u3(o3 o3Var) {
        super(v3.zza);
    }

    public final int s() {
        return ((v3) this.f3883j).E();
    }

    public final t3 t(int i10) {
        return ((v3) this.f3883j).G(i10);
    }

    public final u3 u() {
        q();
        ((v3) this.f3883j).zzj = a9.s();
        return this;
    }

    public final u3 v(int i10, s3 s3Var) {
        q();
        v3.S((v3) this.f3883j, i10, (t3) s3Var.o());
        return this;
    }

    public final String w() {
        return ((v3) this.f3883j).N();
    }

    public final List x() {
        return Collections.unmodifiableList(((v3) this.f3883j).O());
    }

    public final List y() {
        return Collections.unmodifiableList(((v3) this.f3883j).P());
    }
}
