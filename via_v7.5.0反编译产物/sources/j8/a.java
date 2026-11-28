package j8;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f6734a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f6735b;

    public a(String str, int i10) {
        this.f6734a = str;
        this.f6735b = i10;
    }

    public String a() {
        return this.f6734a;
    }

    public int b() {
        return this.f6735b;
    }

    public void c(int i10) {
        this.f6735b = i10;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.f6734a.equals(((a) obj).f6734a);
    }

    public int hashCode() {
        return this.f6734a.hashCode();
    }
}
