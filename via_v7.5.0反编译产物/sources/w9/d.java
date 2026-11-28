package w9;

import java.util.HashMap;
import la.s;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class d implements e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static d f14387c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap f14388a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ga.d f14389b = s.f().z();

    public static e d() {
        if (f14387c == null) {
            synchronized (d.class) {
                try {
                    if (f14387c == null) {
                        f14387c = new d();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f14387c;
    }

    @Override // w9.e
    public boolean a() {
        this.f14388a.clear();
        return true;
    }

    @Override // w9.e
    public boolean b(int i10) {
        this.f14388a.remove(Integer.valueOf(i10));
        return true;
    }

    @Override // w9.e
    public String c(int i10) {
        String strA = (String) this.f14388a.get(Integer.valueOf(i10));
        if (strA == null) {
            ga.c cVarC = this.f14389b.c(i10);
            if (cVarC == null || cVarC.h() != 1) {
                this.f14388a.put(Integer.valueOf(i10), "");
            } else {
                strA = cVarC.a();
                this.f14388a.put(Integer.valueOf(i10), strA);
            }
        }
        if (strA == null || strA.isEmpty()) {
            return null;
        }
        return strA;
    }
}
