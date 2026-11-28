package w0;

import java.util.Map;
import okhttp3.a0;
import okhttp3.w;
import okhttp3.y;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class b implements okhttp3.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final okhttp3.b f13572b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map f13573c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f13574d;

    public b(okhttp3.b bVar, Map map, a aVar) {
        this.f13572b = bVar;
        this.f13573c = map;
        this.f13574d = aVar;
    }

    @Override // okhttp3.b
    public w a(a0 a0Var, y yVar) {
        w wVarA = this.f13572b.a(a0Var, yVar);
        if (wVarA != null && wVarA.c("Authorization") != null && (this.f13572b instanceof y0.a)) {
            this.f13573c.put(this.f13574d.a(wVarA), (y0.a) this.f13572b);
        }
        return wVarA;
    }

    public b(okhttp3.b bVar, Map map) {
        this(bVar, map, new c());
    }
}
