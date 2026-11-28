package vb;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import okhttp3.q;
import okhttp3.w;
import okhttp3.y;
import xb.d;
import xb.e;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final w f13557a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final y f13558b;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f13559a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final w f13560b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final y f13561c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Date f13562d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f13563e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Date f13564f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f13565g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public Date f13566h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public long f13567i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public long f13568j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public String f13569k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f13570l;

        public a(long j10, w wVar, y yVar) {
            this.f13570l = -1;
            this.f13559a = j10;
            this.f13560b = wVar;
            this.f13561c = yVar;
            if (yVar != null) {
                this.f13567i = yVar.p();
                this.f13568j = yVar.n();
                q qVarH = yVar.h();
                int iJ = qVarH.j();
                for (int i10 = 0; i10 < iJ; i10++) {
                    String strE = qVarH.e(i10);
                    String strK = qVarH.k(i10);
                    if ("Date".equalsIgnoreCase(strE)) {
                        this.f13562d = d.b(strK);
                        this.f13563e = strK;
                    } else if ("Expires".equalsIgnoreCase(strE)) {
                        this.f13566h = d.b(strK);
                    } else if ("Last-Modified".equalsIgnoreCase(strE)) {
                        this.f13564f = d.b(strK);
                        this.f13565g = strK;
                    } else if ("ETag".equalsIgnoreCase(strE)) {
                        this.f13569k = strK;
                    } else if ("Age".equalsIgnoreCase(strE)) {
                        this.f13570l = e.d(strK, -1);
                    }
                }
            }
        }

        public static boolean e(w wVar) {
            return (wVar.c("If-Modified-Since") == null && wVar.c("If-None-Match") == null) ? false : true;
        }

        public final long a() {
            Date date = this.f13562d;
            long jMax = date != null ? Math.max(0L, this.f13568j - date.getTime()) : 0L;
            int i10 = this.f13570l;
            if (i10 != -1) {
                jMax = Math.max(jMax, TimeUnit.SECONDS.toMillis(i10));
            }
            long j10 = this.f13568j;
            return jMax + (j10 - this.f13567i) + (this.f13559a - j10);
        }

        public final long b() {
            okhttp3.c cVarB = this.f13561c.b();
            if (cVarB.d() != -1) {
                return TimeUnit.SECONDS.toMillis(cVarB.d());
            }
            if (this.f13566h != null) {
                Date date = this.f13562d;
                long time = this.f13566h.getTime() - (date != null ? date.getTime() : this.f13568j);
                if (time > 0) {
                    return time;
                }
                return 0L;
            }
            if (this.f13564f != null && this.f13561c.o().h().y() == null) {
                Date date2 = this.f13562d;
                long time2 = (date2 != null ? date2.getTime() : this.f13567i) - this.f13564f.getTime();
                if (time2 > 0) {
                    return time2 / 10;
                }
            }
            return 0L;
        }

        public b c() {
            b bVarD = d();
            return (bVarD.f13557a == null || !this.f13560b.b().j()) ? bVarD : new b(null, null);
        }

        public final b d() {
            String str;
            if (this.f13561c == null) {
                return new b(this.f13560b, null);
            }
            if (this.f13560b.e() && this.f13561c.e() == null) {
                return new b(this.f13560b, null);
            }
            if (!b.a(this.f13561c, this.f13560b)) {
                return new b(this.f13560b, null);
            }
            okhttp3.c cVarB = this.f13560b.b();
            if (cVarB.h() || e(this.f13560b)) {
                return new b(this.f13560b, null);
            }
            okhttp3.c cVarB2 = this.f13561c.b();
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
                    y.a aVarL = this.f13561c.l();
                    if (j10 >= jB) {
                        aVarL.a("Warning", "110 HttpURLConnection \"Response is stale\"");
                    }
                    if (jA > 86400000 && f()) {
                        aVarL.a("Warning", "113 HttpURLConnection \"Heuristic expiration\"");
                    }
                    return new b(null, aVarL.c());
                }
            }
            String str2 = this.f13569k;
            if (str2 != null) {
                str = "If-None-Match";
            } else {
                if (this.f13564f != null) {
                    str2 = this.f13565g;
                } else {
                    if (this.f13562d == null) {
                        return new b(this.f13560b, null);
                    }
                    str2 = this.f13563e;
                }
                str = "If-Modified-Since";
            }
            q.a aVarG = this.f13560b.d().g();
            ub.a.f12943a.b(aVarG, str, str2);
            return new b(this.f13560b.g().e(aVarG.d()).b(), this.f13561c);
        }

        public final boolean f() {
            return this.f13561c.b().d() == -1 && this.f13566h == null;
        }
    }

    public b(w wVar, y yVar) {
        this.f13557a = wVar;
        this.f13558b = yVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0056, code lost:
    
        if (r3.b().b() == false) goto L33;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean a(okhttp3.y r3, okhttp3.w r4) {
        /*
            int r0 = r3.c()
            r1 = 200(0xc8, float:2.8E-43)
            r2 = 0
            if (r0 == r1) goto L5a
            r1 = 410(0x19a, float:5.75E-43)
            if (r0 == r1) goto L5a
            r1 = 414(0x19e, float:5.8E-43)
            if (r0 == r1) goto L5a
            r1 = 501(0x1f5, float:7.02E-43)
            if (r0 == r1) goto L5a
            r1 = 203(0xcb, float:2.84E-43)
            if (r0 == r1) goto L5a
            r1 = 204(0xcc, float:2.86E-43)
            if (r0 == r1) goto L5a
            r1 = 307(0x133, float:4.3E-43)
            if (r0 == r1) goto L31
            r1 = 308(0x134, float:4.32E-43)
            if (r0 == r1) goto L5a
            r1 = 404(0x194, float:5.66E-43)
            if (r0 == r1) goto L5a
            r1 = 405(0x195, float:5.68E-43)
            if (r0 == r1) goto L5a
            switch(r0) {
                case 300: goto L5a;
                case 301: goto L5a;
                case 302: goto L31;
                default: goto L30;
            }
        L30:
            goto L59
        L31:
            java.lang.String r0 = "Expires"
            java.lang.String r0 = r3.f(r0)
            if (r0 != 0) goto L5a
            okhttp3.c r0 = r3.b()
            int r0 = r0.d()
            r1 = -1
            if (r0 != r1) goto L5a
            okhttp3.c r0 = r3.b()
            boolean r0 = r0.c()
            if (r0 != 0) goto L5a
            okhttp3.c r0 = r3.b()
            boolean r0 = r0.b()
            if (r0 == 0) goto L59
            goto L5a
        L59:
            return r2
        L5a:
            okhttp3.c r3 = r3.b()
            boolean r3 = r3.i()
            if (r3 != 0) goto L70
            okhttp3.c r3 = r4.b()
            boolean r3 = r3.i()
            if (r3 != 0) goto L70
            r3 = 1
            return r3
        L70:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: vb.b.a(okhttp3.y, okhttp3.w):boolean");
    }
}
