package v0;

import java.util.Map;
import okhttp3.a0;
import okhttp3.w;
import okhttp3.y;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class b implements okhttp3.b {

    /* renamed from: b, reason: collision with root package name */
    public final okhttp3.b f12957b;

    /* renamed from: c, reason: collision with root package name */
    public final Map f12958c;

    /* renamed from: d, reason: collision with root package name */
    public final a f12959d;

    public b(okhttp3.b bVar, Map map) {
        this(bVar, map, new c());
    }

    public b(okhttp3.b bVar, Map map, a aVar) {
        this.f12957b = bVar;
        this.f12958c = map;
        this.f12959d = aVar;
    }

    @Override // okhttp3.b
    public w a(a0 a0Var, y yVar) {
        w wVarA = this.f12957b.a(a0Var, yVar);
        if (wVarA != null && wVarA.c("Authorization") != null && (this.f12957b instanceof x0.a)) {
            this.f12958c.put(this.f12959d.a(wVarA), (x0.a) this.f12957b);
        }
        return wVarA;
    }
}
