package w9;

import z8.u1;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public int f13356a;

    public b(int i10) {
        this.f13356a = i10;
    }

    public int a() {
        return this.f13356a;
    }

    public boolean b(int i10) {
        return (this.f13356a & i10) == i10;
    }

    public void c(int i10, boolean z10) {
        if (z10) {
            this.f13356a = i10 | this.f13356a;
        } else {
            this.f13356a = (i10 ^ (-1)) & this.f13356a;
        }
    }

    public void d(int i10) {
        this.f13356a = i10;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.f13356a == ((b) obj).f13356a;
    }

    public int hashCode() {
        return u1.b(Integer.valueOf(this.f13356a));
    }
}
