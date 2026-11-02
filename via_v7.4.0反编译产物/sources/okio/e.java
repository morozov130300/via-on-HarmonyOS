package okio;

import java.io.InputStream;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public interface e extends q, ReadableByteChannel {
    ByteString A(long j10);

    boolean C();

    String E(long j10);

    boolean G(long j10, ByteString byteString);

    String H(Charset charset);

    String N();

    int O();

    byte[] P(long j10);

    short R();

    void X(long j10);

    long Y(byte b10);

    long Z();

    InputStream a0();

    c c();

    byte readByte();

    void readFully(byte[] bArr);

    int readInt();

    short readShort();

    void skip(long j10);
}
