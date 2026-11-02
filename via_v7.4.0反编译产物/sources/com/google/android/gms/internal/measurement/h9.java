package com.google.android.gms.internal.measurement;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class h9 {

    /* renamed from: a, reason: collision with root package name */
    public static final Charset f3535a = Charset.forName("US-ASCII");

    /* renamed from: b, reason: collision with root package name */
    public static final Charset f3536b = Charset.forName("UTF-8");

    /* renamed from: c, reason: collision with root package name */
    public static final Charset f3537c = Charset.forName("ISO-8859-1");

    /* renamed from: d, reason: collision with root package name */
    public static final byte[] f3538d;

    /* renamed from: e, reason: collision with root package name */
    public static final ByteBuffer f3539e;

    /* renamed from: f, reason: collision with root package name */
    public static final j8 f3540f;

    static {
        byte[] bArr = new byte[0];
        f3538d = bArr;
        f3539e = ByteBuffer.wrap(bArr);
        int i10 = j8.f3576a;
        h8 h8Var = new h8(bArr, 0, 0, false, null);
        try {
            h8Var.c(0);
            f3540f = h8Var;
        } catch (zzll e10) {
            throw new IllegalArgumentException(e10);
        }
    }

    public static int a(boolean z10) {
        return z10 ? 1231 : 1237;
    }

    public static int b(int i10, byte[] bArr, int i11, int i12) {
        for (int i13 = 0; i13 < i12; i13++) {
            i10 = (i10 * 31) + bArr[i13];
        }
        return i10;
    }

    public static Object c(Object obj, String str) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException(str);
    }

    public static String d(byte[] bArr) {
        return new String(bArr, f3536b);
    }
}
