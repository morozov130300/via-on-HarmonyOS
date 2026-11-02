package d;

import android.content.Context;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.jvm.internal.h;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final Set f4427a = new CopyOnWriteArraySet();

    /* renamed from: b, reason: collision with root package name */
    public volatile Context f4428b;

    public final void a(b listener) {
        h.f(listener, "listener");
        Context context = this.f4428b;
        if (context != null) {
            listener.a(context);
        }
        this.f4427a.add(listener);
    }

    public final void b() {
        this.f4428b = null;
    }

    public final void c(Context context) {
        h.f(context, "context");
        this.f4428b = context;
        Iterator it = this.f4427a.iterator();
        while (it.hasNext()) {
            ((b) it.next()).a(context);
        }
    }
}
