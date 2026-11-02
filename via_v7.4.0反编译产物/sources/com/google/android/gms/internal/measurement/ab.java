package com.google.android.gms.internal.measurement;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import libcore.io.Memory;
import sun.misc.Unsafe;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class ab {

    /* renamed from: a, reason: collision with root package name */
    public static final Unsafe f3389a;

    /* renamed from: b, reason: collision with root package name */
    public static final Class f3390b;

    /* renamed from: c, reason: collision with root package name */
    public static final boolean f3391c;

    /* renamed from: d, reason: collision with root package name */
    public static final za f3392d;

    /* renamed from: e, reason: collision with root package name */
    public static final boolean f3393e;

    /* renamed from: f, reason: collision with root package name */
    public static final boolean f3394f;

    /* renamed from: g, reason: collision with root package name */
    public static final long f3395g;

    /* renamed from: h, reason: collision with root package name */
    public static final boolean f3396h;

    /* JADX WARN: Removed duplicated region for block: B:11:0x003e  */
    static {
        boolean z10;
        boolean z11;
        za zaVar;
        Unsafe unsafeL = l();
        f3389a = unsafeL;
        int i10 = v7.f3849a;
        f3390b = Memory.class;
        Class<?> cls = Long.TYPE;
        boolean zA = A(cls);
        f3391c = zA;
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
        f3392d = xaVar;
        if (xaVar == null) {
            z10 = false;
        } else {
            try {
                Class<?> cls3 = xaVar.f3914a.getClass();
                cls3.getMethod("objectFieldOffset", Field.class);
                cls3.getMethod("getLong", Object.class, cls);
                if (b() != null) {
                    z10 = true;
                }
            } catch (Throwable th) {
                m(th);
            }
        }
        f3393e = z10;
        za zaVar2 = f3392d;
        if (zaVar2 == null) {
            z11 = false;
        } else {
            try {
                Class<?> cls4 = zaVar2.f3914a.getClass();
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
            }
        }
        f3394f = z11;
        f3395g = E(byte[].class);
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
        if (fieldB != null && (zaVar = f3392d) != null) {
            zaVar.f3914a.objectFieldOffset(fieldB);
        }
        f3396h = ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean A(Class cls) {
        int i10 = v7.f3849a;
        try {
            Class cls2 = f3390b;
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
        return f3392d.g(obj, j10);
    }

    public static boolean C() {
        return f3394f;
    }

    public static boolean D() {
        return f3393e;
    }

    public static int E(Class cls) {
        if (f3394f) {
            return f3392d.f3914a.arrayBaseOffset(cls);
        }
        return -1;
    }

    public static int a(Class cls) {
        if (f3394f) {
            return f3392d.f3914a.arrayIndexScale(cls);
        }
        return -1;
    }

    public static Field b() {
        int i10 = v7.f3849a;
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
        za zaVar = f3392d;
        long j11 = (-4) & j10;
        int i10 = ((((int) j10) ^ (-1)) & 3) << 3;
        zaVar.f3914a.putInt(obj, j11, ((255 & b10) << i10) | (zaVar.f3914a.getInt(obj, j11) & ((255 << i10) ^ (-1))));
    }

    public static void e(Object obj, long j10, byte b10) {
        za zaVar = f3392d;
        long j11 = (-4) & j10;
        int i10 = (((int) j10) & 3) << 3;
        zaVar.f3914a.putInt(obj, j11, ((255 & b10) << i10) | (zaVar.f3914a.getInt(obj, j11) & ((255 << i10) ^ (-1))));
    }

    public static double f(Object obj, long j10) {
        return f3392d.a(obj, j10);
    }

    public static float g(Object obj, long j10) {
        return f3392d.b(obj, j10);
    }

    public static int h(Object obj, long j10) {
        return f3392d.f3914a.getInt(obj, j10);
    }

    public static long i(Object obj, long j10) {
        return f3392d.f3914a.getLong(obj, j10);
    }

    public static Object j(Class cls) {
        try {
            return f3389a.allocateInstance(cls);
        } catch (InstantiationException e10) {
            throw new IllegalStateException(e10);
        }
    }

    public static Object k(Object obj, long j10) {
        return f3392d.f3914a.getObject(obj, j10);
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
        f3392d.c(obj, j10, z10);
    }

    public static void s(byte[] bArr, long j10, byte b10) {
        f3392d.d(bArr, f3395g + j10, b10);
    }

    public static void t(Object obj, long j10, double d10) {
        f3392d.e(obj, j10, d10);
    }

    public static void u(Object obj, long j10, float f10) {
        f3392d.f(obj, j10, f10);
    }

    public static void v(Object obj, long j10, int i10) {
        f3392d.f3914a.putInt(obj, j10, i10);
    }

    public static void w(Object obj, long j10, long j11) {
        f3392d.f3914a.putLong(obj, j10, j11);
    }

    public static void x(Object obj, long j10, Object obj2) {
        f3392d.f3914a.putObject(obj, j10, obj2);
    }

    public static /* bridge */ /* synthetic */ boolean y(Object obj, long j10) {
        return ((byte) ((f3392d.f3914a.getInt(obj, (-4) & j10) >>> ((int) (((j10 ^ (-1)) & 3) << 3))) & 255)) != 0;
    }

    public static /* bridge */ /* synthetic */ boolean z(Object obj, long j10) {
        return ((byte) ((f3392d.f3914a.getInt(obj, (-4) & j10) >>> ((int) ((j10 & 3) << 3))) & 255)) != 0;
    }
}
