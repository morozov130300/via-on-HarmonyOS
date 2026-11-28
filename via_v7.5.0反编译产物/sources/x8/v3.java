package x8;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class v3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f14644a = com.tuyafeng.support.utils.x.l();

    public static void a(com.tuyafeng.support.widget.e0 e0Var, int i10) {
        if (e0Var == null) {
            return;
        }
        b(e0Var, e0Var.getContext().getString(i10));
    }

    public static void b(com.tuyafeng.support.widget.e0 e0Var, String str) {
        if (e0Var == null) {
            return;
        }
        e0Var.setId(f14644a);
        e0Var.setTitle(str);
        Context context = e0Var.getContext();
        e0Var.l(lb.g.a(context, w7.o.f13822q, w7.u.he), context.getString(w7.u.O8));
    }
}
