package f3;

import java.io.OutputStream;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class a extends OutputStream {

    /* renamed from: e, reason: collision with root package name */
    public long f5884e = 0;

    public long a() {
        return this.f5884e;
    }

    @Override // java.io.OutputStream
    public void write(int i10) {
        this.f5884e++;
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) {
        this.f5884e += bArr.length;
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i10, int i11) {
        int i12;
        if (i10 < 0 || i10 > bArr.length || i11 < 0 || (i12 = i10 + i11) > bArr.length || i12 < 0) {
            throw new IndexOutOfBoundsException();
        }
        this.f5884e += i11;
    }
}
