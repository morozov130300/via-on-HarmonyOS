package com.google.android.gms.internal.measurement;

import java.util.List;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class na {

    /* renamed from: a, reason: collision with root package name */
    public static final Class f3633a;

    /* renamed from: b, reason: collision with root package name */
    public static final qa f3634b;

    /* renamed from: c, reason: collision with root package name */
    public static final qa f3635c;

    static {
        Class<?> cls;
        Class<?> cls2;
        qa qaVar = null;
        try {
            cls = Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            cls = null;
        }
        f3633a = cls;
        try {
            cls2 = Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused2) {
            cls2 = null;
        }
        if (cls2 != null) {
            try {
                qaVar = (qa) cls2.getConstructor(null).newInstance(null);
            } catch (Throwable unused3) {
            }
        }
        f3634b = qaVar;
        f3635c = new sa();
    }

    public static int A(int i10, List list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (m8.y(i10 << 3) + 4);
    }

    public static int B(List list) {
        return list.size() * 4;
    }

    public static int C(int i10, List list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (m8.y(i10 << 3) + 8);
    }

    public static int D(List list) {
        return list.size() * 8;
    }

    public static int E(int i10, List list, la laVar) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iU = 0;
        for (int i11 = 0; i11 < size; i11++) {
            iU += m8.u(i10, (aa) list.get(i11), laVar);
        }
        return iU;
    }

    public static int F(int i10, List list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return G(list) + (size * m8.y(i10 << 3));
    }

    public static int G(List list) {
        int size = list.size();
        int i10 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof b9)) {
            int iV = 0;
            while (i10 < size) {
                iV += m8.v(((Integer) list.get(i10)).intValue());
                i10++;
            }
            return iV;
        }
        b9 b9Var = (b9) list;
        int iV2 = 0;
        while (i10 < size) {
            iV2 += m8.v(b9Var.f(i10));
            i10++;
        }
        return iV2;
    }

    public static int H(int i10, List list, boolean z10) {
        if (list.size() == 0) {
            return 0;
        }
        return I(list) + (list.size() * m8.y(i10 << 3));
    }

    public static int I(List list) {
        int size = list.size();
        int i10 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof q9)) {
            int iZ = 0;
            while (i10 < size) {
                iZ += m8.z(((Long) list.get(i10)).longValue());
                i10++;
            }
            return iZ;
        }
        q9 q9Var = (q9) list;
        int iZ2 = 0;
        while (i10 < size) {
            iZ2 += m8.z(q9Var.i(i10));
            i10++;
        }
        return iZ2;
    }

    public static int J(int i10, Object obj, la laVar) {
        return m8.y(i10 << 3) + m8.w((aa) obj, laVar);
    }

    public static int K(int i10, List list, la laVar) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iY = m8.y(i10 << 3) * size;
        for (int i11 = 0; i11 < size; i11++) {
            iY += m8.w((aa) list.get(i11), laVar);
        }
        return iY;
    }

    public static int L(int i10, List list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return M(list) + (size * m8.y(i10 << 3));
    }

    public static int M(List list) {
        int size = list.size();
        int i10 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof b9)) {
            int iY = 0;
            while (i10 < size) {
                int iIntValue = ((Integer) list.get(i10)).intValue();
                iY += m8.y((iIntValue >> 31) ^ (iIntValue + iIntValue));
                i10++;
            }
            return iY;
        }
        b9 b9Var = (b9) list;
        int iY2 = 0;
        while (i10 < size) {
            int iF = b9Var.f(i10);
            iY2 += m8.y((iF >> 31) ^ (iF + iF));
            i10++;
        }
        return iY2;
    }

    public static int N(int i10, List list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return O(list) + (size * m8.y(i10 << 3));
    }

    public static int O(List list) {
        int size = list.size();
        int i10 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof q9)) {
            int iZ = 0;
            while (i10 < size) {
                long jLongValue = ((Long) list.get(i10)).longValue();
                iZ += m8.z((jLongValue >> 63) ^ (jLongValue + jLongValue));
                i10++;
            }
            return iZ;
        }
        q9 q9Var = (q9) list;
        int iZ2 = 0;
        while (i10 < size) {
            long jI = q9Var.i(i10);
            iZ2 += m8.z((jI >> 63) ^ (jI + jI));
            i10++;
        }
        return iZ2;
    }

    public static int P(int i10, List list) {
        int size = list.size();
        int i11 = 0;
        if (size == 0) {
            return 0;
        }
        boolean z10 = list instanceof j9;
        int iY = m8.y(i10 << 3) * size;
        if (!z10) {
            while (i11 < size) {
                Object obj = list.get(i11);
                if (obj instanceof zzka) {
                    int iZzd = ((zzka) obj).zzd();
                    iY += m8.y(iZzd) + iZzd;
                } else {
                    iY += m8.x((String) obj);
                }
                i11++;
            }
            return iY;
        }
        j9 j9Var = (j9) list;
        while (i11 < size) {
            Object objM = j9Var.m(i11);
            if (objM instanceof zzka) {
                int iZzd2 = ((zzka) objM).zzd();
                iY += m8.y(iZzd2) + iZzd2;
            } else {
                iY += m8.x((String) objM);
            }
            i11++;
        }
        return iY;
    }

    public static int Q(int i10, List list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return R(list) + (size * m8.y(i10 << 3));
    }

    public static int R(List list) {
        int size = list.size();
        int i10 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof b9)) {
            int iY = 0;
            while (i10 < size) {
                iY += m8.y(((Integer) list.get(i10)).intValue());
                i10++;
            }
            return iY;
        }
        b9 b9Var = (b9) list;
        int iY2 = 0;
        while (i10 < size) {
            iY2 += m8.y(b9Var.f(i10));
            i10++;
        }
        return iY2;
    }

    public static int S(int i10, List list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return T(list) + (size * m8.y(i10 << 3));
    }

    public static int T(List list) {
        int size = list.size();
        int i10 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof q9)) {
            int iZ = 0;
            while (i10 < size) {
                iZ += m8.z(((Long) list.get(i10)).longValue());
                i10++;
            }
            return iZ;
        }
        q9 q9Var = (q9) list;
        int iZ2 = 0;
        while (i10 < size) {
            iZ2 += m8.z(q9Var.i(i10));
            i10++;
        }
        return iZ2;
    }

    public static qa U() {
        return f3634b;
    }

    public static qa V() {
        return f3635c;
    }

    public static Object a(Object obj, int i10, int i11, Object obj2, qa qaVar) {
        if (obj2 == null) {
            obj2 = qaVar.c(obj);
        }
        qaVar.f(obj2, i10, i11);
        return obj2;
    }

    public static void b(qa qaVar, Object obj, Object obj2) {
        qaVar.h(obj, qaVar.e(qaVar.d(obj), qaVar.d(obj2)));
    }

    public static void c(Class cls) {
        Class cls2;
        if (!a9.class.isAssignableFrom(cls) && (cls2 = f3633a) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static void d(int i10, List list, gb gbVar, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        gbVar.j(i10, list, z10);
    }

    public static void e(int i10, List list, gb gbVar) {
        if (list == null || list.isEmpty()) {
            return;
        }
        gbVar.d(i10, list);
    }

    public static void f(int i10, List list, gb gbVar, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        gbVar.C(i10, list, z10);
    }

    public static void g(int i10, List list, gb gbVar, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        gbVar.p(i10, list, z10);
    }

    public static void h(int i10, List list, gb gbVar, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        gbVar.m(i10, list, z10);
    }

    public static void i(int i10, List list, gb gbVar, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        gbVar.u(i10, list, z10);
    }

    public static void j(int i10, List list, gb gbVar, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        gbVar.F(i10, list, z10);
    }

    public static void k(int i10, List list, gb gbVar, la laVar) {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (int i11 = 0; i11 < list.size(); i11++) {
            ((n8) gbVar).a(i10, list.get(i11), laVar);
        }
    }

    public static void l(int i10, List list, gb gbVar, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        gbVar.n(i10, list, z10);
    }

    public static void m(int i10, List list, gb gbVar, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        gbVar.y(i10, list, z10);
    }

    public static void n(int i10, List list, gb gbVar, la laVar) {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (int i11 = 0; i11 < list.size(); i11++) {
            ((n8) gbVar).t(i10, list.get(i11), laVar);
        }
    }

    public static void o(int i10, List list, gb gbVar, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        gbVar.B(i10, list, z10);
    }

    public static void p(int i10, List list, gb gbVar, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        gbVar.c(i10, list, z10);
    }

    public static void q(int i10, List list, gb gbVar, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        gbVar.x(i10, list, z10);
    }

    public static void r(int i10, List list, gb gbVar, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        gbVar.H(i10, list, z10);
    }

    public static void s(int i10, List list, gb gbVar) {
        if (list == null || list.isEmpty()) {
            return;
        }
        gbVar.r(i10, list);
    }

    public static void t(int i10, List list, gb gbVar, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        gbVar.l(i10, list, z10);
    }

    public static void u(int i10, List list, gb gbVar, boolean z10) {
        if (list == null || list.isEmpty()) {
            return;
        }
        gbVar.z(i10, list, z10);
    }

    public static boolean v(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static int w(int i10, List list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (m8.y(i10 << 3) + 1);
    }

    public static int x(int i10, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iY = size * m8.y(i10 << 3);
        for (int i11 = 0; i11 < list.size(); i11++) {
            int iZzd = ((zzka) list.get(i11)).zzd();
            iY += m8.y(iZzd) + iZzd;
        }
        return iY;
    }

    public static int y(int i10, List list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return z(list) + (size * m8.y(i10 << 3));
    }

    public static int z(List list) {
        int size = list.size();
        int i10 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof b9)) {
            int iV = 0;
            while (i10 < size) {
                iV += m8.v(((Integer) list.get(i10)).intValue());
                i10++;
            }
            return iV;
        }
        b9 b9Var = (b9) list;
        int iV2 = 0;
        while (i10 < size) {
            iV2 += m8.v(b9Var.f(i10));
            i10++;
        }
        return iV2;
    }
}
