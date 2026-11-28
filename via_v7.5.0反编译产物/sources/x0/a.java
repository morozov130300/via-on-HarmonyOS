package x0;

import ac.f;
import okhttp3.a0;
import okhttp3.l;
import okhttp3.w;
import okhttp3.y;
import y0.b;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class a implements y0.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f14459b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f14460c;

    public a(b bVar) {
        this.f14459b = bVar;
    }

    @Override // okhttp3.b
    public w a(a0 a0Var, y yVar) {
        w wVarO = yVar.o();
        this.f14460c = yVar.c() == 407;
        return b(wVarO);
    }

    public final w b(w wVar) {
        String str = this.f14460c ? "Proxy-Authorization" : "Authorization";
        String strC = wVar.c(str);
        if (strC == null || !strC.startsWith("Basic")) {
            return wVar.g().d(str, l.a(this.f14459b.b(), this.f14459b.a())).b();
        }
        f.j().p(5, "previous basic authentication failed, returning null", null);
        return null;
    }
}
