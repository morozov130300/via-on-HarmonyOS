package t5;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class n extends g {

    /* renamed from: c, reason: collision with root package name */
    public boolean f12209c;

    public n(com.google.zxing.i iVar) {
        super(iVar);
        this.f12209c = true;
    }

    @Override // t5.g
    public com.google.zxing.b e(com.google.zxing.d dVar) {
        if (this.f12209c) {
            this.f12209c = false;
            return new com.google.zxing.b(new s3.j(dVar.e()));
        }
        this.f12209c = true;
        return new com.google.zxing.b(new s3.j(dVar));
    }
}
