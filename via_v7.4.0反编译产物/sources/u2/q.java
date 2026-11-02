package u2;

import u2.b0;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class q extends b0.e.d.a.b.AbstractC0136d {

    /* renamed from: a, reason: collision with root package name */
    public final String f12733a;

    /* renamed from: b, reason: collision with root package name */
    public final String f12734b;

    /* renamed from: c, reason: collision with root package name */
    public final long f12735c;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class b extends b0.e.d.a.b.AbstractC0136d.AbstractC0137a {

        /* renamed from: a, reason: collision with root package name */
        public String f12736a;

        /* renamed from: b, reason: collision with root package name */
        public String f12737b;

        /* renamed from: c, reason: collision with root package name */
        public Long f12738c;

        @Override // u2.b0.e.d.a.b.AbstractC0136d.AbstractC0137a
        public b0.e.d.a.b.AbstractC0136d a() {
            String str = "";
            if (this.f12736a == null) {
                str = " name";
            }
            if (this.f12737b == null) {
                str = str + " code";
            }
            if (this.f12738c == null) {
                str = str + " address";
            }
            if (str.isEmpty()) {
                return new q(this.f12736a, this.f12737b, this.f12738c.longValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // u2.b0.e.d.a.b.AbstractC0136d.AbstractC0137a
        public b0.e.d.a.b.AbstractC0136d.AbstractC0137a b(long j10) {
            this.f12738c = Long.valueOf(j10);
            return this;
        }

        @Override // u2.b0.e.d.a.b.AbstractC0136d.AbstractC0137a
        public b0.e.d.a.b.AbstractC0136d.AbstractC0137a c(String str) {
            if (str == null) {
                throw new NullPointerException("Null code");
            }
            this.f12737b = str;
            return this;
        }

        @Override // u2.b0.e.d.a.b.AbstractC0136d.AbstractC0137a
        public b0.e.d.a.b.AbstractC0136d.AbstractC0137a d(String str) {
            if (str == null) {
                throw new NullPointerException("Null name");
            }
            this.f12736a = str;
            return this;
        }
    }

    public q(String str, String str2, long j10) {
        this.f12733a = str;
        this.f12734b = str2;
        this.f12735c = j10;
    }

    @Override // u2.b0.e.d.a.b.AbstractC0136d
    public long b() {
        return this.f12735c;
    }

    @Override // u2.b0.e.d.a.b.AbstractC0136d
    public String c() {
        return this.f12734b;
    }

    @Override // u2.b0.e.d.a.b.AbstractC0136d
    public String d() {
        return this.f12733a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof b0.e.d.a.b.AbstractC0136d) {
            b0.e.d.a.b.AbstractC0136d abstractC0136d = (b0.e.d.a.b.AbstractC0136d) obj;
            if (this.f12733a.equals(abstractC0136d.d()) && this.f12734b.equals(abstractC0136d.c()) && this.f12735c == abstractC0136d.b()) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = (((this.f12733a.hashCode() ^ 1000003) * 1000003) ^ this.f12734b.hashCode()) * 1000003;
        long j10 = this.f12735c;
        return iHashCode ^ ((int) (j10 ^ (j10 >>> 32)));
    }

    public String toString() {
        return "Signal{name=" + this.f12733a + ", code=" + this.f12734b + ", address=" + this.f12735c + "}";
    }
}
