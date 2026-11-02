package e4;

import java.io.PrintWriter;
import java.io.StringWriter;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class k {

    /* renamed from: a, reason: collision with root package name */
    public final Throwable f4757a;

    public k(Throwable th) {
        this.f4757a = th;
    }

    public String toString() {
        StringWriter stringWriter = new StringWriter();
        this.f4757a.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }
}
