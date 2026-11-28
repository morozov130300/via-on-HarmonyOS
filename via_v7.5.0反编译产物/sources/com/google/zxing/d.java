package com.google.zxing;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f3416a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f3417b;

    public d(int i10, int i11) {
        this.f3416a = i10;
        this.f3417b = i11;
    }

    public final int a() {
        return this.f3417b;
    }

    public abstract byte[] b();

    public abstract byte[] c(int i10, byte[] bArr);

    public final int d() {
        return this.f3416a;
    }

    public d e() {
        return new c(this);
    }

    public boolean f() {
        return false;
    }

    public d g() {
        throw new UnsupportedOperationException("This luminance source does not support rotation by 90 degrees.");
    }

    public final String toString() {
        char c10;
        int i10 = this.f3416a;
        byte[] bArrC = new byte[i10];
        StringBuilder sb2 = new StringBuilder(this.f3417b * (i10 + 1));
        for (int i11 = 0; i11 < this.f3417b; i11++) {
            bArrC = c(i11, bArrC);
            for (int i12 = 0; i12 < this.f3416a; i12++) {
                int i13 = bArrC[i12] & 255;
                if (i13 < 64) {
                    c10 = '#';
                } else if (i13 < 128) {
                    c10 = '+';
                } else {
                    c10 = i13 < 192 ? '.' : ' ';
                }
                sb2.append(c10);
            }
            sb2.append('\n');
        }
        return sb2.toString();
    }
}
