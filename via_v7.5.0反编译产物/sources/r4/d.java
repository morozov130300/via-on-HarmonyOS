package r4;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.http.SslCertificate;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.SystemClock;
import android.webkit.URLUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import q4.j;
import q4.k;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class d implements r4.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f11976a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f11977b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final t4.b.e f11978c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final q4.a f11980e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Bundle f11983h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f11984i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f11985j;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List f11979d = new ArrayList();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f11981f = -1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f11982g = false;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f11986k = 0;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a implements t4.c.b {

        /* JADX INFO: renamed from: r4.d$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
        public class C0117a extends j {
            public C0117a(q4.a aVar) {
                super(aVar);
            }

            @Override // q4.j
            public boolean a(t4.b bVar, k kVar) {
                if (d.this.f11980e.n(bVar, kVar)) {
                    return true;
                }
                if (d.this.f11980e.I(bVar, kVar)) {
                    d.this.H(kVar, 0);
                    return true;
                }
                d.this.f11980e.s(bVar, kVar);
                bVar.q();
                d.this.J();
                return false;
            }
        }

        public a() {
        }

        @Override // t4.c.b
        public t4.b a() {
            t4.b bVar = d.this.f11978c == null ? new t4.b(d.this.f11977b) : d.this.f11978c.a(d.this.f11977b);
            bVar.setTabId(d.this.f11976a);
            bVar.setWebViewClient(new C0117a(d.this.f11980e));
            bVar.setWebChromeClient(new q4.c(d.this.f11980e));
            d.this.f11980e.F(bVar);
            return bVar;
        }

        @Override // t4.c.b
        public void b(t4.b bVar, String str) {
            d.this.f11980e.D(bVar, str);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f11989a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public q4.a f11990b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public g f11991c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Context f11992d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public t4.b.e f11993e;

        public b(int i10) {
            this.f11989a = i10;
        }

        public d a() {
            return new d(this.f11989a, this.f11992d, this.f11990b, this.f11991c, this.f11993e);
        }

        public b b(Context context) {
            this.f11992d = context;
            return this;
        }

        public b c(q4.a aVar) {
            this.f11990b = aVar;
            return this;
        }

        public b d(g gVar) {
            this.f11991c = gVar;
            return this;
        }

        public b e(t4.b.e eVar) {
            this.f11993e = eVar;
            return this;
        }
    }

    public d(int i10, Context context, q4.a aVar, g gVar, t4.b.e eVar) {
        this.f11983h = null;
        this.f11984i = null;
        this.f11985j = null;
        this.f11976a = i10;
        this.f11977b = context;
        this.f11978c = eVar;
        this.f11980e = aVar;
        String url = gVar != null ? gVar.getUrl() : null;
        if (url == null || url.isEmpty() || !(gVar instanceof r4.b)) {
            if (url != null) {
                G(url);
            }
        } else {
            this.f11984i = url;
            r4.b bVar = (r4.b) gVar;
            this.f11983h = bVar.a();
            this.f11985j = bVar.b();
        }
    }

    public final void G(String str) {
        H(new k(str, 0, null, false), 0);
    }

    public final void H(k kVar, int i10) {
        String url;
        String strB = kVar.b();
        t4.b bVarO = o();
        if ((i10 & e.f11994a) != 0 || bVarO == null) {
            url = null;
        } else {
            bVarO.o();
            url = bVarO.getUrl();
        }
        J();
        t4.c cVarI = I();
        int size = this.f11979d.size();
        t4.b bVarA = cVarI.a();
        this.f11979d.add(size, cVarI);
        if (bVarO != null) {
            bVarO.stopLoading();
        }
        if (strB != null) {
            String strTrim = strB.trim();
            if (!strTrim.isEmpty()) {
                bVarA.setReferer(url);
                if (!strTrim.equals(kVar.b())) {
                    kVar = new k(strTrim, kVar.a(), kVar.c(), kVar.d());
                }
                this.f11980e.s(bVarA, kVar);
                bVarA.loadUrl(strTrim);
            }
        }
        S(size);
    }

    public t4.c I() {
        return new t4.c(p4.b.b().a(), new a());
    }

    public final void J() {
        int size = this.f11979d.size();
        while (true) {
            size--;
            if (size <= this.f11981f) {
                return;
            }
            ((t4.c) this.f11979d.get(size)).i();
            this.f11979d.remove(size);
        }
    }

    public final t4.c K() {
        int i10 = this.f11981f;
        if (i10 < 0 || i10 >= this.f11979d.size()) {
            return null;
        }
        return (t4.c) this.f11979d.get(this.f11981f);
    }

    public int L() {
        t4.b bVarO = o();
        if (bVarO == null) {
            return 100;
        }
        return bVarO.getProgress();
    }

    public final void M(boolean z10) {
        t4.b bVarO = o();
        if (bVarO == null) {
            return;
        }
        if ((z10 && bVarO.canGoBack()) || (!z10 && bVarO.canGoForward())) {
            if (z10) {
                bVarO.goBack();
                return;
            } else {
                bVarO.goForward();
                return;
            }
        }
        int i10 = this.f11981f + (z10 ? -1 : 1);
        if (i10 < 0 || i10 >= this.f11979d.size()) {
            return;
        }
        S(i10);
    }

    public final void N() {
        if (this.f11983h != null) {
            return;
        }
        if (this.f11982g) {
            P(0, 0);
            return;
        }
        this.f11985j = getTitle();
        this.f11984i = getUrl();
        this.f11983h = b();
        Iterator it = this.f11979d.iterator();
        while (it.hasNext()) {
            ((t4.c) it.next()).i();
        }
        this.f11979d.clear();
        this.f11981f = -1;
    }

    public final void O() {
        P(3, 2);
    }

    public final void P(int i10, int i11) {
        Q(i10, i11, 300000L);
    }

    public final void Q(int i10, int i11, long j10) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        int size = this.f11979d.size();
        for (int i12 = 0; i12 < size; i12++) {
            if (i12 != this.f11981f) {
                t4.c cVar = (t4.c) this.f11979d.get(i12);
                int i13 = this.f11981f;
                if ((i12 < i13 - i10 || i12 > i13 + i11 || (j10 > 0 && jElapsedRealtime - cVar.e() > j10)) && !cVar.h()) {
                    cVar.j();
                }
            }
        }
    }

    public void R(Bundle bundle) {
        Parcelable[] parcelableArray = Build.VERSION.SDK_INT >= 33 ? (Parcelable[]) bundle.getParcelableArray("LIST", Bundle.class) : bundle.getParcelableArray("LIST");
        if (parcelableArray == null || parcelableArray.length == 0) {
            String str = this.f11984i;
            if (str != null) {
                G(str);
                return;
            }
            return;
        }
        this.f11979d.clear();
        int i10 = bundle.getInt("CUR", -1);
        int size = i10;
        for (int i11 = 0; i11 < parcelableArray.length; i11++) {
            if (i11 == i10) {
                size = this.f11979d.size();
            }
            if (parcelableArray[i11] != null) {
                t4.c cVarI = I();
                cVarI.n((Bundle) parcelableArray[i11]);
                this.f11979d.add(cVarI);
            }
        }
        S(Math.max(0, Math.min(size, this.f11979d.size() - 1)));
    }

    public final void S(int i10) {
        int i11 = (i10 < this.f11981f ? 2 : 4) | (this.f11982g ? 1 : 0);
        t4.c cVarK = K();
        if (cVarK != null) {
            cVarK.m(SystemClock.elapsedRealtime());
        }
        t4.b bVarD = cVarK == null ? null : cVarK.d();
        if (bVarD != null) {
            if (bVarD.getProgress() < 100) {
                bVarD.stopLoading();
            }
            this.f11980e.E(bVarD, i11);
            bVarD.onPause();
        }
        t4.b bVarA = ((t4.c) this.f11979d.get(i10)).a();
        this.f11981f = i10;
        bVarA.onResume();
        O();
        this.f11980e.G(bVarA, i11);
    }

    @Override // r4.a
    public void a() {
        t4.b bVarO = o();
        if (bVarO != null) {
            bVarO.onResume();
        }
        if (this.f11982g) {
            this.f11980e.G(bVarO, 9);
        }
    }

    @Override // r4.a
    public Bundle b() {
        Bundle bundle = this.f11983h;
        if (bundle != null) {
            return bundle;
        }
        Bundle bundle2 = new Bundle();
        if (o() == null) {
            return bundle2;
        }
        bundle2.putString("TITLE", getTitle());
        bundle2.putString("URL", getUrl());
        int size = this.f11979d.size();
        int iMax = Math.max(0, this.f11981f - 6);
        int iMin = Math.min(this.f11981f + 4, size);
        int i10 = this.f11981f - iMax;
        Bundle[] bundleArr = new Bundle[iMin - iMax];
        for (int i11 = iMax; i11 < iMin; i11++) {
            bundleArr[i11 - iMax] = ((t4.c) this.f11979d.get(i11)).f();
        }
        bundle2.putParcelableArray("LIST", bundleArr);
        bundle2.putInt("CUR", i10);
        return bundle2;
    }

    @Override // r4.a
    public void c() {
        t4.b bVarO = o();
        if (bVarO != null) {
            bVarO.reload();
        }
    }

    @Override // r4.a
    public boolean d() {
        return this.f11982g;
    }

    @Override // r4.a
    public void e() {
        M(true);
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
        if (this.f11982g) {
            this.f11980e.E(bVarD, 9);
        }
        bVarD.onPause();
        O();
    }

    @Override // r4.a
    public long g() {
        return this.f11982g ? System.currentTimeMillis() : this.f11986k;
    }

    @Override // r4.a
    public int getId() {
        return this.f11976a;
    }

    @Override // r4.a
    public String getTitle() {
        t4.b bVarO = o();
        return bVarO == null ? this.f11985j : bVarO.getTitle();
    }

    @Override // r4.a
    public String getUrl() {
        t4.b bVarO = o();
        return bVarO == null ? this.f11984i : bVarO.getUrl();
    }

    @Override // r4.a
    public void h() {
        Iterator it = this.f11979d.iterator();
        while (it.hasNext()) {
            ((t4.c) it.next()).i();
        }
        this.f11979d.clear();
    }

    @Override // r4.a
    public boolean i() {
        if (this.f11981f > 0) {
            return true;
        }
        t4.b bVarO = o();
        return bVarO != null && bVarO.canGoBack();
    }

    @Override // r4.a
    public void j() {
        this.f11986k = System.currentTimeMillis();
        f();
        this.f11982g = false;
    }

    @Override // r4.a
    public void k() {
        M(false);
    }

    @Override // r4.a
    public void l(int i10) {
        if (i10 < 0 || i10 >= this.f11979d.size()) {
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
    public boolean m() {
        if (this.f11979d.size() > this.f11981f + 1) {
            return true;
        }
        t4.b bVarO = o();
        return bVarO != null && bVarO.canGoForward();
    }

    @Override // r4.a
    public void n() {
        t4.b bVarO = o();
        if (bVarO != null) {
            bVarO.requestFocus();
        }
    }

    @Override // r4.a
    public t4.b o() {
        t4.c cVarK = K();
        if (cVarK == null) {
            return null;
        }
        return cVarK.d();
    }

    @Override // r4.a
    public boolean p() {
        return L() < 100;
    }

    @Override // r4.a
    public boolean q(int i10) {
        if (i10 < 0 || i10 >= this.f11979d.size()) {
            return false;
        }
        int i11 = this.f11981f;
        if (i10 == i11) {
            return true;
        }
        if (i11 > i10) {
            this.f11981f = i11 - 1;
        }
        int i12 = this.f11981f + 1;
        this.f11979d.add(i12, (t4.c) this.f11979d.remove(i10));
        S(i12);
        return true;
    }

    @Override // r4.a
    public void r() {
        t4.b bVarO = o();
        if (bVarO != null) {
            bVarO.stopLoading();
        }
    }

    @Override // r4.a
    public void s() {
        String url = getUrl();
        t4.b bVarO = o();
        if (bVarO != null) {
            this.f11980e.F(bVarO);
            this.f11980e.D(bVarO, url);
        }
    }

    @Override // r4.a
    public Bitmap t() {
        t4.b bVarO = o();
        if (bVarO == null) {
            return null;
        }
        return bVarO.getFavicon();
    }

    @Override // r4.a
    public void u(String str) {
        if (str == null || str.isEmpty()) {
            return;
        }
        t4.b bVarO = o();
        if (URLUtil.isJavaScriptUrl(str)) {
            if (bVarO != null) {
                bVarO.loadUrl(str);
                return;
            }
            return;
        }
        k kVar = new k(str, 0, null, false);
        if (this.f11980e.n(bVarO, kVar)) {
            return;
        }
        String url = getUrl();
        if (bVarO == null) {
            H(kVar, e.f11994a);
            return;
        }
        if (str.equals(url)) {
            this.f11980e.s(bVarO, kVar);
            bVarO.reload();
        } else {
            if (url != null && !url.isEmpty() && this.f11980e.I(bVarO, kVar)) {
                H(kVar, e.f11994a);
                return;
            }
            this.f11980e.s(bVarO, kVar);
            bVarO.loadUrl(str);
            bVarO.o();
            J();
        }
    }

    @Override // r4.a
    public SslCertificate v() {
        t4.b bVarO = o();
        if (bVarO == null) {
            return null;
        }
        return bVarO.getCertificate();
    }

    @Override // r4.a
    public void w() {
        t4.b bVarO = o();
        if (bVarO == null) {
            return;
        }
        bVarO.resumeTimers();
    }

    @Override // r4.a
    public void x() {
        t4.b bVarO = o();
        if (bVarO == null) {
            return;
        }
        bVarO.pauseTimers();
    }

    @Override // r4.a
    public void y() {
        this.f11982g = true;
        a();
        Bundle bundle = this.f11983h;
        if (bundle != null) {
            R(bundle);
            this.f11983h = null;
            this.f11984i = null;
            this.f11985j = null;
        }
    }

    @Override // r4.a
    public List z() {
        ArrayList arrayList = new ArrayList();
        Iterator it = this.f11979d.iterator();
        while (it.hasNext()) {
            arrayList.add(((t4.c) it.next()).g());
        }
        return arrayList;
    }
}
