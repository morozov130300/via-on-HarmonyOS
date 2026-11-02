package a6;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    public String f102a;

    public d(String str) {
        this.f102a = str;
    }

    public String a() {
        return this.f102a;
    }

    public void b(String str) {
        this.f102a = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            String str = this.f102a;
            String str2 = ((d) obj).f102a;
            if (str != null) {
                return str.equals(str2);
            }
            if (str2 == null) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        String str = this.f102a;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }
}
