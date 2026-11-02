package com.google.android.gms.internal.measurement;

import java.util.Collections;
import java.util.Map;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class q8 {

    /* renamed from: b, reason: collision with root package name */
    public static volatile q8 f3703b;

    /* renamed from: c, reason: collision with root package name */
    public static final q8 f3704c = new q8(true);

    /* renamed from: a, reason: collision with root package name */
    public final Map f3705a = Collections.EMPTY_MAP;

    public q8(boolean z10) {
    }

    public static q8 a() {
        q8 q8Var = f3703b;
        if (q8Var != null) {
            return q8Var;
        }
        synchronized (q8.class) {
            try {
                q8 q8Var2 = f3703b;
                if (q8Var2 != null) {
                    return q8Var2;
                }
                q8 q8VarA = v8.a(q8.class);
                f3703b = q8VarA;
                return q8VarA;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final y8 b(aa aaVar, int i10) {
        n.g.a(this.f3705a.get(new p8(aaVar, i10)));
        return null;
    }
}
