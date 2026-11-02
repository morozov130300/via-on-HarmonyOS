package f2;

import java.lang.Thread;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class a5 implements Thread.UncaughtExceptionHandler {

    /* renamed from: a, reason: collision with root package name */
    public final String f5028a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e5 f5029b;

    public a5(e5 e5Var, String str) {
        this.f5029b = e5Var;
        t1.f.h(str);
        this.f5028a = str;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final synchronized void uncaughtException(Thread thread, Throwable th) {
        this.f5029b.f5030a.d().r().b(this.f5028a, th);
    }
}
