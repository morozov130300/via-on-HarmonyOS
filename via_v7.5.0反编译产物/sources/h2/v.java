package h2;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class v implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ f f5677c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ w f5678e;

    public v(w wVar, f fVar) {
        this.f5678e = wVar;
        this.f5677c = fVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f5678e.f5680b) {
            try {
                w wVar = this.f5678e;
                if (wVar.f5681c != null) {
                    wVar.f5681c.onSuccess(this.f5677c.h());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
