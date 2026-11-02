package zb;

import java.util.Arrays;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    public int f14960a;

    /* renamed from: b, reason: collision with root package name */
    public final int[] f14961b = new int[10];

    public void a() {
        this.f14960a = 0;
        Arrays.fill(this.f14961b, 0);
    }

    public int b(int i10) {
        return this.f14961b[i10];
    }

    public int c() {
        if ((this.f14960a & 2) != 0) {
            return this.f14961b[1];
        }
        return -1;
    }

    public int d() {
        if ((this.f14960a & 128) != 0) {
            return this.f14961b[7];
        }
        return 65535;
    }

    public int e(int i10) {
        return (this.f14960a & 16) != 0 ? this.f14961b[4] : i10;
    }

    public int f(int i10) {
        return (this.f14960a & 32) != 0 ? this.f14961b[5] : i10;
    }

    public boolean g(int i10) {
        return ((1 << i10) & this.f14960a) != 0;
    }

    public void h(k kVar) {
        for (int i10 = 0; i10 < 10; i10++) {
            if (kVar.g(i10)) {
                i(i10, kVar.b(i10));
            }
        }
    }

    public k i(int i10, int i11) {
        if (i10 >= 0) {
            int[] iArr = this.f14961b;
            if (i10 < iArr.length) {
                this.f14960a = (1 << i10) | this.f14960a;
                iArr[i10] = i11;
            }
        }
        return this;
    }

    public int j() {
        return Integer.bitCount(this.f14960a);
    }
}
