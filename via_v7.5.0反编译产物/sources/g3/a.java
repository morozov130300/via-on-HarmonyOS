package g3;

import java.io.OutputStream;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class a extends OutputStream {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f5500c = 0;

    public long a() {
        return this.f5500c;
    }

    @Override // java.io.OutputStream
    public void write(int i10) {
        this.f5500c++;
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) {
        this.f5500c += (long) bArr.length;
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i10, int i11) {
        int i12;
        if (i10 >= 0 && i10 <= bArr.length && i11 >= 0 && (i12 = i10 + i11) <= bArr.length && i12 >= 0) {
            this.f5500c += (long) i11;
            return;
        }
        throw new IndexOutOfBoundsException();
    }
}
