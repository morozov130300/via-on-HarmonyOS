package com.google.android.gms.internal.measurement;

import java.nio.charset.Charset;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class u9 implements ma {

    /* renamed from: b, reason: collision with root package name */
    public static final y9 f3824b = new r9();

    /* renamed from: a, reason: collision with root package name */
    public final y9 f3825a;

    public u9() {
        y9 y9Var;
        w8 w8VarC = w8.c();
        try {
            y9Var = (y9) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", null).invoke(null, null);
        } catch (Exception unused) {
            y9Var = f3824b;
        }
        s9 s9Var = new s9(w8VarC, y9Var);
        Charset charset = h9.f3535a;
        this.f3825a = s9Var;
    }

    public static boolean b(x9 x9Var) {
        return x9Var.b() == 1;
    }

    @Override // com.google.android.gms.internal.measurement.ma
    public final la a(Class cls) {
        na.c(cls);
        x9 x9VarA = this.f3825a.a(cls);
        return x9VarA.a() ? a9.class.isAssignableFrom(cls) ? ea.j(na.V(), t8.b(), x9VarA.zza()) : ea.j(na.U(), t8.a(), x9VarA.zza()) : a9.class.isAssignableFrom(cls) ? b(x9VarA) ? da.H(cls, x9VarA, ga.b(), p9.d(), na.V(), t8.b(), w9.b()) : da.H(cls, x9VarA, ga.b(), p9.d(), na.V(), null, w9.b()) : b(x9VarA) ? da.H(cls, x9VarA, ga.a(), p9.c(), na.U(), t8.a(), w9.a()) : da.H(cls, x9VarA, ga.a(), p9.c(), na.U(), null, w9.a());
    }
}
