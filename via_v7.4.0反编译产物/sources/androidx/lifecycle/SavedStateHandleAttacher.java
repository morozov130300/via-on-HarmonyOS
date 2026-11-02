package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class SavedStateHandleAttacher implements f {

    /* renamed from: e, reason: collision with root package name */
    public final SavedStateHandlesProvider f1023e;

    public SavedStateHandleAttacher(SavedStateHandlesProvider provider) {
        kotlin.jvm.internal.h.f(provider, "provider");
        this.f1023e = provider;
    }

    @Override // androidx.lifecycle.f
    public void a(h source, Lifecycle.Event event) {
        kotlin.jvm.internal.h.f(source, "source");
        kotlin.jvm.internal.h.f(event, "event");
        if (event == Lifecycle.Event.ON_CREATE) {
            source.k0().c(this);
            this.f1023e.d();
        } else {
            throw new IllegalStateException(("Next event must be ON_CREATE, it was " + event).toString());
        }
    }
}
