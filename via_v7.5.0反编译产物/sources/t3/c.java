package t3;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f12483a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f12484b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f12485c;

    public c(byte[] bArr) {
        this.f12483a = bArr;
    }

    public int a() {
        return ((this.f12483a.length - this.f12484b) * 8) - this.f12485c;
    }

    public int b(int i10) {
        if (i10 < 1 || i10 > 32 || i10 > a()) {
            throw new IllegalArgumentException(String.valueOf(i10));
        }
        int i11 = this.f12485c;
        int i12 = 0;
        if (i11 > 0) {
            int i13 = 8 - i11;
            int iMin = Math.min(i10, i13);
            int i14 = i13 - iMin;
            byte[] bArr = this.f12483a;
            int i15 = this.f12484b;
            int i16 = (((255 >> (8 - iMin)) << i14) & bArr[i15]) >> i14;
            i10 -= iMin;
            int i17 = this.f12485c + iMin;
            this.f12485c = i17;
            if (i17 == 8) {
                this.f12485c = 0;
                this.f12484b = i15 + 1;
            }
            i12 = i16;
        }
        if (i10 > 0) {
            while (i10 >= 8) {
                int i18 = i12 << 8;
                byte[] bArr2 = this.f12483a;
                int i19 = this.f12484b;
                i12 = (bArr2[i19] & 255) | i18;
                this.f12484b = i19 + 1;
                i10 -= 8;
            }
            if (i10 > 0) {
                int i20 = 8 - i10;
                int i21 = ((((255 >> i20) << i20) & this.f12483a[this.f12484b]) >> i20) | (i12 << i10);
                this.f12485c += i10;
                return i21;
            }
        }
        return i12;
    }
}
