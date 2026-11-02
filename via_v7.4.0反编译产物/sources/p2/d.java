package p2;

import i3.a;
import java.io.File;
import java.util.concurrent.atomic.AtomicReference;
import u2.b0;
import u2.d0;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class d implements p2.a {

    /* renamed from: c, reason: collision with root package name */
    public static final g f10942c = new b();

    /* renamed from: a, reason: collision with root package name */
    public final i3.a f10943a;

    /* renamed from: b, reason: collision with root package name */
    public final AtomicReference f10944b = new AtomicReference(null);

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class b implements g {
        public b() {
        }

        @Override // p2.g
        public File a() {
            return null;
        }

        @Override // p2.g
        public File b() {
            return null;
        }

        @Override // p2.g
        public File c() {
            return null;
        }

        @Override // p2.g
        public b0.a d() {
            return null;
        }

        @Override // p2.g
        public File e() {
            return null;
        }

        @Override // p2.g
        public File f() {
            return null;
        }

        @Override // p2.g
        public File g() {
            return null;
        }
    }

    public d(i3.a aVar) {
        this.f10943a = aVar;
        aVar.a(new a.InterfaceC0080a() { // from class: p2.b
            @Override // i3.a.InterfaceC0080a
            public final void a(i3.b bVar) {
                d.f(this.f10937a, bVar);
            }
        });
    }

    public static /* synthetic */ void f(d dVar, i3.b bVar) {
        dVar.getClass();
        f.f().b("Crashlytics native component now available.");
        dVar.f10944b.set((p2.a) bVar.get());
    }

    @Override // p2.a
    public g a(String str) {
        p2.a aVar = (p2.a) this.f10944b.get();
        return aVar == null ? f10942c : aVar.a(str);
    }

    @Override // p2.a
    public boolean b() {
        p2.a aVar = (p2.a) this.f10944b.get();
        return aVar != null && aVar.b();
    }

    @Override // p2.a
    public void c(final String str, final String str2, final long j10, final d0 d0Var) {
        f.f().i("Deferring native open session: " + str);
        this.f10943a.a(new a.InterfaceC0080a() { // from class: p2.c
            @Override // i3.a.InterfaceC0080a
            public final void a(i3.b bVar) {
                ((a) bVar.get()).c(str, str2, j10, d0Var);
            }
        });
    }

    @Override // p2.a
    public boolean d(String str) {
        p2.a aVar = (p2.a) this.f10944b.get();
        return aVar != null && aVar.d(str);
    }
}
