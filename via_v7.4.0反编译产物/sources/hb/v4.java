package hb;

import android.content.Context;
import android.graphics.drawable.Drawable;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class v4 {
    public static Drawable a(Context context, int i10) {
        switch (i10) {
            case 1:
                return lb.b.a(context, x7.o.X0, x7.u.nf);
            case 2:
            case WebSettingsBoundaryInterface.AttributionBehavior.APP_SOURCE_AND_APP_TRIGGER /* 3 */:
            case 4:
            case 10:
            case 11:
            case 17:
            case 18:
            case 21:
            case 22:
            case 27:
            default:
                return null;
            case 5:
                return lb.b.a(context, x7.o.f13747n, x7.u.Rd);
            case 6:
                return lb.b.a(context, x7.o.f13750o, x7.u.pe);
            case 7:
            case 30:
                return lb.b.a(context, x7.o.f13777x, x7.u.te);
            case 8:
                return lb.b.a(context, x7.o.f13751o0, x7.u.Ce);
            case 9:
            case 16:
                return lb.b.a(context, x7.o.f13783z, x7.u.Ud);
            case 12:
                return lb.b.a(context, x7.o.f13759r, x7.u.Sd);
            case 13:
                return lb.b.a(context, x7.o.f13736j0, x7.u.ge);
            case 14:
                return lb.b.a(context, x7.o.f13718d0, x7.u.ye);
            case 15:
                return lb.b.a(context, x7.o.G1, x7.u.Ye);
            case 19:
                return lb.b.a(context, x7.o.f13725f1, x7.u.Qe);
            case 20:
                return lb.b.a(context, x7.o.J1, x7.u.af);
            case 23:
                return lb.b.a(context, x7.o.f13785z1, x7.u.wf);
            case 24:
                return lb.b.a(context, x7.o.U0, x7.u.Ke);
            case 25:
                return lb.b.a(context, x7.o.W0, x7.u.Le);
            case 26:
                return lb.b.a(context, x7.o.f13743l1, x7.u.sf);
            case 28:
                return lb.b.a(context, x7.o.I, x7.u.xe);
            case 29:
                return lb.b.a(context, x7.o.B, x7.u.se);
        }
    }

    public static String b(Context context, int i10) {
        switch (i10) {
            case 0:
                return context.getString(x7.u.G9);
            case 1:
                return context.getString(x7.u.M9);
            case 2:
                return context.getString(x7.u.O9);
            case WebSettingsBoundaryInterface.AttributionBehavior.APP_SOURCE_AND_APP_TRIGGER /* 3 */:
                return context.getString(x7.u.f14238y9);
            case 4:
                return context.getString(x7.u.D9);
            case 5:
                return context.getString(x7.u.O);
            case 6:
                return context.getString(x7.u.f13928c);
            case 7:
                return context.getString(x7.u.I9);
            case 8:
                return context.getString(x7.u.K9);
            case 9:
                return context.getString(x7.u.f14251z9);
            case 10:
                return context.getString(x7.u.E9);
            case 11:
                return context.getString(x7.u.F9);
            case 12:
                return context.getString(x7.u.A9);
            case 13:
                return context.getString(x7.u.B9);
            case 14:
                return context.getString(x7.u.F);
            case 15:
                return context.getString(x7.u.f13985g0);
            case 16:
                return context.getString(x7.u.f14068m);
            case 17:
                return context.getString(x7.u.f13953da);
            case 18:
                return context.getString(x7.u.T9);
            case 19:
                return context.getString(x7.u.f13915b0);
            case 20:
                return context.getString(x7.u.f13957e0);
            case 21:
            case 22:
            default:
                throw new IllegalArgumentException("No title for action: " + i10);
            case 23:
                return context.getString(x7.u.N9);
            case 24:
                return context.getString(x7.u.Ia);
            case 25:
                return context.getString(x7.u.Na);
            case 26:
                return context.getString(x7.u.L9);
            case 27:
                return context.getString(x7.u.f14059l4);
            case 28:
                return context.getString(x7.u.J9);
            case 29:
                return context.getString(x7.u.f14225x9);
            case 30:
                return context.getString(x7.u.H9);
        }
    }
}
