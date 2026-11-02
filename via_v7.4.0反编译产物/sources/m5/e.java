package m5;

import i5.b;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import k5.o;
import k5.p;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class e implements l {

    /* renamed from: q, reason: collision with root package name */
    public static final String f8644q = "e";

    /* renamed from: e, reason: collision with root package name */
    public final p f8645e;

    /* renamed from: j, reason: collision with root package name */
    public final g5.c f8646j;

    /* renamed from: k, reason: collision with root package name */
    public final f5.c f8647k;

    /* renamed from: l, reason: collision with root package name */
    public final h5.c f8648l;

    /* renamed from: m, reason: collision with root package name */
    public final o f8649m;

    /* renamed from: n, reason: collision with root package name */
    public final e5.g f8650n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f8651o = false;

    /* renamed from: p, reason: collision with root package name */
    public List f8652p = null;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public class a implements b.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ h[] f8653a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f8654b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f8655c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int[] f8656d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String[] f8657e;

        public a(h[] hVarArr, String str, String str2, int[] iArr, String[] strArr) {
            this.f8653a = hVarArr;
            this.f8654b = str;
            this.f8655c = str2;
            this.f8656d = iArr;
            this.f8657e = strArr;
        }

        @Override // i5.b.a
        public void a() {
            this.f8653a[0] = h.f(25);
        }

        @Override // i5.b.a
        public void b(String str, boolean z10) {
            e.this.f8646j.S(str);
        }

        @Override // i5.b.a
        public void c(HttpURLConnection httpURLConnection, int i10, String str) {
            if (e.this.o()) {
                this.f8653a[0] = h.f(1);
                int[] iArr = this.f8656d;
                iArr[0] = -1;
                iArr[1] = -1;
                return;
            }
            int[] iArr2 = this.f8656d;
            int i11 = iArr2[0] - 1;
            iArr2[0] = i11;
            if (i11 < 0) {
                int i12 = iArr2[1] - 1;
                iArr2[1] = i12;
                if (i12 >= 0) {
                    iArr2[0] = this.f8657e.length - 1;
                }
            }
            if (i10 != 200 && i10 != 206) {
                this.f8653a[0] = h.i(i10, str);
            } else if (e.this.q(httpURLConnection, this.f8654b, this.f8655c)) {
                this.f8656d[0] = -1;
            }
        }

        @Override // i5.b.a
        public void d(HttpURLConnection httpURLConnection) {
            this.f8653a[0] = null;
            e.this.f(httpURLConnection, this.f8654b, this.f8655c);
        }

        @Override // i5.b.a
        public void e(IOException iOException) {
            if (e.this.o() || (iOException instanceof InterruptedIOException)) {
                this.f8653a[0] = h.h(1, iOException);
                int[] iArr = this.f8656d;
                iArr[0] = -1;
                iArr[1] = -1;
                return;
            }
            if (!(iOException instanceof UnknownHostException)) {
                this.f8653a[0] = h.h(20, iOException);
                return;
            }
            this.f8653a[0] = h.h(21, iOException);
            int[] iArr2 = this.f8656d;
            iArr2[0] = -1;
            iArr2[1] = -1;
        }
    }

    public e(e5.g gVar, g5.c cVar, f5.c cVar2, o oVar, p pVar, h5.c cVar3) {
        this.f8650n = gVar;
        this.f8646j = cVar;
        this.f8648l = cVar3;
        this.f8647k = cVar2;
        this.f8649m = oVar;
        this.f8645e = pVar;
    }

    private void p(int i10) {
        if (this.f8646j.q() == i10) {
            return;
        }
        int iQ = this.f8646j.q();
        this.f8646j.P(i10);
        this.f8648l.b(this.f8646j, iQ, i10);
    }

    @Override // m5.l
    public void a() {
        this.f8651o = true;
        List list = this.f8652p;
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ((m5.a) it.next()).a();
            }
        } else {
            if (g5.b.a(this.f8646j.q())) {
                return;
            }
            p(80);
        }
    }

    public final void f(HttpURLConnection httpURLConnection, String str, String str2) {
        Map mapI = this.f8646j.i();
        if (mapI != null && mapI.size() > 0) {
            for (Map.Entry entry : mapI.entrySet()) {
                if (!"Referer".equalsIgnoreCase((String) entry.getKey()) && !"User-Agent".equalsIgnoreCase((String) entry.getKey())) {
                    httpURLConnection.addRequestProperty((String) entry.getKey(), (String) entry.getValue());
                }
            }
        }
        if (str != null) {
            httpURLConnection.setRequestProperty("Referer", str);
        }
        if (str2 != null) {
            httpURLConnection.setRequestProperty("User-Agent", str2);
        }
    }

    @Override // java.util.concurrent.Callable
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public j call() throws Throwable {
        h hVarI;
        if (g5.b.e(this.f8646j.q())) {
            return j.d();
        }
        if (this.f8646j.u()) {
            hVarI = null;
        } else {
            p(91);
            hVarI = j();
        }
        if (hVarI == null) {
            p(92);
            hVarI = i();
            if (hVarI != null) {
                d5.a.a(f8644q, "retry with 1 thread");
                if ((hVarI.a() == 24 || hVarI.a() == 416) && !(this.f8646j.v() && this.f8646j.a() == 1)) {
                    this.f8646j.N(false);
                    this.f8646j.x(1);
                } else if (hVarI.a() >= 400 && hVarI.a() < 500 && this.f8646j.a() != 1) {
                    this.f8646j.x(1);
                }
                this.f8647k.m(this.f8646j.j());
                hVarI = i();
            }
        }
        if (hVarI == null) {
            p(100);
            return j.d();
        }
        if (hVarI.a() == 1) {
            p(80);
        } else if (hVarI.a() == 32) {
            p(95);
        } else {
            this.f8646j.A(hVarI.c());
            this.f8646j.B(hVarI.d());
            p(200);
        }
        return j.c(hVarI);
    }

    public final h h(g5.c cVar, List list) throws InterruptedException {
        g gVar;
        List listL = l(cVar, list);
        ArrayList arrayList = new ArrayList();
        this.f8652p = new ArrayList();
        int size = listL.size() * 2;
        int size2 = listL.size();
        h hVarF = null;
        while (true) {
            if (listL.size() <= 0 || size <= 0) {
                break;
            }
            if (o()) {
                return h.f(1);
            }
            arrayList.clear();
            if (size2 < listL.size()) {
                arrayList.addAll(listL.subList(size2, listL.size()));
            }
            int iMin = Math.min(size2, listL.size());
            char c10 = 0;
            d5.a.b(f8644q, "start downloading, max retry times: %d, max connection: %d, running: %d", Integer.valueOf(size), Integer.valueOf(size2), Integer.valueOf(iMin));
            this.f8652p.clear();
            ArrayList<Future> arrayList2 = new ArrayList();
            for (int i10 = 0; i10 < iMin; i10++) {
                this.f8652p.add(listL.get(i10));
                arrayList2.add(this.f8650n.b().submit((Callable) listL.get(i10)));
            }
            if (arrayList2.size() <= 0) {
                hVarF = h.f(30);
                break;
            }
            listL.clear();
            h hVarB = null;
            boolean z10 = false;
            for (Future future : arrayList2) {
                if (z10) {
                    future.cancel(true);
                } else {
                    try {
                        gVar = (g) future.get();
                    } catch (Exception unused) {
                        gVar = null;
                    }
                    if (gVar != null && gVar.c()) {
                        size--;
                        size2 = Math.max(1, size2 - 1);
                        hVarB = gVar.b();
                        String str = f8644q;
                        Object[] objArr = new Object[1];
                        objArr[c10] = hVarB;
                        d5.a.b(str, "chunk download error: %s", objArr);
                        if (gVar.b() == null || !gVar.b().e()) {
                            z10 = true;
                        } else {
                            d5.a.b(str, "retry chunk: %d-%d", Long.valueOf(gVar.a().h()), Long.valueOf(gVar.a().d()));
                            listL.add(new d(cVar, gVar.a(), this.f8649m, this.f8645e, this.f8648l));
                        }
                    }
                    c10 = 0;
                }
            }
            d5.a.b(f8644q, "canceling: %s", Boolean.valueOf(z10));
            if (z10) {
                hVarF = hVarB;
                break;
            }
            listL.addAll(arrayList);
            if (!listL.isEmpty()) {
                if (size > 0) {
                    try {
                        TimeUnit.MILLISECONDS.sleep(300L);
                    } catch (InterruptedException unused2) {
                        return h.f(1);
                    }
                } else if (hVarB == null) {
                    hVarF = h.f(30);
                }
            }
            hVarF = hVarB;
        }
        this.f8652p = null;
        return hVarF;
    }

    public final h i() {
        if (o()) {
            return h.f(1);
        }
        List listN = n(this.f8646j);
        if (listN == null) {
            return h.f(12);
        }
        h hVarR = r();
        return hVarR != null ? hVarR : h(this.f8646j, listN);
    }

    public final h j() throws Throwable {
        if (!this.f8645e.a()) {
            return h.f(32);
        }
        String strT = this.f8646j.t();
        h[] hVarArr = new h[1];
        String strO = this.f8646j.o();
        String[] strArr = (strO == null || strO.isEmpty()) ? new String[]{this.f8646j.t(), null} : strO.equals(this.f8646j.t()) ? new String[]{null, strO} : new String[]{null, this.f8646j.t(), strO};
        String str = this.f8646j.i() == null ? null : (String) this.f8646j.i().get("User-Agent");
        String[] strArr2 = str == null ? new String[]{null} : new String[]{null, str};
        int[] iArr = {strArr.length - 1, strArr2.length - 1};
        do {
            String str2 = strArr[iArr[0]];
            String str3 = strArr2[iArr[1]];
            this.f8646j.S(strT);
            try {
                i5.b bVar = new i5.b(this.f8646j.t());
                bVar.a(false);
                bVar.b(new a(hVarArr, str2, str3, iArr, strArr));
                bVar.run();
                if (iArr[0] < 0) {
                    break;
                }
            } catch (MalformedURLException e10) {
                hVarArr[0] = h.h(21, e10);
            } catch (GeneralSecurityException e11) {
                hVarArr[0] = h.h(22, e11);
            }
        } while (iArr[1] >= 0);
        return hVarArr[0];
    }

    public final g5.a k(long j10, long j11, long j12) {
        g5.a aVar = new g5.a();
        aVar.n(j10);
        aVar.l(j11);
        aVar.k(j12);
        return aVar;
    }

    public final List l(g5.c cVar, List list) {
        int size = list.size();
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < size; i10++) {
            arrayList.add(new d(cVar, (g5.a) list.get(i10), this.f8649m, this.f8645e, this.f8648l));
        }
        return arrayList;
    }

    public final List m(g5.c cVar) {
        int i10 = 0;
        d5.a.b(f8644q, "generate chunks for task: %s", cVar.toString());
        ArrayList arrayList = new ArrayList();
        if (cVar.r() <= 0 || !cVar.v()) {
            arrayList.add(k(cVar.j(), 0L, 0L));
            return arrayList;
        }
        long jR = cVar.r() / cVar.a();
        while (i10 < cVar.a()) {
            long j10 = i10 * jR;
            arrayList.add(k(cVar.j(), j10, i10 == cVar.a() - 1 ? cVar.r() - j10 : jR));
            i10++;
        }
        return arrayList;
    }

    public final List n(g5.c cVar) {
        List listI = this.f8647k.i(cVar.j());
        if (listI != null && !listI.isEmpty()) {
            return listI;
        }
        List listM = m(cVar);
        return this.f8647k.k(listM) ? this.f8647k.i(cVar.j()) : listM;
    }

    public final boolean o() {
        return this.f8651o || Thread.currentThread().isInterrupted();
    }

    public final boolean q(HttpURLConnection httpURLConnection, String str, String str2) {
        String contentType = httpURLConnection.getContentType();
        int iIndexOf = contentType == null ? -1 : contentType.indexOf(59);
        if (iIndexOf > 0) {
            contentType = contentType.substring(0, iIndexOf).trim().toLowerCase(Locale.ROOT);
        }
        String strB = l5.c.b(contentType);
        if (contentType == null || contentType.equals("application/octet-stream")) {
            String strB2 = l5.b.b(httpURLConnection.getURL().toString(), httpURLConnection.getHeaderField("Content-Disposition"), null);
            int iLastIndexOf = strB2.lastIndexOf(46);
            if (iLastIndexOf >= 0) {
                strB = strB2.substring(iLastIndexOf + 1);
                contentType = l5.c.c(strB, contentType);
            }
        }
        boolean zD = l5.b.d(contentType, strB);
        if (zD != "text/html".equals(this.f8646j.k())) {
            return false;
        }
        if (this.f8646j.T() && contentType != null && !contentType.equalsIgnoreCase(this.f8646j.k())) {
            String strL = this.f8646j.l();
            if (strB != null && !strB.isEmpty() && !"bin".equals(strB)) {
                int iLastIndexOf2 = strL.lastIndexOf(46);
                if (iLastIndexOf2 >= 0) {
                    strL = strL.substring(0, iLastIndexOf2 + 1) + strB;
                } else {
                    strL = strL + '.' + strB;
                }
            }
            this.f8646j.J(strL);
            this.f8646j.I(contentType);
        }
        if (httpURLConnection.getHeaderField("Transfer-Encoding") == null) {
            try {
                this.f8646j.Q(Long.parseLong(httpURLConnection.getHeaderField("Content-Length")));
            } catch (NumberFormatException unused) {
                this.f8646j.Q(-1L);
            }
        } else {
            this.f8646j.Q(-1L);
        }
        if (this.f8646j.r() == -1) {
            this.f8646j.Q(l5.b.f(httpURLConnection.getHeaderField("Content-Range")));
        }
        this.f8646j.N("bytes".equalsIgnoreCase(httpURLConnection.getHeaderField("Accept-Ranges")) || httpURLConnection.getHeaderField("Content-Range") != null);
        if (zD) {
            this.f8646j.Q(-1L);
            this.f8646j.N(false);
        }
        String headerField = httpURLConnection.getHeaderField("ETag");
        if (headerField != null && !headerField.isEmpty()) {
            this.f8646j.w("ETag", headerField);
        }
        this.f8646j.w("Referer", str);
        this.f8646j.w("User-Agent", str2);
        this.f8646j.F(true);
        if (this.f8646j.r() <= 0 || !this.f8646j.v()) {
            this.f8646j.x(1);
            this.f8646j.N(false);
        } else {
            this.f8646j.x(Math.min(Math.max(1, this.f8646j.a()), Math.max(1, (int) Math.ceil(this.f8646j.r() / 1048576.0f))));
        }
        return true;
    }

    public final h r() {
        long jR = this.f8646j.v() ? this.f8646j.r() : 0L;
        try {
            k5.c cVarA = this.f8649m.a(this.f8646j.g());
            try {
                try {
                } catch (IOException e10) {
                    d5.a.a(f8644q, e10.toString());
                }
                if (cVarA.getLength() == jR) {
                    try {
                        cVarA.close();
                    } catch (IOException unused) {
                    }
                    return null;
                }
                if (cVarA.getLength() <= 0) {
                    d5.a.a(f8644q, "reset chunks downloaded");
                    this.f8647k.e(this.f8646j.j());
                }
                cVarA.a(jR);
                cVarA.b();
                try {
                    cVarA.close();
                } catch (IOException unused2) {
                }
                return null;
            } catch (Throwable th) {
                try {
                    cVarA.close();
                } catch (IOException unused3) {
                }
                throw th;
            }
        } catch (IOException | IllegalArgumentException e11) {
            return h.h(12, e11);
        }
    }
}
