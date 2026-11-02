package z8;

import android.R;
import android.content.Context;
import android.view.View;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import w5.k;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class h0 {
    public static /* synthetic */ void a(int[] iArr, Context context, w9.l lVar, p5.c cVar, na.h hVar, y9.a aVar, View view, k.p pVar) {
        int[] iArr2 = pVar.f13337a;
        int i10 = 0;
        if (iArr2 != null && iArr2.length > 0) {
            int i11 = 0;
            for (int i12 : iArr2) {
                i11 += iArr[i12];
            }
            if ((i11 & 1) != 0) {
                b0.k(context);
                b0.o(context);
                lVar.Y();
                if (cVar != null) {
                    cVar.t();
                }
                i10 = 1;
            }
            if ((i11 & 2) != 0) {
                b0.m(context);
                i10++;
            }
            if ((i11 & 4) != 0) {
                b0.n(context);
                w9.n.e().u(true);
                i10++;
            }
            if ((i11 & 64) != 0 && hVar != null) {
                h.b(new e0(hVar));
                i10++;
            }
            if ((i11 & 8) != 0) {
                b0.j();
                i10++;
            }
            if ((i11 & 16) != 0) {
                b0.l(context);
                i10++;
            }
            if ((i11 & 32) != 0) {
                b0.i(context);
                d(context, aVar);
                i10++;
            }
            if (i10 > 0) {
                g6.n.q(context, x7.u.S2);
            }
            i10 = i11;
        }
        lVar.I0(i10);
    }

    public static /* synthetic */ void b(int[] iArr, w9.l lVar, View view, k.p pVar) {
        int[] iArr2 = pVar.f13337a;
        int i10 = 0;
        if (iArr2 != null) {
            int length = iArr2.length;
            int i11 = 0;
            while (i10 < length) {
                i11 += iArr[iArr2[i10]];
                i10++;
            }
            i10 = i11;
        }
        lVar.N2(i10);
    }

    public static void c(Context context, w9.l lVar, p5.c cVar, na.h hVar, y9.a aVar) {
        int iL = lVar.l();
        if ((iL & 1) != 0 || System.currentTimeMillis() - lVar.C1() >= 432000000) {
            b0.k(context);
            b0.o(context);
            lVar.Y();
            if (cVar != null) {
                cVar.t();
            }
        }
        if ((iL & 2) != 0) {
            b0.m(context);
        }
        if ((iL & 4) != 0) {
            b0.n(context);
        }
        if ((iL & 64) != 0 && hVar != null) {
            h.b(new e0(hVar));
        }
        if ((iL & 8) != 0) {
            b0.j();
        }
        if ((iL & 16) != 0) {
            b0.l(context);
        }
        if ((iL & 32) != 0) {
            b0.i(context);
            d(context, aVar);
        }
    }

    public static void d(Context context, y9.a aVar) {
        List listH;
        if (aVar == null || (listH = aVar.h()) == null || listH.isEmpty()) {
            return;
        }
        HashSet hashSet = new HashSet();
        Iterator it = listH.iterator();
        while (it.hasNext()) {
            hashSet.add(((n9.b) it.next()).g());
        }
        w3.f(w3.m(context), hashSet);
    }

    public static void e(final Context context, final w9.l lVar, final p5.c cVar, final na.h hVar, final y9.a aVar) {
        final int[] iArr = {1, 2, 4, 64, 8, 16, 32};
        int[] iArr2 = new int[7];
        int iV = lVar.V();
        int i10 = 0;
        for (int i11 = 0; i11 < 7; i11++) {
            if ((iArr[i11] & iV) != 0) {
                iArr2[i10] = i11;
                i10++;
            }
        }
        w5.k.l(context).d0(x7.u.Z1).K(x7.j.f13645b, Arrays.copyOf(iArr2, i10)).V(R.string.ok, new k.m() { // from class: z8.f0
            @Override // w5.k.m
            public final void a(View view, k.p pVar) {
                h0.a(iArr, context, lVar, cVar, hVar, aVar, view, pVar);
            }
        }).N(R.string.cancel, null).f0();
    }

    public static void f(Context context, final w9.l lVar) {
        final int[] iArr = {1, 2, 4, 64, 8, 16, 32};
        int[] iArr2 = new int[7];
        int iL = lVar.l();
        int i10 = 0;
        for (int i11 = 0; i11 < 7; i11++) {
            if ((iArr[i11] & iL) != 0) {
                iArr2[i10] = i11;
                i10++;
            }
        }
        w5.k.l(context).d0(x7.u.f13903a2).K(x7.j.f13645b, Arrays.copyOf(iArr2, i10)).V(R.string.ok, new k.m() { // from class: z8.g0
            @Override // w5.k.m
            public final void a(View view, k.p pVar) {
                h0.b(iArr, lVar, view, pVar);
            }
        }).N(R.string.cancel, null).f0();
    }
}
