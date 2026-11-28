package rb;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class a implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f12111a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final qb.d f12112b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f12113c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final k9.d f12114d;

    public a(int i10, m9.c cVar, qb.d dVar) {
        this.f12111a = i10;
        this.f12112b = dVar;
        this.f12113c = dVar.getPath() + "bookmarks.html";
        this.f12114d = new k9.d(cVar);
    }

    @Override // rb.d
    public long a() {
        return this.f12112b.b(this.f12113c);
    }

    @Override // rb.d
    public f b() {
        f fVarF;
        long jH = h();
        long jA = a();
        tc.a.a("sync bookmarks, remote modified time: %d", Long.valueOf(jH));
        tc.a.a("sync bookmarks, last pushed time: %d", Long.valueOf(jA));
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

    @Override // rb.d
    public f c() {
        return f(0);
    }

    @Override // rb.d
    public f d() {
        return f(1);
    }

    @Override // rb.d
    public f e() {
        return g(true);
    }

    public final f f(int i10) {
        tc.a.a("pull bookmarks, strategy: %d", Integer.valueOf(i10));
        try {
            InputStream inputStreamH = this.f12112b.h(this.f12113c);
            try {
                this.f12114d.b(new e(this.f12112b, true, a()), i10);
                tc.a.a("restore bookmarks", new Object[0]);
                if (inputStreamH == null) {
                    return null;
                }
                inputStreamH.close();
                return null;
            } catch (Throwable th) {
                if (inputStreamH != null) {
                    try {
                        inputStreamH.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        } catch (Exception e10) {
            tc.a.j(e10);
            return new f(i10 == 1 ? 301 : 101, null, e10);
        }
    }

    public final f g(boolean z10) {
        File fileA;
        tc.a.a("push bookmarks, forced: %s", Boolean.valueOf(z10));
        List listA = this.f12114d.a(new e(this.f12112b, false, 0L));
        if (listA.isEmpty() || (fileA = ((k9.a) listA.get(0)).a()) == null || !fileA.isFile()) {
            return null;
        }
        try {
            this.f12112b.c(this.f12113c, fileA, "text/html", z10);
            return null;
        } catch (IOException e10) {
            tc.a.j(e10);
            return new f(201, null, e10);
        }
    }

    public final long h() {
        try {
            return this.f12112b.e(this.f12113c);
        } catch (IOException unused) {
            tc.a.i("Cannot get remote modified time for: %s", this.f12113c);
            return 0L;
        }
    }
}
