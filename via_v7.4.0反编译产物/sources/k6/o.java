package k6;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class o {

    /* renamed from: a, reason: collision with root package name */
    public final String f8172a;

    public o(String str) {
        this.f8172a = str;
    }

    public static o b(String str) {
        return new o(str);
    }

    public Object a(q qVar) {
        return qVar.a(this);
    }

    public Object c(q qVar) {
        Object objA = a(qVar);
        if (objA != null) {
            return objA;
        }
        throw new NullPointerException(this.f8172a);
    }

    public void d(q qVar, Object obj) {
        qVar.b(this, obj);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.f8172a.equals(((o) obj).f8172a);
    }

    public int hashCode() {
        return this.f8172a.hashCode();
    }

    public String toString() {
        return "Prop{name='" + this.f8172a + "'}";
    }
}
