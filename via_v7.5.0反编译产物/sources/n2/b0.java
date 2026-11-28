package n2;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class f10509a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Class f10510b;

    /* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
    public @interface a {
    }

    public b0(Class cls, Class cls2) {
        this.f10509a = cls;
        this.f10510b = cls2;
    }

    public static b0 a(Class cls, Class cls2) {
        return new b0(cls, cls2);
    }

    public static b0 b(Class cls) {
        return new b0(a.class, cls);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b0.class != obj.getClass()) {
            return false;
        }
        b0 b0Var = (b0) obj;
        if (this.f10510b.equals(b0Var.f10510b)) {
            return this.f10509a.equals(b0Var.f10509a);
        }
        return false;
    }

    public int hashCode() {
        return (this.f10510b.hashCode() * 31) + this.f10509a.hashCode();
    }

    public String toString() {
        if (this.f10509a == a.class) {
            return this.f10510b.getName();
        }
        return "@" + this.f10509a.getName() + " " + this.f10510b.getName();
    }
}
