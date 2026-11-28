package oc;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class a extends t {
    @Override // oc.t
    public void j(t tVar) {
        if (!(tVar instanceof a)) {
            throw new IllegalArgumentException("Parent of block must also be block (can not be inline)");
        }
        super.j(tVar);
    }

    @Override // oc.t
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public a f() {
        return (a) super.f();
    }
}
