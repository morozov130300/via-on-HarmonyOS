package j3;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class g implements i {

    /* renamed from: a, reason: collision with root package name */
    public final g2.g f7551a;

    public g(g2.g gVar) {
        this.f7551a = gVar;
    }

    @Override // j3.i
    public boolean a(Exception exc) {
        return false;
    }

    @Override // j3.i
    public boolean b(com.google.firebase.installations.local.b bVar) {
        if (!bVar.l() && !bVar.k() && !bVar.i()) {
            return false;
        }
        this.f7551a.e(bVar.d());
        return true;
    }
}
