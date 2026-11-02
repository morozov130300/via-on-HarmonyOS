package com.google.android.gms.internal.measurement;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class j2 implements Runnable {

    /* renamed from: e, reason: collision with root package name */
    public final long f3568e;

    /* renamed from: j, reason: collision with root package name */
    public final long f3569j;

    /* renamed from: k, reason: collision with root package name */
    public final boolean f3570k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ u2 f3571l;

    public j2(u2 u2Var, boolean z10) {
        this.f3571l = u2Var;
        this.f3568e = u2Var.f3813b.a();
        this.f3569j = u2Var.f3813b.b();
        this.f3570k = z10;
    }

    public abstract void a();

    public void b() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f3571l.f3818g) {
            b();
            return;
        }
        try {
            a();
        } catch (Exception e10) {
            this.f3571l.h(e10, false, this.f3570k);
            b();
        }
    }
}
