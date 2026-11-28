package com.google.android.gms.internal.measurement;

import java.util.Collections;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class q8 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile q8 f3002b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final q8 f3003c = new q8(true);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f3004a = Collections.EMPTY_MAP;

    public q8(boolean z10) {
    }

    public static q8 a() {
        q8 q8Var = f3002b;
        if (q8Var != null) {
            return q8Var;
        }
        synchronized (q8.class) {
            try {
                q8 q8Var2 = f3002b;
                if (q8Var2 != null) {
                    return q8Var2;
                }
                q8 q8VarA = v8.a(q8.class);
                f3002b = q8VarA;
                return q8VarA;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final y8 b(aa aaVar, int i10) {
        n.g.a(this.f3004a.get(new p8(aaVar, i10)));
        return null;
    }
}
