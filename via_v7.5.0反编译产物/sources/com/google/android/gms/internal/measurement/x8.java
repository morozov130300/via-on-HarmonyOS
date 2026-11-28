package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class x8 extends s7 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a9 f3181c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public a9 f3182e;

    public x8(a9 a9Var) {
        this.f3181c = a9Var;
        if (a9Var.A()) {
            throw new IllegalArgumentException("Default instance must be immutable.");
        }
        this.f3182e = a9Var.o();
    }

    public static void k(Object obj, Object obj2) {
        ia.a().b(obj.getClass()).h(obj, obj2);
    }

    @Override // com.google.android.gms.internal.measurement.s7
    public final /* bridge */ /* synthetic */ s7 i(byte[] bArr, int i10, int i11) throws zzll {
        n(bArr, 0, i11, q8.f3003c);
        return this;
    }

    @Override // com.google.android.gms.internal.measurement.s7
    public final /* bridge */ /* synthetic */ s7 j(byte[] bArr, int i10, int i11, q8 q8Var) throws zzll {
        n(bArr, 0, i11, q8Var);
        return this;
    }

    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public final x8 clone() {
        x8 x8Var = (x8) this.f3181c.C(5, null, null);
        x8Var.f3182e = f();
        return x8Var;
    }

    public final x8 m(a9 a9Var) {
        if (!this.f3181c.equals(a9Var)) {
            if (!this.f3182e.A()) {
                r();
            }
            k(this.f3182e, a9Var);
        }
        return this;
    }

    public final x8 n(byte[] bArr, int i10, int i11, q8 q8Var) throws zzll {
        if (!this.f3182e.A()) {
            r();
        }
        try {
            ia.a().b(this.f3182e.getClass()).f(this.f3182e, bArr, 0, i11, new w7(q8Var));
            return this;
        } catch (zzll e10) {
            throw e10;
        } catch (IOException e11) {
            throw new RuntimeException("Reading from byte array should not throw IOException.", e11);
        } catch (IndexOutOfBoundsException unused) {
            throw zzll.zzf();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x002e, code lost:
    
        if (r3 != false) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.gms.internal.measurement.a9 o() {
        /*
            r5 = this;
            com.google.android.gms.internal.measurement.a9 r0 = r5.f()
            r1 = 1
            r2 = 0
            java.lang.Object r3 = r0.C(r1, r2, r2)
            java.lang.Byte r3 = (java.lang.Byte) r3
            byte r3 = r3.byteValue()
            if (r3 != r1) goto L13
            goto L30
        L13:
            if (r3 == 0) goto L31
            com.google.android.gms.internal.measurement.ia r3 = com.google.android.gms.internal.measurement.ia.a()
            java.lang.Class r4 = r0.getClass()
            com.google.android.gms.internal.measurement.la r3 = r3.b(r4)
            boolean r3 = r3.c(r0)
            if (r1 == r3) goto L29
            r1 = r2
            goto L2a
        L29:
            r1 = r0
        L2a:
            r4 = 2
            r0.C(r4, r1, r2)
            if (r3 == 0) goto L31
        L30:
            return r0
        L31:
            com.google.android.gms.internal.measurement.zznj r1 = new com.google.android.gms.internal.measurement.zznj
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.x8.o():com.google.android.gms.internal.measurement.a9");
    }

    @Override // com.google.android.gms.internal.measurement.z9
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public a9 f() {
        if (!this.f3182e.A()) {
            return this.f3182e;
        }
        this.f3182e.w();
        return this.f3182e;
    }

    public final void q() {
        if (this.f3182e.A()) {
            return;
        }
        r();
    }

    public void r() {
        a9 a9VarO = this.f3181c.o();
        k(a9VarO, this.f3182e);
        this.f3182e = a9VarO;
    }
}
