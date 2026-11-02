package com.google.zxing;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    public final int f4119a;

    /* renamed from: b, reason: collision with root package name */
    public final int f4120b;

    public d(int i10, int i11) {
        this.f4119a = i10;
        this.f4120b = i11;
    }

    public final int a() {
        return this.f4120b;
    }

    public abstract byte[] b();

    public abstract byte[] c(int i10, byte[] bArr);

    public final int d() {
        return this.f4119a;
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
        int i10 = this.f4119a;
        byte[] bArrC = new byte[i10];
        StringBuilder sb2 = new StringBuilder(this.f4120b * (i10 + 1));
        for (int i11 = 0; i11 < this.f4120b; i11++) {
            bArrC = c(i11, bArrC);
            for (int i12 = 0; i12 < this.f4119a; i12++) {
                int i13 = bArrC[i12] & 255;
                sb2.append(i13 < 64 ? '#' : i13 < 128 ? '+' : i13 < 192 ? '.' : ' ');
            }
            sb2.append('\n');
        }
        return sb2.toString();
    }
}
