package com.google.android.gms.internal.measurement;

import java.nio.charset.Charset;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class n8 implements gb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m8 f2931a;

    public n8(m8 m8Var) {
        Charset charset = h9.f2834a;
        this.f2931a = m8Var;
        m8Var.f2921a = this;
    }

    public static n8 K(m8 m8Var) {
        n8 n8Var = m8Var.f2921a;
        return n8Var != null ? n8Var : new n8(m8Var);
    }

    @Override // com.google.android.gms.internal.measurement.gb
    public final void A(int i10, zzka zzkaVar) {
        this.f2931a.g(i10, zzkaVar);
    }

    @Override // com.google.android.gms.internal.measurement.gb
    public final void B(int i10, List list, boolean z10) {
        int i11 = 0;
        if (!z10) {
            while (i11 < list.size()) {
                this.f2931a.h(i10, ((Integer) list.get(i11)).intValue());
                i11++;
            }
            return;
        }
        this.f2931a.p(i10, 2);
        int i12 = 0;
        for (int i13 = 0; i13 < list.size(); i13++) {
            ((Integer) list.get(i13)).getClass();
            i12 += 4;
        }
        this.f2931a.r(i12);
        while (i11 < list.size()) {
            this.f2931a.i(((Integer) list.get(i11)).intValue());
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.gb
    public final void C(int i10, List list, boolean z10) {
        int i11 = 0;
        if (!z10) {
            while (i11 < list.size()) {
                this.f2931a.j(i10, Double.doubleToRawLongBits(((Double) list.get(i11)).doubleValue()));
                i11++;
            }
            return;
        }
        this.f2931a.p(i10, 2);
        int i12 = 0;
        for (int i13 = 0; i13 < list.size(); i13++) {
            ((Double) list.get(i13)).getClass();
            i12 += 8;
        }
        this.f2931a.r(i12);
        while (i11 < list.size()) {
            this.f2931a.k(Double.doubleToRawLongBits(((Double) list.get(i11)).doubleValue()));
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.gb
    public final void D(int i10, long j10) {
        this.f2931a.s(i10, j10);
    }

    @Override // com.google.android.gms.internal.measurement.gb
    public final void E(int i10) {
        this.f2931a.p(i10, 3);
    }

    @Override // com.google.android.gms.internal.measurement.gb
    public final void F(int i10, List list, boolean z10) {
        int i11 = 0;
        if (!z10) {
            while (i11 < list.size()) {
                this.f2931a.h(i10, Float.floatToRawIntBits(((Float) list.get(i11)).floatValue()));
                i11++;
            }
            return;
        }
        this.f2931a.p(i10, 2);
        int i12 = 0;
        for (int i13 = 0; i13 < list.size(); i13++) {
            ((Float) list.get(i13)).getClass();
            i12 += 4;
        }
        this.f2931a.r(i12);
        while (i11 < list.size()) {
            this.f2931a.i(Float.floatToRawIntBits(((Float) list.get(i11)).floatValue()));
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.gb
    public final void G(int i10, long j10) {
        this.f2931a.j(i10, j10);
    }

    @Override // com.google.android.gms.internal.measurement.gb
    public final void H(int i10, List list, boolean z10) {
        int i11 = 0;
        if (!z10) {
            while (i11 < list.size()) {
                m8 m8Var = this.f2931a;
                long jLongValue = ((Long) list.get(i11)).longValue();
                m8Var.s(i10, (jLongValue >> 63) ^ (jLongValue + jLongValue));
                i11++;
            }
            return;
        }
        this.f2931a.p(i10, 2);
        int iZ = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            long jLongValue2 = ((Long) list.get(i12)).longValue();
            iZ += m8.z((jLongValue2 >> 63) ^ (jLongValue2 + jLongValue2));
        }
        this.f2931a.r(iZ);
        while (i11 < list.size()) {
            m8 m8Var2 = this.f2931a;
            long jLongValue3 = ((Long) list.get(i11)).longValue();
            m8Var2.t((jLongValue3 >> 63) ^ (jLongValue3 + jLongValue3));
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.gb
    public final void I(int i10, long j10) {
        this.f2931a.s(i10, (j10 >> 63) ^ (j10 + j10));
    }

    @Override // com.google.android.gms.internal.measurement.gb
    public final void J(int i10) {
        this.f2931a.p(i10, 4);
    }

    @Override // com.google.android.gms.internal.measurement.gb
    public final void a(int i10, Object obj, la laVar) {
        m8 m8Var = this.f2931a;
        m8Var.p(i10, 3);
        laVar.b((aa) obj, m8Var.f2921a);
        m8Var.p(i10, 4);
    }

    @Override // com.google.android.gms.internal.measurement.gb
    public final void b(int i10, int i11) {
        this.f2931a.q(i10, i11);
    }

    @Override // com.google.android.gms.internal.measurement.gb
    public final void c(int i10, List list, boolean z10) {
        int i11 = 0;
        if (!z10) {
            while (i11 < list.size()) {
                this.f2931a.j(i10, ((Long) list.get(i11)).longValue());
                i11++;
            }
            return;
        }
        this.f2931a.p(i10, 2);
        int i12 = 0;
        for (int i13 = 0; i13 < list.size(); i13++) {
            ((Long) list.get(i13)).getClass();
            i12 += 8;
        }
        this.f2931a.r(i12);
        while (i11 < list.size()) {
            this.f2931a.k(((Long) list.get(i11)).longValue());
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.gb
    public final void d(int i10, List list) {
        for (int i11 = 0; i11 < list.size(); i11++) {
            this.f2931a.g(i10, (zzka) list.get(i11));
        }
    }

    @Override // com.google.android.gms.internal.measurement.gb
    public final void e(int i10, int i11) {
        this.f2931a.h(i10, i11);
    }

    @Override // com.google.android.gms.internal.measurement.gb
    public final void f(int i10, boolean z10) {
        this.f2931a.f(i10, z10);
    }

    @Override // com.google.android.gms.internal.measurement.gb
    public final void g(int i10, int i11) {
        this.f2931a.q(i10, (i11 >> 31) ^ (i11 + i11));
    }

    @Override // com.google.android.gms.internal.measurement.gb
    public final void h(int i10, String str) {
        this.f2931a.o(i10, str);
    }

    @Override // com.google.android.gms.internal.measurement.gb
    public final void i(int i10, long j10) {
        this.f2931a.s(i10, j10);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.google.android.gms.internal.measurement.gb
    public final void j(int i10, List list, boolean z10) {
        int i11 = 0;
        if (!z10) {
            while (i11 < list.size()) {
                this.f2931a.f(i10, ((Boolean) list.get(i11)).booleanValue());
                i11++;
            }
            return;
        }
        this.f2931a.p(i10, 2);
        int i12 = 0;
        for (int i13 = 0; i13 < list.size(); i13++) {
            ((Boolean) list.get(i13)).getClass();
            i12++;
        }
        this.f2931a.r(i12);
        while (i11 < list.size()) {
            this.f2931a.e(((Boolean) list.get(i11)).booleanValue() ? (byte) 1 : (byte) 0);
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.gb
    public final void k(int i10, long j10) {
        this.f2931a.j(i10, j10);
    }

    @Override // com.google.android.gms.internal.measurement.gb
    public final void l(int i10, List list, boolean z10) {
        int i11 = 0;
        if (!z10) {
            while (i11 < list.size()) {
                this.f2931a.q(i10, ((Integer) list.get(i11)).intValue());
                i11++;
            }
            return;
        }
        this.f2931a.p(i10, 2);
        int iY = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            iY += m8.y(((Integer) list.get(i12)).intValue());
        }
        this.f2931a.r(iY);
        while (i11 < list.size()) {
            this.f2931a.r(((Integer) list.get(i11)).intValue());
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.gb
    public final void m(int i10, List list, boolean z10) {
        int i11 = 0;
        if (!z10) {
            while (i11 < list.size()) {
                this.f2931a.h(i10, ((Integer) list.get(i11)).intValue());
                i11++;
            }
            return;
        }
        this.f2931a.p(i10, 2);
        int i12 = 0;
        for (int i13 = 0; i13 < list.size(); i13++) {
            ((Integer) list.get(i13)).getClass();
            i12 += 4;
        }
        this.f2931a.r(i12);
        while (i11 < list.size()) {
            this.f2931a.i(((Integer) list.get(i11)).intValue());
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.gb
    public final void n(int i10, List list, boolean z10) {
        int i11 = 0;
        if (!z10) {
            while (i11 < list.size()) {
                this.f2931a.l(i10, ((Integer) list.get(i11)).intValue());
                i11++;
            }
            return;
        }
        this.f2931a.p(i10, 2);
        int iV = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            iV += m8.v(((Integer) list.get(i12)).intValue());
        }
        this.f2931a.r(iV);
        while (i11 < list.size()) {
            this.f2931a.m(((Integer) list.get(i11)).intValue());
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.gb
    public final void o(int i10, int i11) {
        this.f2931a.l(i10, i11);
    }

    @Override // com.google.android.gms.internal.measurement.gb
    public final void p(int i10, List list, boolean z10) {
        int i11 = 0;
        if (!z10) {
            while (i11 < list.size()) {
                this.f2931a.l(i10, ((Integer) list.get(i11)).intValue());
                i11++;
            }
            return;
        }
        this.f2931a.p(i10, 2);
        int iV = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            iV += m8.v(((Integer) list.get(i12)).intValue());
        }
        this.f2931a.r(iV);
        while (i11 < list.size()) {
            this.f2931a.m(((Integer) list.get(i11)).intValue());
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.gb
    public final void q(int i10, int i11) {
        this.f2931a.l(i10, i11);
    }

    @Override // com.google.android.gms.internal.measurement.gb
    public final void r(int i10, List list) {
        int i11 = 0;
        if (!(list instanceof j9)) {
            while (i11 < list.size()) {
                this.f2931a.o(i10, (String) list.get(i11));
                i11++;
            }
            return;
        }
        j9 j9Var = (j9) list;
        while (i11 < list.size()) {
            Object objM = j9Var.m(i11);
            if (objM instanceof String) {
                this.f2931a.o(i10, (String) objM);
            } else {
                this.f2931a.g(i10, (zzka) objM);
            }
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.gb
    public final void s(int i10, double d10) {
        this.f2931a.j(i10, Double.doubleToRawLongBits(d10));
    }

    @Override // com.google.android.gms.internal.measurement.gb
    public final void t(int i10, Object obj, la laVar) throws zzkg {
        aa aaVar = (aa) obj;
        k8 k8Var = (k8) this.f2931a;
        k8Var.r((i10 << 3) | 2);
        k8Var.r(((t7) aaVar).c(laVar));
        laVar.b(aaVar, k8Var.f2921a);
    }

    @Override // com.google.android.gms.internal.measurement.gb
    public final void u(int i10, List list, boolean z10) {
        int i11 = 0;
        if (!z10) {
            while (i11 < list.size()) {
                this.f2931a.j(i10, ((Long) list.get(i11)).longValue());
                i11++;
            }
            return;
        }
        this.f2931a.p(i10, 2);
        int i12 = 0;
        for (int i13 = 0; i13 < list.size(); i13++) {
            ((Long) list.get(i13)).getClass();
            i12 += 8;
        }
        this.f2931a.r(i12);
        while (i11 < list.size()) {
            this.f2931a.k(((Long) list.get(i11)).longValue());
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.gb
    public final void v(int i10, int i11) {
        this.f2931a.h(i10, i11);
    }

    @Override // com.google.android.gms.internal.measurement.gb
    public final void w(int i10, float f10) {
        this.f2931a.h(i10, Float.floatToRawIntBits(f10));
    }

    @Override // com.google.android.gms.internal.measurement.gb
    public final void x(int i10, List list, boolean z10) {
        int i11 = 0;
        if (!z10) {
            while (i11 < list.size()) {
                m8 m8Var = this.f2931a;
                int iIntValue = ((Integer) list.get(i11)).intValue();
                m8Var.q(i10, (iIntValue >> 31) ^ (iIntValue + iIntValue));
                i11++;
            }
            return;
        }
        this.f2931a.p(i10, 2);
        int iY = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            int iIntValue2 = ((Integer) list.get(i12)).intValue();
            iY += m8.y((iIntValue2 >> 31) ^ (iIntValue2 + iIntValue2));
        }
        this.f2931a.r(iY);
        while (i11 < list.size()) {
            m8 m8Var2 = this.f2931a;
            int iIntValue3 = ((Integer) list.get(i11)).intValue();
            m8Var2.r((iIntValue3 >> 31) ^ (iIntValue3 + iIntValue3));
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.gb
    public final void y(int i10, List list, boolean z10) {
        int i11 = 0;
        if (!z10) {
            while (i11 < list.size()) {
                this.f2931a.s(i10, ((Long) list.get(i11)).longValue());
                i11++;
            }
            return;
        }
        this.f2931a.p(i10, 2);
        int iZ = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            iZ += m8.z(((Long) list.get(i12)).longValue());
        }
        this.f2931a.r(iZ);
        while (i11 < list.size()) {
            this.f2931a.t(((Long) list.get(i11)).longValue());
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.gb
    public final void z(int i10, List list, boolean z10) {
        int i11 = 0;
        if (!z10) {
            while (i11 < list.size()) {
                this.f2931a.s(i10, ((Long) list.get(i11)).longValue());
                i11++;
            }
            return;
        }
        this.f2931a.p(i10, 2);
        int iZ = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            iZ += m8.z(((Long) list.get(i12)).longValue());
        }
        this.f2931a.r(iZ);
        while (i11 < list.size()) {
            this.f2931a.t(((Long) list.get(i11)).longValue());
            i11++;
        }
    }
}
