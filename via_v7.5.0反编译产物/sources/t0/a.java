package t0;

import u6.d;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile d f12317a;

    public static boolean a(d dVar) {
        if (dVar == null) {
            throw new NullPointerException("defaultChecker == null");
        }
        d dVar2 = f12317a;
        try {
            return dVar2 == null ? dVar.a() : dVar2.a();
        } catch (Throwable th) {
            throw t6.a.a(th);
        }
    }
}
