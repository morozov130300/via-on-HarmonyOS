package c6;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class p {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final a f2077i = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n f2078a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p7.l f2079b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f2080c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f2081d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f2082e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f2083f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f2084g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f2085h;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }

        public a() {
        }
    }

    public p(n file, long j10, p7.l complete) {
        kotlin.jvm.internal.h.f(file, "file");
        kotlin.jvm.internal.h.f(complete, "complete");
        this.f2078a = file;
        this.f2079b = complete;
        this.f2081d = "";
        this.f2085h = j10;
    }

    public final void a(int i10) {
        if (this.f2084g) {
            return;
        }
        this.f2084g = true;
        this.f2078a.e();
        p7.l lVar = this.f2079b;
        if (1 > i10 || i10 >= 8) {
            i10 = -1;
        }
        lVar.invoke(Integer.valueOf(i10));
    }

    public final boolean b(long j10, String mimeType, long j11) {
        kotlin.jvm.internal.h.f(mimeType, "mimeType");
        if (this.f2084g) {
            return false;
        }
        if (this.f2083f || j10 < 0) {
            return h(7);
        }
        this.f2080c = j10;
        this.f2081d = mimeType;
        this.f2083f = true;
        if (!this.f2078a.c()) {
            return h(6);
        }
        this.f2085h = j11;
        return true;
    }

    public final boolean c(long j10, int i10, long j11, p7.a write) {
        kotlin.jvm.internal.h.f(write, "write");
        if (this.f2084g) {
            return false;
        }
        int iMin = (int) Math.min(65536L, this.f2080c - this.f2082e);
        if (!this.f2083f || j10 != this.f2082e || iMin <= 0 || i10 != iMin) {
            return h(7);
        }
        if (!((Boolean) write.invoke()).booleanValue()) {
            return h(6);
        }
        this.f2082e += (long) i10;
        this.f2085h = j11;
        return true;
    }

    public final void d(long j10) {
        if (j10 - this.f2085h >= 60000) {
            a(4);
        }
    }

    public final boolean e() {
        if (this.f2084g) {
            return false;
        }
        if (!this.f2083f || this.f2082e != this.f2080c) {
            return h(7);
        }
        if (!this.f2078a.b() || !this.f2078a.close()) {
            return h(6);
        }
        if (this.f2078a.length() != this.f2080c) {
            return h(7);
        }
        if (!this.f2078a.d()) {
            return h(6);
        }
        this.f2084g = true;
        this.f2079b.invoke(0);
        return true;
    }

    public final String f() {
        return this.f2081d;
    }

    public final long g() {
        return this.f2080c;
    }

    public final boolean h(int i10) {
        a(i10);
        return false;
    }
}
