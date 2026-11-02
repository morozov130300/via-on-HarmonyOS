package ta;

import z8.u1;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class d0 {

    /* renamed from: a, reason: collision with root package name */
    public String f12315a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f12316b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f12317c;

    public d0(String str, boolean z10, boolean z11) {
        this.f12315a = str;
        this.f12316b = z10;
        this.f12317c = z11;
    }

    public String a() {
        return this.f12315a;
    }

    public boolean b() {
        return this.f12317c;
    }

    public boolean c() {
        return this.f12316b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            d0 d0Var = (d0) obj;
            if (this.f12316b == d0Var.f12316b && this.f12317c == d0Var.f12317c && u1.a(this.f12315a, d0Var.f12315a)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return u1.b(this.f12315a, Boolean.valueOf(this.f12316b), Boolean.valueOf(this.f12317c));
    }
}
