package x;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f14455a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f14456b;

    public d(Object obj, Object obj2) {
        this.f14455a = obj;
        this.f14456b = obj2;
    }

    public static d a(Object obj, Object obj2) {
        return new d(obj, obj2);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return c.a(dVar.f14455a, this.f14455a) && c.a(dVar.f14456b, this.f14456b);
    }

    public int hashCode() {
        Object obj = this.f14455a;
        int iHashCode = obj == null ? 0 : obj.hashCode();
        Object obj2 = this.f14456b;
        return iHashCode ^ (obj2 != null ? obj2.hashCode() : 0);
    }

    public String toString() {
        return "Pair{" + this.f14455a + " " + this.f14456b + "}";
    }
}
