package y3;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public final class n extends p {

    /* renamed from: b, reason: collision with root package name */
    public final String f14437b;

    /* renamed from: c, reason: collision with root package name */
    public final int f14438c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f14439d;

    public n(int i10, String str) {
        super(i10);
        this.f14437b = str;
        this.f14439d = false;
        this.f14438c = 0;
    }

    public n(int i10, String str, int i11) {
        super(i10);
        this.f14439d = true;
        this.f14438c = i11;
        this.f14437b = str;
    }

    public String b() {
        return this.f14437b;
    }

    public int c() {
        return this.f14438c;
    }

    public boolean d() {
        return this.f14439d;
    }
}
