package f4;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final Object f5897a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f5898b;

    public b(Object obj, Object obj2) {
        this.f5897a = obj;
        this.f5898b = obj2;
    }

    public static b a(Object obj, Object obj2) {
        return new b(obj, obj2);
    }

    public Object b() {
        return this.f5897a;
    }

    public Object c() {
        return this.f5898b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b.class != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        Object obj2 = this.f5897a;
        if (obj2 == null) {
            if (bVar.f5897a != null) {
                return false;
            }
        } else if (!obj2.equals(bVar.f5897a)) {
            return false;
        }
        Object obj3 = this.f5898b;
        if (obj3 == null) {
            if (bVar.f5898b != null) {
                return false;
            }
        } else if (!obj3.equals(bVar.f5898b)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        Object obj = this.f5897a;
        int iHashCode = ((obj == null ? 0 : obj.hashCode()) + 31) * 31;
        Object obj2 = this.f5898b;
        return iHashCode + (obj2 != null ? obj2.hashCode() : 0);
    }

    public String toString() {
        return "first = " + this.f5897a + " , second = " + this.f5898b;
    }
}
