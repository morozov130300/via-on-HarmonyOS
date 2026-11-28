package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class d1 extends j1 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AtomicReference f2737d = new AtomicReference();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f2738e;

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0003, code lost:
    
        r3 = r3.get("r");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object c0(android.os.Bundle r3, java.lang.Class r4) {
        /*
            r0 = 0
            if (r3 == 0) goto L32
            java.lang.String r1 = "r"
            java.lang.Object r3 = r3.get(r1)
            if (r3 == 0) goto L32
            java.lang.Object r3 = r4.cast(r3)     // Catch: java.lang.ClassCastException -> L10
            return r3
        L10:
            r0 = move-exception
            java.lang.String r4 = r4.getCanonicalName()
            java.lang.Class r3 = r3.getClass()
            java.lang.String r3 = r3.getCanonicalName()
            r1 = 2
            java.lang.Object[] r1 = new java.lang.Object[r1]
            r2 = 0
            r1[r2] = r4
            r4 = 1
            r1[r4] = r3
            java.lang.String r3 = "Unexpected object type. Expected, Received: %s, %s"
            java.lang.String r3 = java.lang.String.format(r3, r1)
            java.lang.String r4 = "AM"
            android.util.Log.w(r4, r3, r0)
            throw r0
        L32:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.d1.c0(android.os.Bundle, java.lang.Class):java.lang.Object");
    }

    public final Bundle Z(long j10) {
        Bundle bundle;
        synchronized (this.f2737d) {
            if (!this.f2738e) {
                try {
                    this.f2737d.wait(j10);
                } catch (InterruptedException unused) {
                    return null;
                }
            }
            bundle = (Bundle) this.f2737d.get();
        }
        return bundle;
    }

    public final Long a0(long j10) {
        return (Long) c0(Z(j10), Long.class);
    }

    public final String b0(long j10) {
        return (String) c0(Z(j10), String.class);
    }

    @Override // com.google.android.gms.internal.measurement.k1
    public final void v(Bundle bundle) {
        synchronized (this.f2737d) {
            try {
                try {
                    this.f2737d.set(bundle);
                    this.f2738e = true;
                    this.f2737d.notify();
                } catch (Throwable th) {
                    this.f2737d.notify();
                    throw th;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
