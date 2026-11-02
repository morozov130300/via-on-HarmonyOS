package m8;

import android.os.Build;
import java.nio.charset.Charset;
import z8.c0;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final Charset f8676a;

    /* renamed from: b, reason: collision with root package name */
    public static final String f8677b;

    /* renamed from: c, reason: collision with root package name */
    public static final int f8678c;

    /* renamed from: d, reason: collision with root package name */
    public static final String f8679d;

    static {
        Charset charsetForName = Charset.forName("UTF-8");
        f8676a = charsetForName;
        f8677b = charsetForName.name();
        f8678c = Build.VERSION.SDK_INT;
        f8679d = c0.f() ? "https://m.baidu.com/?tn=&from=1022560v" : "https://www.google.com/";
    }
}
