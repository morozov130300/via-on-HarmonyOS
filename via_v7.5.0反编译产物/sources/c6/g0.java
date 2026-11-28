package c6;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2004a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f2005b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f2006c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f2007d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f2008e;

    public g0(String str, String str2, String str3, String str4, String str5) {
        this.f2004a = str;
        this.f2005b = str2;
        this.f2006c = str3;
        this.f2007d = str4;
        this.f2008e = str5;
    }

    public final String a() {
        return this.f2008e;
    }

    public final String b() {
        return this.f2007d;
    }

    public final String c() {
        return this.f2006c;
    }

    public final String d() {
        return this.f2005b;
    }

    public final String e() {
        return this.f2004a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g0)) {
            return false;
        }
        g0 g0Var = (g0) obj;
        return kotlin.jvm.internal.h.a(this.f2004a, g0Var.f2004a) && kotlin.jvm.internal.h.a(this.f2005b, g0Var.f2005b) && kotlin.jvm.internal.h.a(this.f2006c, g0Var.f2006c) && kotlin.jvm.internal.h.a(this.f2007d, g0Var.f2007d) && kotlin.jvm.internal.h.a(this.f2008e, g0Var.f2008e);
    }

    public int hashCode() {
        String str = this.f2004a;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.f2005b;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f2006c;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.f2007d;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.f2008e;
        return iHashCode4 + (str5 != null ? str5.hashCode() : 0);
    }

    public String toString() {
        return "HomepageFavorite(url=" + this.f2004a + ", title=" + this.f2005b + ", iconText=" + this.f2006c + ", iconPath=" + this.f2007d + ", iconColor=" + this.f2008e + ')';
    }
}
