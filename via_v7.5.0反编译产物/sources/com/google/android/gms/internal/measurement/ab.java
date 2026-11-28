package com.google.android.gms.internal.measurement;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import libcore.io.Memory;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class ab {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Unsafe f2688a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Class f2689b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final boolean f2690c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final za f2691d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final boolean f2692e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final boolean f2693f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final long f2694g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final boolean f2695h;

    /* JADX WARN: Code duplicated, block: B:11:0x003e  */
    static {
        boolean z10;
        boolean z11;
        za zaVar;
        Unsafe unsafeL = l();
        f2688a = unsafeL;
        int i10 = v7.f3148a;
        f2689b = Memory.class;
        Class<?> cls = Long.TYPE;
        boolean zA = A(cls);
        f2690c = zA;
        Class<?> cls2 = Integer.TYPE;
        boolean zA2 = A(cls2);
        za xaVar = null;
        if (unsafeL != null) {
            if (zA) {
                xaVar = new ya(unsafeL);
            } else if (zA2) {
                xaVar = new xa(unsafeL);
            }
        }
        f2691d = xaVar;
        if (xaVar == null) {
            z10 = false;
        } else {
            try {
                Class<?> cls3 = xaVar.f3213a.getClass();
                cls3.getMethod("objectFieldOffset", Field.class);
                cls3.getMethod("getLong", Object.class, cls);
                if (b() == null) {
                    z10 = false;
                } else {
                    z10 = true;
                }
            } catch (Throwable th) {
                m(th);
            }
        }
        f2692e = z10;
        za zaVar2 = f2691d;
        if (zaVar2 == null) {
            z11 = false;
        } else {
            try {
                Class<?> cls4 = zaVar2.f3213a.getClass();
                cls4.getMethod("objectFieldOffset", Field.class);
                cls4.getMethod("arrayBaseOffset", Class.class);
                cls4.getMethod("arrayIndexScale", Class.class);
                cls4.getMethod("getInt", Object.class, cls);
                cls4.getMethod("putInt", Object.class, cls, cls2);
                cls4.getMethod("getLong", Object.class, cls);
                cls4.getMethod("putLong", Object.class, cls, cls);
                cls4.getMethod("getObject", Object.class, cls);
                cls4.getMethod("putObject", Object.class, cls, Object.class);
                z11 = true;
            } catch (Throwable th2) {
                m(th2);
                z11 = false;
            }
        }
        f2693f = z11;
        f2694g = E(byte[].class);
        E(boolean[].class);
        a(boolean[].class);
        E(int[].class);
        a(int[].class);
        E(long[].class);
        a(long[].class);
        E(float[].class);
        a(float[].class);
        E(double[].class);
        a(double[].class);
        E(Object[].class);
        a(Object[].class);
        Field fieldB = b();
        if (fieldB != null && (zaVar = f2691d) != null) {
            zaVar.f3213a.objectFieldOffset(fieldB);
        }
        f2695h = ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean A(Class cls) {
        int i10 = v7.f3148a;
        try {
            Class cls2 = f2689b;
            Class cls3 = Boolean.TYPE;
            cls2.getMethod("peekLong", cls, cls3);
            cls2.getMethod("pokeLong", cls, Long.TYPE, cls3);
            Class cls4 = Integer.TYPE;
            cls2.getMethod("pokeInt", cls, cls4, cls3);
            cls2.getMethod("peekInt", cls, cls3);
            cls2.getMethod("pokeByte", cls, Byte.TYPE);
            cls2.getMethod("peekByte", cls);
            cls2.getMethod("pokeByteArray", cls, byte[].class, cls4, cls4);
            cls2.getMethod("peekByteArray", cls, byte[].class, cls4, cls4);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean B(Object obj, long j10) {
        return f2691d.g(obj, j10);
    }

    public static boolean C() {
        return f2693f;
    }

    public static boolean D() {
        return f2692e;
    }

    public static int E(Class cls) {
        if (f2693f) {
            return f2691d.f3213a.arrayBaseOffset(cls);
        }
        return -1;
    }

    public static int a(Class cls) {
        if (f2693f) {
            return f2691d.f3213a.arrayIndexScale(cls);
        }
        return -1;
    }

    public static Field b() {
        int i10 = v7.f3148a;
        Field fieldC = c(Buffer.class, "effectiveDirectAddress");
        if (fieldC != null) {
            return fieldC;
        }
        Field fieldC2 = c(Buffer.class, "address");
        if (fieldC2 == null || fieldC2.getType() != Long.TYPE) {
            return null;
        }
        return fieldC2;
    }

    public static Field c(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void d(Object obj, long j10, byte b10) {
        za zaVar = f2691d;
        long j11 = (-4) & j10;
        int i10 = ((((int) j10) ^ (-1)) & 3) << 3;
        zaVar.f3213a.putInt(obj, j11, ((255 & b10) << i10) | (zaVar.f3213a.getInt(obj, j11) & ((255 << i10) ^ (-1))));
    }

    public static void e(Object obj, long j10, byte b10) {
        za zaVar = f2691d;
        long j11 = (-4) & j10;
        int i10 = (((int) j10) & 3) << 3;
        zaVar.f3213a.putInt(obj, j11, ((255 & b10) << i10) | (zaVar.f3213a.getInt(obj, j11) & ((255 << i10) ^ (-1))));
    }

    public static double f(Object obj, long j10) {
        return f2691d.a(obj, j10);
    }

    public static float g(Object obj, long j10) {
        return f2691d.b(obj, j10);
    }

    public static int h(Object obj, long j10) {
        return f2691d.f3213a.getInt(obj, j10);
    }

    public static long i(Object obj, long j10) {
        return f2691d.f3213a.getLong(obj, j10);
    }

    public static Object j(Class cls) {
        try {
            return f2688a.allocateInstance(cls);
        } catch (InstantiationException e10) {
            throw new IllegalStateException(e10);
        }
    }

    public static Object k(Object obj, long j10) {
        return f2691d.f3213a.getObject(obj, j10);
    }

    public static Unsafe l() {
        try {
            return (Unsafe) AccessController.doPrivileged(new wa());
        } catch (Throwable unused) {
            return null;
        }
    }

    public static /* bridge */ /* synthetic */ void m(Throwable th) {
        Logger.getLogger(ab.class.getName()).logp(Level.WARNING, "com.google.protobuf.UnsafeUtil", "logMissingMethod", "platform method missing - proto runtime falling back to safer methods: ".concat(th.toString()));
    }

    public static void r(Object obj, long j10, boolean z10) {
        f2691d.c(obj, j10, z10);
    }

    public static void s(byte[] bArr, long j10, byte b10) {
        f2691d.d(bArr, f2694g + j10, b10);
    }

    public static void t(Object obj, long j10, double d10) {
        f2691d.e(obj, j10, d10);
    }

    public static void u(Object obj, long j10, float f10) {
        f2691d.f(obj, j10, f10);
    }

    public static void v(Object obj, long j10, int i10) {
        f2691d.f3213a.putInt(obj, j10, i10);
    }

    public static void w(Object obj, long j10, long j11) {
        f2691d.f3213a.putLong(obj, j10, j11);
    }

    public static void x(Object obj, long j10, Object obj2) {
        f2691d.f3213a.putObject(obj, j10, obj2);
    }

    public static /* bridge */ /* synthetic */ boolean y(Object obj, long j10) {
        return ((byte) ((f2691d.f3213a.getInt(obj, (-4) & j10) >>> ((int) (((j10 ^ (-1)) & 3) << 3))) & 255)) != 0;
    }

    public static /* bridge */ /* synthetic */ boolean z(Object obj, long j10) {
        return ((byte) ((f2691d.f3213a.getInt(obj, (-4) & j10) >>> ((int) ((j10 & 3) << 3))) & 255)) != 0;
    }
}
