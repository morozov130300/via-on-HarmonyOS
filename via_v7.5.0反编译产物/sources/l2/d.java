package l2;

import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set f7464a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final k2.a.b f7465b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final f2.a f7466c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c f7467d;

    public d(f2.a aVar, k2.a.b bVar) {
        this.f7465b = bVar;
        this.f7466c = aVar;
        c cVar = new c(this);
        this.f7467d = cVar;
        aVar.b(cVar);
        this.f7464a = new HashSet();
    }
}
