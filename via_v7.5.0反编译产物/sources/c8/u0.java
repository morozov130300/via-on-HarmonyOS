package c8;

import android.R;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import c6.a2;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class u0 extends q4.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b8.a f2280a = b8.a.a();

    public static /* synthetic */ void L(u0 u0Var, JsResult jsResult, String str, boolean z10, View view, q5.k.p pVar) {
        u0Var.getClass();
        jsResult.confirm();
        u0Var.f2280a.c(str, true, z10 && pVar.f11818b);
    }

    public static /* synthetic */ void P(u0 u0Var, JsResult jsResult, String str, boolean z10, View view, q5.k.p pVar) {
        u0Var.getClass();
        jsResult.confirm();
        u0Var.f2280a.c(str, false, z10 && pVar.f11818b);
    }

    public static /* synthetic */ void R(u0 u0Var, JsResult jsResult, String str, boolean z10, View view, q5.k.p pVar) {
        u0Var.getClass();
        jsResult.cancel();
        u0Var.f2280a.c(str, true, z10 && pVar.f11818b);
    }

    public static /* synthetic */ void V(JsPromptResult jsPromptResult, View view, q5.k.p pVar) {
        String[] strArr = pVar.f11819c;
        String str = (strArr == null || strArr.length < 1) ? null : strArr[0];
        if (str == null) {
            str = "";
        }
        jsPromptResult.confirm(str);
    }

    @Override // q4.a
    public boolean f(t4.b bVar, final Message message, final Message message2) {
        if (bVar.isShown()) {
            q5.k.l(bVar.getContext()).f0(w7.u.ng).J(w7.u.f14143m8).u(true).v(false).V(new DialogInterface.OnCancelListener() { // from class: c8.g0
                @Override // android.content.DialogInterface.OnCancelListener
                public final void onCancel(DialogInterface dialogInterface) {
                    message.sendToTarget();
                }
            }).X(R.string.ok, new q5.k.m() { // from class: c8.l0
                @Override // q5.k.m
                public final void a(View view, q5.k.p pVar) {
                    message2.sendToTarget();
                }
            }).P(R.string.cancel, new View.OnClickListener() { // from class: c8.m0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    message.sendToTarget();
                }
            }).h0();
            return true;
        }
        message.sendToTarget();
        return true;
    }

    @Override // q4.a
    public boolean j(t4.b bVar, String str, String str2, final JsResult jsResult) {
        if (!bVar.isShown()) {
            jsResult.cancel();
            return true;
        }
        String strG = a2.f1958a.g(str);
        final String str3 = TextUtils.isEmpty(strG) ? "default" : strG;
        int iB = this.f2280a.b(str3, false);
        if (iB == 2) {
            jsResult.cancel();
            return true;
        }
        final boolean z10 = iB == 1;
        Context context = bVar.getContext();
        q5.k kVarX = q5.k.l(context).g0(TextUtils.isEmpty(strG) ? context.getString(w7.u.I3) : context.getString(w7.u.J3, strG)).K(str2).u(true).v(false).V(new DialogInterface.OnCancelListener() { // from class: c8.q0
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                jsResult.cancel();
            }
        }).X(R.string.ok, new q5.k.m() { // from class: c8.r0
            @Override // q5.k.m
            public final void a(View view, q5.k.p pVar) {
                u0.P(this.f2253a, jsResult, str3, z10, view, pVar);
            }
        });
        if (z10) {
            kVarX.x(w7.u.F6, false);
        }
        kVarX.h0();
        return true;
    }

    @Override // q4.a
    public boolean k(t4.b bVar, String str, String str2, final JsResult jsResult) {
        if (bVar.isShown()) {
            q5.k.l(bVar.getContext()).f0(w7.u.H2).K(str2).u(true).v(false).V(new DialogInterface.OnCancelListener() { // from class: c8.i0
                @Override // android.content.DialogInterface.OnCancelListener
                public final void onCancel(DialogInterface dialogInterface) {
                    jsResult.cancel();
                }
            }).X(w7.u.M7, new q5.k.m() { // from class: c8.j0
                @Override // q5.k.m
                public final void a(View view, q5.k.p pVar) {
                    jsResult.confirm();
                }
            }).P(w7.u.Ad, new View.OnClickListener() { // from class: c8.k0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    jsResult.cancel();
                }
            }).h0();
            return true;
        }
        jsResult.confirm();
        return true;
    }

    @Override // q4.a
    public boolean l(t4.b bVar, String str, String str2, final JsResult jsResult) {
        if (!bVar.isShown()) {
            jsResult.cancel();
            return true;
        }
        String strG = a2.f1958a.g(str);
        final String str3 = TextUtils.isEmpty(strG) ? "default" : strG;
        int iB = this.f2280a.b(str3, true);
        if (iB == 2) {
            jsResult.cancel();
            return true;
        }
        final boolean z10 = iB == 1;
        Context context = bVar.getContext();
        q5.k kVarR = q5.k.l(context).g0(TextUtils.isEmpty(strG) ? context.getString(w7.u.I3) : context.getString(w7.u.J3, strG)).K(str2).u(true).v(false).V(new DialogInterface.OnCancelListener() { // from class: c8.s0
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                jsResult.cancel();
            }
        }).X(R.string.ok, new q5.k.m() { // from class: c8.t0
            @Override // q5.k.m
            public final void a(View view, q5.k.p pVar) {
                u0.L(this.f2272a, jsResult, str3, z10, view, pVar);
            }
        }).R(R.string.cancel, new q5.k.m() { // from class: c8.h0
            @Override // q5.k.m
            public final void a(View view, q5.k.p pVar) {
                u0.R(this.f2212a, jsResult, str3, z10, view, pVar);
            }
        });
        if (z10) {
            kVarR.x(w7.u.F6, false);
        }
        kVarR.h0();
        return true;
    }

    @Override // q4.a
    public boolean m(t4.b bVar, String str, String str2, String str3, final JsPromptResult jsPromptResult) {
        if (!bVar.isShown()) {
            jsPromptResult.cancel();
            return true;
        }
        if (str2 != null && str2.startsWith("BdboxApp:{\"obj\":\"")) {
            jsPromptResult.confirm("");
            return true;
        }
        String strG = a2.f1958a.g(str);
        Context context = bVar.getContext();
        q5.k kVarP = q5.k.l(context).g0(TextUtils.isEmpty(strG) ? context.getString(w7.u.I3) : context.getString(w7.u.J3, strG)).i(str3, str3, 1).u(true).v(false).V(new DialogInterface.OnCancelListener() { // from class: c8.n0
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                jsPromptResult.cancel();
            }
        }).X(R.string.ok, new q5.k.m() { // from class: c8.o0
            @Override // q5.k.m
            public final void a(View view, q5.k.p pVar) {
                u0.V(jsPromptResult, view, pVar);
            }
        }).P(R.string.cancel, new View.OnClickListener() { // from class: c8.p0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                jsPromptResult.cancel();
            }
        });
        if (str2 != null && !str2.isEmpty()) {
            kVarP.K(str2);
        }
        kVarP.h0();
        return true;
    }
}
