package x8;

import android.R;
import android.content.Context;
import android.view.View;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class f0 {
    public static /* synthetic */ void a(int[] iArr, u9.l lVar, View view, q5.k.p pVar) {
        int[] iArr2 = pVar.f11817a;
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
        lVar.R2(i10);
    }

    public static /* synthetic */ void b(int[] iArr, Context context, u9.l lVar, qa.c cVar, ka.h hVar, w9.a aVar, View view, q5.k.p pVar) {
        int[] iArr2 = pVar.f11817a;
        int i10 = 0;
        if (iArr2 != null && iArr2.length > 0) {
            int i11 = 0;
            for (int i12 : iArr2) {
                i11 += iArr[i12];
            }
            if ((i11 & 1) != 0) {
                z.k(context);
                z.o(context);
                lVar.b0();
                if (cVar != null) {
                    cVar.u();
                }
                i10 = 1;
            }
            if ((i11 & 2) != 0) {
                z.m(context);
                i10++;
            }
            if ((i11 & 4) != 0) {
                z.n(context);
                u9.n.e().s(true);
                i10++;
            }
            if ((i11 & 64) != 0 && hVar != null) {
                h.b(new c0(hVar));
                i10++;
            }
            if ((i11 & 8) != 0) {
                z.j();
                i10++;
            }
            if ((i11 & 16) != 0) {
                z.l(context);
                i10++;
            }
            if ((i11 & 32) != 0) {
                z.i(context);
                d(context, aVar);
                i10++;
            }
            if (i10 > 0) {
                com.tuyafeng.support.utils.n.q(context, w7.u.f14026e3);
            }
            i10 = i11;
        }
        lVar.K0(i10);
    }

    public static void c(Context context, u9.l lVar, qa.c cVar, ka.h hVar, w9.a aVar) {
        int iN = lVar.n();
        if ((iN & 1) != 0 || System.currentTimeMillis() - lVar.D1() >= 432000000) {
            z.k(context);
            z.o(context);
            lVar.b0();
            if (cVar != null) {
                cVar.u();
            }
        }
        if ((iN & 2) != 0) {
            z.m(context);
        }
        if ((iN & 4) != 0) {
            z.n(context);
        }
        if ((iN & 64) != 0 && hVar != null) {
            h.b(new c0(hVar));
        }
        if ((iN & 8) != 0) {
            z.j();
        }
        if ((iN & 16) != 0) {
            z.l(context);
        }
        if ((iN & 32) != 0) {
            z.i(context);
            d(context, aVar);
        }
    }

    public static void d(Context context, w9.a aVar) {
        List listH;
        if (aVar == null || (listH = aVar.h()) == null || listH.isEmpty()) {
            return;
        }
        HashSet hashSet = new HashSet();
        Iterator it = listH.iterator();
        while (it.hasNext()) {
            hashSet.add(((l9.b) it.next()).g());
        }
        w3.f(w3.m(context), hashSet);
    }

    public static void e(final Context context, final u9.l lVar, final qa.c cVar, final ka.h hVar, final w9.a aVar) {
        final int[] iArr = {1, 2, 4, 64, 8, 16, 32};
        int[] iArr2 = new int[7];
        int iW = lVar.W();
        int i10 = 0;
        for (int i11 = 0; i11 < 7; i11++) {
            if ((iArr[i11] & iW) != 0) {
                iArr2[i10] = i11;
                i10++;
            }
        }
        q5.k.l(context).f0(w7.u.f14137m2).L(w7.j.f13711b, Arrays.copyOf(iArr2, i10)).X(R.string.ok, new q5.k.m() { // from class: x8.e0
            @Override // q5.k.m
            public final void a(View view, q5.k.p pVar) {
                f0.b(iArr, context, lVar, cVar, hVar, aVar, view, pVar);
            }
        }).P(R.string.cancel, null).h0();
    }

    public static void f(Context context, final u9.l lVar) {
        final int[] iArr = {1, 2, 4, 64, 8, 16, 32};
        int[] iArr2 = new int[7];
        int iN = lVar.n();
        int i10 = 0;
        for (int i11 = 0; i11 < 7; i11++) {
            if ((iArr[i11] & iN) != 0) {
                iArr2[i10] = i11;
                i10++;
            }
        }
        q5.k.l(context).f0(w7.u.f14151n2).L(w7.j.f13711b, Arrays.copyOf(iArr2, i10)).X(R.string.ok, new q5.k.m() { // from class: x8.d0
            @Override // q5.k.m
            public final void a(View view, q5.k.p pVar) {
                f0.a(iArr, lVar, view, pVar);
            }
        }).P(R.string.cancel, null).h0();
    }
}
