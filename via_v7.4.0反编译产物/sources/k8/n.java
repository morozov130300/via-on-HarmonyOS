package k8;

import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class n extends androidx.lifecycle.l {

    /* renamed from: l, reason: collision with root package name */
    public final AtomicBoolean f8216l = new AtomicBoolean(false);

    public static /* synthetic */ void n(n nVar, androidx.lifecycle.m mVar, Object obj) {
        if (nVar.f8216l.compareAndSet(true, false)) {
            mVar.a(obj);
        }
    }

    @Override // androidx.lifecycle.LiveData
    public void g(androidx.lifecycle.h hVar, final androidx.lifecycle.m mVar) {
        if (f()) {
            pc.a.h("Multiple observers registered but only one will be notified of changes.", new Object[0]);
        }
        super.g(hVar, new androidx.lifecycle.m() { // from class: k8.m
            @Override // androidx.lifecycle.m
            public final void a(Object obj) {
                n.n(this.f8214a, mVar, obj);
            }
        });
    }

    @Override // androidx.lifecycle.l, androidx.lifecycle.LiveData
    public void m(Object obj) {
        this.f8216l.set(true);
        super.m(obj);
    }

    public void o() {
        m(null);
    }
}
