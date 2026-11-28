package androidx.lifecycle;

import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class LiveData {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Object f905k = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f906a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public g.b f907b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f908c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f909d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile Object f910e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile Object f911f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f912g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f913h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f914i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Runnable f915j;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class LifecycleBoundObserver extends androidx.lifecycle.LiveData.c implements h {

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final j f916o;

        public LifecycleBoundObserver(j jVar, o oVar) {
            super(oVar);
            this.f916o = jVar;
        }

        public void d() {
            this.f916o.h0().c(this);
        }

        @Override // androidx.lifecycle.h
        public void e(j jVar, Lifecycle.Event event) {
            Lifecycle.State stateB = this.f916o.h0().b();
            if (stateB == Lifecycle.State.DESTROYED) {
                LiveData.this.l(this.f920c);
                return;
            }
            Lifecycle.State state = null;
            while (state != stateB) {
                a(k());
                state = stateB;
                stateB = this.f916o.h0().b();
            }
        }

        public boolean h(j jVar) {
            return this.f916o == jVar;
        }

        public boolean k() {
            return this.f916o.h0().b().isAtLeast(Lifecycle.State.STARTED);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Object obj;
            synchronized (LiveData.this.f906a) {
                obj = LiveData.this.f911f;
                LiveData.this.f911f = LiveData.f905k;
            }
            LiveData.this.m(obj);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class b extends c {
        public b(o oVar) {
            super(oVar);
        }

        @Override // androidx.lifecycle.LiveData.c
        public boolean k() {
            return true;
        }
    }

    public LiveData(Object obj) {
        this.f906a = new Object();
        this.f907b = new g.b();
        this.f908c = 0;
        this.f911f = f905k;
        this.f915j = new a();
        this.f910e = obj;
        this.f912g = 0;
    }

    public static void a(String str) {
        if (f.c.f().b()) {
            return;
        }
        throw new IllegalStateException("Cannot invoke " + str + " on a background thread");
    }

    public void b(int i10) {
        int i11 = this.f908c;
        this.f908c = i10 + i11;
        if (this.f909d) {
            return;
        }
        this.f909d = true;
        while (true) {
            try {
                int i12 = this.f908c;
                if (i11 == i12) {
                    this.f909d = false;
                    return;
                }
                boolean z10 = i11 == 0 && i12 > 0;
                boolean z11 = i11 > 0 && i12 == 0;
                if (z10) {
                    i();
                } else if (z11) {
                    j();
                }
                i11 = i12;
            } catch (Throwable th) {
                this.f909d = false;
                throw th;
            }
        }
    }

    public final void c(c cVar) {
        if (cVar.f921e) {
            if (!cVar.k()) {
                cVar.a(false);
                return;
            }
            int i10 = cVar.f922m;
            int i11 = this.f912g;
            if (i10 >= i11) {
                return;
            }
            cVar.f922m = i11;
            cVar.f920c.a(this.f910e);
        }
    }

    public void d(c cVar) {
        if (this.f913h) {
            this.f914i = true;
            return;
        }
        this.f913h = true;
        do {
            this.f914i = false;
            if (cVar != null) {
                c(cVar);
                cVar = null;
            } else {
                g.b.d dVarG = this.f907b.g();
                while (dVarG.hasNext()) {
                    c((c) ((Map.Entry) dVarG.next()).getValue());
                    if (this.f914i) {
                        break;
                    }
                }
            }
        } while (this.f914i);
        this.f913h = false;
    }

    public Object e() {
        Object obj = this.f910e;
        if (obj != f905k) {
            return obj;
        }
        return null;
    }

    public boolean f() {
        return this.f908c > 0;
    }

    public void g(j jVar, o oVar) {
        a("observe");
        if (jVar.h0().b() == Lifecycle.State.DESTROYED) {
            return;
        }
        LifecycleBoundObserver lifecycleBoundObserver = new LifecycleBoundObserver(jVar, oVar);
        c cVar = (c) this.f907b.n(oVar, lifecycleBoundObserver);
        if (cVar != null && !cVar.h(jVar)) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        }
        if (cVar != null) {
            return;
        }
        jVar.h0().a(lifecycleBoundObserver);
    }

    public void h(o oVar) {
        a("observeForever");
        b bVar = new b(oVar);
        c cVar = (c) this.f907b.n(oVar, bVar);
        if (cVar instanceof LifecycleBoundObserver) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        }
        if (cVar != null) {
            return;
        }
        bVar.a(true);
    }

    public void k(Object obj) {
        boolean z10;
        synchronized (this.f906a) {
            z10 = this.f911f == f905k;
            this.f911f = obj;
        }
        if (z10) {
            f.c.f().c(this.f915j);
        }
    }

    public void l(o oVar) {
        a("removeObserver");
        c cVar = (c) this.f907b.o(oVar);
        if (cVar == null) {
            return;
        }
        cVar.d();
        cVar.a(false);
    }

    public void m(Object obj) {
        a("setValue");
        this.f912g++;
        this.f910e = obj;
        d(null);
    }

    public LiveData() {
        this.f906a = new Object();
        this.f907b = new g.b();
        this.f908c = 0;
        Object obj = f905k;
        this.f911f = obj;
        this.f915j = new a();
        this.f910e = obj;
        this.f912g = -1;
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public abstract class c {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final o f920c;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f921e;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f922m = -1;

        public c(o oVar) {
            this.f920c = oVar;
        }

        public void a(boolean z10) {
            if (z10 == this.f921e) {
                return;
            }
            this.f921e = z10;
            LiveData.this.b(z10 ? 1 : -1);
            if (this.f921e) {
                LiveData.this.d(this);
            }
        }

        public boolean h(j jVar) {
            return false;
        }

        public abstract boolean k();

        public void d() {
        }
    }

    public void i() {
    }

    public void j() {
    }
}
