package xb;

import java.util.List;
import okhttp3.s;
import okhttp3.t;
import okhttp3.w;
import okhttp3.x;
import okhttp3.y;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class a implements s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final okhttp3.k f14665a;

    public a(okhttp3.k kVar) {
        this.f14665a = kVar;
    }

    @Override // okhttp3.s
    public y a(s.a aVar) {
        w wVarE = aVar.e();
        w.a aVarG = wVarE.g();
        x xVarA = wVarE.a();
        if (xVarA != null) {
            t tVarB = xVarA.b();
            if (tVarB != null) {
                aVarG.d("Content-Type", tVarB.toString());
            }
            long jA = xVarA.a();
            if (jA != -1) {
                aVarG.d("Content-Length", Long.toString(jA));
                aVarG.i("Transfer-Encoding");
            } else {
                aVarG.d("Transfer-Encoding", "chunked");
                aVarG.i("Content-Length");
            }
        }
        boolean z10 = false;
        if (wVarE.c("Host") == null) {
            aVarG.d("Host", ub.c.s(wVarE.h(), false));
        }
        if (wVarE.c("Connection") == null) {
            aVarG.d("Connection", "Keep-Alive");
        }
        if (wVarE.c("Accept-Encoding") == null && wVarE.c("Range") == null) {
            aVarG.d("Accept-Encoding", "gzip");
            z10 = true;
        }
        List listB = this.f14665a.b(wVarE.h());
        if (!listB.isEmpty()) {
            aVarG.d("Cookie", b(listB));
        }
        if (wVarE.c("User-Agent") == null) {
            aVarG.d("User-Agent", ub.d.a());
        }
        y yVarC = aVar.c(aVarG.b());
        e.e(this.f14665a, wVarE.h(), yVarC.h());
        y.a aVarP = yVarC.l().p(wVarE);
        if (z10 && "gzip".equalsIgnoreCase(yVarC.f("Content-Encoding")) && e.c(yVarC)) {
            okio.i iVar = new okio.i(yVarC.a().h());
            aVarP.j(yVarC.h().g().e("Content-Encoding").e("Content-Length").d());
            aVarP.b(new h(yVarC.f("Content-Type"), -1L, okio.k.b(iVar)));
        }
        return aVarP.c();
    }

    public final String b(List list) {
        StringBuilder sb2 = new StringBuilder();
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (i10 > 0) {
                sb2.append("; ");
            }
            okhttp3.j jVar = (okhttp3.j) list.get(i10);
            sb2.append(jVar.c());
            sb2.append('=');
            sb2.append(jVar.k());
        }
        return sb2.toString();
    }
}
