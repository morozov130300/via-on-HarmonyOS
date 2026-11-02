package u2;

import u2.d0;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class x extends d0 {

    /* renamed from: a, reason: collision with root package name */
    public final d0.a f12779a;

    /* renamed from: b, reason: collision with root package name */
    public final d0.c f12780b;

    /* renamed from: c, reason: collision with root package name */
    public final d0.b f12781c;

    public x(d0.a aVar, d0.c cVar, d0.b bVar) {
        if (aVar == null) {
            throw new NullPointerException("Null appData");
        }
        this.f12779a = aVar;
        if (cVar == null) {
            throw new NullPointerException("Null osData");
        }
        this.f12780b = cVar;
        if (bVar == null) {
            throw new NullPointerException("Null deviceData");
        }
        this.f12781c = bVar;
    }

    @Override // u2.d0
    public d0.a a() {
        return this.f12779a;
    }

    @Override // u2.d0
    public d0.b c() {
        return this.f12781c;
    }

    @Override // u2.d0
    public d0.c d() {
        return this.f12780b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof d0) {
            d0 d0Var = (d0) obj;
            if (this.f12779a.equals(d0Var.a()) && this.f12780b.equals(d0Var.d()) && this.f12781c.equals(d0Var.c())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((this.f12779a.hashCode() ^ 1000003) * 1000003) ^ this.f12780b.hashCode()) * 1000003) ^ this.f12781c.hashCode();
    }

    public String toString() {
        return "StaticSessionData{appData=" + this.f12779a + ", osData=" + this.f12780b + ", deviceData=" + this.f12781c + "}";
    }
}
