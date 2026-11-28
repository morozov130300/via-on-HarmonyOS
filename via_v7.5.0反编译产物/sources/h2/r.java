package h2;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class r implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ s f5668c;

    public r(s sVar) {
        this.f5668c = sVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f5668c.f5670b) {
            try {
                s sVar = this.f5668c;
                if (sVar.f5671c != null) {
                    sVar.f5671c.b();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
