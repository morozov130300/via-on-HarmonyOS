package t3;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class a implements Cloneable {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int[] f12476m = new int[0];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int[] f12477c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f12478e;

    public a() {
        this.f12478e = 0;
        this.f12477c = f12476m;
    }

    public static int[] q(int i10) {
        return new int[(i10 + 31) / 32];
    }

    public void a(boolean z10) {
        j(this.f12478e + 1);
        if (z10) {
            int[] iArr = this.f12477c;
            int i10 = this.f12478e;
            int i11 = i10 / 32;
            iArr[i11] = (1 << (i10 & 31)) | iArr[i11];
        }
        this.f12478e++;
    }

    public void b(a aVar) {
        int i10 = aVar.f12478e;
        j(this.f12478e + i10);
        for (int i11 = 0; i11 < i10; i11++) {
            a(aVar.k(i11));
        }
    }

    public void d(int i10, int i11) {
        if (i11 < 0 || i11 > 32) {
            throw new IllegalArgumentException("Num bits must be between 0 and 32");
        }
        int i12 = this.f12478e;
        j(i12 + i11);
        for (int i13 = i11 - 1; i13 >= 0; i13--) {
            if (((1 << i13) & i10) != 0) {
                int[] iArr = this.f12477c;
                int i14 = i12 / 32;
                iArr[i14] = iArr[i14] | (1 << (i12 & 31));
            }
            i12++;
        }
        this.f12478e = i12;
    }

    public void e() {
        int length = this.f12477c.length;
        for (int i10 = 0; i10 < length; i10++) {
            this.f12477c[i10] = 0;
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f12478e == aVar.f12478e && Arrays.equals(this.f12477c, aVar.f12477c);
    }

    public int hashCode() {
        return (this.f12478e * 31) + Arrays.hashCode(this.f12477c);
    }

    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public a clone() {
        return new a((int[]) this.f12477c.clone(), this.f12478e);
    }

    public final void j(int i10) {
        if (i10 > this.f12477c.length * 32) {
            int[] iArrQ = q((int) Math.ceil(i10 / 0.75f));
            int[] iArr = this.f12477c;
            System.arraycopy(iArr, 0, iArrQ, 0, iArr.length);
            this.f12477c = iArrQ;
        }
    }

    public boolean k(int i10) {
        return ((1 << (i10 & 31)) & this.f12477c[i10 / 32]) != 0;
    }

    public int l(int i10) {
        int i11 = this.f12478e;
        if (i10 >= i11) {
            return i11;
        }
        int i12 = i10 / 32;
        int i13 = (-(1 << (i10 & 31))) & this.f12477c[i12];
        while (i13 == 0) {
            i12++;
            int[] iArr = this.f12477c;
            if (i12 == iArr.length) {
                return this.f12478e;
            }
            i13 = iArr[i12];
        }
        return Math.min((i12 * 32) + Integer.numberOfTrailingZeros(i13), this.f12478e);
    }

    public int m(int i10) {
        int i11 = this.f12478e;
        if (i10 >= i11) {
            return i11;
        }
        int i12 = i10 / 32;
        int i13 = (-(1 << (i10 & 31))) & (this.f12477c[i12] ^ (-1));
        while (i13 == 0) {
            i12++;
            int[] iArr = this.f12477c;
            if (i12 == iArr.length) {
                return this.f12478e;
            }
            i13 = iArr[i12] ^ (-1);
        }
        return Math.min((i12 * 32) + Integer.numberOfTrailingZeros(i13), this.f12478e);
    }

    public int n() {
        return this.f12478e;
    }

    public int o() {
        return (this.f12478e + 7) / 8;
    }

    public boolean p(int i10, int i11, boolean z10) {
        if (i11 < i10 || i10 < 0 || i11 > this.f12478e) {
            throw new IllegalArgumentException();
        }
        if (i11 == i10) {
            return true;
        }
        int i12 = i11 - 1;
        int i13 = i10 / 32;
        int i14 = i12 / 32;
        int i15 = i13;
        while (i15 <= i14) {
            int i16 = (2 << (i15 >= i14 ? 31 & i12 : 31)) - (1 << (i15 > i13 ? 0 : i10 & 31));
            int i17 = this.f12477c[i15] & i16;
            if (!z10) {
                i16 = 0;
            }
            if (i17 != i16) {
                return false;
            }
            i15++;
        }
        return true;
    }

    public void r() {
        int[] iArr = new int[this.f12477c.length];
        int i10 = (this.f12478e - 1) / 32;
        int i11 = i10 + 1;
        for (int i12 = 0; i12 < i11; i12++) {
            iArr[i10 - i12] = Integer.reverse(this.f12477c[i12]);
        }
        int i13 = this.f12478e;
        int i14 = i11 * 32;
        if (i13 != i14) {
            int i15 = i14 - i13;
            int i16 = iArr[0] >>> i15;
            for (int i17 = 1; i17 < i11; i17++) {
                int i18 = iArr[i17];
                iArr[i17 - 1] = i16 | (i18 << (32 - i15));
                i16 = i18 >>> i15;
            }
            iArr[i10] = i16;
        }
        this.f12477c = iArr;
    }

    public void s(int i10) {
        int[] iArr = this.f12477c;
        int i11 = i10 / 32;
        iArr[i11] = (1 << (i10 & 31)) | iArr[i11];
    }

    public void t(int i10, byte[] bArr, int i11, int i12) {
        for (int i13 = 0; i13 < i12; i13++) {
            int i14 = 0;
            for (int i15 = 0; i15 < 8; i15++) {
                if (k(i10)) {
                    i14 |= 1 << (7 - i15);
                }
                i10++;
            }
            bArr[i11 + i13] = (byte) i14;
        }
    }

    public String toString() {
        int i10 = this.f12478e;
        StringBuilder sb2 = new StringBuilder(i10 + (i10 / 8) + 1);
        for (int i11 = 0; i11 < this.f12478e; i11++) {
            if ((i11 & 7) == 0) {
                sb2.append(' ');
            }
            sb2.append(k(i11) ? 'X' : '.');
        }
        return sb2.toString();
    }

    public void u(a aVar) {
        if (this.f12478e != aVar.f12478e) {
            throw new IllegalArgumentException("Sizes don't match");
        }
        int i10 = 0;
        while (true) {
            int[] iArr = this.f12477c;
            if (i10 >= iArr.length) {
                return;
            }
            iArr[i10] = iArr[i10] ^ aVar.f12477c[i10];
            i10++;
        }
    }

    public a(int i10) {
        this.f12478e = i10;
        this.f12477c = q(i10);
    }

    public a(int[] iArr, int i10) {
        this.f12477c = iArr;
        this.f12478e = i10;
    }
}
