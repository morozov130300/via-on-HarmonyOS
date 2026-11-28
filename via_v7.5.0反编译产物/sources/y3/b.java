package y3;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final x3.b f14830a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final x3.b f14831b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final x3.c f14832c;

    public b(x3.b bVar, x3.b bVar2, x3.c cVar) {
        this.f14830a = bVar;
        this.f14831b = bVar2;
        this.f14832c = cVar;
    }

    public x3.c a() {
        return this.f14832c;
    }

    public x3.b b() {
        return this.f14830a;
    }

    public x3.b c() {
        return this.f14831b;
    }

    public boolean d() {
        return this.f14831b == null;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return Objects.equals(this.f14830a, bVar.f14830a) && Objects.equals(this.f14831b, bVar.f14831b) && Objects.equals(this.f14832c, bVar.f14832c);
    }

    public int hashCode() {
        return (Objects.hashCode(this.f14830a) ^ Objects.hashCode(this.f14831b)) ^ Objects.hashCode(this.f14832c);
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("[ ");
        sb2.append(this.f14830a);
        sb2.append(" , ");
        sb2.append(this.f14831b);
        sb2.append(" : ");
        x3.c cVar = this.f14832c;
        sb2.append(cVar == null ? "null" : Integer.valueOf(cVar.c()));
        sb2.append(" ]");
        return sb2.toString();
    }
}
