package q2;

import java.io.File;
import java.util.concurrent.atomic.AtomicReference;
import v2.b0;
import v2.d0;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class d implements q2.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final g f11720c = new b();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j3.a f11721a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicReference f11722b = new AtomicReference(null);

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class b implements g {
        public b() {
        }

        @Override // q2.g
        public File a() {
            return null;
        }

        @Override // q2.g
        public File b() {
            return null;
        }

        @Override // q2.g
        public File c() {
            return null;
        }

        @Override // q2.g
        public b0.a d() {
            return null;
        }

        @Override // q2.g
        public File e() {
            return null;
        }

        @Override // q2.g
        public File f() {
            return null;
        }

        @Override // q2.g
        public File g() {
            return null;
        }
    }

    public d(j3.a aVar) {
        this.f11721a = aVar;
        aVar.a(new j3.a.InterfaceC0083a() { // from class: q2.b
            @Override // j3.a.InterfaceC0083a
            public final void a(j3.b bVar) {
                d.f(this.f11715a, bVar);
            }
        });
    }

    public static /* synthetic */ void f(d dVar, j3.b bVar) {
        dVar.getClass();
        f.f().b("Crashlytics native component now available.");
        dVar.f11722b.set((q2.a) bVar.get());
    }

    @Override // q2.a
    public g a(String str) {
        q2.a aVar = (q2.a) this.f11722b.get();
        return aVar == null ? f11720c : aVar.a(str);
    }

    @Override // q2.a
    public boolean b() {
        q2.a aVar = (q2.a) this.f11722b.get();
        return aVar != null && aVar.b();
    }

    @Override // q2.a
    public void c(final String str, final String str2, final long j10, final d0 d0Var) {
        f.f().i("Deferring native open session: " + str);
        this.f11721a.a(new j3.a.InterfaceC0083a() { // from class: q2.c
            @Override // j3.a.InterfaceC0083a
            public final void a(j3.b bVar) {
                ((a) bVar.get()).c(str, str2, j10, d0Var);
            }
        });
    }

    @Override // q2.a
    public boolean d(String str) {
        q2.a aVar = (q2.a) this.f11722b.get();
        return aVar != null && aVar.d(str);
    }
}
