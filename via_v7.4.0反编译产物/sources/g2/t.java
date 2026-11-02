package g2;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class t implements Runnable {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ f f6175e;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ u f6176j;

    public t(u uVar, f fVar) {
        this.f6176j = uVar;
        this.f6175e = fVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f6176j.f6178b) {
            try {
                u uVar = this.f6176j;
                if (uVar.f6179c != null) {
                    uVar.f6179c.c((Exception) t1.f.h(this.f6175e.g()));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
