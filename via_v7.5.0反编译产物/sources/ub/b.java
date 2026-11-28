package ub;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class b implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f12944c;

    public b(String str, Object... objArr) {
        this.f12944c = c.r(str, objArr);
    }

    public abstract void k();

    @Override // java.lang.Runnable
    public final void run() {
        String name = Thread.currentThread().getName();
        Thread.currentThread().setName(this.f12944c);
        try {
            k();
        } finally {
            Thread.currentThread().setName(name);
        }
    }
}
