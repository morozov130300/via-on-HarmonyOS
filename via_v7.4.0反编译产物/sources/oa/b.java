package oa;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public String f10492a;

    /* renamed from: b, reason: collision with root package name */
    public String f10493b;

    /* renamed from: c, reason: collision with root package name */
    public String f10494c;

    public b(String str, String str2, String str3) {
        this.f10492a = str;
        this.f10493b = str2;
        this.f10494c = str3;
    }

    public String a() {
        return this.f10492a;
    }

    public String b() {
        String str = this.f10493b;
        return (str == null || str.isEmpty()) ? this.f10494c : this.f10493b;
    }

    public void c(String str) {
        this.f10493b = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            String str = this.f10492a;
            String str2 = ((b) obj).f10492a;
            if (str != null) {
                return str.equals(str2);
            }
            if (str2 == null) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        String str = this.f10492a;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "TranslateLanguage{code='" + this.f10492a + "', name='" + this.f10493b + "', defaultName='" + this.f10494c + "'}";
    }
}
