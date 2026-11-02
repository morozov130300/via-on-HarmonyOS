package g9;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class b implements a {

    /* renamed from: a, reason: collision with root package name */
    public final int f6305a;

    /* renamed from: b, reason: collision with root package name */
    public final String f6306b;

    public b(int i10, String str) {
        this.f6305a = i10;
        this.f6306b = str;
    }

    public int a() {
        return this.f6305a;
    }

    public String b() {
        return this.f6306b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.f6305a == ((b) obj).a();
    }

    public int hashCode() {
        return this.f6305a;
    }
}
