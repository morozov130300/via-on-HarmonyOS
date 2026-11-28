package kotlin.text;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f7351a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final s7.c f7352b;

    public g(String value, s7.c range) {
        kotlin.jvm.internal.h.f(value, "value");
        kotlin.jvm.internal.h.f(range, "range");
        this.f7351a = value;
        this.f7352b = range;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return kotlin.jvm.internal.h.a(this.f7351a, gVar.f7351a) && kotlin.jvm.internal.h.a(this.f7352b, gVar.f7352b);
    }

    public int hashCode() {
        return (this.f7351a.hashCode() * 31) + this.f7352b.hashCode();
    }

    public String toString() {
        return "MatchGroup(value=" + this.f7351a + ", range=" + this.f7352b + ')';
    }
}
