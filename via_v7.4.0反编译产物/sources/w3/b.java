package w3;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public final int f13234a;

    /* renamed from: b, reason: collision with root package name */
    public final int f13235b;

    public b(int i10, int i11) {
        this.f13234a = i10;
        this.f13235b = i11;
    }

    public final int a() {
        return this.f13235b;
    }

    public final int b() {
        return this.f13234a;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f13234a == bVar.f13234a && this.f13235b == bVar.f13235b;
    }

    public final int hashCode() {
        return this.f13234a ^ this.f13235b;
    }

    public final String toString() {
        return this.f13234a + "(" + this.f13235b + ')';
    }
}
