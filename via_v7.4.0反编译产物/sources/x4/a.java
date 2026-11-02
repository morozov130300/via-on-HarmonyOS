package x4;

import android.webkit.WebResourceRequest;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class a implements b {

    /* renamed from: a, reason: collision with root package name */
    public final c f13601a;

    /* renamed from: b, reason: collision with root package name */
    public final e f13602b;

    /* renamed from: c, reason: collision with root package name */
    public final d f13603c;

    /* renamed from: d, reason: collision with root package name */
    public final v4.a f13604d;

    /* renamed from: g, reason: collision with root package name */
    public boolean f13607g;

    /* renamed from: f, reason: collision with root package name */
    public boolean f13606f = false;

    /* renamed from: h, reason: collision with root package name */
    public String f13608h = null;

    /* renamed from: i, reason: collision with root package name */
    public String f13609i = null;

    /* renamed from: e, reason: collision with root package name */
    public final v4.d f13605e = new v4.c();

    public a(c cVar, e eVar, d dVar, boolean z10, int i10) {
        this.f13601a = cVar;
        this.f13602b = eVar;
        this.f13603c = dVar;
        this.f13607g = z10;
        this.f13604d = new v4.b(i10);
    }

    public final void a(w4.b bVar) {
        if (bVar == null) {
            return;
        }
        if (bVar instanceof w4.a) {
            this.f13604d.c((w4.a) bVar);
        } else if (bVar instanceof w4.d) {
            this.f13605e.d((w4.d) bVar);
        }
    }

    @Override // x4.b
    public boolean b(List list) {
        return this.f13603c.b(list);
    }

    @Override // x4.b
    public w4.d c(String str, int i10, String str2) {
        if (this.f13606f || str.isEmpty()) {
            return null;
        }
        return this.f13605e.c(str, i10, str2);
    }

    @Override // x4.b
    public boolean d(String str) {
        if (this.f13606f) {
            return false;
        }
        this.f13608h = null;
        w4.b bVarD = this.f13602b.d(str);
        if (bVarD == null) {
            return false;
        }
        if (bVarD instanceof w4.d) {
            this.f13605e.e((w4.d) bVarD);
            return true;
        }
        if (!(bVarD instanceof w4.a)) {
            return true;
        }
        this.f13604d.d((w4.a) bVarD);
        return true;
    }

    @Override // x4.b
    public boolean e(String str) {
        if (this.f13606f) {
            return false;
        }
        this.f13608h = null;
        w4.b bVarE = this.f13602b.e(str);
        if (bVarE != null) {
            a(bVarE);
        }
        return bVarE != null;
    }

    @Override // x4.b
    public boolean f() {
        return this.f13603c.f();
    }

    @Override // x4.b
    public w4.b g(String str) {
        return this.f13602b.g(str);
    }

    @Override // x4.b
    public String h(String str) {
        String strM;
        if (this.f13606f || str == null || (strM = b5.c.m(str)) == null || strM.isEmpty()) {
            return null;
        }
        return this.f13604d.e(strM);
    }

    @Override // x4.b
    public boolean i(List list) {
        return this.f13603c.c(list);
    }

    @Override // x4.b
    public List j() {
        return this.f13603c.d();
    }

    @Override // x4.b
    public boolean k(boolean z10) {
        if (this.f13607g == z10) {
            return false;
        }
        this.f13607g = z10;
        this.f13608h = null;
        return true;
    }

    @Override // x4.b
    public String l() {
        return this.f13602b.c();
    }

    @Override // x4.b
    public w4.d m(WebResourceRequest webResourceRequest, String str) {
        if (webResourceRequest == null || webResourceRequest.getUrl() == null) {
            return null;
        }
        return c(webResourceRequest.getUrl().toString(), b5.c.j(webResourceRequest, str), str);
    }

    @Override // x4.b
    public boolean n(String str) {
        return this.f13602b.f(str);
    }

    @Override // x4.b
    public void o() {
        this.f13608h = null;
        this.f13606f = true;
        this.f13605e.clear();
        this.f13605e.a();
        this.f13604d.clear();
        this.f13604d.a();
        r(this.f13602b.a());
        if (this.f13607g) {
            r(this.f13601a.a());
        }
        r(this.f13603c.a());
        this.f13605e.b();
        this.f13604d.b();
        this.f13606f = false;
    }

    @Override // x4.b
    public String p() {
        return this.f13602b.b();
    }

    @Override // x4.b
    public w4.d q(String str, String str2) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        return c(str, b5.c.k(str, str2), str2);
    }

    public final void r(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            a((w4.b) it.next());
        }
    }
}
