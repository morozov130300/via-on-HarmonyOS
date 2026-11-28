package t3;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class b implements Cloneable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f12479c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f12480e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f12481m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int[] f12482n;

    public b(int i10) {
        this(i10, i10);
    }

    public final String a(String str, String str2, String str3) {
        StringBuilder sb2 = new StringBuilder(this.f12480e * (this.f12479c + 1));
        for (int i10 = 0; i10 < this.f12480e; i10++) {
            for (int i11 = 0; i11 < this.f12479c; i11++) {
                sb2.append(i(i11, i10) ? str : str2);
            }
            sb2.append(str3);
        }
        return sb2.toString();
    }

    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public b clone() {
        return new b(this.f12479c, this.f12480e, this.f12481m, (int[]) this.f12482n.clone());
    }

    public void d() {
        int length = this.f12482n.length;
        for (int i10 = 0; i10 < length; i10++) {
            int[] iArr = this.f12482n;
            iArr[i10] = iArr[i10] ^ (-1);
        }
    }

    public void e(int i10, int i11) {
        int i12 = (i11 * this.f12481m) + (i10 / 32);
        int[] iArr = this.f12482n;
        iArr[i12] = (1 << (i10 & 31)) ^ iArr[i12];
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f12479c == bVar.f12479c && this.f12480e == bVar.f12480e && this.f12481m == bVar.f12481m && Arrays.equals(this.f12482n, bVar.f12482n);
    }

    public int hashCode() {
        int i10 = this.f12479c;
        return (((((((i10 * 31) + i10) * 31) + this.f12480e) * 31) + this.f12481m) * 31) + Arrays.hashCode(this.f12482n);
    }

    public boolean i(int i10, int i11) {
        return ((this.f12482n[(i11 * this.f12481m) + (i10 / 32)] >>> (i10 & 31)) & 1) != 0;
    }

    public int[] j() {
        int length = this.f12482n.length - 1;
        while (length >= 0 && this.f12482n[length] == 0) {
            length--;
        }
        if (length < 0) {
            return null;
        }
        int i10 = this.f12481m;
        int i11 = length / i10;
        int i12 = (length % i10) * 32;
        int i13 = 31;
        while ((this.f12482n[length] >>> i13) == 0) {
            i13--;
        }
        return new int[]{i12 + i13, i11};
    }

    public int k() {
        return this.f12480e;
    }

    public int[] l() {
        int[] iArr;
        int i10 = 0;
        int i11 = 0;
        while (true) {
            iArr = this.f12482n;
            if (i11 >= iArr.length || iArr[i11] != 0) {
                break;
            }
            i11++;
        }
        if (i11 == iArr.length) {
            return null;
        }
        int i12 = this.f12481m;
        int i13 = i11 / i12;
        int i14 = (i11 % i12) * 32;
        while ((iArr[i11] << (31 - i10)) == 0) {
            i10++;
        }
        return new int[]{i14 + i10, i13};
    }

    public int m() {
        return this.f12479c;
    }

    public void n(int i10, int i11) {
        int i12 = (i11 * this.f12481m) + (i10 / 32);
        int[] iArr = this.f12482n;
        iArr[i12] = (1 << (i10 & 31)) | iArr[i12];
    }

    public void o(int i10, int i11, int i12, int i13) {
        if (i11 < 0 || i10 < 0) {
            throw new IllegalArgumentException("Left and top must be nonnegative");
        }
        if (i13 < 1 || i12 < 1) {
            throw new IllegalArgumentException("Height and width must be at least 1");
        }
        int i14 = i12 + i10;
        int i15 = i13 + i11;
        if (i15 > this.f12480e || i14 > this.f12479c) {
            throw new IllegalArgumentException("The region must fit inside the matrix");
        }
        while (i11 < i15) {
            int i16 = this.f12481m * i11;
            for (int i17 = i10; i17 < i14; i17++) {
                int[] iArr = this.f12482n;
                int i18 = (i17 / 32) + i16;
                iArr[i18] = iArr[i18] | (1 << (i17 & 31));
            }
            i11++;
        }
    }

    public String p(String str, String str2) {
        return a(str, str2, "\n");
    }

    public String toString() {
        return p("X ", "  ");
    }

    public b(int i10, int i11) {
        if (i10 < 1 || i11 < 1) {
            throw new IllegalArgumentException("Both dimensions must be greater than 0");
        }
        this.f12479c = i10;
        this.f12480e = i11;
        int i12 = (i10 + 31) / 32;
        this.f12481m = i12;
        this.f12482n = new int[i12 * i11];
    }

    public b(int i10, int i11, int i12, int[] iArr) {
        this.f12479c = i10;
        this.f12480e = i11;
        this.f12481m = i12;
        this.f12482n = iArr;
    }
}
