package zb;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f15695a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int[] f15696b = new int[10];

    public void a() {
        this.f15695a = 0;
        Arrays.fill(this.f15696b, 0);
    }

    public int b(int i10) {
        return this.f15696b[i10];
    }

    public int c() {
        if ((this.f15695a & 2) != 0) {
            return this.f15696b[1];
        }
        return -1;
    }

    public int d() {
        if ((this.f15695a & 128) != 0) {
            return this.f15696b[7];
        }
        return 65535;
    }

    public int e(int i10) {
        return (this.f15695a & 16) != 0 ? this.f15696b[4] : i10;
    }

    public int f(int i10) {
        return (this.f15695a & 32) != 0 ? this.f15696b[5] : i10;
    }

    public boolean g(int i10) {
        return ((1 << i10) & this.f15695a) != 0;
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
            int[] iArr = this.f15696b;
            if (i10 < iArr.length) {
                this.f15695a = (1 << i10) | this.f15695a;
                iArr[i10] = i11;
            }
        }
        return this;
    }

    public int j() {
        return Integer.bitCount(this.f15695a);
    }
}
