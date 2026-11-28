package autodispose2;

import r6.s;
import r6.t;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class h extends r6.q implements r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t f1655a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final r6.c f1656b;

    public h(t tVar, r6.c cVar) {
        this.f1655a = tVar;
        this.f1656b = cVar;
    }

    @Override // r6.q
    public void j(s sVar) {
        this.f1655a.c(new k(this.f1656b, sVar));
    }
}
