package okio;

import java.io.InputStream;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public interface e extends q, ReadableByteChannel {
    ByteString B(long j10);

    boolean C();

    String F(long j10);

    boolean I(long j10, ByteString byteString);

    String K(Charset charset);

    String O();

    int R();

    byte[] S(long j10);

    short T();

    void X(long j10);

    long Y(byte b10);

    long Z();

    InputStream a0();

    c d();

    byte readByte();

    void readFully(byte[] bArr);

    int readInt();

    short readShort();

    void skip(long j10);
}
