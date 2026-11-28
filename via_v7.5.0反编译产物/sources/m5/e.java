package m5;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import k5.o;
import k5.p;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class e implements m {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final String f7896v = "e";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final p f7897c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final g5.c f7898e;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final f5.c f7899m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final h5.c f7900n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final o f7901o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final e5.g f7902p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final boolean f7903q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public List f7904r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public volatile boolean f7905s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public volatile i5.b f7906t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public List f7907u;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public class a implements i5.b.InterfaceC0075b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f7908a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f7909b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ h[] f7910c;

        public a(String str, String str2, h[] hVarArr) {
            this.f7908a = str;
            this.f7909b = str2;
            this.f7910c = hVarArr;
        }

        @Override // i5.b.InterfaceC0075b
        public void a() {
            this.f7910c[0] = h.f(25);
        }

        @Override // i5.b.InterfaceC0075b
        public void b(String str, boolean z10) {
            if (e.this.f7898e.W()) {
                return;
            }
            e.this.f7898e.T(str);
        }

        @Override // i5.b.InterfaceC0075b
        public void c(HttpURLConnection httpURLConnection, int i10, String str) {
            if (e.this.o()) {
                this.f7910c[0] = h.f(1);
            } else if (i10 == 200 || i10 == 206) {
                this.f7910c[0] = e.this.q(httpURLConnection, this.f7908a, this.f7909b) ? null : h.f(20);
            } else {
                this.f7910c[0] = h.i(i10, str);
            }
        }

        @Override // i5.b.InterfaceC0075b
        public void d(HttpURLConnection httpURLConnection) {
            e.this.f(httpURLConnection, this.f7908a, this.f7909b);
        }

        @Override // i5.b.InterfaceC0075b
        public void e(IOException iOException) {
            if (e.this.o()) {
                this.f7910c[0] = h.h(1, iOException);
                return;
            }
            if (iOException instanceof SocketTimeoutException) {
                this.f7910c[0] = h.h(23, iOException);
                return;
            }
            if (iOException instanceof InterruptedIOException) {
                this.f7910c[0] = h.h(1, iOException);
            } else if (iOException instanceof UnknownHostException) {
                this.f7910c[0] = h.h(21, iOException);
            } else {
                this.f7910c[0] = h.h(20, iOException);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static final class b implements Callable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final m5.a f7912c;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final CountDownLatch f7913e = new CountDownLatch(1);

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public Future f7914m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public boolean f7915n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public boolean f7916o;

        public b(m5.a aVar) {
            this.f7912c = aVar;
        }

        public void b() {
            boolean z10 = false;
            while (true) {
                try {
                    this.f7913e.await();
                    break;
                } catch (InterruptedException unused) {
                    z10 = true;
                }
            }
            if (z10) {
                Thread.currentThread().interrupt();
            }
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public g call() {
            synchronized (this) {
                try {
                    if (this.f7916o) {
                        return null;
                    }
                    this.f7915n = true;
                    try {
                        return (g) this.f7912c.call();
                    } finally {
                        this.f7913e.countDown();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public void d() {
            synchronized (this) {
                try {
                    this.f7916o = true;
                    if (!this.f7915n) {
                        this.f7913e.countDown();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            Future future = this.f7914m;
            if (future != null) {
                future.cancel(true);
            }
        }
    }

    public e(e5.g gVar, g5.c cVar, f5.c cVar2, o oVar, p pVar, h5.c cVar3) {
        this(gVar, cVar, cVar2, oVar, pVar, cVar3, false);
    }

    private void p(int i10) {
        if (this.f7898e.q() == i10) {
            return;
        }
        int iQ = this.f7898e.q();
        this.f7898e.Q(i10);
        this.f7900n.b(this.f7898e, iQ, i10);
    }

    @Override // m5.m
    public synchronized void a() {
        try {
            this.f7905s = true;
            i5.b bVar = this.f7906t;
            if (bVar != null) {
                bVar.a();
            }
            List list = this.f7907u;
            if (list != null) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    ((m5.a) it.next()).a();
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void f(HttpURLConnection httpURLConnection, String str, String str2) {
        Map mapI = this.f7898e.i();
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
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public j call() {
        h hVarI;
        if (g5.b.e(this.f7898e.q())) {
            return j.d();
        }
        if (this.f7898e.u()) {
            hVarI = null;
        } else {
            p(91);
            hVarI = j();
        }
        if (hVarI == null) {
            p(92);
            hVarI = i();
            if (hVarI != null) {
                d5.a.a(f7896v, "retry with 1 thread");
                if ((hVarI.a() == 24 || hVarI.a() == 416) && !(this.f7898e.v() && this.f7898e.a() == 1)) {
                    this.f7898e.O(false);
                    this.f7898e.x(1);
                } else if (hVarI.a() >= 400 && hVarI.a() < 500 && this.f7898e.a() != 1) {
                    this.f7898e.x(1);
                }
                if (this.f7903q) {
                    this.f7904r = null;
                } else {
                    this.f7899m.m(this.f7898e.j());
                }
                try {
                    TimeUnit.SECONDS.sleep(1L);
                    hVarI = i();
                } catch (InterruptedException e10) {
                    Thread.currentThread().interrupt();
                    hVarI = h.h(1, e10);
                }
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
            this.f7898e.A(hVarI.c());
            this.f7898e.B(hVarI.d());
            p(200);
        }
        return j.c(hVarI);
    }

    /* JADX WARN: Code duplicated, block: B:174:0x02f3 A[LOOP:17: B:172:0x02ed->B:174:0x02f3, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:178:0x0307 A[LOOP:18: B:176:0x0301->B:178:0x0307, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:193:0x0312 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public final h h(g5.c cVar, List list) {
        Iterator it;
        Iterator it2;
        Exception exc;
        g gVar;
        List listL = l(cVar, list);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        try {
            int size = listL.size() * 2;
            int size2 = listL.size();
            h hVarF = null;
            while (listL.size() > 0 && size > 0) {
                int i10 = 1;
                if (o()) {
                    h hVarF2 = h.f(1);
                    Iterator it3 = arrayList2.iterator();
                    while (it3.hasNext()) {
                        ((b) it3.next()).d();
                    }
                    Iterator it4 = arrayList2.iterator();
                    while (it4.hasNext()) {
                        ((b) it4.next()).b();
                    }
                    synchronized (this) {
                        this.f7907u = null;
                    }
                    return hVarF2;
                }
                arrayList.clear();
                if (size2 < listL.size()) {
                    arrayList.addAll(listL.subList(size2, listL.size()));
                }
                int iMin = Math.min(size2, listL.size());
                char c10 = 0;
                d5.a.b(f7896v, "start downloading, max retry times: %d, max connection: %d, running: %d", Integer.valueOf(size), Integer.valueOf(size2), Integer.valueOf(iMin));
                synchronized (this) {
                    if (o()) {
                        h hVarF3 = h.f(1);
                        Iterator it5 = arrayList2.iterator();
                        while (it5.hasNext()) {
                            ((b) it5.next()).d();
                        }
                        Iterator it6 = arrayList2.iterator();
                        while (it6.hasNext()) {
                            ((b) it6.next()).b();
                        }
                        synchronized (this) {
                            this.f7907u = null;
                        }
                        return hVarF3;
                    }
                    this.f7907u = new ArrayList(listL.subList(0, iMin));
                    arrayList2.clear();
                    Iterator it7 = this.f7907u.iterator();
                    while (it7.hasNext()) {
                        b bVar = new b((m5.a) it7.next());
                        arrayList2.add(bVar);
                        bVar.f7914m = this.f7902p.b().submit(bVar);
                    }
                    listL.clear();
                    Iterator it8 = arrayList2.iterator();
                    h hVarB = null;
                    int iMax = size2;
                    int i11 = size;
                    while (it8.hasNext()) {
                        try {
                            gVar = (g) ((b) it8.next()).f7914m.get();
                            exc = null;
                        } catch (Exception e10) {
                            exc = e10;
                            gVar = null;
                        }
                        if (gVar == null) {
                            if (!(exc instanceof InterruptedException)) {
                                h hVarH = h.h(30, exc);
                                Iterator it9 = arrayList2.iterator();
                                while (it9.hasNext()) {
                                    ((b) it9.next()).d();
                                }
                                Iterator it10 = arrayList2.iterator();
                                while (it10.hasNext()) {
                                    ((b) it10.next()).b();
                                }
                                synchronized (this) {
                                    this.f7907u = null;
                                }
                                return hVarH;
                            }
                            Thread.currentThread().interrupt();
                            h hVarH2 = h.h(i10, exc);
                            Iterator it11 = arrayList2.iterator();
                            while (it11.hasNext()) {
                                ((b) it11.next()).d();
                            }
                            Iterator it12 = arrayList2.iterator();
                            while (it12.hasNext()) {
                                ((b) it12.next()).b();
                            }
                            synchronized (this) {
                                this.f7907u = null;
                            }
                            return hVarH2;
                        }
                        if (gVar.c()) {
                            i11--;
                            iMax = Math.max(i10, iMax - 1);
                            hVarB = gVar.b();
                            String str = f7896v;
                            Object[] objArr = new Object[i10];
                            objArr[c10] = hVarB;
                            d5.a.b(str, "chunk download error: %s", objArr);
                            if (gVar.b() == null || !gVar.b().e()) {
                                Iterator it13 = arrayList2.iterator();
                                while (it13.hasNext()) {
                                    ((b) it13.next()).d();
                                }
                                Iterator it14 = arrayList2.iterator();
                                while (it14.hasNext()) {
                                    ((b) it14.next()).b();
                                }
                                synchronized (this) {
                                    this.f7907u = null;
                                }
                                return hVarB;
                            }
                            d5.a.b(str, "retry chunk: %d-%d", Long.valueOf(gVar.a().h()), Long.valueOf(gVar.a().d()));
                            listL.add(new d(this.f7902p.b(), cVar, gVar.a(), this.f7901o, this.f7897c, this.f7900n));
                        }
                        c10 = 0;
                        i10 = 1;
                    }
                    listL.addAll(arrayList);
                    if (listL.isEmpty()) {
                        hVarF = hVarB;
                    } else {
                        if (i11 > 0) {
                            try {
                                TimeUnit.MILLISECONDS.sleep(300L);
                            } catch (InterruptedException unused) {
                                h hVarF4 = h.f(1);
                                Iterator it15 = arrayList2.iterator();
                                while (it15.hasNext()) {
                                    ((b) it15.next()).d();
                                }
                                Iterator it16 = arrayList2.iterator();
                                while (it16.hasNext()) {
                                    ((b) it16.next()).b();
                                }
                                synchronized (this) {
                                    this.f7907u = null;
                                    return hVarF4;
                                }
                            }
                        } else if (hVarB == null) {
                            hVarF = h.f(30);
                        }
                        hVarF = hVarB;
                    }
                    size = i11;
                    size2 = iMax;
                    it = arrayList2.iterator();
                    while (it.hasNext()) {
                        ((b) it.next()).d();
                    }
                    it2 = arrayList2.iterator();
                    while (it2.hasNext()) {
                        ((b) it2.next()).b();
                    }
                    synchronized (this) {
                        this.f7907u = null;
                        throw th;
                    }
                }
            }
            Iterator it17 = arrayList2.iterator();
            while (it17.hasNext()) {
                ((b) it17.next()).d();
            }
            Iterator it18 = arrayList2.iterator();
            while (it18.hasNext()) {
                ((b) it18.next()).b();
            }
            synchronized (this) {
                this.f7907u = null;
            }
            return hVarF;
        } catch (Throwable th) {
            it = arrayList2.iterator();
            while (it.hasNext()) {
                ((b) it.next()).d();
            }
            it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                ((b) it2.next()).b();
            }
            synchronized (this) {
                this.f7907u = null;
                throw th;
            }
        }
    }

    public final h i() {
        if (o()) {
            return h.f(1);
        }
        List<g5.a> listN = n(this.f7898e);
        if (listN == null) {
            return h.f(12);
        }
        h hVarR = r();
        if (hVarR != null) {
            return hVarR;
        }
        h hVarH = h(this.f7898e, listN);
        if (hVarH == null && this.f7903q) {
            long jB = 0;
            for (g5.a aVar : listN) {
                if (aVar.b() <= 0 || (aVar.e() > 0 && aVar.b() != aVar.e())) {
                    return h.f(31);
                }
                jB += aVar.b();
            }
            if (this.f7898e.r() > 0 && jB != this.f7898e.r()) {
                return h.f(31);
            }
        }
        return hVarH;
    }

    public final h j() {
        if (!this.f7897c.a()) {
            return h.f(32);
        }
        String strT = this.f7898e.t();
        h[] hVarArr = new h[1];
        String strO = this.f7898e.o();
        String[] strArr = (strO == null || strO.isEmpty()) ? new String[]{this.f7898e.t(), null} : strO.equals(this.f7898e.t()) ? new String[]{null, strO} : new String[]{null, this.f7898e.t(), strO};
        String str = this.f7898e.i() == null ? null : (String) this.f7898e.i().get("User-Agent");
        String[] strArr2 = str == null ? new String[]{null} : new String[]{null, str};
        for (int length = strArr2.length - 1; length >= 0; length--) {
            for (int length2 = strArr.length - 1; length2 >= 0; length2--) {
                if (o()) {
                    return h.f(1);
                }
                String str2 = strArr[length2];
                String str3 = strArr2[length];
                this.f7898e.T(strT);
                try {
                    i5.b bVar = new i5.b(this.f7898e.t(), this.f7902p.b());
                    bVar.c(new a(str2, str3, hVarArr));
                    this.f7906t = bVar;
                    try {
                        if (o()) {
                            bVar.a();
                        }
                        bVar.run();
                        this.f7906t = null;
                        if (o()) {
                            return h.f(1);
                        }
                        if (this.f7898e.u()) {
                            return null;
                        }
                        if (hVarArr[0].a() == 1 || hVarArr[0].a() == 21) {
                            return hVarArr[0];
                        }
                    } catch (Throwable th) {
                        this.f7906t = null;
                        throw th;
                    }
                } catch (MalformedURLException e10) {
                    return h.h(21, e10);
                } catch (GeneralSecurityException e11) {
                    return h.h(22, e11);
                }
            }
        }
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
            arrayList.add(new d(this.f7902p.b(), cVar, (g5.a) list.get(i10), this.f7901o, this.f7897c, this.f7900n));
        }
        return arrayList;
    }

    public final List m(g5.c cVar) {
        int i10 = 0;
        d5.a.b(f7896v, "generate chunks for task: %s", cVar.toString());
        ArrayList arrayList = new ArrayList();
        if (cVar.r() <= 0 || !cVar.v()) {
            arrayList.add(k(cVar.j(), 0L, 0L));
            return arrayList;
        }
        long jR = cVar.r() / ((long) cVar.a());
        while (i10 < cVar.a()) {
            long j10 = ((long) i10) * jR;
            arrayList.add(k(cVar.j(), j10, i10 == cVar.a() - 1 ? cVar.r() - j10 : jR));
            i10++;
        }
        return arrayList;
    }

    public final List n(g5.c cVar) {
        if (this.f7903q) {
            if (this.f7904r == null) {
                this.f7904r = m(cVar);
            }
            return this.f7904r;
        }
        List listH = this.f7899m.h(cVar.j());
        if (listH != null && !listH.isEmpty()) {
            return listH;
        }
        List listM = m(cVar);
        return this.f7899m.k(listM) ? this.f7899m.h(cVar.j()) : listM;
    }

    public final boolean o() {
        return this.f7905s || Thread.currentThread().isInterrupted();
    }

    public final boolean q(HttpURLConnection httpURLConnection, String str, String str2) {
        String contentType = httpURLConnection.getContentType();
        int iIndexOf = contentType == null ? -1 : contentType.indexOf(59);
        if (contentType != null) {
            if (iIndexOf >= 0) {
                contentType = contentType.substring(0, iIndexOf);
            }
            contentType = contentType.trim().toLowerCase(Locale.ROOT);
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
        if (!this.f7898e.X() && zD != "text/html".equals(this.f7898e.k())) {
            return false;
        }
        if (this.f7898e.V() && contentType != null && !contentType.equalsIgnoreCase(this.f7898e.k())) {
            String strL = this.f7898e.l();
            if (strB != null && !strB.isEmpty() && !"bin".equals(strB)) {
                int iLastIndexOf2 = strL.lastIndexOf(46);
                if (iLastIndexOf2 >= 0) {
                    strL = strL.substring(0, iLastIndexOf2 + 1) + strB;
                } else {
                    strL = strL + '.' + strB;
                }
            }
            this.f7898e.K(strL);
            this.f7898e.J(contentType);
        } else if (this.f7898e.X()) {
            this.f7898e.J(contentType != null ? contentType : "application/octet-stream");
        }
        if (httpURLConnection.getHeaderField("Transfer-Encoding") == null) {
            try {
                this.f7898e.R(Long.parseLong(httpURLConnection.getHeaderField("Content-Length")));
            } catch (NumberFormatException unused) {
                this.f7898e.R(-1L);
            }
        } else {
            this.f7898e.R(-1L);
        }
        if (this.f7898e.r() == -1) {
            this.f7898e.R(l5.b.f(httpURLConnection.getHeaderField("Content-Range")));
        }
        this.f7898e.O("bytes".equalsIgnoreCase(httpURLConnection.getHeaderField("Accept-Ranges")) || httpURLConnection.getHeaderField("Content-Range") != null);
        if (zD) {
            this.f7898e.R(-1L);
            this.f7898e.O(false);
        }
        String headerField = httpURLConnection.getHeaderField("ETag");
        if (headerField != null && !headerField.isEmpty()) {
            this.f7898e.w("ETag", headerField);
        }
        this.f7898e.w("Referer", str);
        this.f7898e.w("User-Agent", str2);
        this.f7898e.F(true);
        if (this.f7898e.r() <= 0 || !this.f7898e.v()) {
            this.f7898e.x(1);
            this.f7898e.O(false);
        } else {
            this.f7898e.x(Math.min(Math.max(1, this.f7898e.a()), Math.max(1, (int) Math.ceil(this.f7898e.r() / 1048576.0f))));
        }
        return true;
    }

    public final h r() {
        long length;
        long jR = this.f7898e.v() ? this.f7898e.r() : 0L;
        try {
            k5.c cVarA = this.f7901o.a(this.f7898e.g());
            try {
                try {
                    length = cVarA.getLength();
                    if (length == jR) {
                        return null;
                    }
                    if (length <= 0) {
                        try {
                            d5.a.a(f7896v, "reset chunks downloaded");
                            if (this.f7903q) {
                                Iterator it = this.f7904r.iterator();
                                while (it.hasNext()) {
                                    ((g5.a) it.next()).i(0L);
                                }
                            } else {
                                this.f7899m.i(this.f7898e.j());
                            }
                        } catch (IOException e10) {
                            e = e10;
                            d5.a.a(f7896v, e.toString());
                            if (length >= 0) {
                                if (length > jR) {
                                }
                            }
                            return h.h(12, e);
                        }
                    }
                    cVarA.a(jR);
                    cVarA.b();
                    return null;
                } finally {
                    try {
                        cVarA.close();
                    } catch (IOException unused) {
                    }
                }
            } catch (IOException e11) {
                e = e11;
                length = -1;
            }
        } catch (IOException | IllegalArgumentException e12) {
            return h.h(12, e12);
        }
    }

    public e(e5.g gVar, g5.c cVar, f5.c cVar2, o oVar, p pVar, h5.c cVar3, boolean z10) {
        this.f7905s = false;
        this.f7907u = null;
        this.f7902p = gVar;
        this.f7898e = cVar;
        this.f7900n = cVar3;
        this.f7899m = cVar2;
        this.f7901o = oVar;
        this.f7897c = pVar;
        this.f7903q = z10;
    }
}
