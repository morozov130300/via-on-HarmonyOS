package x3;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f14482a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f14483b;

    public b(int i10, int i11) {
        this.f14482a = i10;
        this.f14483b = i11;
    }

    public final int a() {
        return this.f14483b;
    }

    public final int b() {
        return this.f14482a;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f14482a == bVar.f14482a && this.f14483b == bVar.f14483b;
    }

    public final int hashCode() {
        return this.f14482a ^ this.f14483b;
    }

    public final String toString() {
        return this.f14482a + "(" + this.f14483b + ')';
    }
}
