package ub;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class b implements Runnable {

    /* renamed from: e, reason: collision with root package name */
    public final String f12934e;

    public b(String str, Object... objArr) {
        this.f12934e = c.r(str, objArr);
    }

    public abstract void k();

    @Override // java.lang.Runnable
    public final void run() {
        String name = Thread.currentThread().getName();
        Thread.currentThread().setName(this.f12934e);
        try {
            k();
        } finally {
            Thread.currentThread().setName(name);
        }
    }
}
