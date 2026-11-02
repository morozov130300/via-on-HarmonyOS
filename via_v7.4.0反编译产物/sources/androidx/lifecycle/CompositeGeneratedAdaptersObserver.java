package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class CompositeGeneratedAdaptersObserver implements f {

    /* renamed from: e, reason: collision with root package name */
    public final c[] f991e;

    public CompositeGeneratedAdaptersObserver(c[] generatedAdapters) {
        kotlin.jvm.internal.h.f(generatedAdapters, "generatedAdapters");
        this.f991e = generatedAdapters;
    }

    @Override // androidx.lifecycle.f
    public void a(h source, Lifecycle.Event event) {
        kotlin.jvm.internal.h.f(source, "source");
        kotlin.jvm.internal.h.f(event, "event");
        k kVar = new k();
        for (c cVar : this.f991e) {
            cVar.a(source, event, false, kVar);
        }
        for (c cVar2 : this.f991e) {
            cVar2.a(source, event, true, kVar);
        }
    }
}
