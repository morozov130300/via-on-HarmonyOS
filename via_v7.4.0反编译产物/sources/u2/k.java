package u2;

import u2.b0;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class k extends b0.e.c {

    /* renamed from: a, reason: collision with root package name */
    public final int f12667a;

    /* renamed from: b, reason: collision with root package name */
    public final String f12668b;

    /* renamed from: c, reason: collision with root package name */
    public final int f12669c;

    /* renamed from: d, reason: collision with root package name */
    public final long f12670d;

    /* renamed from: e, reason: collision with root package name */
    public final long f12671e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f12672f;

    /* renamed from: g, reason: collision with root package name */
    public final int f12673g;

    /* renamed from: h, reason: collision with root package name */
    public final String f12674h;

    /* renamed from: i, reason: collision with root package name */
    public final String f12675i;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class b extends b0.e.c.a {

        /* renamed from: a, reason: collision with root package name */
        public Integer f12676a;

        /* renamed from: b, reason: collision with root package name */
        public String f12677b;

        /* renamed from: c, reason: collision with root package name */
        public Integer f12678c;

        /* renamed from: d, reason: collision with root package name */
        public Long f12679d;

        /* renamed from: e, reason: collision with root package name */
        public Long f12680e;

        /* renamed from: f, reason: collision with root package name */
        public Boolean f12681f;

        /* renamed from: g, reason: collision with root package name */
        public Integer f12682g;

        /* renamed from: h, reason: collision with root package name */
        public String f12683h;

        /* renamed from: i, reason: collision with root package name */
        public String f12684i;

        @Override // u2.b0.e.c.a
        public b0.e.c a() {
            String str = "";
            if (this.f12676a == null) {
                str = " arch";
            }
            if (this.f12677b == null) {
                str = str + " model";
            }
            if (this.f12678c == null) {
                str = str + " cores";
            }
            if (this.f12679d == null) {
                str = str + " ram";
            }
            if (this.f12680e == null) {
                str = str + " diskSpace";
            }
            if (this.f12681f == null) {
                str = str + " simulator";
            }
            if (this.f12682g == null) {
                str = str + " state";
            }
            if (this.f12683h == null) {
                str = str + " manufacturer";
            }
            if (this.f12684i == null) {
                str = str + " modelClass";
            }
            if (str.isEmpty()) {
                return new k(this.f12676a.intValue(), this.f12677b, this.f12678c.intValue(), this.f12679d.longValue(), this.f12680e.longValue(), this.f12681f.booleanValue(), this.f12682g.intValue(), this.f12683h, this.f12684i);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // u2.b0.e.c.a
        public b0.e.c.a b(int i10) {
            this.f12676a = Integer.valueOf(i10);
            return this;
        }

        @Override // u2.b0.e.c.a
        public b0.e.c.a c(int i10) {
            this.f12678c = Integer.valueOf(i10);
            return this;
        }

        @Override // u2.b0.e.c.a
        public b0.e.c.a d(long j10) {
            this.f12680e = Long.valueOf(j10);
            return this;
        }

        @Override // u2.b0.e.c.a
        public b0.e.c.a e(String str) {
            if (str == null) {
                throw new NullPointerException("Null manufacturer");
            }
            this.f12683h = str;
            return this;
        }

        @Override // u2.b0.e.c.a
        public b0.e.c.a f(String str) {
            if (str == null) {
                throw new NullPointerException("Null model");
            }
            this.f12677b = str;
            return this;
        }

        @Override // u2.b0.e.c.a
        public b0.e.c.a g(String str) {
            if (str == null) {
                throw new NullPointerException("Null modelClass");
            }
            this.f12684i = str;
            return this;
        }

        @Override // u2.b0.e.c.a
        public b0.e.c.a h(long j10) {
            this.f12679d = Long.valueOf(j10);
            return this;
        }

        @Override // u2.b0.e.c.a
        public b0.e.c.a i(boolean z10) {
            this.f12681f = Boolean.valueOf(z10);
            return this;
        }

        @Override // u2.b0.e.c.a
        public b0.e.c.a j(int i10) {
            this.f12682g = Integer.valueOf(i10);
            return this;
        }
    }

    public k(int i10, String str, int i11, long j10, long j11, boolean z10, int i12, String str2, String str3) {
        this.f12667a = i10;
        this.f12668b = str;
        this.f12669c = i11;
        this.f12670d = j10;
        this.f12671e = j11;
        this.f12672f = z10;
        this.f12673g = i12;
        this.f12674h = str2;
        this.f12675i = str3;
    }

    @Override // u2.b0.e.c
    public int b() {
        return this.f12667a;
    }

    @Override // u2.b0.e.c
    public int c() {
        return this.f12669c;
    }

    @Override // u2.b0.e.c
    public long d() {
        return this.f12671e;
    }

    @Override // u2.b0.e.c
    public String e() {
        return this.f12674h;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof b0.e.c) {
            b0.e.c cVar = (b0.e.c) obj;
            if (this.f12667a == cVar.b() && this.f12668b.equals(cVar.f()) && this.f12669c == cVar.c() && this.f12670d == cVar.h() && this.f12671e == cVar.d() && this.f12672f == cVar.j() && this.f12673g == cVar.i() && this.f12674h.equals(cVar.e()) && this.f12675i.equals(cVar.g())) {
                return true;
            }
        }
        return false;
    }

    @Override // u2.b0.e.c
    public String f() {
        return this.f12668b;
    }

    @Override // u2.b0.e.c
    public String g() {
        return this.f12675i;
    }

    @Override // u2.b0.e.c
    public long h() {
        return this.f12670d;
    }

    public int hashCode() {
        int iHashCode = (((((this.f12667a ^ 1000003) * 1000003) ^ this.f12668b.hashCode()) * 1000003) ^ this.f12669c) * 1000003;
        long j10 = this.f12670d;
        int i10 = (iHashCode ^ ((int) (j10 ^ (j10 >>> 32)))) * 1000003;
        long j11 = this.f12671e;
        return ((((((((i10 ^ ((int) (j11 ^ (j11 >>> 32)))) * 1000003) ^ (this.f12672f ? 1231 : 1237)) * 1000003) ^ this.f12673g) * 1000003) ^ this.f12674h.hashCode()) * 1000003) ^ this.f12675i.hashCode();
    }

    @Override // u2.b0.e.c
    public int i() {
        return this.f12673g;
    }

    @Override // u2.b0.e.c
    public boolean j() {
        return this.f12672f;
    }

    public String toString() {
        return "Device{arch=" + this.f12667a + ", model=" + this.f12668b + ", cores=" + this.f12669c + ", ram=" + this.f12670d + ", diskSpace=" + this.f12671e + ", simulator=" + this.f12672f + ", state=" + this.f12673g + ", manufacturer=" + this.f12674h + ", modelClass=" + this.f12675i + "}";
    }
}
