package autodispose2;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class f extends r6.j implements n {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final r6.n f1650c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final r6.c f1651e;

    public f(r6.n nVar, r6.c cVar) {
        this.f1650c = nVar;
        this.f1651e = cVar;
    }

    @Override // r6.j
    public void F(r6.o oVar) {
        this.f1650c.c(new AutoDisposingObserverImpl(this.f1651e, oVar));
    }
}
