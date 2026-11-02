package com.google.android.gms.internal.measurement;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class h0 implements i0 {

    /* renamed from: a, reason: collision with root package name */
    public final q4 f3524a;

    /* renamed from: b, reason: collision with root package name */
    public final String f3525b;

    public h0(q4 q4Var, String str) {
        this.f3524a = q4Var;
        this.f3525b = str;
    }

    @Override // com.google.android.gms.internal.measurement.i0
    public final q4 a(r rVar) {
        q4 q4VarA = this.f3524a.a();
        q4VarA.e(this.f3525b, rVar);
        return q4VarA;
    }
}
