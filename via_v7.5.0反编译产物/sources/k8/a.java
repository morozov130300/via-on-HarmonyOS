package k8;

import java.nio.charset.Charset;
import x8.a0;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Charset f7218a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f7219b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f7220c;

    static {
        Charset charsetForName = Charset.forName("UTF-8");
        f7218a = charsetForName;
        f7219b = charsetForName.name();
        f7220c = a0.f() ? "https://m.baidu.com/?tn=&from=1022560v" : "https://www.google.com/";
    }
}
