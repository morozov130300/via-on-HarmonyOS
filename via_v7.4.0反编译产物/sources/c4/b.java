package c4;

import java.lang.reflect.Array;
import java.util.Arrays;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final byte[][] f2278a;

    /* renamed from: b, reason: collision with root package name */
    public final int f2279b;

    /* renamed from: c, reason: collision with root package name */
    public final int f2280c;

    public b(int i10, int i11) {
        this.f2278a = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, i11, i10);
        this.f2279b = i10;
        this.f2280c = i11;
    }

    public void a(byte b10) {
        for (byte[] bArr : this.f2278a) {
            Arrays.fill(bArr, b10);
        }
    }

    public byte b(int i10, int i11) {
        return this.f2278a[i11][i10];
    }

    public byte[][] c() {
        return this.f2278a;
    }

    public int d() {
        return this.f2280c;
    }

    public int e() {
        return this.f2279b;
    }

    public void f(int i10, int i11, int i12) {
        this.f2278a[i11][i10] = (byte) i12;
    }

    public void g(int i10, int i11, boolean z10) {
        this.f2278a[i11][i10] = z10 ? (byte) 1 : (byte) 0;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder((this.f2279b * 2 * this.f2280c) + 2);
        for (int i10 = 0; i10 < this.f2280c; i10++) {
            byte[] bArr = this.f2278a[i10];
            for (int i11 = 0; i11 < this.f2279b; i11++) {
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
