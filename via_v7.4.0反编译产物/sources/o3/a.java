package o3;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class a extends f {

    /* renamed from: a, reason: collision with root package name */
    public final String f10347a;

    /* renamed from: b, reason: collision with root package name */
    public final String f10348b;

    public a(String str, String str2) {
        if (str == null) {
            throw new NullPointerException("Null libraryName");
        }
        this.f10347a = str;
        if (str2 == null) {
            throw new NullPointerException("Null version");
        }
        this.f10348b = str2;
    }

    @Override // o3.f
    public String b() {
        return this.f10347a;
    }

    @Override // o3.f
    public String c() {
        return this.f10348b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof f) {
            f fVar = (f) obj;
            if (this.f10347a.equals(fVar.b()) && this.f10348b.equals(fVar.c())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((this.f10347a.hashCode() ^ 1000003) * 1000003) ^ this.f10348b.hashCode();
    }

    public String toString() {
        return "LibraryVersion{libraryName=" + this.f10347a + ", version=" + this.f10348b + "}";
    }
}
