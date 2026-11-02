package z8;

import android.content.Context;
import c8.eb;
import c8.lc;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class j0 {
    public static n5.b a() {
        return lc.c();
    }

    public static boolean b() {
        p5.c cVarD = a().d();
        r5.c cVarQ = cVarD.q("fa6f3153b591e06fbf0170d935ad0afe");
        return cVarQ != null ? cVarQ.j() : cVarD.s(-99);
    }

    public static void c(Context context, boolean z10, boolean z11) {
        r5.a aVarA;
        p5.c cVarD = a().d();
        r5.c cVarQ = cVarD.q("fa6f3153b591e06fbf0170d935ad0afe");
        if (cVarQ != null) {
            if (z11) {
                return;
            }
            cVarD.l(cVarQ.e(), z10);
        } else {
            if (cVarD.u(-99, z10) || !z10 || (aVarA = eb.a(context)) == null) {
                return;
            }
            aVarA.h(-99);
            cVarD.v(aVarA);
        }
    }
}
