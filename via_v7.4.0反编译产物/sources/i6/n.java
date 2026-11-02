package i6;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    public final String f7038a;

    /* renamed from: b, reason: collision with root package name */
    public final String f7039b;

    /* renamed from: c, reason: collision with root package name */
    public final String f7040c;

    /* renamed from: d, reason: collision with root package name */
    public final String f7041d;

    /* renamed from: e, reason: collision with root package name */
    public final String f7042e;

    public n(String str, String str2, String str3, String str4, String str5) {
        this.f7038a = str;
        this.f7039b = str2;
        this.f7040c = str3;
        this.f7041d = str4;
        this.f7042e = str5;
    }

    public final String a() {
        return this.f7042e;
    }

    public final String b() {
        return this.f7041d;
    }

    public final String c() {
        return this.f7040c;
    }

    public final String d() {
        return this.f7039b;
    }

    public final String e() {
        return this.f7038a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof n)) {
            return false;
        }
        n nVar = (n) obj;
        return kotlin.jvm.internal.h.a(this.f7038a, nVar.f7038a) && kotlin.jvm.internal.h.a(this.f7039b, nVar.f7039b) && kotlin.jvm.internal.h.a(this.f7040c, nVar.f7040c) && kotlin.jvm.internal.h.a(this.f7041d, nVar.f7041d) && kotlin.jvm.internal.h.a(this.f7042e, nVar.f7042e);
    }

    public int hashCode() {
        String str = this.f7038a;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.f7039b;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f7040c;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.f7041d;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.f7042e;
        return iHashCode4 + (str5 != null ? str5.hashCode() : 0);
    }

    public String toString() {
        return "HomepageFavorite(url=" + this.f7038a + ", title=" + this.f7039b + ", iconText=" + this.f7040c + ", iconPath=" + this.f7041d + ", iconColor=" + this.f7042e + ')';
    }
}
