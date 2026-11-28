package androidx.activity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Executor f401a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p7.a f402b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f403c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f404d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f405e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f406f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List f407g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Runnable f408h;

    public m(Executor executor, p7.a reportFullyDrawn) {
        kotlin.jvm.internal.h.f(executor, "executor");
        kotlin.jvm.internal.h.f(reportFullyDrawn, "reportFullyDrawn");
        this.f401a = executor;
        this.f402b = reportFullyDrawn;
        this.f403c = new Object();
        this.f407g = new ArrayList();
        this.f408h = new Runnable() { // from class: androidx.activity.l
            @Override // java.lang.Runnable
            public final void run() {
                m.d(this.f400c);
            }
        };
    }

    public static final void d(m this$0) {
        kotlin.jvm.internal.h.f(this$0, "this$0");
        synchronized (this$0.f403c) {
            try {
                this$0.f405e = false;
                if (this$0.f404d == 0 && !this$0.f406f) {
                    this$0.f402b.invoke();
                    this$0.b();
                }
                d7.h hVar = d7.h.f3935a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void b() {
        synchronized (this.f403c) {
            try {
                this.f406f = true;
                Iterator it = this.f407g.iterator();
                while (it.hasNext()) {
                    ((p7.a) it.next()).invoke();
                }
                this.f407g.clear();
                d7.h hVar = d7.h.f3935a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean c() {
        boolean z10;
        synchronized (this.f403c) {
            z10 = this.f406f;
        }
        return z10;
    }
}
