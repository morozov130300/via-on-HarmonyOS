package s0;

import java.lang.reflect.Array;
import java.util.List;
import java.util.concurrent.Executor;
import org.chromium.support_lib_boundary.ProxyControllerBoundaryInterface;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class m extends r0.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ProxyControllerBoundaryInterface f12142a;

    public static String[][] e(List list) {
        String[][] strArr = (String[][]) Array.newInstance((Class<?>) String.class, list.size(), 2);
        for (int i10 = 0; i10 < list.size(); i10++) {
            strArr[i10][0] = ((r0.d.b) list.get(i10)).a();
            strArr[i10][1] = ((r0.d.b) list.get(i10)).b();
        }
        return strArr;
    }

    @Override // r0.e
    public void a(Executor executor, Runnable runnable) {
        if (!v.R.d()) {
            throw v.a();
        }
        d().clearProxyOverride(runnable, executor);
    }

    @Override // r0.e
    public void c(r0.d dVar, Executor executor, Runnable runnable) {
        a.d dVar2 = v.R;
        a.d dVar3 = v.X;
        String[][] strArrE = e(dVar.b());
        String[] strArr = (String[]) dVar.a().toArray(new String[0]);
        if (dVar2.d() && !dVar.c()) {
            d().setProxyOverride(strArrE, strArr, runnable, executor);
        } else {
            if (!dVar2.d() || !dVar3.d()) {
                throw v.a();
            }
            d().setProxyOverride(strArrE, strArr, runnable, executor, dVar.c());
        }
    }

    public final ProxyControllerBoundaryInterface d() {
        if (this.f12142a == null) {
            this.f12142a = w.d().getProxyController();
        }
        return this.f12142a;
    }
}
