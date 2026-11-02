package d1;

import android.content.Context;
import java.io.Closeable;
import java.io.IOException;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class u implements Closeable {

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public interface a {
        a a(Context context);

        u build();
    }

    public abstract l1.d a();

    public abstract t b();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        a().close();
    }
}
