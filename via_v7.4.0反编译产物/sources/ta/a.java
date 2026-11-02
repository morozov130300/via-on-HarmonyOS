package ta;

import z8.u1;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public String f12295a;

    /* renamed from: b, reason: collision with root package name */
    public String f12296b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f12297c;

    public a(String str, String str2, boolean z10) {
        this.f12295a = str;
        this.f12296b = str2;
        this.f12297c = z10;
    }

    public String a() {
        return this.f12296b;
    }

    public String b() {
        return this.f12295a;
    }

    public boolean c() {
        return this.f12297c;
    }

    public void d(boolean z10) {
        this.f12297c = z10;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            a aVar = (a) obj;
            if (this.f12297c == aVar.f12297c && u1.a(this.f12295a, aVar.f12295a) && u1.a(this.f12296b, aVar.f12296b)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return u1.b(this.f12295a, this.f12296b, Boolean.valueOf(this.f12297c));
    }
}
