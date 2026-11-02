package l1;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class b extends k {

    /* renamed from: a, reason: collision with root package name */
    public final long f8324a;

    /* renamed from: b, reason: collision with root package name */
    public final d1.p f8325b;

    /* renamed from: c, reason: collision with root package name */
    public final d1.i f8326c;

    public b(long j10, d1.p pVar, d1.i iVar) {
        this.f8324a = j10;
        if (pVar == null) {
            throw new NullPointerException("Null transportContext");
        }
        this.f8325b = pVar;
        if (iVar == null) {
            throw new NullPointerException("Null event");
        }
        this.f8326c = iVar;
    }

    @Override // l1.k
    public d1.i b() {
        return this.f8326c;
    }

    @Override // l1.k
    public long c() {
        return this.f8324a;
    }

    @Override // l1.k
    public d1.p d() {
        return this.f8325b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof k) {
            k kVar = (k) obj;
            if (this.f8324a == kVar.c() && this.f8325b.equals(kVar.d()) && this.f8326c.equals(kVar.b())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        long j10 = this.f8324a;
        return this.f8326c.hashCode() ^ ((((((int) (j10 ^ (j10 >>> 32))) ^ 1000003) * 1000003) ^ this.f8325b.hashCode()) * 1000003);
    }

    public String toString() {
        return "PersistedEvent{id=" + this.f8324a + ", transportContext=" + this.f8325b + ", event=" + this.f8326c + "}";
    }
}
