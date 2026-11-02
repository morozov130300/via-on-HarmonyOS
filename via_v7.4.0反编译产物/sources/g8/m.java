package g8;

import z8.u1;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class m {

    /* renamed from: a, reason: collision with root package name */
    public String f6288a;

    /* renamed from: b, reason: collision with root package name */
    public String f6289b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f6290c;

    public m(String str, String str2, boolean z10) {
        this.f6288a = str;
        this.f6289b = str2;
        this.f6290c = z10;
    }

    public String a() {
        return this.f6289b;
    }

    public String b() {
        return this.f6288a;
    }

    public boolean c() {
        return this.f6290c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            m mVar = (m) obj;
            if (this.f6290c == mVar.f6290c && u1.a(this.f6288a, mVar.f6288a) && u1.a(this.f6289b, mVar.f6289b)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return u1.b(this.f6288a, this.f6289b, Boolean.valueOf(this.f6290c));
    }
}
