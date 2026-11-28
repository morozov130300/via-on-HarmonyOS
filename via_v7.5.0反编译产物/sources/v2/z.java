package v2;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class z extends d0.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f13327a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f13328b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f13329c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f13330d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f13331e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f13332f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f13333g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f13334h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f13335i;

    public z(int i10, String str, int i11, long j10, long j11, boolean z10, int i12, String str2, String str3) {
        this.f13327a = i10;
        if (str == null) {
            throw new NullPointerException("Null model");
        }
        this.f13328b = str;
        this.f13329c = i11;
        this.f13330d = j10;
        this.f13331e = j11;
        this.f13332f = z10;
        this.f13333g = i12;
        if (str2 == null) {
            throw new NullPointerException("Null manufacturer");
        }
        this.f13334h = str2;
        if (str3 == null) {
            throw new NullPointerException("Null modelClass");
        }
        this.f13335i = str3;
    }

    @Override // v2.d0.b
    public int a() {
        return this.f13327a;
    }

    @Override // v2.d0.b
    public int b() {
        return this.f13329c;
    }

    @Override // v2.d0.b
    public long d() {
        return this.f13331e;
    }

    @Override // v2.d0.b
    public boolean e() {
        return this.f13332f;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof d0.b) {
            d0.b bVar = (d0.b) obj;
            if (this.f13327a == bVar.a() && this.f13328b.equals(bVar.g()) && this.f13329c == bVar.b() && this.f13330d == bVar.j() && this.f13331e == bVar.d() && this.f13332f == bVar.e() && this.f13333g == bVar.i() && this.f13334h.equals(bVar.f()) && this.f13335i.equals(bVar.h())) {
                return true;
            }
        }
        return false;
    }

    @Override // v2.d0.b
    public String f() {
        return this.f13334h;
    }

    @Override // v2.d0.b
    public String g() {
        return this.f13328b;
    }

    @Override // v2.d0.b
    public String h() {
        return this.f13335i;
    }

    public int hashCode() {
        int iHashCode = (((((this.f13327a ^ 1000003) * 1000003) ^ this.f13328b.hashCode()) * 1000003) ^ this.f13329c) * 1000003;
        long j10 = this.f13330d;
        int i10 = (iHashCode ^ ((int) (j10 ^ (j10 >>> 32)))) * 1000003;
        long j11 = this.f13331e;
        return ((((((((i10 ^ ((int) (j11 ^ (j11 >>> 32)))) * 1000003) ^ (this.f13332f ? 1231 : 1237)) * 1000003) ^ this.f13333g) * 1000003) ^ this.f13334h.hashCode()) * 1000003) ^ this.f13335i.hashCode();
    }

    @Override // v2.d0.b
    public int i() {
        return this.f13333g;
    }

    @Override // v2.d0.b
    public long j() {
        return this.f13330d;
    }

    public String toString() {
        return "DeviceData{arch=" + this.f13327a + ", model=" + this.f13328b + ", availableProcessors=" + this.f13329c + ", totalRam=" + this.f13330d + ", diskSpace=" + this.f13331e + ", isEmulator=" + this.f13332f + ", state=" + this.f13333g + ", manufacturer=" + this.f13334h + ", modelClass=" + this.f13335i + "}";
    }
}
