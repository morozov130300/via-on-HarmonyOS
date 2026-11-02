package vb;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import okhttp3.q;
import okhttp3.w;
import okhttp3.y;
import xb.d;
import xb.e;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final w f13193a;

    /* renamed from: b, reason: collision with root package name */
    public final y f13194b;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final long f13195a;

        /* renamed from: b, reason: collision with root package name */
        public final w f13196b;

        /* renamed from: c, reason: collision with root package name */
        public final y f13197c;

        /* renamed from: d, reason: collision with root package name */
        public Date f13198d;

        /* renamed from: e, reason: collision with root package name */
        public String f13199e;

        /* renamed from: f, reason: collision with root package name */
        public Date f13200f;

        /* renamed from: g, reason: collision with root package name */
        public String f13201g;

        /* renamed from: h, reason: collision with root package name */
        public Date f13202h;

        /* renamed from: i, reason: collision with root package name */
        public long f13203i;

        /* renamed from: j, reason: collision with root package name */
        public long f13204j;

        /* renamed from: k, reason: collision with root package name */
        public String f13205k;

        /* renamed from: l, reason: collision with root package name */
        public int f13206l;

        public a(long j10, w wVar, y yVar) {
            this.f13206l = -1;
            this.f13195a = j10;
            this.f13196b = wVar;
            this.f13197c = yVar;
            if (yVar != null) {
                this.f13203i = yVar.p();
                this.f13204j = yVar.n();
                q qVarI = yVar.i();
                int iJ = qVarI.j();
                for (int i10 = 0; i10 < iJ; i10++) {
                    String strE = qVarI.e(i10);
                    String strK = qVarI.k(i10);
                    if ("Date".equalsIgnoreCase(strE)) {
                        this.f13198d = d.b(strK);
                        this.f13199e = strK;
                    } else if ("Expires".equalsIgnoreCase(strE)) {
                        this.f13202h = d.b(strK);
                    } else if ("Last-Modified".equalsIgnoreCase(strE)) {
                        this.f13200f = d.b(strK);
                        this.f13201g = strK;
                    } else if ("ETag".equalsIgnoreCase(strE)) {
                        this.f13205k = strK;
                    } else if ("Age".equalsIgnoreCase(strE)) {
                        this.f13206l = e.d(strK, -1);
                    }
                }
            }
        }

        public static boolean e(w wVar) {
            return (wVar.c("If-Modified-Since") == null && wVar.c("If-None-Match") == null) ? false : true;
        }

        public final long a() {
            Date date = this.f13198d;
            long jMax = date != null ? Math.max(0L, this.f13204j - date.getTime()) : 0L;
            int i10 = this.f13206l;
            if (i10 != -1) {
                jMax = Math.max(jMax, TimeUnit.SECONDS.toMillis(i10));
            }
            long j10 = this.f13204j;
            return jMax + (j10 - this.f13203i) + (this.f13195a - j10);
        }

        public final long b() {
            if (this.f13197c.b().d() != -1) {
                return TimeUnit.SECONDS.toMillis(r0.d());
            }
            if (this.f13202h != null) {
                Date date = this.f13198d;
                long time = this.f13202h.getTime() - (date != null ? date.getTime() : this.f13204j);
                if (time > 0) {
                    return time;
                }
                return 0L;
            }
            if (this.f13200f != null && this.f13197c.o().h().x() == null) {
                Date date2 = this.f13198d;
                long time2 = (date2 != null ? date2.getTime() : this.f13203i) - this.f13200f.getTime();
                if (time2 > 0) {
                    return time2 / 10;
                }
            }
            return 0L;
        }

        public b c() {
            b bVarD = d();
            return (bVarD.f13193a == null || !this.f13196b.b().j()) ? bVarD : new b(null, null);
        }

        public final b d() {
            String str;
            if (this.f13197c == null) {
                return new b(this.f13196b, null);
            }
            if ((!this.f13196b.e() || this.f13197c.f() != null) && b.a(this.f13197c, this.f13196b)) {
                okhttp3.c cVarB = this.f13196b.b();
                if (cVarB.h() || e(this.f13196b)) {
                    return new b(this.f13196b, null);
                }
                okhttp3.c cVarB2 = this.f13197c.b();
                long jA = a();
                long jB = b();
                if (cVarB.d() != -1) {
                    jB = Math.min(jB, TimeUnit.SECONDS.toMillis(cVarB.d()));
                }
                long millis = 0;
                long millis2 = cVarB.f() != -1 ? TimeUnit.SECONDS.toMillis(cVarB.f()) : 0L;
                if (!cVarB2.g() && cVarB.e() != -1) {
                    millis = TimeUnit.SECONDS.toMillis(cVarB.e());
                }
                if (!cVarB2.h()) {
                    long j10 = millis2 + jA;
                    if (j10 < millis + jB) {
                        y.a aVarL = this.f13197c.l();
                        if (j10 >= jB) {
                            aVarL.a("Warning", "110 HttpURLConnection \"Response is stale\"");
                        }
                        if (jA > 86400000 && f()) {
                            aVarL.a("Warning", "113 HttpURLConnection \"Heuristic expiration\"");
                        }
                        return new b(null, aVarL.c());
                    }
                }
                String str2 = this.f13205k;
                if (str2 != null) {
                    str = "If-None-Match";
                } else {
                    if (this.f13200f != null) {
                        str2 = this.f13201g;
                    } else {
                        if (this.f13198d == null) {
                            return new b(this.f13196b, null);
                        }
                        str2 = this.f13199e;
                    }
                    str = "If-Modified-Since";
                }
                q.a aVarG = this.f13196b.d().g();
                ub.a.f12933a.b(aVarG, str, str2);
                return new b(this.f13196b.g().e(aVarG.d()).b(), this.f13197c);
            }
            return new b(this.f13196b, null);
        }

        public final boolean f() {
            return this.f13197c.b().d() == -1 && this.f13202h == null;
        }
    }

    public b(w wVar, y yVar) {
        this.f13193a = wVar;
        this.f13194b = yVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0056, code lost:
    
        if (r3.b().b() == false) goto L33;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean a(y yVar, w wVar) {
        int iD = yVar.d();
        if (iD != 200 && iD != 410 && iD != 414 && iD != 501 && iD != 203 && iD != 204) {
            if (iD != 307) {
                if (iD != 308 && iD != 404 && iD != 405) {
                    switch (iD) {
                        case 300:
                        case 301:
                            break;
                        case 302:
                            break;
                        default:
                            return false;
                    }
                }
            }
            if (yVar.g("Expires") == null) {
                if (yVar.b().d() == -1) {
                    if (!yVar.b().c()) {
                    }
                }
            }
        }
        return (yVar.b().i() || wVar.b().i()) ? false : true;
    }
}
