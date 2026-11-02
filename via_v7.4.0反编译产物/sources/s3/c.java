package s3;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f11815a;

    /* renamed from: b, reason: collision with root package name */
    public int f11816b;

    /* renamed from: c, reason: collision with root package name */
    public int f11817c;

    public c(byte[] bArr) {
        this.f11815a = bArr;
    }

    public int a() {
        return ((this.f11815a.length - this.f11816b) * 8) - this.f11817c;
    }

    public int b(int i10) {
        if (i10 < 1 || i10 > 32 || i10 > a()) {
            throw new IllegalArgumentException(String.valueOf(i10));
        }
        int i11 = this.f11817c;
        int i12 = 0;
        if (i11 > 0) {
            int i13 = 8 - i11;
            int iMin = Math.min(i10, i13);
            int i14 = i13 - iMin;
            byte[] bArr = this.f11815a;
            int i15 = this.f11816b;
            int i16 = (((255 >> (8 - iMin)) << i14) & bArr[i15]) >> i14;
            i10 -= iMin;
            int i17 = this.f11817c + iMin;
            this.f11817c = i17;
            if (i17 == 8) {
                this.f11817c = 0;
                this.f11816b = i15 + 1;
            }
            i12 = i16;
        }
        if (i10 > 0) {
            while (i10 >= 8) {
                int i18 = i12 << 8;
                byte[] bArr2 = this.f11815a;
                int i19 = this.f11816b;
                i12 = (bArr2[i19] & 255) | i18;
                this.f11816b = i19 + 1;
                i10 -= 8;
            }
            if (i10 > 0) {
                int i20 = 8 - i10;
                int i21 = ((((255 >> i20) << i20) & this.f11815a[this.f11816b]) >> i20) | (i12 << i10);
                this.f11817c += i10;
                return i21;
            }
        }
        return i12;
    }
}
