package androidx.activity;

import android.os.Build;
import android.window.BackEvent;
import android.window.OnBackAnimationCallback;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.lifecycle.Lifecycle;
import java.util.Iterator;
import java.util.ListIterator;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class OnBackPressedDispatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Runnable f365a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final x.a f366b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e7.h f367c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public o f368d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public OnBackInvokedCallback f369e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public OnBackInvokedDispatcher f370f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f371g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f372h;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public final class LifecycleOnBackPressedCancellable implements androidx.lifecycle.h, androidx.activity.c {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Lifecycle f373c;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final o f374e;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public androidx.activity.c f375m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final /* synthetic */ OnBackPressedDispatcher f376n;

        public LifecycleOnBackPressedCancellable(OnBackPressedDispatcher onBackPressedDispatcher, Lifecycle lifecycle, o onBackPressedCallback) {
            kotlin.jvm.internal.h.f(lifecycle, "lifecycle");
            kotlin.jvm.internal.h.f(onBackPressedCallback, "onBackPressedCallback");
            this.f376n = onBackPressedDispatcher;
            this.f373c = lifecycle;
            this.f374e = onBackPressedCallback;
            lifecycle.a(this);
        }

        @Override // androidx.activity.c
        public void cancel() {
            this.f373c.c(this);
            this.f374e.i(this);
            androidx.activity.c cVar = this.f375m;
            if (cVar != null) {
                cVar.cancel();
            }
            this.f375m = null;
        }

        @Override // androidx.lifecycle.h
        public void e(androidx.lifecycle.j source, Lifecycle.Event event) {
            kotlin.jvm.internal.h.f(source, "source");
            kotlin.jvm.internal.h.f(event, "event");
            if (event == Lifecycle.Event.ON_START) {
                this.f375m = this.f376n.i(this.f374e);
                return;
            }
            if (event != Lifecycle.Event.ON_STOP) {
                if (event == Lifecycle.Event.ON_DESTROY) {
                    cancel();
                }
            } else {
                androidx.activity.c cVar = this.f375m;
                if (cVar != null) {
                    cVar.cancel();
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f377a = new a();

        public static final void c(p7.a onBackInvoked) {
            kotlin.jvm.internal.h.f(onBackInvoked, "$onBackInvoked");
            onBackInvoked.invoke();
        }

        public final OnBackInvokedCallback b(final p7.a onBackInvoked) {
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

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f378a = new b();

        /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
        public static final class a implements OnBackAnimationCallback {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ p7.l f379a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ p7.l f380b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ p7.a f381c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ p7.a f382d;

            public a(p7.l lVar, p7.l lVar2, p7.a aVar, p7.a aVar2) {
                this.f379a = lVar;
                this.f380b = lVar2;
                this.f381c = aVar;
                this.f382d = aVar2;
            }

            @Override // android.window.OnBackAnimationCallback
            public void onBackCancelled() {
                this.f382d.invoke();
            }

            @Override // android.window.OnBackInvokedCallback
            public void onBackInvoked() {
                this.f381c.invoke();
            }

            @Override // android.window.OnBackAnimationCallback
            public void onBackProgressed(BackEvent backEvent) {
                kotlin.jvm.internal.h.f(backEvent, "backEvent");
                this.f380b.invoke(new androidx.activity.b(backEvent));
            }

            @Override // android.window.OnBackAnimationCallback
            public void onBackStarted(BackEvent backEvent) {
                kotlin.jvm.internal.h.f(backEvent, "backEvent");
                this.f379a.invoke(new androidx.activity.b(backEvent));
            }
        }

        public final OnBackInvokedCallback a(p7.l onBackStarted, p7.l onBackProgressed, p7.a onBackInvoked, p7.a onBackCancelled) {
            kotlin.jvm.internal.h.f(onBackStarted, "onBackStarted");
            kotlin.jvm.internal.h.f(onBackProgressed, "onBackProgressed");
            kotlin.jvm.internal.h.f(onBackInvoked, "onBackInvoked");
            kotlin.jvm.internal.h.f(onBackCancelled, "onBackCancelled");
            return new a(onBackStarted, onBackProgressed, onBackInvoked, onBackCancelled);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public final class c implements androidx.activity.c {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final o f383c;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ OnBackPressedDispatcher f384e;

        public c(OnBackPressedDispatcher onBackPressedDispatcher, o onBackPressedCallback) {
            kotlin.jvm.internal.h.f(onBackPressedCallback, "onBackPressedCallback");
            this.f384e = onBackPressedDispatcher;
            this.f383c = onBackPressedCallback;
        }

        @Override // androidx.activity.c
        public void cancel() {
            this.f384e.f367c.remove(this.f383c);
            if (kotlin.jvm.internal.h.a(this.f384e.f368d, this.f383c)) {
                this.f383c.c();
                this.f384e.f368d = null;
            }
            this.f383c.i(this);
            p7.a aVarB = this.f383c.b();
            if (aVarB != null) {
                aVarB.invoke();
            }
            this.f383c.k(null);
        }
    }

    public OnBackPressedDispatcher(Runnable runnable, x.a aVar) {
        this.f365a = runnable;
        this.f366b = aVar;
        this.f367c = new e7.h();
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 33) {
            this.f369e = i10 >= 34 ? b.f378a.a(new p7.l() { // from class: androidx.activity.OnBackPressedDispatcher.1
                {
                    super(1);
                }

                @Override // p7.l
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((androidx.activity.b) obj);
                    return d7.h.f3935a;
                }

                public final void invoke(androidx.activity.b backEvent) {
                    kotlin.jvm.internal.h.f(backEvent, "backEvent");
                    OnBackPressedDispatcher.this.m(backEvent);
                }
            }, new p7.l() { // from class: androidx.activity.OnBackPressedDispatcher.2
                {
                    super(1);
                }

                @Override // p7.l
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((androidx.activity.b) obj);
                    return d7.h.f3935a;
                }

                public final void invoke(androidx.activity.b backEvent) {
                    kotlin.jvm.internal.h.f(backEvent, "backEvent");
                    OnBackPressedDispatcher.this.l(backEvent);
                }
            }, new p7.a() { // from class: androidx.activity.OnBackPressedDispatcher.3
                {
                    super(0);
                }

                @Override // p7.a
                public /* bridge */ /* synthetic */ Object invoke() {
                    m0invoke();
                    return d7.h.f3935a;
                }

                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m0invoke() {
                    OnBackPressedDispatcher.this.k();
                }
            }, new p7.a() { // from class: androidx.activity.OnBackPressedDispatcher.4
                {
                    super(0);
                }

                @Override // p7.a
                public /* bridge */ /* synthetic */ Object invoke() {
                    m1invoke();
                    return d7.h.f3935a;
                }

                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m1invoke() {
                    OnBackPressedDispatcher.this.j();
                }
            }) : a.f377a.b(new p7.a() { // from class: androidx.activity.OnBackPressedDispatcher.5
                {
                    super(0);
                }

                @Override // p7.a
                public /* bridge */ /* synthetic */ Object invoke() {
                    m2invoke();
                    return d7.h.f3935a;
                }

                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m2invoke() {
                    OnBackPressedDispatcher.this.k();
                }
            });
        }
    }

    public final void h(androidx.lifecycle.j owner, o onBackPressedCallback) {
        kotlin.jvm.internal.h.f(owner, "owner");
        kotlin.jvm.internal.h.f(onBackPressedCallback, "onBackPressedCallback");
        Lifecycle lifecycleH0 = owner.h0();
        if (lifecycleH0.b() == Lifecycle.State.DESTROYED) {
            return;
        }
        onBackPressedCallback.a(new LifecycleOnBackPressedCancellable(this, lifecycleH0, onBackPressedCallback));
        p();
        onBackPressedCallback.k(new OnBackPressedDispatcher$addCallback$1(this));
    }

    public final androidx.activity.c i(o onBackPressedCallback) {
        kotlin.jvm.internal.h.f(onBackPressedCallback, "onBackPressedCallback");
        this.f367c.add(onBackPressedCallback);
        c cVar = new c(this, onBackPressedCallback);
        onBackPressedCallback.a(cVar);
        p();
        onBackPressedCallback.k(new OnBackPressedDispatcher$addCancellableCallback$1(this));
        return cVar;
    }

    public final void j() {
        Object objPrevious;
        o oVar = this.f368d;
        if (oVar == null) {
            e7.h hVar = this.f367c;
            ListIterator<E> listIterator = hVar.listIterator(hVar.size());
            do {
                if (!listIterator.hasPrevious()) {
                    objPrevious = null;
                    break;
                }
                objPrevious = listIterator.previous();
            } while (!((o) objPrevious).g());
            oVar = (o) objPrevious;
        }
        this.f368d = null;
        if (oVar != null) {
            oVar.c();
        }
    }

    public final void k() {
        Object objPrevious;
        o oVar = this.f368d;
        if (oVar == null) {
            e7.h hVar = this.f367c;
            ListIterator<E> listIterator = hVar.listIterator(hVar.size());
            do {
                if (!listIterator.hasPrevious()) {
                    objPrevious = null;
                    break;
                }
                objPrevious = listIterator.previous();
            } while (!((o) objPrevious).g());
            oVar = (o) objPrevious;
        }
        this.f368d = null;
        if (oVar != null) {
            oVar.d();
            return;
        }
        Runnable runnable = this.f365a;
        if (runnable != null) {
            runnable.run();
        }
    }

    public final void l(androidx.activity.b bVar) {
        Object objPrevious;
        o oVar = this.f368d;
        if (oVar == null) {
            e7.h hVar = this.f367c;
            ListIterator<E> listIterator = hVar.listIterator(hVar.size());
            do {
                if (!listIterator.hasPrevious()) {
                    objPrevious = null;
                    break;
                }
                objPrevious = listIterator.previous();
            } while (!((o) objPrevious).g());
            oVar = (o) objPrevious;
        }
        if (oVar != null) {
            oVar.e(bVar);
        }
    }

    public final void m(androidx.activity.b bVar) {
        Object objPrevious;
        e7.h hVar = this.f367c;
        ListIterator<E> listIterator = hVar.listIterator(hVar.size());
        do {
            if (!listIterator.hasPrevious()) {
                objPrevious = null;
                break;
            }
            objPrevious = listIterator.previous();
        } while (!((o) objPrevious).g());
        o oVar = (o) objPrevious;
        this.f368d = oVar;
        if (oVar != null) {
            oVar.f(bVar);
        }
    }

    public final void n(OnBackInvokedDispatcher invoker) {
        kotlin.jvm.internal.h.f(invoker, "invoker");
        this.f370f = invoker;
        o(this.f372h);
    }

    public final void o(boolean z10) {
        OnBackInvokedDispatcher onBackInvokedDispatcher = this.f370f;
        OnBackInvokedCallback onBackInvokedCallback = this.f369e;
        if (onBackInvokedDispatcher == null || onBackInvokedCallback == null) {
            return;
        }
        if (z10 && !this.f371g) {
            a.f377a.d(onBackInvokedDispatcher, 0, onBackInvokedCallback);
            this.f371g = true;
        } else {
            if (z10 || !this.f371g) {
                return;
            }
            a.f377a.e(onBackInvokedDispatcher, onBackInvokedCallback);
            this.f371g = false;
        }
    }

    public final void p() {
        boolean z10 = this.f372h;
        e7.h hVar = this.f367c;
        boolean z11 = false;
        if (!p.a(hVar) || !hVar.isEmpty()) {
            Iterator<E> it = hVar.iterator();
            while (it.hasNext()) {
                if (((o) it.next()).g()) {
                    z11 = true;
                    break;
                }
            }
        }
        this.f372h = z11;
        if (z11 != z10) {
            x.a aVar = this.f366b;
            if (aVar != null) {
                aVar.accept(Boolean.valueOf(z11));
            }
            if (Build.VERSION.SDK_INT >= 33) {
                o(z11);
            }
        }
    }

    public OnBackPressedDispatcher(Runnable runnable) {
        this(runnable, null);
    }
}
