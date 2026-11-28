package okio;

import java.nio.channels.WritableByteChannel;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public interface d extends p, WritableByteChannel {
    d H(String str);

    long M(q qVar);

    d N(long j10);

    c d();

    @Override // okio.p, java.io.Flushable
    void flush();

    d write(byte[] bArr);

    d write(byte[] bArr, int i10, int i11);

    d writeByte(int i10);

    d writeInt(int i10);

    d writeShort(int i10);
}
