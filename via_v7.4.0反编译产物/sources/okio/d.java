package okio;

import java.nio.channels.WritableByteChannel;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public interface d extends p, WritableByteChannel {
    d F(String str);

    long K(q qVar);

    d L(long j10);

    c c();

    @Override // okio.p, java.io.Flushable
    void flush();

    d write(byte[] bArr);

    d write(byte[] bArr, int i10, int i11);

    d writeByte(int i10);

    d writeInt(int i10);

    d writeShort(int i10);
}
