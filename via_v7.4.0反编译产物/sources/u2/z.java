package u2;

import u2.d0;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class z extends d0.b {

    /* renamed from: a, reason: collision with root package name */
    public final int f12788a;

    /* renamed from: b, reason: collision with root package name */
    public final String f12789b;

    /* renamed from: c, reason: collision with root package name */
    public final int f12790c;

    /* renamed from: d, reason: collision with root package name */
    public final long f12791d;

    /* renamed from: e, reason: collision with root package name */
    public final long f12792e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f12793f;

    /* renamed from: g, reason: collision with root package name */
    public final int f12794g;

    /* renamed from: h, reason: collision with root package name */
    public final String f12795h;

    /* renamed from: i, reason: collision with root package name */
    public final String f12796i;

    public z(int i10, String str, int i11, long j10, long j11, boolean z10, int i12, String str2, String str3) {
        this.f12788a = i10;
        if (str == null) {
            throw new NullPointerException("Null model");
        }
        this.f12789b = str;
        this.f12790c = i11;
        this.f12791d = j10;
        this.f12792e = j11;
        this.f12793f = z10;
        this.f12794g = i12;
        if (str2 == null) {
            throw new NullPointerException("Null manufacturer");
        }
        this.f12795h = str2;
        if (str3 == null) {
            throw new NullPointerException("Null modelClass");
        }
        this.f12796i = str3;
    }

    @Override // u2.d0.b
    public int a() {
        return this.f12788a;
    }

    @Override // u2.d0.b
    public int b() {
        return this.f12790c;
    }

    @Override // u2.d0.b
    public long d() {
        return this.f12792e;
    }

    @Override // u2.d0.b
    public boolean e() {
        return this.f12793f;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof d0.b) {
            d0.b bVar = (d0.b) obj;
            if (this.f12788a == bVar.a() && this.f12789b.equals(bVar.g()) && this.f12790c == bVar.b() && this.f12791d == bVar.j() && this.f12792e == bVar.d() && this.f12793f == bVar.e() && this.f12794g == bVar.i() && this.f12795h.equals(bVar.f()) && this.f12796i.equals(bVar.h())) {
                return true;
            }
        }
        return false;
    }

    @Override // u2.d0.b
    public String f() {
        return this.f12795h;
    }

    @Override // u2.d0.b
    public String g() {
        return this.f12789b;
    }

    @Override // u2.d0.b
    public String h() {
        return this.f12796i;
    }

    public int hashCode() {
        int iHashCode = (((((this.f12788a ^ 1000003) * 1000003) ^ this.f12789b.hashCode()) * 1000003) ^ this.f12790c) * 1000003;
        long j10 = this.f12791d;
        int i10 = (iHashCode ^ ((int) (j10 ^ (j10 >>> 32)))) * 1000003;
        long j11 = this.f12792e;
        return ((((((((i10 ^ ((int) (j11 ^ (j11 >>> 32)))) * 1000003) ^ (this.f12793f ? 1231 : 1237)) * 1000003) ^ this.f12794g) * 1000003) ^ this.f12795h.hashCode()) * 1000003) ^ this.f12796i.hashCode();
    }

    @Override // u2.d0.b
    public int i() {
        return this.f12794g;
    }

    @Override // u2.d0.b
    public long j() {
        return this.f12791d;
    }

    public String toString() {
        return "DeviceData{arch=" + this.f12788a + ", model=" + this.f12789b + ", availableProcessors=" + this.f12790c + ", totalRam=" + this.f12791d + ", diskSpace=" + this.f12792e + ", isEmulator=" + this.f12793f + ", state=" + this.f12794g + ", manufacturer=" + this.f12795h + ", modelClass=" + this.f12796i + "}";
    }
}
