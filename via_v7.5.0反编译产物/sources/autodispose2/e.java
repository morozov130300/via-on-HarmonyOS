package autodispose2;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class e extends r6.f implements m {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final r6.i f1648c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final r6.c f1649e;

    public e(r6.i iVar, r6.c cVar) {
        this.f1648c = iVar;
        this.f1649e = cVar;
    }

    @Override // r6.f
    public void m(r6.h hVar) {
        this.f1648c.c(new j(this.f1649e, hVar));
    }
}
