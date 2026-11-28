package y3;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f14833a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f14834b;

    public c(List list, int i10) {
        this.f14833a = new ArrayList(list);
        this.f14834b = i10;
    }

    public List a() {
        return this.f14833a;
    }

    public int b() {
        return this.f14834b;
    }

    public boolean c(List list) {
        return this.f14833a.equals(list);
    }

    public boolean equals(Object obj) {
        if (obj instanceof c) {
            return this.f14833a.equals(((c) obj).f14833a);
        }
        return false;
    }

    public int hashCode() {
        return this.f14833a.hashCode();
    }

    public String toString() {
        return "{ " + this.f14833a + " }";
    }
}
