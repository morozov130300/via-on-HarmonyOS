package f4;

import java.io.PrintWriter;
import java.io.StringWriter;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Throwable f4473a;

    public k(Throwable th) {
        this.f4473a = th;
    }

    public String toString() {
        StringWriter stringWriter = new StringWriter();
        this.f4473a.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }
}
