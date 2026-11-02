package e8;

import android.R;
import android.content.Context;
import android.net.http.SslError;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.SslErrorHandler;
import android.widget.ScrollView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import w5.k;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class h0 extends p4.a {

    /* renamed from: a, reason: collision with root package name */
    public final w9.l f4816a;

    /* renamed from: b, reason: collision with root package name */
    public final d8.f f4817b = d8.f.c();

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a extends ClickableSpan {

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Context f4818e;

        /* renamed from: j, reason: collision with root package name */
        public final /* synthetic */ CharSequence f4819j;

        public a(Context context, CharSequence charSequence) {
            this.f4818e = context;
            this.f4819j = charSequence;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            if (viewGroup instanceof ScrollView) {
                ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
                layoutParams.height = Math.max(view.getMeasuredHeight(), (g6.y.p(this.f4818e) * 2) / 5);
                viewGroup.setLayoutParams(layoutParams);
            }
            if (view instanceof TextView) {
                ((TextView) view).setText(this.f4819j);
            }
        }
    }

    public h0(w9.l lVar) {
        this.f4816a = lVar;
    }

    public static /* synthetic */ void G(h0 h0Var, String str, SslError sslError, SslErrorHandler sslErrorHandler, View view, k.p pVar) {
        h0Var.getClass();
        if (pVar.f13338b) {
            h0Var.f4817b.e(str, 2);
        }
        List listF = h0Var.f4817b.f(str, sslError);
        if (listF == null) {
            sslErrorHandler.cancel();
            return;
        }
        Iterator it = listF.iterator();
        while (it.hasNext()) {
            ((SslErrorHandler) it.next()).cancel();
        }
    }

    public static /* synthetic */ void H(h0 h0Var, String str, SslError sslError, SslErrorHandler sslErrorHandler, View view, k.p pVar) {
        h0Var.getClass();
        if (pVar.f13338b) {
            h0Var.f4817b.e(str, 1);
        }
        List listF = h0Var.f4817b.f(str, sslError);
        if (listF == null) {
            sslErrorHandler.proceed();
            return;
        }
        Iterator it = listF.iterator();
        while (it.hasNext()) {
            ((SslErrorHandler) it.next()).proceed();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARN: Type inference failed for: r0v21 */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    public final int I(SslError sslError) {
        boolean zHasError = sslError.hasError(3);
        boolean z10 = zHasError;
        if (sslError.hasError(4)) {
            z10 = (zHasError ? 1 : 0) | 2;
        }
        boolean z11 = z10;
        if (sslError.hasError(1)) {
            z11 = (z10 ? 1 : 0) | 4;
        }
        boolean z12 = z11;
        if (sslError.hasError(2)) {
            z12 = (z11 ? 1 : 0) | '\b';
        }
        ?? r02 = z12;
        if (sslError.hasError(0)) {
            r02 = (z12 ? 1 : 0) | 16;
        }
        return sslError.hasError(5) ? r02 | 32 : r02;
    }

    public final List J(Context context, SslError sslError) {
        ArrayList arrayList = new ArrayList();
        if (sslError.hasError(3)) {
            arrayList.add(context.getString(x7.u.fd));
        }
        if (sslError.hasError(4)) {
            arrayList.add(context.getString(x7.u.ad));
        }
        if (sslError.hasError(1)) {
            arrayList.add(context.getString(x7.u.cd));
        }
        if (sslError.hasError(2)) {
            arrayList.add(context.getString(x7.u.bd));
        }
        if (sslError.hasError(0)) {
            arrayList.add(context.getString(x7.u.ed));
        }
        if (sslError.hasError(5)) {
            arrayList.add(context.getString(x7.u.dd));
        }
        return arrayList;
    }

    @Override // p4.a
    public boolean v(t4.b bVar, final SslErrorHandler sslErrorHandler, final SslError sslError) {
        int iG2 = this.f4816a.G2();
        if (iG2 != 0) {
            int I = I(sslError);
            if ((iG2 & I) == I) {
                sslErrorHandler.proceed();
                return true;
            }
        }
        Context context = bVar.getContext();
        String url = sslError.getUrl();
        String url2 = bVar.getUrl();
        i6.i0 i0Var = i6.i0.f7006a;
        String strF = i0Var.f(url);
        String strF2 = i0Var.f(url2);
        final String str = TextUtils.isEmpty(strF) ? strF2 : strF;
        int iD = this.f4817b.d(str);
        if (iD == 1) {
            sslErrorHandler.proceed();
            return true;
        }
        if (iD == 2) {
            sslErrorHandler.cancel();
            return true;
        }
        if (!strF.isEmpty() && !strF2.isEmpty() && !strF.equals(strF2) && sslError.getPrimaryError() != 3) {
            sslErrorHandler.cancel();
            return true;
        }
        if (this.f4817b.g(str, sslError, sslErrorHandler)) {
            return true;
        }
        List<String> listJ = J(context, sslError);
        StringBuilder sb2 = new StringBuilder();
        for (String str2 : listJ) {
            sb2.append("- ");
            sb2.append(str2);
            sb2.append('\n');
        }
        String string = sb2.toString();
        String string2 = context.getString(x7.u.hd, TextUtils.isEmpty(str) ? context.getString(x7.u.Gf).toLowerCase(Locale.ROOT) : str, string);
        w5.k kVarP = w5.k.l(context).d0(x7.u.lg).w(x7.u.gd, false).t(false).u(false).V(R.string.ok, new k.m() { // from class: e8.f0
            @Override // w5.k.m
            public final void a(View view, k.p pVar) {
                h0.H(this.f4804a, str, sslError, sslErrorHandler, view, pVar);
            }
        }).P(R.string.cancel, new k.m() { // from class: e8.g0
            @Override // w5.k.m
            public final void a(View view, k.p pVar) {
                h0.G(this.f4809a, str, sslError, sslErrorHandler, view, pVar);
            }
        });
        if (sslError.getCertificate() != null) {
            CharSequence charSequenceT = z8.b0.t(context, sslError.getCertificate());
            SpannableString spannableString = new SpannableString(string2);
            a aVar = new a(context, charSequenceT);
            int iIndexOf = string2.indexOf(string);
            int length = string.length() + iIndexOf;
            spannableString.setSpan(aVar, iIndexOf, length, 33);
            spannableString.setSpan(new ForegroundColorSpan(x8.h.j(context)), iIndexOf, length, 33);
            kVarP.J(spannableString);
        } else {
            kVarP.J(string2);
        }
        kVarP.f0();
        return true;
    }
}
