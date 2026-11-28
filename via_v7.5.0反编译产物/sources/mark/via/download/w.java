package mark.via.download;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import android.webkit.URLUtil;
import android.widget.EditText;
import android.widget.TextView;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class w extends i8.a {
    public o E0;
    public EditText F0;
    public TextView G0;
    public TextView H0;
    public a I0;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public interface a {
        void a(o oVar);
    }

    public static /* synthetic */ void k3(w wVar, o oVar) {
        wVar.t3();
        String strD = wVar.E0.d();
        if (!x8.t1.a(wVar.F0.getText().toString(), strD)) {
            wVar.F0.setText(strD);
            if (wVar.F0.hasFocus()) {
                wVar.F0.clearFocus();
                wVar.F0.requestFocus();
            }
        }
        wVar.u3();
        wVar.H0.setVisibility(wVar.E0.c() > 64198568 ? 8 : 0);
    }

    public static /* synthetic */ void l3(w wVar, View view) {
        if (wVar.I0 != null) {
            String strTrim = wVar.F0.getText().toString().trim();
            wVar.E0.n(strTrim);
            int iLastIndexOf = strTrim.lastIndexOf(46);
            if (iLastIndexOf >= 0) {
                wVar.E0.p(l5.c.c(strTrim.substring(iLastIndexOf + 1), "application/octet-stream"));
            }
            wVar.I0.a(wVar.E0);
        }
        wVar.V2();
    }

    public static /* synthetic */ void m3(w wVar, View view, boolean z10) {
        if (!z10) {
            wVar.getClass();
            return;
        }
        String string = wVar.F0.getText().toString();
        int iLastIndexOf = string.lastIndexOf(".");
        if (iLastIndexOf == -1 || string.length() - iLastIndexOf >= 7) {
            wVar.F0.selectAll();
        } else {
            wVar.F0.setSelection(0, iLastIndexOf);
        }
    }

    /* JADX WARN: Code duplicated, block: B:44:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:47:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:56:? A[RETURN, SYNTHETIC] */
    public static /* synthetic */ o n3(w wVar) throws Throwable {
        HttpURLConnection httpURLConnection;
        wVar.getClass();
        boolean z10 = false;
        HttpURLConnection httpURLConnection2 = null;
        try {
            String strH = wVar.E0.h();
            httpURLConnection = (HttpURLConnection) new URL(strH).openConnection();
            try {
                try {
                    httpURLConnection.setRequestProperty("Cookie", CookieManager.getInstance().getCookie(strH));
                    httpURLConnection.setRequestProperty("Referer", strH);
                    if (wVar.E0.i() != null) {
                        httpURLConnection.setRequestProperty("User-Agent", wVar.E0.i());
                    }
                    httpURLConnection.setRequestMethod("HEAD");
                    httpURLConnection.connect();
                    if (httpURLConnection.getResponseCode() == 200) {
                        wVar.E0.m(Build.VERSION.SDK_INT >= 24 ? httpURLConnection.getContentLengthLong() : httpURLConnection.getContentLength());
                        String contentType = httpURLConnection.getContentType();
                        int iIndexOf = contentType == null ? -1 : contentType.indexOf(59);
                        if (iIndexOf > 0) {
                            contentType = contentType.substring(0, iIndexOf);
                        }
                        if (contentType != null) {
                            wVar.E0.p(contentType);
                        }
                        String headerField = httpURLConnection.getHeaderField("Content-Disposition");
                        if (headerField != null) {
                            wVar.E0.l(headerField);
                        }
                        if (wVar.E0.j()) {
                            String strB = l5.b.b(strH, wVar.E0.b(), wVar.E0.e());
                            if (strB.endsWith(".apk")) {
                                wVar.E0.p("application/vnd.android.package-archive");
                            }
                            wVar.E0.n(strB);
                        }
                        z10 = true;
                    }
                } catch (Exception e10) {
                    e = e10;
                    tc.a.j(e);
                    if (httpURLConnection != null) {
                    }
                    if (z10) {
                        return wVar.E0;
                    }
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                httpURLConnection2 = httpURLConnection;
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
                throw th;
            }
        } catch (Exception e11) {
            e = e11;
            httpURLConnection = null;
        } catch (Throwable th2) {
            th = th2;
            if (httpURLConnection2 != null) {
                httpURLConnection2.disconnect();
            }
            throw th;
        }
        httpURLConnection.disconnect();
        if (z10) {
            return wVar.E0;
        }
        return null;
    }

    public static w p3(o oVar) {
        Bundle bundle = new Bundle();
        bundle.putString("url", oVar.h());
        bundle.putString("fileName", oVar.d());
        bundle.putString("userAgent", oVar.i());
        bundle.putString("contentDisposition", oVar.b());
        bundle.putString("mimeType", oVar.e());
        bundle.putString("referer", oVar.g());
        bundle.putString("path", oVar.f());
        bundle.putLong("contentLength", oVar.c());
        bundle.putBoolean("fileNameOverwrittable", oVar.j());
        bundle.putString("authorization", oVar.a());
        w wVar = new w();
        wVar.F2(bundle);
        return wVar;
    }

    @Override // androidx.fragment.app.Fragment
    public View A1(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(w7.r.f13935d, viewGroup, false);
    }

    @Override // i8.a, androidx.fragment.app.Fragment
    public void R1() {
        super.R1();
        Dialog dialogX2 = X2();
        if (dialogX2 != null) {
            dialogX2.setCanceledOnTouchOutside(false);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void V1(View view, Bundle bundle) {
        String strB;
        super.V1(view, bundle);
        o oVar = this.E0;
        if (oVar == null || oVar.h() == null) {
            V2();
            return;
        }
        v8.g.f(view);
        String strD = this.E0.d();
        boolean zC = i.y(G()).C(this.E0.h());
        boolean zStartsWith = this.E0.h().startsWith("data:");
        if (zStartsWith || zC) {
            if (zStartsWith && (this.E0.e() == null || this.E0.e().isEmpty() || this.E0.e().contains("/*") || "application/octet-stream".equals(this.E0.e()))) {
                this.E0.p(l5.a.d(this.E0.h()));
            }
            if (strD == null || strD.isEmpty()) {
                strD = l5.a.c(this.E0.e(), null);
                this.E0.n(strD);
            } else if (strD.indexOf(46, Math.max(0, strD.length() - 7)) < 0 && this.E0.e() != null && (strB = l5.c.b(this.E0.e())) != null) {
                strD = strD + "." + strB;
                this.E0.n(strD);
            }
            t3();
        }
        if (strD == null) {
            strD = l5.b.b(this.E0.h(), this.E0.b(), this.E0.e());
            this.E0.n(strD);
            if (strD.endsWith(".apk")) {
                this.E0.p("application/vnd.android.package-archive");
            }
            t3();
        }
        TextView textView = (TextView) view.findViewById(w7.p.f13899p1);
        this.G0 = textView;
        textView.setTextDirection(5);
        EditText editText = (EditText) view.findViewById(w7.p.f13879j);
        this.F0 = editText;
        editText.setText(strD);
        this.F0.setSelectAllOnFocus(true);
        this.F0.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: mark.via.download.q
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view2, boolean z10) {
                w.m3(this.f10280a, view2, z10);
            }
        });
        view.findViewById(w7.p.f13863d1).setOnClickListener(new View.OnClickListener() { // from class: mark.via.download.r
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f10286a.d3().cancel();
            }
        });
        TextView textView2 = (TextView) view.findViewById(w7.p.f13866e1);
        this.H0 = textView2;
        if (zC) {
            textView2.setVisibility(8);
        }
        this.H0.setOnClickListener(new View.OnClickListener() { // from class: mark.via.download.s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                w wVar = this.f10290a;
                com.tuyafeng.support.utils.n.a(wVar.G(), wVar.E0.h(), w7.u.Fg);
            }
        });
        u3();
        view.findViewById(w7.p.f13878i1).setOnClickListener(new View.OnClickListener() { // from class: mark.via.download.t
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                w.l3(this.f10293a, view2);
            }
        });
        if (URLUtil.isNetworkUrl(this.E0.h())) {
            if (this.E0.c() <= 0) {
                r3();
            }
        } else {
            if (!URLUtil.isDataUrl(this.E0.h()) || this.E0.c() > 0) {
                return;
            }
            q3();
        }
    }

    @Override // androidx.fragment.app.k, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        if (this.E0 != null) {
            i.y(G()).D(this.E0.h());
        }
        super.onCancel(dialogInterface);
    }

    public final void q3() {
        this.E0.m(l5.a.b(this.E0.h()));
        if (this.E0.c() > 1019904) {
            this.H0.setVisibility(8);
        }
        u3();
        t3();
    }

    public final void r3() {
        ((autodispose2.m) r6.f.h(new Callable() { // from class: mark.via.download.u
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return w.n3(this.f10296c);
            }
        }).n(a7.a.c()).k(q6.b.b()).p(s8.b.a(b1()))).a(new u6.f() { // from class: mark.via.download.v
            @Override // u6.f
            public final void accept(Object obj) {
                w.k3(this.f10303c, (o) obj);
            }
        }, new w7.e0());
    }

    public void s3(a aVar) {
        this.I0 = aVar;
    }

    public final void t3() {
        if (this.E0 == null) {
            F2(null);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("url", this.E0.h());
        bundle.putString("fileName", this.E0.d());
        bundle.putString("contentDisposition", this.E0.b());
        bundle.putString("mimeType", this.E0.e());
        bundle.putString("userAgent", this.E0.i());
        bundle.putString("referer", this.E0.g());
        bundle.putString("authorization", this.E0.a());
        bundle.putLong("contentLength", this.E0.c());
        F2(bundle);
    }

    public final void u3() {
        this.G0.setText(Y0(w7.u.J5, x8.z.v(G(), this.E0.c())));
    }

    @Override // i8.a, androidx.fragment.app.k, androidx.fragment.app.Fragment
    public void w1(Bundle bundle) {
        super.w1(bundle);
        Bundle bundleW0 = w0();
        if (bundleW0 == null || bundleW0.isEmpty()) {
            return;
        }
        this.E0 = new o.b().j(bundleW0.getString("url")).e(bundleW0.getString("fileName")).k(bundleW0.getString("userAgent")).c(bundleW0.getString("contentDisposition")).g(bundleW0.getString("mimeType")).i(bundleW0.getString("referer")).a(bundleW0.getString("authorization")).h(bundleW0.getString("path")).d(bundleW0.getLong("contentLength")).f(bundleW0.getBoolean("fileNameOverwrittable")).b();
    }
}
