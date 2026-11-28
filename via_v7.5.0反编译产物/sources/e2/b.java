package e2;

import android.os.Bundle;
import g2.h5;
import g2.o7;
import java.util.List;
import java.util.Map;
import u1.f;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class b extends e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h5 f4165a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o7 f4166b;

    public b(h5 h5Var) {
        super(null);
        f.h(h5Var);
        this.f4165a = h5Var;
        this.f4166b = h5Var.I();
    }

    @Override // g2.p7
    public final long a() {
        return this.f4165a.N().t0();
    }

    @Override // g2.p7
    public final int b(String str) {
        this.f4166b.Q(str);
        return 25;
    }

    @Override // g2.p7
    public final List c(String str, String str2) {
        return this.f4166b.Z(str, str2);
    }

    @Override // g2.p7
    public final Map d(String str, String str2, boolean z10) {
        return this.f4166b.a0(str, str2, z10);
    }

    @Override // g2.p7
    public final String e() {
        return this.f4166b.V();
    }

    @Override // g2.p7
    public final String f() {
        return this.f4166b.W();
    }

    @Override // g2.p7
    public final void g(Bundle bundle) {
        this.f4166b.D(bundle);
    }

    @Override // g2.p7
    public final void h(String str, String str2, Bundle bundle) {
        this.f4166b.r(str, str2, bundle);
    }

    @Override // g2.p7
    public final String i() {
        return this.f4166b.X();
    }

    @Override // g2.p7
    public final String j() {
        return this.f4166b.V();
    }

    @Override // g2.p7
    public final void k(String str) {
        this.f4165a.y().l(str, this.f4165a.a().b());
    }

    @Override // g2.p7
    public final void l(String str, String str2, Bundle bundle) {
        this.f4165a.I().o(str, str2, bundle);
    }

    @Override // g2.p7
    public final void m(String str) {
        this.f4165a.y().m(str, this.f4165a.a().b());
    }
}
