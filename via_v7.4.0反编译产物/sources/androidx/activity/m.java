package androidx.activity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    public final Executor f498a;

    /* renamed from: b, reason: collision with root package name */
    public final q7.a f499b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f500c;

    /* renamed from: d, reason: collision with root package name */
    public int f501d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f502e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f503f;

    /* renamed from: g, reason: collision with root package name */
    public final List f504g;

    /* renamed from: h, reason: collision with root package name */
    public final Runnable f505h;

    public m(Executor executor, q7.a reportFullyDrawn) {
        kotlin.jvm.internal.h.f(executor, "executor");
        kotlin.jvm.internal.h.f(reportFullyDrawn, "reportFullyDrawn");
        this.f498a = executor;
        this.f499b = reportFullyDrawn;
        this.f500c = new Object();
        this.f504g = new ArrayList();
        this.f505h = new Runnable() { // from class: androidx.activity.l
            @Override // java.lang.Runnable
            public final void run() {
                m.d(this.f497e);
            }
        };
    }

    public static final void d(m this$0) {
        kotlin.jvm.internal.h.f(this$0, "this$0");
        synchronized (this$0.f500c) {
            try {
                this$0.f502e = false;
                if (this$0.f501d == 0 && !this$0.f503f) {
                    this$0.f499b.invoke();
                    this$0.b();
                }
                j7.f fVar = j7.f.f7594a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void b() {
        synchronized (this.f500c) {
            try {
                this.f503f = true;
                Iterator it = this.f504g.iterator();
                while (it.hasNext()) {
                    ((q7.a) it.next()).invoke();
                }
                this.f504g.clear();
                j7.f fVar = j7.f.f7594a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean c() {
        boolean z10;
        synchronized (this.f500c) {
            z10 = this.f503f;
        }
        return z10;
    }
}
