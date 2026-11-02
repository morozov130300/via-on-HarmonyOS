package androidx.activity;

import android.os.Build;
import android.window.BackEvent;
import android.window.OnBackAnimationCallback;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.activity.OnBackPressedDispatcher;
import androidx.lifecycle.Lifecycle;
import java.util.Iterator;
import java.util.ListIterator;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class OnBackPressedDispatcher {

    /* renamed from: a, reason: collision with root package name */
    public final Runnable f462a;

    /* renamed from: b, reason: collision with root package name */
    public final w.a f463b;

    /* renamed from: c, reason: collision with root package name */
    public final k7.e f464c;

    /* renamed from: d, reason: collision with root package name */
    public o f465d;

    /* renamed from: e, reason: collision with root package name */
    public OnBackInvokedCallback f466e;

    /* renamed from: f, reason: collision with root package name */
    public OnBackInvokedDispatcher f467f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f468g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f469h;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public final class LifecycleOnBackPressedCancellable implements androidx.lifecycle.f, androidx.activity.c {

        /* renamed from: e, reason: collision with root package name */
        public final Lifecycle f470e;

        /* renamed from: j, reason: collision with root package name */
        public final o f471j;

        /* renamed from: k, reason: collision with root package name */
        public androidx.activity.c f472k;

        /* renamed from: l, reason: collision with root package name */
        public final /* synthetic */ OnBackPressedDispatcher f473l;

        public LifecycleOnBackPressedCancellable(OnBackPressedDispatcher onBackPressedDispatcher, Lifecycle lifecycle, o onBackPressedCallback) {
            kotlin.jvm.internal.h.f(lifecycle, "lifecycle");
            kotlin.jvm.internal.h.f(onBackPressedCallback, "onBackPressedCallback");
            this.f473l = onBackPressedDispatcher;
            this.f470e = lifecycle;
            this.f471j = onBackPressedCallback;
            lifecycle.a(this);
        }

        @Override // androidx.lifecycle.f
        public void a(androidx.lifecycle.h source, Lifecycle.Event event) {
            kotlin.jvm.internal.h.f(source, "source");
            kotlin.jvm.internal.h.f(event, "event");
            if (event == Lifecycle.Event.ON_START) {
                this.f472k = this.f473l.i(this.f471j);
                return;
            }
            if (event != Lifecycle.Event.ON_STOP) {
                if (event == Lifecycle.Event.ON_DESTROY) {
                    cancel();
                }
            } else {
                androidx.activity.c cVar = this.f472k;
                if (cVar != null) {
                    cVar.cancel();
                }
            }
        }

        @Override // androidx.activity.c
        public void cancel() {
            this.f470e.c(this);
            this.f471j.i(this);
            androidx.activity.c cVar = this.f472k;
            if (cVar != null) {
                cVar.cancel();
            }
            this.f472k = null;
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public static final a f474a = new a();

        public static final void c(q7.a onBackInvoked) {
            kotlin.jvm.internal.h.f(onBackInvoked, "$onBackInvoked");
            onBackInvoked.invoke();
        }

        public final OnBackInvokedCallback b(final q7.a onBackInvoked) {
            kotlin.jvm.internal.h.f(onBackInvoked, "onBackInvoked");
            return new OnBackInvokedCallback() { // from class: androidx.activity.q
                @Override // android.window.OnBackInvokedCallback
                public final void onBackInvoked() {
                    OnBackPressedDispatcher.a.c(onBackInvoked);
                }
            };
        }

        public final void d(Object dispatcher, int i10, Object callback) {
            kotlin.jvm.internal.h.f(dispatcher, "dispatcher");
            kotlin.jvm.internal.h.f(callback, "callback");
            ((OnBackInvokedDispatcher) dispatcher).registerOnBackInvokedCallback(i10, (OnBackInvokedCallback) callback);
        }

        public final void e(Object dispatcher, Object callback) {
            kotlin.jvm.internal.h.f(dispatcher, "dispatcher");
            kotlin.jvm.internal.h.f(callback, "callback");
            ((OnBackInvokedDispatcher) dispatcher).unregisterOnBackInvokedCallback((OnBackInvokedCallback) callback);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public static final b f475a = new b();

        /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
        public static final class a implements OnBackAnimationCallback {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ q7.l f476a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ q7.l f477b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ q7.a f478c;

            /* renamed from: d, reason: collision with root package name */
            public final /* synthetic */ q7.a f479d;

            public a(q7.l lVar, q7.l lVar2, q7.a aVar, q7.a aVar2) {
                this.f476a = lVar;
                this.f477b = lVar2;
                this.f478c = aVar;
                this.f479d = aVar2;
            }

            @Override // android.window.OnBackAnimationCallback
            public void onBackCancelled() {
                this.f479d.invoke();
            }

            @Override // android.window.OnBackInvokedCallback
            public void onBackInvoked() {
                this.f478c.invoke();
            }

            @Override // android.window.OnBackAnimationCallback
            public void onBackProgressed(BackEvent backEvent) {
                kotlin.jvm.internal.h.f(backEvent, "backEvent");
                this.f477b.invoke(new androidx.activity.b(backEvent));
            }

            @Override // android.window.OnBackAnimationCallback
            public void onBackStarted(BackEvent backEvent) {
                kotlin.jvm.internal.h.f(backEvent, "backEvent");
                this.f476a.invoke(new androidx.activity.b(backEvent));
            }
        }

        public final OnBackInvokedCallback a(q7.l onBackStarted, q7.l onBackProgressed, q7.a onBackInvoked, q7.a onBackCancelled) {
            kotlin.jvm.internal.h.f(onBackStarted, "onBackStarted");
            kotlin.jvm.internal.h.f(onBackProgressed, "onBackProgressed");
            kotlin.jvm.internal.h.f(onBackInvoked, "onBackInvoked");
            kotlin.jvm.internal.h.f(onBackCancelled, "onBackCancelled");
            return new a(onBackStarted, onBackProgressed, onBackInvoked, onBackCancelled);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public final class c implements androidx.activity.c {

        /* renamed from: e, reason: collision with root package name */
        public final o f480e;

        /* renamed from: j, reason: collision with root package name */
        public final /* synthetic */ OnBackPressedDispatcher f481j;

        public c(OnBackPressedDispatcher onBackPressedDispatcher, o onBackPressedCallback) {
            kotlin.jvm.internal.h.f(onBackPressedCallback, "onBackPressedCallback");
            this.f481j = onBackPressedDispatcher;
            this.f480e = onBackPressedCallback;
        }

        @Override // androidx.activity.c
        public void cancel() {
            this.f481j.f464c.remove(this.f480e);
            if (kotlin.jvm.internal.h.a(this.f481j.f465d, this.f480e)) {
                this.f480e.c();
                this.f481j.f465d = null;
            }
            this.f480e.i(this);
            q7.a aVarB = this.f480e.b();
            if (aVarB != null) {
                aVarB.invoke();
            }
            this.f480e.k(null);
        }
    }

    public OnBackPressedDispatcher(Runnable runnable) {
        this(runnable, null);
    }

    public OnBackPressedDispatcher(Runnable runnable, w.a aVar) {
        this.f462a = runnable;
        this.f463b = aVar;
        this.f464c = new k7.e();
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 33) {
            this.f466e = i10 >= 34 ? b.f475a.a(new q7.l() { // from class: androidx.activity.OnBackPressedDispatcher.1
                {
                    super(1);
                }

                @Override // q7.l
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((androidx.activity.b) obj);
                    return j7.f.f7594a;
                }

                public final void invoke(androidx.activity.b backEvent) {
                    kotlin.jvm.internal.h.f(backEvent, "backEvent");
                    OnBackPressedDispatcher.this.m(backEvent);
                }
            }, new q7.l() { // from class: androidx.activity.OnBackPressedDispatcher.2
                {
                    super(1);
                }

                @Override // q7.l
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((androidx.activity.b) obj);
                    return j7.f.f7594a;
                }

                public final void invoke(androidx.activity.b backEvent) {
                    kotlin.jvm.internal.h.f(backEvent, "backEvent");
                    OnBackPressedDispatcher.this.l(backEvent);
                }
            }, new q7.a() { // from class: androidx.activity.OnBackPressedDispatcher.3
                {
                    super(0);
                }

                @Override // q7.a
                public /* bridge */ /* synthetic */ Object invoke() {
                    m0invoke();
                    return j7.f.f7594a;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m0invoke() {
                    OnBackPressedDispatcher.this.k();
                }
            }, new q7.a() { // from class: androidx.activity.OnBackPressedDispatcher.4
                {
                    super(0);
                }

                @Override // q7.a
                public /* bridge */ /* synthetic */ Object invoke() {
                    m1invoke();
                    return j7.f.f7594a;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m1invoke() {
                    OnBackPressedDispatcher.this.j();
                }
            }) : a.f474a.b(new q7.a() { // from class: androidx.activity.OnBackPressedDispatcher.5
                {
                    super(0);
                }

                @Override // q7.a
                public /* bridge */ /* synthetic */ Object invoke() {
                    m2invoke();
                    return j7.f.f7594a;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m2invoke() {
                    OnBackPressedDispatcher.this.k();
                }
            });
        }
    }

    public final void h(androidx.lifecycle.h owner, o onBackPressedCallback) {
        kotlin.jvm.internal.h.f(owner, "owner");
        kotlin.jvm.internal.h.f(onBackPressedCallback, "onBackPressedCallback");
        Lifecycle lifecycleK0 = owner.k0();
        if (lifecycleK0.b() == Lifecycle.State.DESTROYED) {
            return;
        }
        onBackPressedCallback.a(new LifecycleOnBackPressedCancellable(this, lifecycleK0, onBackPressedCallback));
        p();
        onBackPressedCallback.k(new OnBackPressedDispatcher$addCallback$1(this));
    }

    public final androidx.activity.c i(o onBackPressedCallback) {
        kotlin.jvm.internal.h.f(onBackPressedCallback, "onBackPressedCallback");
        this.f464c.add(onBackPressedCallback);
        c cVar = new c(this, onBackPressedCallback);
        onBackPressedCallback.a(cVar);
        p();
        onBackPressedCallback.k(new OnBackPressedDispatcher$addCancellableCallback$1(this));
        return cVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.lang.Object] */
    public final void j() {
        o oVarPrevious;
        o oVar = this.f465d;
        if (oVar == null) {
            k7.e eVar = this.f464c;
            ListIterator listIterator = eVar.listIterator(eVar.size());
            while (true) {
                if (!listIterator.hasPrevious()) {
                    oVarPrevious = 0;
                    break;
                } else {
                    oVarPrevious = listIterator.previous();
                    if (((o) oVarPrevious).g()) {
                        break;
                    }
                }
            }
            oVar = oVarPrevious;
        }
        this.f465d = null;
        if (oVar != null) {
            oVar.c();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.lang.Object] */
    public final void k() {
        o oVarPrevious;
        o oVar = this.f465d;
        if (oVar == null) {
            k7.e eVar = this.f464c;
            ListIterator listIterator = eVar.listIterator(eVar.size());
            while (true) {
                if (!listIterator.hasPrevious()) {
                    oVarPrevious = 0;
                    break;
                } else {
                    oVarPrevious = listIterator.previous();
                    if (((o) oVarPrevious).g()) {
                        break;
                    }
                }
            }
            oVar = oVarPrevious;
        }
        this.f465d = null;
        if (oVar != null) {
            oVar.d();
            return;
        }
        Runnable runnable = this.f462a;
        if (runnable != null) {
            runnable.run();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.lang.Object] */
    public final void l(androidx.activity.b bVar) {
        o oVarPrevious;
        o oVar = this.f465d;
        if (oVar == null) {
            k7.e eVar = this.f464c;
            ListIterator listIterator = eVar.listIterator(eVar.size());
            while (true) {
                if (!listIterator.hasPrevious()) {
                    oVarPrevious = 0;
                    break;
                } else {
                    oVarPrevious = listIterator.previous();
                    if (((o) oVarPrevious).g()) {
                        break;
                    }
                }
            }
            oVar = oVarPrevious;
        }
        if (oVar != null) {
            oVar.e(bVar);
        }
    }

    public final void m(androidx.activity.b bVar) {
        Object objPrevious;
        k7.e eVar = this.f464c;
        ListIterator<E> listIterator = eVar.listIterator(eVar.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                objPrevious = null;
                break;
            } else {
                objPrevious = listIterator.previous();
                if (((o) objPrevious).g()) {
                    break;
                }
            }
        }
        o oVar = (o) objPrevious;
        this.f465d = oVar;
        if (oVar != null) {
            oVar.f(bVar);
        }
    }

    public final void n(OnBackInvokedDispatcher invoker) {
        kotlin.jvm.internal.h.f(invoker, "invoker");
        this.f467f = invoker;
        o(this.f469h);
    }

    public final void o(boolean z10) {
        OnBackInvokedDispatcher onBackInvokedDispatcher = this.f467f;
        OnBackInvokedCallback onBackInvokedCallback = this.f466e;
        if (onBackInvokedDispatcher == null || onBackInvokedCallback == null) {
            return;
        }
        if (z10 && !this.f468g) {
            a.f474a.d(onBackInvokedDispatcher, 0, onBackInvokedCallback);
            this.f468g = true;
        } else {
            if (z10 || !this.f468g) {
                return;
            }
            a.f474a.e(onBackInvokedDispatcher, onBackInvokedCallback);
            this.f468g = false;
        }
    }

    public final void p() {
        boolean z10 = this.f469h;
        k7.e eVar = this.f464c;
        boolean z11 = false;
        if (!p.a(eVar) || !eVar.isEmpty()) {
            Iterator<E> it = eVar.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (((o) it.next()).g()) {
                    z11 = true;
                    break;
                }
            }
        }
        this.f469h = z11;
        if (z11 != z10) {
            w.a aVar = this.f463b;
            if (aVar != null) {
                aVar.accept(Boolean.valueOf(z11));
            }
            if (Build.VERSION.SDK_INT >= 33) {
                o(z11);
            }
        }
    }
}
