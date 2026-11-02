package u2;

import u2.b0;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class r extends b0.e.d.a.b.AbstractC0138e {

    /* renamed from: a, reason: collision with root package name */
    public final String f12739a;

    /* renamed from: b, reason: collision with root package name */
    public final int f12740b;

    /* renamed from: c, reason: collision with root package name */
    public final c0 f12741c;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class b extends b0.e.d.a.b.AbstractC0138e.AbstractC0139a {

        /* renamed from: a, reason: collision with root package name */
        public String f12742a;

        /* renamed from: b, reason: collision with root package name */
        public Integer f12743b;

        /* renamed from: c, reason: collision with root package name */
        public c0 f12744c;

        @Override // u2.b0.e.d.a.b.AbstractC0138e.AbstractC0139a
        public b0.e.d.a.b.AbstractC0138e a() {
            String str = "";
            if (this.f12742a == null) {
                str = " name";
            }
            if (this.f12743b == null) {
                str = str + " importance";
            }
            if (this.f12744c == null) {
                str = str + " frames";
            }
            if (str.isEmpty()) {
                return new r(this.f12742a, this.f12743b.intValue(), this.f12744c);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // u2.b0.e.d.a.b.AbstractC0138e.AbstractC0139a
        public b0.e.d.a.b.AbstractC0138e.AbstractC0139a b(c0 c0Var) {
            if (c0Var == null) {
                throw new NullPointerException("Null frames");
            }
            this.f12744c = c0Var;
            return this;
        }

        @Override // u2.b0.e.d.a.b.AbstractC0138e.AbstractC0139a
        public b0.e.d.a.b.AbstractC0138e.AbstractC0139a c(int i10) {
            this.f12743b = Integer.valueOf(i10);
            return this;
        }

        @Override // u2.b0.e.d.a.b.AbstractC0138e.AbstractC0139a
        public b0.e.d.a.b.AbstractC0138e.AbstractC0139a d(String str) {
            if (str == null) {
                throw new NullPointerException("Null name");
            }
            this.f12742a = str;
            return this;
        }
    }

    public r(String str, int i10, c0 c0Var) {
        this.f12739a = str;
        this.f12740b = i10;
        this.f12741c = c0Var;
    }

    @Override // u2.b0.e.d.a.b.AbstractC0138e
    public c0 b() {
        return this.f12741c;
    }

    @Override // u2.b0.e.d.a.b.AbstractC0138e
    public int c() {
        return this.f12740b;
    }

    @Override // u2.b0.e.d.a.b.AbstractC0138e
    public String d() {
        return this.f12739a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof b0.e.d.a.b.AbstractC0138e) {
            b0.e.d.a.b.AbstractC0138e abstractC0138e = (b0.e.d.a.b.AbstractC0138e) obj;
            if (this.f12739a.equals(abstractC0138e.d()) && this.f12740b == abstractC0138e.c() && this.f12741c.equals(abstractC0138e.b())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((this.f12739a.hashCode() ^ 1000003) * 1000003) ^ this.f12740b) * 1000003) ^ this.f12741c.hashCode();
    }

    public String toString() {
        return "Thread{name=" + this.f12739a + ", importance=" + this.f12740b + ", frames=" + this.f12741c + "}";
    }
}
