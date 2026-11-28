package v5;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f13386a;

    public d(String str) {
        this.f13386a = str;
    }

    public String a() {
        return this.f13386a;
    }

    public void b(String str) {
        this.f13386a = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            String str = this.f13386a;
            String str2 = ((d) obj).f13386a;
            if (str != null) {
                return str.equals(str2);
            }
            if (str2 == null) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        String str = this.f13386a;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }
}
