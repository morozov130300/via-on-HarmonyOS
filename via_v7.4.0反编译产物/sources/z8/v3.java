package z8;

import android.content.Context;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class v3 {

    /* renamed from: a, reason: collision with root package name */
    public static final int f14776a = g6.y.l();

    public static void a(com.tuyafeng.support.widget.z zVar, int i10) {
        if (zVar == null) {
            return;
        }
        b(zVar, zVar.getContext().getString(i10));
    }

    public static void b(com.tuyafeng.support.widget.z zVar, String str) {
        if (zVar == null) {
            return;
        }
        zVar.setId(f14776a);
        zVar.setTitle(str);
        Context context = zVar.getContext();
        zVar.k(lb.b.a(context, x7.o.f13759r, x7.u.Sd), context.getString(x7.u.C8));
    }
}
