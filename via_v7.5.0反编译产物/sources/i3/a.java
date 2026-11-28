package i3;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class a extends r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f6228a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f6229b;

    public a(String str, List list) {
        if (str == null) {
            throw new NullPointerException("Null userAgent");
        }
        this.f6228a = str;
        if (list == null) {
            throw new NullPointerException("Null usedDates");
        }
        this.f6229b = list;
    }

    @Override // i3.r
    public List b() {
        return this.f6229b;
    }

    @Override // i3.r
    public String c() {
        return this.f6228a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof r) {
            r rVar = (r) obj;
            if (this.f6228a.equals(rVar.c()) && this.f6229b.equals(rVar.b())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((this.f6228a.hashCode() ^ 1000003) * 1000003) ^ this.f6229b.hashCode();
    }

    public String toString() {
        return "HeartBeatResult{userAgent=" + this.f6228a + ", usedDates=" + this.f6229b + "}";
    }
}
