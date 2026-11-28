package b8;

import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static d f1780b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap f1781a = new HashMap();

    public static d c() {
        if (f1780b == null) {
            f1780b = new d();
        }
        return f1780b;
    }

    public boolean a(int i10, int i11, String str, boolean z10, boolean z11) {
        c cVarE = e(i10);
        cVarE.a(i11, str, z10, z11);
        return !cVarE.e();
    }

    public void b(int i10) {
        e(i10).b();
    }

    public List d(int i10) {
        return e(i10).c();
    }

    public final c e(int i10) {
        c cVar = (c) this.f1781a.get(Integer.valueOf(i10));
        if (cVar != null) {
            return cVar;
        }
        c cVar2 = new c();
        this.f1781a.put(Integer.valueOf(i10), cVar2);
        return cVar2;
    }

    public boolean f(int i10) {
        return !e(i10).d();
    }

    public boolean g(int i10) {
        return !e(i10).e();
    }

    public void h(int i10, int i11) {
        e(i10).f(i11);
    }

    public void i(int i10, int i11, String str) {
        c cVarE = e(i10);
        cVarE.b();
        cVarE.h(i11);
        cVarE.g(p9.a.a().s(str));
    }
}
