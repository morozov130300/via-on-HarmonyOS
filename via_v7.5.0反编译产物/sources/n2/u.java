package n2;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class u implements j3.b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Object f10570c = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile Object f10571a = f10570c;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile j3.b f10572b;

    public u(j3.b bVar) {
        this.f10572b = bVar;
    }

    @Override // j3.b
    public Object get() {
        Object obj;
        Object obj2 = this.f10571a;
        Object obj3 = f10570c;
        if (obj2 != obj3) {
            return obj2;
        }
        synchronized (this) {
            try {
                obj = this.f10571a;
                if (obj == obj3) {
                    obj = this.f10572b.get();
                    this.f10571a = obj;
                    this.f10572b = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return obj;
    }
}
