package i8;

import android.content.Context;
import java.util.HashSet;
import java.util.Set;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class l {
    public static h8.a a(Context context, int i10) {
        switch (i10) {
            case 1:
                return b(context, i10, x7.o.H0, x7.u.He, x7.u.P, true, false);
            case 2:
                return b(context, i10, x7.o.f13777x, x7.u.te, x7.u.f14026j, true, false);
            case WebSettingsBoundaryInterface.AttributionBehavior.APP_SOURCE_AND_APP_TRIGGER /* 3 */:
                return b(context, i10, x7.o.f13751o0, x7.u.Ce, x7.u.H, true, false);
            case 4:
                return b(context, i10, x7.o.I, x7.u.xe, x7.u.C, true, false);
            case 5:
                return b(context, i10, x7.o.f13766t0, x7.u.Ee, x7.u.I, true, false);
            case 6:
                return b(context, i10, x7.o.f13752o1, x7.u.Ve, x7.u.f13943d0, true, false);
            case 7:
                return b(context, i10, x7.o.f13750o, x7.u.pe, x7.u.f13928c, true, false);
            case 8:
                return b(context, i10, x7.o.F, x7.u.we, x7.u.T, true, false);
            case 9:
                return b(context, i10, x7.o.D1, x7.u.Xe, x7.u.f13971f0, true, false);
            case 10:
                return b(context, i10, x7.o.f13746m1, x7.u.Ue, x7.u.f14095nc, true, false);
            case 11:
                return b(context, i10, x7.o.f13718d0, x7.u.ye, x7.u.F, true, false);
            case 12:
                return b(context, i10, x7.o.f13725f1, x7.u.Qe, x7.u.Z, true, false);
            case 13:
                return b(context, i10, x7.o.I0, x7.u.Re, x7.u.f13929c0, true, false);
            case 14:
                return b(context, i10, x7.o.G1, x7.u.Ye, x7.u.f13985g0, true, false);
            case 15:
                return b(context, i10, x7.o.J1, x7.u.af, x7.u.f13957e0, true, false);
            case 16:
                return b(context, i10, x7.o.f13739k0, x7.u.Ae, x7.u.G, true, false);
            case 17:
                return b(context, i10, x7.o.f13760r0, x7.u.De, x7.u.f14209w6, true, false);
            case 18:
                return b(context, i10, x7.o.f13713b1, x7.u.Oe, x7.u.f14038jb, true, false);
            case 19:
                return b(context, i10, x7.o.I1, x7.u.Ze, x7.u.C0, true, false);
            case 20:
                return b(context, i10, x7.o.F0, x7.u.Ge, x7.u.E8, true, false);
            case 21:
            case 22:
            default:
                return b(context, 22, 0, 0, 0, true, false);
            case 23:
                return b(context, i10, x7.o.D0, x7.u.Fe, x7.u.L, true, false);
            case 24:
                return b(context, i10, x7.o.Y0, x7.u.Me, x7.u.M9, true, false);
            case 25:
                return b(context, i10, x7.o.f13731h1, x7.u.Se, x7.u.Db, true, false);
            case 26:
                return b(context, i10, x7.o.f13755p1, x7.u.We, x7.u.Ic, true, false);
            case 27:
                return b(context, i10, x7.o.f13734i1, x7.u.Te, x7.u.uc, true, false);
            case 28:
                return b(context, i10, x7.o.f13744m, x7.u.oe, x7.u.f14165t1, true, false);
            case 29:
                return b(context, i10, x7.o.f13730h0, x7.u.ze, x7.u.Pc, true, false);
            case 30:
                return b(context, i10, x7.o.f13722e1, x7.u.Pe, x7.u.P9, true, false);
            case 31:
                return b(context, i10, x7.o.E, x7.u.ve, x7.u.Z1, true, false);
            case 32:
                return b(context, i10, x7.o.Q0, x7.u.Je, x7.u.f14252za, true, false);
            case 33:
                return b(context, i10, x7.o.U0, x7.u.Ke, x7.u.Ia, true, false);
            case 34:
                return b(context, i10, x7.o.f13756q, x7.u.re, x7.u.f14229y0, true, false);
            case 35:
                return b(context, i10, x7.o.K, x7.u.ue, x7.u.R2, true, false);
            case 36:
                return b(context, i10, x7.o.W0, x7.u.Le, x7.u.Na, true, false);
            case 37:
                return b(context, i10, x7.o.J0, x7.u.Ie, x7.u.f14199v9, true, false);
            case 38:
                return b(context, i10, x7.o.f13742l0, x7.u.Be, x7.u.Q5, true, false);
            case 39:
                return b(context, i10, x7.o.B, x7.u.se, x7.u.O0, true, false);
            case 40:
                return b(context, i10, x7.o.f13753p, x7.u.qe, x7.u.f13942d, true, false);
            case 41:
                return b(context, i10, x7.o.Z0, x7.u.Ne, x7.u.Va, true, false);
        }
    }

    public static h8.a b(Context context, int i10, int i11, int i12, int i13, boolean z10, boolean z11) {
        return new h8.a(i10, lb.b.a(context, i11, i12), i13 == 0 ? null : context.getString(i13), z10, z11);
    }

    public static Set c() {
        HashSet hashSet = new HashSet();
        int[] iArr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 24, 25, 26, 23, 27, 28, 29, 30, 31, 32, 33, 40, 34, 35, 36, 37, 38, 39, 41};
        for (int i10 = 0; i10 < 39; i10++) {
            hashSet.add(Integer.valueOf(iArr[i10]));
        }
        return hashSet;
    }
}
