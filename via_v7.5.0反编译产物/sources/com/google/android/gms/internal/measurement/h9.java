package com.google.android.gms.internal.measurement;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class h9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Charset f2834a = Charset.forName("US-ASCII");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Charset f2835b = Charset.forName("UTF-8");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Charset f2836c = Charset.forName("ISO-8859-1");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final byte[] f2837d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ByteBuffer f2838e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final j8 f2839f;

    static {
        byte[] bArr = new byte[0];
        f2837d = bArr;
        f2838e = ByteBuffer.wrap(bArr);
        int i10 = j8.f2875a;
        h8 h8Var = new h8(bArr, 0, 0, false, null);
        try {
            h8Var.c(0);
            f2839f = h8Var;
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
        return new String(bArr, f2835b);
    }
}
