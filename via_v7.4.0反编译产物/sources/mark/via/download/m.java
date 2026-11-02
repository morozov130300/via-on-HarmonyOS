package mark.via.download;

import android.app.Dialog;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import android.webkit.URLUtil;
import android.widget.EditText;
import android.widget.TextView;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.Callable;
import mark.via.download.e;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class m extends k8.a {
    public e C0;
    public EditText D0;
    public TextView E0;
    public TextView F0;
    public a G0;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public interface a {
        void a(e eVar);
    }

    public static /* synthetic */ void j3(m mVar, View view) {
        g6.n.a(mVar.I(), mVar.C0.h(), x7.u.pg);
        mVar.X2();
    }

    public static /* synthetic */ void k3(m mVar, e eVar) {
        mVar.t3();
        String strD = mVar.C0.d();
        if (!z8.u1.a(mVar.D0.getText().toString(), strD)) {
            mVar.D0.setText(strD);
            if (mVar.D0.hasFocus()) {
                mVar.D0.clearFocus();
                mVar.D0.requestFocus();
            }
        }
        mVar.u3();
        mVar.F0.setVisibility(mVar.C0.c() > 64198568 ? 8 : 0);
    }

    public static /* synthetic */ void l3(m mVar, View view) {
        if (mVar.G0 != null) {
            String strTrim = mVar.D0.getText().toString().trim();
            mVar.C0.n(strTrim);
            int iLastIndexOf = strTrim.lastIndexOf(46);
            if (iLastIndexOf >= 0) {
                mVar.C0.p(l5.c.c(strTrim.substring(iLastIndexOf + 1), "application/octet-stream"));
            }
            mVar.G0.a(mVar.C0);
        }
        mVar.X2();
    }

    public static /* synthetic */ void m3(m mVar, View view, boolean z10) {
        if (!z10) {
            mVar.getClass();
            return;
        }
        String string = mVar.D0.getText().toString();
        int iLastIndexOf = string.lastIndexOf(".");
        if (iLastIndexOf == -1 || string.length() - iLastIndexOf >= 7) {
            mVar.D0.selectAll();
        } else {
            mVar.D0.setSelection(0, iLastIndexOf);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:56:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static /* synthetic */ e n3(m mVar) throws Throwable {
        HttpURLConnection httpURLConnection;
        mVar.getClass();
        boolean z10 = false;
        HttpURLConnection httpURLConnection2 = null;
        try {
            String strH = mVar.C0.h();
            httpURLConnection = (HttpURLConnection) new URL(strH).openConnection();
            try {
                try {
                    httpURLConnection.setRequestProperty("Cookie", CookieManager.getInstance().getCookie(strH));
                    httpURLConnection.setRequestProperty("Referer", strH);
                    if (mVar.C0.i() != null) {
                        httpURLConnection.setRequestProperty("User-Agent", mVar.C0.i());
                    }
                    httpURLConnection.setRequestMethod("HEAD");
                    httpURLConnection.connect();
                    if (httpURLConnection.getResponseCode() == 200) {
                        mVar.C0.m(Build.VERSION.SDK_INT >= 24 ? httpURLConnection.getContentLengthLong() : httpURLConnection.getContentLength());
                        String contentType = httpURLConnection.getContentType();
                        int iIndexOf = contentType == null ? -1 : contentType.indexOf(59);
                        if (iIndexOf > 0) {
                            contentType = contentType.substring(0, iIndexOf);
                        }
                        if (contentType != null) {
                            mVar.C0.p(contentType);
                        }
                        String headerField = httpURLConnection.getHeaderField("Content-Disposition");
                        if (headerField != null) {
                            mVar.C0.l(headerField);
                        }
                        if (mVar.C0.j()) {
                            String strB = l5.b.b(strH, mVar.C0.b(), mVar.C0.e());
                            if (strB.endsWith(".apk")) {
                                mVar.C0.p("application/vnd.android.package-archive");
                            }
                            mVar.C0.n(strB);
                        }
                        z10 = true;
                    }
                } catch (Exception e10) {
                    e = e10;
                    pc.a.i(e);
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    if (z10) {
                    }
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
            }
            throw th;
        }
        httpURLConnection.disconnect();
        if (z10) {
            return null;
        }
        return mVar.C0;
    }

    public static m p3(e eVar) {
        Bundle bundle = new Bundle();
        bundle.putString("url", eVar.h());
        bundle.putString("fileName", eVar.d());
        bundle.putString("userAgent", eVar.i());
        bundle.putString("contentDisposition", eVar.b());
        bundle.putString("mimeType", eVar.e());
        bundle.putString("referer", eVar.g());
        bundle.putString("path", eVar.f());
        bundle.putLong("contentLength", eVar.c());
        bundle.putBoolean("fileNameOverwrittable", eVar.j());
        bundle.putString("authorization", eVar.a());
        m mVar = new m();
        mVar.H2(bundle);
        return mVar;
    }

    @Override // androidx.fragment.app.Fragment
    public View C1(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(x7.r.f13869d, viewGroup, false);
    }

    @Override // k8.a, androidx.fragment.app.Fragment
    public void T1() {
        super.T1();
        Dialog dialogZ2 = Z2();
        if (dialogZ2 != null) {
            dialogZ2.setCanceledOnTouchOutside(false);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void X1(View view, Bundle bundle) throws UnsupportedEncodingException {
        String strB;
        super.X1(view, bundle);
        e eVar = this.C0;
        if (eVar == null || eVar.h() == null) {
            X2();
            return;
        }
        x8.g.f(view);
        String strD = this.C0.d();
        if (this.C0.h().startsWith("data:")) {
            if (this.C0.e() == null || this.C0.e().isEmpty() || this.C0.e().contains("/*") || "application/octet-stream".equals(this.C0.e())) {
                this.C0.p(l5.a.d(this.C0.h()));
            }
            if (strD == null || strD.isEmpty()) {
                strD = l5.a.c(this.C0.e(), null);
                this.C0.n(strD);
            } else if (strD.indexOf(46, Math.max(0, strD.length() - 7)) < 0 && this.C0.e() != null && (strB = l5.c.b(this.C0.e())) != null) {
                strD = strD + "." + strB;
                this.C0.n(strD);
            }
            t3();
        }
        if (strD == null) {
            strD = l5.b.b(this.C0.h(), this.C0.b(), this.C0.e());
            this.C0.n(strD);
            if (strD.endsWith(".apk")) {
                this.C0.p("application/vnd.android.package-archive");
            }
            t3();
        }
        TextView textView = (TextView) view.findViewById(x7.p.f13833p1);
        this.E0 = textView;
        textView.setTextDirection(5);
        EditText editText = (EditText) view.findViewById(x7.p.f13813j);
        this.D0 = editText;
        editText.setText(strD);
        this.D0.setSelectAllOnFocus(true);
        this.D0.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: mark.via.download.g
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view2, boolean z10) {
                m.m3(this.f9909a, view2, z10);
            }
        });
        view.findViewById(x7.p.f13797d1).setOnClickListener(new View.OnClickListener() { // from class: mark.via.download.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f9914a.X2();
            }
        });
        TextView textView2 = (TextView) view.findViewById(x7.p.f13800e1);
        this.F0 = textView2;
        textView2.setOnClickListener(new View.OnClickListener() { // from class: mark.via.download.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                m.j3(this.f9915a, view2);
            }
        });
        u3();
        view.findViewById(x7.p.f13812i1).setOnClickListener(new View.OnClickListener() { // from class: mark.via.download.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                m.l3(this.f9920a, view2);
            }
        });
        if (URLUtil.isNetworkUrl(this.C0.h())) {
            if (this.C0.c() <= 0) {
                r3();
            }
        } else {
            if (!URLUtil.isDataUrl(this.C0.h()) || this.C0.c() > 0) {
                return;
            }
            q3();
        }
    }

    public final void q3() throws UnsupportedEncodingException {
        this.C0.m(l5.a.b(this.C0.h()));
        if (this.C0.c() > 1019904) {
            this.F0.setVisibility(8);
        }
        u3();
        t3();
    }

    public final void r3() {
        ((autodispose2.m) x6.f.h(new Callable() { // from class: mark.via.download.k
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return m.n3(this.f9924e);
            }
        }).n(g7.a.c()).k(w6.b.b()).p(u8.b.a(d1()))).a(new a7.e() { // from class: mark.via.download.l
            @Override // a7.e
            public final void accept(Object obj) {
                m.k3(this.f9928e, (e) obj);
            }
        }, new x7.g0());
    }

    public void s3(a aVar) {
        this.G0 = aVar;
    }

    public final void t3() {
        if (this.C0 == null) {
            H2(null);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("url", this.C0.h());
        bundle.putString("fileName", this.C0.d());
        bundle.putString("contentDisposition", this.C0.b());
        bundle.putString("mimeType", this.C0.e());
        bundle.putString("userAgent", this.C0.i());
        bundle.putString("referer", this.C0.g());
        bundle.putString("authorization", this.C0.a());
        bundle.putLong("contentLength", this.C0.c());
        H2(bundle);
    }

    public final void u3() {
        this.E0.setText(a1(x7.u.f14234y5, z8.b0.w(I(), this.C0.c())));
    }

    @Override // k8.a, androidx.fragment.app.k, androidx.fragment.app.Fragment
    public void y1(Bundle bundle) {
        super.y1(bundle);
        Bundle bundleY0 = y0();
        if (bundleY0 == null || bundleY0.isEmpty()) {
            return;
        }
        this.C0 = new e.b().j(bundleY0.getString("url")).e(bundleY0.getString("fileName")).k(bundleY0.getString("userAgent")).c(bundleY0.getString("contentDisposition")).g(bundleY0.getString("mimeType")).i(bundleY0.getString("referer")).a(bundleY0.getString("authorization")).h(bundleY0.getString("path")).d(bundleY0.getLong("contentLength")).f(bundleY0.getBoolean("fileNameOverwrittable")).b();
    }
}
