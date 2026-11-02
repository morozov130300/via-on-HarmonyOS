package l8;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public final String f8448a;

    /* renamed from: b, reason: collision with root package name */
    public int f8449b;

    public a(String str, int i10) {
        this.f8448a = str;
        this.f8449b = i10;
    }

    public String a() {
        return this.f8448a;
    }

    public int b() {
        return this.f8449b;
    }

    public void c(int i10) {
        this.f8449b = i10;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.f8448a.equals(((a) obj).f8448a);
    }

    public int hashCode() {
        return this.f8448a.hashCode();
    }
}
