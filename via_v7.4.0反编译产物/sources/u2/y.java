package u2;

import u2.d0;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class y extends d0.a {

    /* renamed from: a, reason: collision with root package name */
    public final String f12782a;

    /* renamed from: b, reason: collision with root package name */
    public final String f12783b;

    /* renamed from: c, reason: collision with root package name */
    public final String f12784c;

    /* renamed from: d, reason: collision with root package name */
    public final String f12785d;

    /* renamed from: e, reason: collision with root package name */
    public final int f12786e;

    /* renamed from: f, reason: collision with root package name */
    public final p2.e f12787f;

    public y(String str, String str2, String str3, String str4, int i10, p2.e eVar) {
        if (str == null) {
            throw new NullPointerException("Null appIdentifier");
        }
        this.f12782a = str;
        if (str2 == null) {
            throw new NullPointerException("Null versionCode");
        }
        this.f12783b = str2;
        if (str3 == null) {
            throw new NullPointerException("Null versionName");
        }
        this.f12784c = str3;
        if (str4 == null) {
            throw new NullPointerException("Null installUuid");
        }
        this.f12785d = str4;
        this.f12786e = i10;
        if (eVar == null) {
            throw new NullPointerException("Null developmentPlatformProvider");
        }
        this.f12787f = eVar;
    }

    @Override // u2.d0.a
    public String a() {
        return this.f12782a;
    }

    @Override // u2.d0.a
    public int c() {
        return this.f12786e;
    }

    @Override // u2.d0.a
    public p2.e d() {
        return this.f12787f;
    }

    @Override // u2.d0.a
    public String e() {
        return this.f12785d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof d0.a) {
            d0.a aVar = (d0.a) obj;
            if (this.f12782a.equals(aVar.a()) && this.f12783b.equals(aVar.f()) && this.f12784c.equals(aVar.g()) && this.f12785d.equals(aVar.e()) && this.f12786e == aVar.c() && this.f12787f.equals(aVar.d())) {
                return true;
            }
        }
        return false;
    }

    @Override // u2.d0.a
    public String f() {
        return this.f12783b;
    }

    @Override // u2.d0.a
    public String g() {
        return this.f12784c;
    }

    public int hashCode() {
        return ((((((((((this.f12782a.hashCode() ^ 1000003) * 1000003) ^ this.f12783b.hashCode()) * 1000003) ^ this.f12784c.hashCode()) * 1000003) ^ this.f12785d.hashCode()) * 1000003) ^ this.f12786e) * 1000003) ^ this.f12787f.hashCode();
    }

    public String toString() {
        return "AppData{appIdentifier=" + this.f12782a + ", versionCode=" + this.f12783b + ", versionName=" + this.f12784c + ", installUuid=" + this.f12785d + ", deliveryMechanism=" + this.f12786e + ", developmentPlatformProvider=" + this.f12787f + "}";
    }
}
