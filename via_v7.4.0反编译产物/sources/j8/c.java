package j8;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import z8.q3;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class c implements q {

    /* renamed from: e, reason: collision with root package name */
    public static volatile c f7599e;

    /* renamed from: a, reason: collision with root package name */
    public final q3 f7600a;

    /* renamed from: b, reason: collision with root package name */
    public final List f7601b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    public List f7602c = null;

    /* renamed from: d, reason: collision with root package name */
    public final Handler f7603d = new Handler(Looper.getMainLooper());

    public c(Context context) {
        this.f7600a = new q3(context);
    }

    public static /* synthetic */ void k(c cVar, t tVar) {
        cVar.getClass();
        tVar.i(tVar.a() + 1);
        cVar.p(tVar);
    }

    public static /* synthetic */ void l(c cVar, t tVar) {
        Iterator it = cVar.f7602c.iterator();
        while (it.hasNext()) {
            ((d) it.next()).a(tVar);
        }
    }

    public static c n(Context context) {
        if (f7599e == null) {
            synchronized (c.class) {
                try {
                    if (f7599e == null) {
                        f7599e = new c(context.getApplicationContext());
                    }
                } finally {
                }
            }
        }
        return f7599e;
    }

    @Override // j8.q
    public List a() {
        return new ArrayList(this.f7601b);
    }

    @Override // j8.q
    public void b(d dVar) {
        if (dVar == null) {
            return;
        }
        if (this.f7602c == null) {
            this.f7602c = new ArrayList();
        }
        this.f7602c.add(dVar);
    }

    @Override // j8.q
    public boolean c() {
        if (this.f7601b.isEmpty()) {
            return true;
        }
        this.f7600a.i();
        this.f7601b.clear();
        return true;
    }

    @Override // j8.q
    public void d(d dVar) {
        List list = this.f7602c;
        if (list == null) {
            return;
        }
        if (dVar == null || (list.remove(dVar) && this.f7602c.isEmpty())) {
            this.f7602c.clear();
            this.f7602c = null;
        }
    }

    @Override // j8.q
    public t e() {
        if (this.f7601b.isEmpty()) {
            return null;
        }
        return (t) this.f7601b.get(0);
    }

    @Override // j8.q
    public t f(String str) {
        int iO = o(str);
        if (iO >= 0) {
            return (t) this.f7601b.get(iO);
        }
        return null;
    }

    @Override // j8.q
    public q3 g() {
        return this.f7600a;
    }

    @Override // j8.q
    public boolean h(String str) {
        t tVarF;
        if (str != null && (tVarF = f(str)) != null && !tVarF.h()) {
            return false;
        }
        this.f7600a.i();
        boolean z10 = false;
        for (t tVar : this.f7601b) {
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

    @Override // j8.q
    public String i(t tVar) {
        if (tVar == null || tVar.b() == null || tVar.b().isEmpty()) {
            return null;
        }
        int iO = o(tVar.b());
        if (iO > 0) {
            this.f7601b.set(iO, tVar);
        } else {
            this.f7601b.clear();
            this.f7601b.add(tVar);
        }
        return tVar.b();
    }

    @Override // j8.q
    public boolean j(String str) {
        t tVarF = f(str);
        if (tVarF == null || tVarF.g()) {
            h(null);
            return false;
        }
        Iterator it = this.f7601b.iterator();
        while (it.hasNext()) {
            ((t) it.next()).j(false);
        }
        p(tVarF);
        return true;
    }

    public final void m(final t tVar) {
        if (this.f7602c == null) {
            return;
        }
        this.f7603d.post(new Runnable() { // from class: j8.a
            @Override // java.lang.Runnable
            public final void run() {
                c.l(this.f7595e, tVar);
            }
        });
    }

    public final int o(String str) {
        if (str != null && !str.isEmpty()) {
            int size = this.f7601b.size();
            for (int i10 = 0; i10 < size; i10++) {
                if (str.equals(((t) this.f7601b.get(i10)).b())) {
                    return i10;
                }
            }
        }
        return -1;
    }

    public final void p(final t tVar) {
        String strC = tVar.c(tVar.a());
        tVar.j(strC != null && this.f7600a.h(strC, new Runnable() { // from class: j8.b
            @Override // java.lang.Runnable
            public final void run() {
                c.k(this.f7597e, tVar);
            }
        }));
        m(tVar);
    }
}
