package l1;

import l1.e;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class a extends e {

    /* renamed from: b, reason: collision with root package name */
    public final long f8314b;

    /* renamed from: c, reason: collision with root package name */
    public final int f8315c;

    /* renamed from: d, reason: collision with root package name */
    public final int f8316d;

    /* renamed from: e, reason: collision with root package name */
    public final long f8317e;

    /* renamed from: f, reason: collision with root package name */
    public final int f8318f;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class b extends e.a {

        /* renamed from: a, reason: collision with root package name */
        public Long f8319a;

        /* renamed from: b, reason: collision with root package name */
        public Integer f8320b;

        /* renamed from: c, reason: collision with root package name */
        public Integer f8321c;

        /* renamed from: d, reason: collision with root package name */
        public Long f8322d;

        /* renamed from: e, reason: collision with root package name */
        public Integer f8323e;

        @Override // l1.e.a
        public e a() {
            String str = "";
            if (this.f8319a == null) {
                str = " maxStorageSizeInBytes";
            }
            if (this.f8320b == null) {
                str = str + " loadBatchSize";
            }
            if (this.f8321c == null) {
                str = str + " criticalSectionEnterTimeoutMs";
            }
            if (this.f8322d == null) {
                str = str + " eventCleanUpAge";
            }
            if (this.f8323e == null) {
                str = str + " maxBlobByteSizePerRow";
            }
            if (str.isEmpty()) {
                return new a(this.f8319a.longValue(), this.f8320b.intValue(), this.f8321c.intValue(), this.f8322d.longValue(), this.f8323e.intValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // l1.e.a
        public e.a b(int i10) {
            this.f8321c = Integer.valueOf(i10);
            return this;
        }

        @Override // l1.e.a
        public e.a c(long j10) {
            this.f8322d = Long.valueOf(j10);
            return this;
        }

        @Override // l1.e.a
        public e.a d(int i10) {
            this.f8320b = Integer.valueOf(i10);
            return this;
        }

        @Override // l1.e.a
        public e.a e(int i10) {
            this.f8323e = Integer.valueOf(i10);
            return this;
        }

        @Override // l1.e.a
        public e.a f(long j10) {
            this.f8319a = Long.valueOf(j10);
            return this;
        }
    }

    public a(long j10, int i10, int i11, long j11, int i12) {
        this.f8314b = j10;
        this.f8315c = i10;
        this.f8316d = i11;
        this.f8317e = j11;
        this.f8318f = i12;
    }

    @Override // l1.e
    public int b() {
        return this.f8316d;
    }

    @Override // l1.e
    public long c() {
        return this.f8317e;
    }

    @Override // l1.e
    public int d() {
        return this.f8315c;
    }

    @Override // l1.e
    public int e() {
        return this.f8318f;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof e) {
            e eVar = (e) obj;
            if (this.f8314b == eVar.f() && this.f8315c == eVar.d() && this.f8316d == eVar.b() && this.f8317e == eVar.c() && this.f8318f == eVar.e()) {
                return true;
            }
        }
        return false;
    }

    @Override // l1.e
    public long f() {
        return this.f8314b;
    }

    public int hashCode() {
        long j10 = this.f8314b;
        int i10 = (((((((int) (j10 ^ (j10 >>> 32))) ^ 1000003) * 1000003) ^ this.f8315c) * 1000003) ^ this.f8316d) * 1000003;
        long j11 = this.f8317e;
        return this.f8318f ^ ((i10 ^ ((int) (j11 ^ (j11 >>> 32)))) * 1000003);
    }

    public String toString() {
        return "EventStoreConfig{maxStorageSizeInBytes=" + this.f8314b + ", loadBatchSize=" + this.f8315c + ", criticalSectionEnterTimeoutMs=" + this.f8316d + ", eventCleanUpAge=" + this.f8317e + ", maxBlobByteSizePerRow=" + this.f8318f + "}";
    }
}
