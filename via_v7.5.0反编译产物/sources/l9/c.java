package l9;

import c6.a2;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f7521a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f7522b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int[] f7523c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f7524d = 0;

    public c(String str, boolean z10, boolean z11) {
        g(str);
        f(z10);
        if (z11) {
            this.f7522b |= 2;
        }
    }

    public long a() {
        return this.f7524d;
    }

    public String b() {
        int i10;
        int i11;
        int[] iArr = this.f7523c;
        return (iArr == null || iArr.length < 2 || (i10 = iArr[1]) < (i11 = iArr[0]) || i11 < 0) ? "" : this.f7521a.substring(i11, i10).toLowerCase(Locale.ROOT);
    }

    public String c() {
        return this.f7521a;
    }

    public boolean d() {
        return (this.f7522b & 1) == 1;
    }

    public boolean e() {
        return (this.f7522b & 2) == 2;
    }

    public final void f(boolean z10) {
        this.f7522b = (z10 ? 1 : 0) | this.f7522b;
    }

    public void g(String str) {
        this.f7521a = str;
        a2 a2Var = a2.f1958a;
        this.f7523c = a2Var.e(str);
        this.f7524d = System.currentTimeMillis();
        this.f7522b |= a2Var.s(b()) ? 2 : 0;
    }
}
