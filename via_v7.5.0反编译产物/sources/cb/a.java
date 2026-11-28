package cb;

import x8.t1;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m9.b f2358a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final m9.a f2359b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f2360c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f2361d;

    public a(m9.b bVar) {
        this.f2359b = null;
        this.f2358a = bVar;
    }

    public m9.a a() {
        return this.f2359b;
    }

    public m9.b b() {
        return this.f2358a;
    }

    public int c() {
        return this.f2361d;
    }

    public long d() {
        return h() ? this.f2359b.a() : this.f2358a.a();
    }

    public String e() {
        m9.a aVar = this.f2359b;
        if (aVar != null) {
            return aVar.b();
        }
        m9.b bVar = this.f2358a;
        if (bVar != null) {
            return bVar.c();
        }
        return null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            a aVar = (a) obj;
            if (t1.a(this.f2358a, aVar.f2358a) && t1.a(this.f2359b, aVar.f2359b)) {
                return true;
            }
        }
        return false;
    }

    public int f() {
        m9.a aVar = this.f2359b;
        if (aVar != null) {
            return aVar.c();
        }
        m9.b bVar = this.f2358a;
        if (bVar != null) {
            return bVar.d();
        }
        return 0;
    }

    public String g() {
        m9.a aVar = this.f2359b;
        if (aVar != null) {
            return aVar.e();
        }
        m9.b bVar = this.f2358a;
        if (bVar != null) {
            return bVar.e();
        }
        return null;
    }

    public boolean h() {
        return this.f2359b != null;
    }

    public int hashCode() {
        return t1.b(this.f2358a, this.f2359b);
    }

    public boolean i() {
        return this.f2360c;
    }

    public void j(int i10) {
        this.f2361d = i10;
    }

    public void k(boolean z10) {
        this.f2360c = z10;
    }

    public String toString() {
        return "BookmarkData{bookmarkItem=" + this.f2358a + ", bookmarkFolder=" + this.f2359b + ", isImmutable=" + this.f2360c + '}';
    }

    public a(m9.a aVar) {
        this.f2359b = aVar;
        this.f2358a = null;
    }
}
