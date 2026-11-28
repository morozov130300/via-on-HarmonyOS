package n5;

import android.graphics.Rect;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f10668a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f10669b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f10670c;

    public s(byte[] bArr, int i10, int i11) {
        this.f10668a = bArr;
        this.f10669b = i10;
        this.f10670c = i11;
    }

    public static byte[] e(byte[] bArr, int i10, int i11) {
        int i12 = i10 * i11;
        byte[] bArr2 = new byte[i12];
        int i13 = i12 - 1;
        for (int i14 = 0; i14 < i12; i14++) {
            bArr2[i13] = bArr[i14];
            i13--;
        }
        return bArr2;
    }

    public static byte[] f(byte[] bArr, int i10, int i11) {
        int i12 = i10 * i11;
        byte[] bArr2 = new byte[i12];
        int i13 = i12 - 1;
        for (int i14 = 0; i14 < i10; i14++) {
            for (int i15 = i11 - 1; i15 >= 0; i15--) {
                bArr2[i13] = bArr[(i15 * i10) + i14];
                i13--;
            }
        }
        return bArr2;
    }

    public static byte[] g(byte[] bArr, int i10, int i11) {
        byte[] bArr2 = new byte[i10 * i11];
        int i12 = 0;
        for (int i13 = 0; i13 < i10; i13++) {
            for (int i14 = i11 - 1; i14 >= 0; i14--) {
                bArr2[i12] = bArr[(i14 * i10) + i13];
                i12++;
            }
        }
        return bArr2;
    }

    public s a(Rect rect, int i10) {
        int iWidth = rect.width() / i10;
        int iHeight = rect.height() / i10;
        int i11 = rect.top;
        byte[] bArr = new byte[iWidth * iHeight];
        if (i10 == 1) {
            int i12 = (i11 * this.f10669b) + rect.left;
            for (int i13 = 0; i13 < iHeight; i13++) {
                System.arraycopy(this.f10668a, i12, bArr, i13 * iWidth, iWidth);
                i12 += this.f10669b;
            }
        } else {
            int i14 = (i11 * this.f10669b) + rect.left;
            for (int i15 = 0; i15 < iHeight; i15++) {
                int i16 = i15 * iWidth;
                int i17 = i14;
                for (int i18 = 0; i18 < iWidth; i18++) {
                    bArr[i16] = this.f10668a[i17];
                    i17 += i10;
                    i16++;
                }
                i14 += this.f10669b * i10;
            }
        }
        return new s(bArr, iWidth, iHeight);
    }

    public byte[] b() {
        return this.f10668a;
    }

    public int c() {
        return this.f10670c;
    }

    public int d() {
        return this.f10669b;
    }

    public s h(int i10) {
        if (i10 == 90) {
            return new s(g(this.f10668a, this.f10669b, this.f10670c), this.f10670c, this.f10669b);
        }
        if (i10 != 180) {
            return i10 != 270 ? this : new s(f(this.f10668a, this.f10669b, this.f10670c), this.f10670c, this.f10669b);
        }
        return new s(e(this.f10668a, this.f10669b, this.f10670c), this.f10669b, this.f10670c);
    }
}
