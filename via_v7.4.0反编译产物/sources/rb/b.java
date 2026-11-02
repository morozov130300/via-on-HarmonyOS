package rb;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class b implements d {

    /* renamed from: a, reason: collision with root package name */
    public final int f11635a;

    /* renamed from: b, reason: collision with root package name */
    public final qb.d f11636b;

    /* renamed from: c, reason: collision with root package name */
    public final String f11637c;

    /* renamed from: d, reason: collision with root package name */
    public final m9.f f11638d;

    public b(int i10, y9.a aVar, qb.d dVar) {
        this.f11635a = i10;
        this.f11636b = dVar;
        this.f11637c = dVar.getPath() + "favorites.txt";
        this.f11638d = new m9.f(aVar, null);
    }

    private f f(int i10) throws IOException {
        pc.a.a("pull favorites, strategy: %d", Integer.valueOf(i10));
        try {
            InputStream inputStreamH = this.f11636b.h(this.f11637c);
            try {
                this.f11638d.b(new e(this.f11636b, true), i10);
                pc.a.a("override favorites", new Object[0]);
                if (inputStreamH == null) {
                    return null;
                }
                inputStreamH.close();
                return null;
            } finally {
            }
        } catch (Exception e10) {
            pc.a.i(e10);
            return new f(i10 == 1 ? 301 : 101, null, e10);
        }
    }

    private long g() {
        try {
            return this.f11636b.e(this.f11637c);
        } catch (IOException unused) {
            pc.a.h("Cannot get remote modified time for: %s", this.f11637c);
            return 0L;
        }
    }

    @Override // rb.d
    public long a() {
        return this.f11636b.b(this.f11637c);
    }

    @Override // rb.d
    public f b() {
        return f(0);
    }

    @Override // rb.d
    public f c() {
        return f(1);
    }

    @Override // rb.d
    public f d() throws IOException {
        File fileA;
        pc.a.a("push favorites", new Object[0]);
        List listA = this.f11638d.a(new e(this.f11636b, false));
        if (listA.isEmpty() || (fileA = ((m9.a) listA.get(0)).a()) == null || !fileA.isFile()) {
            return null;
        }
        try {
            this.f11636b.c(this.f11637c, fileA, "text/html", false);
            return null;
        } catch (IOException e10) {
            pc.a.i(e10);
            return new f(201, null, e10);
        }
    }

    @Override // rb.d
    public f e() throws IOException {
        f fVarF;
        long jG = g();
        long jA = a();
        pc.a.a("sync favorites, remote modified time: %d", Long.valueOf(jG));
        pc.a.a("sync favorites, last pushed time: %d", Long.valueOf(jA));
        if (jA >= jG || jG == 0) {
            fVarF = null;
        } else {
            fVarF = f(jA != 0 ? 2 : 0);
        }
        if (fVarF != null) {
            return fVarF;
        }
        if (jG == 0) {
            try {
                this.f11636b.a(this.f11637c, true);
            } catch (IOException e10) {
                pc.a.i(e10);
            }
        }
        return d();
    }
}
