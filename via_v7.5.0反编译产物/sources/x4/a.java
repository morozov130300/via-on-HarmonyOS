package x4;

import android.webkit.WebResourceRequest;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f14498a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f14499b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d f14500c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f14502e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public v4.a f14503f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f14505h;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f14501d = new Object();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f14506i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f14507j = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public v4.d f14504g = new v4.c();

    public a(c cVar, e eVar, d dVar, boolean z10, int i10) {
        this.f14498a = cVar;
        this.f14499b = eVar;
        this.f14500c = dVar;
        this.f14505h = z10;
        this.f14502e = i10;
        this.f14503f = new v4.b(i10);
    }

    @Override // x4.b
    public synchronized boolean a(List list) {
        return this.f14500c.a(list);
    }

    @Override // x4.b
    public w4.d b(String str, int i10, String str2) {
        w4.d dVarB;
        if (str.isEmpty()) {
            return null;
        }
        synchronized (this.f14501d) {
            dVarB = this.f14504g.b(str, i10, str2);
        }
        return dVarB;
    }

    @Override // x4.b
    public synchronized boolean c(String str) {
        w4.b bVarC = this.f14499b.c(str);
        if (bVarC == null) {
            return false;
        }
        synchronized (this.f14501d) {
            try {
                if (bVarC instanceof w4.d) {
                    this.f14504g.e((w4.d) bVarC);
                } else if (bVarC instanceof w4.a) {
                    this.f14503f.e((w4.a) bVarC);
                }
                this.f14506i = null;
            } catch (Throwable th) {
                throw th;
            }
        }
        return true;
    }

    @Override // x4.b
    public synchronized boolean d(String str) {
        w4.b bVarD;
        bVarD = this.f14499b.d(str);
        if (bVarD != null) {
            synchronized (this.f14501d) {
                q(bVarD, this.f14504g, this.f14503f);
                this.f14506i = null;
            }
        }
        return bVarD != null;
    }

    @Override // x4.b
    public boolean e() {
        return this.f14500c.e();
    }

    @Override // x4.b
    public synchronized w4.b f(String str) {
        return this.f14499b.f(str);
    }

    @Override // x4.b
    public String g(String str) {
        String strM;
        String strF;
        if (str == null || (strM = b5.c.m(str)) == null || strM.isEmpty()) {
            return null;
        }
        synchronized (this.f14501d) {
            strF = this.f14503f.f(strM);
        }
        return strF;
    }

    @Override // x4.b
    public synchronized boolean h(List list) {
        return this.f14500c.b(list);
    }

    @Override // x4.b
    public synchronized List i() {
        return this.f14500c.c();
    }

    @Override // x4.b
    public synchronized boolean j(boolean z10) {
        if (this.f14505h == z10) {
            return false;
        }
        this.f14505h = z10;
        return true;
    }

    @Override // x4.b
    public String k() {
        return this.f14499b.e();
    }

    @Override // x4.b
    public w4.d l(WebResourceRequest webResourceRequest, String str) {
        if (webResourceRequest == null || webResourceRequest.getUrl() == null) {
            return null;
        }
        return b(webResourceRequest.getUrl().toString(), b5.c.j(webResourceRequest, str), str);
    }

    @Override // x4.b
    public synchronized boolean m(String str) {
        return this.f14499b.g(str);
    }

    @Override // x4.b
    public synchronized void n() {
        try {
            v4.c cVar = new v4.c();
            v4.b bVar = new v4.b(this.f14502e);
            cVar.a();
            bVar.a();
            r(this.f14499b.a(), cVar, bVar);
            if (this.f14505h) {
                r(this.f14498a.a(), cVar, bVar);
            }
            for (w4.c cVar2 : this.f14500c.c()) {
                if (cVar2.h()) {
                    r(b5.c.t(cVar2.a()), cVar, bVar);
                }
            }
            cVar.c();
            bVar.c();
            synchronized (this.f14501d) {
                this.f14504g = cVar;
                this.f14503f = bVar;
                this.f14506i = null;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // x4.b
    public synchronized String o() {
        return this.f14499b.b();
    }

    @Override // x4.b
    public w4.d p(String str, String str2) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        return b(str, b5.c.k(str, str2), str2);
    }

    public final void q(w4.b bVar, v4.d dVar, v4.a aVar) {
        if (bVar instanceof w4.a) {
            aVar.d((w4.a) bVar);
        } else if (bVar instanceof w4.d) {
            dVar.d((w4.d) bVar);
        }
    }

    public final void r(List list, v4.d dVar, v4.a aVar) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            q((w4.b) it.next(), dVar, aVar);
        }
    }
}
