package u2;

import u2.b0;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class p extends b0.e.d.a.b.c {

    /* renamed from: a, reason: collision with root package name */
    public final String f12723a;

    /* renamed from: b, reason: collision with root package name */
    public final String f12724b;

    /* renamed from: c, reason: collision with root package name */
    public final c0 f12725c;

    /* renamed from: d, reason: collision with root package name */
    public final b0.e.d.a.b.c f12726d;

    /* renamed from: e, reason: collision with root package name */
    public final int f12727e;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class b extends b0.e.d.a.b.c.AbstractC0135a {

        /* renamed from: a, reason: collision with root package name */
        public String f12728a;

        /* renamed from: b, reason: collision with root package name */
        public String f12729b;

        /* renamed from: c, reason: collision with root package name */
        public c0 f12730c;

        /* renamed from: d, reason: collision with root package name */
        public b0.e.d.a.b.c f12731d;

        /* renamed from: e, reason: collision with root package name */
        public Integer f12732e;

        @Override // u2.b0.e.d.a.b.c.AbstractC0135a
        public b0.e.d.a.b.c a() {
            String str = "";
            if (this.f12728a == null) {
                str = " type";
            }
            if (this.f12730c == null) {
                str = str + " frames";
            }
            if (this.f12732e == null) {
                str = str + " overflowCount";
            }
            if (str.isEmpty()) {
                return new p(this.f12728a, this.f12729b, this.f12730c, this.f12731d, this.f12732e.intValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // u2.b0.e.d.a.b.c.AbstractC0135a
        public b0.e.d.a.b.c.AbstractC0135a b(b0.e.d.a.b.c cVar) {
            this.f12731d = cVar;
            return this;
        }

        @Override // u2.b0.e.d.a.b.c.AbstractC0135a
        public b0.e.d.a.b.c.AbstractC0135a c(c0 c0Var) {
            if (c0Var == null) {
                throw new NullPointerException("Null frames");
            }
            this.f12730c = c0Var;
            return this;
        }

        @Override // u2.b0.e.d.a.b.c.AbstractC0135a
        public b0.e.d.a.b.c.AbstractC0135a d(int i10) {
            this.f12732e = Integer.valueOf(i10);
            return this;
        }

        @Override // u2.b0.e.d.a.b.c.AbstractC0135a
        public b0.e.d.a.b.c.AbstractC0135a e(String str) {
            this.f12729b = str;
            return this;
        }

        @Override // u2.b0.e.d.a.b.c.AbstractC0135a
        public b0.e.d.a.b.c.AbstractC0135a f(String str) {
            if (str == null) {
                throw new NullPointerException("Null type");
            }
            this.f12728a = str;
            return this;
        }
    }

    public p(String str, String str2, c0 c0Var, b0.e.d.a.b.c cVar, int i10) {
        this.f12723a = str;
        this.f12724b = str2;
        this.f12725c = c0Var;
        this.f12726d = cVar;
        this.f12727e = i10;
    }

    @Override // u2.b0.e.d.a.b.c
    public b0.e.d.a.b.c b() {
        return this.f12726d;
    }

    @Override // u2.b0.e.d.a.b.c
    public c0 c() {
        return this.f12725c;
    }

    @Override // u2.b0.e.d.a.b.c
    public int d() {
        return this.f12727e;
    }

    @Override // u2.b0.e.d.a.b.c
    public String e() {
        return this.f12724b;
    }

    public boolean equals(Object obj) {
        String str;
        b0.e.d.a.b.c cVar;
        if (obj == this) {
            return true;
        }
        if (obj instanceof b0.e.d.a.b.c) {
            b0.e.d.a.b.c cVar2 = (b0.e.d.a.b.c) obj;
            if (this.f12723a.equals(cVar2.f()) && ((str = this.f12724b) != null ? str.equals(cVar2.e()) : cVar2.e() == null) && this.f12725c.equals(cVar2.c()) && ((cVar = this.f12726d) != null ? cVar.equals(cVar2.b()) : cVar2.b() == null) && this.f12727e == cVar2.d()) {
                return true;
            }
        }
        return false;
    }

    @Override // u2.b0.e.d.a.b.c
    public String f() {
        return this.f12723a;
    }

    public int hashCode() {
        int iHashCode = (this.f12723a.hashCode() ^ 1000003) * 1000003;
        String str = this.f12724b;
        int iHashCode2 = (((iHashCode ^ (str == null ? 0 : str.hashCode())) * 1000003) ^ this.f12725c.hashCode()) * 1000003;
        b0.e.d.a.b.c cVar = this.f12726d;
        return ((iHashCode2 ^ (cVar != null ? cVar.hashCode() : 0)) * 1000003) ^ this.f12727e;
    }

    public String toString() {
        return "Exception{type=" + this.f12723a + ", reason=" + this.f12724b + ", frames=" + this.f12725c + ", causedBy=" + this.f12726d + ", overflowCount=" + this.f12727e + "}";
    }
}
