package g1;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: c, reason: collision with root package name */
    public static final e f6132c = new a().a();

    /* renamed from: a, reason: collision with root package name */
    public final long f6133a;

    /* renamed from: b, reason: collision with root package name */
    public final long f6134b;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public long f6135a = 0;

        /* renamed from: b, reason: collision with root package name */
        public long f6136b = 0;

        public e a() {
            return new e(this.f6135a, this.f6136b);
        }

        public a b(long j10) {
            this.f6136b = j10;
            return this;
        }

        public a c(long j10) {
            this.f6135a = j10;
            return this;
        }
    }

    public e(long j10, long j11) {
        this.f6133a = j10;
        this.f6134b = j11;
    }

    public static a c() {
        return new a();
    }

    public long a() {
        return this.f6134b;
    }

    public long b() {
        return this.f6133a;
    }
}
