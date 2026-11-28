package rb;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class b implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f12115a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final qb.d f12116b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f12117c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final k9.f f12118d;

    public b(int i10, w9.a aVar, qb.d dVar) {
        this.f12115a = i10;
        this.f12116b = dVar;
        this.f12117c = dVar.getPath() + "favorites.txt";
        this.f12118d = new k9.f(aVar, null);
    }

    private f f(int i10) {
        tc.a.a("pull favorites, strategy: %d", Integer.valueOf(i10));
        try {
            InputStream inputStreamH = this.f12116b.h(this.f12117c);
            try {
                this.f12118d.b(new e(this.f12116b, true), i10);
                tc.a.a("override favorites", new Object[0]);
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

    private long g() {
        try {
            return this.f12116b.e(this.f12117c);
        } catch (IOException unused) {
            tc.a.i("Cannot get remote modified time for: %s", this.f12117c);
            return 0L;
        }
    }

    @Override // rb.d
    public long a() {
        return this.f12116b.b(this.f12117c);
    }

    @Override // rb.d
    public f b() {
        f fVarF;
        long jG = g();
        long jA = a();
        tc.a.a("sync favorites, remote modified time: %d", Long.valueOf(jG));
        tc.a.a("sync favorites, last pushed time: %d", Long.valueOf(jA));
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
                this.f12116b.a(this.f12117c, true);
            } catch (IOException e10) {
                tc.a.j(e10);
            }
        }
        return e();
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
        File fileA;
        tc.a.a("push favorites", new Object[0]);
        List listA = this.f12118d.a(new e(this.f12116b, false));
        if (listA.isEmpty() || (fileA = ((k9.a) listA.get(0)).a()) == null || !fileA.isFile()) {
            return null;
        }
        try {
            this.f12116b.c(this.f12117c, fileA, "text/html", false);
            return null;
        } catch (IOException e10) {
            tc.a.j(e10);
            return new f(201, null, e10);
        }
    }
}
