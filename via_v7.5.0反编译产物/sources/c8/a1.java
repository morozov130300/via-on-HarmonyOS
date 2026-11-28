package c8;

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
import c6.a2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class a1 extends q4.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u9.l f2156a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b8.f f2157b = b8.f.c();

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a extends ClickableSpan {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Context f2158c;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ CharSequence f2159e;

        public a(Context context, CharSequence charSequence) {
            this.f2158c = context;
            this.f2159e = charSequence;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            if (viewGroup instanceof ScrollView) {
                ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
                layoutParams.height = Math.max(view.getMeasuredHeight(), (com.tuyafeng.support.utils.x.p(this.f2158c) * 2) / 5);
                viewGroup.setLayoutParams(layoutParams);
            }
            if (view instanceof TextView) {
                ((TextView) view).setText(this.f2159e);
            }
        }
    }

    public a1(u9.l lVar) {
        this.f2156a = lVar;
    }

    public static /* synthetic */ void J(a1 a1Var, String str, SslError sslError, SslErrorHandler sslErrorHandler, View view, q5.k.p pVar) {
        a1Var.getClass();
        if (pVar.f11818b) {
            a1Var.f2157b.e(str, 2);
        }
        List listF = a1Var.f2157b.f(str, sslError);
        if (listF == null) {
            sslErrorHandler.cancel();
            return;
        }
        Iterator it = listF.iterator();
        while (it.hasNext()) {
            ((SslErrorHandler) it.next()).cancel();
        }
    }

    public static /* synthetic */ void K(a1 a1Var, String str, SslError sslError, SslErrorHandler sslErrorHandler, View view, q5.k.p pVar) {
        a1Var.getClass();
        if (pVar.f11818b) {
            a1Var.f2157b.e(str, 1);
        }
        List listF = a1Var.f2157b.f(str, sslError);
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
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARN: Type inference failed for: r0v21 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    public final int L(SslError sslError) {
        boolean zHasError = sslError.hasError(3);
        ?? r10 = zHasError;
        if (sslError.hasError(4)) {
            r10 = (zHasError ? 1 : 0) | 2;
        }
        ?? r11 = r10;
        if (sslError.hasError(1)) {
            r11 = (r10 == true ? 1 : 0) | 4;
        }
        ?? r12 = r11;
        if (sslError.hasError(2)) {
            r12 = (r11 == true ? 1 : 0) | 8;
        }
        ?? r13 = r12;
        if (sslError.hasError(0)) {
            r13 = (r12 == true ? 1 : 0) | 16;
        }
        return sslError.hasError(5) ? r13 | 32 : r13;
    }

    public final List M(Context context, SslError sslError) {
        ArrayList arrayList = new ArrayList();
        if (sslError.hasError(3)) {
            arrayList.add(context.getString(w7.u.vd));
        }
        if (sslError.hasError(4)) {
            arrayList.add(context.getString(w7.u.qd));
        }
        if (sslError.hasError(1)) {
            arrayList.add(context.getString(w7.u.sd));
        }
        if (sslError.hasError(2)) {
            arrayList.add(context.getString(w7.u.rd));
        }
        if (sslError.hasError(0)) {
            arrayList.add(context.getString(w7.u.ud));
        }
        if (sslError.hasError(5)) {
            arrayList.add(context.getString(w7.u.td));
        }
        return arrayList;
    }

    @Override // q4.a
    public boolean x(t4.b bVar, final SslErrorHandler sslErrorHandler, final SslError sslError) {
        int iK2 = this.f2156a.K2();
        if (iK2 != 0) {
            int iL = L(sslError);
            if ((iK2 & iL) == iL) {
                sslErrorHandler.proceed();
                return true;
            }
        }
        Context context = bVar.getContext();
        String url = sslError.getUrl();
        String url2 = bVar.getUrl();
        a2 a2Var = a2.f1958a;
        String strG = a2Var.g(url);
        String strG2 = a2Var.g(url2);
        final String str = TextUtils.isEmpty(strG) ? strG2 : strG;
        int iD = this.f2157b.d(str);
        if (iD == 1) {
            sslErrorHandler.proceed();
            return true;
        }
        if (iD == 2) {
            sslErrorHandler.cancel();
            return true;
        }
        if (!strG.isEmpty() && !strG2.isEmpty() && !strG.equals(strG2) && sslError.getPrimaryError() != 3) {
            sslErrorHandler.cancel();
            return true;
        }
        if (this.f2157b.g(str, sslError, sslErrorHandler)) {
            return true;
        }
        List<String> listM = M(context, sslError);
        StringBuilder sb2 = new StringBuilder();
        for (String str2 : listM) {
            sb2.append("- ");
            sb2.append(str2);
            sb2.append('\n');
        }
        String string = sb2.toString();
        String string2 = context.getString(w7.u.xd, TextUtils.isEmpty(str) ? context.getString(w7.u.Wf).toLowerCase(Locale.ROOT) : str, string);
        q5.k kVarR = q5.k.l(context).f0(w7.u.Ag).x(w7.u.wd, false).u(false).v(false).X(R.string.ok, new q5.k.m() { // from class: c8.y0
            @Override // q5.k.m
            public final void a(View view, q5.k.p pVar) {
                a1.K(this.f2300a, str, sslError, sslErrorHandler, view, pVar);
            }
        }).R(R.string.cancel, new q5.k.m() { // from class: c8.z0
            @Override // q5.k.m
            public final void a(View view, q5.k.p pVar) {
                a1.J(this.f2305a, str, sslError, sslErrorHandler, view, pVar);
            }
        });
        if (sslError.getCertificate() != null) {
            CharSequence charSequenceS = x8.z.s(context, sslError.getCertificate());
            SpannableString spannableString = new SpannableString(string2);
            a aVar = new a(context, charSequenceS);
            int iIndexOf = string2.indexOf(string);
            int length = string.length() + iIndexOf;
            spannableString.setSpan(aVar, iIndexOf, length, 33);
            spannableString.setSpan(new ForegroundColorSpan(v8.h.j(context)), iIndexOf, length, 33);
            kVarR.K(spannableString);
        } else {
            kVarR.K(string2);
        }
        kVarR.h0();
        return true;
    }
}
