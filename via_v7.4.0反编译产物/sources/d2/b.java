package d2;

import android.os.Bundle;
import f2.h5;
import f2.o7;
import java.util.List;
import java.util.Map;
import t1.f;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class b extends e {

    /* renamed from: a, reason: collision with root package name */
    public final h5 f4533a;

    /* renamed from: b, reason: collision with root package name */
    public final o7 f4534b;

    public b(h5 h5Var) {
        super(null);
        f.h(h5Var);
        this.f4533a = h5Var;
        this.f4534b = h5Var.I();
    }

    @Override // f2.p7
    public final long a() {
        return this.f4533a.N().t0();
    }

    @Override // f2.p7
    public final int b(String str) {
        this.f4534b.Q(str);
        return 25;
    }

    @Override // f2.p7
    public final List c(String str, String str2) {
        return this.f4534b.Z(str, str2);
    }

    @Override // f2.p7
    public final Map d(String str, String str2, boolean z10) {
        return this.f4534b.a0(str, str2, z10);
    }

    @Override // f2.p7
    public final String e() {
        return this.f4534b.V();
    }

    @Override // f2.p7
    public final String f() {
        return this.f4534b.W();
    }

    @Override // f2.p7
    public final void g(Bundle bundle) {
        this.f4534b.D(bundle);
    }

    @Override // f2.p7
    public final void h(String str, String str2, Bundle bundle) {
        this.f4534b.r(str, str2, bundle);
    }

    @Override // f2.p7
    public final String i() {
        return this.f4534b.X();
    }

    @Override // f2.p7
    public final String j() {
        return this.f4534b.V();
    }

    @Override // f2.p7
    public final void k(String str) {
        this.f4533a.y().l(str, this.f4533a.a().b());
    }

    @Override // f2.p7
    public final void l(String str, String str2, Bundle bundle) {
        this.f4533a.I().o(str, str2, bundle);
    }

    @Override // f2.p7
    public final void m(String str) {
        this.f4533a.y().m(str, this.f4533a.a().b());
    }
}
