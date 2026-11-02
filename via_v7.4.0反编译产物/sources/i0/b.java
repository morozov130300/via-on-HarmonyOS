package i0;

import androidx.lifecycle.b0;
import androidx.lifecycle.h;
import androidx.lifecycle.x;
import androidx.lifecycle.y;
import androidx.lifecycle.z;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import n.g;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class b extends i0.a {

    /* renamed from: a, reason: collision with root package name */
    public final h f6967a;

    /* renamed from: b, reason: collision with root package name */
    public final a f6968b;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class a extends x {

        /* renamed from: f, reason: collision with root package name */
        public static final y.b f6969f = new C0079a();

        /* renamed from: d, reason: collision with root package name */
        public k.h f6970d = new k.h();

        /* renamed from: e, reason: collision with root package name */
        public boolean f6971e = false;

        /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
        /* renamed from: i0.b$a$a, reason: collision with other inner class name */
        public static class C0079a implements y.b {
            @Override // androidx.lifecycle.y.b
            public x a(Class cls) {
                return new a();
            }

            @Override // androidx.lifecycle.y.b
            public /* synthetic */ x b(Class cls, h0.a aVar) {
                return z.b(this, cls, aVar);
            }
        }

        public static a k(b0 b0Var) {
            return (a) new y(b0Var, f6969f).a(a.class);
        }

        @Override // androidx.lifecycle.x
        public void h() {
            super.h();
            if (this.f6970d.e() <= 0) {
                this.f6970d.a();
            } else {
                g.a(this.f6970d.i(0));
                throw null;
            }
        }

        public void j(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            if (this.f6970d.e() > 0) {
                printWriter.print(str);
                printWriter.println("Loaders:");
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append("    ");
                if (this.f6970d.e() <= 0) {
                    return;
                }
                g.a(this.f6970d.i(0));
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.f6970d.d(0));
                printWriter.print(": ");
                throw null;
            }
        }

        public void l() {
            if (this.f6970d.e() <= 0) {
                return;
            }
            g.a(this.f6970d.i(0));
            throw null;
        }
    }

    public b(h hVar, b0 b0Var) {
        this.f6967a = hVar;
        this.f6968b = a.k(b0Var);
    }

    @Override // i0.a
    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.f6968b.j(str, fileDescriptor, printWriter, strArr);
    }

    @Override // i0.a
    public void c() {
        this.f6968b.l();
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(128);
        sb2.append("LoaderManager{");
        sb2.append(Integer.toHexString(System.identityHashCode(this)));
        sb2.append(" in ");
        w.b.a(this.f6967a, sb2);
        sb2.append("}}");
        return sb2.toString();
    }
}
