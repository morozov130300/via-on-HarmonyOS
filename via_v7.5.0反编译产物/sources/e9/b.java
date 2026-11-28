package e9;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class b implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f4320a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f4321b;

    public b(int i10, String str) {
        this.f4320a = i10;
        this.f4321b = str;
    }

    public int a() {
        return this.f4320a;
    }

    public String b() {
        return this.f4321b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.f4320a == ((b) obj).a();
    }

    public int hashCode() {
        return this.f4320a;
    }
}
