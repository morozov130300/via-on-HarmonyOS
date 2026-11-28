package e6;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f4256a;

    public o(String str) {
        this.f4256a = str;
    }

    public static o b(String str) {
        return new o(str);
    }

    public Object a(q qVar) {
        return qVar.b(this);
    }

    public Object c(q qVar) {
        Object objA = a(qVar);
        if (objA != null) {
            return objA;
        }
        throw new NullPointerException(this.f4256a);
    }

    public void d(q qVar, Object obj) {
        qVar.a(this, obj);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.f4256a.equals(((o) obj).f4256a);
    }

    public int hashCode() {
        return this.f4256a.hashCode();
    }

    public String toString() {
        return "Prop{name='" + this.f4256a + "'}";
    }
}
