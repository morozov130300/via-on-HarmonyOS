package u2;

import u2.b0;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class t extends b0.e.d.c {

    /* renamed from: a, reason: collision with root package name */
    public final Double f12755a;

    /* renamed from: b, reason: collision with root package name */
    public final int f12756b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f12757c;

    /* renamed from: d, reason: collision with root package name */
    public final int f12758d;

    /* renamed from: e, reason: collision with root package name */
    public final long f12759e;

    /* renamed from: f, reason: collision with root package name */
    public final long f12760f;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class b extends b0.e.d.c.a {

        /* renamed from: a, reason: collision with root package name */
        public Double f12761a;

        /* renamed from: b, reason: collision with root package name */
        public Integer f12762b;

        /* renamed from: c, reason: collision with root package name */
        public Boolean f12763c;

        /* renamed from: d, reason: collision with root package name */
        public Integer f12764d;

        /* renamed from: e, reason: collision with root package name */
        public Long f12765e;

        /* renamed from: f, reason: collision with root package name */
        public Long f12766f;

        @Override // u2.b0.e.d.c.a
        public b0.e.d.c a() {
            String str = "";
            if (this.f12762b == null) {
                str = " batteryVelocity";
            }
            if (this.f12763c == null) {
                str = str + " proximityOn";
            }
            if (this.f12764d == null) {
                str = str + " orientation";
            }
            if (this.f12765e == null) {
                str = str + " ramUsed";
            }
            if (this.f12766f == null) {
                str = str + " diskUsed";
            }
            if (str.isEmpty()) {
                return new t(this.f12761a, this.f12762b.intValue(), this.f12763c.booleanValue(), this.f12764d.intValue(), this.f12765e.longValue(), this.f12766f.longValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // u2.b0.e.d.c.a
        public b0.e.d.c.a b(Double d10) {
            this.f12761a = d10;
            return this;
        }

        @Override // u2.b0.e.d.c.a
        public b0.e.d.c.a c(int i10) {
            this.f12762b = Integer.valueOf(i10);
            return this;
        }

        @Override // u2.b0.e.d.c.a
        public b0.e.d.c.a d(long j10) {
            this.f12766f = Long.valueOf(j10);
            return this;
        }

        @Override // u2.b0.e.d.c.a
        public b0.e.d.c.a e(int i10) {
            this.f12764d = Integer.valueOf(i10);
            return this;
        }

        @Override // u2.b0.e.d.c.a
        public b0.e.d.c.a f(boolean z10) {
            this.f12763c = Boolean.valueOf(z10);
            return this;
        }

        @Override // u2.b0.e.d.c.a
        public b0.e.d.c.a g(long j10) {
            this.f12765e = Long.valueOf(j10);
            return this;
        }
    }

    public t(Double d10, int i10, boolean z10, int i11, long j10, long j11) {
        this.f12755a = d10;
        this.f12756b = i10;
        this.f12757c = z10;
        this.f12758d = i11;
        this.f12759e = j10;
        this.f12760f = j11;
    }

    @Override // u2.b0.e.d.c
    public Double b() {
        return this.f12755a;
    }

    @Override // u2.b0.e.d.c
    public int c() {
        return this.f12756b;
    }

    @Override // u2.b0.e.d.c
    public long d() {
        return this.f12760f;
    }

    @Override // u2.b0.e.d.c
    public int e() {
        return this.f12758d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof b0.e.d.c) {
            b0.e.d.c cVar = (b0.e.d.c) obj;
            Double d10 = this.f12755a;
            if (d10 != null ? d10.equals(cVar.b()) : cVar.b() == null) {
                if (this.f12756b == cVar.c() && this.f12757c == cVar.g() && this.f12758d == cVar.e() && this.f12759e == cVar.f() && this.f12760f == cVar.d()) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // u2.b0.e.d.c
    public long f() {
        return this.f12759e;
    }

    @Override // u2.b0.e.d.c
    public boolean g() {
        return this.f12757c;
    }

    public int hashCode() {
        Double d10 = this.f12755a;
        int iHashCode = ((((((((d10 == null ? 0 : d10.hashCode()) ^ 1000003) * 1000003) ^ this.f12756b) * 1000003) ^ (this.f12757c ? 1231 : 1237)) * 1000003) ^ this.f12758d) * 1000003;
        long j10 = this.f12759e;
        long j11 = this.f12760f;
        return ((iHashCode ^ ((int) (j10 ^ (j10 >>> 32)))) * 1000003) ^ ((int) (j11 ^ (j11 >>> 32)));
    }

    public String toString() {
        return "Device{batteryLevel=" + this.f12755a + ", batteryVelocity=" + this.f12756b + ", proximityOn=" + this.f12757c + ", orientation=" + this.f12758d + ", ramUsed=" + this.f12759e + ", diskUsed=" + this.f12760f + "}";
    }
}
