package u2;

import u2.b0;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class m extends b0.e.d.a {

    /* renamed from: a, reason: collision with root package name */
    public final b0.e.d.a.b f12695a;

    /* renamed from: b, reason: collision with root package name */
    public final c0 f12696b;

    /* renamed from: c, reason: collision with root package name */
    public final c0 f12697c;

    /* renamed from: d, reason: collision with root package name */
    public final Boolean f12698d;

    /* renamed from: e, reason: collision with root package name */
    public final int f12699e;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class b extends b0.e.d.a.AbstractC0131a {

        /* renamed from: a, reason: collision with root package name */
        public b0.e.d.a.b f12700a;

        /* renamed from: b, reason: collision with root package name */
        public c0 f12701b;

        /* renamed from: c, reason: collision with root package name */
        public c0 f12702c;

        /* renamed from: d, reason: collision with root package name */
        public Boolean f12703d;

        /* renamed from: e, reason: collision with root package name */
        public Integer f12704e;

        public b() {
        }

        public b(b0.e.d.a aVar) {
            this.f12700a = aVar.d();
            this.f12701b = aVar.c();
            this.f12702c = aVar.e();
            this.f12703d = aVar.b();
            this.f12704e = Integer.valueOf(aVar.f());
        }

        @Override // u2.b0.e.d.a.AbstractC0131a
        public b0.e.d.a a() {
            String str = "";
            if (this.f12700a == null) {
                str = " execution";
            }
            if (this.f12704e == null) {
                str = str + " uiOrientation";
            }
            if (str.isEmpty()) {
                return new m(this.f12700a, this.f12701b, this.f12702c, this.f12703d, this.f12704e.intValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // u2.b0.e.d.a.AbstractC0131a
        public b0.e.d.a.AbstractC0131a b(Boolean bool) {
            this.f12703d = bool;
            return this;
        }

        @Override // u2.b0.e.d.a.AbstractC0131a
        public b0.e.d.a.AbstractC0131a c(c0 c0Var) {
            this.f12701b = c0Var;
            return this;
        }

        @Override // u2.b0.e.d.a.AbstractC0131a
        public b0.e.d.a.AbstractC0131a d(b0.e.d.a.b bVar) {
            if (bVar == null) {
                throw new NullPointerException("Null execution");
            }
            this.f12700a = bVar;
            return this;
        }

        @Override // u2.b0.e.d.a.AbstractC0131a
        public b0.e.d.a.AbstractC0131a e(c0 c0Var) {
            this.f12702c = c0Var;
            return this;
        }

        @Override // u2.b0.e.d.a.AbstractC0131a
        public b0.e.d.a.AbstractC0131a f(int i10) {
            this.f12704e = Integer.valueOf(i10);
            return this;
        }
    }

    public m(b0.e.d.a.b bVar, c0 c0Var, c0 c0Var2, Boolean bool, int i10) {
        this.f12695a = bVar;
        this.f12696b = c0Var;
        this.f12697c = c0Var2;
        this.f12698d = bool;
        this.f12699e = i10;
    }

    @Override // u2.b0.e.d.a
    public Boolean b() {
        return this.f12698d;
    }

    @Override // u2.b0.e.d.a
    public c0 c() {
        return this.f12696b;
    }

    @Override // u2.b0.e.d.a
    public b0.e.d.a.b d() {
        return this.f12695a;
    }

    @Override // u2.b0.e.d.a
    public c0 e() {
        return this.f12697c;
    }

    public boolean equals(Object obj) {
        c0 c0Var;
        c0 c0Var2;
        Boolean bool;
        if (obj == this) {
            return true;
        }
        if (obj instanceof b0.e.d.a) {
            b0.e.d.a aVar = (b0.e.d.a) obj;
            if (this.f12695a.equals(aVar.d()) && ((c0Var = this.f12696b) != null ? c0Var.equals(aVar.c()) : aVar.c() == null) && ((c0Var2 = this.f12697c) != null ? c0Var2.equals(aVar.e()) : aVar.e() == null) && ((bool = this.f12698d) != null ? bool.equals(aVar.b()) : aVar.b() == null) && this.f12699e == aVar.f()) {
                return true;
            }
        }
        return false;
    }

    @Override // u2.b0.e.d.a
    public int f() {
        return this.f12699e;
    }

    @Override // u2.b0.e.d.a
    public b0.e.d.a.AbstractC0131a g() {
        return new b(this);
    }

    public int hashCode() {
        int iHashCode = (this.f12695a.hashCode() ^ 1000003) * 1000003;
        c0 c0Var = this.f12696b;
        int iHashCode2 = (iHashCode ^ (c0Var == null ? 0 : c0Var.hashCode())) * 1000003;
        c0 c0Var2 = this.f12697c;
        int iHashCode3 = (iHashCode2 ^ (c0Var2 == null ? 0 : c0Var2.hashCode())) * 1000003;
        Boolean bool = this.f12698d;
        return ((iHashCode3 ^ (bool != null ? bool.hashCode() : 0)) * 1000003) ^ this.f12699e;
    }

    public String toString() {
        return "Application{execution=" + this.f12695a + ", customAttributes=" + this.f12696b + ", internalKeys=" + this.f12697c + ", background=" + this.f12698d + ", uiOrientation=" + this.f12699e + "}";
    }
}
