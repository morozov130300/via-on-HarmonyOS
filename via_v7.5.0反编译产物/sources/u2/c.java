package u2;

import java.io.File;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b f12818c = new b();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final y2.g f12819a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public u2.a f12820b;

    public c(y2.g gVar) {
        this.f12819a = gVar;
        this.f12820b = f12818c;
    }

    public void a() {
        this.f12820b.d();
    }

    public byte[] b() {
        return this.f12820b.c();
    }

    public String c() {
        return this.f12820b.b();
    }

    public final File d(String str) {
        return this.f12819a.o(str, "userlog");
    }

    public final void e(String str) {
        this.f12820b.a();
        this.f12820b = f12818c;
        if (str == null) {
            return;
        }
        f(d(str), 65536);
    }

    public void f(File file, int i10) {
        this.f12820b = new f(file, i10);
    }

    public void g(long j10, String str) {
        this.f12820b.e(j10, str);
    }

    public c(y2.g gVar, String str) {
        this(gVar);
        e(str);
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class b implements u2.a {
        public b() {
        }

        @Override // u2.a
        public String b() {
            return null;
        }

        @Override // u2.a
        public byte[] c() {
            return null;
        }

        @Override // u2.a
        public void a() {
        }

        @Override // u2.a
        public void d() {
        }

        @Override // u2.a
        public void e(long j10, String str) {
        }
    }
}
