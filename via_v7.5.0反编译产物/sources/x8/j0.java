package x8;

import android.content.Context;
import mark.via.browser.kd;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class j0 {
    public static oa.k1 a() {
        return kd.c();
    }

    public static boolean b() {
        qa.c cVarF = a().f();
        ra.c cVarR = cVarF.r("fa6f3153b591e06fbf0170d935ad0afe");
        return cVarR != null ? cVarR.j() : cVarF.t(-99);
    }

    public static void c(boolean z10, boolean z11) {
        qa.c cVarF = a().f();
        ra.c cVarR = cVarF.r("fa6f3153b591e06fbf0170d935ad0afe");
        if (cVarR != null) {
            if (z11) {
                return;
            }
            cVarF.l(cVarR.e(), z10);
        } else {
            if (cVarF.w(-99, z10) || !z10) {
                return;
            }
            final c6.g gVar = c6.g.f2003a;
            ra.a aVarE = ra.a.e(gVar.b(), null);
            if (aVarE == null) {
                return;
            }
            aVarE.g(-99);
            cVarF.v(aVarE, gVar.c(), new x.h() { // from class: x8.h0
                @Override // x.h
                public final Object get() {
                    return gVar.a();
                }
            });
        }
    }

    public static void d(Context context, boolean z10) {
        qa.c cVarF = a().f();
        if (cVarF.w(-101, z10) || !z10) {
            return;
        }
        final c6.x1 x1Var = c6.x1.f2137a;
        ra.a aVarE = ra.a.e(x1Var.g(), null);
        if (aVarE == null) {
            return;
        }
        aVarE.a().A("434ac3d1c485c21999283f07f207746d");
        aVarE.a().y(x3.b(context));
        aVarE.g(-101);
        cVarF.v(aVarE, x1Var.h(), new x.h() { // from class: x8.i0
            @Override // x.h
            public final Object get() {
                return x1Var.f();
            }
        });
    }
}
