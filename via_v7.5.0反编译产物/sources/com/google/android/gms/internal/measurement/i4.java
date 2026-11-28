package com.google.android.gms.internal.measurement;

import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class i4 extends x8 implements ba {
    public /* synthetic */ i4(a4 a4Var) {
        super(j4.zza);
    }

    public final i4 A(String str) {
        q();
        j4.R((j4) this.f3182e, str);
        return this;
    }

    public final i4 B(int i10, m4 m4Var) {
        q();
        j4.M((j4) this.f3182e, i10, (n4) m4Var.o());
        return this;
    }

    public final i4 C(int i10, n4 n4Var) {
        q();
        j4.M((j4) this.f3182e, i10, n4Var);
        return this;
    }

    public final i4 D(long j10) {
        q();
        j4.T((j4) this.f3182e, j10);
        return this;
    }

    public final i4 E(long j10) {
        q();
        j4.S((j4) this.f3182e, j10);
        return this;
    }

    public final n4 F(int i10) {
        return ((j4) this.f3182e).J(i10);
    }

    public final String G() {
        return ((j4) this.f3182e).K();
    }

    public final List H() {
        return Collections.unmodifiableList(((j4) this.f3182e).L());
    }

    public final boolean I() {
        return ((j4) this.f3182e).W();
    }

    public final int s() {
        return ((j4) this.f3182e).E();
    }

    public final long t() {
        return ((j4) this.f3182e).F();
    }

    public final long u() {
        return ((j4) this.f3182e).G();
    }

    public final i4 v(Iterable iterable) {
        q();
        j4.O((j4) this.f3182e, iterable);
        return this;
    }

    public final i4 w(m4 m4Var) {
        q();
        j4.N((j4) this.f3182e, (n4) m4Var.o());
        return this;
    }

    public final i4 x(n4 n4Var) {
        q();
        j4.N((j4) this.f3182e, n4Var);
        return this;
    }

    public final i4 y() {
        q();
        ((j4) this.f3182e).zze = a9.s();
        return this;
    }

    public final i4 z(int i10) {
        q();
        j4.Q((j4) this.f3182e, i10);
        return this;
    }
}
