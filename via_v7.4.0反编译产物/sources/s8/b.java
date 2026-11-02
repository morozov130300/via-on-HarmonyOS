package s8;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import q0.b;
import q0.g;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public final c f11856a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f11857b;

    /* renamed from: c, reason: collision with root package name */
    public Executor f11858c;

    /* renamed from: d, reason: collision with root package name */
    public Runnable f11859d;

    public b(c cVar) {
        this.f11856a = cVar;
    }

    public c b() {
        return this.f11856a;
    }

    public boolean c() {
        return g.a("PROXY_OVERRIDE");
    }

    public boolean d() {
        return g.a("PROXY_OVERRIDE_REVERSE_BYPASS");
    }

    public boolean e() {
        if (this.f11857b || !c() || !this.f11856a.e()) {
            return false;
        }
        pc.a.a("start proxy", new Object[0]);
        b.a aVarB = new b.a().d(this.f11856a.d()).g().b();
        if (d() && this.f11856a.h()) {
            aVarB.j(true);
        }
        Set setC = this.f11856a.c();
        if (setC != null) {
            Iterator it = setC.iterator();
            while (it.hasNext()) {
                aVarB.a((String) it.next());
            }
        }
        this.f11858c = Executors.newCachedThreadPool();
        this.f11859d = new Runnable() { // from class: s8.a
            @Override // java.lang.Runnable
            public final void run() {
                pc.a.a("webview proxy changed!", new Object[0]);
            }
        };
        q0.c.b().c(aVarB.e(), this.f11858c, this.f11859d);
        this.f11857b = true;
        return true;
    }

    public boolean f() {
        if (!this.f11857b || !c()) {
            return false;
        }
        pc.a.a("stop proxy", new Object[0]);
        q0.c.b().a(this.f11858c, this.f11859d);
        this.f11858c = null;
        this.f11859d = null;
        this.f11857b = false;
        return true;
    }
}
