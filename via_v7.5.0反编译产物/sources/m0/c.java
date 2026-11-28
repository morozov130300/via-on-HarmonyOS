package m0;

import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import androidx.savedstate.Recreator;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.h;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f7784d = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f7785a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final androidx.savedstate.a f7786b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f7787c;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class a {
        public /* synthetic */ a(f fVar) {
            this();
        }

        public final c a(d owner) {
            h.f(owner, "owner");
            return new c(owner, null);
        }

        public a() {
        }
    }

    public /* synthetic */ c(d dVar, f fVar) {
        this(dVar);
    }

    public static final c a(d dVar) {
        return f7784d.a(dVar);
    }

    public final androidx.savedstate.a b() {
        return this.f7786b;
    }

    public final void c() {
        Lifecycle lifecycleH0 = this.f7785a.h0();
        if (lifecycleH0.b() != Lifecycle.State.INITIALIZED) {
            throw new IllegalStateException("Restarter must be created only during owner's initialization stage");
        }
        lifecycleH0.a(new Recreator(this.f7785a));
        this.f7786b.e(lifecycleH0);
        this.f7787c = true;
    }

    public final void d(Bundle bundle) {
        if (!this.f7787c) {
            c();
        }
        Lifecycle lifecycleH0 = this.f7785a.h0();
        if (!lifecycleH0.b().isAtLeast(Lifecycle.State.STARTED)) {
            this.f7786b.f(bundle);
            return;
        }
        throw new IllegalStateException(("performRestore cannot be called when owner is " + lifecycleH0.b()).toString());
    }

    public final void e(Bundle outBundle) {
        h.f(outBundle, "outBundle");
        this.f7786b.g(outBundle);
    }

    public c(d dVar) {
        this.f7785a = dVar;
        this.f7786b = new androidx.savedstate.a();
    }
}
