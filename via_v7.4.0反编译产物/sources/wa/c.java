package wa;

/* compiled from: r8-map-id-751751c23d83be85ef57d175c5469894c696c5ed63f45cf86a3b6e4238664d4a */
/* loaded from: classes.dex */
public class c {

    /* renamed from: b, reason: collision with root package name */
    public static c f13387b;

    /* renamed from: a, reason: collision with root package name */
    public long f13388a;

    public static c a() {
        if (f13387b == null) {
            f13387b = new c();
        }
        return f13387b;
    }

    public boolean b() {
        return System.currentTimeMillis() < this.f13388a;
    }

    public void c() {
        this.f13388a = System.currentTimeMillis() + 180000;
    }
}
