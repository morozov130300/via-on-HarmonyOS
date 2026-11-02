package rb;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import m9.l;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class c implements d {

    /* renamed from: a, reason: collision with root package name */
    public final int f11639a;

    /* renamed from: b, reason: collision with root package name */
    public final qb.d f11640b;

    /* renamed from: c, reason: collision with root package name */
    public final String f11641c;

    /* renamed from: d, reason: collision with root package name */
    public final l f11642d;

    public c(int i10, qb.d dVar, l lVar) {
        this.f11639a = i10;
        this.f11640b = dVar;
        this.f11641c = dVar.getPath() + "settings.txt";
        this.f11642d = lVar;
    }

    private long g() {
        try {
            return this.f11640b.e(this.f11641c);
        } catch (IOException unused) {
            pc.a.h("Cannot get remote modified time for: %s", this.f11641c);
            return 0L;
        }
    }

    @Override // rb.d
    public long a() {
        return this.f11640b.b(this.f11641c);
    }

    @Override // rb.d
    public f b() {
        return f(false);
    }

    @Override // rb.d
    public f c() {
        return f(true);
    }

    @Override // rb.d
    public f d() throws IOException {
        File fileA;
        pc.a.a("push settings", new Object[0]);
        List listA = this.f11642d.a(new e(this.f11640b, false));
        if (listA.isEmpty() || (fileA = ((m9.a) listA.get(0)).a()) == null || !fileA.isFile()) {
            return null;
        }
        try {
            pc.a.a("upload settings.txt", new Object[0]);
            this.f11640b.c(this.f11641c, fileA, "text/plain", false);
            return null;
        } catch (IOException e10) {
            pc.a.i(e10);
            return new f(201, null, e10);
        }
    }

    @Override // rb.d
    public f e() {
        long jG = g();
        long jA = a();
        pc.a.a("sync settings, remote modified time: %d", Long.valueOf(jG));
        pc.a.a("sync settings, last pushed time: %d", Long.valueOf(jA));
        f fVarF = (jA >= jG || jG == 0) ? null : f(false);
        if (fVarF != null) {
            return fVarF;
        }
        if (jG == 0) {
            try {
                this.f11640b.a(this.f11641c, true);
            } catch (IOException e10) {
                pc.a.i(e10);
            }
        }
        return d();
    }

    public final f f(boolean z10) throws IOException {
        pc.a.a("pull settings, ignore local data: %s", Boolean.valueOf(z10));
        try {
            InputStream inputStreamH = this.f11640b.h(this.f11641c);
            try {
                this.f11642d.b(new e(this.f11640b, true), z10 ? 1 : 0);
                pc.a.a("override settings", new Object[0]);
                if (inputStreamH == null) {
                    return null;
                }
                inputStreamH.close();
                return null;
            } finally {
            }
        } catch (Exception e10) {
            pc.a.i(e10);
            return new f(z10 ? 301 : 101, null, e10);
        }
    }
}
