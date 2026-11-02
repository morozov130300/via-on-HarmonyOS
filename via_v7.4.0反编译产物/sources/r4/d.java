package r4;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.http.SslCertificate;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.SystemClock;
import android.webkit.URLUtil;
import android.webkit.WebResourceRequest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p4.j;
import p4.k;
import t4.c;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class d implements r4.a, k {

    /* renamed from: a, reason: collision with root package name */
    public final int f11524a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f11525b;

    /* renamed from: d, reason: collision with root package name */
    public final p4.a f11527d;

    /* renamed from: g, reason: collision with root package name */
    public Bundle f11530g;

    /* renamed from: h, reason: collision with root package name */
    public String f11531h;

    /* renamed from: i, reason: collision with root package name */
    public String f11532i;

    /* renamed from: c, reason: collision with root package name */
    public final List f11526c = new ArrayList();

    /* renamed from: e, reason: collision with root package name */
    public int f11528e = -1;

    /* renamed from: f, reason: collision with root package name */
    public boolean f11529f = false;

    /* renamed from: j, reason: collision with root package name */
    public long f11533j = 0;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a implements c.b {
        public a() {
        }

        @Override // t4.c.b
        public t4.b a() {
            t4.b bVar = new t4.b(d.this.f11525b);
            bVar.setTabId(d.this.f11524a);
            bVar.setWebViewClient(new j(d.this.f11527d, d.this));
            bVar.setWebChromeClient(new p4.c(d.this.f11527d));
            d.this.T(bVar);
            return bVar;
        }

        @Override // t4.c.b
        public void b(t4.b bVar, String str) {
            d.this.U(bVar, str);
        }
    }

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final int f11535a;

        /* renamed from: b, reason: collision with root package name */
        public p4.a f11536b;

        /* renamed from: c, reason: collision with root package name */
        public g f11537c = null;

        /* renamed from: d, reason: collision with root package name */
        public Context f11538d;

        public b(int i10) {
            this.f11535a = i10;
        }

        public d a() {
            return new d(this.f11535a, this.f11538d, this.f11536b, this.f11537c);
        }

        public b b(Context context) {
            this.f11538d = context;
            return this;
        }

        public b c(p4.a aVar) {
            this.f11536b = aVar;
            return this;
        }

        public b d(g gVar) {
            this.f11537c = gVar;
            return this;
        }
    }

    public d(int i10, Context context, p4.a aVar, g gVar) {
        this.f11530g = null;
        this.f11531h = null;
        this.f11532i = null;
        this.f11524a = i10;
        this.f11525b = context;
        this.f11527d = aVar;
        String url = gVar != null ? gVar.getUrl() : null;
        if (url == null || url.isEmpty() || !(gVar instanceof r4.b)) {
            if (url != null) {
                G(url);
            }
        } else {
            this.f11531h = url;
            r4.b bVar = (r4.b) gVar;
            this.f11530g = bVar.a();
            this.f11532i = bVar.b();
        }
    }

    @Override // r4.a
    public List A() {
        ArrayList arrayList = new ArrayList();
        Iterator it = this.f11526c.iterator();
        while (it.hasNext()) {
            arrayList.add(((t4.c) it.next()).g());
        }
        return arrayList;
    }

    public final void G(String str) {
        H(str, 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0046  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void H(String str, int i10) {
        String url;
        t4.b bVarP = p();
        if ((i10 & e.f11539a) != 0 || bVarP == null) {
            url = null;
        } else {
            bVarP.p();
            url = bVarP.getUrl();
        }
        J();
        t4.c cVarI = I();
        int size = this.f11526c.size();
        t4.b bVarA = cVarI.a();
        this.f11526c.add(size, cVarI);
        if (bVarP != null) {
            bVarP.stopLoading();
        }
        if (str != null) {
            String strTrim = str.trim();
            if (strTrim.isEmpty()) {
                U(bVarA, null);
            } else {
                bVarA.setReferer(url);
                U(bVarA, strTrim);
                bVarA.loadUrl(strTrim);
            }
        }
        S(size);
    }

    public t4.c I() {
        return new t4.c(o4.b.b().a(), new a());
    }

    public final void J() {
        int size = this.f11526c.size();
        while (true) {
            size--;
            if (size <= this.f11528e) {
                return;
            }
            ((t4.c) this.f11526c.get(size)).i();
            this.f11526c.remove(size);
        }
    }

    public final t4.c K() {
        int i10 = this.f11528e;
        if (i10 < 0 || i10 >= this.f11526c.size()) {
            return null;
        }
        return (t4.c) this.f11526c.get(this.f11528e);
    }

    public int L() {
        t4.b bVarP = p();
        if (bVarP == null) {
            return 100;
        }
        return bVarP.getProgress();
    }

    public final void M(boolean z10) {
        t4.b bVarP = p();
        if (bVarP == null) {
            return;
        }
        if ((z10 && bVarP.canGoBack()) || (!z10 && bVarP.canGoForward())) {
            if (z10) {
                bVarP.goBack();
                return;
            } else {
                bVarP.goForward();
                return;
            }
        }
        int i10 = this.f11528e + (z10 ? -1 : 1);
        if (i10 < 0 || i10 >= this.f11526c.size()) {
            return;
        }
        S(i10);
    }

    public final void N() {
        if (this.f11530g != null) {
            return;
        }
        if (this.f11529f) {
            P(0, 0);
            return;
        }
        this.f11532i = getTitle();
        this.f11531h = getUrl();
        this.f11530g = b();
        Iterator it = this.f11526c.iterator();
        while (it.hasNext()) {
            ((t4.c) it.next()).i();
        }
        this.f11526c.clear();
        this.f11528e = -1;
    }

    public final void O() {
        P(3, 2);
    }

    public final void P(int i10, int i11) {
        Q(i10, i11, 300000L);
    }

    public final void Q(int i10, int i11, long j10) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        int size = this.f11526c.size();
        for (int i12 = 0; i12 < size; i12++) {
            if (i12 != this.f11528e) {
                t4.c cVar = (t4.c) this.f11526c.get(i12);
                int i13 = this.f11528e;
                if ((i12 < i13 - i10 || i12 > i13 + i11 || (j10 > 0 && jElapsedRealtime - cVar.e() > j10)) && !cVar.h()) {
                    cVar.j();
                }
            }
        }
    }

    public void R(Bundle bundle) {
        Parcelable[] parcelableArray = Build.VERSION.SDK_INT >= 33 ? (Parcelable[]) bundle.getParcelableArray("LIST", Bundle.class) : bundle.getParcelableArray("LIST");
        if (parcelableArray == null || parcelableArray.length == 0) {
            String str = this.f11531h;
            if (str != null) {
                G(str);
                return;
            }
            return;
        }
        this.f11526c.clear();
        int i10 = bundle.getInt("CUR", -1);
        int size = i10;
        for (int i11 = 0; i11 < parcelableArray.length; i11++) {
            if (i11 == i10) {
                size = this.f11526c.size();
            }
            if (parcelableArray[i11] != null) {
                t4.c cVarI = I();
                cVarI.n((Bundle) parcelableArray[i11]);
                this.f11526c.add(cVarI);
            }
        }
        S(Math.max(0, Math.min(size, this.f11526c.size() - 1)));
    }

    public final void S(int i10) {
        boolean z10 = i10 < this.f11528e;
        t4.c cVarK = K();
        if (cVarK != null) {
            cVarK.m(SystemClock.elapsedRealtime());
        }
        t4.b bVarD = cVarK == null ? null : cVarK.d();
        if (bVarD != null) {
            if (bVarD.getProgress() < 100) {
                bVarD.stopLoading();
            }
            bVarD.n();
            bVarD.onPause();
        }
        t4.b bVarA = ((t4.c) this.f11526c.get(i10)).a();
        this.f11528e = i10;
        bVarA.onResume();
        bVarA.r();
        O();
        this.f11527d.D(p(), (z10 ? 2 : 4) | (this.f11529f ? 1 : 0));
    }

    public final void T(t4.b bVar) {
        if (bVar == null) {
            return;
        }
        this.f11527d.C(bVar);
    }

    public final void U(t4.b bVar, String str) {
        if (bVar == null) {
            return;
        }
        this.f11527d.B(bVar, str);
    }

    @Override // r4.a
    public void a() {
        t4.b bVarP = p();
        if (bVarP != null) {
            bVarP.onResume();
        }
        if (this.f11529f) {
            this.f11527d.D(bVarP, 9);
        }
    }

    @Override // r4.a
    public Bundle b() {
        Bundle bundle = this.f11530g;
        if (bundle != null) {
            return bundle;
        }
        Bundle bundle2 = new Bundle();
        if (p() == null) {
            return bundle2;
        }
        bundle2.putString("TITLE", getTitle());
        bundle2.putString("URL", getUrl());
        int size = this.f11526c.size();
        int iMax = Math.max(0, this.f11528e - 6);
        int iMin = Math.min(this.f11528e + 4, size);
        int i10 = this.f11528e - iMax;
        Bundle[] bundleArr = new Bundle[iMin - iMax];
        for (int i11 = iMax; i11 < iMin; i11++) {
            bundleArr[i11 - iMax] = ((t4.c) this.f11526c.get(i11)).f();
        }
        bundle2.putParcelableArray("LIST", bundleArr);
        bundle2.putInt("CUR", i10);
        return bundle2;
    }

    @Override // r4.a
    public void c() {
        t4.b bVarP = p();
        if (bVarP != null) {
            bVarP.reload();
        }
    }

    @Override // r4.a
    public boolean d() {
        return this.f11529f;
    }

    @Override // p4.k
    public boolean e(t4.b bVar, WebResourceRequest webResourceRequest, String str, int i10) {
        if (i10 == 3) {
            return true;
        }
        if (i10 == 1) {
            G(str);
            return true;
        }
        if (i10 != 2) {
            return false;
        }
        if (bVar != null) {
            bVar.s();
        }
        J();
        return false;
    }

    @Override // r4.a
    public void f() {
        t4.c cVarK = K();
        if (cVarK == null) {
            return;
        }
        cVarK.m(SystemClock.elapsedRealtime());
        t4.b bVarD = cVarK.d();
        if (bVarD == null) {
            return;
        }
        bVarD.onPause();
        O();
    }

    @Override // r4.a
    public void g() {
        M(true);
    }

    @Override // r4.a
    public int getId() {
        return this.f11524a;
    }

    @Override // r4.a
    public String getTitle() {
        t4.b bVarP = p();
        return bVarP == null ? this.f11532i : bVarP.getTitle();
    }

    @Override // r4.a
    public String getUrl() {
        t4.b bVarP = p();
        return bVarP == null ? this.f11531h : bVarP.getUrl();
    }

    @Override // r4.a
    public void h() {
        Iterator it = this.f11526c.iterator();
        while (it.hasNext()) {
            ((t4.c) it.next()).i();
        }
        this.f11526c.clear();
    }

    @Override // r4.a
    public long i() {
        return this.f11529f ? System.currentTimeMillis() : this.f11533j;
    }

    @Override // r4.a
    public boolean j() {
        if (this.f11528e > 0) {
            return true;
        }
        t4.b bVarP = p();
        return bVarP != null && bVarP.canGoBack();
    }

    @Override // r4.a
    public void k() {
        this.f11529f = false;
        this.f11533j = System.currentTimeMillis();
        f();
    }

    @Override // r4.a
    public void l() {
        M(false);
    }

    @Override // r4.a
    public void m(int i10) {
        if (i10 < 0 || i10 >= this.f11526c.size()) {
            return;
        }
        if (i10 == 0) {
            N();
            return;
        }
        int i11 = i10 - 1;
        double d10 = i11;
        Double.isNaN(d10);
        int iCeil = (int) Math.ceil(d10 / 2.0d);
        P(iCeil, i11 - iCeil);
    }

    @Override // r4.a
    public boolean n() {
        if (this.f11526c.size() > this.f11528e + 1) {
            return true;
        }
        t4.b bVarP = p();
        return bVarP != null && bVarP.canGoForward();
    }

    @Override // r4.a
    public void o() {
        t4.b bVarP = p();
        if (bVarP != null) {
            bVarP.requestFocus();
        }
    }

    @Override // r4.a
    public t4.b p() {
        t4.c cVarK = K();
        if (cVarK == null) {
            return null;
        }
        return cVarK.d();
    }

    @Override // r4.a
    public boolean q() {
        return L() < 100;
    }

    @Override // r4.a
    public boolean r(int i10) {
        if (i10 < 0 || i10 >= this.f11526c.size()) {
            return false;
        }
        int i11 = this.f11528e;
        if (i10 == i11) {
            return true;
        }
        if (i11 > i10) {
            this.f11528e = i11 - 1;
        }
        int i12 = this.f11528e + 1;
        this.f11526c.add(i12, (t4.c) this.f11526c.remove(i10));
        S(i12);
        return true;
    }

    @Override // r4.a
    public void s() {
        t4.b bVarP = p();
        if (bVarP != null) {
            bVarP.stopLoading();
        }
    }

    @Override // r4.a
    public void t() {
        String url = getUrl();
        t4.b bVarP = p();
        if (bVarP != null) {
            T(bVarP);
            U(bVarP, url);
        }
    }

    @Override // r4.a
    public Bitmap u() {
        t4.b bVarP = p();
        if (bVarP == null) {
            return null;
        }
        return bVarP.getFavicon();
    }

    @Override // r4.a
    public void v(String str) {
        t4.b bVarP = p();
        if (str == null || str.isEmpty()) {
            return;
        }
        String url = getUrl();
        if (str.equals(url)) {
            if (bVarP == null) {
                H(str, e.f11539a);
                return;
            } else {
                U(bVarP, str);
                bVarP.reload();
                return;
            }
        }
        if (URLUtil.isJavaScriptUrl(str)) {
            if (bVarP != null) {
                bVarP.loadUrl(str);
            }
        } else {
            if (bVarP == null || !(url == null || url.isEmpty() || this.f11527d.E(bVarP, str, false, true) == 2)) {
                H(str, e.f11539a);
                return;
            }
            U(bVarP, str);
            bVarP.loadUrl(str);
            bVarP.p();
            J();
        }
    }

    @Override // r4.a
    public SslCertificate w() {
        t4.b bVarP = p();
        if (bVarP == null) {
            return null;
        }
        return bVarP.getCertificate();
    }

    @Override // r4.a
    public void x() {
        t4.b bVarP = p();
        if (bVarP == null) {
            return;
        }
        bVarP.resumeTimers();
    }

    @Override // r4.a
    public void y() {
        t4.b bVarP = p();
        if (bVarP == null) {
            return;
        }
        bVarP.pauseTimers();
    }

    @Override // r4.a
    public void z() {
        this.f11529f = true;
        a();
        Bundle bundle = this.f11530g;
        if (bundle != null) {
            R(bundle);
            this.f11530g = null;
            this.f11531h = null;
            this.f11532i = null;
        }
    }
}
