package f2;

import java.util.Map;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class z3 implements Runnable {

    /* renamed from: e, reason: collision with root package name */
    public final x3 f5865e;

    /* renamed from: j, reason: collision with root package name */
    public final int f5866j;

    /* renamed from: k, reason: collision with root package name */
    public final Throwable f5867k;

    /* renamed from: l, reason: collision with root package name */
    public final byte[] f5868l;

    /* renamed from: m, reason: collision with root package name */
    public final String f5869m;

    /* renamed from: n, reason: collision with root package name */
    public final Map f5870n;

    public /* synthetic */ z3(String str, x3 x3Var, int i10, Throwable th, byte[] bArr, Map map, y3 y3Var) {
        t1.f.h(x3Var);
        this.f5865e = x3Var;
        this.f5866j = i10;
        this.f5867k = th;
        this.f5868l = bArr;
        this.f5869m = str;
        this.f5870n = map;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f5865e.a(this.f5869m, this.f5866j, this.f5867k, this.f5868l, this.f5870n);
    }
}
