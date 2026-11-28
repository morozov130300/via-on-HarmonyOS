package p3;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile d f11568b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set f11569a = new HashSet();

    public static d a() {
        d dVar;
        d dVar2 = f11568b;
        if (dVar2 != null) {
            return dVar2;
        }
        synchronized (d.class) {
            try {
                dVar = f11568b;
                if (dVar == null) {
                    dVar = new d();
                    f11568b = dVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return dVar;
    }

    public Set b() {
        Set setUnmodifiableSet;
        synchronized (this.f11569a) {
            setUnmodifiableSet = Collections.unmodifiableSet(this.f11569a);
        }
        return setUnmodifiableSet;
    }
}
