package rb;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import k9.l;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class c implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f12119a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final qb.d f12120b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f12121c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final l f12122d;

    public c(int i10, qb.d dVar, l lVar) {
        this.f12119a = i10;
        this.f12120b = dVar;
        this.f12121c = dVar.getPath() + "settings.txt";
        this.f12122d = lVar;
    }

    private long g() {
        try {
            return this.f12120b.e(this.f12121c);
        } catch (IOException unused) {
            tc.a.i("Cannot get remote modified time for: %s", this.f12121c);
            return 0L;
        }
    }

    @Override // rb.d
    public long a() {
        return this.f12120b.b(this.f12121c);
    }

    @Override // rb.d
    public f b() {
        long jG = g();
        long jA = a();
        tc.a.a("sync settings, remote modified time: %d", Long.valueOf(jG));
        tc.a.a("sync settings, last pushed time: %d", Long.valueOf(jA));
        f fVarF = (jA >= jG || jG == 0) ? null : f(false);
        if (fVarF != null) {
            return fVarF;
        }
        if (jG == 0) {
            try {
                this.f12120b.a(this.f12121c, true);
            } catch (IOException e10) {
                tc.a.j(e10);
            }
        }
        return e();
    }

    @Override // rb.d
    public f c() {
        return f(false);
    }

    @Override // rb.d
    public f d() {
        return f(true);
    }

    @Override // rb.d
    public f e() {
        File fileA;
        tc.a.a("push settings", new Object[0]);
        List listA = this.f12122d.a(new e(this.f12120b, false));
        if (listA.isEmpty() || (fileA = ((k9.a) listA.get(0)).a()) == null || !fileA.isFile()) {
            return null;
        }
        try {
            tc.a.a("upload settings.txt", new Object[0]);
            this.f12120b.c(this.f12121c, fileA, "text/plain", false);
            return null;
        } catch (IOException e10) {
            tc.a.j(e10);
            return new f(201, null, e10);
        }
    }

    public final f f(boolean z10) {
        tc.a.a("pull settings, ignore local data: %s", Boolean.valueOf(z10));
        try {
            InputStream inputStreamH = this.f12120b.h(this.f12121c);
            try {
                this.f12122d.b(new e(this.f12120b, true), z10 ? 1 : 0);
                tc.a.a("override settings", new Object[0]);
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
            return new f(z10 ? 301 : 101, null, e10);
        }
    }
}
