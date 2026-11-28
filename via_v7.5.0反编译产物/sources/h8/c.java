package h8;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import x8.m3;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class c implements q {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile c f5730e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m3 f5731a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f5732b = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List f5733c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Handler f5734d = new Handler(Looper.getMainLooper());

    public c(Context context) {
        this.f5731a = new m3(context);
    }

    public static /* synthetic */ void k(c cVar, t tVar) {
        cVar.getClass();
        tVar.i(tVar.a() + 1);
        cVar.p(tVar);
    }

    public static /* synthetic */ void l(c cVar, t tVar) {
        Iterator it = cVar.f5733c.iterator();
        while (it.hasNext()) {
            ((d) it.next()).a(tVar);
        }
    }

    public static c n(Context context) {
        if (f5730e == null) {
            synchronized (c.class) {
                try {
                    if (f5730e == null) {
                        f5730e = new c(context.getApplicationContext());
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f5730e;
    }

    @Override // h8.q
    public List a() {
        return new ArrayList(this.f5732b);
    }

    @Override // h8.q
    public boolean b() {
        if (this.f5732b.isEmpty()) {
            return true;
        }
        this.f5731a.i();
        this.f5732b.clear();
        return true;
    }

    @Override // h8.q
    public String c(t tVar) {
        if (tVar == null || tVar.b() == null || tVar.b().isEmpty()) {
            return null;
        }
        int iO = o(tVar.b());
        if (iO > 0) {
            this.f5732b.set(iO, tVar);
        } else {
            this.f5732b.clear();
            this.f5732b.add(tVar);
        }
        return tVar.b();
    }

    @Override // h8.q
    public t d() {
        if (this.f5732b.isEmpty()) {
            return null;
        }
        return (t) this.f5732b.get(0);
    }

    @Override // h8.q
    public void e(d dVar) {
        List list = this.f5733c;
        if (list == null) {
            return;
        }
        if (dVar == null || (list.remove(dVar) && this.f5733c.isEmpty())) {
            this.f5733c.clear();
            this.f5733c = null;
        }
    }

    @Override // h8.q
    public t f(String str) {
        int iO = o(str);
        if (iO >= 0) {
            return (t) this.f5732b.get(iO);
        }
        return null;
    }

    @Override // h8.q
    public void g(d dVar) {
        if (dVar == null) {
            return;
        }
        if (this.f5733c == null) {
            this.f5733c = new ArrayList();
        }
        this.f5733c.add(dVar);
    }

    @Override // h8.q
    public m3 h() {
        return this.f5731a;
    }

    @Override // h8.q
    public boolean i(String str) {
        t tVarF;
        if (str != null && (tVarF = f(str)) != null && !tVarF.h()) {
            return false;
        }
        this.f5731a.i();
        boolean z10 = false;
        for (t tVar : this.f5732b) {
            if (tVar.h()) {
                tVar.j(false);
                if (!z10) {
                    m(tVar);
                    z10 = true;
                }
            }
        }
        return z10;
    }

    @Override // h8.q
    public boolean j(String str) {
        t tVarF = f(str);
        if (tVarF == null || tVarF.g()) {
            i(null);
            return false;
        }
        Iterator it = this.f5732b.iterator();
        while (it.hasNext()) {
            ((t) it.next()).j(false);
        }
        p(tVarF);
        return true;
    }

    public final void m(final t tVar) {
        if (this.f5733c == null) {
            return;
        }
        this.f5734d.post(new Runnable() { // from class: h8.a
            @Override // java.lang.Runnable
            public final void run() {
                c.l(this.f5726c, tVar);
            }
        });
    }

    public final int o(String str) {
        if (str != null && !str.isEmpty()) {
            int size = this.f5732b.size();
            for (int i10 = 0; i10 < size; i10++) {
                if (str.equals(((t) this.f5732b.get(i10)).b())) {
                    return i10;
                }
            }
        }
        return -1;
    }

    public final void p(final t tVar) {
        String strC = tVar.c(tVar.a());
        tVar.j(strC != null && this.f5731a.h(strC, new Runnable() { // from class: h8.b
            @Override // java.lang.Runnable
            public final void run() {
                c.k(this.f5728c, tVar);
            }
        }));
        m(tVar);
    }
}
