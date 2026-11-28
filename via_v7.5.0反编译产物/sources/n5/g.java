package n5;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class g implements com.google.zxing.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.google.zxing.i f10613a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List f10614b = new ArrayList();

    public g(com.google.zxing.i iVar) {
        this.f10613a = iVar;
    }

    @Override // com.google.zxing.l
    public void a(com.google.zxing.k kVar) {
        this.f10614b.add(kVar);
    }

    public com.google.zxing.j b(com.google.zxing.b bVar) {
        this.f10614b.clear();
        try {
            com.google.zxing.i iVar = this.f10613a;
            return iVar instanceof com.google.zxing.e ? ((com.google.zxing.e) iVar).d(bVar) : iVar.b(bVar);
        } catch (Exception unused) {
            return null;
        } finally {
            this.f10613a.reset();
        }
    }

    public com.google.zxing.j c(com.google.zxing.d dVar) {
        return b(e(dVar));
    }

    public List d() {
        return new ArrayList(this.f10614b);
    }

    public com.google.zxing.b e(com.google.zxing.d dVar) {
        return new com.google.zxing.b(new t3.j(dVar));
    }
}
