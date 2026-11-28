package g4;

/* JADX INFO: compiled from: r8-map-id-875fbd63171e2c5424b2aca0835b618037335a04f461a9f23d4d6d9cb859ddbf */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f5513a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f5514b;

    public b(Object obj, Object obj2) {
        this.f5513a = obj;
        this.f5514b = obj2;
    }

    public static b a(Object obj, Object obj2) {
        return new b(obj, obj2);
    }

    public Object b() {
        return this.f5513a;
    }

    public Object c() {
        return this.f5514b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b.class != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        Object obj2 = this.f5513a;
        if (obj2 == null) {
            if (bVar.f5513a != null) {
                return false;
            }
        } else if (!obj2.equals(bVar.f5513a)) {
            return false;
        }
        Object obj3 = this.f5514b;
        if (obj3 == null) {
            if (bVar.f5514b != null) {
                return false;
            }
        } else if (!obj3.equals(bVar.f5514b)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        Object obj = this.f5513a;
        int iHashCode = ((obj == null ? 0 : obj.hashCode()) + 31) * 31;
        Object obj2 = this.f5514b;
        return iHashCode + (obj2 != null ? obj2.hashCode() : 0);
    }

    public String toString() {
        return "first = " + this.f5513a + " , second = " + this.f5514b;
    }
}
