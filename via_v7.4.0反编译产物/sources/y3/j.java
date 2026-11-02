package y3;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class j {

    /* renamed from: a, reason: collision with root package name */
    public final s3.a f14432a;

    /* renamed from: b, reason: collision with root package name */
    public final r f14433b;

    public j(s3.a aVar) {
        this.f14432a = aVar;
        this.f14433b = new r(aVar);
    }

    public static j a(s3.a aVar) {
        if (aVar.j(1)) {
            return new g(aVar);
        }
        if (!aVar.j(2)) {
            return new k(aVar);
        }
        int iG = r.g(aVar, 1, 4);
        if (iG == 4) {
            return new a(aVar);
        }
        if (iG == 5) {
            return new b(aVar);
        }
        int iG2 = r.g(aVar, 1, 5);
        if (iG2 == 12) {
            return new c(aVar);
        }
        if (iG2 == 13) {
            return new d(aVar);
        }
        switch (r.g(aVar, 1, 7)) {
            case 56:
                return new e(aVar, "310", "11");
            case 57:
                return new e(aVar, "320", "11");
            case 58:
                return new e(aVar, "310", "13");
            case 59:
                return new e(aVar, "320", "13");
            case 60:
                return new e(aVar, "310", "15");
            case 61:
                return new e(aVar, "320", "15");
            case 62:
                return new e(aVar, "310", "17");
            case 63:
                return new e(aVar, "320", "17");
            default:
                throw new IllegalStateException("unknown decoder: " + aVar);
        }
    }

    public final r b() {
        return this.f14433b;
    }

    public final s3.a c() {
        return this.f14432a;
    }

    public abstract String d();
}
