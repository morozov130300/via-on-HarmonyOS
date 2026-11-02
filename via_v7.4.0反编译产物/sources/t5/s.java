package t5;

import android.graphics.Rect;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class s {

    /* renamed from: a, reason: collision with root package name */
    public byte[] f12239a;

    /* renamed from: b, reason: collision with root package name */
    public int f12240b;

    /* renamed from: c, reason: collision with root package name */
    public int f12241c;

    public s(byte[] bArr, int i10, int i11) {
        this.f12239a = bArr;
        this.f12240b = i10;
        this.f12241c = i11;
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
            int i12 = (i11 * this.f12240b) + rect.left;
            for (int i13 = 0; i13 < iHeight; i13++) {
                System.arraycopy(this.f12239a, i12, bArr, i13 * iWidth, iWidth);
                i12 += this.f12240b;
            }
        } else {
            int i14 = (i11 * this.f12240b) + rect.left;
            for (int i15 = 0; i15 < iHeight; i15++) {
                int i16 = i15 * iWidth;
                int i17 = i14;
                for (int i18 = 0; i18 < iWidth; i18++) {
                    bArr[i16] = this.f12239a[i17];
                    i17 += i10;
                    i16++;
                }
                i14 += this.f12240b * i10;
            }
        }
        return new s(bArr, iWidth, iHeight);
    }

    public byte[] b() {
        return this.f12239a;
    }

    public int c() {
        return this.f12241c;
    }

    public int d() {
        return this.f12240b;
    }

    public s h(int i10) {
        return i10 != 90 ? i10 != 180 ? i10 != 270 ? this : new s(f(this.f12239a, this.f12240b, this.f12241c), this.f12241c, this.f12240b) : new s(e(this.f12239a, this.f12240b, this.f12241c), this.f12240b, this.f12241c) : new s(g(this.f12239a, this.f12240b, this.f12241c), this.f12241c, this.f12240b);
    }
}
