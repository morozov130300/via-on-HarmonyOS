package d1;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class c extends g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f3869a;

    public c(List list) {
        if (list == null) {
            throw new NullPointerException("Null logRequests");
        }
        this.f3869a = list;
    }

    @Override // d1.g
    public List c() {
        return this.f3869a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof g) {
            return this.f3869a.equals(((g) obj).c());
        }
        return false;
    }

    public int hashCode() {
        return this.f3869a.hashCode() ^ 1000003;
    }

    public String toString() {
        return "BatchedLogRequest{logRequests=" + this.f3869a + "}";
    }
}
