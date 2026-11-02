package xb;

import java.util.List;
import okhttp3.o;
import okhttp3.s;
import okhttp3.w;
import okhttp3.y;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class g implements s.a {

    /* renamed from: a, reason: collision with root package name */
    public final List f14327a;

    /* renamed from: b, reason: collision with root package name */
    public final wb.f f14328b;

    /* renamed from: c, reason: collision with root package name */
    public final c f14329c;

    /* renamed from: d, reason: collision with root package name */
    public final wb.c f14330d;

    /* renamed from: e, reason: collision with root package name */
    public final int f14331e;

    /* renamed from: f, reason: collision with root package name */
    public final w f14332f;

    /* renamed from: g, reason: collision with root package name */
    public final okhttp3.d f14333g;

    /* renamed from: h, reason: collision with root package name */
    public final o f14334h;

    /* renamed from: i, reason: collision with root package name */
    public final int f14335i;

    /* renamed from: j, reason: collision with root package name */
    public final int f14336j;

    /* renamed from: k, reason: collision with root package name */
    public final int f14337k;

    /* renamed from: l, reason: collision with root package name */
    public int f14338l;

    public g(List list, wb.f fVar, c cVar, wb.c cVar2, int i10, w wVar, okhttp3.d dVar, o oVar, int i11, int i12, int i13) {
        this.f14327a = list;
        this.f14330d = cVar2;
        this.f14328b = fVar;
        this.f14329c = cVar;
        this.f14331e = i10;
        this.f14332f = wVar;
        this.f14333g = dVar;
        this.f14334h = oVar;
        this.f14335i = i11;
        this.f14336j = i12;
        this.f14337k = i13;
    }

    @Override // okhttp3.s.a
    public int a() {
        return this.f14336j;
    }

    @Override // okhttp3.s.a
    public int b() {
        return this.f14337k;
    }

    @Override // okhttp3.s.a
    public y c(w wVar) {
        return j(wVar, this.f14328b, this.f14329c, this.f14330d);
    }

    @Override // okhttp3.s.a
    public int d() {
        return this.f14335i;
    }

    @Override // okhttp3.s.a
    public w e() {
        return this.f14332f;
    }

    public okhttp3.d f() {
        return this.f14333g;
    }

    public okhttp3.g g() {
        return this.f14330d;
    }

    public o h() {
        return this.f14334h;
    }

    public c i() {
        return this.f14329c;
    }

    public y j(w wVar, wb.f fVar, c cVar, wb.c cVar2) {
        if (this.f14331e >= this.f14327a.size()) {
            throw new AssertionError();
        }
        this.f14338l++;
        if (this.f14329c != null && !this.f14330d.s(wVar.h())) {
            throw new IllegalStateException("network interceptor " + this.f14327a.get(this.f14331e - 1) + " must retain the same host and port");
        }
        if (this.f14329c != null && this.f14338l > 1) {
            throw new IllegalStateException("network interceptor " + this.f14327a.get(this.f14331e - 1) + " must call proceed() exactly once");
        }
        g gVar = new g(this.f14327a, fVar, cVar, cVar2, this.f14331e + 1, wVar, this.f14333g, this.f14334h, this.f14335i, this.f14336j, this.f14337k);
        s sVar = (s) this.f14327a.get(this.f14331e);
        y yVarA = sVar.a(gVar);
        if (cVar != null && this.f14331e + 1 < this.f14327a.size() && gVar.f14338l != 1) {
            throw new IllegalStateException("network interceptor " + sVar + " must call proceed() exactly once");
        }
        if (yVarA == null) {
            throw new NullPointerException("interceptor " + sVar + " returned null");
        }
        if (yVarA.a() != null) {
            return yVarA;
        }
        throw new IllegalStateException("interceptor " + sVar + " returned a response with no body");
    }

    public wb.f k() {
        return this.f14328b;
    }
}
