package e1;

import android.content.Context;
import java.util.Collections;
import java.util.Set;
import l1.g0;
import l1.k0;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class t implements s {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile u f4155e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o1.a f4156a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o1.a f4157b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final k1.e f4158c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final g0 f4159d;

    public t(o1.a aVar, o1.a aVar2, k1.e eVar, g0 g0Var, k0 k0Var) {
        this.f4156a = aVar;
        this.f4157b = aVar2;
        this.f4158c = eVar;
        this.f4159d = g0Var;
        k0Var.c();
    }

    public static t c() {
        u uVar = f4155e;
        if (uVar != null) {
            return uVar.b();
        }
        throw new IllegalStateException("Not initialized!");
    }

    public static Set d(f fVar) {
        return fVar instanceof g ? Collections.unmodifiableSet(((g) fVar).a()) : Collections.singleton(b1.b.b("proto"));
    }

    public static void f(Context context) {
        if (f4155e == null) {
            synchronized (t.class) {
                try {
                    if (f4155e == null) {
                        f4155e = e.c().a(context).build();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    @Override // e1.s
    public void a(o oVar, b1.g gVar) {
        this.f4158c.a(oVar.f().f(oVar.c().c()), b(oVar), gVar);
    }

    public final i b(o oVar) {
        return i.a().i(this.f4156a.a()).k(this.f4157b.a()).j(oVar.g()).h(new h(oVar.b(), oVar.d())).g(oVar.c().a()).d();
    }

    public g0 e() {
        return this.f4159d;
    }

    public b1.f g(f fVar) {
        return new q(d(fVar), p.a().b(fVar.getName()).c(fVar.getExtras()).a(), this);
    }
}
