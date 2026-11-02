package n9;

import i6.i0;
import java.util.Locale;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public String f10267a;

    /* renamed from: b, reason: collision with root package name */
    public int f10268b = 0;

    /* renamed from: c, reason: collision with root package name */
    public int[] f10269c = null;

    /* renamed from: d, reason: collision with root package name */
    public long f10270d = 0;

    public c(String str, boolean z10, boolean z11) {
        g(str);
        f(z10);
        if (z11) {
            this.f10268b |= 2;
        }
    }

    public long a() {
        return this.f10270d;
    }

    public String b() {
        int i10;
        int i11;
        int[] iArr = this.f10269c;
        return (iArr == null || iArr.length < 2 || (i10 = iArr[1]) < (i11 = iArr[0]) || i11 < 0) ? "" : this.f10267a.substring(i11, i10).toLowerCase(Locale.ROOT);
    }

    public String c() {
        return this.f10267a;
    }

    public boolean d() {
        return (this.f10268b & 1) == 1;
    }

    public boolean e() {
        return (this.f10268b & 2) == 2;
    }

    public final void f(boolean z10) {
        this.f10268b = (z10 ? 1 : 0) | this.f10268b;
    }

    public void g(String str) {
        this.f10267a = str;
        i0 i0Var = i0.f7006a;
        this.f10269c = i0Var.d(str);
        this.f10270d = System.currentTimeMillis();
        this.f10268b |= i0Var.r(b()) ? 2 : 0;
    }
}
