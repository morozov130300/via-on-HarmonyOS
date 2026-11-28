package n5;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class n extends g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f10638c;

    public n(com.google.zxing.i iVar) {
        super(iVar);
        this.f10638c = true;
    }

    @Override // n5.g
    public com.google.zxing.b e(com.google.zxing.d dVar) {
        if (this.f10638c) {
            this.f10638c = false;
            return new com.google.zxing.b(new t3.j(dVar.e()));
        }
        this.f10638c = true;
        return new com.google.zxing.b(new t3.j(dVar));
    }
}
