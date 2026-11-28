package d4;

import java.lang.reflect.Array;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[][] f3905a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f3906b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f3907c;

    public b(int i10, int i11) {
        this.f3905a = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, i11, i10);
        this.f3906b = i10;
        this.f3907c = i11;
    }

    public void a(byte b10) {
        for (byte[] bArr : this.f3905a) {
            Arrays.fill(bArr, b10);
        }
    }

    public byte b(int i10, int i11) {
        return this.f3905a[i11][i10];
    }

    public byte[][] c() {
        return this.f3905a;
    }

    public int d() {
        return this.f3907c;
    }

    public int e() {
        return this.f3906b;
    }

    public void f(int i10, int i11, int i12) {
        this.f3905a[i11][i10] = (byte) i12;
    }

    public void g(int i10, int i11, boolean z10) {
        this.f3905a[i11][i10] = z10 ? (byte) 1 : (byte) 0;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder((this.f3906b * 2 * this.f3907c) + 2);
        for (int i10 = 0; i10 < this.f3907c; i10++) {
            byte[] bArr = this.f3905a[i10];
            for (int i11 = 0; i11 < this.f3906b; i11++) {
                byte b10 = bArr[i11];
                if (b10 == 0) {
                    sb2.append(" 0");
                } else if (b10 != 1) {
                    sb2.append("  ");
                } else {
                    sb2.append(" 1");
                }
            }
            sb2.append('\n');
        }
        return sb2.toString();
    }
}
