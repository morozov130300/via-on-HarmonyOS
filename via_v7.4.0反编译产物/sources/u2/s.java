package u2;

import u2.b0;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class s extends b0.e.d.a.b.AbstractC0138e.AbstractC0140b {

    /* renamed from: a, reason: collision with root package name */
    public final long f12745a;

    /* renamed from: b, reason: collision with root package name */
    public final String f12746b;

    /* renamed from: c, reason: collision with root package name */
    public final String f12747c;

    /* renamed from: d, reason: collision with root package name */
    public final long f12748d;

    /* renamed from: e, reason: collision with root package name */
    public final int f12749e;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class b extends b0.e.d.a.b.AbstractC0138e.AbstractC0140b.AbstractC0141a {

        /* renamed from: a, reason: collision with root package name */
        public Long f12750a;

        /* renamed from: b, reason: collision with root package name */
        public String f12751b;

        /* renamed from: c, reason: collision with root package name */
        public String f12752c;

        /* renamed from: d, reason: collision with root package name */
        public Long f12753d;

        /* renamed from: e, reason: collision with root package name */
        public Integer f12754e;

        @Override // u2.b0.e.d.a.b.AbstractC0138e.AbstractC0140b.AbstractC0141a
        public b0.e.d.a.b.AbstractC0138e.AbstractC0140b a() {
            String str = "";
            if (this.f12750a == null) {
                str = " pc";
            }
            if (this.f12751b == null) {
                str = str + " symbol";
            }
            if (this.f12753d == null) {
                str = str + " offset";
            }
            if (this.f12754e == null) {
                str = str + " importance";
            }
            if (str.isEmpty()) {
                return new s(this.f12750a.longValue(), this.f12751b, this.f12752c, this.f12753d.longValue(), this.f12754e.intValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // u2.b0.e.d.a.b.AbstractC0138e.AbstractC0140b.AbstractC0141a
        public b0.e.d.a.b.AbstractC0138e.AbstractC0140b.AbstractC0141a b(String str) {
            this.f12752c = str;
            return this;
        }

        @Override // u2.b0.e.d.a.b.AbstractC0138e.AbstractC0140b.AbstractC0141a
        public b0.e.d.a.b.AbstractC0138e.AbstractC0140b.AbstractC0141a c(int i10) {
            this.f12754e = Integer.valueOf(i10);
            return this;
        }

        @Override // u2.b0.e.d.a.b.AbstractC0138e.AbstractC0140b.AbstractC0141a
        public b0.e.d.a.b.AbstractC0138e.AbstractC0140b.AbstractC0141a d(long j10) {
            this.f12753d = Long.valueOf(j10);
            return this;
        }

        @Override // u2.b0.e.d.a.b.AbstractC0138e.AbstractC0140b.AbstractC0141a
        public b0.e.d.a.b.AbstractC0138e.AbstractC0140b.AbstractC0141a e(long j10) {
            this.f12750a = Long.valueOf(j10);
            return this;
        }

        @Override // u2.b0.e.d.a.b.AbstractC0138e.AbstractC0140b.AbstractC0141a
        public b0.e.d.a.b.AbstractC0138e.AbstractC0140b.AbstractC0141a f(String str) {
            if (str == null) {
                throw new NullPointerException("Null symbol");
            }
            this.f12751b = str;
            return this;
        }
    }

    public s(long j10, String str, String str2, long j11, int i10) {
        this.f12745a = j10;
        this.f12746b = str;
        this.f12747c = str2;
        this.f12748d = j11;
        this.f12749e = i10;
    }

    @Override // u2.b0.e.d.a.b.AbstractC0138e.AbstractC0140b
    public String b() {
        return this.f12747c;
    }

    @Override // u2.b0.e.d.a.b.AbstractC0138e.AbstractC0140b
    public int c() {
        return this.f12749e;
    }

    @Override // u2.b0.e.d.a.b.AbstractC0138e.AbstractC0140b
    public long d() {
        return this.f12748d;
    }

    @Override // u2.b0.e.d.a.b.AbstractC0138e.AbstractC0140b
    public long e() {
        return this.f12745a;
    }

    public boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (obj instanceof b0.e.d.a.b.AbstractC0138e.AbstractC0140b) {
            b0.e.d.a.b.AbstractC0138e.AbstractC0140b abstractC0140b = (b0.e.d.a.b.AbstractC0138e.AbstractC0140b) obj;
            if (this.f12745a == abstractC0140b.e() && this.f12746b.equals(abstractC0140b.f()) && ((str = this.f12747c) != null ? str.equals(abstractC0140b.b()) : abstractC0140b.b() == null) && this.f12748d == abstractC0140b.d() && this.f12749e == abstractC0140b.c()) {
                return true;
            }
        }
        return false;
    }

    @Override // u2.b0.e.d.a.b.AbstractC0138e.AbstractC0140b
    public String f() {
        return this.f12746b;
    }

    public int hashCode() {
        long j10 = this.f12745a;
        int iHashCode = (((((int) (j10 ^ (j10 >>> 32))) ^ 1000003) * 1000003) ^ this.f12746b.hashCode()) * 1000003;
        String str = this.f12747c;
        int iHashCode2 = (iHashCode ^ (str == null ? 0 : str.hashCode())) * 1000003;
        long j11 = this.f12748d;
        return this.f12749e ^ ((iHashCode2 ^ ((int) (j11 ^ (j11 >>> 32)))) * 1000003);
    }

    public String toString() {
        return "Frame{pc=" + this.f12745a + ", symbol=" + this.f12746b + ", file=" + this.f12747c + ", offset=" + this.f12748d + ", importance=" + this.f12749e + "}";
    }
}
