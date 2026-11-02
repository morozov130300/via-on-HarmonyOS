package y0;

import java.nio.ByteBuffer;
import java.security.MessageDigest;
import okio.q;
import okio.r;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class h implements okio.d {

    /* renamed from: e, reason: collision with root package name */
    public final MessageDigest f14396e;

    /* renamed from: j, reason: collision with root package name */
    public boolean f14397j;

    /* renamed from: k, reason: collision with root package name */
    public byte[] f14398k;

    /* renamed from: l, reason: collision with root package name */
    public okio.c f14399l;

    public h(MessageDigest messageDigest) {
        this.f14396e = messageDigest;
        messageDigest.reset();
        this.f14399l = new okio.c();
    }

    @Override // okio.d
    public okio.d F(String str) {
        return null;
    }

    @Override // okio.p
    public void I(okio.c cVar, long j10) {
    }

    @Override // okio.d
    public long K(q qVar) {
        return 0L;
    }

    @Override // okio.d
    public okio.d L(long j10) {
        return null;
    }

    public byte[] a() {
        return this.f14398k;
    }

    @Override // okio.d
    public okio.c c() {
        return this.f14399l;
    }

    @Override // okio.p, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.f14397j) {
            return;
        }
        this.f14397j = true;
        this.f14398k = this.f14396e.digest();
        this.f14399l.close();
    }

    @Override // okio.p
    public r e() {
        return null;
    }

    @Override // okio.d, okio.p, java.io.Flushable
    public void flush() {
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return false;
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) {
        return 0;
    }

    @Override // okio.d
    public okio.d write(byte[] bArr) {
        this.f14396e.update(bArr);
        return this;
    }

    @Override // okio.d
    public okio.d write(byte[] bArr, int i10, int i11) {
        this.f14396e.update(bArr, i10, i11);
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
}
