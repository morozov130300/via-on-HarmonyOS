package g1;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: c, reason: collision with root package name */
    public static final d f6127c = new a().a();

    /* renamed from: a, reason: collision with root package name */
    public final long f6128a;

    /* renamed from: b, reason: collision with root package name */
    public final long f6129b;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public long f6130a = 0;

        /* renamed from: b, reason: collision with root package name */
        public long f6131b = 0;

        public d a() {
            return new d(this.f6130a, this.f6131b);
        }

        public a b(long j10) {
            this.f6130a = j10;
            return this;
        }

        public a c(long j10) {
            this.f6131b = j10;
            return this;
        }
    }

    public d(long j10, long j11) {
        this.f6128a = j10;
        this.f6129b = j11;
    }

    public static a c() {
        return new a();
    }

    public long a() {
        return this.f6128a;
    }

    public long b() {
        return this.f6129b;
    }
}
