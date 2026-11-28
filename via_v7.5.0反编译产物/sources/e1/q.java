package e1;

import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class q implements b1.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set f4147a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p f4148b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final s f4149c;

    public q(Set set, p pVar, s sVar) {
        this.f4147a = set;
        this.f4148b = pVar;
        this.f4149c = sVar;
    }

    @Override // b1.f
    public b1.e a(String str, Class cls, b1.b bVar, b1.d dVar) {
        if (this.f4147a.contains(bVar)) {
            return new r(this.f4148b, str, bVar, dVar, this.f4149c);
        }
        throw new IllegalArgumentException(String.format("%s is not supported byt this factory. Supported encodings are: %s.", bVar, this.f4147a));
    }
}
