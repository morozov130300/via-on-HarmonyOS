package d1;

import java.util.Set;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class q implements a1.f {

    /* renamed from: a, reason: collision with root package name */
    public final Set f4515a;

    /* renamed from: b, reason: collision with root package name */
    public final p f4516b;

    /* renamed from: c, reason: collision with root package name */
    public final s f4517c;

    public q(Set set, p pVar, s sVar) {
        this.f4515a = set;
        this.f4516b = pVar;
        this.f4517c = sVar;
    }

    @Override // a1.f
    public a1.e a(String str, Class cls, a1.b bVar, a1.d dVar) {
        if (this.f4515a.contains(bVar)) {
            return new r(this.f4516b, str, bVar, dVar, this.f4517c);
        }
        throw new IllegalArgumentException(String.format("%s is not supported byt this factory. Supported encodings are: %s.", bVar, this.f4515a));
    }
}
