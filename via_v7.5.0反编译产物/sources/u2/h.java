package u2;

import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicMarkableReference;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f12849a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final t2.h f12850b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f12851c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f12852d = new a(false);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a f12853e = new a(true);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AtomicMarkableReference f12854f = new AtomicMarkableReference(null, false);

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AtomicMarkableReference f12855a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AtomicReference f12856b = new AtomicReference(null);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f12857c;

        public a(boolean z10) {
            this.f12857c = z10;
            this.f12855a = new AtomicMarkableReference(new b(64, z10 ? 8192 : 1024), false);
        }

        public static /* synthetic */ Void a(a aVar) throws Throwable {
            aVar.f12856b.set(null);
            aVar.d();
            return null;
        }

        public Map b() {
            return ((b) this.f12855a.getReference()).a();
        }

        public final void c() {
            Callable callable = new Callable() { // from class: u2.g
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return h.a.a(this.f12848c);
                }
            };
            if (autodispose2.c.a(this.f12856b, null, callable)) {
                h.this.f12850b.g(callable);
            }
        }

        public final void d() throws Throwable {
            Map mapA;
            synchronized (this) {
                try {
                    if (this.f12855a.isMarked()) {
                        mapA = ((b) this.f12855a.getReference()).a();
                        AtomicMarkableReference atomicMarkableReference = this.f12855a;
                        atomicMarkableReference.set((b) atomicMarkableReference.getReference(), false);
                    } else {
                        mapA = null;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (mapA != null) {
                h.this.f12849a.k(h.this.f12851c, mapA, this.f12857c);
            }
        }

        public boolean e(String str, String str2) {
            synchronized (this) {
                try {
                    if (!((b) this.f12855a.getReference()).d(str, str2)) {
                        return false;
                    }
                    AtomicMarkableReference atomicMarkableReference = this.f12855a;
                    atomicMarkableReference.set((b) atomicMarkableReference.getReference(), true);
                    c();
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public h(String str, y2.g gVar, t2.h hVar) {
        this.f12851c = str;
        this.f12849a = new d(gVar);
        this.f12850b = hVar;
    }

    public static h f(String str, y2.g gVar, t2.h hVar) {
        d dVar = new d(gVar);
        h hVar2 = new h(str, gVar, hVar);
        ((b) hVar2.f12852d.f12855a.getReference()).e(dVar.g(str, false));
        ((b) hVar2.f12853e.f12855a.getReference()).e(dVar.g(str, true));
        hVar2.f12854f.set(dVar.h(str), false);
        return hVar2;
    }

    public static String g(String str, y2.g gVar) {
        return new d(gVar).h(str);
    }

    public Map d() {
        return this.f12852d.b();
    }

    public Map e() {
        return this.f12853e.b();
    }

    public boolean h(String str, String str2) {
        return this.f12853e.e(str, str2);
    }
}
