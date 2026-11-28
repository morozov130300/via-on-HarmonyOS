package kotlin.text;

import java.nio.charset.Charset;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f7328a = new c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Charset f7329b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Charset f7330c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Charset f7331d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Charset f7332e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Charset f7333f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Charset f7334g;

    static {
        Charset charsetForName = Charset.forName("UTF-8");
        kotlin.jvm.internal.h.e(charsetForName, "forName(...)");
        f7329b = charsetForName;
        Charset charsetForName2 = Charset.forName("UTF-16");
        kotlin.jvm.internal.h.e(charsetForName2, "forName(...)");
        f7330c = charsetForName2;
        Charset charsetForName3 = Charset.forName("UTF-16BE");
        kotlin.jvm.internal.h.e(charsetForName3, "forName(...)");
        f7331d = charsetForName3;
        Charset charsetForName4 = Charset.forName("UTF-16LE");
        kotlin.jvm.internal.h.e(charsetForName4, "forName(...)");
        f7332e = charsetForName4;
        Charset charsetForName5 = Charset.forName("US-ASCII");
        kotlin.jvm.internal.h.e(charsetForName5, "forName(...)");
        f7333f = charsetForName5;
        Charset charsetForName6 = Charset.forName("ISO-8859-1");
        kotlin.jvm.internal.h.e(charsetForName6, "forName(...)");
        f7334g = charsetForName6;
    }
}
