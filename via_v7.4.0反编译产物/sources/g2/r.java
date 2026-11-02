package g2;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class r implements Runnable {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ s f6171e;

    public r(s sVar) {
        this.f6171e = sVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f6171e.f6173b) {
            try {
                s sVar = this.f6171e;
                if (sVar.f6174c != null) {
                    sVar.f6174c.b();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
