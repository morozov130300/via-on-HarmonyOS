package g2;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class v implements Runnable {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ f f6180e;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ w f6181j;

    public v(w wVar, f fVar) {
        this.f6181j = wVar;
        this.f6180e = fVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f6181j.f6183b) {
            try {
                w wVar = this.f6181j;
                if (wVar.f6184c != null) {
                    wVar.f6184c.onSuccess(this.f6180e.h());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
