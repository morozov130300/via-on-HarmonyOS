package ra;

import c6.j1;
import c6.k1;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f12070a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f12071b;

    public a(c cVar, b bVar) {
        if (cVar == null) {
            throw new NullPointerException("Script meta can not be null");
        }
        if (bVar == null) {
            throw new NullPointerException("Script content can not be null");
        }
        this.f12070a = cVar;
        this.f12071b = bVar;
    }

    public static a e(String str, String str2) {
        Locale locale = Locale.getDefault();
        j1 j1VarC = k1.f2063a.c(str, str2, locale.getLanguage(), locale.getCountry());
        if (j1VarC == null) {
            return null;
        }
        c cVar = new c();
        long jCurrentTimeMillis = System.currentTimeMillis();
        cVar.l(jCurrentTimeMillis);
        cVar.s(jCurrentTimeMillis);
        cVar.n(true);
        cVar.t(j1VarC.k());
        cVar.v(j1VarC.q());
        cVar.p(j1VarC.h());
        cVar.o(j1VarC.g());
        cVar.u(j1VarC.p());
        cVar.m(j1VarC.b());
        b bVar = new b();
        bVar.p(true);
        bVar.o(str);
        bVar.A(ua.b.a(j1VarC.l() + j1VarC.a()));
        bVar.z(j1VarC.o());
        bVar.t(j1VarC.f());
        bVar.s(j1VarC.e());
        bVar.w(ua.c.d(j1VarC.j()));
        bVar.q(ua.c.d(j1VarC.c()));
        bVar.v(ua.c.d(j1VarC.i()));
        bVar.r(ua.c.d(j1VarC.d()));
        bVar.x(ua.c.d(j1VarC.m()));
        bVar.y(ua.c.e(j1VarC.n()));
        return new a(cVar, bVar);
    }

    public b a() {
        return this.f12071b;
    }

    public int b() {
        return this.f12071b.f();
    }

    public c c() {
        return this.f12070a;
    }

    public String d() {
        return this.f12071b.l();
    }

    public void f(boolean z10) {
        this.f12070a.n(z10);
        this.f12071b.p(z10);
    }

    public void g(int i10) {
        this.f12070a.q(i10);
        this.f12071b.u(i10);
    }

    public String toString() {
        return "Script{meta=" + this.f12070a + ", content=" + this.f12071b + '}';
    }
}
