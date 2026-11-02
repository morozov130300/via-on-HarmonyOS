package androidx.fragment.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class w extends s {

    /* renamed from: e, reason: collision with root package name */
    public final Activity f974e;

    /* renamed from: j, reason: collision with root package name */
    public final Context f975j;

    /* renamed from: k, reason: collision with root package name */
    public final Handler f976k;

    /* renamed from: l, reason: collision with root package name */
    public final int f977l;

    /* renamed from: m, reason: collision with root package name */
    public final FragmentManager f978m;

    public w(Activity activity, Context context, Handler handler, int i10) {
        kotlin.jvm.internal.h.f(context, "context");
        kotlin.jvm.internal.h.f(handler, "handler");
        this.f974e = activity;
        this.f975j = context;
        this.f976k = handler;
        this.f977l = i10;
        this.f978m = new f0();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public w(q activity) {
        this(activity, activity, new Handler(), 0);
        kotlin.jvm.internal.h.f(activity, "activity");
    }

    public final Activity q() {
        return this.f974e;
    }

    public final Context r() {
        return this.f975j;
    }

    public final FragmentManager s() {
        return this.f978m;
    }

    public final Handler t() {
        return this.f976k;
    }

    public abstract void u(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    public abstract Object v();

    public abstract LayoutInflater w();

    public void x(Fragment fragment, String[] permissions, int i10) {
        kotlin.jvm.internal.h.f(fragment, "fragment");
        kotlin.jvm.internal.h.f(permissions, "permissions");
    }

    public void y(Fragment fragment, Intent intent, int i10, Bundle bundle) {
        kotlin.jvm.internal.h.f(fragment, "fragment");
        kotlin.jvm.internal.h.f(intent, "intent");
        if (i10 != -1) {
            throw new IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host");
        }
        o.a.k(this.f975j, intent, bundle);
    }

    public abstract void z();
}
