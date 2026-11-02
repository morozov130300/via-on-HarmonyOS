package t5;

import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class g implements com.google.zxing.l {

    /* renamed from: a, reason: collision with root package name */
    public com.google.zxing.i f12184a;

    /* renamed from: b, reason: collision with root package name */
    public List f12185b = new ArrayList();

    public g(com.google.zxing.i iVar) {
        this.f12184a = iVar;
    }

    @Override // com.google.zxing.l
    public void a(com.google.zxing.k kVar) {
        this.f12185b.add(kVar);
    }

    public com.google.zxing.j b(com.google.zxing.b bVar) {
        this.f12185b.clear();
        try {
            com.google.zxing.i iVar = this.f12184a;
            if (iVar instanceof com.google.zxing.e) {
                com.google.zxing.j jVarD = ((com.google.zxing.e) iVar).d(bVar);
                this.f12184a.reset();
                return jVarD;
            }
            com.google.zxing.j jVarB = iVar.b(bVar);
            this.f12184a.reset();
            return jVarB;
        } catch (Exception unused) {
            this.f12184a.reset();
            return null;
        } catch (Throwable th) {
            this.f12184a.reset();
            throw th;
        }
    }

    public com.google.zxing.j c(com.google.zxing.d dVar) {
        return b(e(dVar));
    }

    public List d() {
        return new ArrayList(this.f12185b);
    }

    public com.google.zxing.b e(com.google.zxing.d dVar) {
        return new com.google.zxing.b(new s3.j(dVar));
    }
}
