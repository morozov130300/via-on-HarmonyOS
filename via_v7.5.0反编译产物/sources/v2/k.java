package v2;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class k extends b0.e.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f13206a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f13207b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f13208c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f13209d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f13210e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f13211f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f13212g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f13213h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f13214i;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class b extends b0.e.c.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Integer f13215a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f13216b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Integer f13217c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Long f13218d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Long f13219e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Boolean f13220f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public Integer f13221g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public String f13222h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public String f13223i;

        @Override // v2.b0.e.c.a
        public b0.e.c a() {
            String str = "";
            if (this.f13215a == null) {
                str = " arch";
            }
            if (this.f13216b == null) {
                str = str + " model";
            }
            if (this.f13217c == null) {
                str = str + " cores";
            }
            if (this.f13218d == null) {
                str = str + " ram";
            }
            if (this.f13219e == null) {
                str = str + " diskSpace";
            }
            if (this.f13220f == null) {
                str = str + " simulator";
            }
            if (this.f13221g == null) {
                str = str + " state";
            }
            if (this.f13222h == null) {
                str = str + " manufacturer";
            }
            if (this.f13223i == null) {
                str = str + " modelClass";
            }
            if (str.isEmpty()) {
                return new k(this.f13215a.intValue(), this.f13216b, this.f13217c.intValue(), this.f13218d.longValue(), this.f13219e.longValue(), this.f13220f.booleanValue(), this.f13221g.intValue(), this.f13222h, this.f13223i);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // v2.b0.e.c.a
        public b0.e.c.a b(int i10) {
            this.f13215a = Integer.valueOf(i10);
            return this;
        }

        @Override // v2.b0.e.c.a
        public b0.e.c.a c(int i10) {
            this.f13217c = Integer.valueOf(i10);
            return this;
        }

        @Override // v2.b0.e.c.a
        public b0.e.c.a d(long j10) {
            this.f13219e = Long.valueOf(j10);
            return this;
        }

        @Override // v2.b0.e.c.a
        public b0.e.c.a e(String str) {
            if (str == null) {
                throw new NullPointerException("Null manufacturer");
            }
            this.f13222h = str;
            return this;
        }

        @Override // v2.b0.e.c.a
        public b0.e.c.a f(String str) {
            if (str == null) {
                throw new NullPointerException("Null model");
            }
            this.f13216b = str;
            return this;
        }

        @Override // v2.b0.e.c.a
        public b0.e.c.a g(String str) {
            if (str == null) {
                throw new NullPointerException("Null modelClass");
            }
            this.f13223i = str;
            return this;
        }

        @Override // v2.b0.e.c.a
        public b0.e.c.a h(long j10) {
            this.f13218d = Long.valueOf(j10);
            return this;
        }

        @Override // v2.b0.e.c.a
        public b0.e.c.a i(boolean z10) {
            this.f13220f = Boolean.valueOf(z10);
            return this;
        }

        @Override // v2.b0.e.c.a
        public b0.e.c.a j(int i10) {
            this.f13221g = Integer.valueOf(i10);
            return this;
        }
    }

    @Override // v2.b0.e.c
    public int b() {
        return this.f13206a;
    }

    @Override // v2.b0.e.c
    public int c() {
        return this.f13208c;
    }

    @Override // v2.b0.e.c
    public long d() {
        return this.f13210e;
    }

    @Override // v2.b0.e.c
    public String e() {
        return this.f13213h;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof b0.e.c) {
            b0.e.c cVar = (b0.e.c) obj;
            if (this.f13206a == cVar.b() && this.f13207b.equals(cVar.f()) && this.f13208c == cVar.c() && this.f13209d == cVar.h() && this.f13210e == cVar.d() && this.f13211f == cVar.j() && this.f13212g == cVar.i() && this.f13213h.equals(cVar.e()) && this.f13214i.equals(cVar.g())) {
                return true;
            }
        }
        return false;
    }

    @Override // v2.b0.e.c
    public String f() {
        return this.f13207b;
    }

    @Override // v2.b0.e.c
    public String g() {
        return this.f13214i;
    }

    @Override // v2.b0.e.c
    public long h() {
        return this.f13209d;
    }

    public int hashCode() {
        int iHashCode = (((((this.f13206a ^ 1000003) * 1000003) ^ this.f13207b.hashCode()) * 1000003) ^ this.f13208c) * 1000003;
        long j10 = this.f13209d;
        int i10 = (iHashCode ^ ((int) (j10 ^ (j10 >>> 32)))) * 1000003;
        long j11 = this.f13210e;
        return ((((((((i10 ^ ((int) (j11 ^ (j11 >>> 32)))) * 1000003) ^ (this.f13211f ? 1231 : 1237)) * 1000003) ^ this.f13212g) * 1000003) ^ this.f13213h.hashCode()) * 1000003) ^ this.f13214i.hashCode();
    }

    @Override // v2.b0.e.c
    public int i() {
        return this.f13212g;
    }

    @Override // v2.b0.e.c
    public boolean j() {
        return this.f13211f;
    }

    public String toString() {
        return "Device{arch=" + this.f13206a + ", model=" + this.f13207b + ", cores=" + this.f13208c + ", ram=" + this.f13209d + ", diskSpace=" + this.f13210e + ", simulator=" + this.f13211f + ", state=" + this.f13212g + ", manufacturer=" + this.f13213h + ", modelClass=" + this.f13214i + "}";
    }

    public k(int i10, String str, int i11, long j10, long j11, boolean z10, int i12, String str2, String str3) {
        this.f13206a = i10;
        this.f13207b = str;
        this.f13208c = i11;
        this.f13209d = j10;
        this.f13210e = j11;
        this.f13211f = z10;
        this.f13212g = i12;
        this.f13213h = str2;
        this.f13214i = str3;
    }
}
