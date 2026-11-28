package androidx.fragment.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class w extends s {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Activity f875c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Context f876e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Handler f877m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f878n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final FragmentManager f879o;

    public w(Activity activity, Context context, Handler handler, int i10) {
        kotlin.jvm.internal.h.f(context, "context");
        kotlin.jvm.internal.h.f(handler, "handler");
        this.f875c = activity;
        this.f876e = context;
        this.f877m = handler;
        this.f878n = i10;
        this.f879o = new f0();
    }

    public final Activity p() {
        return this.f875c;
    }

    public final Context q() {
        return this.f876e;
    }

    public final FragmentManager r() {
        return this.f879o;
    }

    public final Handler s() {
        return this.f877m;
    }

    public abstract void t(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    public abstract Object u();

    public abstract LayoutInflater v();

    public void w(Fragment fragment, String[] permissions, int i10) {
        kotlin.jvm.internal.h.f(fragment, "fragment");
        kotlin.jvm.internal.h.f(permissions, "permissions");
    }

    public void x(Fragment fragment, Intent intent, int i10, Bundle bundle) {
        kotlin.jvm.internal.h.f(fragment, "fragment");
        kotlin.jvm.internal.h.f(intent, "intent");
        if (i10 != -1) {
            throw new IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host");
        }
        o.a.k(this.f876e, intent, bundle);
    }

    public abstract void y();

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public w(q activity) {
        this(activity, activity, new Handler(), 0);
        kotlin.jvm.internal.h.f(activity, "activity");
    }
}
