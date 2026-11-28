package com.google.android.gms.internal.measurement;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class a9 extends t7 {
    private static final Map zza = new ConcurrentHashMap();
    private int zzd = -1;
    protected ra zzc = ra.c();

    public static a9 n(Class cls) {
        Map map = zza;
        a9 a9Var = (a9) map.get(cls);
        if (a9Var == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                a9Var = (a9) map.get(cls);
            } catch (ClassNotFoundException e10) {
                throw new IllegalStateException("Class initialization cannot fail.", e10);
            }
        }
        if (a9Var != null) {
            return a9Var;
        }
        a9 a9Var2 = (a9) ((a9) ab.j(cls)).C(6, null, null);
        if (a9Var2 == null) {
            throw new IllegalStateException();
        }
        map.put(cls, a9Var2);
        return a9Var2;
    }

    public static e9 p() {
        return b9.g();
    }

    public static f9 q() {
        return q9.f();
    }

    public static f9 r(f9 f9Var) {
        int size = f9Var.size();
        return f9Var.j(size == 0 ? 10 : size + size);
    }

    public static g9 s() {
        return ja.f();
    }

    public static g9 t(g9 g9Var) {
        int size = g9Var.size();
        return g9Var.j(size == 0 ? 10 : size + size);
    }

    public static Object u(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e10) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e10);
        } catch (InvocationTargetException e11) {
            Throwable cause = e11.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            if (cause instanceof Error) {
                throw ((Error) cause);
            }
            throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
        }
    }

    public static Object v(aa aaVar, String str, Object[] objArr) {
        return new ka(aaVar, str, objArr);
    }

    public static void y(Class cls, a9 a9Var) {
        a9Var.x();
        zza.put(cls, a9Var);
    }

    public final boolean A() {
        return (this.zzd & Integer.MIN_VALUE) != 0;
    }

    public final int B() {
        return ia.a().b(getClass()).e(this);
    }

    public abstract Object C(int i10, Object obj, Object obj2);

    @Override // com.google.android.gms.internal.measurement.aa
    public final int a() {
        if (A()) {
            int iK = k(null);
            if (iK >= 0) {
                return iK;
            }
            throw new IllegalStateException("serialized size must be non-negative, was " + iK);
        }
        int i10 = this.zzd & Integer.MAX_VALUE;
        if (i10 != Integer.MAX_VALUE) {
            return i10;
        }
        int iK2 = k(null);
        if (iK2 >= 0) {
            this.zzd = (this.zzd & Integer.MIN_VALUE) | iK2;
            return iK2;
        }
        throw new IllegalStateException("serialized size must be non-negative, was " + iK2);
    }

    @Override // com.google.android.gms.internal.measurement.ba
    public final /* synthetic */ aa b() {
        return (a9) C(6, null, null);
    }

    @Override // com.google.android.gms.internal.measurement.t7
    public final int c(la laVar) {
        if (A()) {
            int iK = k(laVar);
            if (iK >= 0) {
                return iK;
            }
            throw new IllegalStateException("serialized size must be non-negative, was " + iK);
        }
        int i10 = this.zzd & Integer.MAX_VALUE;
        if (i10 != Integer.MAX_VALUE) {
            return i10;
        }
        int iK2 = k(laVar);
        if (iK2 >= 0) {
            this.zzd = (this.zzd & Integer.MIN_VALUE) | iK2;
            return iK2;
        }
        throw new IllegalStateException("serialized size must be non-negative, was " + iK2);
    }

    @Override // com.google.android.gms.internal.measurement.aa
    public final /* synthetic */ z9 d() {
        return (x8) C(5, null, null);
    }

    @Override // com.google.android.gms.internal.measurement.aa
    public final void e(m8 m8Var) {
        ia.a().b(getClass()).b(this, n8.K(m8Var));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return ia.a().b(getClass()).i(this, (a9) obj);
    }

    public final int hashCode() {
        if (A()) {
            return B();
        }
        int i10 = this.zzb;
        if (i10 != 0) {
            return i10;
        }
        int iB = B();
        this.zzb = iB;
        return iB;
    }

    public final int k(la laVar) {
        if (laVar != null) {
            return laVar.g(this);
        }
        return ia.a().b(getClass()).g(this);
    }

    public final x8 l() {
        return (x8) C(5, null, null);
    }

    public final x8 m() {
        x8 x8Var = (x8) C(5, null, null);
        x8Var.m(this);
        return x8Var;
    }

    public final a9 o() {
        return (a9) C(4, null, null);
    }

    public final String toString() {
        return ca.a(this, super.toString());
    }

    public final void w() {
        ia.a().b(getClass()).a(this);
        x();
    }

    public final void x() {
        this.zzd &= Integer.MAX_VALUE;
    }

    public final void z(int i10) {
        this.zzd = (this.zzd & Integer.MIN_VALUE) | Integer.MAX_VALUE;
    }
}
