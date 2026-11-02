package e8;

import android.R;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import w5.k;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class b0 extends p4.a {

    /* renamed from: a, reason: collision with root package name */
    public final d8.a f4797a = d8.a.a();

    public static /* synthetic */ void I(b0 b0Var, JsResult jsResult, String str, boolean z10, View view, k.p pVar) {
        b0Var.getClass();
        jsResult.confirm();
        b0Var.f4797a.c(str, true, z10 && pVar.f13338b);
    }

    public static /* synthetic */ void M(b0 b0Var, JsResult jsResult, String str, boolean z10, View view, k.p pVar) {
        b0Var.getClass();
        jsResult.confirm();
        b0Var.f4797a.c(str, false, z10 && pVar.f13338b);
    }

    public static /* synthetic */ void O(b0 b0Var, JsResult jsResult, String str, boolean z10, View view, k.p pVar) {
        b0Var.getClass();
        jsResult.cancel();
        b0Var.f4797a.c(str, true, z10 && pVar.f13338b);
    }

    public static /* synthetic */ void S(JsPromptResult jsPromptResult, View view, k.p pVar) {
        String[] strArr = pVar.f13339c;
        String str = (strArr == null || strArr.length < 1) ? null : strArr[0];
        if (str == null) {
            str = "";
        }
        jsPromptResult.confirm(str);
    }

    @Override // p4.a
    public boolean f(t4.b bVar, final Message message, final Message message2) {
        if (bVar.isShown()) {
            w5.k.l(bVar.getContext()).d0(x7.u.Xf).I(x7.u.f13909a8).t(true).u(false).T(new DialogInterface.OnCancelListener() { // from class: e8.n
                @Override // android.content.DialogInterface.OnCancelListener
                public final void onCancel(DialogInterface dialogInterface) {
                    message.sendToTarget();
                }
            }).V(R.string.ok, new k.m() { // from class: e8.s
                @Override // w5.k.m
                public final void a(View view, k.p pVar) {
                    message2.sendToTarget();
                }
            }).N(R.string.cancel, new View.OnClickListener() { // from class: e8.t
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    message.sendToTarget();
                }
            }).f0();
            return true;
        }
        message.sendToTarget();
        return true;
    }

    @Override // p4.a
    public boolean j(t4.b bVar, String str, String str2, final JsResult jsResult) {
        if (!bVar.isShown()) {
            jsResult.cancel();
            return true;
        }
        String strF = i6.i0.f7006a.f(str);
        final String str3 = TextUtils.isEmpty(strF) ? "default" : strF;
        int iB = this.f4797a.b(str3, false);
        if (iB == 2) {
            jsResult.cancel();
            return true;
        }
        final boolean z10 = iB == 1;
        Context context = bVar.getContext();
        w5.k kVarV = w5.k.l(context).e0(TextUtils.isEmpty(strF) ? context.getString(x7.u.f14193v3) : context.getString(x7.u.f14206w3, strF)).J(str2).t(true).u(false).T(new DialogInterface.OnCancelListener() { // from class: e8.x
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                jsResult.cancel();
            }
        }).V(R.string.ok, new k.m() { // from class: e8.y
            @Override // w5.k.m
            public final void a(View view, k.p pVar) {
                b0.M(this.f4885a, jsResult, str3, z10, view, pVar);
            }
        });
        if (z10) {
            kVarV.w(x7.u.f14170t6, false);
        }
        kVarV.f0();
        return true;
    }

    @Override // p4.a
    public boolean k(t4.b bVar, String str, String str2, final JsResult jsResult) {
        if (bVar.isShown()) {
            w5.k.l(bVar.getContext()).d0(x7.u.f14179u2).J(str2).t(true).u(false).T(new DialogInterface.OnCancelListener() { // from class: e8.p
                @Override // android.content.DialogInterface.OnCancelListener
                public final void onCancel(DialogInterface dialogInterface) {
                    jsResult.cancel();
                }
            }).V(x7.u.A7, new k.m() { // from class: e8.q
                @Override // w5.k.m
                public final void a(View view, k.p pVar) {
                    jsResult.confirm();
                }
            }).N(x7.u.kd, new View.OnClickListener() { // from class: e8.r
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    jsResult.cancel();
                }
            }).f0();
            return true;
        }
        jsResult.confirm();
        return true;
    }

    @Override // p4.a
    public boolean l(t4.b bVar, String str, String str2, final JsResult jsResult) {
        if (!bVar.isShown()) {
            jsResult.cancel();
            return true;
        }
        String strF = i6.i0.f7006a.f(str);
        final String str3 = TextUtils.isEmpty(strF) ? "default" : strF;
        int iB = this.f4797a.b(str3, true);
        if (iB == 2) {
            jsResult.cancel();
            return true;
        }
        final boolean z10 = iB == 1;
        Context context = bVar.getContext();
        w5.k kVarP = w5.k.l(context).e0(TextUtils.isEmpty(strF) ? context.getString(x7.u.f14193v3) : context.getString(x7.u.f14206w3, strF)).J(str2).t(true).u(false).T(new DialogInterface.OnCancelListener() { // from class: e8.z
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                jsResult.cancel();
            }
        }).V(R.string.ok, new k.m() { // from class: e8.a0
            @Override // w5.k.m
            public final void a(View view, k.p pVar) {
                b0.I(this.f4793a, jsResult, str3, z10, view, pVar);
            }
        }).P(R.string.cancel, new k.m() { // from class: e8.o
            @Override // w5.k.m
            public final void a(View view, k.p pVar) {
                b0.O(this.f4853a, jsResult, str3, z10, view, pVar);
            }
        });
        if (z10) {
            kVarP.w(x7.u.f14170t6, false);
        }
        kVarP.f0();
        return true;
    }

    @Override // p4.a
    public boolean m(t4.b bVar, String str, String str2, String str3, final JsPromptResult jsPromptResult) {
        if (!bVar.isShown()) {
            jsPromptResult.cancel();
            return true;
        }
        if (str2 != null && str2.startsWith("BdboxApp:{\"obj\":\"")) {
            jsPromptResult.confirm("");
            return true;
        }
        String strF = i6.i0.f7006a.f(str);
        Context context = bVar.getContext();
        w5.k kVarN = w5.k.l(context).e0(TextUtils.isEmpty(strF) ? context.getString(x7.u.f14193v3) : context.getString(x7.u.f14206w3, strF)).i(str3, str3, 1).t(true).u(false).T(new DialogInterface.OnCancelListener() { // from class: e8.u
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                jsPromptResult.cancel();
            }
        }).V(R.string.ok, new k.m() { // from class: e8.v
            @Override // w5.k.m
            public final void a(View view, k.p pVar) {
                b0.S(jsPromptResult, view, pVar);
            }
        }).N(R.string.cancel, new View.OnClickListener() { // from class: e8.w
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                jsPromptResult.cancel();
            }
        });
        if (str2 != null && !str2.isEmpty()) {
            kVarN.J(str2);
        }
        kVarN.f0();
        return true;
    }
}
