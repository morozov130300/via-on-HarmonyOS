package w;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public final Object f13207a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f13208b;

    public d(Object obj, Object obj2) {
        this.f13207a = obj;
        this.f13208b = obj2;
    }

    public static d a(Object obj, Object obj2) {
        return new d(obj, obj2);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return c.a(dVar.f13207a, this.f13207a) && c.a(dVar.f13208b, this.f13208b);
    }

    public int hashCode() {
        Object obj = this.f13207a;
        int iHashCode = obj == null ? 0 : obj.hashCode();
        Object obj2 = this.f13208b;
        return iHashCode ^ (obj2 != null ? obj2.hashCode() : 0);
    }

    public String toString() {
        return "Pair{" + this.f13207a + " " + this.f13208b + "}";
    }
}
