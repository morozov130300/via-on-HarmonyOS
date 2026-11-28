package d;

import android.content.Context;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.jvm.internal.h;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set f3792a = new CopyOnWriteArraySet();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile Context f3793b;

    public final void a(b listener) {
        h.f(listener, "listener");
        Context context = this.f3793b;
        if (context != null) {
            listener.a(context);
        }
        this.f3792a.add(listener);
    }

    public final void b() {
        this.f3793b = null;
    }

    public final void c(Context context) {
        h.f(context, "context");
        this.f3793b = context;
        Iterator it = this.f3792a.iterator();
        while (it.hasNext()) {
            ((b) it.next()).a(context);
        }
    }
}
