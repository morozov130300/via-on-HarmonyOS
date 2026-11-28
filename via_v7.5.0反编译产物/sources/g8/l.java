package g8;

import android.content.Context;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class l {
    public static f8.a a(Context context, int i10) {
        switch (i10) {
            case 1:
                return b(context, i10, w7.o.F0, w7.u.Xe, w7.u.Q, true, false);
            case 2:
                return b(context, i10, w7.o.f13840w, w7.u.Je, w7.u.f14092j, true, false);
            case 3:
                return b(context, i10, w7.o.f13820p0, w7.u.Se, w7.u.I, true, false);
            case 4:
                return b(context, i10, w7.o.H, w7.u.Ne, w7.u.D, true, false);
            case 5:
                return b(context, i10, w7.o.f13835u0, w7.u.Ue, w7.u.J, true, false);
            case 6:
                return b(context, i10, w7.o.f13812m1, w7.u.mf, w7.u.f14037f0, true, false);
            case 7:
                return b(context, i10, w7.o.f13813n, w7.u.Fe, w7.u.f13994c, true, false);
            case 8:
                return b(context, i10, w7.o.E, w7.u.Me, w7.u.U, true, false);
            case 9:
                return b(context, i10, w7.o.B1, w7.u.of, w7.u.f14065h0, true, false);
            case 10:
                return b(context, i10, w7.o.f13806k1, w7.u.lf, w7.u.Bc, true, false);
            case 11:
                return b(context, i10, w7.o.f13781c0, w7.u.Oe, w7.u.G, true, false);
            case 12:
                return b(context, i10, w7.o.f13785d1, w7.u.gf, w7.u.f13967a0, true, false);
            case 13:
                return b(context, i10, w7.o.G0, w7.u.hf, w7.u.f14009d0, true, false);
            case 14:
                return b(context, i10, w7.o.D1, w7.u.pf, w7.u.f14079i0, true, false);
            case 15:
                return b(context, i10, w7.o.G1, w7.u.rf, w7.u.f14051g0, true, false);
            case 16:
                return b(context, i10, w7.o.f13805k0, w7.u.Qe, w7.u.H, true, false);
            case 17:
                return b(context, i10, w7.o.f13829s0, w7.u.Te, w7.u.I6, true, false);
            case 18:
                return b(context, i10, w7.o.Z0, w7.u.ef, w7.u.f14271vb, true, false);
            case 19:
                return b(context, i10, w7.o.F1, w7.u.qf, w7.u.F0, true, false);
            case 20:
                return b(context, i10, w7.o.D0, w7.u.We, w7.u.Q8, true, false);
            case 21:
            case 22:
            default:
                return b(context, 22, 0, 0, 0, true, false);
            case 23:
                return b(context, i10, w7.o.B0, w7.u.Ve, w7.u.M, true, false);
            case 24:
                return b(context, i10, w7.o.W0, w7.u.cf, w7.u.Y9, true, false);
            case 25:
                return b(context, i10, w7.o.f13791f1, w7.u.jf, w7.u.Qb, true, false);
            case 26:
                return b(context, i10, w7.o.f13815n1, w7.u.nf, w7.u.Xc, true, false);
            case 27:
                return b(context, i10, w7.o.f13794g1, w7.u.kf, w7.u.Ic, true, false);
            case 28:
                return b(context, i10, w7.o.f13807l, w7.u.Ee, w7.u.G1, true, false);
            case 29:
                return b(context, i10, w7.o.f13796h0, w7.u.Pe, w7.u.ed, true, false);
            case 30:
                return b(context, i10, w7.o.f13782c1, w7.u.ff, w7.u.f13991ba, true, false);
            case 31:
                return b(context, i10, w7.o.D, w7.u.Le, w7.u.f14137m2, true, false);
            case 32:
                return b(context, i10, w7.o.O0, w7.u.Ze, w7.u.La, true, false);
            case 33:
                return b(context, i10, w7.o.S0, w7.u.af, w7.u.Ua, true, false);
            case 34:
                return b(context, i10, w7.o.f13819p, w7.u.He, w7.u.A0, true, false);
            case 35:
                return b(context, i10, w7.o.J, w7.u.Ke, w7.u.f14012d3, true, false);
            case 36:
                return b(context, i10, w7.o.U0, w7.u.bf, w7.u.Za, true, false);
            case 37:
                return b(context, i10, w7.o.H0, w7.u.Ye, w7.u.H9, true, false);
            case 38:
                return b(context, i10, w7.o.f13808l0, w7.u.Re, w7.u.f14001c6, true, false);
            case 39:
                return b(context, i10, w7.o.A, w7.u.Ie, w7.u.R0, true, false);
            case 40:
                return b(context, i10, w7.o.f13816o, w7.u.Ge, w7.u.f14008d, true, false);
            case 41:
                return b(context, i10, w7.o.X0, w7.u.df, w7.u.f14076hb, true, false);
        }
    }

    public static f8.a b(Context context, int i10, int i11, int i12, int i13, boolean z10, boolean z11) {
        return new f8.a(i10, lb.g.a(context, i11, i12), i13 == 0 ? null : context.getString(i13), z10, z11);
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
