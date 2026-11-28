package xb;

import java.util.List;
import okhttp3.o;
import okhttp3.s;
import okhttp3.w;
import okhttp3.y;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class g implements s.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f14673a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final wb.f f14674b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c f14675c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final wb.c f14676d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f14677e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final w f14678f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final okhttp3.d f14679g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final o f14680h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f14681i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f14682j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f14683k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f14684l;

    public g(List list, wb.f fVar, c cVar, wb.c cVar2, int i10, w wVar, okhttp3.d dVar, o oVar, int i11, int i12, int i13) {
        this.f14673a = list;
        this.f14676d = cVar2;
        this.f14674b = fVar;
        this.f14675c = cVar;
        this.f14677e = i10;
        this.f14678f = wVar;
        this.f14679g = dVar;
        this.f14680h = oVar;
        this.f14681i = i11;
        this.f14682j = i12;
        this.f14683k = i13;
    }

    @Override // okhttp3.s.a
    public int a() {
        return this.f14682j;
    }

    @Override // okhttp3.s.a
    public int b() {
        return this.f14683k;
    }

    @Override // okhttp3.s.a
    public y c(w wVar) {
        return j(wVar, this.f14674b, this.f14675c, this.f14676d);
    }

    @Override // okhttp3.s.a
    public int d() {
        return this.f14681i;
    }

    @Override // okhttp3.s.a
    public w e() {
        return this.f14678f;
    }

    public okhttp3.d f() {
        return this.f14679g;
    }

    public okhttp3.g g() {
        return this.f14676d;
    }

    public o h() {
        return this.f14680h;
    }

    public c i() {
        return this.f14675c;
    }

    public y j(w wVar, wb.f fVar, c cVar, wb.c cVar2) {
        if (this.f14677e >= this.f14673a.size()) {
            throw new AssertionError();
        }
        this.f14684l++;
        if (this.f14675c != null && !this.f14676d.s(wVar.h())) {
            throw new IllegalStateException("network interceptor " + this.f14673a.get(this.f14677e - 1) + " must retain the same host and port");
        }
        if (this.f14675c != null && this.f14684l > 1) {
            throw new IllegalStateException("network interceptor " + this.f14673a.get(this.f14677e - 1) + " must call proceed() exactly once");
        }
        g gVar = new g(this.f14673a, fVar, cVar, cVar2, this.f14677e + 1, wVar, this.f14679g, this.f14680h, this.f14681i, this.f14682j, this.f14683k);
        s sVar = (s) this.f14673a.get(this.f14677e);
        y yVarA = sVar.a(gVar);
        if (cVar != null && this.f14677e + 1 < this.f14673a.size() && gVar.f14684l != 1) {
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
        return this.f14674b;
    }
}
