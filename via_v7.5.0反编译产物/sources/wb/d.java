package wb;

import java.util.LinkedHashSet;
import java.util.Set;
import okhttp3.a0;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set f14429a = new LinkedHashSet();

    public synchronized void a(a0 a0Var) {
        this.f14429a.remove(a0Var);
    }

    public synchronized void b(a0 a0Var) {
        this.f14429a.add(a0Var);
    }

    public synchronized boolean c(a0 a0Var) {
        return this.f14429a.contains(a0Var);
    }
}
