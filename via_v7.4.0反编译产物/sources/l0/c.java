package l0;

import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import androidx.savedstate.Recreator;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.h;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: d, reason: collision with root package name */
    public static final a f8310d = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final d f8311a;

    /* renamed from: b, reason: collision with root package name */
    public final androidx.savedstate.a f8312b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f8313c;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final c a(d owner) {
            h.f(owner, "owner");
            return new c(owner, null);
        }
    }

    public c(d dVar) {
        this.f8311a = dVar;
        this.f8312b = new androidx.savedstate.a();
    }

    public /* synthetic */ c(d dVar, f fVar) {
        this(dVar);
    }

    public static final c a(d dVar) {
        return f8310d.a(dVar);
    }

    public final androidx.savedstate.a b() {
        return this.f8312b;
    }

    public final void c() {
        Lifecycle lifecycleK0 = this.f8311a.k0();
        if (lifecycleK0.b() != Lifecycle.State.INITIALIZED) {
            throw new IllegalStateException("Restarter must be created only during owner's initialization stage");
        }
        lifecycleK0.a(new Recreator(this.f8311a));
        this.f8312b.e(lifecycleK0);
        this.f8313c = true;
    }

    public final void d(Bundle bundle) {
        if (!this.f8313c) {
            c();
        }
        Lifecycle lifecycleK0 = this.f8311a.k0();
        if (!lifecycleK0.b().isAtLeast(Lifecycle.State.STARTED)) {
            this.f8312b.f(bundle);
            return;
        }
        throw new IllegalStateException(("performRestore cannot be called when owner is " + lifecycleK0.b()).toString());
    }

    public final void e(Bundle outBundle) {
        h.f(outBundle, "outBundle");
        this.f8312b.g(outBundle);
    }
}
