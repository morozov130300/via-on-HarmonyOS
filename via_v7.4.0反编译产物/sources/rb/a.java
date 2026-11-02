package rb;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class a implements d {

    /* renamed from: a, reason: collision with root package name */
    public final int f11631a;

    /* renamed from: b, reason: collision with root package name */
    public final qb.d f11632b;

    /* renamed from: c, reason: collision with root package name */
    public final String f11633c;

    /* renamed from: d, reason: collision with root package name */
    public final m9.d f11634d;

    public a(int i10, o9.c cVar, qb.d dVar) {
        this.f11631a = i10;
        this.f11632b = dVar;
        this.f11633c = dVar.getPath() + "bookmarks.html";
        this.f11634d = new m9.d(cVar);
    }

    @Override // rb.d
    public long a() {
        return this.f11632b.b(this.f11633c);
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
    public f d() {
        return g(true);
    }

    @Override // rb.d
    public f e() throws IOException {
        f fVarF;
        long jH = h();
        long jA = a();
        pc.a.a("sync bookmarks, remote modified time: %d", Long.valueOf(jH));
        pc.a.a("sync bookmarks, last pushed time: %d", Long.valueOf(jA));
        if (jA >= jH || jH == 0) {
            fVarF = null;
        } else {
            fVarF = f(jA == 0 ? 0 : 2);
        }
        if (fVarF == null) {
            return g(jH == 0);
        }
        return fVarF;
    }

    public final f f(int i10) throws IOException {
        pc.a.a("pull bookmarks, strategy: %d", Integer.valueOf(i10));
        try {
            InputStream inputStreamH = this.f11632b.h(this.f11633c);
            try {
                this.f11634d.b(new e(this.f11632b, true, a()), i10);
                pc.a.a("restore bookmarks", new Object[0]);
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

    public final f g(boolean z10) throws IOException {
        File fileA;
        pc.a.a("push bookmarks, forced: %s", Boolean.valueOf(z10));
        List listA = this.f11634d.a(new e(this.f11632b, false, 0L));
        if (listA.isEmpty() || (fileA = ((m9.a) listA.get(0)).a()) == null || !fileA.isFile()) {
            return null;
        }
        try {
            this.f11632b.c(this.f11633c, fileA, "text/html", z10);
            return null;
        } catch (IOException e10) {
            pc.a.i(e10);
            return new f(201, null, e10);
        }
    }

    public final long h() {
        try {
            return this.f11632b.e(this.f11633c);
        } catch (IOException unused) {
            pc.a.h("Cannot get remote modified time for: %s", this.f11633c);
            return 0L;
        }
    }
}
