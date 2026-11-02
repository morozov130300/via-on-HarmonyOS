package cb;

import z8.u1;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public final o9.b f3062a;

    /* renamed from: b, reason: collision with root package name */
    public final o9.a f3063b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f3064c;

    /* renamed from: d, reason: collision with root package name */
    public int f3065d;

    public a(o9.a aVar) {
        this.f3063b = aVar;
        this.f3062a = null;
    }

    public a(o9.b bVar) {
        this.f3063b = null;
        this.f3062a = bVar;
    }

    public o9.a a() {
        return this.f3063b;
    }

    public o9.b b() {
        return this.f3062a;
    }

    public int c() {
        return this.f3065d;
    }

    public String d() {
        o9.a aVar = this.f3063b;
        if (aVar != null) {
            return aVar.b();
        }
        o9.b bVar = this.f3062a;
        if (bVar != null) {
            return bVar.c();
        }
        return null;
    }

    public int e() {
        o9.a aVar = this.f3063b;
        if (aVar != null) {
            return aVar.c();
        }
        o9.b bVar = this.f3062a;
        if (bVar != null) {
            return bVar.d();
        }
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            a aVar = (a) obj;
            if (u1.a(this.f3062a, aVar.f3062a) && u1.a(this.f3063b, aVar.f3063b)) {
                return true;
            }
        }
        return false;
    }

    public String f() {
        o9.a aVar = this.f3063b;
        if (aVar != null) {
            return aVar.e();
        }
        o9.b bVar = this.f3062a;
        if (bVar != null) {
            return bVar.e();
        }
        return null;
    }

    public boolean g() {
        return this.f3063b != null;
    }

    public boolean h() {
        return this.f3064c;
    }

    public int hashCode() {
        return u1.b(this.f3062a, this.f3063b);
    }

    public void i(int i10) {
        this.f3065d = i10;
    }

    public void j(boolean z10) {
        this.f3064c = z10;
    }

    public String toString() {
        return "BookmarkData{bookmarkItem=" + this.f3062a + ", bookmarkFolder=" + this.f3063b + ", isImmutable=" + this.f3064c + '}';
    }
}
