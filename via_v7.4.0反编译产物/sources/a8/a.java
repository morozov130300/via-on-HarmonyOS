package a8;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public final o9.a f140a;

    /* renamed from: b, reason: collision with root package name */
    public final int f141b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f142c;

    public a(a aVar, boolean z10) {
        this(aVar.a(), aVar.b(), z10);
    }

    public a(o9.a aVar, int i10, boolean z10) {
        this.f140a = aVar;
        this.f141b = i10;
        this.f142c = z10;
    }

    public o9.a a() {
        return this.f140a;
    }

    public int b() {
        return this.f141b;
    }

    public boolean c() {
        return this.f142c;
    }

    public void d(boolean z10) {
        this.f142c = z10;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            a aVar = (a) obj;
            if (this.f141b == aVar.f141b && this.f142c == aVar.f142c && z8.u1.a(this.f140a, aVar.f140a)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return z8.u1.b(this.f140a, Integer.valueOf(this.f141b), Boolean.valueOf(this.f142c));
    }

    public String toString() {
        return "BookmarkFolderWrapper{folder=" + this.f140a + ", level=" + this.f141b + ", selected=" + this.f142c + '}';
    }
}
