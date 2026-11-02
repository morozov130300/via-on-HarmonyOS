package d1;

import android.content.Context;
import java.util.Collections;
import java.util.Set;
import k1.g0;
import k1.k0;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class t implements s {

    /* renamed from: e, reason: collision with root package name */
    public static volatile u f4523e;

    /* renamed from: a, reason: collision with root package name */
    public final n1.a f4524a;

    /* renamed from: b, reason: collision with root package name */
    public final n1.a f4525b;

    /* renamed from: c, reason: collision with root package name */
    public final j1.e f4526c;

    /* renamed from: d, reason: collision with root package name */
    public final g0 f4527d;

    public t(n1.a aVar, n1.a aVar2, j1.e eVar, g0 g0Var, k0 k0Var) {
        this.f4524a = aVar;
        this.f4525b = aVar2;
        this.f4526c = eVar;
        this.f4527d = g0Var;
        k0Var.c();
    }

    public static t c() {
        u uVar = f4523e;
        if (uVar != null) {
            return uVar.b();
        }
        throw new IllegalStateException("Not initialized!");
    }

    public static Set d(f fVar) {
        return fVar instanceof g ? Collections.unmodifiableSet(((g) fVar).a()) : Collections.singleton(a1.b.b("proto"));
    }

    public static void f(Context context) {
        if (f4523e == null) {
            synchronized (t.class) {
                try {
                    if (f4523e == null) {
                        f4523e = e.d().a(context).build();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    @Override // d1.s
    public void a(o oVar, a1.g gVar) {
        this.f4526c.a(oVar.f().f(oVar.c().c()), b(oVar), gVar);
    }

    public final i b(o oVar) {
        return i.a().i(this.f4524a.a()).k(this.f4525b.a()).j(oVar.g()).h(new h(oVar.b(), oVar.d())).g(oVar.c().a()).d();
    }

    public g0 e() {
        return this.f4527d;
    }

    public a1.f g(f fVar) {
        return new q(d(fVar), p.a().b(fVar.getName()).c(fVar.getExtras()).a(), this);
    }
}
