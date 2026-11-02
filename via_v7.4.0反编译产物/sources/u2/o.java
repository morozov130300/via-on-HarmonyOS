package u2;

import u2.b0;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class o extends b0.e.d.a.b.AbstractC0132a {

    /* renamed from: a, reason: collision with root package name */
    public final long f12715a;

    /* renamed from: b, reason: collision with root package name */
    public final long f12716b;

    /* renamed from: c, reason: collision with root package name */
    public final String f12717c;

    /* renamed from: d, reason: collision with root package name */
    public final String f12718d;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class b extends b0.e.d.a.b.AbstractC0132a.AbstractC0133a {

        /* renamed from: a, reason: collision with root package name */
        public Long f12719a;

        /* renamed from: b, reason: collision with root package name */
        public Long f12720b;

        /* renamed from: c, reason: collision with root package name */
        public String f12721c;

        /* renamed from: d, reason: collision with root package name */
        public String f12722d;

        @Override // u2.b0.e.d.a.b.AbstractC0132a.AbstractC0133a
        public b0.e.d.a.b.AbstractC0132a a() {
            String str = "";
            if (this.f12719a == null) {
                str = " baseAddress";
            }
            if (this.f12720b == null) {
                str = str + " size";
            }
            if (this.f12721c == null) {
                str = str + " name";
            }
            if (str.isEmpty()) {
                return new o(this.f12719a.longValue(), this.f12720b.longValue(), this.f12721c, this.f12722d);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // u2.b0.e.d.a.b.AbstractC0132a.AbstractC0133a
        public b0.e.d.a.b.AbstractC0132a.AbstractC0133a b(long j10) {
            this.f12719a = Long.valueOf(j10);
            return this;
        }

        @Override // u2.b0.e.d.a.b.AbstractC0132a.AbstractC0133a
        public b0.e.d.a.b.AbstractC0132a.AbstractC0133a c(String str) {
            if (str == null) {
                throw new NullPointerException("Null name");
            }
            this.f12721c = str;
            return this;
        }

        @Override // u2.b0.e.d.a.b.AbstractC0132a.AbstractC0133a
        public b0.e.d.a.b.AbstractC0132a.AbstractC0133a d(long j10) {
            this.f12720b = Long.valueOf(j10);
            return this;
        }

        @Override // u2.b0.e.d.a.b.AbstractC0132a.AbstractC0133a
        public b0.e.d.a.b.AbstractC0132a.AbstractC0133a e(String str) {
            this.f12722d = str;
            return this;
        }
    }

    public o(long j10, long j11, String str, String str2) {
        this.f12715a = j10;
        this.f12716b = j11;
        this.f12717c = str;
        this.f12718d = str2;
    }

    @Override // u2.b0.e.d.a.b.AbstractC0132a
    public long b() {
        return this.f12715a;
    }

    @Override // u2.b0.e.d.a.b.AbstractC0132a
    public String c() {
        return this.f12717c;
    }

    @Override // u2.b0.e.d.a.b.AbstractC0132a
    public long d() {
        return this.f12716b;
    }

    @Override // u2.b0.e.d.a.b.AbstractC0132a
    public String e() {
        return this.f12718d;
    }

    public boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (obj instanceof b0.e.d.a.b.AbstractC0132a) {
            b0.e.d.a.b.AbstractC0132a abstractC0132a = (b0.e.d.a.b.AbstractC0132a) obj;
            if (this.f12715a == abstractC0132a.b() && this.f12716b == abstractC0132a.d() && this.f12717c.equals(abstractC0132a.c()) && ((str = this.f12718d) != null ? str.equals(abstractC0132a.e()) : abstractC0132a.e() == null)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        long j10 = this.f12715a;
        long j11 = this.f12716b;
        int iHashCode = (((((((int) (j10 ^ (j10 >>> 32))) ^ 1000003) * 1000003) ^ ((int) (j11 ^ (j11 >>> 32)))) * 1000003) ^ this.f12717c.hashCode()) * 1000003;
        String str = this.f12718d;
        return (str == null ? 0 : str.hashCode()) ^ iHashCode;
    }

    public String toString() {
        return "BinaryImage{baseAddress=" + this.f12715a + ", size=" + this.f12716b + ", name=" + this.f12717c + ", uuid=" + this.f12718d + "}";
    }
}
