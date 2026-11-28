package q8;

import android.os.Build;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import r0.d;
import r0.e;
import r0.l;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f11831a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f11832b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Executor f11833c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Runnable f11834d;

    public b(c cVar) {
        this.f11831a = cVar;
    }

    public static boolean c() {
        return Build.VERSION.SDK_INT >= 24 && l.a("PROXY_OVERRIDE");
    }

    public static boolean d() {
        return Build.VERSION.SDK_INT >= 24 && l.a("PROXY_OVERRIDE_REVERSE_BYPASS");
    }

    public c b() {
        return this.f11831a;
    }

    public boolean e() {
        if (this.f11832b || !c() || !this.f11831a.e()) {
            return false;
        }
        tc.a.a("start proxy", new Object[0]);
        d.a aVarB = new d.a().d(this.f11831a.d()).g().b();
        if (d() && this.f11831a.h()) {
            aVarB.j(true);
        }
        Set setC = this.f11831a.c();
        if (setC != null) {
            Iterator it = setC.iterator();
            while (it.hasNext()) {
                aVarB.a((String) it.next());
            }
        }
        this.f11833c = Executors.newCachedThreadPool();
        this.f11834d = new Runnable() { // from class: q8.a
            @Override // java.lang.Runnable
            public final void run() {
                tc.a.a("webview proxy changed!", new Object[0]);
            }
        };
        e.b().c(aVarB.e(), this.f11833c, this.f11834d);
        this.f11832b = true;
        return true;
    }

    public boolean f() {
        if (!this.f11832b || !c()) {
            return false;
        }
        tc.a.a("stop proxy", new Object[0]);
        e.b().a(this.f11833c, this.f11834d);
        this.f11833c = null;
        this.f11834d = null;
        this.f11832b = false;
        return true;
    }
}
