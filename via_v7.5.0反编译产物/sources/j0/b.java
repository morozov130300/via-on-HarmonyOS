package j0;

import androidx.lifecycle.a0;
import androidx.lifecycle.b0;
import androidx.lifecycle.d0;
import androidx.lifecycle.j;
import androidx.lifecycle.z;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import k.h;
import n.g;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class b extends j0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j f6723a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f6724b;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class a extends z {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final a0.b f6725f = new C0082a();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public h f6726d = new h();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f6727e = false;

        /* JADX INFO: renamed from: j0.b$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
        public static class C0082a implements a0.b {
            @Override // androidx.lifecycle.a0.b
            public z a(Class cls) {
                return new a();
            }

            @Override // androidx.lifecycle.a0.b
            public /* synthetic */ z b(Class cls, i0.a aVar) {
                return b0.b(this, cls, aVar);
            }
        }

        public static a k(d0 d0Var) {
            return (a) new a0(d0Var, f6725f).a(a.class);
        }

        @Override // androidx.lifecycle.z
        public void h() {
            super.h();
            if (this.f6726d.i() <= 0) {
                this.f6726d.a();
            } else {
                g.a(this.f6726d.j(0));
                throw null;
            }
        }

        public void j(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            if (this.f6726d.i() > 0) {
                printWriter.print(str);
                printWriter.println("Loaders:");
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append("    ");
                if (this.f6726d.i() <= 0) {
                    return;
                }
                g.a(this.f6726d.j(0));
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.f6726d.e(0));
                printWriter.print(": ");
                throw null;
            }
        }

        public void l() {
            if (this.f6726d.i() <= 0) {
                return;
            }
            g.a(this.f6726d.j(0));
            throw null;
        }
    }

    public b(j jVar, d0 d0Var) {
        this.f6723a = jVar;
        this.f6724b = a.k(d0Var);
    }

    @Override // j0.a
    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.f6724b.j(str, fileDescriptor, printWriter, strArr);
    }

    @Override // j0.a
    public void c() {
        this.f6724b.l();
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(128);
        sb2.append("LoaderManager{");
        sb2.append(Integer.toHexString(System.identityHashCode(this)));
        sb2.append(" in ");
        x.b.a(this.f6723a, sb2);
        sb2.append("}}");
        return sb2.toString();
    }
}
