package t2;

import java.io.File;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class c {

    /* renamed from: c, reason: collision with root package name */
    public static final b f12085c = new b();

    /* renamed from: a, reason: collision with root package name */
    public final x2.g f12086a;

    /* renamed from: b, reason: collision with root package name */
    public t2.a f12087b;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class b implements t2.a {
        public b() {
        }

        @Override // t2.a
        public void a() {
        }

        @Override // t2.a
        public String b() {
            return null;
        }

        @Override // t2.a
        public byte[] c() {
            return null;
        }

        @Override // t2.a
        public void d() {
        }

        @Override // t2.a
        public void e(long j10, String str) {
        }
    }

    public c(x2.g gVar) {
        this.f12086a = gVar;
        this.f12087b = f12085c;
    }

    public c(x2.g gVar, String str) {
        this(gVar);
        e(str);
    }

    public void a() {
        this.f12087b.d();
    }

    public byte[] b() {
        return this.f12087b.c();
    }

    public String c() {
        return this.f12087b.b();
    }

    public final File d(String str) {
        return this.f12086a.o(str, "userlog");
    }

    public final void e(String str) {
        this.f12087b.a();
        this.f12087b = f12085c;
        if (str == null) {
            return;
        }
        f(d(str), 65536);
    }

    public void f(File file, int i10) {
        this.f12087b = new f(file, i10);
    }

    public void g(long j10, String str) {
        this.f12087b.e(j10, str);
    }
}
