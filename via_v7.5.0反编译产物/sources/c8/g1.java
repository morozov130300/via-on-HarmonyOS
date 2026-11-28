package c8;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.http.SslCertificate;
import android.text.TextUtils;
import c6.a2;
import java.util.HashMap;
import mark.via.browser.FreeSelectController;
import x8.w3;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class g1 extends q4.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u9.l f2205a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f2206b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final FreeSelectController f2207c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final HashMap f2208d = new HashMap();

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public interface a {
        void D(String str);

        void N(int i10);

        void e0(String str, String str2);

        void r(t4.b bVar);

        void s(String str, String str2, SslCertificate sslCertificate);

        void z(int i10);
    }

    public g1(u9.l lVar, a aVar, FreeSelectController freeSelectController) {
        this.f2205a = lVar;
        this.f2206b = aVar;
        this.f2207c = freeSelectController;
    }

    @Override // q4.a
    public void D(t4.b bVar, String str) {
        this.f2207c.x(bVar);
        this.f2208d.put(Integer.valueOf(bVar.getTabId()), Boolean.valueOf(s9.d.l(bVar.getContext(), str)));
    }

    @Override // q4.a
    public void G(t4.b bVar, int i10) {
        boolean z10 = (i10 & 1) == 1;
        if (bVar == null) {
            if (z10) {
                this.f2206b.r(null);
                return;
            }
            return;
        }
        this.f2206b.N(bVar.getTabId());
        if (z10) {
            this.f2206b.r(bVar);
            String url = bVar.getUrl();
            String title = bVar.getTitle();
            SslCertificate certificate = bVar.getCertificate();
            boolean zL = s9.d.l(bVar.getContext(), url);
            this.f2206b.D(url);
            this.f2206b.z(zL ? 100 : bVar.getProgress());
            if (!TextUtils.isEmpty(title)) {
                this.f2206b.s(title, url, certificate);
            } else {
                if (zL || TextUtils.isEmpty(url)) {
                    return;
                }
                this.f2206b.s(url, url, certificate);
            }
        }
    }

    @Override // q4.a
    public void o(t4.b bVar, String str) {
        bVar.setVisibility(0);
        if (str == null || !str.startsWith("http") || !this.f2205a.R0() || this.f2205a.V2()) {
            return;
        }
        bVar.setBackgroundColor(-1);
    }

    @Override // q4.a
    public void p(t4.b bVar, String str, Bitmap bitmap) {
        this.f2207c.x(bVar);
        boolean zL = s9.d.l(bVar.getContext(), str);
        this.f2208d.put(Integer.valueOf(bVar.getTabId()), Boolean.valueOf(zL));
        if (bVar.isShown()) {
            if (!TextUtils.isEmpty(str) && !zL && this.f2205a.e() && this.f2205a.C1() && this.f2205a.n2().t()) {
                bVar.setVisibility(8);
            }
            this.f2206b.D(str);
        }
        if (zL) {
            return;
        }
        this.f2206b.N(bVar.getTabId());
    }

    @Override // q4.a
    public void t(t4.b bVar, int i10) {
        if (bVar.isShown()) {
            if (((Boolean) this.f2208d.get(Integer.valueOf(bVar.getTabId()))) == Boolean.FALSE) {
                this.f2206b.z(i10);
            } else {
                this.f2206b.z(100);
            }
        }
    }

    @Override // q4.a
    public void v(t4.b bVar, final Bitmap bitmap) {
        this.f2206b.N(bVar.getTabId());
        if (bitmap == null) {
            return;
        }
        final Context context = bVar.getContext();
        final String url = bVar.getUrl();
        x8.h.b(new Runnable() { // from class: c8.f1
            @Override // java.lang.Runnable
            public final void run() {
                x8.y0.h(context, url, bitmap);
            }
        });
    }

    @Override // q4.a
    public void y(t4.b bVar, String str) {
        String url = bVar.getUrl();
        if (bVar.isShown()) {
            this.f2206b.s(str, url, bVar.getCertificate());
        }
        this.f2206b.e0(str, url);
        this.f2206b.N(bVar.getTabId());
    }

    @Override // q4.a
    public void z(t4.b bVar, final String str, boolean z10) {
        if (str.contains("favicon.ico")) {
            return;
        }
        a2 a2Var = a2.f1958a;
        final String url = bVar.getUrl();
        if (a2Var.m(url)) {
            return;
        }
        final String strM = w3.m(bVar.getContext());
        x8.h.b(new Runnable() { // from class: c8.e1
            @Override // java.lang.Runnable
            public final void run() throws Throwable {
                w3.b(strM, str, url);
            }
        });
    }
}
