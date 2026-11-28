package v2;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class l extends b0.e.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f13224a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f13225b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b0.e.d.a f13226c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b0.e.d.c f13227d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final b0.e.d.AbstractC0147d f13228e;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class b extends b0.e.d.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Long f13229a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f13230b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public b0.e.d.a f13231c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public b0.e.d.c f13232d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public b0.e.d.AbstractC0147d f13233e;

        @Override // v2.b0.e.d.b
        public b0.e.d a() {
            String str = "";
            if (this.f13229a == null) {
                str = " timestamp";
            }
            if (this.f13230b == null) {
                str = str + " type";
            }
            if (this.f13231c == null) {
                str = str + " app";
            }
            if (this.f13232d == null) {
                str = str + " device";
            }
            if (str.isEmpty()) {
                return new l(this.f13229a.longValue(), this.f13230b, this.f13231c, this.f13232d, this.f13233e);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // v2.b0.e.d.b
        public b0.e.d.b b(b0.e.d.a aVar) {
            if (aVar == null) {
                throw new NullPointerException("Null app");
            }
            this.f13231c = aVar;
            return this;
        }

        @Override // v2.b0.e.d.b
        public b0.e.d.b c(b0.e.d.c cVar) {
            if (cVar == null) {
                throw new NullPointerException("Null device");
            }
            this.f13232d = cVar;
            return this;
        }

        @Override // v2.b0.e.d.b
        public b0.e.d.b d(b0.e.d.AbstractC0147d abstractC0147d) {
            this.f13233e = abstractC0147d;
            return this;
        }

        @Override // v2.b0.e.d.b
        public b0.e.d.b e(long j10) {
            this.f13229a = Long.valueOf(j10);
            return this;
        }

        @Override // v2.b0.e.d.b
        public b0.e.d.b f(String str) {
            if (str == null) {
                throw new NullPointerException("Null type");
            }
            this.f13230b = str;
            return this;
        }

        public b() {
        }

        public b(b0.e.d dVar) {
            this.f13229a = Long.valueOf(dVar.e());
            this.f13230b = dVar.f();
            this.f13231c = dVar.b();
            this.f13232d = dVar.c();
            this.f13233e = dVar.d();
        }
    }

    @Override // v2.b0.e.d
    public b0.e.d.a b() {
        return this.f13226c;
    }

    @Override // v2.b0.e.d
    public b0.e.d.c c() {
        return this.f13227d;
    }

    @Override // v2.b0.e.d
    public b0.e.d.AbstractC0147d d() {
        return this.f13228e;
    }

    @Override // v2.b0.e.d
    public long e() {
        return this.f13224a;
    }

    public boolean equals(Object obj) {
        b0.e.d.AbstractC0147d abstractC0147d;
        if (obj == this) {
            return true;
        }
        if (obj instanceof b0.e.d) {
            b0.e.d dVar = (b0.e.d) obj;
            if (this.f13224a == dVar.e() && this.f13225b.equals(dVar.f()) && this.f13226c.equals(dVar.b()) && this.f13227d.equals(dVar.c()) && ((abstractC0147d = this.f13228e) != null ? abstractC0147d.equals(dVar.d()) : dVar.d() == null)) {
                return true;
            }
        }
        return false;
    }

    @Override // v2.b0.e.d
    public String f() {
        return this.f13225b;
    }

    @Override // v2.b0.e.d
    public b0.e.d.b g() {
        return new b(this);
    }

    public int hashCode() {
        long j10 = this.f13224a;
        int iHashCode = (((((((((int) (j10 ^ (j10 >>> 32))) ^ 1000003) * 1000003) ^ this.f13225b.hashCode()) * 1000003) ^ this.f13226c.hashCode()) * 1000003) ^ this.f13227d.hashCode()) * 1000003;
        b0.e.d.AbstractC0147d abstractC0147d = this.f13228e;
        return (abstractC0147d == null ? 0 : abstractC0147d.hashCode()) ^ iHashCode;
    }

    public String toString() {
        return "Event{timestamp=" + this.f13224a + ", type=" + this.f13225b + ", app=" + this.f13226c + ", device=" + this.f13227d + ", log=" + this.f13228e + "}";
    }

    public l(long j10, String str, b0.e.d.a aVar, b0.e.d.c cVar, b0.e.d.AbstractC0147d abstractC0147d) {
        this.f13224a = j10;
        this.f13225b = str;
        this.f13226c = aVar;
        this.f13227d = cVar;
        this.f13228e = abstractC0147d;
    }
}
