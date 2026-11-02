package t2;

import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicMarkableReference;
import java.util.concurrent.atomic.AtomicReference;
import t2.h;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    public final d f12116a;

    /* renamed from: b, reason: collision with root package name */
    public final s2.h f12117b;

    /* renamed from: c, reason: collision with root package name */
    public final String f12118c;

    /* renamed from: d, reason: collision with root package name */
    public final a f12119d = new a(false);

    /* renamed from: e, reason: collision with root package name */
    public final a f12120e = new a(true);

    /* renamed from: f, reason: collision with root package name */
    public final AtomicMarkableReference f12121f = new AtomicMarkableReference(null, false);

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a {

        /* renamed from: a, reason: collision with root package name */
        public final AtomicMarkableReference f12122a;

        /* renamed from: b, reason: collision with root package name */
        public final AtomicReference f12123b = new AtomicReference(null);

        /* renamed from: c, reason: collision with root package name */
        public final boolean f12124c;

        public a(boolean z10) {
            this.f12124c = z10;
            this.f12122a = new AtomicMarkableReference(new b(64, z10 ? 8192 : 1024), false);
        }

        public static /* synthetic */ Void a(a aVar) throws Throwable {
            aVar.f12123b.set(null);
            aVar.d();
            return null;
        }

        public Map b() {
            return ((b) this.f12122a.getReference()).a();
        }

        public final void c() {
            Callable callable = new Callable() { // from class: t2.g
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return h.a.a(this.f12115e);
                }
            };
            if (autodispose2.c.a(this.f12123b, null, callable)) {
                h.this.f12117b.g(callable);
            }
        }

        public final void d() throws Throwable {
            Map mapA;
            synchronized (this) {
                try {
                    if (this.f12122a.isMarked()) {
                        mapA = ((b) this.f12122a.getReference()).a();
                        AtomicMarkableReference atomicMarkableReference = this.f12122a;
                        atomicMarkableReference.set((b) atomicMarkableReference.getReference(), false);
                    } else {
                        mapA = null;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (mapA != null) {
                h.this.f12116a.k(h.this.f12118c, mapA, this.f12124c);
            }
        }

        public boolean e(String str, String str2) {
            synchronized (this) {
                try {
                    if (!((b) this.f12122a.getReference()).d(str, str2)) {
                        return false;
                    }
                    AtomicMarkableReference atomicMarkableReference = this.f12122a;
                    atomicMarkableReference.set((b) atomicMarkableReference.getReference(), true);
                    c();
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public h(String str, x2.g gVar, s2.h hVar) {
        this.f12118c = str;
        this.f12116a = new d(gVar);
        this.f12117b = hVar;
    }

    public static h f(String str, x2.g gVar, s2.h hVar) {
        d dVar = new d(gVar);
        h hVar2 = new h(str, gVar, hVar);
        ((b) hVar2.f12119d.f12122a.getReference()).e(dVar.g(str, false));
        ((b) hVar2.f12120e.f12122a.getReference()).e(dVar.g(str, true));
        hVar2.f12121f.set(dVar.h(str), false);
        return hVar2;
    }

    public static String g(String str, x2.g gVar) {
        return new d(gVar).h(str);
    }

    public Map d() {
        return this.f12119d.b();
    }

    public Map e() {
        return this.f12120e.b();
    }

    public boolean h(String str, String str2) {
        return this.f12120e.e(str, str2);
    }
}
