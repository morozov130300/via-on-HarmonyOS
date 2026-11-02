package okio;

import java.io.Closeable;
import java.io.Flushable;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public interface p extends Closeable, Flushable {
    void I(c cVar, long j10);

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    r e();

    void flush();
}
