package r0;

import java.lang.reflect.Array;
import java.util.List;
import java.util.concurrent.Executor;
import org.chromium.support_lib_boundary.ProxyControllerBoundaryInterface;
import q0.b;
import r0.a;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class k extends q0.c {

    /* renamed from: a, reason: collision with root package name */
    public ProxyControllerBoundaryInterface f11475a;

    public static String[][] e(List list) {
        String[][] strArr = (String[][]) Array.newInstance((Class<?>) String.class, list.size(), 2);
        for (int i10 = 0; i10 < list.size(); i10++) {
            strArr[i10][0] = ((b.C0114b) list.get(i10)).a();
            strArr[i10][1] = ((b.C0114b) list.get(i10)).b();
        }
        return strArr;
    }

    @Override // q0.c
    public void a(Executor executor, Runnable runnable) {
        if (!o.Q.d()) {
            throw o.a();
        }
        d().clearProxyOverride(runnable, executor);
    }

    @Override // q0.c
    public void c(q0.b bVar, Executor executor, Runnable runnable) {
        a.d dVar = o.Q;
        a.d dVar2 = o.W;
        String[][] strArrE = e(bVar.b());
        String[] strArr = (String[]) bVar.a().toArray(new String[0]);
        if (dVar.d() && !bVar.c()) {
            d().setProxyOverride(strArrE, strArr, runnable, executor);
        } else {
            if (!dVar.d() || !dVar2.d()) {
                throw o.a();
            }
            d().setProxyOverride(strArrE, strArr, runnable, executor, bVar.c());
        }
    }

    public final ProxyControllerBoundaryInterface d() {
        if (this.f11475a == null) {
            this.f11475a = p.d().getProxyController();
        }
        return this.f11475a;
    }
}
