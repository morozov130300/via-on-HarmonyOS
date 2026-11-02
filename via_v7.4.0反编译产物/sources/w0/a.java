package w0;

import ac.f;
import okhttp3.a0;
import okhttp3.l;
import okhttp3.w;
import okhttp3.y;
import x0.b;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class a implements x0.a {

    /* renamed from: b, reason: collision with root package name */
    public final b f13211b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f13212c;

    public a(b bVar) {
        this.f13211b = bVar;
    }

    @Override // okhttp3.b
    public w a(a0 a0Var, y yVar) {
        w wVarO = yVar.o();
        this.f13212c = yVar.d() == 407;
        return b(wVarO);
    }

    public final w b(w wVar) {
        String str = this.f13212c ? "Proxy-Authorization" : "Authorization";
        String strC = wVar.c(str);
        if (strC == null || !strC.startsWith("Basic")) {
            return wVar.g().d(str, l.a(this.f13211b.b(), this.f13211b.a())).b();
        }
        f.j().p(5, "previous basic authentication failed, returning null", null);
        return null;
    }
}
