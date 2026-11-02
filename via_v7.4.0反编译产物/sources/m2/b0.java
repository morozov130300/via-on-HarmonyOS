package m2;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class b0 {

    /* renamed from: a, reason: collision with root package name */
    public final Class f8545a;

    /* renamed from: b, reason: collision with root package name */
    public final Class f8546b;

    /* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
    public @interface a {
    }

    public b0(Class cls, Class cls2) {
        this.f8545a = cls;
        this.f8546b = cls2;
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
        if (this.f8546b.equals(b0Var.f8546b)) {
            return this.f8545a.equals(b0Var.f8545a);
        }
        return false;
    }

    public int hashCode() {
        return (this.f8546b.hashCode() * 31) + this.f8545a.hashCode();
    }

    public String toString() {
        if (this.f8545a == a.class) {
            return this.f8546b.getName();
        }
        return "@" + this.f8545a.getName() + " " + this.f8546b.getName();
    }
}
