package z0;

import java.nio.ByteBuffer;
import java.security.MessageDigest;
import okio.q;
import okio.r;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class h implements okio.d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final MessageDigest f15124c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f15125e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public byte[] f15126m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public okio.c f15127n;

    public h(MessageDigest messageDigest) {
        this.f15124c = messageDigest;
        messageDigest.reset();
        this.f15127n = new okio.c();
    }

    @Override // okio.d
    public okio.d H(String str) {
        return null;
    }

    @Override // okio.d
    public long M(q qVar) {
        return 0L;
    }

    @Override // okio.d
    public okio.d N(long j10) {
        return null;
    }

    public byte[] a() {
        return this.f15126m;
    }

    @Override // okio.p, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.f15125e) {
            return;
        }
        this.f15125e = true;
        this.f15126m = this.f15124c.digest();
        this.f15127n.close();
    }

    @Override // okio.d
    public okio.c d() {
        return this.f15127n;
    }

    @Override // okio.p
    public r i() {
        return null;
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return false;
    }

    @Override // okio.d
    public okio.d write(byte[] bArr) {
        this.f15124c.update(bArr);
        return this;
    }

    @Override // okio.d
    public okio.d writeByte(int i10) {
        return null;
    }

    @Override // okio.d
    public okio.d writeInt(int i10) {
        return null;
    }

    @Override // okio.d
    public okio.d writeShort(int i10) {
        return null;
    }

    @Override // okio.d
    public okio.d write(byte[] bArr, int i10, int i11) {
        this.f15124c.update(bArr, i10, i11);
        return this;
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) {
        return 0;
    }

    @Override // okio.d, okio.p, java.io.Flushable
    public void flush() {
    }

    @Override // okio.p
    public void L(okio.c cVar, long j10) {
    }
}
