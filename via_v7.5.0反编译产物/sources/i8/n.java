package i8;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class n extends androidx.lifecycle.n {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final AtomicBoolean f6327l = new AtomicBoolean(false);

    public static /* synthetic */ void n(n nVar, androidx.lifecycle.o oVar, Object obj) {
        if (nVar.f6327l.compareAndSet(true, false)) {
            oVar.a(obj);
        }
    }

    @Override // androidx.lifecycle.LiveData
    public void g(androidx.lifecycle.j jVar, final androidx.lifecycle.o oVar) {
        if (f()) {
            tc.a.i("Multiple observers registered but only one will be notified of changes.", new Object[0]);
        }
        super.g(jVar, new androidx.lifecycle.o() { // from class: i8.m
            @Override // androidx.lifecycle.o
            public final void a(Object obj) {
                n.n(this.f6325a, oVar, obj);
            }
        });
    }

    @Override // androidx.lifecycle.n, androidx.lifecycle.LiveData
    public void m(Object obj) {
        this.f6327l.set(true);
        super.m(obj);
    }

    public void o() {
        m(null);
    }
}
